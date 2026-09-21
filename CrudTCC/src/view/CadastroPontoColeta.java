package view;

import controller.PontoColetaDAO;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.PontoColeta;

/** Formulário visual de cadastro (CREATE). */
public class CadastroPontoColeta extends javax.swing.JFrame {

    private final PontoColetaDAO dao = new PontoColetaDAO();

    public CadastroPontoColeta() {
        initComponents();
        aplicarEstilo();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCabecalho = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
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
        btnCadastrar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("EcoMaps - Cadastrar ponto de coleta");

        pnlCabecalho.setLayout(new java.awt.BorderLayout());

        lblTitulo.setText("Cadastrar ponto de coleta - CREATE");
        pnlCabecalho.add(lblTitulo, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlCabecalho, java.awt.BorderLayout.NORTH);

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

        lblLatitude.setText("Latitude (opcional)");
        pnlFormulario.add(lblLatitude);
        pnlFormulario.add(txtLatitude);

        lblLongitude.setText("Longitude (opcional)");
        pnlFormulario.add(lblLongitude);
        pnlFormulario.add(txtLongitude);

        getContentPane().add(pnlFormulario, java.awt.BorderLayout.CENTER);

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(this::btnCadastrarActionPerformed);
        pnlAcoes.add(btnCadastrar);

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(this::btnLimparActionPerformed);
        pnlAcoes.add(btnLimpar);

        getContentPane().add(pnlAcoes, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        try {
            PontoColeta ponto = lerFormulario();
            int id = dao.cadastrar(ponto);
            JOptionPane.showMessageDialog(this, "Ponto cadastrado com sucesso! ID: " + id);
            limparCampos();
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Dados inválidos", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar: " + e.getMessage(), "Banco de dados", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnLimparActionPerformed

    private PontoColeta lerFormulario() {
        String nome = txtNome.getText().trim();
        String endereco = txtEndereco.getText().trim();
        String bairro = txtBairro.getText().trim();
        String cidade = txtCidade.getText().trim();
        String materiais = txtMateriais.getText().trim();
        if (nome.isEmpty() || endereco.isEmpty() || bairro.isEmpty() || cidade.isEmpty() || materiais.isEmpty()) {
            throw new IllegalArgumentException("Preencha todos os campos marcados com *.");
        }
        return new PontoColeta(0, nome, endereco, bairro, cidade, materiais,
                txtHorario.getText().trim(), lerDoubleOpcional(txtLatitude.getText(), "latitude"),
                lerDoubleOpcional(txtLongitude.getText(), "longitude"));
    }

    private Double lerDoubleOpcional(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) return null;
        try { return Double.valueOf(valor.trim().replace(',', '.')); }
        catch (NumberFormatException e) { throw new IllegalArgumentException("A " + campo + " deve ser um número."); }
    }

    private void limparCampos() {
        txtNome.setText(""); txtEndereco.setText(""); txtBairro.setText(""); txtCidade.setText("");
        txtMateriais.setText(""); txtHorario.setText(""); txtLatitude.setText(""); txtLongitude.setText("");
        txtNome.requestFocus();
    }


    private void aplicarEstilo() {
        pnlCabecalho.setBackground(new java.awt.Color(0, 82, 50));
        pnlCabecalho.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 22, 16, 22));
        lblTitulo.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 22));
        lblTitulo.setForeground(java.awt.Color.WHITE);
        pnlFormulario.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 24, 12, 24));
        pnlAcoes.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 20, 18, 20));
        setMinimumSize(new java.awt.Dimension(680, 540));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblHorario;
    private javax.swing.JLabel lblLatitude;
    private javax.swing.JLabel lblLongitude;
    private javax.swing.JLabel lblMateriais;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlAcoes;
    private javax.swing.JPanel pnlCabecalho;
    private javax.swing.JPanel pnlFormulario;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtHorario;
    private javax.swing.JTextField txtLatitude;
    private javax.swing.JTextField txtLongitude;
    private javax.swing.JTextField txtMateriais;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
