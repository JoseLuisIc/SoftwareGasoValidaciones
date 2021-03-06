/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Usuarios;

import Controlador.LibreriaBDControlador;
import Modelo.modeloTablaUsuario;
import Vista.Principal.ventanaPrincipal;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 *
 * @author Saul Arenas Ramirez
 * Create: 18/06/2020
 */
public class Administracion_de_usuarios extends javax.swing.JFrame {

    /**
     * Creates new form Administracion_de_usuarios
     */
    LibreriaBDControlador lbc = new LibreriaBDControlador();
    modeloTablaUsuario mtu = new modeloTablaUsuario();
    public int tipoUsuario = 0;
    public int idUsuario = 0;
    public Administracion_de_usuarios(modeloTablaUsuario mtu) {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Multimedia/icono_GasValid.jpg")).getImage());
        this.mtu = mtu;
        this.tipoUsuario = mtu.getTipoUsuario();//Obtengo el tipo de usuario
        this.idUsuario = mtu.getIdActual();
        System.out.println("Administracion_de_usuarios tipoUsuario:"+tipoUsuario);
        
        /*Valida el tipo de usuario*/
        if(tipoUsuario == 0){
            
        }else{
            
            AgregarADU.setEnabled(false);
            EditarADU.setEnabled(false);
            EliminarADU.setEnabled(false);
            UsuariosADU.setEnabled(false);
        }
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        AgregarADU = new javax.swing.JButton();
        EditarADU = new javax.swing.JButton();
        EliminarADU = new javax.swing.JButton();
        UsuariosADU = new javax.swing.JButton();
        RegresarADU = new javax.swing.JButton();
        MicuentaADU = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administraci??n de Usuarios");
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 30)); // NOI18N
        jLabel1.setText("Administracion de usuarios");

        AgregarADU.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        AgregarADU.setForeground(new java.awt.Color(51, 153, 0));
        AgregarADU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/mypc_add.png"))); // NOI18N
        AgregarADU.setText("Agregar ");
        AgregarADU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarADUActionPerformed(evt);
            }
        });

        EditarADU.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        EditarADU.setForeground(new java.awt.Color(204, 204, 0));
        EditarADU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/network_write.png"))); // NOI18N
        EditarADU.setText("Editar");
        EditarADU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarADUActionPerformed(evt);
            }
        });

        EliminarADU.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        EliminarADU.setForeground(new java.awt.Color(153, 0, 0));
        EliminarADU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/network_close.png"))); // NOI18N
        EliminarADU.setText("Eliminar");
        EliminarADU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarADUActionPerformed(evt);
            }
        });

        UsuariosADU.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        UsuariosADU.setForeground(new java.awt.Color(0, 102, 204));
        UsuariosADU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/eye_watch.png"))); // NOI18N
        UsuariosADU.setText("Usuarios");
        UsuariosADU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuariosADUActionPerformed(evt);
            }
        });

        RegresarADU.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        RegresarADU.setText("Regresar");
        RegresarADU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarADUActionPerformed(evt);
            }
        });

        MicuentaADU.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        MicuentaADU.setForeground(new java.awt.Color(0, 204, 204));
        MicuentaADU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/mypc_info.png"))); // NOI18N
        MicuentaADU.setText(" Mi cuenta");
        MicuentaADU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MicuentaADUActionPerformed(evt);
            }
        });

        jLabel2.setText("Nota: Solo usuarios tipo administrador pueden agregar, ver, editar y eliminar a los usuarios en el sistema.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel1))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(RegresarADU, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(173, 173, 173)
                                .addComponent(jLabel2))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(204, 204, 204)
                                .addComponent(UsuariosADU, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(99, 99, 99)
                                .addComponent(MicuentaADU, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(AgregarADU, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                        .addComponent(EditarADU, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91)
                        .addComponent(EliminarADU, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AgregarADU, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditarADU, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EliminarADU, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 231, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RegresarADU, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UsuariosADU, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MicuentaADU, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(138, 138, 138))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AgregarADUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarADUActionPerformed
    /*
    Obtengo el ID de usuario y lo mando al nuevo dialog :P    
    */
    int newIdUser = 0; 
    
    
    lbc.openConnection();
    newIdUser = lbc.obtenerIDUser("tabla_usuarios");
    lbc.closeConnection();
    if(newIdUser != 0){
        Agregar_Usuarios dialog = new Agregar_Usuarios(new javax.swing.JFrame(), true,newIdUser);
        dialog.setVisible(true);
    }
    else{
        JOptionPane.showMessageDialog(null, "No se puede obtener el ID.\n "
                + "Verifica con el administrador este fallo.");
    }
    
    }//GEN-LAST:event_AgregarADUActionPerformed

    private void RegresarADUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarADUActionPerformed
    ventanaPrincipal abrir = new ventanaPrincipal(mtu);
    abrir.setVisible(true);
    this.setVisible(false);
    }//GEN-LAST:event_RegresarADUActionPerformed

    private void EditarADUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarADUActionPerformed
    Edita_IUsuario dialog = new Edita_IUsuario(new javax.swing.JFrame(), true);
    dialog.setVisible(true);
    }//GEN-LAST:event_EditarADUActionPerformed

    private void EliminarADUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarADUActionPerformed
        
        Eliminar_Usuarios dialog = new Eliminar_Usuarios(new javax.swing.JFrame(), true,idUsuario);
        dialog.setVisible(true);
    }//GEN-LAST:event_EliminarADUActionPerformed

    private void MicuentaADUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MicuentaADUActionPerformed
        Mi_Cuenta dialog = new Mi_Cuenta(new javax.swing.JFrame(), true,mtu);
        dialog.setVisible(true);
    }//GEN-LAST:event_MicuentaADUActionPerformed

    private void UsuariosADUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuariosADUActionPerformed
        Usuarios dialog = new Usuarios(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_UsuariosADUActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Administracion_de_usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Administracion_de_usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Administracion_de_usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Administracion_de_usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Administracion_de_usuarios().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarADU;
    private javax.swing.JButton EditarADU;
    private javax.swing.JButton EliminarADU;
    private javax.swing.JButton MicuentaADU;
    private javax.swing.JButton RegresarADU;
    private javax.swing.JButton UsuariosADU;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
