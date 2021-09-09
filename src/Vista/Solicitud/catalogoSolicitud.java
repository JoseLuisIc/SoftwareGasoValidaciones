/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Solicitud;

import Modelo.modeloTablaUsuario;
import Controlador.LibreriaBDControlador;
import Controlador.LibreriaToolsControlador;
import Controlador.reportesWord;
import Vista.Dictamen.catalogoConfDictamen;
import Vista.InspeccionDeMedicion.catalogoInspeccionDeMedicion;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

/**
 *
 * @author Saul
 */
public class catalogoSolicitud extends javax.swing.JDialog {
    public String columna[];
    LibreriaToolsControlador lbt = new LibreriaToolsControlador();
    LibreriaBDControlador lbd = new LibreriaBDControlador();
    modeloTablaUsuario mtu = new modeloTablaUsuario();
    DefaultTableModel  modeloSolicitud;
    reportesWord reporteWord = new reportesWord();
    public String  Usuario;
    
    public catalogoSolicitud(modeloTablaUsuario mtu){

       this.mtu=mtu;
        Usuario=mtu.getNombreCompleto();
     getColumnas();
          lbd.openConnection();
         modeloSolicitud = lbd.modeloSolicitudtabla(columna,"","",""); //Cargo el contenido por defecto
         lbd.closeConnection();
            initComponents();
            setIconImage(new ImageIcon(getClass().getResource("/Multimedia/icono_GasValid.jpg")).getImage());
tablaCatalogoSolicitud.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = tablaCatalogoSolicitud.rowAtPoint(evt.getPoint());
                int col  = 0;
                
                if (row >= 0 && col >= 0) {
                    String valor = tablaCatalogoSolicitud.getModel().getValueAt(row, col).toString(); //Tomo el valor de el modelo de la tabla
                    folioSolicitudCS.setText(valor); //Obtengo el valor del textfield
                }
                int col2 = 7;
                if (row >= 0 && col2 >= 0) {
                    String valor2 = tablaCatalogoSolicitud.getModel().getValueAt(row, col2).toString(); //Tomo el valor de el modelo de la tabla
                    noEstacionCS.setText(valor2); //Obtengo el valor del textfield
                }

            }
        });

    }
    /*Obtengo los titulos de mi tabla*/
    String[] getColumnas(){ //Columnas
            columna = new String[] {"FolioSolicitud",
            "Impreso",
            "NombreUsuario",
            "NombreTécnico",
            "Fecha",
            "FechaPropuesta",
            "TipoSolicitud",
            "IDEstación",
            "TMangueras",
            "Referencia",
            "Observaciones",
            "PersonalApoyo"};
        return columna;
    }
    /*private void MostrarTodasSolicitudesActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
        String  folioSolicitud = folioSolicitudCS.getText();
        String tipoSolicitud = (String)tiposolicitudCS.getSelectedItem();
        String noEstacion = (String) noEstacionCS.getText();
        lbd.openConnection();
        modeloSolicitud = lbd.modeloSolicitudtabla(columna, folioSolicitud, tipoSolicitud, noEstacion);
        lbd.closeConnection();
        tablaCatalogoSolicitud.setModel(modeloSolicitud);
        modeloSolicitud.fireTableDataChanged();
    }*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        agregarCS = new javax.swing.JButton();
        modificarCS = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        folioSolicitudCS = new javax.swing.JTextField();
        tiposolicitudCS = new javax.swing.JComboBox<>();
        noEstacionCS = new javax.swing.JTextField();
        buscarCS = new javax.swing.JButton();
        refrescarCS = new javax.swing.JButton();
        imprimirDictamen = new javax.swing.JButton();
        imprimirCS = new javax.swing.JButton();
        refrescarCS1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCatalogoSolicitud = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 600));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        agregarCS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/edit_add.png"))); // NOI18N
        agregarCS.setText("Agregar");
        agregarCS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarCSActionPerformed(evt);
            }
        });

        modificarCS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/modify.png"))); // NOI18N
        modificarCS.setText("Modificar");
        modificarCS.setEnabled(false);
        modificarCS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarCSActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(102, 102, 102));
        jTextArea1.setRows(5);
        jTextArea1.setText("Para filtrar los campos primero\ndeben añadir información a los \ncampos y después darle clic a \nbuscar. Nota: Puede seleccionar\ndirectamente en la tabla para\nllenar el folio en automatico.\n\nDespués de generar la solicitud, ya puedes\ngenerar el dictamen.");
        jTextArea1.setWrapStyleWord(true);
        jScrollPane2.setViewportView(jTextArea1);

        jLabel10.setText("Folio Solicitud:");

        jLabel11.setText("Tipo de solicitud");

        jLabel12.setText("No. Estacion");

        tiposolicitudCS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Inicial", "Periodica", "Extraordinaria" }));

        noEstacionCS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                noEstacionCSKeyTyped(evt);
            }
        });

        buscarCS.setFont(new java.awt.Font("Arial Black", 0, 13)); // NOI18N
        buscarCS.setText("Buscar");
        buscarCS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarCSActionPerformed(evt);
            }
        });

        refrescarCS.setFont(new java.awt.Font("Arial Black", 0, 13)); // NOI18N
        refrescarCS.setText("Refrescar");
        refrescarCS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refrescarCSActionPerformed(evt);
            }
        });

        imprimirDictamen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/printer.png"))); // NOI18N
        imprimirDictamen.setText("Imprimir Dictamen");
        imprimirDictamen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirDictamenActionPerformed(evt);
            }
        });

        imprimirCS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/printer.png"))); // NOI18N
        imprimirCS.setText("Imprimir Solictud");
        imprimirCS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirCSActionPerformed(evt);
            }
        });

        refrescarCS1.setFont(new java.awt.Font("Arial Black", 0, 13)); // NOI18N
        refrescarCS1.setText("Terminar");
        refrescarCS1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refrescarCS1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(imprimirDictamen, javax.swing.GroupLayout.PREFERRED_SIZE, 169, Short.MAX_VALUE)
                    .addComponent(agregarCS, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                    .addComponent(modificarCS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imprimirCS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel11))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tiposolicitudCS, 0, 179, Short.MAX_VALUE)
                                        .addComponent(folioSolicitudCS)))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addGap(41, 41, 41)
                                    .addComponent(noEstacionCS)))
                            .addGap(137, 137, 137))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(refrescarCS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buscarCS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                            .addContainerGap()))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(refrescarCS1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(folioSolicitudCS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addComponent(buscarCS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(tiposolicitudCS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(refrescarCS)
                        .addGap(9, 9, 9)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(noEstacionCS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(5, 5, 5)
                        .addComponent(refrescarCS1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(agregarCS)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(modificarCS, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(imprimirCS)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(imprimirDictamen))
                            .addComponent(jScrollPane2))
                        .addGap(0, 21, Short.MAX_VALUE))))
        );

        tablaCatalogoSolicitud.setModel(modeloSolicitud);
        jScrollPane1.setViewportView(tablaCatalogoSolicitud);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE))
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

    private void agregarCSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarCSActionPerformed
                registroSolicitudContrato dialog = new registroSolicitudContrato(new javax.swing.JFrame(), true, mtu);
                dialog.setVisible(true);
                
        lbd.openConnection();
        modeloSolicitud = lbd.modeloSolicitudtabla(columna, "", "", "");
        lbd.closeConnection();
        tablaCatalogoSolicitud.setModel(modeloSolicitud);
        modeloSolicitud.fireTableDataChanged();
                
    }//GEN-LAST:event_agregarCSActionPerformed

    private void modificarCSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarCSActionPerformed
        modificarSolicitudContrato dialog=new modificarSolicitudContrato(new javax.swing.JFrame(), true, mtu);
        dialog.setVisible(true);
        
           lbd.openConnection();
        modeloSolicitud = lbd.modeloSolicitudtabla(columna, "", "", "");
        lbd.closeConnection();
        tablaCatalogoSolicitud.setModel(modeloSolicitud);
        modeloSolicitud.fireTableDataChanged();
    }//GEN-LAST:event_modificarCSActionPerformed

    private void refrescarCSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refrescarCSActionPerformed
        lbd.openConnection();
        modeloSolicitud = lbd.modeloSolicitudtabla(columna, "", "", "");
        lbd.closeConnection();
        tablaCatalogoSolicitud.setModel(modeloSolicitud);
        modeloSolicitud.fireTableDataChanged();
        // TODO add your handling code here:
    }//GEN-LAST:event_refrescarCSActionPerformed

    private void noEstacionCSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_noEstacionCSKeyTyped
//    char solonumero=evt.getKeyChar();
//
//    if(Character.isLetter(solonumero)){
//        getToolkit().beep();
//        evt.consume();
//        JOptionPane.showMessageDialog(rootPane, "Ingresar solo numeros");
//    }        // TODO add your handling code here:
    }//GEN-LAST:event_noEstacionCSKeyTyped

    private void buscarCSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarCSActionPerformed
  // TODO add your handling code here:
        String  folioSolicitud = folioSolicitudCS.getText();
        String tipoSolicitud = (String)tiposolicitudCS.getSelectedItem();
        String noEstacion = (String) noEstacionCS.getText();
        lbd.openConnection();
        modeloSolicitud = lbd.modeloSolicitudtabla(columna, folioSolicitud, tipoSolicitud, noEstacion);
        lbd.closeConnection();
        tablaCatalogoSolicitud.setModel(modeloSolicitud);
        modeloSolicitud.fireTableDataChanged();
    }//GEN-LAST:event_buscarCSActionPerformed

    private void imprimirCSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirCSActionPerformed
        // TODO add your handling code here:
        /*
        Imprimo la solicitud
        Realizo la consulta de la información que se necesita.
        Se adecua el codigo para la solcitud para no reeplicar codigo
        */
            int operacionExitosa = 1;
            int tipoDoc = 2;
            Object [] arregloDatosDoc;
            String folioSol = folioSolicitudCS.getText();
            int validaFSol = 0;

            lbd.openConnection();
            validaFSol = lbd.validaFolioSolicitud(folioSol);
            lbd.closeConnection();
       
            if(validaFSol != 0){
            /*Creo un arreglo con las etiquetas que se necesitan modificar/reemplazar*/
                String [] etiquetasReemplazo = {"«FOLY»",
                    "«SOLTYPE»",
                    "«SOLICITA»",
                    "«RZNSOCIAL»",
                    "«CITY»",
                    "«STATE»",
                    "«DATE»",
                    "«TESTIGO»",
                    "«DOM»",
                    "«CELL»",
                    "«CORELE»",
                    "«NESTACION»",
                    "«NCRE»",
                    "«MGN»",
                    "«PMM»",
                    "«DISL»",
                    "«OBSEVCNS»",
                    "«CPP»",
                    "«RFC»",
                    "«PERIODO»"
            };
                String periodo = lbt.obtenerPeriodo();
                
                /*Recupero la información para mi documento :) */
                lbd.openConnection();
                arregloDatosDoc = lbd.obtenerDatosSolicitud(folioSol,periodo);
                operacionExitosa = lbd.updateSolicitudDictamen(folioSol);
                lbd.closeConnection();
                //arregloDatosDoc = (String[]) arregloDatosDocAux;
                System.out.println("Datos:"+arregloDatosDoc.length+"Etiquetas:"+etiquetasReemplazo.length);
                try {
                    /*Inserto los valores al documento machote y lo guardo en la nueva ubicación*/
//                    for (Object arregloDatosDoc1 : arregloDatosDoc) {
//                        //arregloDatosDoc[i];
//                        System.out.println("" + arregloDatosDoc1);
//                    }
                    reporteWord.creaDocContrato(etiquetasReemplazo,arregloDatosDoc, tipoDoc, folioSol);
                    JOptionPane.showMessageDialog(null, "Ahora continuaremos con el proceso de dictamen.");
                } catch (InvalidFormatException | IOException ex) {
                    Logger.getLogger(catalogoInspeccionDeMedicion.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Ocurrio un error al crear el archivo error es el siguiente:"+ex);
                }
               
            }
            else{
                JOptionPane.showMessageDialog(null,"No existe el folio que quiere imprimir");
            }
        
    }//GEN-LAST:event_imprimirCSActionPerformed

    private void imprimirDictamenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirDictamenActionPerformed
        // TODO add your handling code here:
            
            int operacionExitosa = 1;
            int tipoDoc = 4;
            int tipoDocDic = 3;
            int tipoDocDicFinal = 5; //El dictamen Final se genera apartir de este documento.
            Object [] arregloDatosDoc;
            Object [] arregloDatosDocDic = null;
            String folioSol = folioSolicitudCS.getText();
            String idEstacion = noEstacionCS.getText();
            int validaPosicion = 0;
            int validaFSol = 0;
            int validaEstacion = 0;

            lbd.openConnection();
            validaFSol = lbd.validaFolioSolicitud(folioSol);
            validaEstacion = lbd.obtenerEstaciones(idEstacion);
            validaPosicion = lbd.obtenerValidacionFolioEstacion(folioSol,idEstacion);
            lbd.closeConnection();
            
            if(validaFSol != 0 && validaEstacion !=0 && validaPosicion !=0){
            /*Creo un arreglo con las etiquetas que se necesitan modificar/reemplazar*/
                String periodo = ""; //lbt.obtenerPeriodo(); El periodo se pide al cargar la configuración, por eso se comenta JLCI 24/07/2021
                String horarioInicio = lbt.obtenerHorarioInicio();
                String horarioFin = lbt.obtenerHorarioFIN();
                String fechaLocal = lbt.obtenerFecha();
                
                String [] etiquetasReemplazoDictamen = {
                    "«FOLIO»",
                    "«TYPESOL»",
                    "«RESPONSABLE»",
                    "«CARGO»",
                    "«SOLICITANTE»",
                    "«RZNSOCIAL»",
                    "«DOM»",
                    "«RFC»",
                    "«CIUDAD»",
                    "«TELEF»",
                    "«UTM»",
                    "«CP»",
                    "«ESTADO»",
                    "«NOCRE»",
                    "«OBSV»",
                    "«OBSVC»",
                    "«TECNICO»",
                    "«PAPOYO»",
                    "«SOLICITANTEF»",
                    "«MEDIDAS»",
                    "«CRONO»",
                    "«TERMO»",
                    "«PERIODO»",
                    "«HORAUNO»",
                    "«HORADOS»",
                    "«DATE»"
                };
                /*Recupero la información para mi documento :) */
                lbd.openConnection();
                //catalogoConfDictamen ccd = new catalogoConfDictamen(folioSol,idEstacion);
                catalogoConfDictamen cfd = new  catalogoConfDictamen(null, rootPaneCheckingEnabled, folioSol, idEstacion);
                cfd.show();
                
                fechaLocal = cfd.confDic.getFecha();
                periodo = cfd.confDic.getPeriodo();
                horarioInicio = cfd.confDic.getHoraIn();
                horarioFin = cfd.confDic.getHoraFin();
             
                //lbd.obtenerDatosDictamenHU(folioSol,periodo);
                arregloDatosDocDic = lbd.obtenerDatosDictamen(folioSol,periodo,horarioInicio,horarioFin,fechaLocal);
                List <String> datosDictamen = lbd.obtenerDatosDictamenHD(folioSol,idEstacion);
                arregloDatosDoc = new Object[datosDictamen.size()];
                String [] etiquetasReemplazo = new String[datosDictamen.size()];// {"«FOLY»","«DICTAMENLISTA»"};
                for (int i = 0; i < datosDictamen.size(); i++) {
                    arregloDatosDoc[i] = " ";
                    etiquetasReemplazo[i]= " ";
                }
                System.out.println("datosDictamen: "+datosDictamen.size());
                for (int i = 0; i < datosDictamen.size(); i++) {
                    arregloDatosDoc[i] = datosDictamen.get(i);
                    etiquetasReemplazo[i]= "«DICTAMENLISTA"+i+"»";
                }
                System.out.println(Arrays.toString(arregloDatosDoc));
                System.out.println(Arrays.toString(etiquetasReemplazo));
                /*Vaciar tabla */
                lbd.vaciarTabla("tabla_datos_dictamen");
                //operacionExitosa = lbd.updateSolicitudDictamen(folioSol);
                lbd.closeConnection();
                //arregloDatosDoc = (String[]) arregloDatosDocAux;
                System.out.println("Datos:"+arregloDatosDocDic.length+"Etiquetas:"+etiquetasReemplazoDictamen.length);
                System.out.println("Datos:"+arregloDatosDoc.length+"Etiquetas:"+etiquetasReemplazo.length);
                try {
                    reporteWord.creaDocContrato(etiquetasReemplazoDictamen,arregloDatosDocDic, tipoDocDic,folioSol);
                    /*NoTocar*/
                    
                    reporteWord.creaDocContrato(etiquetasReemplazo,arregloDatosDoc, tipoDoc,folioSol);
                    /*Generar el documento completo*/
                    //tipoDocDicFinal;
                    //reporteWord
                } catch (InvalidFormatException | IOException ex) {
                    Logger.getLogger(catalogoInspeccionDeMedicion.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Ocurrio un error al crear el archivo error es el siguiente:"+ex);
                }
                
            }else{
                
                if(validaFSol == 0 && validaEstacion ==0 )
                    JOptionPane.showMessageDialog(null,"No existe el folio & la estación que quiere imprimir.");
                if(validaFSol ==0)
                    JOptionPane.showMessageDialog(null,"No existe el folio que quiere imprimir.");
                if(validaEstacion ==0)
                    JOptionPane.showMessageDialog(null,"No existe la estación que quiere imprimir.");
                if(validaPosicion ==0) 
                    JOptionPane.showMessageDialog(null,"El folio y la estación, no están relacionados.");
                
            }
    }//GEN-LAST:event_imprimirDictamenActionPerformed

    private void refrescarCS1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refrescarCS1ActionPerformed
        dispose();
    }//GEN-LAST:event_refrescarCS1ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarCS;
    private javax.swing.JButton buscarCS;
    private javax.swing.JTextField folioSolicitudCS;
    private javax.swing.JButton imprimirCS;
    private javax.swing.JButton imprimirDictamen;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton modificarCS;
    private javax.swing.JTextField noEstacionCS;
    private javax.swing.JButton refrescarCS;
    private javax.swing.JButton refrescarCS1;
    private javax.swing.JTable tablaCatalogoSolicitud;
    private javax.swing.JComboBox<String> tiposolicitudCS;
    // End of variables declaration//GEN-END:variables
}
