package view;

import controller.PontoColetaDAO;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.PontoColeta;

/** Formulário visual de exclusão (DELETE). */
public class ExcluirPontoColeta extends javax.swing.JFrame {

    private final PontoColetaDAO dao = new PontoColetaDAO();
    private PontoColeta pontoCarregado;

    public ExcluirPontoColeta() {
        initComponents();
        aplicarEstilo();
        setLocationRelativeTo(null);
        btnExcluir.setEnabled(false);
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
        scrResumo = new javax.swing.JScrollPane();
        txtResumo = new javax.swing.JTextArea();
        pnlAcoes = new javax.swing.JPanel();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("EcoMaps - Excluir ponto de coleta");
        getContentPane().setLayout(new java.awt.BorderLayout(0, 8));

        pnlCabecalho.setLayout(new java.awt.BorderLayout());

        lblTitulo.setText("Excluir ponto de coleta");
        pnlCabecalho.add(lblTitulo, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlCabecalho, java.awt.BorderLayout.NORTH);

        pnlCentro.setLayout(new java.awt.BorderLayout());

        pnlBusca.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        lblId.setText("ID do ponto:");
        pnlBusca.add(lblId);

        txtId.setColumns(8);
        pnlBusca.add(txtId);

        btnBuscar.setText("Localizar");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);
        pnlBusca.add(btnBuscar);

        pnlCentro.add(pnlBusca, java.awt.BorderLayout.NORTH);

        txtResumo.setEditable(false);
        txtResumo.setColumns(20);
        txtResumo.setRows(9);
        txtResumo.setText("Informe um ID e clique em Localizar.");
        scrResumo.setViewportView(txtResumo);

        pnlCentro.add(scrResumo, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlCentro, java.awt.BorderLayout.CENTER);

        btnExcluir.setText("Excluir definitivamente");
        btnExcluir.addActionListener(this::btnExcluirActionPerformed);
        pnlAcoes.add(btnExcluir);

        getContentPane().add(pnlAcoes, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            int id = Integer.parseInt(txtId.getText().trim());
            pontoCarregado = dao.buscarPorId(id);
            if (pontoCarregado == null) {
                txtResumo.setText("Ponto não encontrado.");
                btnExcluir.setEnabled(false);
            } else {
                txtResumo.setText("ID: " + pontoCarregado.getId() + "\nNome: " + pontoCarregado.getNome()
                        + "\nEndereço: " + pontoCarregado.getEndereco() + "\nBairro: " + pontoCarregado.getBairro()
                        + "\nCidade: " + pontoCarregado.getCidade() + "\nMateriais: " + pontoCarregado.getMateriaisAceitos()
                        + "\nHorário: " + pontoCarregado.getHorarioFuncionamento());
                btnExcluir.setEnabled(true);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Digite um ID numérico.", "ID inválido", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao buscar: " + e.getMessage(), "Banco de dados", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (pontoCarregado == null) return;
        int confirmacao = JOptionPane.showConfirmDialog(this,
                "Deseja excluir o ponto '" + pontoCarregado.getNome() + "'?\nEsta ação não pode ser desfeita.",
                "Confirmar exclusão", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (confirmacao != JOptionPane.YES_OPTION) return;
        try {
            if (dao.excluir(pontoCarregado.getId())) {
                JOptionPane.showMessageDialog(this, "Ponto excluído com sucesso.");
                txtResumo.setText("Registro excluído.");
                txtId.setText("");
                pontoCarregado = null;
                btnExcluir.setEnabled(false);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao excluir: " + e.getMessage(), "Banco de dados", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed


    private void aplicarEstilo() {
        pnlCabecalho.setBackground(new java.awt.Color(0, 82, 50));
        pnlCabecalho.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 22, 16, 22));
        lblTitulo.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 22));
        lblTitulo.setForeground(java.awt.Color.WHITE);
        pnlBusca.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 16, 0, 16));
        scrResumo.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 18, 8, 18));
        pnlAcoes.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 16, 16, 16));
        setMinimumSize(new java.awt.Dimension(650, 420));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlAcoes;
    private javax.swing.JPanel pnlBusca;
    private javax.swing.JPanel pnlCabecalho;
    private javax.swing.JPanel pnlCentro;
    private javax.swing.JScrollPane scrResumo;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextArea txtResumo;
    // End of variables declaration//GEN-END:variables
}
