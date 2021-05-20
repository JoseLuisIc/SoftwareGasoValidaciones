/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Dispensarios;

import Controlador.LibreriaBDControlador;
import Controlador.LibreriaToolsControlador;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

/**
 * @since 20/07/2020
 * @author joseluis.caamal
 */
public class agregarDispensario extends javax.swing.JDialog {

    /**
     * Creates new form agregarDispensario
     */
    LibreriaBDControlador lbd = new LibreriaBDControlador();
    LibreriaToolsControlador lbt = new LibreriaToolsControlador();
    public agregarDispensario(java.awt.Frame parent, boolean modal) {
       
        super(parent, modal);
        
        initComponents();
        
        String numEstación = campoNoEstacion.getText();
        lbd.openConnection();
        List<String> marcasGasolina = lbd.obtenerMarcaGasolina();
        lbd.closeConnection();
        campoMarcaDispensario.removeAllItems();
        for(int i=0; i< marcasGasolina.size();i++){
           campoMarcaDispensario.addItem(marcasGasolina.get(i));
        }
//        if(numEstación.equals("")){
//            
//            numEstac
//            
//            
//        }else{
//        }
        botonGuardar.setEnabled(false);
        campoNoEstacion.getDocument().addDocumentListener(new DocumentListener()
        {
           @Override
           public void insertUpdate(DocumentEvent evt)
            {
                actualizaEstadoBoton(evt);
            }

           @Override
            public void removeUpdate(DocumentEvent evt)
            {
               actualizaEstadoBoton(evt);
            }

           @Override
            public void changedUpdate(DocumentEvent evt) {}     
            
        }   
        );
        
        
    }
    /*
    Objetive: Permite Actualizar el estado del textfield al momento de seleccionarlo.
    Author: Jose Luis Caaamal Ic
    Date: 19/07/2020
    */
    private void actualizaEstadoBoton(DocumentEvent evt)
    {
        Document doc = evt.getDocument();
        boolean hayTexo = doc.getLength() > 0;
        botonGuardar.setEnabled(hayTexo);
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
        jLabel2 = new javax.swing.JLabel();
        campoNoEstacion = new javax.swing.JTextField();
        campoRazonSocial = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        campoFechaReg = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        campoModelo = new javax.swing.JTextField();
        campoSerie = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        campoMangueraA = new javax.swing.JComboBox();
        campoMangueraC = new javax.swing.JComboBox();
        campoMangueraE = new javax.swing.JComboBox();
        campoMangueraD = new javax.swing.JComboBox();
        campoMangueraB = new javax.swing.JComboBox();
        campoMangueraF = new javax.swing.JComboBox();
        campoMarcaDispensario = new javax.swing.JComboBox();
        campoAlcanceMaximo = new javax.swing.JTextField();
        campoAlcanceMinimo = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        campoAprobacionDGN = new javax.swing.JTextField();
        botonGuardar = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        etiquetaMarcaGasolina = new javax.swing.JLabel();
        campoNoDispensario = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar Dispensario");

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 19)); // NOI18N
        jLabel1.setText("Número de la CRE:");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 19)); // NOI18N
        jLabel2.setText("Razón Social:");

        campoNoEstacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoNoEstacionKeyPressed(evt);
            }
        });

        campoRazonSocial.setEditable(false);

        jLabel18.setText("Fecha Registro:");

        campoFechaReg.setText("Fecha");

        jLabel20.setText("Para validar el número de estación, dirigirse a los catalogos de estaciones.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel18))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoFechaReg)
                    .addComponent(campoNoEstacion, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoRazonSocial)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(campoRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoNoEstacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel20)
                    .addComponent(campoFechaReg))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel3.setText("Núm Dispensario:");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel4.setText("Marca:");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel5.setText("Modelo:");

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel6.setText("Num Serie:");

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel7.setText("Alcance Min:");

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel8.setText("Alcance Max:");

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel9.setText("Manguera A:");

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel10.setText("Manguera C:");

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel11.setText("Manguera E:");

        jLabel12.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel12.setText("Manguera B:");

        jLabel13.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel13.setText("Manguera D:");

        jLabel14.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel14.setText("Manguera F:");

        campoMangueraA.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Magna", "Premium", "Diesel", "N/A" }));
        campoMangueraA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoMangueraAActionPerformed(evt);
            }
        });

        campoMangueraC.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Magna", "Premium", "Diesel", "N/A" }));

        campoMangueraE.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Magna", "Premium", "Diesel", "N/A" }));

        campoMangueraD.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Magna", "Premium", "Diesel", "N/A" }));

        campoMangueraB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Magna", "Premium", "Diesel", "N/A" }));

        campoMangueraF.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Magna", "Premium", "Diesel", "N/A" }));

        campoMarcaDispensario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "WAYNE", "PETROL & IMPORT", "GILBARCO", "TOKHEIM", "PEGASUS", "TEAM", "GBR", "UNIVERSEL", "BENNETT", "SUPRAMAX" }));

        jLabel15.setText("l/m");

        jLabel16.setText("l/m");

        jLabel17.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel17.setText("Aprobación DGN:");

        botonGuardar.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        jLabel21.setText("Para \"Guardar\", es necesario que indique el número de estación.");

        jLabel22.setText("Marca Gasolina:");

        etiquetaMarcaGasolina.setText("jLabel23");

        campoNoDispensario.setEditable(false);
        campoNoDispensario.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel8))
                                .addGap(60, 60, 60)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(campoAprobacionDGN)
                                    .addComponent(campoSerie)
                                    .addComponent(campoModelo)
                                    .addComponent(campoMarcaDispensario, 0, 199, Short.MAX_VALUE)
                                    .addComponent(campoAlcanceMinimo)
                                    .addComponent(campoAlcanceMaximo)
                                    .addComponent(campoNoDispensario)))
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(30, 30, 30)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel9))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(campoMangueraC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(campoMangueraA, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel14)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(campoMangueraF, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel13)
                                                .addGap(10, 10, 10)
                                                .addComponent(campoMangueraD, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(campoMangueraB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel22))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(campoMangueraE, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(etiquetaMarcaGasolina, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addContainerGap(27, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel9)
                    .addComponent(campoMangueraA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(campoMangueraB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoNoDispensario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(campoMarcaDispensario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel13)
                    .addComponent(campoMangueraC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoMangueraD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel11)
                    .addComponent(campoMangueraE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(campoMangueraF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel22)
                    .addComponent(etiquetaMarcaGasolina))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(campoAlcanceMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(campoAprobacionDGN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(campoAlcanceMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(botonGuardar))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void campoMangueraAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoMangueraAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoMangueraAActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        // TODO add your handling code here:
        //Guardo la información
        String campoDispensario = campoNoDispensario.getText();
        String campoEstacion = campoNoEstacion.getText();
        String campoMDispensario = (String) campoMarcaDispensario.getSelectedItem();
        String campoModeloD =  campoModelo.getText();
        String campoSerieD =  campoSerie.getText();
        String campoAlcanceMin = campoAlcanceMinimo.getText();
        String campoAprobacion = campoAprobacionDGN.getText();
        String campoAlcanceMax = campoAlcanceMaximo.getText();
        String campoMA = (String) campoMangueraA.getSelectedItem();
        String campoMB = (String) campoMangueraB.getSelectedItem();
        String campoMC = (String) campoMangueraC.getSelectedItem();
        String campoMD = (String) campoMangueraD.getSelectedItem();
        String campoME = (String) campoMangueraE.getSelectedItem();
        String campoMF = (String) campoMangueraF.getSelectedItem();
        Date obtenFecha = new Date();
        String fechaRegistroDisp = lbt.convertirFecha(obtenFecha);
        String fechaRegistroD = fechaRegistroDisp;
        int valida = 0;
        lbd.openConnection();
        //Inserto los datos a a la tabla_dispensarios
        valida = lbd.insertaDispensarios(campoDispensario, campoEstacion, campoMDispensario, campoModeloD, campoSerieD, campoAlcanceMin, campoAprobacion, campoAlcanceMax, campoMA, campoMB, campoMC, campoMD, campoME, campoMF, fechaRegistroD);
        lbd.closeConnection();
        if(valida==1)
        {
            JOptionPane.showMessageDialog(null, "Proceso exitoso, datos almacenados.");
            this.dispose();
        }
        else{
            JOptionPane.showMessageDialog(null, "Proceso no exitos, verifica tus datos e intenta nuevamente.");
            //this.dispose();
        }
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void campoNoEstacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNoEstacionKeyPressed
        // TODO add your handling code here:
        Object [] arrObjEstacion = null;
        if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER){
               int totalDispReg = 0; //Indica el total de dispensariosReg
               String idEstacion = campoNoEstacion.getText();
               System.out.println("Presiono para buscar");
               int validaEstacion = 0;
               lbd.openConnection();
               validaEstacion = lbd.validaDispensario(idEstacion);
               lbd.closeConnection();
               if(validaEstacion!=0&& !idEstacion.equals("")){
                   System.out.println("Si existe la estación, se procedera a consultar los datos.");
                   //Realizo la consulta de los datos
                   lbd.openConnection();
                   arrObjEstacion = lbd.obtenerArrEstaciones(idEstacion);
                   lbd.closeConnection();
                   campoRazonSocial.setText((String) arrObjEstacion[3]);
                   Date date = (Date) arrObjEstacion[1];
                   arrObjEstacion[1] = lbt.convertirFecha(date);
                   campoFechaReg.setText((String) arrObjEstacion[1]);
                   etiquetaMarcaGasolina.setText((String) arrObjEstacion[14]);
                   //A continuación validamos el dispensario
                   //Cargamos el que sigue :v
                   lbd.openConnection();
                   totalDispReg = lbd.obtenerDispensario(idEstacion);
                   lbd.closeConnection();
                   campoNoDispensario.setText(String.valueOf(totalDispReg));
               }else{
                   campoNoEstacion.setText("");
                   campoNoDispensario.setText("");
                   campoRazonSocial.setText("");
                   campoFechaReg.setText("");
                   etiquetaMarcaGasolina.setText("");
                   System.out.println("No existe la estación.");
                   JOptionPane.showMessageDialog(null, "No existe la estación.");
               }
            }
    }//GEN-LAST:event_campoNoEstacionKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGuardar;
    private javax.swing.JTextField campoAlcanceMaximo;
    private javax.swing.JTextField campoAlcanceMinimo;
    private javax.swing.JTextField campoAprobacionDGN;
    private javax.swing.JLabel campoFechaReg;
    private javax.swing.JComboBox campoMangueraA;
    private javax.swing.JComboBox campoMangueraB;
    private javax.swing.JComboBox campoMangueraC;
    private javax.swing.JComboBox campoMangueraD;
    private javax.swing.JComboBox campoMangueraE;
    private javax.swing.JComboBox campoMangueraF;
    private javax.swing.JComboBox campoMarcaDispensario;
    private javax.swing.JTextField campoModelo;
    private javax.swing.JTextField campoNoDispensario;
    private javax.swing.JTextField campoNoEstacion;
    private javax.swing.JTextField campoRazonSocial;
    private javax.swing.JTextField campoSerie;
    private javax.swing.JLabel etiquetaMarcaGasolina;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
