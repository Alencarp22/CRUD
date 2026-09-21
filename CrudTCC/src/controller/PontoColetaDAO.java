package controller;

import model.PontoColeta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO responsável pelas quatro operações do CRUD de pontos de coleta.
 * C = cadastrar, R = consultar, U = atualizar, D = excluir.
 */
public class PontoColetaDAO {

    public int cadastrar(PontoColeta ponto) throws SQLException {
        String sql = "INSERT INTO pontos_coleta "
                + "(nome, endereco, bairro, cidade, materiais_aceitos, horario_funcionamento, latitude, longitude) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexao = Conexao.getConexao();
             PreparedStatement ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            preencherParametros(ps, ponto, false);
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    ponto.setId(rs.getInt(1));
                    return ponto.getId();
                }
            }
        }
        return 0;
    }

    public PontoColeta buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM pontos_coleta WHERE id = ?";

        try (Connection conexao = Conexao.getConexao();
             PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapear(rs);
                }
            }
        }
        return null;
    }

    public List<PontoColeta> listarTodos() throws SQLException {
        List<PontoColeta> pontos = new ArrayList<>();
        String sql = "SELECT * FROM pontos_coleta ORDER BY nome, id";

        try (Connection conexao = Conexao.getConexao();
             PreparedStatement ps = conexao.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                pontos.add(mapear(rs));
            }
        }
        return pontos;
    }

    public boolean atualizar(PontoColeta ponto) throws SQLException {
        String sql = "UPDATE pontos_coleta SET "
                + "nome=?, endereco=?, bairro=?, cidade=?, materiais_aceitos=?, "
                + "horario_funcionamento=?, latitude=?, longitude=? WHERE id=?";

        try (Connection conexao = Conexao.getConexao();
             PreparedStatement ps = conexao.prepareStatement(sql)) {

            preencherParametros(ps, ponto, true);
            return ps.executeUpdate() > 0;
        }
    }

    public boolean excluir(int id) throws SQLException {
        String sql = "DELETE FROM pontos_coleta WHERE id = ?";

        try (Connection conexao = Conexao.getConexao();
             PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    private void preencherParametros(PreparedStatement ps, PontoColeta ponto, boolean incluirId)
            throws SQLException {
        ps.setString(1, ponto.getNome());
        ps.setString(2, ponto.getEndereco());
        ps.setString(3, ponto.getBairro());
        ps.setString(4, ponto.getCidade());
        ps.setString(5, ponto.getMateriaisAceitos());
        ps.setString(6, ponto.getHorarioFuncionamento());

        if (ponto.getLatitude() == null) {
            ps.setNull(7, Types.DECIMAL);
        } else {
            ps.setDouble(7, ponto.getLatitude());
        }

        if (ponto.getLongitude() == null) {
            ps.setNull(8, Types.DECIMAL);
        } else {
            ps.setDouble(8, ponto.getLongitude());
        }

        if (incluirId) {
            ps.setInt(9, ponto.getId());
        }
    }

    private PontoColeta mapear(ResultSet rs) throws SQLException {
        PontoColeta ponto = new PontoColeta();
        ponto.setId(rs.getInt("id"));
        ponto.setNome(rs.getString("nome"));
        ponto.setEndereco(rs.getString("endereco"));
        ponto.setBairro(rs.getString("bairro"));
        ponto.setCidade(rs.getString("cidade"));
        ponto.setMateriaisAceitos(rs.getString("materiais_aceitos"));
        ponto.setHorarioFuncionamento(rs.getString("horario_funcionamento"));

        double latitude = rs.getDouble("latitude");
        ponto.setLatitude(rs.wasNull() ? null : latitude);

        double longitude = rs.getDouble("longitude");
        ponto.setLongitude(rs.wasNull() ? null : longitude);
        return ponto;
    }
}
