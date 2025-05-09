/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.vieira.gestaofuncionarios.view;

import br.com.vieira.gestaofuncionarios.controller.UsuarioController;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo
 */
public class CadastroPessoa extends javax.swing.JFrame {

    private final UsuarioController usuarioController;

    /**
     * Creates new form CadastroPessoa
     */
    public CadastroPessoa(UsuarioController usuarioController) {
        this.usuarioController = usuarioController;
        initComponents();
        setLocationRelativeTo(null);
    }

    private CadastroPessoa() {
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

        lblEmail = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        lblTitleLogin = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        btnCancelar = new javax.swing.JButton();
        lblNomeCompleto = new javax.swing.JLabel();
        txtNomeCompleto = new javax.swing.JTextField();
        btnCadastrar1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(950, 630));
        setSize(new java.awt.Dimension(600, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblEmail.setBackground(new java.awt.Color(204, 204, 204));
        lblEmail.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblEmail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEmail.setText("Email");
        getContentPane().add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, -1, -1));

        lblSenha.setBackground(new java.awt.Color(204, 204, 204));
        lblSenha.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblSenha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSenha.setText("Senha");
        getContentPane().add(lblSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, -1, -1));

        lblTitleLogin.setBackground(new java.awt.Color(204, 204, 204));
        lblTitleLogin.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblTitleLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleLogin.setText("Cadastro de Pessoas");
        getContentPane().add(lblTitleLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 230, 30));
        getContentPane().add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, 230, 30));

        btnCancelar.setText("Cancelar");
        btnCancelar.setMargin(new java.awt.Insets(4, 16, 4, 16));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 230, 30));

        lblNomeCompleto.setBackground(new java.awt.Color(204, 204, 204));
        lblNomeCompleto.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblNomeCompleto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNomeCompleto.setText("Nome Completo");
        getContentPane().add(lblNomeCompleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));
        getContentPane().add(txtNomeCompleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 230, 30));

        btnCadastrar1.setText("Cadastrar");
        btnCadastrar1.setMargin(new java.awt.Insets(4, 16, 4, 16));
        btnCadastrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnCadastrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 230, 30));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 750, 10));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCadastrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrar1ActionPerformed
        try {
            usuarioController.cadastrarUsuario(
                    txtNomeCompleto.getText().trim(),
                    txtEmail.getText().trim(),
                    new String(txtSenha.getPassword())
            );
            JOptionPane.showMessageDialog(this, "Cadastro realizado!");
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_btnCadastrar1ActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroPessoa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar1;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JSeparator jSeparator1;
    private static javax.swing.JLabel lblEmail;
    private static javax.swing.JLabel lblNomeCompleto;
    private static javax.swing.JLabel lblSenha;
    private static javax.swing.JLabel lblTitleLogin;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNomeCompleto;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
