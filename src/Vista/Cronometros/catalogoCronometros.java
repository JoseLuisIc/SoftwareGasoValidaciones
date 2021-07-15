/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Cronometros;

import Controlador.LibreriaBDControlador;
import Modelo.modeloTablaUsuario;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Saul
 */
public class catalogoCronometros extends javax.swing.JDialog {

    public String columna[];
    LibreriaBDControlador lbd = new LibreriaBDControlador();
    DefaultTableModel modeloCronometros;
    modeloTablaUsuario mtu = new modeloTablaUsuario();
    int tipoUsuario = 0;
    
        public catalogoCronometros(modeloTablaUsuario mtu) {
        this.mtu = mtu;
        tipoUsuario = mtu.getTipoUsuario();
        getColumnas();
        lbd.openConnection();
        modeloCronometros = lbd.modeloCronometros(columna); //Cargo el contenido por defecto
        lbd.closeConnection();
        initComponents();
        //Valido eltipo de usuario
        if(tipoUsuario != 0){
            editarCC.setEnabled(false);
            eliminarCC.setEnabled(false);
        }
        tablaCatalogoCronometros.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = tablaCatalogoCronometros.rowAtPoint(evt.getPoint());
                int col = 0;
                if (row >= 0 && col >= 0) {
                    String valor = tablaCatalogoCronometros.getModel().getValueAt(row, col).toString(); //Tomo el valor de el modelo de la tabla
                }

            }
        });

    }//fincatalogoTermometro
    
            String[] getColumnas(){ //Columnas
            columna = new String[] {"id_Crono",
            "marca",
            "modelo",
            "serie",
            "estatus",
            "fecha_calibracion",
            "resultado",
            "informe_calibracion"};
        return columna;
    }
            
    private void RefrescarCCctionPerformed(java.awt.event.ActionEvent evt) {                                            
        lbd.openConnection();
        modeloCronometros = lbd.modeloCronometros(columna);
        lbd.closeConnection();
        tablaCatalogoCronometros.setModel(modeloCronometros);
        modeloCronometros.fireTableDataChanged();
    }   
            
            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCatalogoCronometros = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        agregarCC = new javax.swing.JButton();
        editarCC = new javax.swing.JButton();
        eliminarCC = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 600));
        setMinimumSize(new java.awt.Dimension(1000, 600));

        tablaCatalogoCronometros.setModel(modeloCronometros);
        jScrollPane1.setViewportView(tablaCatalogoCronometros);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(204, 204, 255));

        agregarCC.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        agregarCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/edit_add.png"))); // NOI18N
        agregarCC.setText("Agregar");
        agregarCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarCCActionPerformed(evt);
            }
        });

        editarCC.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        editarCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/modify.png"))); // NOI18N
        editarCC.setText("Editar");
        editarCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarCCActionPerformed(evt);
            }
        });

        eliminarCC.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        eliminarCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/trash_can3_delete.png"))); // NOI18N
        eliminarCC.setText("Eliminar");
        eliminarCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarCCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(agregarCC, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(editarCC, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(eliminarCC, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(eliminarCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editarCC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(agregarCC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setForeground(new java.awt.Color(204, 255, 204));

        jLabel1.setText("Bienvenido al Catalogo de Cronometros, aquí pueden visualizarse los cronometros disponibles en el sistema.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addContainerGap(292, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void agregarCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarCCActionPerformed
agregarCronometro abrir=new agregarCronometro(new javax.swing.JFrame(), true);
abrir.show();
  RefrescarCCctionPerformed(evt);
    }//GEN-LAST:event_agregarCCActionPerformed

    private void editarCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarCCActionPerformed
      editarCronometro abrir=new editarCronometro(new javax.swing.JFrame(), true);
        abrir.show();
        RefrescarCCctionPerformed(evt);
    }//GEN-LAST:event_editarCCActionPerformed

    private void eliminarCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarCCActionPerformed
        eliminarCronometro abrir=new eliminarCronometro(new javax.swing.JFrame(), true);
        abrir.show();
        RefrescarCCctionPerformed(evt);
    }//GEN-LAST:event_eliminarCCActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarCC;
    private javax.swing.JButton editarCC;
    private javax.swing.JButton eliminarCC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaCatalogoCronometros;
    // End of variables declaration//GEN-END:variables
}
