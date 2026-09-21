package view;

import controller.Conexao;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 * Tela inicial do EcoMaps.
 * Este arquivo possui TelaPrincipal.form e pode ser editado na aba Design do NetBeans.
 */
public class TelaPrincipal extends javax.swing.JFrame {

    public TelaPrincipal() {
        initComponents();
        aplicarEstilo();
        setLocationRelativeTo(null);
    }

    /**
     * Código gerado/gerenciado pelo GUI Builder do NetBeans.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCabecalho = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblSubtitulo = new javax.swing.JLabel();
        pnlConteudo = new javax.swing.JPanel();
        lblCrud = new javax.swing.JLabel();
        pnlCentro = new javax.swing.JPanel();
        lblDescricao = new javax.swing.JLabel();
        pnlBotoes = new javax.swing.JPanel();
        btnCadastrar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        pnlStatus = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EcoMaps - CRUD de Pontos de Coleta");

        pnlCabecalho.setLayout(new java.awt.GridLayout(2, 1, 0, 6));

        lblTitulo.setText("EcoMaps");
        pnlCabecalho.add(lblTitulo);

        lblSubtitulo.setText("Gerenciamento de pontos de coleta para descarte adequado de resíduos.");
        pnlCabecalho.add(lblSubtitulo);

        getContentPane().add(pnlCabecalho, java.awt.BorderLayout.NORTH);

        pnlConteudo.setLayout(new java.awt.BorderLayout(12, 18));

        lblCrud.setText("CRUD de Pontos de Coleta");
        pnlConteudo.add(lblCrud, java.awt.BorderLayout.NORTH);

        pnlCentro.setLayout(new java.awt.BorderLayout(0, 14));

        lblDescricao.setText("Cadastre, consulte, edite e exclua os locais que poderão aparecer no mapa do EcoMaps.");
        pnlCentro.add(lblDescricao, java.awt.BorderLayout.NORTH);

        pnlBotoes.setLayout(new java.awt.GridLayout(2, 2, 14, 14));

        btnCadastrar.setText("Cadastrar (CREATE)");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        pnlBotoes.add(btnCadastrar);

        btnConsultar.setText("Consultar (READ)");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });
        pnlBotoes.add(btnConsultar);

        btnEditar.setText("Editar (UPDATE)");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        pnlBotoes.add(btnEditar);

        btnExcluir.setText("Excluir (DELETE)");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        pnlBotoes.add(btnExcluir);

        pnlCentro.add(pnlBotoes, java.awt.BorderLayout.CENTER);

        pnlConteudo.add(pnlCentro, java.awt.BorderLayout.CENTER);

        pnlStatus.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 12, 5));
        pnlConteudo.add(pnlStatus, java.awt.BorderLayout.SOUTH);

        getContentPane().add(pnlConteudo, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        new CadastroPontoColeta().setVisible(true);
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        new ConsultarPontoColeta().setVisible(true);
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        new AlterarPontoColeta().setVisible(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        new ExcluirPontoColeta().setVisible(true);
    }//GEN-LAST:event_btnExcluirActionPerformed

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> new TelaPrincipal().setVisible(true));
    }


    private void aplicarEstilo() {
        pnlCabecalho.setBackground(new java.awt.Color(0, 82, 50));
        pnlCabecalho.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 30, 20, 30));
        lblTitulo.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 28));
        lblTitulo.setForeground(java.awt.Color.WHITE);
        lblSubtitulo.setFont(new java.awt.Font("SansSerif", java.awt.Font.PLAIN, 15));
        lblSubtitulo.setForeground(new java.awt.Color(225, 245, 235));
        pnlConteudo.setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 30, 24, 30));
        lblCrud.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 22));
        lblDescricao.setFont(new java.awt.Font("SansSerif", java.awt.Font.PLAIN, 14));
        pnlStatus.setBackground(new java.awt.Color(230, 244, 236));
        pnlStatus.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 10, 8, 10));
        java.awt.Font fonteBotao = new java.awt.Font("SansSerif", java.awt.Font.BOLD, 15);
        btnCadastrar.setFont(fonteBotao); btnConsultar.setFont(fonteBotao);
        btnEditar.setFont(fonteBotao); btnExcluir.setFont(fonteBotao);
        setMinimumSize(new java.awt.Dimension(780, 500));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel lblCrud;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblSubtitulo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlBotoes;
    private javax.swing.JPanel pnlCabecalho;
    private javax.swing.JPanel pnlCentro;
    private javax.swing.JPanel pnlConteudo;
    private javax.swing.JPanel pnlStatus;
    // End of variables declaration//GEN-END:variables
}
