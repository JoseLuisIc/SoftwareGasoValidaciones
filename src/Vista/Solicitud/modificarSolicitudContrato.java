/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Solicitud;

import Controlador.LibreriaBDControlador;
import Controlador.LibreriaToolsControlador;
import java.text.SimpleDateFormat;

import java.text.DateFormat;
import java.util.Date;
import Modelo.modeloTablaUsuario;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author Saul
 */
public class modificarSolicitudContrato extends javax.swing.JDialog {
    LibreriaBDControlador lbd = new LibreriaBDControlador();
    modeloTablaUsuario mtu = new modeloTablaUsuario();
    public String Usuario;
    
    public modificarSolicitudContrato(java.awt.Frame parent, boolean modal,modeloTablaUsuario mtu) {
                super(parent, modal);
                this.mtu = mtu;
                Usuario = mtu.getNombreCompleto();
                initComponents();             
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
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        manguerasaVerificarMSC = new javax.swing.JTextField();
        magnaMSC = new javax.swing.JTextField();
        premiumMSC = new javax.swing.JTextField();
        diselMSC = new javax.swing.JTextField();
        nombreSolicitanteMSC = new javax.swing.JTextField();
        razonSocialMSC = new javax.swing.JTextField();
        domicilioMSC = new javax.swing.JTextField();
        estadoMSC = new javax.swing.JTextField();
        telefonoMSC = new javax.swing.JTextField();
        emailMSC = new javax.swing.JTextField();
        regfedCausantesMSC = new javax.swing.JTextField();
        estacionMSC = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        noEstacionMSC = new javax.swing.JTextField();
        referenciaSolicitudMSC = new javax.swing.JTextField();
        observacionesMSC = new javax.swing.JTextField();
        tecnicoMSC = new javax.swing.JTextField();
        fechaMSC = new com.toedter.calendar.JDateChooser();
        fechaPropuestaMSC = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        tiposolicitudMSC = new javax.swing.JComboBox<>();
        foliosolicitudMSC = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        tecnicoMSC1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(599, 685));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel8.setText("Mangueras a verificar");

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel9.setText("Magna");

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel10.setText("Premium");

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel11.setText("Disel");

        jLabel12.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel12.setText("Nombre de solicitante");

        jLabel13.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel13.setText("Razon social");

        jLabel14.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel14.setText("Reg.Fed.Causantes");

        jLabel15.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel15.setText("Domicilio");

        jLabel19.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel19.setText("Estacion No.");

        jLabel16.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel16.setText("Telefono");

        jLabel17.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel17.setText("Estado");

        jLabel24.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel24.setText("Email");

        manguerasaVerificarMSC.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N

        magnaMSC.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N

        premiumMSC.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N

        diselMSC.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N

        nombreSolicitanteMSC.setEditable(false);
        nombreSolicitanteMSC.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N

        razonSocialMSC.setEditable(false);
        razonSocialMSC.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N

        domicilioMSC.setEditable(false);
        domicilioMSC.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N

        estadoMSC.setEditable(false);
        estadoMSC.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N

        telefonoMSC.setEditable(false);
        telefonoMSC.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N

        emailMSC.setEditable(false);
        emailMSC.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N

        regfedCausantesMSC.setEditable(false);
        regfedCausantesMSC.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N

        estacionMSC.setEditable(false);
        estacionMSC.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(manguerasaVerificarMSC, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(magnaMSC, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(premiumMSC, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(diselMSC, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombreSolicitanteMSC))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addGap(29, 29, 29)
                        .addComponent(razonSocialMSC))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(102, 102, 102)
                        .addComponent(telefonoMSC))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(estadoMSC, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(emailMSC, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(97, 97, 97)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(domicilioMSC)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(regfedCausantesMSC, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(estacionMSC)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(manguerasaVerificarMSC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(magnaMSC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(premiumMSC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diselMSC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(nombreSolicitanteMSC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(razonSocialMSC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(regfedCausantesMSC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(estacionMSC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(domicilioMSC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(telefonoMSC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(estadoMSC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailMSC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel2.setText("Tipo de solicitud");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel3.setText("No. Estacion");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel4.setText("Fecha Propuesta");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel5.setText("Referencia de Solicitud");

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel6.setText("Observaciones");

        jLabel20.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel20.setText("Tecnico");

        jLabel18.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel18.setText("Fecha");

        jLabel22.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel22.setText("Presione enter al terminar");

        jLabel23.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel23.setText("de ingresar el No.Estacion");

        noEstacionMSC.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        noEstacionMSC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                noEstacionMSCKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                noEstacionMSCKeyPressed(evt);
            }
        });

        referenciaSolicitudMSC.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N

        observacionesMSC.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N

        tecnicoMSC.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel7.setText("Folio de solicitud");

        tiposolicitudMSC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Inicial", "Periodica", "Extraordinaria" }));

        foliosolicitudMSC.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N

        jLabel21.setFont(new java.awt.Font("Arial Black", 0, 20)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(153, 153, 0));
        jLabel21.setText("Editar Solicitud/Contrato");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/modify.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel25.setText("Personal de Apoyo");

        tecnicoMSC1.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel20)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(noEstacionMSC)
                            .addComponent(fechaPropuestaMSC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(referenciaSolicitudMSC)
                            .addComponent(observacionesMSC)
                            .addComponent(tecnicoMSC))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tecnicoMSC1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel23))))
                        .addGap(2, 2, 2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(55, 55, 55)
                                .addComponent(tiposolicitudMSC, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(jLabel21))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addComponent(foliosolicitudMSC, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(fechaMSC, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)))))
                        .addGap(63, 63, 63))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel21)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(foliosolicitudMSC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tiposolicitudMSC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(fechaMSC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(noEstacionMSC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel23)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(fechaPropuestaMSC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(referenciaSolicitudMSC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(observacionesMSC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(tecnicoMSC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(tecnicoMSC1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void noEstacionMSCKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_noEstacionMSCKeyPressed
Object  Datos[]=null;
if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER){
String idestacion=noEstacionMSC.getText();
 
int validaEstacion = 0;

       lbd.openConnection();
               validaEstacion = lbd.validaDispensario(idestacion);
               lbd.closeConnection();
               if(validaEstacion!=0 && !idestacion.equals("")){
                                  System.out.println("Si existe la estación, se procedera a consultar los datos.");
                                                     lbd.openConnection();
                                                     Datos=lbd.obtenerdatosparasolicitud(idestacion);
                                                     lbd.closeConnection();
                                                     
                                                     
                                                     magnaMSC.setText((String) String.valueOf(Datos[15]));
                                                     premiumMSC.setText((String)String.valueOf(Datos[16]));
                                                     diselMSC.setText((String)String.valueOf(Datos[17]));
                                                     
                                                     int magna=Integer.parseInt(magnaMSC.getText());
                                                     int premium=Integer.parseInt(premiumMSC.getText());
                                                     int disel=Integer.parseInt(diselMSC.getText());
                                                     
                                                     int total=magna+premium+disel;
                                                     
                                                     manguerasaVerificarMSC.setText((String)String.valueOf(total));
                                                     
                                                     nombreSolicitanteMSC.setText((String)Datos[2]);
                                                     razonSocialMSC.setText((String)Datos[3]);
                                                     regfedCausantesMSC.setText((String)Datos[4]);
                                                     estacionMSC.setText((String)String.valueOf(Datos[0]));
                                                     domicilioMSC.setText((String)Datos[5]);
                                                     telefonoMSC.setText((String)Datos[9]);
                                                     estadoMSC.setText((String)Datos[8]);
                                                     emailMSC.setText((String)Datos[10]);
                                                       
               }
                                                                                                              }//GEN-LAST:event_noEstacionMSCKeyPressed

/*
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    }//GEN-LAST:event_jButton1ActionPerformed

    private void noEstacionMSCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_noEstacionMSCKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_noEstacionMSCKeyTyped
/**/
    }
    
        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                
            String  Foliodesolicitud,Tipodesolicitud,Fecha2, NoEstacion,/*Usuario,*/FechaPropuesta2;
 String ReferenciadeSolicitud,Observaciones,Tecnico;
 String   total_mangueras;

 Foliodesolicitud=foliosolicitudMSC.getText();
 Tipodesolicitud=(String)tiposolicitudMSC.getSelectedItem();
 
     Date  fecha=fechaMSC.getDate();
       DateFormat f=new SimpleDateFormat("dd-MM-yyyy");
       Fecha2=f.format(fecha);
       
       Date FechaPropuesta=fechaPropuestaMSC.getDate();
       DateFormat F=new SimpleDateFormat("dd-MM-yyyy");
       FechaPropuesta2=F.format(FechaPropuesta);
       
       
 
 NoEstacion=noEstacionMSC.getText();
 
 
 ReferenciadeSolicitud=referenciaSolicitudMSC.getText();
    Observaciones=observacionesMSC.getText();
    Tecnico=tecnicoMSC.getText();
    
    total_mangueras=manguerasaVerificarMSC.getText();
    
    
    lbd.openConnection();
    
    lbd.modificarDatosSolicitud(Foliodesolicitud, Usuario, Tecnico, Fecha2, FechaPropuesta2, Tipodesolicitud,NoEstacion,total_mangueras,ReferenciadeSolicitud,Observaciones);
    
    
    lbd.closeConnection();
            
    }                
        
          private void noEstacionMSCKeyTyped(java.awt.event.KeyEvent evt) {                                       
char solonumero=evt.getKeyChar();

//if(Character.isLetter(solonumero)){
//getToolkit().beep();
//evt.consume();
//JOptionPane.showMessageDialog(rootPane, "Ingresar solo numeros");}
          }
        
        
        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField diselMSC;
    private javax.swing.JTextField domicilioMSC;
    private javax.swing.JTextField emailMSC;
    private javax.swing.JTextField estacionMSC;
    private javax.swing.JTextField estadoMSC;
    private com.toedter.calendar.JDateChooser fechaMSC;
    private com.toedter.calendar.JDateChooser fechaPropuestaMSC;
    private javax.swing.JTextField foliosolicitudMSC;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField magnaMSC;
    private javax.swing.JTextField manguerasaVerificarMSC;
    private javax.swing.JTextField noEstacionMSC;
    private javax.swing.JTextField nombreSolicitanteMSC;
    private javax.swing.JTextField observacionesMSC;
    private javax.swing.JTextField premiumMSC;
    private javax.swing.JTextField razonSocialMSC;
    private javax.swing.JTextField referenciaSolicitudMSC;
    private javax.swing.JTextField regfedCausantesMSC;
    private javax.swing.JTextField tecnicoMSC;
    private javax.swing.JTextField tecnicoMSC1;
    private javax.swing.JTextField telefonoMSC;
    private javax.swing.JComboBox<String> tiposolicitudMSC;
    // End of variables declaration//GEN-END:variables
}