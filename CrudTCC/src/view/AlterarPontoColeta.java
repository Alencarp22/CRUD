package view;

import controller.PontoColetaDAO;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.PontoColeta;

/** Formulário visual de edição (UPDATE). */
public class AlterarPontoColeta extends javax.swing.JFrame {

    private final PontoColetaDAO dao = new PontoColetaDAO();

    public AlterarPontoColeta() {
        initComponents();
        aplicarEstilo();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCabecalho = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        pnlCentro = new javax.swing.JPanel();
        pnlBusca = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        pnlFormulario = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblEndereco = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        lblBairro = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        lblCidade = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        lblMateriais = new javax.swing.JLabel();
        txtMateriais = new javax.swing.JTextField();
        lblHorario = new javax.swing.JLabel();
        txtHorario = new javax.swing.JTextField();
        lblLatitude = new javax.swing.JLabel();
        txtLatitude = new javax.swing.JTextField();
        lblLongitude = new javax.swing.JLabel();
        txtLongitude = new javax.swing.JTextField();
        pnlAcoes = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("EcoMaps - Editar ponto de coleta");

        pnlCabecalho.setLayout(new java.awt.BorderLayout());

        lblTitulo.setText("Editar ponto de coleta");
        pnlCabecalho.add(lblTitulo, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlCabecalho, java.awt.BorderLayout.NORTH);

        pnlCentro.setLayout(new java.awt.BorderLayout());

        pnlBusca.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        lblId.setText("ID do ponto:");
        pnlBusca.add(lblId);

        txtId.setColumns(8);
        pnlBusca.add(txtId);

        btnBuscar.setText("Carregar dados");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);
        pnlBusca.add(btnBuscar);

        pnlCentro.add(pnlBusca, java.awt.BorderLayout.NORTH);

        pnlFormulario.setLayout(new java.awt.GridLayout(8, 2, 10, 10));

        lblNome.setText("Nome *");
        pnlFormulario.add(lblNome);
        pnlFormulario.add(txtNome);

        lblEndereco.setText("Endereço *");
        pnlFormulario.add(lblEndereco);
        pnlFormulario.add(txtEndereco);

        lblBairro.setText("Bairro *");
        pnlFormulario.add(lblBairro);
        pnlFormulario.add(txtBairro);

        lblCidade.setText("Cidade *");
        pnlFormulario.add(lblCidade);
        pnlFormulario.add(txtCidade);

        lblMateriais.setText("Materiais aceitos *");
        pnlFormulario.add(lblMateriais);
        pnlFormulario.add(txtMateriais);

        lblHorario.setText("Horário de funcionamento");
        pnlFormulario.add(lblHorario);
        pnlFormulario.add(txtHorario);

        lblLatitude.setText("Latitude");
        pnlFormulario.add(lblLatitude);
        pnlFormulario.add(txtLatitude);

        lblLongitude.setText("Longitude");
        pnlFormulario.add(lblLongitude);
        pnlFormulario.add(txtLongitude);

        pnlCentro.add(pnlFormulario, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlCentro, java.awt.BorderLayout.CENTER);

        btnSalvar.setText("Salvar alterações");
        btnSalvar.addActionListener(this::btnSalvarActionPerformed);
        pnlAcoes.add(btnSalvar);

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(this::btnLimparActionPerformed);
        pnlAcoes.add(btnLimpar);

        getContentPane().add(pnlAcoes, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            int id = Integer.parseInt(txtId.getText().trim());
            PontoColeta p = dao.buscarPorId(id);
            if (p == null) { JOptionPane.showMessageDialog(this, "Ponto não encontrado."); return; }
            preencherCampos(p);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Digite um ID numérico.", "ID inválido", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao buscar: " + e.getMessage(), "Banco de dados", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            int id = Integer.parseInt(txtId.getText().trim());
            PontoColeta p = lerFormulario(id);
            boolean ok = dao.atualizar(p);
            JOptionPane.showMessageDialog(this, ok ? "Ponto atualizado com sucesso!" : "Nenhum registro foi atualizado.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Digite um ID numérico.", "ID inválido", JOptionPane.WARNING_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Dados inválidos", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar: " + e.getMessage(), "Banco de dados", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void preencherCampos(PontoColeta p) {
        txtNome.setText(p.getNome()); txtEndereco.setText(p.getEndereco()); txtBairro.setText(p.getBairro());
        txtCidade.setText(p.getCidade()); txtMateriais.setText(p.getMateriaisAceitos());
        txtHorario.setText(p.getHorarioFuncionamento() == null ? "" : p.getHorarioFuncionamento());
        txtLatitude.setText(p.getLatitude() == null ? "" : p.getLatitude().toString());
        txtLongitude.setText(p.getLongitude() == null ? "" : p.getLongitude().toString());
    }

    private PontoColeta lerFormulario(int id) {
        String nome = txtNome.getText().trim(), endereco = txtEndereco.getText().trim(), bairro = txtBairro.getText().trim(),
               cidade = txtCidade.getText().trim(), materiais = txtMateriais.getText().trim();
        if (nome.isEmpty() || endereco.isEmpty() || bairro.isEmpty() || cidade.isEmpty() || materiais.isEmpty())
            throw new IllegalArgumentException("Preencha todos os campos marcados com *.");
        return new PontoColeta(id, nome, endereco, bairro, cidade, materiais, txtHorario.getText().trim(),
                lerDoubleOpcional(txtLatitude.getText(), "latitude"), lerDoubleOpcional(txtLongitude.getText(), "longitude"));
    }

    private Double lerDoubleOpcional(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) return null;
        try { return Double.valueOf(valor.trim().replace(',', '.')); }
        catch (NumberFormatException e) { throw new IllegalArgumentException("A " + campo + " deve ser um número."); }
    }

    private void limparCampos() {
        txtId.setText(""); txtNome.setText(""); txtEndereco.setText(""); txtBairro.setText(""); txtCidade.setText("");
        txtMateriais.setText(""); txtHorario.setText(""); txtLatitude.setText(""); txtLongitude.setText("");
    }


    private void aplicarEstilo() {
        pnlCabecalho.setBackground(new java.awt.Color(0, 82, 50));
        pnlCabecalho.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 22, 16, 22));
        lblTitulo.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 22));
        lblTitulo.setForeground(java.awt.Color.WHITE);
        pnlBusca.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 20, 8, 20));
        pnlFormulario.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 24, 8, 24));
        pnlAcoes.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 20, 18, 20));
        setMinimumSize(new java.awt.Dimension(700, 590));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblHorario;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblLatitude;
    private javax.swing.JLabel lblLongitude;
    private javax.swing.JLabel lblMateriais;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlAcoes;
    private javax.swing.JPanel pnlBusca;
    private javax.swing.JPanel pnlCabecalho;
    private javax.swing.JPanel pnlCentro;
    private javax.swing.JPanel pnlFormulario;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtHorario;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtLatitude;
    private javax.swing.JTextField txtLongitude;
    private javax.swing.JTextField txtMateriais;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
