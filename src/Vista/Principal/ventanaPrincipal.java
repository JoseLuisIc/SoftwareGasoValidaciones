/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Principal;

import Modelo.modeloTablaUsuario;
import Vista.Cronometros.catalogoCronometros;
import Vista.Dispensarios.catalogoDispensarios;
import Vista.Estacion.*;
import Vista.Hologramas.catalogoHologramas;
import Vista.InspeccionDeMedicion.catalogoInspeccionDeMedicion;
import Vista.Jarras.catalogoMedidadVolumetricasJarras;
import Vista.Precinto.catalogoPrecinto;
import java.awt.Image;
import java.io.File;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import Vista.Usuarios.Administracion_de_usuarios;
import Vista.Solicitud.catalogoSolicitud;
import Vista.Termometro.catalogoTermometro;

/**
 *
 * @author Christian Olmedo
 */
public class ventanaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form ventanaPrincipal
     */
    String ruta = "";
    public URL url = getClass().getResource(ruta);
    Image image = new ImageIcon(url).getImage();
    modeloTablaUsuario mtu = new modeloTablaUsuario();
    public ventanaPrincipal(modeloTablaUsuario mtu) {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Multimedia/icono_GasValid.jpg")).getImage());
        this.mtu = mtu;
        catalogoCronometros.setToolTipText("Catálogo Cronómetros");
        catalogoJarras.setToolTipText("Catálogo Jarras");
        catalogoTermometros.setToolTipText("Catálogo Termómetros");
        //registroContrato.setToolTipText("Registro Contrato");
        inspeccionMedicion.setToolTipText("Inspección de Medición");
        registroSolicitud.setToolTipText("Registro Solicitud");
        catalogoEstaciones.setToolTipText("Catálogo Estaciones");
        catalogoDispensarios.setToolTipText("Catálogo Movimientos Dispensarios");
        cambiarImagen.setToolTipText("Cambiar Imagen");
        catalogoUsuarios.setToolTipText("Catálogo Usuarios");
        catalogoHologramas.setToolTipText("Catálogo Hologramas");
        catalogoPrecinto.setToolTipText("Catálogo Precinto");
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
        catalogoCronometros = new javax.swing.JButton();
        catalogoJarras = new javax.swing.JButton();
        catalogoTermometros = new javax.swing.JButton();
        catalogoHologramas = new javax.swing.JButton();
        inspeccionMedicion = new javax.swing.JButton();
        registroSolicitud = new javax.swing.JButton();
        catalogoEstaciones = new javax.swing.JButton();
        catalogoDispensarios = new javax.swing.JButton();
        cambiarImagen = new javax.swing.JButton();
        catalogoUsuarios = new javax.swing.JButton();
        catalogoPrecinto = new javax.swing.JButton();
        labelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GasValid 2.0");
        setLocation(new java.awt.Point(600, 0));
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.setForeground(new java.awt.Color(255, 153, 153));
        jPanel1.setAlignmentX(60.0F);
        jPanel1.setAlignmentY(60.0F);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        catalogoCronometros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/chronometer.png"))); // NOI18N
        catalogoCronometros.setAlignmentX(0.5F);
        catalogoCronometros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catalogoCronometrosActionPerformed(evt);
            }
        });
        jPanel1.add(catalogoCronometros, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 80));

        catalogoJarras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/jarras_opt.png"))); // NOI18N
        catalogoJarras.setAlignmentX(0.5F);
        catalogoJarras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catalogoJarrasActionPerformed(evt);
            }
        });
        jPanel1.add(catalogoJarras, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 80, 80));

        catalogoTermometros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/thermometer.png"))); // NOI18N
        catalogoTermometros.setAlignmentX(0.5F);
        catalogoTermometros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catalogoTermometrosActionPerformed(evt);
            }
        });
        jPanel1.add(catalogoTermometros, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 80, 80));

        catalogoHologramas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/profeco.png"))); // NOI18N
        catalogoHologramas.setAlignmentX(0.5F);
        catalogoHologramas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catalogoHologramasActionPerformed(evt);
            }
        });
        jPanel1.add(catalogoHologramas, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 80, 80));

        inspeccionMedicion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/contract_pencil.png"))); // NOI18N
        inspeccionMedicion.setAlignmentX(0.5F);
        inspeccionMedicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inspeccionMedicionActionPerformed(evt);
            }
        });
        jPanel1.add(inspeccionMedicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 80, 80));

        registroSolicitud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/to_do_list_checked2.png"))); // NOI18N
        registroSolicitud.setAlignmentX(0.5F);
        registroSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroSolicitudActionPerformed(evt);
            }
        });
        jPanel1.add(registroSolicitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 80, 80));

        catalogoEstaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/pemex2.png"))); // NOI18N
        catalogoEstaciones.setAlignmentX(0.5F);
        catalogoEstaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catalogoEstacionesActionPerformed(evt);
            }
        });
        jPanel1.add(catalogoEstaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 80, 80));

        catalogoDispensarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/gas.png"))); // NOI18N
        catalogoDispensarios.setAlignmentX(0.5F);
        catalogoDispensarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catalogoDispensariosActionPerformed(evt);
            }
        });
        jPanel1.add(catalogoDispensarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 80, 80));

        cambiarImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/gasvalid_changemain.png"))); // NOI18N
        cambiarImagen.setAlignmentX(0.5F);
        cambiarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarImagenActionPerformed(evt);
            }
        });
        jPanel1.add(cambiarImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 510, 70, 70));

        catalogoUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/user_group.png"))); // NOI18N
        catalogoUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catalogoUsuariosActionPerformed(evt);
            }
        });
        jPanel1.add(catalogoUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 80, 80));

        catalogoPrecinto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/precinto.jpg"))); // NOI18N
        catalogoPrecinto.setAlignmentX(0.5F);
        catalogoPrecinto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catalogoPrecintoActionPerformed(evt);
            }
        });
        jPanel1.add(catalogoPrecinto, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, 80, 80));

        labelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/fondoGVV.jpg"))); // NOI18N
        jPanel1.add(labelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, -1, -1));

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

    private void catalogoCronometrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catalogoCronometrosActionPerformed
  catalogoCronometros abrir=new catalogoCronometros(mtu);
     abrir.show();
    }//GEN-LAST:event_catalogoCronometrosActionPerformed
  
    private void catalogoJarrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catalogoJarrasActionPerformed
    catalogoMedidadVolumetricasJarras abrir = new catalogoMedidadVolumetricasJarras();
    abrir.show();
    //this.setVisible(false);
    }//GEN-LAST:event_catalogoJarrasActionPerformed

    private void catalogoTermometrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catalogoTermometrosActionPerformed
       catalogoTermometro abrir=new catalogoTermometro(mtu);
        abrir.show();

    }//GEN-LAST:event_catalogoTermometrosActionPerformed

    private void catalogoHologramasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catalogoHologramasActionPerformed
        //saul arenas ramirez 8/07/2020
        catalogoHologramas abrir=new catalogoHologramas(mtu);
        abrir.show();
        //this.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_catalogoHologramasActionPerformed

    private void inspeccionMedicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inspeccionMedicionActionPerformed
        // TODO add your handling code here:
        catalogoInspeccionDeMedicion cipm = new catalogoInspeccionDeMedicion();
        cipm.show();
    }//GEN-LAST:event_inspeccionMedicionActionPerformed

    private void registroSolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroSolicitudActionPerformed
       catalogoSolicitud ver=new catalogoSolicitud(mtu);
       ver.show();
// TODO add your handling code here:
    }//GEN-LAST:event_registroSolicitudActionPerformed

    private void catalogoEstacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catalogoEstacionesActionPerformed
        // TODO add your handling code here:
        catalogoEstaciones ce = new catalogoEstaciones();
        ce.show();
    }//GEN-LAST:event_catalogoEstacionesActionPerformed

    private void catalogoDispensariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catalogoDispensariosActionPerformed
        // TODO add your handling code here:
        catalogoDispensarios cd = new catalogoDispensarios(mtu);
        cd.show();
    }//GEN-LAST:event_catalogoDispensariosActionPerformed

    
    /*
    Desarrollo: José Luis Caamal Ic
    Objetivo: El boton cambia la imagen del panel principal por cualquiera que se elija mediante el jfilechooser.
    Parametros:
    */
    private void cambiarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarImagenActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
    
            FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif"); 
            fileChooser.setFileFilter(imgFilter);

            int result = fileChooser.showOpenDialog(this);

            if (result != JFileChooser.CANCEL_OPTION) {

                File fileName = fileChooser.getSelectedFile();

                if ((fileName == null) || (fileName.getName().equals(""))) {
                    //txt.setText("...");
                } else {
                    //txt.setText(fileName.getAbsolutePath());
                    ruta = fileName.getAbsolutePath();
                    labelFondo.setIcon(new ImageIcon(ruta));
                    labelFondo.setOpaque(true);
                }
            }
    }//GEN-LAST:event_cambiarImagenActionPerformed

    private void catalogoUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catalogoUsuariosActionPerformed
        Administracion_de_usuarios  abrir = new Administracion_de_usuarios(mtu);
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_catalogoUsuariosActionPerformed

    private void catalogoPrecintoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catalogoPrecintoActionPerformed
        catalogoPrecinto cP = new catalogoPrecinto();
        cP.show();        
    }//GEN-LAST:event_catalogoPrecintoActionPerformed

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
//            java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ventanaPrincipal().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cambiarImagen;
    private javax.swing.JButton catalogoCronometros;
    private javax.swing.JButton catalogoDispensarios;
    private javax.swing.JButton catalogoEstaciones;
    private javax.swing.JButton catalogoHologramas;
    private javax.swing.JButton catalogoJarras;
    private javax.swing.JButton catalogoPrecinto;
    private javax.swing.JButton catalogoTermometros;
    private javax.swing.JButton catalogoUsuarios;
    private javax.swing.JButton inspeccionMedicion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelFondo;
    private javax.swing.JButton registroSolicitud;
    // End of variables declaration//GEN-END:variables
}
