package view;

import controller.PontoColetaDAO;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.PontoColeta;

/** Formulário visual de consulta (READ). */
public class ConsultarPontoColeta extends javax.swing.JFrame {

    private final PontoColetaDAO dao = new PontoColetaDAO();

    public ConsultarPontoColeta() {
        initComponents();
        aplicarEstilo();
        setLocationRelativeTo(null);
        listarTodos();
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
        btnListar = new javax.swing.JButton();
        scrTabela = new javax.swing.JScrollPane();
        tblPontos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("EcoMaps - Consultar pontos de coleta");
        getContentPane().setLayout(new java.awt.BorderLayout(0, 8));

        pnlCabecalho.setLayout(new java.awt.BorderLayout());

        lblTitulo.setText("Consultar pontos de coleta ");
        pnlCabecalho.add(lblTitulo, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlCabecalho, java.awt.BorderLayout.NORTH);

        pnlCentro.setLayout(new java.awt.BorderLayout(0, 8));

        pnlBusca.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        lblId.setText("ID:");
        pnlBusca.add(lblId);

        txtId.setColumns(8);
        pnlBusca.add(txtId);

        btnBuscar.setText("Buscar por ID");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);
        pnlBusca.add(btnBuscar);

        btnListar.setText("Listar todos");
        btnListar.addActionListener(this::btnListarActionPerformed);
        pnlBusca.add(btnListar);

        pnlCentro.add(pnlBusca, java.awt.BorderLayout.NORTH);

        tblPontos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblPontos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Endereço", "Bairro", "Cidade", "Materiais", "Horário", "Latitude", "Longitude"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrTabela.setViewportView(tblPontos);

        pnlCentro.add(scrTabela, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlCentro, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            int id = Integer.parseInt(txtId.getText().trim());
            PontoColeta p = dao.buscarPorId(id);
            if (p == null) {
                JOptionPane.showMessageDialog(this, "Nenhum ponto encontrado com ID " + id + ".");
                preencherTabela(java.util.Collections.emptyList());
            } else {
                preencherTabela(java.util.Collections.singletonList(p));
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Digite um ID numérico.", "ID inválido", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao consultar: " + e.getMessage(), "Banco de dados", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        listarTodos();
    }//GEN-LAST:event_btnListarActionPerformed

    private void listarTodos() {
        try { preencherTabela(dao.listarTodos()); }
        catch (SQLException e) { JOptionPane.showMessageDialog(this, "Erro ao listar: " + e.getMessage(), "Banco de dados", JOptionPane.ERROR_MESSAGE); }
    }

    private void preencherTabela(List<PontoColeta> pontos) {
        DefaultTableModel modelo = (DefaultTableModel) tblPontos.getModel();
        modelo.setRowCount(0);
        for (PontoColeta p : pontos) {
            modelo.addRow(new Object[]{p.getId(), p.getNome(), p.getEndereco(), p.getBairro(), p.getCidade(),
                p.getMateriaisAceitos(), p.getHorarioFuncionamento(), p.getLatitude(), p.getLongitude()});
        }
    }


    private void aplicarEstilo() {
        pnlCabecalho.setBackground(new java.awt.Color(0, 82, 50));
        pnlCabecalho.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 22, 16, 22));
        lblTitulo.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 22));
        lblTitulo.setForeground(java.awt.Color.WHITE);
        pnlBusca.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 12, 0, 12));
        tblPontos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        setMinimumSize(new java.awt.Dimension(980, 500));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnListar;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlBusca;
    private javax.swing.JPanel pnlCabecalho;
    private javax.swing.JPanel pnlCentro;
    private javax.swing.JScrollPane scrTabela;
    private javax.swing.JTable tblPontos;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
