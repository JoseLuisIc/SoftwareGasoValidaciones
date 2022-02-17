/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Hologramas;

import javax.swing.JOptionPane;
import Controlador.LibreriaBDControlador;
import javax.swing.ImageIcon;
//import java.sql.*;


/**
 *
 * @author Saul
 */
public class GeneradorDeCalcomonia extends javax.swing.JDialog {
      
    
    

    /**
     * Creates new form AgregarCatalogoDeHologramas
     */
    public GeneradorDeCalcomonia(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Multimedia/icono_GasValid.jpg")).getImage());
        
                          PROFECOGDC.setSelected(true);

    }
    
        
 
    //Saul Arenas Ramirez 8/07/2020


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoProfecoUvaCDC = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        LetraGDC = new javax.swing.JTextField();
        FolioInicialGDC = new javax.swing.JTextField();
        FoloFinalGDC = new javax.swing.JTextField();
        PROFECOGDC = new javax.swing.JRadioButton();
        UVAGDC = new javax.swing.JRadioButton();
        GuardarGDC = new javax.swing.JButton();
        AnioGDC = new javax.swing.JComboBox<>();
        TipodeVerificacionGDC = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        CEROSADICIONALESGDC = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Generador Calcomanía");
        setMinimumSize(new java.awt.Dimension(388, 447));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jLabel1.setText("Letra");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jLabel2.setText("Año");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jLabel3.setText("Tipo de verificación");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jLabel4.setText("Folio Inicial");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jLabel5.setText("Folio Final");

        LetraGDC.setBackground(new java.awt.Color(204, 255, 255));
        LetraGDC.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        LetraGDC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LetraGDCActionPerformed(evt);
            }
        });
        LetraGDC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                LetraGDCKeyTyped(evt);
            }
        });

        FolioInicialGDC.setBackground(new java.awt.Color(204, 255, 255));
        FolioInicialGDC.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        FolioInicialGDC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FolioInicialGDCKeyTyped(evt);
            }
        });

        FoloFinalGDC.setBackground(new java.awt.Color(204, 255, 255));
        FoloFinalGDC.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        FoloFinalGDC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FoloFinalGDCKeyTyped(evt);
            }
        });

        GrupoProfecoUvaCDC.add(PROFECOGDC);
        PROFECOGDC.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        PROFECOGDC.setText("PROFECO");
        PROFECOGDC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PROFECOGDCActionPerformed(evt);
            }
        });

        GrupoProfecoUvaCDC.add(UVAGDC);
        UVAGDC.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        UVAGDC.setText("UVA");

        GuardarGDC.setBackground(new java.awt.Color(0, 153, 102));
        GuardarGDC.setFont(new java.awt.Font("Arial Black", 0, 13)); // NOI18N
        GuardarGDC.setForeground(new java.awt.Color(0, 102, 0));
        GuardarGDC.setText("Guardar");
        GuardarGDC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarGDCActionPerformed(evt);
            }
        });

        AnioGDC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AnioGDC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050" }));

        TipodeVerificacionGDC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TipodeVerificacionGDC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "021", "022", "023" }));
        TipodeVerificacionGDC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TipodeVerificacionGDCActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jLabel6.setText("0's adicionales");

        CEROSADICIONALESGDC.setBackground(new java.awt.Color(204, 255, 255));
        CEROSADICIONALESGDC.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        CEROSADICIONALESGDC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CEROSADICIONALESGDCKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(AnioGDC, 0, 141, Short.MAX_VALUE)
                            .addComponent(LetraGDC)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(PROFECOGDC)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(UVAGDC))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TipodeVerificacionGDC, 0, 141, Short.MAX_VALUE)
                                    .addComponent(FoloFinalGDC)
                                    .addComponent(FolioInicialGDC)
                                    .addComponent(CEROSADICIONALESGDC)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(GuardarGDC, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(LetraGDC, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(AnioGDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TipodeVerificacionGDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(CEROSADICIONALESGDC, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(FolioInicialGDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(FoloFinalGDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(PROFECOGDC)
                        .addGap(18, 18, 18)
                        .addComponent(UVAGDC)
                        .addContainerGap(32, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(GuardarGDC, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
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

    private void LetraGDCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LetraGDCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LetraGDCActionPerformed

    private void GuardarGDCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarGDCActionPerformed
//Saul Arenas Ramirez 8/07/2020

//Abrir la conexion
LibreriaBDControlador lbc= new LibreriaBDControlador();

lbc.openConnection();



     // para guardar los datos que ya esten ingresados
  String  letra,anio,tipo,ceros,folioinicial,foliofinal,profOuva,HOLOGRAMA;
  //String  sql="";
   
  letra=LetraGDC.getText();
  anio=(String) AnioGDC.getSelectedItem();
  tipo=(String) TipodeVerificacionGDC.getSelectedItem();
  ceros=CEROSADICIONALESGDC.getText();
  folioinicial=FolioInicialGDC.getText();
  foliofinal=FoloFinalGDC.getText();

  if (PROFECOGDC.isSelected()){
  profOuva="PROFECO";}
  else {profOuva="UVA";}
 
  //convertir de string a enteros los folios
 int folioinicialI=Integer.parseInt(folioinicial);
 int foliofinalI=Integer.parseInt(foliofinal);
 int folioincorrecto=0;
 
 if(folioinicialI>foliofinalI){
 JOptionPane.showMessageDialog(rootPane, "Atencion El folio inicial es mayor que el final");
 folioincorrecto=1;
 }
 
while(folioinicialI<=foliofinalI){
HOLOGRAMA=(letra+anio+tipo+ceros+folioinicialI);
folioinicialI++;

//mandar los datos a la base de datos
lbc.insertarHologramas(HOLOGRAMA, profOuva);
    System.out.println(HOLOGRAMA);
}
//CIERRA LA CONEXION
lbc.closeConnection();

if (folioincorrecto==0){
JOptionPane.showMessageDialog(rootPane, "Guardado exitosamente");
}
  

    }//GEN-LAST:event_GuardarGDCActionPerformed

    private void TipodeVerificacionGDCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TipodeVerificacionGDCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TipodeVerificacionGDCActionPerformed

    private void PROFECOGDCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PROFECOGDCActionPerformed
  // TODO add your handling code here:
    }//GEN-LAST:event_PROFECOGDCActionPerformed

    private void LetraGDCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LetraGDCKeyTyped
//Saul Arenas Ramirez 07/8/2020
        char sololetra=evt.getKeyChar();
if (Character.isDigit(sololetra)){
getToolkit().beep();
evt.consume();
    JOptionPane.showMessageDialog(rootPane, "Ingresar solo letras");}


    }//GEN-LAST:event_LetraGDCKeyTyped

    private void CEROSADICIONALESGDCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CEROSADICIONALESGDCKeyTyped
char soloceros=evt.getKeyChar();

if(Character.isLetter(soloceros)){
getToolkit().beep();
evt.consume();
JOptionPane.showMessageDialog(rootPane, "Ingresar solo numeros");}
    }//GEN-LAST:event_CEROSADICIONALESGDCKeyTyped

    private void FolioInicialGDCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FolioInicialGDCKeyTyped
char solofolioinicial=evt.getKeyChar();

if(Character.isLetter(solofolioinicial)){
getToolkit().beep();
evt.consume();
JOptionPane.showMessageDialog(rootPane, "Ingresar solo numeros");}    }//GEN-LAST:event_FolioInicialGDCKeyTyped

    private void FoloFinalGDCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FoloFinalGDCKeyTyped
char solofoliofinal=evt.getKeyChar();

if(Character.isLetter(solofoliofinal)){
getToolkit().beep();
evt.consume();
JOptionPane.showMessageDialog(rootPane, "Ingrese solo numeros");}}/*
JOptionPane.showMessageDialog(rootPane, "Ingresar solo numeros");}JOptionPane.showMessageDialog(rootPane, "Ingresar solo numeros");}JOptionPane.showMessageDialog(rootPane, "Ingresar solo numeros");}    }//GEN-LAST:event_FoloFinalGDCKeyTyped
*/
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> AnioGDC;
    private javax.swing.JTextField CEROSADICIONALESGDC;
    private javax.swing.JTextField FolioInicialGDC;
    private javax.swing.JTextField FoloFinalGDC;
    private javax.swing.ButtonGroup GrupoProfecoUvaCDC;
    private javax.swing.JButton GuardarGDC;
    private javax.swing.JTextField LetraGDC;
    private javax.swing.JRadioButton PROFECOGDC;
    private javax.swing.JComboBox<String> TipodeVerificacionGDC;
    private javax.swing.JRadioButton UVAGDC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}