/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.vieira.gestaofuncionarios.view;

import br.com.vieira.gestaofuncionarios.controller.FuncionarioController;
import br.com.vieira.gestaofuncionarios.controller.UsuarioController;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eduardo
 */
public class ListaFuncionarios extends javax.swing.JFrame {

    private final FuncionarioController funcionarioController;
    private final UsuarioController usuarioController;

    /**
     * Creates new form ListaFuncionarios
     */
    public ListaFuncionarios(FuncionarioController funcionarioController,
            UsuarioController usuarioController) {
        this.funcionarioController = funcionarioController;
        this.usuarioController = usuarioController;
        initComponents();
        setLocationRelativeTo(null);
    }

    private ListaFuncionarios() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitleLogin = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnCadastrarPessoa = new javax.swing.JButton();
        btnCadastrarFuncionario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(950, 630));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitleLogin.setBackground(new java.awt.Color(204, 204, 204));
        lblTitleLogin.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblTitleLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleLogin.setText("Funcionários");
        getContentPane().add(lblTitleLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Funcionário", "Data Admissão", "Salário"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 760, 220));

        btnCadastrarPessoa.setText("Cadastrar Pessoa");
        btnCadastrarPessoa.setMargin(new java.awt.Insets(4, 16, 4, 16));
        btnCadastrarPessoa.setMaximumSize(new java.awt.Dimension(250, 26));
        btnCadastrarPessoa.setMinimumSize(new java.awt.Dimension(250, 26));
        btnCadastrarPessoa.setPreferredSize(new java.awt.Dimension(250, 26));
        btnCadastrarPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarPessoaActionPerformed(evt);
            }
        });
        getContentPane().add(btnCadastrarPessoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 250, 30));

        btnCadastrarFuncionario.setText("Cadastrar Funcionário");
        btnCadastrarFuncionario.setMargin(new java.awt.Insets(4, 16, 4, 16));
        btnCadastrarFuncionario.setMaximumSize(new java.awt.Dimension(250, 26));
        btnCadastrarFuncionario.setMinimumSize(new java.awt.Dimension(250, 26));
        btnCadastrarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarFuncionarioActionPerformed(evt);
            }
        });
        getContentPane().add(btnCadastrarFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 250, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarPessoaActionPerformed
        new CadastroPessoa(usuarioController).setVisible(true);
    }//GEN-LAST:event_btnCadastrarPessoaActionPerformed

    private void btnCadastrarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarFuncionarioActionPerformed
        new CadastroFuncionario(funcionarioController).setVisible(true);
    }//GEN-LAST:event_btnCadastrarFuncionarioActionPerformed
    private void carregarFuncionarios() throws SQLException {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        funcionarioController.listarFuncionarios().forEach(func -> {
            model.addRow(new Object[]{
                func.getId(),
                func.getNome(),
                func.getDataAdmissao(),
                func.getSalario()
            });
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListaFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaFuncionarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrarFuncionario;
    private javax.swing.JButton btnCadastrarPessoa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private static javax.swing.JLabel lblTitleLogin;
    // End of variables declaration//GEN-END:variables
}
