/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.InspeccionDeMedicion;

import Controlador.LibreriaBDControlador;
import Controlador.colorTabla;
import Controlador.reportesWord;
import Modelo.modeloTablaUsuario;
import java.awt.Component;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

/**
 *
 * @author Jose Luis
 */
public class catalogoInspeccionDeMedicion extends javax.swing.JFrame {
    LibreriaBDControlador lbd = new LibreriaBDControlador();
    modeloTablaUsuario mtu = new modeloTablaUsuario();
    reportesWord reporteWord = new reportesWord();
    colorTabla colorT = new colorTabla(0,0);
    /**
     * Creates new form catalogoInspeccionDeMedicion
     */
    public catalogoInspeccionDeMedicion() {
        
        initComponents();
//        // Indicamos como sera el resaltado de la tabla
//        jTable1.setDefaultRenderer(Object.class, colorT);
//        colorT.setColumna(0);
//        colorT.setColumna(2);
//        //colorT.setColumna(2);
         //lleno el combo de termometros
         lbd.openConnection();
         List <String> listaAux = lbd.obtenerTermometros(2,"");
         String [] lista = new String[listaAux.size()];
         lista = listaAux.toArray(lista);        
         jComboBoxTermometro.setModel((new javax.swing.DefaultComboBoxModel<>(lista)));
         String item_seleccionado = jComboBoxTermometro.getSelectedItem().toString();
         listaAux = lbd.obtenerTermometros(1,item_seleccionado);
         datosTermometro.setText(listaAux.toString());
         //lleno el combo de cronometros
         listaAux = lbd.obtenerCronometros(2,"");
         lista = new String[listaAux.size()];
         lista = listaAux.toArray(lista);        
         jComboBoxCronometro.setModel((new javax.swing.DefaultComboBoxModel<>(lista)));
         item_seleccionado = jComboBoxCronometro.getSelectedItem().toString();
         listaAux = lbd.obtenerCronometros(1,item_seleccionado);
         datosCronometro.setText(listaAux.toString());
         //lleno los combos jarra
         lbd.closeConnection();
         //lleno la hora
         Date fecha = new Date();
         jDateChooserFechaIM.setDate(fecha);
entraonoentra();
operacionesdeInspeccionMedicion();
    }
    //SAR 12/04/21 INI
    private void entraonoentra(){
         if(jRadioButton21.isSelected()&&jRadioButton24.isSelected()&&jRadioButton26.isSelected()&&jRadioButton28.isSelected()&&jRadioButton30.isSelected()&&jRadioButton32.isSelected()&&jRadioButton34.isSelected()&&jRadioButton36.isSelected()&&jRadioButton38.isSelected()){
         entraraMangueras();
         }  else{
             bloquearaMangueras();}
    }
    
    private   void entraraMangueras() {
              //mangueraA
               for(Component aM:jPanel2.getComponents()) {
aM.setEnabled(true);
}               for(Component bM:jPanel12.getComponents()) {
bM.setEnabled(true);
}               for(Component cM:jPanel13.getComponents()) {
cM.setEnabled(true);
}               for(Component dM:jPanel14.getComponents()) {
dM.setEnabled(true);
}
      //mangueraB
               for(Component eM:jPanel16.getComponents()) {
eM.setEnabled(true);
}               for(Component fM:jPanel17.getComponents()) {
fM.setEnabled(true);
}               for(Component gM:jPanel18.getComponents()) {
gM.setEnabled(true);
}               for(Component hM:jPanel20.getComponents()) {
hM.setEnabled(true);
}
      //mangueraC
               for(Component iM:jPanel21.getComponents()) {
iM.setEnabled(true);
}               for(Component jM:jPanel22.getComponents()) {
jM.setEnabled(true);
}               for(Component kM:jPanel23.getComponents()) {
kM.setEnabled(true);
}               for(Component lM:jPanel25.getComponents()) {
lM.setEnabled(true);
}
      //mangueraD
               for(Component mM:jPanel26.getComponents()) {
mM.setEnabled(true);
}               for(Component nM:jPanel27.getComponents()) {
nM.setEnabled(true);
}               for(Component oM:jPanel28.getComponents()) {
oM.setEnabled(true);
}               for(Component pM:jPanel30.getComponents()) {
pM.setEnabled(true);
}
      //mangueraE
               for(Component qM:jPanel31.getComponents()) {
qM.setEnabled(true);
}               for(Component rM:jPanel32.getComponents()) {
rM.setEnabled(true);
}               for(Component sM:jPanel33.getComponents()) {
sM.setEnabled(true);
}               for(Component tM:jPanel35.getComponents()) {
tM.setEnabled(true);
}
      //mangueraF
               for(Component uM:jPanel36.getComponents()) {
uM.setEnabled(true);
}               for(Component vM:jPanel37.getComponents()) {
vM.setEnabled(true);
}               for(Component wM:jPanel38.getComponents()) {
wM.setEnabled(true);
}               for(Component xM:jPanel40.getComponents()) {
xM.setEnabled(true);
}
    }
    
    private void bloquearaMangueras(){
          //mangueraA
               for(Component aB:jPanel2.getComponents()) {
aB.setEnabled(false);
}               for(Component bB:jPanel12.getComponents()) {
bB.setEnabled(false);
}               for(Component cB:jPanel13.getComponents()) {
cB.setEnabled(false);
}               for(Component dB:jPanel14.getComponents()) {
dB.setEnabled(false);
}
      //mangueraB
               for(Component eB:jPanel16.getComponents()) {
eB.setEnabled(false);
}               for(Component fB:jPanel17.getComponents()) {
fB.setEnabled(false);
}               for(Component gB:jPanel18.getComponents()) {
gB.setEnabled(false);
}               for(Component hB:jPanel20.getComponents()) {
hB.setEnabled(false);
}
      //mangueraC
               for(Component iB:jPanel21.getComponents()) {
iB.setEnabled(false);
}               for(Component jB:jPanel22.getComponents()) {
jB.setEnabled(false);
}               for(Component kB:jPanel23.getComponents()) {
kB.setEnabled(false);
}               for(Component lB:jPanel25.getComponents()) {
lB.setEnabled(false);
}
      //mangueraD
               for(Component mB:jPanel26.getComponents()) {
mB.setEnabled(false);
}               for(Component nB:jPanel27.getComponents()) {
nB.setEnabled(false);
}               for(Component oB:jPanel28.getComponents()) {
oB.setEnabled(false);
}               for(Component pB:jPanel30.getComponents()) {
pB.setEnabled(false);
}
      //mangueraE
               for(Component qB:jPanel31.getComponents()) {
qB.setEnabled(false);
}               for(Component rB:jPanel32.getComponents()) {
rB.setEnabled(false);
}               for(Component sB:jPanel33.getComponents()) {
sB.setEnabled(false);
}               for(Component tB:jPanel35.getComponents()) {
tB.setEnabled(false);
}
      //mangueraF
               for(Component uB:jPanel36.getComponents()) {
uB.setEnabled(false);
}               for(Component vB:jPanel37.getComponents()) {
vB.setEnabled(false);
}               for(Component wB:jPanel38.getComponents()) {
wB.setEnabled(false);
}               for(Component xB:jPanel40.getComponents()) {
xB.setEnabled(false);
}
    }
        //SAR 12/04/21 FIN
    
    //SAR 13/04/21 INI
    private void operacionesdeInspeccionMedicion(){
      //MANGUERA A  
     double  ap1maxI,ap2maxI,ap3maxI,ap1medI,ap2medI,ap3medI,ap1minI,ap2minI,ap3minI, alcprommax,alcprommed,alcprommin;
//Prueba maximo
     ap1maxI= Double.parseDouble(this.AP1MAX.getText());
      ap2maxI= Double.parseDouble(this.AP2MAX.getText());
       ap3maxI=Double.parseDouble(this.AP3MAX.getText());
    alcprommax=Math.round((  (ap1maxI+ap2maxI+ap3maxI)/3)*100.0)/100.0;
    //LC max
    ALCMAX.setText(String.valueOf(alcprommax));
    //Prueba medio
     ap1medI= Double.parseDouble(this.AP1MED.getText());
      ap2medI= Double.parseDouble(this.AP2MED.getText());
       ap3medI= Double.parseDouble(this.AP3MED.getText());
    alcprommed= Math.round(((ap1medI+ap2medI+ap3medI)/3)*100.0)/100.0;
        //LC med
    ALCMED.setText(String.valueOf(alcprommed));
    
        //Prueba minimo
     ap1minI= Double.parseDouble(this.AP1MIN.getText());
      ap2minI= Double.parseDouble(this.AP2MIN.getText());
       ap3minI= Double.parseDouble(this.AP3MIN.getText());
    alcprommin= Math.round(((ap1minI+ap2minI+ap3minI)/3)*100.0)/100.0;
        //LC min
    ALCMIN.setText(String.valueOf(alcprommin));
    
    
    //CTS
    double actsmaxp1,actsmaxp2,actsmaxp3,actsmedp1,actsmedp2,actsmedp3,actsminp1,actsminp2,actsminp3;
    double atmaxp1,atmaxp2,atmaxp3,atmedp1,atmedp2,atmedp3,atminp1,atminp2,atminp3;
    double actsmaxprom,actsmedprom,actsminprom;

  atmaxp1=Double.parseDouble(this.ATMAXP1.getText());
    actsmaxp1=1+(0.0000477)*(atmaxp1-20);
        atmaxp2=Double.parseDouble(this.ATMAXP2.getText());
    actsmaxp2=1+(0.0000477)*(atmaxp2-20);
        atmaxp3=Double.parseDouble(this.ATMAXP3.getText());
    actsmaxp3=1+(0.0000477)*(atmaxp3-20);
    
    actsmaxprom=(actsmaxp1+actsmaxp2+actsmaxp3)/3;
        System.out.println("CTS maximo promedio MA "+actsmaxprom);
    
        atmedp1=Double.parseDouble(this.ATMEDP1.getText());
    actsmedp1=1+(0.0000477)*(atmedp1-20);
        atmedp2=Double.parseDouble(this.ATMEDP2.getText());
    actsmedp2=1+(0.0000477)*(atmedp2-20);
        atmedp3=Double.parseDouble(this.ATMEDP3.getText());
    actsmedp3=1+(0.0000477)*(atmedp3-20);
    
        actsmedprom=(actsmedp1+actsmedp2+actsmedp3)/3;
            System.out.println("CTS medio promedio MA "+actsmedprom);
            
        atminp1=Double.parseDouble(this.ATMINP1.getText());
    actsminp1=1+(0.0000477)*(atminp1-20);
        atminp2=Double.parseDouble(this.ATMINP2.getText());
    actsminp2=1+(0.0000477)*(atminp2-20);
        atminp3=Double.parseDouble(this.ATMINP3.getText());
    actsminp3=1+(0.0000477)*(atminp3-20);
    
        actsminprom=(actsminp1+actsminp2+actsminp3)/3;
        System.out.println("CTS minimo promedio MA "+actsminprom);
        
        //VCMV
        double  av20,akc ,avcmvmax,avcmvmed,avcmvmin;
        av20=Double.parseDouble(this.AV20.getText());
        akc=Double.parseDouble(this.AKC.getText());

        avcmvmax=Math.round((av20+alcprommax*akc*actsmaxprom)*100.0)/100.0;
        System.out.println("VCMV maximo promedio MA "+avcmvmax);
        avcmvmed=Math.round((av20+alcprommed*akc*actsmedprom)*100.0)/100.0;
                System.out.println("VCMV medio promedio MA "+avcmvmed);
        avcmvmin=Math.round((av20+alcprommin*akc*actsminprom)*100.0)/100.0;
                System.out.println("VCMV minimo promedio MA "+avcmvmin);
        
        
            AVCMVMAX.setText(String.valueOf(avcmvmax));
             AVCMVMED.setText(String.valueOf(avcmvmed));
             AVCMVMIN.setText(String.valueOf(avcmvmin));
    //------------------------------------------------------------------------------
          //MANGUERA B  
     double  bp1maxI,bp2maxI,bp3maxI,bp1medI,bp2medI,bp3medI,bp1minI,bp2minI,bp3minI, blcprommax,blcprommed,blcprommin;
//Prueba maximo
     bp1maxI= Double.parseDouble(this.BP1MAX.getText());
      bp2maxI= Double.parseDouble(this.BP2MAX.getText());
       bp3maxI=Double.parseDouble(this.BP3MAX.getText());
    blcprommax=Math.round((  (bp1maxI+bp2maxI+bp3maxI)/3)*100.0)/100.0;
    //LC max
    BLCMAX.setText(String.valueOf(blcprommax));
    //Prueba medio
     bp1medI= Double.parseDouble(this.BP1MED.getText());
      bp2medI= Double.parseDouble(this.BP2MED.getText());
       bp3medI= Double.parseDouble(this.BP3MED.getText());
    blcprommed= Math.round(((bp1medI+bp2medI+bp3medI)/3)*100.0)/100.0;
        //LC med
    BLCMED.setText(String.valueOf(blcprommed));
    
        //Prueba minimo
     bp1minI= Double.parseDouble(this.BP1MIN.getText());
      bp2minI= Double.parseDouble(this.BP2MIN.getText());
       bp3minI= Double.parseDouble(this.BP3MIN.getText());
    blcprommin= Math.round(((bp1minI+bp2minI+bp3minI)/3)*100.0)/100.0;
        //LC min
    BLCMIN.setText(String.valueOf(blcprommin));
    
    
    //CTS
    double  bctsmaxp1,bctsmaxp2,bctsmaxp3,bctsmedp1,bctsmedp2,bctsmedp3,bctsminp1,bctsminp2,bctsminp3;
    double btmaxp1,btmaxp2,btmaxp3,btmedp1,btmedp2,btmedp3,btminp1,btminp2,btminp3;
    double bctsmaxprom,bctsmedprom,bctsminprom;

  btmaxp1=Double.parseDouble(this.BTMAXP1.getText());
    bctsmaxp1=1+(0.0000477)*(btmaxp1-20);
        btmaxp2=Double.parseDouble(this.BTMAXP2.getText());
    bctsmaxp2=1+(0.0000477)*(btmaxp2-20);
        btmaxp3=Double.parseDouble(this.BTMAXP3.getText());
    bctsmaxp3=1+(0.0000477)*(btmaxp3-20);
    
    bctsmaxprom=(bctsmaxp1+bctsmaxp2+bctsmaxp3)/3;
        System.out.println("CTS maximo promedio MB "+bctsmaxprom);
    
        btmedp1=Double.parseDouble(this.BTMEDP1.getText());
    bctsmedp1=1+(0.0000477)*(btmedp1-20);
        btmedp2=Double.parseDouble(this.BTMEDP2.getText());
    bctsmedp2=1+(0.0000477)*(btmedp2-20);
        btmedp3=Double.parseDouble(this.BTMEDP3.getText());
    bctsmedp3=1+(0.0000477)*(btmedp3-20);
    
        bctsmedprom=(bctsmedp1+bctsmedp2+bctsmedp3)/3;
            System.out.println("CTS medio promedio MB "+bctsmedprom);
            
        btminp1=Double.parseDouble(this.BTMINP1.getText());
    bctsminp1=1+(0.0000477)*(btminp1-20);
        btminp2=Double.parseDouble(this.BTMINP2.getText());
    bctsminp2=1+(0.0000477)*(btminp2-20);
        btminp3=Double.parseDouble(this.BTMINP3.getText());
    bctsminp3=1+(0.0000477)*(btminp3-20);
    
        bctsminprom=(bctsminp1+bctsminp2+bctsminp3)/3;
        System.out.println("CTS minimo promedio MB "+bctsminprom);
        
        //VCMV
        double  bv20,bkc ,bvcmvmax,bvcmvmed,bvcmvmin;
        bv20=Double.parseDouble(this.BV20.getText());
        bkc=Double.parseDouble(this.BKC.getText());

        bvcmvmax=Math.round((bv20+blcprommax*bkc*bctsmaxprom)*100.0)/100.0;
        System.out.println("VCMV maximo promedio MB "+bvcmvmax);
        bvcmvmed=Math.round((bv20+blcprommed*bkc*bctsmedprom)*100.0)/100.0;
                System.out.println("VCMV medio promedio MB "+bvcmvmed);
        bvcmvmin=Math.round((bv20+blcprommin*bkc*bctsminprom)*100.0)/100.0;
                System.out.println("VCMV minimo promedio MB "+bvcmvmin);
        
        
            BVCMVMAX.setText(String.valueOf(bvcmvmax));
             BVCMVMED.setText(String.valueOf(bvcmvmed));
             BVCMVMIN.setText(String.valueOf(bvcmvmin));
    //------------------------------------------------------------------------------
    }
        //SAR 13/04/21 FIN
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        A = new javax.swing.ButtonGroup();
        B = new javax.swing.ButtonGroup();
        C = new javax.swing.ButtonGroup();
        D = new javax.swing.ButtonGroup();
        E = new javax.swing.ButtonGroup();
        F = new javax.swing.ButtonGroup();
        G = new javax.swing.ButtonGroup();
        H = new javax.swing.ButtonGroup();
        I = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        folioSolicitud = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButtonImprimir = new javax.swing.JButton();
        jCheckBoxImprimir = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        campoEstacion = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jComboBoxCronometro = new javax.swing.JComboBox<>();
        jComboBoxDispensarios = new javax.swing.JComboBox<>();
        jComboBoxTermometro = new javax.swing.JComboBox<>();
        jTextField3 = new javax.swing.JTextField();
        datosTermometro = new javax.swing.JTextField();
        datosCronometro = new javax.swing.JTextField();
        jDateChooserFechaIM = new com.toedter.calendar.JDateChooser();
        jButton2 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        verificacionVisual = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        jRadioButton25 = new javax.swing.JRadioButton();
        jRadioButton26 = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jRadioButton21 = new javax.swing.JRadioButton();
        jRadioButton22 = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jRadioButton23 = new javax.swing.JRadioButton();
        jRadioButton24 = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        jRadioButton27 = new javax.swing.JRadioButton();
        jRadioButton28 = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jRadioButton29 = new javax.swing.JRadioButton();
        jRadioButton30 = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jRadioButton31 = new javax.swing.JRadioButton();
        jRadioButton32 = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        jRadioButton33 = new javax.swing.JRadioButton();
        jRadioButton34 = new javax.swing.JRadioButton();
        jLabel15 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jRadioButton35 = new javax.swing.JRadioButton();
        jRadioButton36 = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        jRadioButton37 = new javax.swing.JRadioButton();
        jRadioButton38 = new javax.swing.JRadioButton();
        jLabel17 = new javax.swing.JLabel();
        mangueraA = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        AP1MAX = new javax.swing.JTextField();
        AP1MED = new javax.swing.JTextField();
        AP1MIN = new javax.swing.JTextField();
        AP2MIN = new javax.swing.JTextField();
        AP2MAX = new javax.swing.JTextField();
        AP2MED = new javax.swing.JTextField();
        AP3MIN = new javax.swing.JTextField();
        AP3MED = new javax.swing.JTextField();
        AP3MAX = new javax.swing.JTextField();
        ALCMAX = new javax.swing.JTextField();
        ALCMED = new javax.swing.JTextField();
        ALCMIN = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        ATMEDP1 = new javax.swing.JTextField();
        ATMEDP2 = new javax.swing.JTextField();
        ATMEDP3 = new javax.swing.JTextField();
        ATMAXP3 = new javax.swing.JTextField();
        ATMINP1 = new javax.swing.JTextField();
        ATMINP3 = new javax.swing.JTextField();
        ATMAXP2 = new javax.swing.JTextField();
        ATMINP2 = new javax.swing.JTextField();
        ATMAXP1 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jTextField30 = new javax.swing.JTextField();
        jTextField31 = new javax.swing.JTextField();
        jTextField32 = new javax.swing.JTextField();
        jTextField33 = new javax.swing.JTextField();
        jTextField34 = new javax.swing.JTextField();
        jTextField35 = new javax.swing.JTextField();
        jTextField36 = new javax.swing.JTextField();
        jTextField37 = new javax.swing.JTextField();
        jTextField38 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jTextField39 = new javax.swing.JTextField();
        jTextField40 = new javax.swing.JTextField();
        jTextField41 = new javax.swing.JTextField();
        jTextField42 = new javax.swing.JTextField();
        jTextField43 = new javax.swing.JTextField();
        jTextField44 = new javax.swing.JTextField();
        jTextField45 = new javax.swing.JTextField();
        jTextField46 = new javax.swing.JTextField();
        jTextField47 = new javax.swing.JTextField();
        jTextField48 = new javax.swing.JTextField();
        jTextField49 = new javax.swing.JTextField();
        jTextField50 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jTextField53 = new javax.swing.JTextField();
        jTextField54 = new javax.swing.JTextField();
        AV20 = new javax.swing.JTextField();
        AKC = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jComboBoxJarraA = new javax.swing.JComboBox<>();
        jPanel13 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jTextField64 = new javax.swing.JTextField();
        jTextField67 = new javax.swing.JTextField();
        jTextField68 = new javax.swing.JTextField();
        jTextField69 = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        AVCMVMIN = new javax.swing.JTextField();
        AVCMVMED = new javax.swing.JTextField();
        AVCMVMAX = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jTextField58 = new javax.swing.JTextField();
        jTextField59 = new javax.swing.JTextField();
        jTextField60 = new javax.swing.JTextField();
        jTextField61 = new javax.swing.JTextField();
        jTextField62 = new javax.swing.JTextField();
        jTextField63 = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jTextField65 = new javax.swing.JTextField();
        jTextField66 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        mangueraA1 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        BP1MAX = new javax.swing.JTextField();
        BP1MED = new javax.swing.JTextField();
        BP1MIN = new javax.swing.JTextField();
        BP2MIN = new javax.swing.JTextField();
        BP2MAX = new javax.swing.JTextField();
        BP2MED = new javax.swing.JTextField();
        BP3MIN = new javax.swing.JTextField();
        BP3MED = new javax.swing.JTextField();
        BP3MAX = new javax.swing.JTextField();
        BLCMAX = new javax.swing.JTextField();
        BLCMED = new javax.swing.JTextField();
        BLCMIN = new javax.swing.JTextField();
        jTextField82 = new javax.swing.JTextField();
        jTextField83 = new javax.swing.JTextField();
        jTextField84 = new javax.swing.JTextField();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        BTMEDP1 = new javax.swing.JTextField();
        BTMEDP2 = new javax.swing.JTextField();
        BTMEDP3 = new javax.swing.JTextField();
        BTMAXP3 = new javax.swing.JTextField();
        BTMINP1 = new javax.swing.JTextField();
        BTMINP3 = new javax.swing.JTextField();
        BTMAXP2 = new javax.swing.JTextField();
        BTMINP2 = new javax.swing.JTextField();
        BTMAXP1 = new javax.swing.JTextField();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jTextField94 = new javax.swing.JTextField();
        jTextField95 = new javax.swing.JTextField();
        jTextField96 = new javax.swing.JTextField();
        jTextField97 = new javax.swing.JTextField();
        jTextField98 = new javax.swing.JTextField();
        jTextField99 = new javax.swing.JTextField();
        jTextField100 = new javax.swing.JTextField();
        jTextField101 = new javax.swing.JTextField();
        jTextField102 = new javax.swing.JTextField();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jTextField103 = new javax.swing.JTextField();
        jTextField104 = new javax.swing.JTextField();
        jTextField105 = new javax.swing.JTextField();
        jTextField106 = new javax.swing.JTextField();
        jTextField107 = new javax.swing.JTextField();
        jTextField108 = new javax.swing.JTextField();
        jTextField109 = new javax.swing.JTextField();
        jTextField110 = new javax.swing.JTextField();
        jTextField111 = new javax.swing.JTextField();
        jTextField112 = new javax.swing.JTextField();
        jTextField113 = new javax.swing.JTextField();
        jTextField114 = new javax.swing.JTextField();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel107 = new javax.swing.JLabel();
        jTextField115 = new javax.swing.JTextField();
        jTextField116 = new javax.swing.JTextField();
        BV20 = new javax.swing.JTextField();
        BKC = new javax.swing.JTextField();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jComboBoxJarraB = new javax.swing.JComboBox<>();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jTextField119 = new javax.swing.JTextField();
        jTextField120 = new javax.swing.JTextField();
        jTextField121 = new javax.swing.JTextField();
        jTextField122 = new javax.swing.JTextField();
        jPanel20 = new javax.swing.JPanel();
        BVCMVMIN = new javax.swing.JTextField();
        BVCMVMED = new javax.swing.JTextField();
        BVCMVMAX = new javax.swing.JTextField();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jTextField126 = new javax.swing.JTextField();
        jTextField127 = new javax.swing.JTextField();
        jTextField128 = new javax.swing.JTextField();
        jTextField129 = new javax.swing.JTextField();
        jTextField130 = new javax.swing.JTextField();
        jTextField131 = new javax.swing.JTextField();
        jLabel121 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jTextField132 = new javax.swing.JTextField();
        jTextField133 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        mangueraA2 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        CP1MAX = new javax.swing.JTextField();
        CP1MED = new javax.swing.JTextField();
        CP1MIN = new javax.swing.JTextField();
        CP2MIN = new javax.swing.JTextField();
        CP2MAX = new javax.swing.JTextField();
        CP2MED = new javax.swing.JTextField();
        CP3MIN = new javax.swing.JTextField();
        CP3MED = new javax.swing.JTextField();
        CP3MAX = new javax.swing.JTextField();
        CLCMAX = new javax.swing.JTextField();
        CLCMED = new javax.swing.JTextField();
        CLCMIN = new javax.swing.JTextField();
        jTextField146 = new javax.swing.JTextField();
        jTextField147 = new javax.swing.JTextField();
        jTextField148 = new javax.swing.JTextField();
        jLabel135 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        CTMEDP1 = new javax.swing.JTextField();
        CTMEDP2 = new javax.swing.JTextField();
        CTMEDP3 = new javax.swing.JTextField();
        CTMAXP3 = new javax.swing.JTextField();
        CTMINP1 = new javax.swing.JTextField();
        CTMINP3 = new javax.swing.JTextField();
        CTMAXP2 = new javax.swing.JTextField();
        CTMINP2 = new javax.swing.JTextField();
        CTMAXP1 = new javax.swing.JTextField();
        jLabel138 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        jLabel143 = new javax.swing.JLabel();
        jLabel144 = new javax.swing.JLabel();
        jLabel145 = new javax.swing.JLabel();
        jLabel146 = new javax.swing.JLabel();
        jTextField158 = new javax.swing.JTextField();
        jTextField159 = new javax.swing.JTextField();
        jTextField160 = new javax.swing.JTextField();
        jTextField161 = new javax.swing.JTextField();
        jTextField162 = new javax.swing.JTextField();
        jTextField163 = new javax.swing.JTextField();
        jTextField164 = new javax.swing.JTextField();
        jTextField165 = new javax.swing.JTextField();
        jTextField166 = new javax.swing.JTextField();
        jLabel147 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        jLabel149 = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        jLabel151 = new javax.swing.JLabel();
        jLabel152 = new javax.swing.JLabel();
        jLabel153 = new javax.swing.JLabel();
        jTextField167 = new javax.swing.JTextField();
        jTextField168 = new javax.swing.JTextField();
        jTextField169 = new javax.swing.JTextField();
        jTextField170 = new javax.swing.JTextField();
        jTextField171 = new javax.swing.JTextField();
        jTextField172 = new javax.swing.JTextField();
        jTextField173 = new javax.swing.JTextField();
        jTextField174 = new javax.swing.JTextField();
        jTextField175 = new javax.swing.JTextField();
        jTextField176 = new javax.swing.JTextField();
        jTextField177 = new javax.swing.JTextField();
        jTextField178 = new javax.swing.JTextField();
        jLabel154 = new javax.swing.JLabel();
        jLabel155 = new javax.swing.JLabel();
        jLabel156 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel157 = new javax.swing.JLabel();
        jTextField179 = new javax.swing.JTextField();
        jTextField180 = new javax.swing.JTextField();
        CV20 = new javax.swing.JTextField();
        CKC = new javax.swing.JTextField();
        jLabel158 = new javax.swing.JLabel();
        jLabel159 = new javax.swing.JLabel();
        jLabel160 = new javax.swing.JLabel();
        jLabel161 = new javax.swing.JLabel();
        jLabel162 = new javax.swing.JLabel();
        jComboBoxJarraC = new javax.swing.JComboBox<>();
        jPanel23 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel163 = new javax.swing.JLabel();
        jLabel164 = new javax.swing.JLabel();
        jLabel165 = new javax.swing.JLabel();
        jLabel166 = new javax.swing.JLabel();
        jLabel167 = new javax.swing.JLabel();
        jTextField183 = new javax.swing.JTextField();
        jTextField184 = new javax.swing.JTextField();
        jTextField185 = new javax.swing.JTextField();
        jTextField186 = new javax.swing.JTextField();
        jPanel25 = new javax.swing.JPanel();
        CVCMVMIN = new javax.swing.JTextField();
        CVCMVMED = new javax.swing.JTextField();
        CVCMVMAX = new javax.swing.JTextField();
        jLabel168 = new javax.swing.JLabel();
        jLabel169 = new javax.swing.JLabel();
        jLabel170 = new javax.swing.JLabel();
        jTextField190 = new javax.swing.JTextField();
        jTextField191 = new javax.swing.JTextField();
        jTextField192 = new javax.swing.JTextField();
        jTextField193 = new javax.swing.JTextField();
        jTextField194 = new javax.swing.JTextField();
        jTextField195 = new javax.swing.JTextField();
        jLabel171 = new javax.swing.JLabel();
        jLabel172 = new javax.swing.JLabel();
        jLabel173 = new javax.swing.JLabel();
        jLabel174 = new javax.swing.JLabel();
        jLabel175 = new javax.swing.JLabel();
        jLabel176 = new javax.swing.JLabel();
        jLabel177 = new javax.swing.JLabel();
        jTextField196 = new javax.swing.JTextField();
        jTextField197 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        mangueraA3 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jLabel178 = new javax.swing.JLabel();
        jLabel179 = new javax.swing.JLabel();
        jLabel180 = new javax.swing.JLabel();
        jLabel181 = new javax.swing.JLabel();
        jLabel182 = new javax.swing.JLabel();
        jLabel183 = new javax.swing.JLabel();
        jLabel184 = new javax.swing.JLabel();
        DP1MAX = new javax.swing.JTextField();
        DP1MED = new javax.swing.JTextField();
        DP1MIN = new javax.swing.JTextField();
        DP2MIN = new javax.swing.JTextField();
        DP2MAX = new javax.swing.JTextField();
        DP2MED = new javax.swing.JTextField();
        DP3MIN = new javax.swing.JTextField();
        DP3MED = new javax.swing.JTextField();
        DP3MAX = new javax.swing.JTextField();
        DLCMAX = new javax.swing.JTextField();
        DLCMED = new javax.swing.JTextField();
        DLCMIN = new javax.swing.JTextField();
        jTextField210 = new javax.swing.JTextField();
        jTextField211 = new javax.swing.JTextField();
        jTextField212 = new javax.swing.JTextField();
        jLabel185 = new javax.swing.JLabel();
        jLabel186 = new javax.swing.JLabel();
        jLabel187 = new javax.swing.JLabel();
        DTMEDP1 = new javax.swing.JTextField();
        DTMEDP2 = new javax.swing.JTextField();
        DTMEDP3 = new javax.swing.JTextField();
        DTMAXP3 = new javax.swing.JTextField();
        DTMINP1 = new javax.swing.JTextField();
        DTMINP3 = new javax.swing.JTextField();
        DTMAXP2 = new javax.swing.JTextField();
        DTMINP2 = new javax.swing.JTextField();
        DTMAXP1 = new javax.swing.JTextField();
        jLabel188 = new javax.swing.JLabel();
        jLabel189 = new javax.swing.JLabel();
        jLabel190 = new javax.swing.JLabel();
        jLabel191 = new javax.swing.JLabel();
        jLabel192 = new javax.swing.JLabel();
        jLabel193 = new javax.swing.JLabel();
        jLabel194 = new javax.swing.JLabel();
        jLabel195 = new javax.swing.JLabel();
        jLabel196 = new javax.swing.JLabel();
        jTextField222 = new javax.swing.JTextField();
        jTextField223 = new javax.swing.JTextField();
        jTextField224 = new javax.swing.JTextField();
        jTextField225 = new javax.swing.JTextField();
        jTextField226 = new javax.swing.JTextField();
        jTextField227 = new javax.swing.JTextField();
        jTextField228 = new javax.swing.JTextField();
        jTextField229 = new javax.swing.JTextField();
        jTextField230 = new javax.swing.JTextField();
        jLabel197 = new javax.swing.JLabel();
        jLabel198 = new javax.swing.JLabel();
        jLabel199 = new javax.swing.JLabel();
        jLabel200 = new javax.swing.JLabel();
        jLabel201 = new javax.swing.JLabel();
        jLabel202 = new javax.swing.JLabel();
        jLabel203 = new javax.swing.JLabel();
        jTextField231 = new javax.swing.JTextField();
        jTextField232 = new javax.swing.JTextField();
        jTextField233 = new javax.swing.JTextField();
        jTextField234 = new javax.swing.JTextField();
        jTextField235 = new javax.swing.JTextField();
        jTextField236 = new javax.swing.JTextField();
        jTextField237 = new javax.swing.JTextField();
        jTextField238 = new javax.swing.JTextField();
        jTextField239 = new javax.swing.JTextField();
        jTextField240 = new javax.swing.JTextField();
        jTextField241 = new javax.swing.JTextField();
        jTextField242 = new javax.swing.JTextField();
        jLabel204 = new javax.swing.JLabel();
        jLabel205 = new javax.swing.JLabel();
        jLabel206 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jLabel207 = new javax.swing.JLabel();
        jTextField243 = new javax.swing.JTextField();
        jTextField244 = new javax.swing.JTextField();
        DV20 = new javax.swing.JTextField();
        DKC = new javax.swing.JTextField();
        jLabel208 = new javax.swing.JLabel();
        jLabel209 = new javax.swing.JLabel();
        jLabel210 = new javax.swing.JLabel();
        jLabel211 = new javax.swing.JLabel();
        jLabel212 = new javax.swing.JLabel();
        jComboBoxJarraD = new javax.swing.JComboBox<>();
        jPanel28 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jLabel213 = new javax.swing.JLabel();
        jLabel214 = new javax.swing.JLabel();
        jLabel215 = new javax.swing.JLabel();
        jLabel216 = new javax.swing.JLabel();
        jLabel217 = new javax.swing.JLabel();
        jTextField247 = new javax.swing.JTextField();
        jTextField248 = new javax.swing.JTextField();
        jTextField249 = new javax.swing.JTextField();
        jTextField250 = new javax.swing.JTextField();
        jPanel30 = new javax.swing.JPanel();
        DVCMVMIN = new javax.swing.JTextField();
        DVCMVMED = new javax.swing.JTextField();
        DVCMVMAX = new javax.swing.JTextField();
        jLabel218 = new javax.swing.JLabel();
        jLabel219 = new javax.swing.JLabel();
        jLabel220 = new javax.swing.JLabel();
        jTextField254 = new javax.swing.JTextField();
        jTextField255 = new javax.swing.JTextField();
        jTextField256 = new javax.swing.JTextField();
        jTextField257 = new javax.swing.JTextField();
        jTextField258 = new javax.swing.JTextField();
        jTextField259 = new javax.swing.JTextField();
        jLabel221 = new javax.swing.JLabel();
        jLabel222 = new javax.swing.JLabel();
        jLabel223 = new javax.swing.JLabel();
        jLabel224 = new javax.swing.JLabel();
        jLabel225 = new javax.swing.JLabel();
        jLabel226 = new javax.swing.JLabel();
        jLabel227 = new javax.swing.JLabel();
        jTextField260 = new javax.swing.JTextField();
        jTextField261 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        mangueraA4 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jLabel228 = new javax.swing.JLabel();
        jLabel229 = new javax.swing.JLabel();
        jLabel230 = new javax.swing.JLabel();
        jLabel231 = new javax.swing.JLabel();
        jLabel232 = new javax.swing.JLabel();
        jLabel233 = new javax.swing.JLabel();
        jLabel234 = new javax.swing.JLabel();
        EP1MAX = new javax.swing.JTextField();
        EP1MED = new javax.swing.JTextField();
        EP1MIN = new javax.swing.JTextField();
        EP2MIN = new javax.swing.JTextField();
        EP2MAX = new javax.swing.JTextField();
        EP2MED = new javax.swing.JTextField();
        EP3MIN = new javax.swing.JTextField();
        EP3MED = new javax.swing.JTextField();
        EP3MAX = new javax.swing.JTextField();
        ELCMAX = new javax.swing.JTextField();
        ELCMED = new javax.swing.JTextField();
        ELCMIN = new javax.swing.JTextField();
        jTextField274 = new javax.swing.JTextField();
        jTextField275 = new javax.swing.JTextField();
        jTextField276 = new javax.swing.JTextField();
        jLabel235 = new javax.swing.JLabel();
        jLabel236 = new javax.swing.JLabel();
        jLabel237 = new javax.swing.JLabel();
        ETMEDP1 = new javax.swing.JTextField();
        ETMEDP2 = new javax.swing.JTextField();
        ETMEDP3 = new javax.swing.JTextField();
        ETMAXP3 = new javax.swing.JTextField();
        ETMINP1 = new javax.swing.JTextField();
        ETMINP3 = new javax.swing.JTextField();
        ETMAXP2 = new javax.swing.JTextField();
        ETMINP2 = new javax.swing.JTextField();
        ETMAXP1 = new javax.swing.JTextField();
        jLabel238 = new javax.swing.JLabel();
        jLabel239 = new javax.swing.JLabel();
        jLabel240 = new javax.swing.JLabel();
        jLabel241 = new javax.swing.JLabel();
        jLabel242 = new javax.swing.JLabel();
        jLabel243 = new javax.swing.JLabel();
        jLabel244 = new javax.swing.JLabel();
        jLabel245 = new javax.swing.JLabel();
        jLabel246 = new javax.swing.JLabel();
        jTextField286 = new javax.swing.JTextField();
        jTextField287 = new javax.swing.JTextField();
        jTextField288 = new javax.swing.JTextField();
        jTextField289 = new javax.swing.JTextField();
        jTextField290 = new javax.swing.JTextField();
        jTextField291 = new javax.swing.JTextField();
        jTextField292 = new javax.swing.JTextField();
        jTextField293 = new javax.swing.JTextField();
        jTextField294 = new javax.swing.JTextField();
        jLabel247 = new javax.swing.JLabel();
        jLabel248 = new javax.swing.JLabel();
        jLabel249 = new javax.swing.JLabel();
        jLabel250 = new javax.swing.JLabel();
        jLabel251 = new javax.swing.JLabel();
        jLabel252 = new javax.swing.JLabel();
        jLabel253 = new javax.swing.JLabel();
        jTextField295 = new javax.swing.JTextField();
        jTextField296 = new javax.swing.JTextField();
        jTextField297 = new javax.swing.JTextField();
        jTextField298 = new javax.swing.JTextField();
        jTextField299 = new javax.swing.JTextField();
        jTextField300 = new javax.swing.JTextField();
        jTextField301 = new javax.swing.JTextField();
        jTextField302 = new javax.swing.JTextField();
        jTextField303 = new javax.swing.JTextField();
        jTextField304 = new javax.swing.JTextField();
        jTextField305 = new javax.swing.JTextField();
        jTextField306 = new javax.swing.JTextField();
        jLabel254 = new javax.swing.JLabel();
        jLabel255 = new javax.swing.JLabel();
        jLabel256 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jLabel257 = new javax.swing.JLabel();
        jTextField307 = new javax.swing.JTextField();
        jTextField308 = new javax.swing.JTextField();
        EV20 = new javax.swing.JTextField();
        EKC = new javax.swing.JTextField();
        jLabel258 = new javax.swing.JLabel();
        jLabel259 = new javax.swing.JLabel();
        jLabel260 = new javax.swing.JLabel();
        jLabel261 = new javax.swing.JLabel();
        jLabel262 = new javax.swing.JLabel();
        jComboBoxJarraE = new javax.swing.JComboBox<>();
        jPanel33 = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        jLabel263 = new javax.swing.JLabel();
        jLabel264 = new javax.swing.JLabel();
        jLabel265 = new javax.swing.JLabel();
        jLabel266 = new javax.swing.JLabel();
        jLabel267 = new javax.swing.JLabel();
        jTextField311 = new javax.swing.JTextField();
        jTextField312 = new javax.swing.JTextField();
        jTextField313 = new javax.swing.JTextField();
        jTextField314 = new javax.swing.JTextField();
        jPanel35 = new javax.swing.JPanel();
        EVCMVMIN = new javax.swing.JTextField();
        EVCMVMED = new javax.swing.JTextField();
        EVCMVMAX = new javax.swing.JTextField();
        jLabel268 = new javax.swing.JLabel();
        jLabel269 = new javax.swing.JLabel();
        jLabel270 = new javax.swing.JLabel();
        jTextField318 = new javax.swing.JTextField();
        jTextField319 = new javax.swing.JTextField();
        jTextField320 = new javax.swing.JTextField();
        jTextField321 = new javax.swing.JTextField();
        jTextField322 = new javax.swing.JTextField();
        jTextField323 = new javax.swing.JTextField();
        jLabel271 = new javax.swing.JLabel();
        jLabel272 = new javax.swing.JLabel();
        jLabel273 = new javax.swing.JLabel();
        jLabel274 = new javax.swing.JLabel();
        jLabel275 = new javax.swing.JLabel();
        jLabel276 = new javax.swing.JLabel();
        jLabel277 = new javax.swing.JLabel();
        jTextField324 = new javax.swing.JTextField();
        jTextField325 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        mangueraA5 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jLabel278 = new javax.swing.JLabel();
        jLabel279 = new javax.swing.JLabel();
        jLabel280 = new javax.swing.JLabel();
        jLabel281 = new javax.swing.JLabel();
        jLabel282 = new javax.swing.JLabel();
        jLabel283 = new javax.swing.JLabel();
        jLabel284 = new javax.swing.JLabel();
        FP1MAX = new javax.swing.JTextField();
        FP1MED = new javax.swing.JTextField();
        FP1MIN = new javax.swing.JTextField();
        FP2MIN = new javax.swing.JTextField();
        FP2MAX = new javax.swing.JTextField();
        FP2MED = new javax.swing.JTextField();
        FP3MIN = new javax.swing.JTextField();
        FP3MED = new javax.swing.JTextField();
        FP3MAX = new javax.swing.JTextField();
        FLCMAX = new javax.swing.JTextField();
        FLCMED = new javax.swing.JTextField();
        FLCMIN = new javax.swing.JTextField();
        jTextField338 = new javax.swing.JTextField();
        jTextField339 = new javax.swing.JTextField();
        jTextField340 = new javax.swing.JTextField();
        jLabel285 = new javax.swing.JLabel();
        jLabel286 = new javax.swing.JLabel();
        jLabel287 = new javax.swing.JLabel();
        FTMEDP1 = new javax.swing.JTextField();
        FTMEDP2 = new javax.swing.JTextField();
        FTMEDP3 = new javax.swing.JTextField();
        FTMAXP3 = new javax.swing.JTextField();
        FTMINP1 = new javax.swing.JTextField();
        FTMINP3 = new javax.swing.JTextField();
        FTMAXP2 = new javax.swing.JTextField();
        FTMINP2 = new javax.swing.JTextField();
        FTMAXP1 = new javax.swing.JTextField();
        jLabel288 = new javax.swing.JLabel();
        jLabel289 = new javax.swing.JLabel();
        jLabel290 = new javax.swing.JLabel();
        jLabel291 = new javax.swing.JLabel();
        jLabel292 = new javax.swing.JLabel();
        jLabel293 = new javax.swing.JLabel();
        jLabel294 = new javax.swing.JLabel();
        jLabel295 = new javax.swing.JLabel();
        jLabel296 = new javax.swing.JLabel();
        jTextField350 = new javax.swing.JTextField();
        jTextField351 = new javax.swing.JTextField();
        jTextField352 = new javax.swing.JTextField();
        jTextField353 = new javax.swing.JTextField();
        jTextField354 = new javax.swing.JTextField();
        jTextField355 = new javax.swing.JTextField();
        jTextField356 = new javax.swing.JTextField();
        jTextField357 = new javax.swing.JTextField();
        jTextField358 = new javax.swing.JTextField();
        jLabel297 = new javax.swing.JLabel();
        jLabel298 = new javax.swing.JLabel();
        jLabel299 = new javax.swing.JLabel();
        jLabel300 = new javax.swing.JLabel();
        jLabel301 = new javax.swing.JLabel();
        jLabel302 = new javax.swing.JLabel();
        jLabel303 = new javax.swing.JLabel();
        jTextField359 = new javax.swing.JTextField();
        jTextField360 = new javax.swing.JTextField();
        jTextField361 = new javax.swing.JTextField();
        jTextField362 = new javax.swing.JTextField();
        jTextField363 = new javax.swing.JTextField();
        jTextField364 = new javax.swing.JTextField();
        jTextField365 = new javax.swing.JTextField();
        jTextField366 = new javax.swing.JTextField();
        jTextField367 = new javax.swing.JTextField();
        jTextField368 = new javax.swing.JTextField();
        jTextField369 = new javax.swing.JTextField();
        jTextField370 = new javax.swing.JTextField();
        jLabel304 = new javax.swing.JLabel();
        jLabel305 = new javax.swing.JLabel();
        jLabel306 = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        jLabel307 = new javax.swing.JLabel();
        jTextField371 = new javax.swing.JTextField();
        jTextField372 = new javax.swing.JTextField();
        FV20 = new javax.swing.JTextField();
        FKC = new javax.swing.JTextField();
        jLabel308 = new javax.swing.JLabel();
        jLabel309 = new javax.swing.JLabel();
        jLabel310 = new javax.swing.JLabel();
        jLabel311 = new javax.swing.JLabel();
        jLabel312 = new javax.swing.JLabel();
        jComboBoxJarraF = new javax.swing.JComboBox<>();
        jPanel38 = new javax.swing.JPanel();
        jPanel39 = new javax.swing.JPanel();
        jLabel313 = new javax.swing.JLabel();
        jLabel314 = new javax.swing.JLabel();
        jLabel315 = new javax.swing.JLabel();
        jLabel316 = new javax.swing.JLabel();
        jLabel317 = new javax.swing.JLabel();
        jTextField375 = new javax.swing.JTextField();
        jTextField376 = new javax.swing.JTextField();
        jTextField377 = new javax.swing.JTextField();
        jTextField378 = new javax.swing.JTextField();
        jPanel40 = new javax.swing.JPanel();
        FVCMVMIN = new javax.swing.JTextField();
        FVCMVMED = new javax.swing.JTextField();
        FVCMVMAX = new javax.swing.JTextField();
        jLabel318 = new javax.swing.JLabel();
        jLabel319 = new javax.swing.JLabel();
        jLabel320 = new javax.swing.JLabel();
        jTextField382 = new javax.swing.JTextField();
        jTextField383 = new javax.swing.JTextField();
        jTextField384 = new javax.swing.JTextField();
        jTextField385 = new javax.swing.JTextField();
        jTextField386 = new javax.swing.JTextField();
        jTextField387 = new javax.swing.JTextField();
        jLabel321 = new javax.swing.JLabel();
        jLabel322 = new javax.swing.JLabel();
        jLabel323 = new javax.swing.JLabel();
        jLabel324 = new javax.swing.JLabel();
        jLabel325 = new javax.swing.JLabel();
        jLabel326 = new javax.swing.JLabel();
        jLabel327 = new javax.swing.JLabel();
        jTextField388 = new javax.swing.JTextField();
        jTextField389 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inspeccion de Medición");
        setMinimumSize(new java.awt.Dimension(869, 652));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setForeground(new java.awt.Color(204, 255, 204));

        jLabel1.setText("Verificación Visual:");

        folioSolicitud.setToolTipText("Para cargar los datos, ingresa el folio seguido de un enter");
        folioSolicitud.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                folioSolicitudKeyPressed(evt);
            }
        });

        jLabel2.setText("Folio:");

        jButtonImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/printer.png"))); // NOI18N
        jButtonImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImprimirActionPerformed(evt);
            }
        });

        jCheckBoxImprimir.setText("Imprimir Contrato");
        jCheckBoxImprimir.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxImprimirItemStateChanged(evt);
            }
        });

        jLabel3.setText("Dispensario");

        jLabel4.setText("Fecha/Hora");

        jLabel5.setText("Termómetro");

        jLabel6.setText("Cronómetro");

        jLabel7.setText("Estación");

        jLabel8.setText("Tipo Verificacion");

        campoEstacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoEstacionActionPerformed(evt);
            }
        });
        campoEstacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoEstacionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoEstacionKeyTyped(evt);
            }
        });

        jComboBoxCronometro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxCronometroItemStateChanged(evt);
            }
        });

        jComboBoxTermometro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxTermometroItemStateChanged(evt);
            }
        });

        jDateChooserFechaIM.setEnabled(false);

        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jCheckBox1.setText("ValidaInformación");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboBoxCronometro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(folioSolicitud, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxDispensarios, javax.swing.GroupLayout.Alignment.LEADING, 0, 156, Short.MAX_VALUE)
                            .addComponent(jComboBoxTermometro, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooserFechaIM, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoEstacion)
                                    .addComponent(jTextField3)))
                            .addComponent(jTextField2)
                            .addComponent(datosTermometro, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(datosCronometro, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCheckBoxImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(81, 81, 81))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(folioSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(campoEstacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxImprimir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxDispensarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel8)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jDateChooserFechaIM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jComboBoxTermometro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(datosTermometro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox1)))
                    .addComponent(jButtonImprimir))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBoxCronometro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datosCronometro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jTabbedPane1.setBackground(new java.awt.Color(153, 204, 255));
        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 102));

        verificacionVisual.setBackground(new java.awt.Color(255, 255, 255));

        jLabel65.setText("Caratula indicadora");

        C.add(jRadioButton25);
        jRadioButton25.setSelected(true);
        jRadioButton25.setText("No cumple");
        jRadioButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton25ActionPerformed(evt);
            }
        });

        C.add(jRadioButton26);
        jRadioButton26.setText("Cumple");
        jRadioButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton26ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("C");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel65)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton25)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton26)
                        .addComponent(jRadioButton25)
                        .addComponent(jLabel11))
                    .addComponent(jLabel65))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jLabel63.setText("Leyendas o avisos al consumidor");

        A.add(jRadioButton21);
        jRadioButton21.setText("Cumple");
        jRadioButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton21ActionPerformed(evt);
            }
        });

        A.add(jRadioButton22);
        jRadioButton22.setSelected(true);
        jRadioButton22.setText("No cumple");
        jRadioButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton22ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("A");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel63)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton22)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton21)
                        .addComponent(jRadioButton22)
                        .addComponent(jLabel9))
                    .addComponent(jLabel63))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel64.setText("Placa o etiqueta de identificación");

        B.add(jRadioButton23);
        jRadioButton23.setSelected(true);
        jRadioButton23.setText("No cumple");
        jRadioButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton23ActionPerformed(evt);
            }
        });

        B.add(jRadioButton24);
        jRadioButton24.setText("Cumple");
        jRadioButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton24ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("B");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel64)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton23)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton24)
                        .addComponent(jRadioButton23)
                        .addComponent(jLabel10))
                    .addComponent(jLabel64))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jLabel66.setText("Signo de pesos en caratula");

        D.add(jRadioButton27);
        jRadioButton27.setSelected(true);
        jRadioButton27.setText("No cumple");
        jRadioButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton27ActionPerformed(evt);
            }
        });

        D.add(jRadioButton28);
        jRadioButton28.setText("Cumple");
        jRadioButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton28ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("D");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel66)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton27)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton28)
                        .addComponent(jRadioButton27)
                        .addComponent(jLabel12))
                    .addComponent(jLabel66))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jLabel67.setText("Dispositivos contador y/o computador");

        E.add(jRadioButton29);
        jRadioButton29.setSelected(true);
        jRadioButton29.setText("No cumple");
        jRadioButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton29ActionPerformed(evt);
            }
        });

        E.add(jRadioButton30);
        jRadioButton30.setText("Cumple");
        jRadioButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton30ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setText("E");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel67)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton29)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel67)
                        .addComponent(jRadioButton30)
                        .addComponent(jRadioButton29))
                    .addComponent(jLabel13))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel68.setText("Mecanismo de ajuste.");

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel69.setText("Clik aquí para ver más de esta regla.");
        jLabel69.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel69MouseClicked(evt);
            }
        });

        F.add(jRadioButton31);
        jRadioButton31.setSelected(true);
        jRadioButton31.setText("No cumple");
        jRadioButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton31ActionPerformed(evt);
            }
        });

        F.add(jRadioButton32);
        jRadioButton32.setText("Cumple");
        jRadioButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton32ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setText("F");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel68)
                .addGap(18, 18, 18)
                .addComponent(jLabel69)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 542, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton31)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton32)
                        .addComponent(jRadioButton31)
                        .addComponent(jLabel14))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel68)
                        .addComponent(jLabel69)))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jLabel70.setText("Dispositivos de despacho");

        G.add(jRadioButton33);
        jRadioButton33.setSelected(true);
        jRadioButton33.setText("No cumple");
        jRadioButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton33ActionPerformed(evt);
            }
        });

        G.add(jRadioButton34);
        jRadioButton34.setText("Cumple");
        jRadioButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton34ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("G");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel70)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton33)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton34)
                        .addComponent(jRadioButton33)
                        .addComponent(jLabel15))
                    .addComponent(jLabel70))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jLabel71.setText("Golpes de presión");

        H.add(jRadioButton35);
        jRadioButton35.setSelected(true);
        jRadioButton35.setText("No cumple");
        jRadioButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton35ActionPerformed(evt);
            }
        });

        H.add(jRadioButton36);
        jRadioButton36.setText("Cumple");
        jRadioButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton36ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setText("H");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel71)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton35)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton36)
                        .addComponent(jRadioButton35)
                        .addComponent(jLabel16))
                    .addComponent(jLabel71))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jLabel72.setText("Tiempo de corte (80 s) max.");

        I.add(jRadioButton37);
        jRadioButton37.setSelected(true);
        jRadioButton37.setText("No cumple");
        jRadioButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton37ActionPerformed(evt);
            }
        });

        I.add(jRadioButton38);
        jRadioButton38.setText("Cumple");
        jRadioButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton38ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setText("I");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel72)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton37)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton38)
                        .addComponent(jRadioButton37)
                        .addComponent(jLabel17))
                    .addComponent(jLabel72))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout verificacionVisualLayout = new javax.swing.GroupLayout(verificacionVisual);
        verificacionVisual.setLayout(verificacionVisualLayout);
        verificacionVisualLayout.setHorizontalGroup(
            verificacionVisualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        verificacionVisualLayout.setVerticalGroup(
            verificacionVisualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(verificacionVisualLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Verificación Visual", verificacionVisual);

        mangueraA.setAutoscrolls(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel18.setText("Gastos");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel20.setText("Máximo(ml)");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 51, 153));
        jLabel21.setText("Pruebas Meterológicas");

        jLabel22.setText("Lado A: ");

        jLabel23.setText("TipoGas");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel24.setText("Medio(ml)");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel25.setText("Minimo(ml)");

        AP1MAX.setText("-10");
        AP1MAX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                AP1MAXFocusLost(evt);
            }
        });
        AP1MAX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AP1MAXActionPerformed(evt);
            }
        });

        AP1MED.setText("-10");
        AP1MED.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                AP1MEDFocusLost(evt);
            }
        });

        AP1MIN.setText("-10");
        AP1MIN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                AP1MINFocusLost(evt);
            }
        });

        AP2MIN.setText("-10");
        AP2MIN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                AP2MINFocusLost(evt);
            }
        });

        AP2MAX.setText("-10");
        AP2MAX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                AP2MAXFocusLost(evt);
            }
        });

        AP2MED.setText("-10");
        AP2MED.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                AP2MEDFocusLost(evt);
            }
        });

        AP3MIN.setText("-10");
        AP3MIN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                AP3MINFocusLost(evt);
            }
        });

        AP3MED.setText("-10");
        AP3MED.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                AP3MEDFocusLost(evt);
            }
        });

        AP3MAX.setText("-10");
        AP3MAX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                AP3MAXFocusLost(evt);
            }
        });

        ALCMAX.setEditable(false);

        ALCMED.setEditable(false);

        ALCMIN.setEditable(false);

        jTextField18.setText("-10");

        jTextField19.setText("-10");

        jTextField20.setText("-10");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel26.setText("Máximo");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel27.setText("Medio");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel28.setText("Minimo");

        ATMEDP1.setText("0");
        ATMEDP1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ATMEDP1FocusLost(evt);
            }
        });

        ATMEDP2.setText("0");
        ATMEDP2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ATMEDP2FocusLost(evt);
            }
        });

        ATMEDP3.setText("0");
        ATMEDP3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ATMEDP3FocusLost(evt);
            }
        });
        ATMEDP3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ATMEDP3ActionPerformed(evt);
            }
        });

        ATMAXP3.setText("0");
        ATMAXP3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ATMAXP3FocusLost(evt);
            }
        });
        ATMAXP3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ATMAXP3ActionPerformed(evt);
            }
        });

        ATMINP1.setText("0");
        ATMINP1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ATMINP1FocusLost(evt);
            }
        });

        ATMINP3.setText("0");
        ATMINP3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ATMINP3FocusLost(evt);
            }
        });
        ATMINP3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ATMINP3ActionPerformed(evt);
            }
        });

        ATMAXP2.setText("0");
        ATMAXP2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ATMAXP2FocusLost(evt);
            }
        });

        ATMINP2.setText("0");
        ATMINP2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ATMINP2FocusLost(evt);
            }
        });

        ATMAXP1.setText("0");
        ATMAXP1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ATMAXP1FocusLost(evt);
            }
        });

        jLabel29.setText("Prueba1");

        jLabel30.setText("Prueba2");

        jLabel31.setText("Prueba3");

        jLabel32.setText("LC");

        jLabel33.setText("Err.Rep");

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel34.setText("Temperatura");

        jLabel35.setText("Prueba1");

        jLabel36.setText("Prueba2");

        jLabel37.setText("Prueba3");

        jTextField30.setText("0");

        jTextField31.setText("0");

        jTextField32.setText("0");

        jTextField33.setText("0");

        jTextField34.setText("0");
        jTextField34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField34ActionPerformed(evt);
            }
        });

        jTextField35.setText("0");

        jTextField36.setText("0");

        jTextField37.setText("0");

        jTextField38.setText("0");

        jLabel38.setText("Prueba3");

        jLabel39.setText("Prueba2");

        jLabel40.setText("Prueba1");

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel41.setText("Tiempo");

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel42.setText("Máximo");

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel43.setText("Medio");

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel44.setText("Minimo");

        jTextField39.setText("20000");

        jTextField40.setText("20000");

        jTextField41.setText("20000");

        jTextField42.setText("20000");

        jTextField43.setText("20000");

        jTextField44.setText("20000");

        jTextField45.setText("20000");

        jTextField46.setText("20000");

        jTextField47.setText("20000");

        jTextField48.setText("20000");

        jTextField49.setText("20000");

        jTextField50.setText("20000");

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel45.setText("Máximo(ml)");

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel46.setText("Medio(ml)");

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel47.setText("Minimo(ml)");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel20)
                                        .addComponent(jLabel24)
                                        .addComponent(jLabel25))
                                    .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.LEADING))
                                .addComponent(jLabel46, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel47, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(AP1MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(AP1MAX, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                                        .addComponent(AP1MED))
                                    .addComponent(jLabel29))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(AP2MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(AP2MAX)
                                                .addComponent(AP2MED, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(AP3MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(AP3MAX)
                                                .addComponent(AP3MED, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ALCMIN, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(ALCMAX)
                                                .addComponent(ALCMED, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jTextField19)
                                                .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel26)
                                            .addComponent(jLabel27)
                                            .addComponent(jLabel28)
                                            .addComponent(jLabel41)
                                            .addComponent(jLabel42)
                                            .addComponent(jLabel43)
                                            .addComponent(jLabel44))
                                        .addGap(23, 23, 23))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel30)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel31)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel32)
                                        .addGap(23, 23, 23)
                                        .addComponent(jLabel33)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel34))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField49, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField39)
                                        .addComponent(jTextField50, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField48, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField40)
                                        .addComponent(jTextField47, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField45, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField41)
                                        .addComponent(jTextField46, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField44, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField42)
                                        .addComponent(jTextField43, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ATMINP1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(ATMAXP1)
                                        .addComponent(ATMEDP1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ATMINP2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(ATMAXP2)
                                            .addComponent(ATMEDP2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel36))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ATMINP3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(ATMAXP3)
                                            .addComponent(ATMEDP3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel37)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField31)
                                        .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel40))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jTextField33)
                                                .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField36, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jTextField38)
                                                .addComponent(jTextField37, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel39)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel38)))))
                        .addGap(30, 30, 30))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(67, 67, 67)
                                .addComponent(jLabel22)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel23))
                            .addComponent(jLabel18))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel29)
                        .addComponent(jLabel30)
                        .addComponent(jLabel31)
                        .addComponent(jLabel32)
                        .addComponent(jLabel33)
                        .addComponent(jLabel35)
                        .addComponent(jLabel36)
                        .addComponent(jLabel37)
                        .addComponent(jLabel34)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(ATMAXP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ATMEDP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ATMINP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(ATMAXP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ATMEDP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ATMINP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(ATMAXP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ATMEDP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ATMINP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(jLabel39)
                            .addComponent(jLabel40)
                            .addComponent(jLabel41))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel20)
                                        .addComponent(AP1MAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel24)
                                        .addComponent(AP1MED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel25)
                                        .addComponent(AP1MIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(AP2MAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(AP2MED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(AP2MIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(AP3MAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(AP3MED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(AP3MIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(ALCMAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(ALCMED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(ALCMIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel26))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel28)))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(32, 32, 32)
                                    .addComponent(jLabel27)))
                            .addGap(43, 43, 43))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel45))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel46))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel47)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel42))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel43))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel44)))))
                .addGap(35, 35, 35))
        );

        jPanel12.setBackground(new java.awt.Color(204, 255, 204));

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel48.setText("Jarra");

        AV20.setText("0");
        AV20.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                AV20FocusLost(evt);
            }
        });

        AKC.setText("0");
        AKC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                AKCFocusLost(evt);
            }
        });

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel49.setText("KC");

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel50.setText("V20");

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(0, 51, 153));
        jLabel51.setText("Información de la Jarra");

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel52.setText("Fecha Calib.");

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel53.setText("Inf. Calib.");

        jComboBoxJarraA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel48)
                                .addComponent(jLabel50, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel49, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxJarraA, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AV20)
                            .addComponent(AKC, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel53)
                                .addGap(9, 9, 9))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel52)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField53)
                            .addComponent(jTextField54, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel51)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel48)
                                    .addComponent(jComboBoxJarraA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(AV20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel50)))
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel53)
                                .addComponent(jTextField54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AKC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel49)))
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel52)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(255, 153, 153));

        jPanel15.setBackground(new java.awt.Color(204, 255, 204));

        jLabel19.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 102, 51));
        jLabel19.setText("ACEPTADA");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel74.setText("Total Inicial:");

        jLabel75.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel75.setText("Total Final:");

        jLabel76.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel76.setText("Calc. PROFECO.");

        jLabel77.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel77.setText("Calc. UVA.");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel77)
                    .addComponent(jLabel76)
                    .addComponent(jLabel75)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel74))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField64, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField67, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField68, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField69, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel74)
                    .addComponent(jTextField64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel75)
                    .addComponent(jTextField67, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel76)
                    .addComponent(jTextField68, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel77)
                    .addComponent(jTextField69, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14.setBackground(new java.awt.Color(153, 204, 255));

        AVCMVMIN.setEditable(false);

        AVCMVMED.setEditable(false);

        AVCMVMAX.setEditable(false);

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel54.setText("Vcmv");

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel55.setText("E");

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel56.setText("qv");

        jTextField59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField59ActionPerformed(evt);
            }
        });

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(0, 51, 153));
        jLabel57.setText("Resultados");

        jLabel58.setText("G. Máximo");

        jLabel59.setText("G. Medio");

        jLabel60.setText("G. Mínimo");

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel61.setText("ml");

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel62.setText("ml");

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel73.setText("l./mn.");

        jTextField65.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField65ActionPerformed(evt);
            }
        });

        jButton1.setText("Incluir");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel54)
                                .addComponent(jLabel55, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel56, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel58)
                            .addComponent(jTextField59)
                            .addComponent(jTextField58)
                            .addComponent(AVCMVMAX, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(AVCMVMED, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                .addComponent(jTextField60)
                                .addComponent(jTextField61))
                            .addComponent(jLabel59))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel60)
                                .addGap(185, 185, 185))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(AVCMVMIN, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                    .addComponent(jTextField63)
                                    .addComponent(jTextField62))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel73)
                                    .addComponent(jLabel62)
                                    .addComponent(jLabel61))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField65, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField66, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)))))
                    .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel57)
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(jLabel59)
                    .addComponent(jLabel60))
                .addGap(1, 1, 1)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AVCMVMAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel54))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField59, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel55))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField58, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel56)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(AVCMVMED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField60, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(AVCMVMIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField63, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField62, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField66, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel61))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField65, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel62))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel73)
                            .addComponent(jButton1))))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mangueraALayout = new javax.swing.GroupLayout(mangueraA);
        mangueraA.setLayout(mangueraALayout);
        mangueraALayout.setHorizontalGroup(
            mangueraALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mangueraALayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(mangueraALayout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        mangueraALayout.setVerticalGroup(
            mangueraALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mangueraALayout.createSequentialGroup()
                .addGroup(mangueraALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mangueraALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Manguera A", mangueraA);

        mangueraA1.setAutoscrolls(true);

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));

        jLabel78.setText("Gastos");

        jLabel79.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel79.setText("Máximo(ml)");

        jLabel80.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(0, 51, 153));
        jLabel80.setText("Pruebas Meterológicas");

        jLabel81.setText("Lado B: ");

        jLabel82.setText("TipoGas");

        jLabel83.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel83.setText("Medio(ml)");

        jLabel84.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel84.setText("Minimo(ml)");

        BP1MAX.setText("-10");
        BP1MAX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                BP1MAXFocusLost(evt);
            }
        });
        BP1MAX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BP1MAXActionPerformed(evt);
            }
        });

        BP1MED.setText("-10");
        BP1MED.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                BP1MEDFocusLost(evt);
            }
        });

        BP1MIN.setText("-10");
        BP1MIN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                BP1MINFocusLost(evt);
            }
        });
        BP1MIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BP1MINActionPerformed(evt);
            }
        });

        BP2MIN.setText("-10");
        BP2MIN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                BP2MINFocusLost(evt);
            }
        });
        BP2MIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BP2MINActionPerformed(evt);
            }
        });

        BP2MAX.setText("-10");
        BP2MAX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                BP2MAXFocusLost(evt);
            }
        });

        BP2MED.setText("-10");
        BP2MED.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                BP2MEDFocusLost(evt);
            }
        });

        BP3MIN.setText("-10");
        BP3MIN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                BP3MINFocusLost(evt);
            }
        });

        BP3MED.setText("-10");
        BP3MED.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                BP3MEDFocusLost(evt);
            }
        });

        BP3MAX.setText("-10");
        BP3MAX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                BP3MAXFocusLost(evt);
            }
        });

        BLCMAX.setEditable(false);

        BLCMED.setEditable(false);

        BLCMIN.setEditable(false);

        jTextField82.setText("-10");

        jTextField83.setText("-10");

        jTextField84.setText("-10");

        jLabel85.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel85.setText("Máximo");

        jLabel86.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel86.setText("Medio");

        jLabel87.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel87.setText("Minimo");

        BTMEDP1.setText("0");
        BTMEDP1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                BTMEDP1FocusLost(evt);
            }
        });
        BTMEDP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTMEDP1ActionPerformed(evt);
            }
        });

        BTMEDP2.setText("0");
        BTMEDP2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                BTMEDP2FocusLost(evt);
            }
        });

        BTMEDP3.setText("0");
        BTMEDP3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                BTMEDP3FocusLost(evt);
            }
        });

        BTMAXP3.setText("0");
        BTMAXP3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                BTMAXP3FocusLost(evt);
            }
        });
        BTMAXP3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTMAXP3ActionPerformed(evt);
            }
        });

        BTMINP1.setText("0");
        BTMINP1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                BTMINP1FocusLost(evt);
            }
        });

        BTMINP3.setText("0");
        BTMINP3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                BTMINP3FocusLost(evt);
            }
        });

        BTMAXP2.setText("0");
        BTMAXP2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                BTMAXP2FocusLost(evt);
            }
        });

        BTMINP2.setText("0");
        BTMINP2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                BTMINP2FocusLost(evt);
            }
        });
        BTMINP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTMINP2ActionPerformed(evt);
            }
        });

        BTMAXP1.setText("0");
        BTMAXP1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                BTMAXP1FocusLost(evt);
            }
        });

        jLabel88.setText("Prueba1");

        jLabel89.setText("Prueba2");

        jLabel90.setText("Prueba3");

        jLabel91.setText("LC");

        jLabel92.setText("Err.Rep");

        jLabel93.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel93.setText("Temperatura");

        jLabel94.setText("Prueba1");

        jLabel95.setText("Prueba2");

        jLabel96.setText("Prueba3");

        jTextField94.setText("0");

        jTextField95.setText("0");
        jTextField95.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField95ActionPerformed(evt);
            }
        });

        jTextField96.setText("0");

        jTextField97.setText("0");

        jTextField98.setText("0");

        jTextField99.setText("0");

        jTextField100.setText("0");

        jTextField101.setText("0");

        jTextField102.setText("0");

        jLabel97.setText("Prueba3");

        jLabel98.setText("Prueba2");

        jLabel99.setText("Prueba1");

        jLabel100.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel100.setText("Tiempo");

        jLabel101.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel101.setText("Máximo");

        jLabel102.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel102.setText("Medio");

        jLabel103.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel103.setText("Minimo");

        jTextField103.setText("20000");

        jTextField104.setText("20000");

        jTextField105.setText("20000");

        jTextField106.setText("20000");

        jTextField107.setText("20000");

        jTextField108.setText("20000");

        jTextField109.setText("20000");

        jTextField110.setText("20000");
        jTextField110.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField110ActionPerformed(evt);
            }
        });

        jTextField111.setText("20000");

        jTextField112.setText("20000");

        jTextField113.setText("20000");

        jTextField114.setText("20000");

        jLabel104.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel104.setText("Máximo(ml)");

        jLabel105.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel105.setText("Medio(ml)");

        jLabel106.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel106.setText("Minimo(ml)");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel79)
                                        .addComponent(jLabel83)
                                        .addComponent(jLabel84))
                                    .addComponent(jLabel104, javax.swing.GroupLayout.Alignment.LEADING))
                                .addComponent(jLabel105, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel106, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BP1MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(BP1MAX, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                                        .addComponent(BP1MED))
                                    .addComponent(jLabel88))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(BP2MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(BP2MAX)
                                                .addComponent(BP2MED, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(BP3MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(BP3MAX)
                                                .addComponent(BP3MED, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(BLCMIN, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(BLCMAX)
                                                .addComponent(BLCMED, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField82, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jTextField83)
                                                .addComponent(jTextField84, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel85)
                                            .addComponent(jLabel86)
                                            .addComponent(jLabel87)
                                            .addComponent(jLabel100)
                                            .addComponent(jLabel101)
                                            .addComponent(jLabel102)
                                            .addComponent(jLabel103))
                                        .addGap(23, 23, 23))
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel89)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel90)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel91)
                                        .addGap(23, 23, 23)
                                        .addComponent(jLabel92)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel93))))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField113, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField103)
                                        .addComponent(jTextField114, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField112, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField104)
                                        .addComponent(jTextField111, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField109, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField105)
                                        .addComponent(jTextField110, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField108, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField106)
                                        .addComponent(jTextField107, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BTMINP1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(BTMAXP1)
                                        .addComponent(BTMEDP1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel94, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(BTMINP2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(BTMAXP2)
                                            .addComponent(BTMEDP2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel95))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(BTMINP3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(BTMAXP3)
                                            .addComponent(BTMEDP3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel96)))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField96, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField95)
                                        .addComponent(jTextField94, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel99))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField99, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jTextField97)
                                                .addComponent(jTextField98, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField100, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jTextField102)
                                                .addComponent(jTextField101, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addComponent(jLabel98)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel97)))))
                        .addGap(30, 30, 30))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jLabel80)
                                .addGap(67, 67, 67)
                                .addComponent(jLabel81)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel82))
                            .addComponent(jLabel78))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel80)
                    .addComponent(jLabel81)
                    .addComponent(jLabel82))
                .addGap(30, 30, 30)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel78)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel88)
                        .addComponent(jLabel89)
                        .addComponent(jLabel90)
                        .addComponent(jLabel91)
                        .addComponent(jLabel92)
                        .addComponent(jLabel94)
                        .addComponent(jLabel95)
                        .addComponent(jLabel96)
                        .addComponent(jLabel93)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(BTMAXP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTMEDP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTMINP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(BTMAXP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTMEDP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTMINP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(BTMAXP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTMEDP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTMINP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel97)
                            .addComponent(jLabel98)
                            .addComponent(jLabel99)
                            .addComponent(jLabel100))
                        .addGroup(jPanel16Layout.createSequentialGroup()
                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel16Layout.createSequentialGroup()
                                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel79)
                                        .addComponent(BP1MAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel83)
                                        .addComponent(BP1MED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel84)
                                        .addComponent(BP1MIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel16Layout.createSequentialGroup()
                                    .addComponent(BP2MAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(BP2MED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(BP2MIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel16Layout.createSequentialGroup()
                                    .addComponent(BP3MAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(BP3MED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(BP3MIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel16Layout.createSequentialGroup()
                                    .addComponent(BLCMAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(BLCMED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(BLCMIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel16Layout.createSequentialGroup()
                                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField83, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel85))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField84, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField82, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel87)))
                                .addGroup(jPanel16Layout.createSequentialGroup()
                                    .addGap(32, 32, 32)
                                    .addComponent(jLabel86)))
                            .addGap(43, 43, 43))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jTextField97, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField98, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField99, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jTextField102, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField101, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField100, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField103, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel104))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField114, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel105))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField113, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel106)))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jTextField104, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField111, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField112, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jTextField105, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField110, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField109, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jTextField106, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField107, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField108, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel16Layout.createSequentialGroup()
                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField95, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel101))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField94, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel102))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField96, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel103)))))
                .addGap(35, 35, 35))
        );

        jPanel17.setBackground(new java.awt.Color(204, 255, 204));

        jLabel107.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel107.setText("Jarra");

        BV20.setText("0");
        BV20.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                BV20FocusLost(evt);
            }
        });

        BKC.setText("0");
        BKC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                BKCFocusLost(evt);
            }
        });

        jLabel108.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel108.setText("KC");

        jLabel109.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel109.setText("V20");

        jLabel110.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel110.setForeground(new java.awt.Color(0, 51, 153));
        jLabel110.setText("Información de la Jarra");

        jLabel111.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel111.setText("Fecha Calib.");

        jLabel112.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel112.setText("Inf. Calib.");

        jComboBoxJarraB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel110, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel107)
                                .addComponent(jLabel109, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel108, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxJarraB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BV20)
                            .addComponent(BKC, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(jLabel112)
                                .addGap(9, 9, 9))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                                .addComponent(jLabel111)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField115)
                            .addComponent(jTextField116, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel110)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel107)
                                    .addComponent(jComboBoxJarraB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(BV20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel109)))
                            .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel112)
                                .addComponent(jTextField116, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BKC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel108)))
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField115, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel111)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel18.setBackground(new java.awt.Color(255, 153, 153));

        jPanel19.setBackground(new java.awt.Color(204, 255, 204));

        jLabel113.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel113.setForeground(new java.awt.Color(0, 102, 51));
        jLabel113.setText("ACEPTADA");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel113)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel113)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel114.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel114.setText("Total Inicial:");

        jLabel115.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel115.setText("Total Final:");

        jLabel116.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel116.setText("Calc. PROFECO.");

        jLabel117.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel117.setText("Calc. UVA.");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel117)
                    .addComponent(jLabel116)
                    .addComponent(jLabel115)
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel114))
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField119, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField120, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField121, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField122, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel114)
                    .addComponent(jTextField119, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel115)
                    .addComponent(jTextField120, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel116)
                    .addComponent(jTextField121, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel117)
                    .addComponent(jTextField122, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel20.setBackground(new java.awt.Color(153, 204, 255));

        BVCMVMIN.setEditable(false);

        BVCMVMED.setEditable(false);

        BVCMVMAX.setEditable(false);

        jLabel118.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel118.setText("Vcmv");

        jLabel119.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel119.setText("E");

        jLabel120.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel120.setText("qv");

        jTextField127.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField127ActionPerformed(evt);
            }
        });

        jLabel121.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel121.setForeground(new java.awt.Color(0, 51, 153));
        jLabel121.setText("Resultados");

        jLabel122.setText("G. Máximo");

        jLabel123.setText("G. Medio");

        jLabel124.setText("G. Mínimo");

        jLabel125.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel125.setText("ml");

        jLabel126.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel126.setText("ml");

        jLabel127.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel127.setText("l./mn.");

        jTextField132.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField132ActionPerformed(evt);
            }
        });

        jButton3.setText("Incluir");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel118)
                                .addComponent(jLabel119, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel120, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel122)
                            .addComponent(jTextField127)
                            .addComponent(jTextField126)
                            .addComponent(BVCMVMAX, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(BVCMVMED, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                .addComponent(jTextField128)
                                .addComponent(jTextField129))
                            .addComponent(jLabel123))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addComponent(jLabel124)
                                .addGap(185, 185, 185))
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(BVCMVMIN, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                    .addComponent(jTextField131)
                                    .addComponent(jTextField130))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel127)
                                    .addComponent(jLabel126)
                                    .addComponent(jLabel125))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField132, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField133, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)))))
                    .addComponent(jLabel121, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel121)
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel122)
                    .addComponent(jLabel123)
                    .addComponent(jLabel124))
                .addGap(1, 1, 1)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BVCMVMAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel118))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField127, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel119))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField126, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel120)))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(BVCMVMED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField128, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField129, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(BVCMVMIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField131, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField130, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField133, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel125))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField132, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel126))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel127)
                            .addComponent(jButton3))))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mangueraA1Layout = new javax.swing.GroupLayout(mangueraA1);
        mangueraA1.setLayout(mangueraA1Layout);
        mangueraA1Layout.setHorizontalGroup(
            mangueraA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mangueraA1Layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(mangueraA1Layout.createSequentialGroup()
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        mangueraA1Layout.setVerticalGroup(
            mangueraA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mangueraA1Layout.createSequentialGroup()
                .addGroup(mangueraA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mangueraA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Manguera B", mangueraA1);

        mangueraA2.setAutoscrolls(true);

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));

        jLabel128.setText("Gastos");

        jLabel129.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel129.setText("Máximo(ml)");

        jLabel130.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel130.setForeground(new java.awt.Color(0, 51, 153));
        jLabel130.setText("Pruebas Meterológicas");

        jLabel131.setText("Lado C: ");

        jLabel132.setText("TipoGas");

        jLabel133.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel133.setText("Medio(ml)");

        jLabel134.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel134.setText("Minimo(ml)");

        CP1MAX.setText("-10");

        CP1MED.setText("-10");

        CP1MIN.setText("-10");

        CP2MIN.setText("-10");

        CP2MAX.setText("-10");

        CP2MED.setText("-10");

        CP3MIN.setText("-10");

        CP3MED.setText("-10");

        CP3MAX.setText("-10");

        CLCMAX.setEditable(false);

        CLCMED.setEditable(false);

        CLCMIN.setEditable(false);

        jTextField146.setText("-10");

        jTextField147.setText("-10");

        jTextField148.setText("-10");

        jLabel135.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel135.setText("Máximo");

        jLabel136.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel136.setText("Medio");

        jLabel137.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel137.setText("Minimo");

        CTMEDP1.setText("0");

        CTMEDP2.setText("0");

        CTMEDP3.setText("0");

        CTMAXP3.setText("0");

        CTMINP1.setText("0");

        CTMINP3.setText("0");

        CTMAXP2.setText("0");

        CTMINP2.setText("0");

        CTMAXP1.setText("0");

        jLabel138.setText("Prueba1");

        jLabel139.setText("Prueba2");

        jLabel140.setText("Prueba3");

        jLabel141.setText("LC");

        jLabel142.setText("Err.Rep");

        jLabel143.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel143.setText("Temperatura");

        jLabel144.setText("Prueba1");

        jLabel145.setText("Prueba2");

        jLabel146.setText("Prueba3");

        jTextField158.setText("0");
        jTextField158.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField158ActionPerformed(evt);
            }
        });

        jTextField159.setText("0");

        jTextField160.setText("0");

        jTextField161.setText("0");

        jTextField162.setText("0");

        jTextField163.setText("0");

        jTextField164.setText("0");

        jTextField165.setText("0");

        jTextField166.setText("0");

        jLabel147.setText("Prueba3");

        jLabel148.setText("Prueba2");

        jLabel149.setText("Prueba1");

        jLabel150.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel150.setText("Tiempo");

        jLabel151.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel151.setText("Máximo");

        jLabel152.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel152.setText("Medio");

        jLabel153.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel153.setText("Minimo");

        jTextField167.setText("20000");

        jTextField168.setText("20000");

        jTextField169.setText("20000");

        jTextField170.setText("20000");

        jTextField171.setText("20000");

        jTextField172.setText("20000");

        jTextField173.setText("20000");

        jTextField174.setText("20000");

        jTextField175.setText("20000");

        jTextField176.setText("20000");

        jTextField177.setText("20000");

        jTextField178.setText("20000");

        jLabel154.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel154.setText("Máximo(ml)");

        jLabel155.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel155.setText("Medio(ml)");

        jLabel156.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel156.setText("Minimo(ml)");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel129)
                                        .addComponent(jLabel133)
                                        .addComponent(jLabel134))
                                    .addComponent(jLabel154, javax.swing.GroupLayout.Alignment.LEADING))
                                .addComponent(jLabel155, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel156, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CP1MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(CP1MAX, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                                        .addComponent(CP1MED))
                                    .addComponent(jLabel138))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel21Layout.createSequentialGroup()
                                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(CP2MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(CP2MAX)
                                                .addComponent(CP2MED, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(CP3MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(CP3MAX)
                                                .addComponent(CP3MED, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(CLCMIN, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(CLCMAX)
                                                .addComponent(CLCMED, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField146, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jTextField147)
                                                .addComponent(jTextField148, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel135)
                                            .addComponent(jLabel136)
                                            .addComponent(jLabel137)
                                            .addComponent(jLabel150)
                                            .addComponent(jLabel151)
                                            .addComponent(jLabel152)
                                            .addComponent(jLabel153))
                                        .addGap(23, 23, 23))
                                    .addGroup(jPanel21Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel139)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel140)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel141)
                                        .addGap(23, 23, 23)
                                        .addComponent(jLabel142)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel143))))
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField177, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField167)
                                        .addComponent(jTextField178, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField176, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField168)
                                        .addComponent(jTextField175, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField173, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField169)
                                        .addComponent(jTextField174, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField172, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField170)
                                        .addComponent(jTextField171, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CTMINP1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(CTMAXP1)
                                        .addComponent(CTMEDP1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel144, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(CTMINP2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(CTMAXP2)
                                            .addComponent(CTMEDP2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel145))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(CTMINP3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(CTMAXP3)
                                            .addComponent(CTMEDP3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel146)))
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField160, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField159)
                                        .addComponent(jTextField158, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel149))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel21Layout.createSequentialGroup()
                                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField163, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jTextField161)
                                                .addComponent(jTextField162, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField164, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jTextField166)
                                                .addComponent(jTextField165, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel21Layout.createSequentialGroup()
                                        .addComponent(jLabel148)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel147)))))
                        .addGap(30, 30, 30))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addComponent(jLabel130)
                                .addGap(67, 67, 67)
                                .addComponent(jLabel131)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel132))
                            .addComponent(jLabel128))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel130)
                    .addComponent(jLabel131)
                    .addComponent(jLabel132))
                .addGap(30, 30, 30)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel128)
                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel138)
                        .addComponent(jLabel139)
                        .addComponent(jLabel140)
                        .addComponent(jLabel141)
                        .addComponent(jLabel142)
                        .addComponent(jLabel144)
                        .addComponent(jLabel145)
                        .addComponent(jLabel146)
                        .addComponent(jLabel143)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(CTMAXP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CTMEDP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CTMINP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(CTMAXP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CTMEDP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CTMINP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(CTMAXP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CTMEDP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CTMINP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel147)
                            .addComponent(jLabel148)
                            .addComponent(jLabel149)
                            .addComponent(jLabel150))
                        .addGroup(jPanel21Layout.createSequentialGroup()
                            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel21Layout.createSequentialGroup()
                                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel129)
                                        .addComponent(CP1MAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel133)
                                        .addComponent(CP1MED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel134)
                                        .addComponent(CP1MIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel21Layout.createSequentialGroup()
                                    .addComponent(CP2MAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(CP2MED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(CP2MIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel21Layout.createSequentialGroup()
                                    .addComponent(CP3MAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(CP3MED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(CP3MIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel21Layout.createSequentialGroup()
                                    .addComponent(CLCMAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(CLCMED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(CLCMIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel21Layout.createSequentialGroup()
                                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField147, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel135))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField148, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField146, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel137)))
                                .addGroup(jPanel21Layout.createSequentialGroup()
                                    .addGap(32, 32, 32)
                                    .addComponent(jLabel136)))
                            .addGap(43, 43, 43))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jTextField161, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField162, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField163, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jTextField166, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField165, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField164, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField167, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel154))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField178, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel155))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField177, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel156)))
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addComponent(jTextField168, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField175, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField176, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addComponent(jTextField169, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField174, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField173, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addComponent(jTextField170, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField171, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField172, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel21Layout.createSequentialGroup()
                            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField159, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel151))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField158, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel152))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField160, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel153)))))
                .addGap(35, 35, 35))
        );

        jPanel22.setBackground(new java.awt.Color(204, 255, 204));

        jLabel157.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel157.setText("Jarra");

        CV20.setText("0");

        CKC.setText("0");

        jLabel158.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel158.setText("KC");

        jLabel159.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel159.setText("V20");

        jLabel160.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel160.setForeground(new java.awt.Color(0, 51, 153));
        jLabel160.setText("Información de la Jarra");

        jLabel161.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel161.setText("Fecha Calib.");

        jLabel162.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel162.setText("Inf. Calib.");

        jComboBoxJarraC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel160, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel157)
                                .addComponent(jLabel159, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel158, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxJarraC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CV20)
                            .addComponent(CKC, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel162)
                                .addGap(9, 9, 9))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel161)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField179)
                            .addComponent(jTextField180, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel160)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel157)
                                    .addComponent(jComboBoxJarraC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CV20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel159)))
                            .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel162)
                                .addComponent(jTextField180, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CKC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel158)))
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField179, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel161)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel23.setBackground(new java.awt.Color(255, 153, 153));

        jPanel24.setBackground(new java.awt.Color(204, 255, 204));

        jLabel163.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel163.setForeground(new java.awt.Color(0, 102, 51));
        jLabel163.setText("ACEPTADA");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel163)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel163)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel164.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel164.setText("Total Inicial:");

        jLabel165.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel165.setText("Total Final:");

        jLabel166.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel166.setText("Calc. PROFECO.");

        jLabel167.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel167.setText("Calc. UVA.");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel167)
                    .addComponent(jLabel166)
                    .addComponent(jLabel165)
                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel164))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField183, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField184, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField185, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField186, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel164)
                    .addComponent(jTextField183, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel165)
                    .addComponent(jTextField184, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel166)
                    .addComponent(jTextField185, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel167)
                    .addComponent(jTextField186, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel25.setBackground(new java.awt.Color(153, 204, 255));

        CVCMVMIN.setEditable(false);

        CVCMVMED.setEditable(false);

        CVCMVMAX.setEditable(false);

        jLabel168.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel168.setText("Vcmv");

        jLabel169.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel169.setText("E");

        jLabel170.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel170.setText("qv");

        jTextField191.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField191ActionPerformed(evt);
            }
        });

        jLabel171.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel171.setForeground(new java.awt.Color(0, 51, 153));
        jLabel171.setText("Resultados");

        jLabel172.setText("G. Máximo");

        jLabel173.setText("G. Medio");

        jLabel174.setText("G. Mínimo");

        jLabel175.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel175.setText("ml");

        jLabel176.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel176.setText("ml");

        jLabel177.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel177.setText("l./mn.");

        jTextField196.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField196ActionPerformed(evt);
            }
        });

        jButton4.setText("Incluir");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel168)
                                .addComponent(jLabel169, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel170, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel172)
                            .addComponent(jTextField191)
                            .addComponent(jTextField190)
                            .addComponent(CVCMVMAX, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(CVCMVMED, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                .addComponent(jTextField192)
                                .addComponent(jTextField193))
                            .addComponent(jLabel173))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addComponent(jLabel174)
                                .addGap(185, 185, 185))
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(CVCMVMIN, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                    .addComponent(jTextField195)
                                    .addComponent(jTextField194))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel177)
                                    .addComponent(jLabel176)
                                    .addComponent(jLabel175))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField196, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField197, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)))))
                    .addComponent(jLabel171, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel171)
                .addGap(18, 18, 18)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel172)
                    .addComponent(jLabel173)
                    .addComponent(jLabel174))
                .addGap(1, 1, 1)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CVCMVMAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel168))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField191, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel169))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField190, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel170)))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(CVCMVMED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField192, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField193, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(CVCMVMIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField195, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField194, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField197, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel175))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField196, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel176))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel177)
                            .addComponent(jButton4))))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mangueraA2Layout = new javax.swing.GroupLayout(mangueraA2);
        mangueraA2.setLayout(mangueraA2Layout);
        mangueraA2Layout.setHorizontalGroup(
            mangueraA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mangueraA2Layout.createSequentialGroup()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(mangueraA2Layout.createSequentialGroup()
                .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        mangueraA2Layout.setVerticalGroup(
            mangueraA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mangueraA2Layout.createSequentialGroup()
                .addGroup(mangueraA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mangueraA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Manguera C", mangueraA2);

        mangueraA3.setAutoscrolls(true);

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));

        jLabel178.setText("Gastos");

        jLabel179.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel179.setText("Máximo(ml)");

        jLabel180.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel180.setForeground(new java.awt.Color(0, 51, 153));
        jLabel180.setText("Pruebas Meterológicas");

        jLabel181.setText("Lado D: ");

        jLabel182.setText("TipoGas");

        jLabel183.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel183.setText("Medio(ml)");

        jLabel184.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel184.setText("Minimo(ml)");

        DP1MAX.setText("-10");

        DP1MED.setText("-10");

        DP1MIN.setText("-10");

        DP2MIN.setText("-10");

        DP2MAX.setText("-10");

        DP2MED.setText("-10");

        DP3MIN.setText("-10");

        DP3MED.setText("-10");

        DP3MAX.setText("-10");

        DLCMAX.setEditable(false);

        DLCMED.setEditable(false);

        DLCMIN.setEditable(false);

        jTextField210.setText("-10");

        jTextField211.setText("-10");

        jTextField212.setText("-10");

        jLabel185.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel185.setText("Máximo");

        jLabel186.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel186.setText("Medio");

        jLabel187.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel187.setText("Minimo");

        DTMEDP1.setText("0");

        DTMEDP2.setText("0");

        DTMEDP3.setText("0");

        DTMAXP3.setText("0");

        DTMINP1.setText("0");

        DTMINP3.setText("0");

        DTMAXP2.setText("0");

        DTMINP2.setText("0");

        DTMAXP1.setText("0");

        jLabel188.setText("Prueba1");

        jLabel189.setText("Prueba2");

        jLabel190.setText("Prueba3");

        jLabel191.setText("LC");

        jLabel192.setText("Err.Rep");

        jLabel193.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel193.setText("Temperatura");

        jLabel194.setText("Prueba1");

        jLabel195.setText("Prueba2");

        jLabel196.setText("Prueba3");

        jTextField222.setText("0");

        jTextField223.setText("0");

        jTextField224.setText("0");

        jTextField225.setText("0");

        jTextField226.setText("0");

        jTextField227.setText("0");

        jTextField228.setText("0");

        jTextField229.setText("0");

        jTextField230.setText("0");

        jLabel197.setText("Prueba3");

        jLabel198.setText("Prueba2");

        jLabel199.setText("Prueba1");

        jLabel200.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel200.setText("Tiempo");

        jLabel201.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel201.setText("Máximo");

        jLabel202.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel202.setText("Medio");

        jLabel203.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel203.setText("Minimo");

        jTextField231.setText("20000");

        jTextField232.setText("20000");

        jTextField233.setText("20000");

        jTextField234.setText("20000");

        jTextField235.setText("20000");

        jTextField236.setText("20000");

        jTextField237.setText("20000");

        jTextField238.setText("20000");

        jTextField239.setText("20000");

        jTextField240.setText("20000");

        jTextField241.setText("20000");

        jTextField242.setText("20000");

        jLabel204.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel204.setText("Máximo(ml)");

        jLabel205.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel205.setText("Medio(ml)");

        jLabel206.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel206.setText("Minimo(ml)");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel179)
                                        .addComponent(jLabel183)
                                        .addComponent(jLabel184))
                                    .addComponent(jLabel204, javax.swing.GroupLayout.Alignment.LEADING))
                                .addComponent(jLabel205, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel206, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DP1MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(DP1MAX, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                                        .addComponent(DP1MED))
                                    .addComponent(jLabel188))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel26Layout.createSequentialGroup()
                                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(DP2MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(DP2MAX)
                                                .addComponent(DP2MED, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(DP3MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(DP3MAX)
                                                .addComponent(DP3MED, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(DLCMIN, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(DLCMAX)
                                                .addComponent(DLCMED, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField210, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jTextField211)
                                                .addComponent(jTextField212, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel185)
                                            .addComponent(jLabel186)
                                            .addComponent(jLabel187)
                                            .addComponent(jLabel200)
                                            .addComponent(jLabel201)
                                            .addComponent(jLabel202)
                                            .addComponent(jLabel203))
                                        .addGap(23, 23, 23))
                                    .addGroup(jPanel26Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel189)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel190)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel191)
                                        .addGap(23, 23, 23)
                                        .addComponent(jLabel192)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel193))))
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField241, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField231)
                                        .addComponent(jTextField242, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField240, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField232)
                                        .addComponent(jTextField239, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField237, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField233)
                                        .addComponent(jTextField238, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField236, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField234)
                                        .addComponent(jTextField235, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DTMINP1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(DTMAXP1)
                                        .addComponent(DTMEDP1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel194, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(DTMINP2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(DTMAXP2)
                                            .addComponent(DTMEDP2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel195))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(DTMINP3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(DTMAXP3)
                                            .addComponent(DTMEDP3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel196)))
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField224, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField223)
                                        .addComponent(jTextField222, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel199))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel26Layout.createSequentialGroup()
                                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField227, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jTextField225)
                                                .addComponent(jTextField226, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField228, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jTextField230)
                                                .addComponent(jTextField229, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel26Layout.createSequentialGroup()
                                        .addComponent(jLabel198)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel197)))))
                        .addGap(30, 30, 30))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addComponent(jLabel180)
                                .addGap(67, 67, 67)
                                .addComponent(jLabel181)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel182))
                            .addComponent(jLabel178))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel180)
                    .addComponent(jLabel181)
                    .addComponent(jLabel182))
                .addGap(30, 30, 30)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel178)
                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel188)
                        .addComponent(jLabel189)
                        .addComponent(jLabel190)
                        .addComponent(jLabel191)
                        .addComponent(jLabel192)
                        .addComponent(jLabel194)
                        .addComponent(jLabel195)
                        .addComponent(jLabel196)
                        .addComponent(jLabel193)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(DTMAXP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DTMEDP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DTMINP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(DTMAXP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DTMEDP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DTMINP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(DTMAXP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DTMEDP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DTMINP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel197)
                            .addComponent(jLabel198)
                            .addComponent(jLabel199)
                            .addComponent(jLabel200))
                        .addGroup(jPanel26Layout.createSequentialGroup()
                            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel26Layout.createSequentialGroup()
                                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel179)
                                        .addComponent(DP1MAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel183)
                                        .addComponent(DP1MED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel184)
                                        .addComponent(DP1MIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel26Layout.createSequentialGroup()
                                    .addComponent(DP2MAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(DP2MED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(DP2MIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel26Layout.createSequentialGroup()
                                    .addComponent(DP3MAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(DP3MED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(DP3MIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel26Layout.createSequentialGroup()
                                    .addComponent(DLCMAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(DLCMED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(DLCMIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel26Layout.createSequentialGroup()
                                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField211, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel185))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField212, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField210, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel187)))
                                .addGroup(jPanel26Layout.createSequentialGroup()
                                    .addGap(32, 32, 32)
                                    .addComponent(jLabel186)))
                            .addGap(43, 43, 43))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(jTextField225, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField226, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField227, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(jTextField230, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField229, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField228, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField231, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel204))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField242, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel205))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField241, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel206)))
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addComponent(jTextField232, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField239, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField240, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addComponent(jTextField233, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField238, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField237, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addComponent(jTextField234, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField235, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField236, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel26Layout.createSequentialGroup()
                            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField223, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel201))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField222, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel202))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField224, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel203)))))
                .addGap(35, 35, 35))
        );

        jPanel27.setBackground(new java.awt.Color(204, 255, 204));

        jLabel207.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel207.setText("Jarra");

        DV20.setText("0");

        DKC.setText("0");

        jLabel208.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel208.setText("KC");

        jLabel209.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel209.setText("V20");

        jLabel210.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel210.setForeground(new java.awt.Color(0, 51, 153));
        jLabel210.setText("Información de la Jarra");

        jLabel211.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel211.setText("Fecha Calib.");

        jLabel212.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel212.setText("Inf. Calib.");

        jComboBoxJarraD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jLabel210, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel207)
                                .addComponent(jLabel209, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel208, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxJarraD, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DV20)
                            .addComponent(DKC, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addComponent(jLabel212)
                                .addGap(9, 9, 9))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                                .addComponent(jLabel211)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField243)
                            .addComponent(jTextField244, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel210)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel207)
                                    .addComponent(jComboBoxJarraD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(DV20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel209)))
                            .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel212)
                                .addComponent(jTextField244, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DKC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel208)))
                    .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField243, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel211)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel28.setBackground(new java.awt.Color(255, 153, 153));

        jPanel29.setBackground(new java.awt.Color(204, 255, 204));

        jLabel213.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel213.setForeground(new java.awt.Color(0, 102, 51));
        jLabel213.setText("ACEPTADA");

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel213)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel213)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel214.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel214.setText("Total Inicial:");

        jLabel215.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel215.setText("Total Final:");

        jLabel216.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel216.setText("Calc. PROFECO.");

        jLabel217.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel217.setText("Calc. UVA.");

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel217)
                    .addComponent(jLabel216)
                    .addComponent(jLabel215)
                    .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel214))
                .addGap(18, 18, 18)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField247, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField248, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField249, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField250, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel214)
                    .addComponent(jTextField247, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel215)
                    .addComponent(jTextField248, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel216)
                    .addComponent(jTextField249, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel217)
                    .addComponent(jTextField250, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel30.setBackground(new java.awt.Color(153, 204, 255));

        DVCMVMIN.setEditable(false);

        DVCMVMED.setEditable(false);

        DVCMVMAX.setEditable(false);

        jLabel218.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel218.setText("Vcmv");

        jLabel219.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel219.setText("E");

        jLabel220.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel220.setText("qv");

        jTextField255.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField255ActionPerformed(evt);
            }
        });

        jLabel221.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel221.setForeground(new java.awt.Color(0, 51, 153));
        jLabel221.setText("Resultados");

        jLabel222.setText("G. Máximo");

        jLabel223.setText("G. Medio");

        jLabel224.setText("G. Mínimo");

        jLabel225.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel225.setText("ml");

        jLabel226.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel226.setText("ml");

        jLabel227.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel227.setText("l./mn.");

        jTextField260.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField260ActionPerformed(evt);
            }
        });

        jButton5.setText("Incluir");

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel218)
                                .addComponent(jLabel219, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel220, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel222)
                            .addComponent(jTextField255)
                            .addComponent(jTextField254)
                            .addComponent(DVCMVMAX, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(DVCMVMED, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                .addComponent(jTextField256)
                                .addComponent(jTextField257))
                            .addComponent(jLabel223))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel30Layout.createSequentialGroup()
                                .addComponent(jLabel224)
                                .addGap(185, 185, 185))
                            .addGroup(jPanel30Layout.createSequentialGroup()
                                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(DVCMVMIN, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                    .addComponent(jTextField259)
                                    .addComponent(jTextField258))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel227)
                                    .addComponent(jLabel226)
                                    .addComponent(jLabel225))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField260, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField261, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)))))
                    .addComponent(jLabel221, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel221)
                .addGap(18, 18, 18)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel222)
                    .addComponent(jLabel223)
                    .addComponent(jLabel224))
                .addGap(1, 1, 1)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DVCMVMAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel218))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField255, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel219))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField254, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel220)))
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addComponent(DVCMVMED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField256, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField257, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addComponent(DVCMVMIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField259, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField258, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField261, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel225))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField260, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel226))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel227)
                            .addComponent(jButton5))))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mangueraA3Layout = new javax.swing.GroupLayout(mangueraA3);
        mangueraA3.setLayout(mangueraA3Layout);
        mangueraA3Layout.setHorizontalGroup(
            mangueraA3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mangueraA3Layout.createSequentialGroup()
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(mangueraA3Layout.createSequentialGroup()
                .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        mangueraA3Layout.setVerticalGroup(
            mangueraA3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mangueraA3Layout.createSequentialGroup()
                .addGroup(mangueraA3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mangueraA3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Manguera D", mangueraA3);

        mangueraA4.setAutoscrolls(true);

        jPanel31.setBackground(new java.awt.Color(255, 255, 255));

        jLabel228.setText("Gastos");

        jLabel229.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel229.setText("Máximo(ml)");

        jLabel230.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel230.setForeground(new java.awt.Color(0, 51, 153));
        jLabel230.setText("Pruebas Meterológicas");

        jLabel231.setText("Lado E: ");

        jLabel232.setText("TipoGas");

        jLabel233.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel233.setText("Medio(ml)");

        jLabel234.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel234.setText("Minimo(ml)");

        EP1MAX.setText("-10");

        EP1MED.setText("-10");

        EP1MIN.setText("-10");

        EP2MIN.setText("-10");

        EP2MAX.setText("-10");

        EP2MED.setText("-10");

        EP3MIN.setText("-10");

        EP3MED.setText("-10");

        EP3MAX.setText("-10");

        ELCMAX.setEditable(false);

        ELCMED.setEditable(false);

        ELCMIN.setEditable(false);

        jTextField274.setText("-10");

        jTextField275.setText("-10");

        jTextField276.setText("-10");

        jLabel235.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel235.setText("Máximo");

        jLabel236.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel236.setText("Medio");

        jLabel237.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel237.setText("Minimo");

        ETMEDP1.setText("0");

        ETMEDP2.setText("0");

        ETMEDP3.setText("0");

        ETMAXP3.setText("0");

        ETMINP1.setText("0");

        ETMINP3.setText("0");

        ETMAXP2.setText("0");

        ETMINP2.setText("0");

        ETMAXP1.setText("0");

        jLabel238.setText("Prueba1");

        jLabel239.setText("Prueba2");

        jLabel240.setText("Prueba3");

        jLabel241.setText("LC");

        jLabel242.setText("Err.Rep");

        jLabel243.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel243.setText("Temperatura");

        jLabel244.setText("Prueba1");

        jLabel245.setText("Prueba2");

        jLabel246.setText("Prueba3");

        jTextField286.setText("0");

        jTextField287.setText("0");

        jTextField288.setText("0");

        jTextField289.setText("0");

        jTextField290.setText("0");

        jTextField291.setText("0");

        jTextField292.setText("0");

        jTextField293.setText("0");

        jTextField294.setText("0");

        jLabel247.setText("Prueba3");

        jLabel248.setText("Prueba2");

        jLabel249.setText("Prueba1");

        jLabel250.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel250.setText("Tiempo");

        jLabel251.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel251.setText("Máximo");

        jLabel252.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel252.setText("Medio");

        jLabel253.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel253.setText("Minimo");

        jTextField295.setText("20000");

        jTextField296.setText("20000");

        jTextField297.setText("20000");

        jTextField298.setText("20000");

        jTextField299.setText("20000");

        jTextField300.setText("20000");

        jTextField301.setText("20000");

        jTextField302.setText("20000");

        jTextField303.setText("20000");

        jTextField304.setText("20000");

        jTextField305.setText("20000");

        jTextField306.setText("20000");

        jLabel254.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel254.setText("Máximo(ml)");

        jLabel255.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel255.setText("Medio(ml)");

        jLabel256.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel256.setText("Minimo(ml)");

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel229)
                                        .addComponent(jLabel233)
                                        .addComponent(jLabel234))
                                    .addComponent(jLabel254, javax.swing.GroupLayout.Alignment.LEADING))
                                .addComponent(jLabel255, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel256, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel31Layout.createSequentialGroup()
                                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(EP1MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(EP1MAX, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                                        .addComponent(EP1MED))
                                    .addComponent(jLabel238))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel31Layout.createSequentialGroup()
                                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(EP2MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(EP2MAX)
                                                .addComponent(EP2MED, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(EP3MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(EP3MAX)
                                                .addComponent(EP3MED, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ELCMIN, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(ELCMAX)
                                                .addComponent(ELCMED, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField274, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jTextField275)
                                                .addComponent(jTextField276, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel235)
                                            .addComponent(jLabel236)
                                            .addComponent(jLabel237)
                                            .addComponent(jLabel250)
                                            .addComponent(jLabel251)
                                            .addComponent(jLabel252)
                                            .addComponent(jLabel253))
                                        .addGap(23, 23, 23))
                                    .addGroup(jPanel31Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel239)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel240)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel241)
                                        .addGap(23, 23, 23)
                                        .addComponent(jLabel242)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel243))))
                            .addGroup(jPanel31Layout.createSequentialGroup()
                                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField305, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField295)
                                        .addComponent(jTextField306, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField304, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField296)
                                        .addComponent(jTextField303, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField301, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField297)
                                        .addComponent(jTextField302, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField300, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField298)
                                        .addComponent(jTextField299, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel31Layout.createSequentialGroup()
                                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ETMINP1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(ETMAXP1)
                                        .addComponent(ETMEDP1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel244, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ETMINP2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(ETMAXP2)
                                            .addComponent(ETMEDP2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel245))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ETMINP3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(ETMAXP3)
                                            .addComponent(ETMEDP3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel246)))
                            .addGroup(jPanel31Layout.createSequentialGroup()
                                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField288, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField287)
                                        .addComponent(jTextField286, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel249))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel31Layout.createSequentialGroup()
                                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField291, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jTextField289)
                                                .addComponent(jTextField290, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField292, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jTextField294)
                                                .addComponent(jTextField293, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel31Layout.createSequentialGroup()
                                        .addComponent(jLabel248)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel247)))))
                        .addGap(30, 30, 30))
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel31Layout.createSequentialGroup()
                                .addComponent(jLabel230)
                                .addGap(67, 67, 67)
                                .addComponent(jLabel231)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel232))
                            .addComponent(jLabel228))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel230)
                    .addComponent(jLabel231)
                    .addComponent(jLabel232))
                .addGap(30, 30, 30)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel228)
                    .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel238)
                        .addComponent(jLabel239)
                        .addComponent(jLabel240)
                        .addComponent(jLabel241)
                        .addComponent(jLabel242)
                        .addComponent(jLabel244)
                        .addComponent(jLabel245)
                        .addComponent(jLabel246)
                        .addComponent(jLabel243)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(ETMAXP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ETMEDP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ETMINP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(ETMAXP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ETMEDP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ETMINP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(ETMAXP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ETMEDP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ETMINP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel247)
                            .addComponent(jLabel248)
                            .addComponent(jLabel249)
                            .addComponent(jLabel250))
                        .addGroup(jPanel31Layout.createSequentialGroup()
                            .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel31Layout.createSequentialGroup()
                                    .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel229)
                                        .addComponent(EP1MAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel233)
                                        .addComponent(EP1MED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel234)
                                        .addComponent(EP1MIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel31Layout.createSequentialGroup()
                                    .addComponent(EP2MAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(EP2MED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(EP2MIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel31Layout.createSequentialGroup()
                                    .addComponent(EP3MAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(EP3MED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(EP3MIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel31Layout.createSequentialGroup()
                                    .addComponent(ELCMAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(ELCMED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(ELCMIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel31Layout.createSequentialGroup()
                                    .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField275, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel235))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField276, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField274, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel237)))
                                .addGroup(jPanel31Layout.createSequentialGroup()
                                    .addGap(32, 32, 32)
                                    .addComponent(jLabel236)))
                            .addGap(43, 43, 43))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(jTextField289, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField290, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField291, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(jTextField294, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField293, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField292, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel31Layout.createSequentialGroup()
                                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField295, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel254))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField306, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel255))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField305, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel256)))
                            .addGroup(jPanel31Layout.createSequentialGroup()
                                .addComponent(jTextField296, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField303, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField304, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel31Layout.createSequentialGroup()
                                .addComponent(jTextField297, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField302, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField301, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel31Layout.createSequentialGroup()
                                .addComponent(jTextField298, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField299, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField300, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel31Layout.createSequentialGroup()
                            .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField287, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel251))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField286, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel252))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField288, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel253)))))
                .addGap(35, 35, 35))
        );

        jPanel32.setBackground(new java.awt.Color(204, 255, 204));

        jLabel257.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel257.setText("Jarra");

        EV20.setText("0");

        EKC.setText("0");

        jLabel258.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel258.setText("KC");

        jLabel259.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel259.setText("V20");

        jLabel260.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel260.setForeground(new java.awt.Color(0, 51, 153));
        jLabel260.setText("Información de la Jarra");

        jLabel261.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel261.setText("Fecha Calib.");

        jLabel262.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel262.setText("Inf. Calib.");

        jComboBoxJarraE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addComponent(jLabel260, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel257)
                                .addComponent(jLabel259, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel258, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxJarraE, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(EV20)
                            .addComponent(EKC, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel32Layout.createSequentialGroup()
                                .addComponent(jLabel262)
                                .addGap(9, 9, 9))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                                .addComponent(jLabel261)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField307)
                            .addComponent(jTextField308, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel260)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel32Layout.createSequentialGroup()
                                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel257)
                                    .addComponent(jComboBoxJarraE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(EV20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel259)))
                            .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel262)
                                .addComponent(jTextField308, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EKC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel258)))
                    .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField307, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel261)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel33.setBackground(new java.awt.Color(255, 153, 153));

        jPanel34.setBackground(new java.awt.Color(204, 255, 204));

        jLabel263.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel263.setForeground(new java.awt.Color(0, 102, 51));
        jLabel263.setText("ACEPTADA");

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel263)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel263)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel264.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel264.setText("Total Inicial:");

        jLabel265.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel265.setText("Total Final:");

        jLabel266.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel266.setText("Calc. PROFECO.");

        jLabel267.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel267.setText("Calc. UVA.");

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel267)
                    .addComponent(jLabel266)
                    .addComponent(jLabel265)
                    .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel264))
                .addGap(18, 18, 18)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField311, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField312, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField313, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField314, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel264)
                    .addComponent(jTextField311, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel265)
                    .addComponent(jTextField312, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel266)
                    .addComponent(jTextField313, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel267)
                    .addComponent(jTextField314, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel35.setBackground(new java.awt.Color(153, 204, 255));

        EVCMVMIN.setEditable(false);

        EVCMVMED.setEditable(false);

        EVCMVMAX.setEditable(false);

        jLabel268.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel268.setText("Vcmv");

        jLabel269.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel269.setText("E");

        jLabel270.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel270.setText("qv");

        jTextField319.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField319ActionPerformed(evt);
            }
        });

        jLabel271.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel271.setForeground(new java.awt.Color(0, 51, 153));
        jLabel271.setText("Resultados");

        jLabel272.setText("G. Máximo");

        jLabel273.setText("G. Medio");

        jLabel274.setText("G. Mínimo");

        jLabel275.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel275.setText("ml");

        jLabel276.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel276.setText("ml");

        jLabel277.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel277.setText("l./mn.");

        jTextField324.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField324ActionPerformed(evt);
            }
        });

        jButton6.setText("Incluir");

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel268)
                                .addComponent(jLabel269, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel270, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel272)
                            .addComponent(jTextField319)
                            .addComponent(jTextField318)
                            .addComponent(EVCMVMAX, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(EVCMVMED, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                .addComponent(jTextField320)
                                .addComponent(jTextField321))
                            .addComponent(jLabel273))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel35Layout.createSequentialGroup()
                                .addComponent(jLabel274)
                                .addGap(185, 185, 185))
                            .addGroup(jPanel35Layout.createSequentialGroup()
                                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(EVCMVMIN, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                    .addComponent(jTextField323)
                                    .addComponent(jTextField322))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel277)
                                    .addComponent(jLabel276)
                                    .addComponent(jLabel275))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField324, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField325, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)))))
                    .addComponent(jLabel271, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel271)
                .addGap(18, 18, 18)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel272)
                    .addComponent(jLabel273)
                    .addComponent(jLabel274))
                .addGap(1, 1, 1)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EVCMVMAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel268))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField319, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel269))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField318, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel270)))
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addComponent(EVCMVMED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField320, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField321, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addComponent(EVCMVMIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField323, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField322, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField325, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel275))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField324, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel276))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel277)
                            .addComponent(jButton6))))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mangueraA4Layout = new javax.swing.GroupLayout(mangueraA4);
        mangueraA4.setLayout(mangueraA4Layout);
        mangueraA4Layout.setHorizontalGroup(
            mangueraA4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mangueraA4Layout.createSequentialGroup()
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(mangueraA4Layout.createSequentialGroup()
                .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        mangueraA4Layout.setVerticalGroup(
            mangueraA4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mangueraA4Layout.createSequentialGroup()
                .addGroup(mangueraA4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mangueraA4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Manguera E", mangueraA4);

        mangueraA5.setAutoscrolls(true);

        jPanel36.setBackground(new java.awt.Color(255, 255, 255));

        jLabel278.setText("Gastos");

        jLabel279.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel279.setText("Máximo(ml)");

        jLabel280.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel280.setForeground(new java.awt.Color(0, 51, 153));
        jLabel280.setText("Pruebas Meterológicas");

        jLabel281.setText("Lado F: ");

        jLabel282.setText("TipoGas");

        jLabel283.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel283.setText("Medio(ml)");

        jLabel284.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel284.setText("Minimo(ml)");

        FP1MAX.setText("-10");

        FP1MED.setText("-10");

        FP1MIN.setText("-10");

        FP2MIN.setText("-10");

        FP2MAX.setText("-10");

        FP2MED.setText("-10");

        FP3MIN.setText("-10");

        FP3MED.setText("-10");

        FP3MAX.setText("-10");

        FLCMAX.setEditable(false);

        FLCMED.setEditable(false);

        FLCMIN.setEditable(false);

        jTextField338.setText("-10");

        jTextField339.setText("-10");

        jTextField340.setText("-10");

        jLabel285.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel285.setText("Máximo");

        jLabel286.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel286.setText("Medio");

        jLabel287.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel287.setText("Minimo");

        FTMEDP1.setText("0");

        FTMEDP2.setText("0");

        FTMEDP3.setText("0");

        FTMAXP3.setText("0");

        FTMINP1.setText("0");

        FTMINP3.setText("0");

        FTMAXP2.setText("0");

        FTMINP2.setText("0");

        FTMAXP1.setText("0");

        jLabel288.setText("Prueba1");

        jLabel289.setText("Prueba2");

        jLabel290.setText("Prueba3");

        jLabel291.setText("LC");

        jLabel292.setText("Err.Rep");

        jLabel293.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel293.setText("Temperatura");

        jLabel294.setText("Prueba1");

        jLabel295.setText("Prueba2");

        jLabel296.setText("Prueba3");

        jTextField350.setText("0");

        jTextField351.setText("0");

        jTextField352.setText("0");

        jTextField353.setText("0");

        jTextField354.setText("0");

        jTextField355.setText("0");

        jTextField356.setText("0");

        jTextField357.setText("0");

        jTextField358.setText("0");

        jLabel297.setText("Prueba3");

        jLabel298.setText("Prueba2");

        jLabel299.setText("Prueba1");

        jLabel300.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel300.setText("Tiempo");

        jLabel301.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel301.setText("Máximo");

        jLabel302.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel302.setText("Medio");

        jLabel303.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel303.setText("Minimo");

        jTextField359.setText("20000");

        jTextField360.setText("20000");

        jTextField361.setText("20000");

        jTextField362.setText("20000");

        jTextField363.setText("20000");

        jTextField364.setText("20000");

        jTextField365.setText("20000");

        jTextField366.setText("20000");

        jTextField367.setText("20000");

        jTextField368.setText("20000");

        jTextField369.setText("20000");

        jTextField370.setText("20000");

        jLabel304.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel304.setText("Máximo(ml)");

        jLabel305.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel305.setText("Medio(ml)");

        jLabel306.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel306.setText("Minimo(ml)");

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel279)
                                        .addComponent(jLabel283)
                                        .addComponent(jLabel284))
                                    .addComponent(jLabel304, javax.swing.GroupLayout.Alignment.LEADING))
                                .addComponent(jLabel305, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel306, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel36Layout.createSequentialGroup()
                                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(FP1MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(FP1MAX, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                                        .addComponent(FP1MED))
                                    .addComponent(jLabel288))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel36Layout.createSequentialGroup()
                                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(FP2MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(FP2MAX)
                                                .addComponent(FP2MED, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(FP3MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(FP3MAX)
                                                .addComponent(FP3MED, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(FLCMIN, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(FLCMAX)
                                                .addComponent(FLCMED, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField338, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jTextField339)
                                                .addComponent(jTextField340, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel285)
                                            .addComponent(jLabel286)
                                            .addComponent(jLabel287)
                                            .addComponent(jLabel300)
                                            .addComponent(jLabel301)
                                            .addComponent(jLabel302)
                                            .addComponent(jLabel303))
                                        .addGap(23, 23, 23))
                                    .addGroup(jPanel36Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel289)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel290)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel291)
                                        .addGap(23, 23, 23)
                                        .addComponent(jLabel292)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel293))))
                            .addGroup(jPanel36Layout.createSequentialGroup()
                                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField369, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField359)
                                        .addComponent(jTextField370, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField368, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField360)
                                        .addComponent(jTextField367, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField365, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField361)
                                        .addComponent(jTextField366, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField364, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField362)
                                        .addComponent(jTextField363, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel36Layout.createSequentialGroup()
                                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(FTMINP1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(FTMAXP1)
                                        .addComponent(FTMEDP1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel294, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(FTMINP2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(FTMAXP2)
                                            .addComponent(FTMEDP2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel295))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(FTMINP3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(FTMAXP3)
                                            .addComponent(FTMEDP3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel296)))
                            .addGroup(jPanel36Layout.createSequentialGroup()
                                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField352, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField351)
                                        .addComponent(jTextField350, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel299))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel36Layout.createSequentialGroup()
                                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField355, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jTextField353)
                                                .addComponent(jTextField354, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField356, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jTextField358)
                                                .addComponent(jTextField357, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel36Layout.createSequentialGroup()
                                        .addComponent(jLabel298)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel297)))))
                        .addGap(30, 30, 30))
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel36Layout.createSequentialGroup()
                                .addComponent(jLabel280)
                                .addGap(67, 67, 67)
                                .addComponent(jLabel281)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel282))
                            .addComponent(jLabel278))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel280)
                    .addComponent(jLabel281)
                    .addComponent(jLabel282))
                .addGap(30, 30, 30)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel278)
                    .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel288)
                        .addComponent(jLabel289)
                        .addComponent(jLabel290)
                        .addComponent(jLabel291)
                        .addComponent(jLabel292)
                        .addComponent(jLabel294)
                        .addComponent(jLabel295)
                        .addComponent(jLabel296)
                        .addComponent(jLabel293)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(FTMAXP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FTMEDP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FTMINP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(FTMAXP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FTMEDP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FTMINP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(FTMAXP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FTMEDP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FTMINP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel297)
                            .addComponent(jLabel298)
                            .addComponent(jLabel299)
                            .addComponent(jLabel300))
                        .addGroup(jPanel36Layout.createSequentialGroup()
                            .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel36Layout.createSequentialGroup()
                                    .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel279)
                                        .addComponent(FP1MAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel283)
                                        .addComponent(FP1MED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel284)
                                        .addComponent(FP1MIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel36Layout.createSequentialGroup()
                                    .addComponent(FP2MAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(FP2MED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(FP2MIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel36Layout.createSequentialGroup()
                                    .addComponent(FP3MAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(FP3MED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(FP3MIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel36Layout.createSequentialGroup()
                                    .addComponent(FLCMAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(FLCMED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(FLCMIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel36Layout.createSequentialGroup()
                                    .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField339, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel285))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField340, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField338, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel287)))
                                .addGroup(jPanel36Layout.createSequentialGroup()
                                    .addGap(32, 32, 32)
                                    .addComponent(jLabel286)))
                            .addGap(43, 43, 43))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(jTextField353, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField354, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField355, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(jTextField358, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField357, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField356, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel36Layout.createSequentialGroup()
                                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField359, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel304))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField370, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel305))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField369, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel306)))
                            .addGroup(jPanel36Layout.createSequentialGroup()
                                .addComponent(jTextField360, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField367, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField368, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel36Layout.createSequentialGroup()
                                .addComponent(jTextField361, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField366, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField365, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel36Layout.createSequentialGroup()
                                .addComponent(jTextField362, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField363, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField364, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel36Layout.createSequentialGroup()
                            .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField351, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel301))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField350, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel302))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField352, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel303)))))
                .addGap(35, 35, 35))
        );

        jPanel37.setBackground(new java.awt.Color(204, 255, 204));

        jLabel307.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel307.setText("Jarra");

        FV20.setText("0");

        FKC.setText("0");

        jLabel308.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel308.setText("KC");

        jLabel309.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel309.setText("V20");

        jLabel310.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel310.setForeground(new java.awt.Color(0, 51, 153));
        jLabel310.setText("Información de la Jarra");

        jLabel311.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel311.setText("Fecha Calib.");

        jLabel312.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel312.setText("Inf. Calib.");

        jComboBoxJarraF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addComponent(jLabel310, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel307)
                                .addComponent(jLabel309, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel308, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxJarraF, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(FV20)
                            .addComponent(FKC, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel37Layout.createSequentialGroup()
                                .addComponent(jLabel312)
                                .addGap(9, 9, 9))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                                .addComponent(jLabel311)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField371)
                            .addComponent(jTextField372, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel310)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel37Layout.createSequentialGroup()
                                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel307)
                                    .addComponent(jComboBoxJarraF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(FV20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel309)))
                            .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel312)
                                .addComponent(jTextField372, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FKC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel308)))
                    .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField371, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel311)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel38.setBackground(new java.awt.Color(255, 153, 153));

        jPanel39.setBackground(new java.awt.Color(204, 255, 204));

        jLabel313.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel313.setForeground(new java.awt.Color(0, 102, 51));
        jLabel313.setText("ACEPTADA");

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel313)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel313)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel314.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel314.setText("Total Inicial:");

        jLabel315.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel315.setText("Total Final:");

        jLabel316.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel316.setText("Calc. PROFECO.");

        jLabel317.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel317.setText("Calc. UVA.");

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel317)
                    .addComponent(jLabel316)
                    .addComponent(jLabel315)
                    .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel314))
                .addGap(18, 18, 18)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField375, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField376, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField377, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField378, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel314)
                    .addComponent(jTextField375, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel315)
                    .addComponent(jTextField376, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel316)
                    .addComponent(jTextField377, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel317)
                    .addComponent(jTextField378, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel40.setBackground(new java.awt.Color(153, 204, 255));

        FVCMVMIN.setEditable(false);

        FVCMVMED.setEditable(false);

        FVCMVMAX.setEditable(false);

        jLabel318.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel318.setText("Vcmv");

        jLabel319.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel319.setText("E");

        jLabel320.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel320.setText("qv");

        jTextField383.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField383ActionPerformed(evt);
            }
        });

        jLabel321.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel321.setForeground(new java.awt.Color(0, 51, 153));
        jLabel321.setText("Resultados");

        jLabel322.setText("G. Máximo");

        jLabel323.setText("G. Medio");

        jLabel324.setText("G. Mínimo");

        jLabel325.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel325.setText("ml");

        jLabel326.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel326.setText("ml");

        jLabel327.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel327.setText("l./mn.");

        jTextField388.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField388ActionPerformed(evt);
            }
        });

        jButton7.setText("Incluir");

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel318)
                                .addComponent(jLabel319, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel320, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel322)
                            .addComponent(jTextField383)
                            .addComponent(jTextField382)
                            .addComponent(FVCMVMAX, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(FVCMVMED, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                .addComponent(jTextField384)
                                .addComponent(jTextField385))
                            .addComponent(jLabel323))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel40Layout.createSequentialGroup()
                                .addComponent(jLabel324)
                                .addGap(185, 185, 185))
                            .addGroup(jPanel40Layout.createSequentialGroup()
                                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(FVCMVMIN, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                    .addComponent(jTextField387)
                                    .addComponent(jTextField386))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel327)
                                    .addComponent(jLabel326)
                                    .addComponent(jLabel325))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField388, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField389, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)))))
                    .addComponent(jLabel321, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel321)
                .addGap(18, 18, 18)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel322)
                    .addComponent(jLabel323)
                    .addComponent(jLabel324))
                .addGap(1, 1, 1)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FVCMVMAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel318))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField383, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel319))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField382, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel320)))
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addComponent(FVCMVMED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField384, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField385, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addComponent(FVCMVMIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField387, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField386, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField389, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel325))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField388, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel326))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel327)
                            .addComponent(jButton7))))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mangueraA5Layout = new javax.swing.GroupLayout(mangueraA5);
        mangueraA5.setLayout(mangueraA5Layout);
        mangueraA5Layout.setHorizontalGroup(
            mangueraA5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mangueraA5Layout.createSequentialGroup()
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(mangueraA5Layout.createSequentialGroup()
                .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        mangueraA5Layout.setVerticalGroup(
            mangueraA5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mangueraA5Layout.createSequentialGroup()
                .addGroup(mangueraA5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mangueraA5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Manguera F", mangueraA5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void folioSolicitudKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_folioSolicitudKeyPressed
        // TODO add your handling code here:
       if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER){
           
            String folioSol = folioSolicitud.getText();
            int validaFSol = 0;

            lbd.openConnection();
            validaFSol = lbd.validaFolioSolicitud(folioSol);
            lbd.closeConnection();

            if(validaFSol != 0){

                JOptionPane.showMessageDialog(null,"El folio es valido, da clic al boton imprimir para continuar.");
                
            }
            else{

                JOptionPane.showMessageDialog(null,"No existe el folio que quiere imprimir");
            }
       }
           
    }//GEN-LAST:event_folioSolicitudKeyPressed

    private void jButtonImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImprimirActionPerformed
        // TODO add your handling code here:
        int tipoDocumento = 1;
        if(jCheckBoxImprimir.isSelected()){
            //jButtonImprimir.setEnabled(true);
            Object [] arregloDatosDoc;
            String folioSol = folioSolicitud.getText();
            int validaFSol = 0;

            lbd.openConnection();
            validaFSol = lbd.validaFolioSolicitud(folioSol);
            lbd.closeConnection();
       
            if(validaFSol != 0){

                // JOptionPane.showMessageDialog(null,"El folio es valido, da clic al boton imprimir para continuar.");
                //Imprimo el documento
                //Lista de datos que se necesitan:
                /*
                «FolioContrato»,
                «REPRESENTGASO»,
                «RAZONSOCIAL»,
                «REPRESENTANTEEMPRESA»,
                «REPRESENTANTEEMPRESA»,
                «RAZONSOCIAL»,
                «CIUDAD»,
                «ESTADO»,
                «FECHAVERIFICACION»
                */
                /*Creo un arreglo con las etiquetas que se necesitan modificar/reemplazar*/
                String [] etiquetasReemplazo = {"«FolioContrato»",
                    "«REPRESENTGASO»",
                    "«RAZONSOCIAL»",
                    "«REPRESENTANTEEMPRESA»",
                    //"«REPRESENTANTEEMPRESA»",// Se repite :v
                    "«CIUDAD»",
                    "«ESTADO»",
                    "«FECHAVERIFICACION»",
                    "«TESTIGO»"};
                /*Recupero la información para mi documento :) */
                lbd.openConnection();
                arregloDatosDoc = lbd.obtenerDatosContrato(folioSol);
                lbd.closeConnection();
                System.out.println("Datos:"+arregloDatosDoc.length+"Etiquetas:"+etiquetasReemplazo.length);
                try {
                    /*Inserto los valores al documento machote y lo guardo en la nueva ubicación*/
//                    for (Object arregloDatosDoc1 : arregloDatosDoc) {
//                        //arregloDatosDoc[i];
//                        System.out.println("" + arregloDatosDoc1);
//                    }
                    reporteWord.creaDocContrato(etiquetasReemplazo,arregloDatosDoc,tipoDocumento,folioSol);
                } catch (InvalidFormatException | IOException ex) {
                    Logger.getLogger(catalogoInspeccionDeMedicion.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Ocurrio un error al crear el archivo error es el siguiente:"+ex);
                }
               
            }
            else{

                JOptionPane.showMessageDialog(null,"No existe el folio que quiere imprimir");
            }
            
            }
            else{
                //jButtonImprimir.setEnabled(true);
                 JOptionPane.showMessageDialog(null,"Habilia el check para imprimir.");
            }
        
    }//GEN-LAST:event_jButtonImprimirActionPerformed

    private void jCheckBoxImprimirItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxImprimirItemStateChanged
        // TODO add your handling code here:
        //jButtonImprimir.setEnabled(false);
        
    }//GEN-LAST:event_jCheckBoxImprimirItemStateChanged

    private void campoEstacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoEstacionActionPerformed
        // TODO add your handling code here:   
    }//GEN-LAST:event_campoEstacionActionPerformed

    private void jRadioButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton38ActionPerformed
entraonoentra();        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton38ActionPerformed

    private void jRadioButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton36ActionPerformed
entraonoentra();        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton36ActionPerformed

    private void jRadioButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton34ActionPerformed
entraonoentra();        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton34ActionPerformed

    private void jRadioButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton32ActionPerformed
entraonoentra();        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton32ActionPerformed

    private void jLabel69MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel69MouseClicked
        // TODO add your handling code here:
        panelInfo pinfo = new panelInfo();
        pinfo.show();
    }//GEN-LAST:event_jLabel69MouseClicked

    private void jRadioButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton30ActionPerformed
entraonoentra();        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton30ActionPerformed

    private void jRadioButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton28ActionPerformed
entraonoentra();        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton28ActionPerformed

    private void jRadioButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton24ActionPerformed
entraonoentra();        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton24ActionPerformed

    private void jRadioButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton21ActionPerformed
entraonoentra();        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton21ActionPerformed

    private void jRadioButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton26ActionPerformed
entraonoentra();        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton26ActionPerformed

    private void jTextField59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField59ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField59ActionPerformed

    private void jTextField65ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField65ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField65ActionPerformed

    private void jTextField127ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField127ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField127ActionPerformed

    private void jTextField132ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField132ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField132ActionPerformed

    private void jTextField191ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField191ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField191ActionPerformed

    private void jTextField196ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField196ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField196ActionPerformed

    private void jTextField255ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField255ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField255ActionPerformed

    private void jTextField260ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField260ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField260ActionPerformed

    private void jTextField319ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField319ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField319ActionPerformed

    private void jTextField324ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField324ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField324ActionPerformed

    private void jTextField383ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField383ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField383ActionPerformed

    private void jTextField388ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField388ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField388ActionPerformed

    private void campoEstacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoEstacionKeyTyped
        // TODO add your handling code here:7
    }//GEN-LAST:event_campoEstacionKeyTyped

    private void campoEstacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoEstacionKeyPressed
        // TODO add your handling code here:
        
        if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER){
           
            String nEstacion = campoEstacion.getText();
            int validaFSol = 0;

            lbd.openConnection();
            validaFSol = lbd.obtenerEstaciones(nEstacion);
            lbd.closeConnection();

            if(validaFSol != 0){

                JOptionPane.showMessageDialog(null,"El cliente si existe, da si para cargar la información");
                int dialogButton = JOptionPane.YES_NO_OPTION;
                JOptionPane.showMessageDialog(null,"Se cargaran los datos del cliente: "+campoEstacion.getText());
                int dialogResult = JOptionPane.showConfirmDialog (null, "¿Está de acuerdo?","Warning",dialogButton);
                if(dialogResult == JOptionPane.YES_OPTION){
                   
                }
                else{
                
                }
            }
            else{

                JOptionPane.showMessageDialog(null,"No existe el clinte que quiere consultar.");
            }
        }
    }//GEN-LAST:event_campoEstacionKeyPressed

    private void jComboBoxTermometroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxTermometroItemStateChanged
        // TODO add your handling code here:
        lbd.openConnection();
        List <String> listaAux = lbd.obtenerTermometros(1, (String) evt.getItem());
        //String [] lista = new String[listaAux.size()];
         //lista = listaAux.toArray(lista);        
         //jComboBoxTermometro.setModel((new javax.swing.DefaultComboBoxModel<>(lista)));
         //String item_seleccionado = jComboBoxTermometro.getSelectedItem().toString();
         datosTermometro.setText(listaAux.toString());
         //lleno el combo de cronometros
         //lleno los combos jarra
         lbd.closeConnection();
    }//GEN-LAST:event_jComboBoxTermometroItemStateChanged

    private void jComboBoxCronometroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxCronometroItemStateChanged
        // TODO add your handling code here:
        lbd.openConnection();
        List <String> listaAux = lbd.obtenerCronometros(1, (String) evt.getItem());
        //String [] lista = new String[listaAux.size()];
         //lista = listaAux.toArray(lista);        
         //jComboBoxTermometro.setModel((new javax.swing.DefaultComboBoxModel<>(lista)));
         //String item_seleccionado = jComboBoxTermometro.getSelectedItem().toString();
         datosCronometro.setText(listaAux.toString());
         //lleno el combo de cronometros
         //lleno los combos jarra
         lbd.closeConnection();
    }//GEN-LAST:event_jComboBoxCronometroItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jRadioButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton37ActionPerformed
entraonoentra();
    }//GEN-LAST:event_jRadioButton37ActionPerformed

    private void jRadioButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton22ActionPerformed
entraonoentra();
    }//GEN-LAST:event_jRadioButton22ActionPerformed

    private void jRadioButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton23ActionPerformed
entraonoentra();
    }//GEN-LAST:event_jRadioButton23ActionPerformed

    private void jRadioButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton25ActionPerformed
entraonoentra();  // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton25ActionPerformed

    private void jRadioButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton27ActionPerformed
entraonoentra();// TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton27ActionPerformed

    private void jRadioButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton29ActionPerformed
entraonoentra();    // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton29ActionPerformed

    private void jRadioButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton31ActionPerformed
entraonoentra();       // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton31ActionPerformed

    private void jRadioButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton33ActionPerformed
entraonoentra();        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton33ActionPerformed

    private void jRadioButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton35ActionPerformed
entraonoentra();        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton35ActionPerformed

    private void AP1MAXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AP1MAXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AP1MAXActionPerformed

    private void AP1MAXFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AP1MAXFocusLost
operacionesdeInspeccionMedicion();
    }//GEN-LAST:event_AP1MAXFocusLost

    private void AP2MAXFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AP2MAXFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_AP2MAXFocusLost

    private void AP3MAXFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AP3MAXFocusLost
operacionesdeInspeccionMedicion();
    }//GEN-LAST:event_AP3MAXFocusLost

    private void AP1MEDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AP1MEDFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_AP1MEDFocusLost

    private void AP2MEDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AP2MEDFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_AP2MEDFocusLost

    private void AP3MEDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AP3MEDFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_AP3MEDFocusLost

    private void AP1MINFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AP1MINFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_AP1MINFocusLost

    private void AP2MINFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AP2MINFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_AP2MINFocusLost

    private void AP3MINFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AP3MINFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_AP3MINFocusLost

    private void ATMAXP3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ATMAXP3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ATMAXP3ActionPerformed

    private void ATMEDP3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ATMEDP3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ATMEDP3ActionPerformed

    private void ATMINP3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ATMINP3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ATMINP3ActionPerformed

    private void jTextField34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField34ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField34ActionPerformed

    private void ATMAXP1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ATMAXP1FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_ATMAXP1FocusLost

    private void ATMAXP2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ATMAXP2FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_ATMAXP2FocusLost

    private void ATMAXP3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ATMAXP3FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_ATMAXP3FocusLost

    private void ATMEDP1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ATMEDP1FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_ATMEDP1FocusLost

    private void ATMEDP2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ATMEDP2FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_ATMEDP2FocusLost

    private void ATMEDP3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ATMEDP3FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_ATMEDP3FocusLost

    private void ATMINP1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ATMINP1FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_ATMINP1FocusLost

    private void ATMINP2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ATMINP2FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_ATMINP2FocusLost

    private void ATMINP3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ATMINP3FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_ATMINP3FocusLost

    private void AV20FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AV20FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_AV20FocusLost

    private void AKCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AKCFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_AKCFocusLost

    private void BP1MAXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BP1MAXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BP1MAXActionPerformed

    private void BP1MINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BP1MINActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BP1MINActionPerformed

    private void BP2MINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BP2MINActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BP2MINActionPerformed

    private void jTextField110ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField110ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField110ActionPerformed

    private void BTMAXP3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTMAXP3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTMAXP3ActionPerformed

    private void BTMEDP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTMEDP1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTMEDP1ActionPerformed

    private void BTMINP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTMINP2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTMINP2ActionPerformed

    private void jTextField95ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField95ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField95ActionPerformed

    private void jTextField158ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField158ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField158ActionPerformed

    private void BP1MAXFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BP1MAXFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_BP1MAXFocusLost

    private void BP2MAXFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BP2MAXFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_BP2MAXFocusLost

    private void BP3MAXFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BP3MAXFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_BP3MAXFocusLost

    private void BP1MEDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BP1MEDFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_BP1MEDFocusLost

    private void BP2MEDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BP2MEDFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_BP2MEDFocusLost

    private void BP3MEDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BP3MEDFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_BP3MEDFocusLost

    private void BP1MINFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BP1MINFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_BP1MINFocusLost

    private void BP2MINFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BP2MINFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_BP2MINFocusLost

    private void BP3MINFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BP3MINFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_BP3MINFocusLost

    private void BV20FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BV20FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_BV20FocusLost

    private void BKCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BKCFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_BKCFocusLost

    private void BTMAXP1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BTMAXP1FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_BTMAXP1FocusLost

    private void BTMAXP2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BTMAXP2FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_BTMAXP2FocusLost

    private void BTMAXP3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BTMAXP3FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_BTMAXP3FocusLost

    private void BTMEDP1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BTMEDP1FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_BTMEDP1FocusLost

    private void BTMEDP2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BTMEDP2FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_BTMEDP2FocusLost

    private void BTMEDP3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BTMEDP3FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_BTMEDP3FocusLost

    private void BTMINP1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BTMINP1FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_BTMINP1FocusLost

    private void BTMINP2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BTMINP2FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_BTMINP2FocusLost

    private void BTMINP3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BTMINP3FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_BTMINP3FocusLost

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
//                if ("Windows".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(catalogoInspeccionDeMedicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(catalogoInspeccionDeMedicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(catalogoInspeccionDeMedicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(catalogoInspeccionDeMedicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new catalogoInspeccionDeMedicion().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup A;
    private javax.swing.JTextField AKC;
    private javax.swing.JTextField ALCMAX;
    private javax.swing.JTextField ALCMED;
    private javax.swing.JTextField ALCMIN;
    private javax.swing.JTextField AP1MAX;
    private javax.swing.JTextField AP1MED;
    private javax.swing.JTextField AP1MIN;
    private javax.swing.JTextField AP2MAX;
    private javax.swing.JTextField AP2MED;
    private javax.swing.JTextField AP2MIN;
    private javax.swing.JTextField AP3MAX;
    private javax.swing.JTextField AP3MED;
    private javax.swing.JTextField AP3MIN;
    private javax.swing.JTextField ATMAXP1;
    private javax.swing.JTextField ATMAXP2;
    private javax.swing.JTextField ATMAXP3;
    private javax.swing.JTextField ATMEDP1;
    private javax.swing.JTextField ATMEDP2;
    private javax.swing.JTextField ATMEDP3;
    private javax.swing.JTextField ATMINP1;
    private javax.swing.JTextField ATMINP2;
    private javax.swing.JTextField ATMINP3;
    private javax.swing.JTextField AV20;
    private javax.swing.JTextField AVCMVMAX;
    private javax.swing.JTextField AVCMVMED;
    private javax.swing.JTextField AVCMVMIN;
    private javax.swing.ButtonGroup B;
    private javax.swing.JTextField BKC;
    private javax.swing.JTextField BLCMAX;
    private javax.swing.JTextField BLCMED;
    private javax.swing.JTextField BLCMIN;
    private javax.swing.JTextField BP1MAX;
    private javax.swing.JTextField BP1MED;
    private javax.swing.JTextField BP1MIN;
    private javax.swing.JTextField BP2MAX;
    private javax.swing.JTextField BP2MED;
    private javax.swing.JTextField BP2MIN;
    private javax.swing.JTextField BP3MAX;
    private javax.swing.JTextField BP3MED;
    private javax.swing.JTextField BP3MIN;
    private javax.swing.JTextField BTMAXP1;
    private javax.swing.JTextField BTMAXP2;
    private javax.swing.JTextField BTMAXP3;
    private javax.swing.JTextField BTMEDP1;
    private javax.swing.JTextField BTMEDP2;
    private javax.swing.JTextField BTMEDP3;
    private javax.swing.JTextField BTMINP1;
    private javax.swing.JTextField BTMINP2;
    private javax.swing.JTextField BTMINP3;
    private javax.swing.JTextField BV20;
    private javax.swing.JTextField BVCMVMAX;
    private javax.swing.JTextField BVCMVMED;
    private javax.swing.JTextField BVCMVMIN;
    private javax.swing.ButtonGroup C;
    private javax.swing.JTextField CKC;
    private javax.swing.JTextField CLCMAX;
    private javax.swing.JTextField CLCMED;
    private javax.swing.JTextField CLCMIN;
    private javax.swing.JTextField CP1MAX;
    private javax.swing.JTextField CP1MED;
    private javax.swing.JTextField CP1MIN;
    private javax.swing.JTextField CP2MAX;
    private javax.swing.JTextField CP2MED;
    private javax.swing.JTextField CP2MIN;
    private javax.swing.JTextField CP3MAX;
    private javax.swing.JTextField CP3MED;
    private javax.swing.JTextField CP3MIN;
    private javax.swing.JTextField CTMAXP1;
    private javax.swing.JTextField CTMAXP2;
    private javax.swing.JTextField CTMAXP3;
    private javax.swing.JTextField CTMEDP1;
    private javax.swing.JTextField CTMEDP2;
    private javax.swing.JTextField CTMEDP3;
    private javax.swing.JTextField CTMINP1;
    private javax.swing.JTextField CTMINP2;
    private javax.swing.JTextField CTMINP3;
    private javax.swing.JTextField CV20;
    private javax.swing.JTextField CVCMVMAX;
    private javax.swing.JTextField CVCMVMED;
    private javax.swing.JTextField CVCMVMIN;
    private javax.swing.ButtonGroup D;
    private javax.swing.JTextField DKC;
    private javax.swing.JTextField DLCMAX;
    private javax.swing.JTextField DLCMED;
    private javax.swing.JTextField DLCMIN;
    private javax.swing.JTextField DP1MAX;
    private javax.swing.JTextField DP1MED;
    private javax.swing.JTextField DP1MIN;
    private javax.swing.JTextField DP2MAX;
    private javax.swing.JTextField DP2MED;
    private javax.swing.JTextField DP2MIN;
    private javax.swing.JTextField DP3MAX;
    private javax.swing.JTextField DP3MED;
    private javax.swing.JTextField DP3MIN;
    private javax.swing.JTextField DTMAXP1;
    private javax.swing.JTextField DTMAXP2;
    private javax.swing.JTextField DTMAXP3;
    private javax.swing.JTextField DTMEDP1;
    private javax.swing.JTextField DTMEDP2;
    private javax.swing.JTextField DTMEDP3;
    private javax.swing.JTextField DTMINP1;
    private javax.swing.JTextField DTMINP2;
    private javax.swing.JTextField DTMINP3;
    private javax.swing.JTextField DV20;
    private javax.swing.JTextField DVCMVMAX;
    private javax.swing.JTextField DVCMVMED;
    private javax.swing.JTextField DVCMVMIN;
    private javax.swing.ButtonGroup E;
    private javax.swing.JTextField EKC;
    private javax.swing.JTextField ELCMAX;
    private javax.swing.JTextField ELCMED;
    private javax.swing.JTextField ELCMIN;
    private javax.swing.JTextField EP1MAX;
    private javax.swing.JTextField EP1MED;
    private javax.swing.JTextField EP1MIN;
    private javax.swing.JTextField EP2MAX;
    private javax.swing.JTextField EP2MED;
    private javax.swing.JTextField EP2MIN;
    private javax.swing.JTextField EP3MAX;
    private javax.swing.JTextField EP3MED;
    private javax.swing.JTextField EP3MIN;
    private javax.swing.JTextField ETMAXP1;
    private javax.swing.JTextField ETMAXP2;
    private javax.swing.JTextField ETMAXP3;
    private javax.swing.JTextField ETMEDP1;
    private javax.swing.JTextField ETMEDP2;
    private javax.swing.JTextField ETMEDP3;
    private javax.swing.JTextField ETMINP1;
    private javax.swing.JTextField ETMINP2;
    private javax.swing.JTextField ETMINP3;
    private javax.swing.JTextField EV20;
    private javax.swing.JTextField EVCMVMAX;
    private javax.swing.JTextField EVCMVMED;
    private javax.swing.JTextField EVCMVMIN;
    private javax.swing.ButtonGroup F;
    private javax.swing.JTextField FKC;
    private javax.swing.JTextField FLCMAX;
    private javax.swing.JTextField FLCMED;
    private javax.swing.JTextField FLCMIN;
    private javax.swing.JTextField FP1MAX;
    private javax.swing.JTextField FP1MED;
    private javax.swing.JTextField FP1MIN;
    private javax.swing.JTextField FP2MAX;
    private javax.swing.JTextField FP2MED;
    private javax.swing.JTextField FP2MIN;
    private javax.swing.JTextField FP3MAX;
    private javax.swing.JTextField FP3MED;
    private javax.swing.JTextField FP3MIN;
    private javax.swing.JTextField FTMAXP1;
    private javax.swing.JTextField FTMAXP2;
    private javax.swing.JTextField FTMAXP3;
    private javax.swing.JTextField FTMEDP1;
    private javax.swing.JTextField FTMEDP2;
    private javax.swing.JTextField FTMEDP3;
    private javax.swing.JTextField FTMINP1;
    private javax.swing.JTextField FTMINP2;
    private javax.swing.JTextField FTMINP3;
    private javax.swing.JTextField FV20;
    private javax.swing.JTextField FVCMVMAX;
    private javax.swing.JTextField FVCMVMED;
    private javax.swing.JTextField FVCMVMIN;
    private javax.swing.ButtonGroup G;
    private javax.swing.ButtonGroup H;
    private javax.swing.ButtonGroup I;
    private javax.swing.JTextField campoEstacion;
    private javax.swing.JTextField datosCronometro;
    private javax.swing.JTextField datosTermometro;
    private javax.swing.JTextField folioSolicitud;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButtonImprimir;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBoxImprimir;
    private javax.swing.JComboBox<String> jComboBoxCronometro;
    private javax.swing.JComboBox<String> jComboBoxDispensarios;
    private javax.swing.JComboBox<String> jComboBoxJarraA;
    private javax.swing.JComboBox<String> jComboBoxJarraB;
    private javax.swing.JComboBox<String> jComboBoxJarraC;
    private javax.swing.JComboBox<String> jComboBoxJarraD;
    private javax.swing.JComboBox<String> jComboBoxJarraE;
    private javax.swing.JComboBox<String> jComboBoxJarraF;
    private javax.swing.JComboBox<String> jComboBoxTermometro;
    private com.toedter.calendar.JDateChooser jDateChooserFechaIM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel173;
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel175;
    private javax.swing.JLabel jLabel176;
    private javax.swing.JLabel jLabel177;
    private javax.swing.JLabel jLabel178;
    private javax.swing.JLabel jLabel179;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel180;
    private javax.swing.JLabel jLabel181;
    private javax.swing.JLabel jLabel182;
    private javax.swing.JLabel jLabel183;
    private javax.swing.JLabel jLabel184;
    private javax.swing.JLabel jLabel185;
    private javax.swing.JLabel jLabel186;
    private javax.swing.JLabel jLabel187;
    private javax.swing.JLabel jLabel188;
    private javax.swing.JLabel jLabel189;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel190;
    private javax.swing.JLabel jLabel191;
    private javax.swing.JLabel jLabel192;
    private javax.swing.JLabel jLabel193;
    private javax.swing.JLabel jLabel194;
    private javax.swing.JLabel jLabel195;
    private javax.swing.JLabel jLabel196;
    private javax.swing.JLabel jLabel197;
    private javax.swing.JLabel jLabel198;
    private javax.swing.JLabel jLabel199;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel200;
    private javax.swing.JLabel jLabel201;
    private javax.swing.JLabel jLabel202;
    private javax.swing.JLabel jLabel203;
    private javax.swing.JLabel jLabel204;
    private javax.swing.JLabel jLabel205;
    private javax.swing.JLabel jLabel206;
    private javax.swing.JLabel jLabel207;
    private javax.swing.JLabel jLabel208;
    private javax.swing.JLabel jLabel209;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel210;
    private javax.swing.JLabel jLabel211;
    private javax.swing.JLabel jLabel212;
    private javax.swing.JLabel jLabel213;
    private javax.swing.JLabel jLabel214;
    private javax.swing.JLabel jLabel215;
    private javax.swing.JLabel jLabel216;
    private javax.swing.JLabel jLabel217;
    private javax.swing.JLabel jLabel218;
    private javax.swing.JLabel jLabel219;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel220;
    private javax.swing.JLabel jLabel221;
    private javax.swing.JLabel jLabel222;
    private javax.swing.JLabel jLabel223;
    private javax.swing.JLabel jLabel224;
    private javax.swing.JLabel jLabel225;
    private javax.swing.JLabel jLabel226;
    private javax.swing.JLabel jLabel227;
    private javax.swing.JLabel jLabel228;
    private javax.swing.JLabel jLabel229;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel230;
    private javax.swing.JLabel jLabel231;
    private javax.swing.JLabel jLabel232;
    private javax.swing.JLabel jLabel233;
    private javax.swing.JLabel jLabel234;
    private javax.swing.JLabel jLabel235;
    private javax.swing.JLabel jLabel236;
    private javax.swing.JLabel jLabel237;
    private javax.swing.JLabel jLabel238;
    private javax.swing.JLabel jLabel239;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel240;
    private javax.swing.JLabel jLabel241;
    private javax.swing.JLabel jLabel242;
    private javax.swing.JLabel jLabel243;
    private javax.swing.JLabel jLabel244;
    private javax.swing.JLabel jLabel245;
    private javax.swing.JLabel jLabel246;
    private javax.swing.JLabel jLabel247;
    private javax.swing.JLabel jLabel248;
    private javax.swing.JLabel jLabel249;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel250;
    private javax.swing.JLabel jLabel251;
    private javax.swing.JLabel jLabel252;
    private javax.swing.JLabel jLabel253;
    private javax.swing.JLabel jLabel254;
    private javax.swing.JLabel jLabel255;
    private javax.swing.JLabel jLabel256;
    private javax.swing.JLabel jLabel257;
    private javax.swing.JLabel jLabel258;
    private javax.swing.JLabel jLabel259;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel260;
    private javax.swing.JLabel jLabel261;
    private javax.swing.JLabel jLabel262;
    private javax.swing.JLabel jLabel263;
    private javax.swing.JLabel jLabel264;
    private javax.swing.JLabel jLabel265;
    private javax.swing.JLabel jLabel266;
    private javax.swing.JLabel jLabel267;
    private javax.swing.JLabel jLabel268;
    private javax.swing.JLabel jLabel269;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel270;
    private javax.swing.JLabel jLabel271;
    private javax.swing.JLabel jLabel272;
    private javax.swing.JLabel jLabel273;
    private javax.swing.JLabel jLabel274;
    private javax.swing.JLabel jLabel275;
    private javax.swing.JLabel jLabel276;
    private javax.swing.JLabel jLabel277;
    private javax.swing.JLabel jLabel278;
    private javax.swing.JLabel jLabel279;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel280;
    private javax.swing.JLabel jLabel281;
    private javax.swing.JLabel jLabel282;
    private javax.swing.JLabel jLabel283;
    private javax.swing.JLabel jLabel284;
    private javax.swing.JLabel jLabel285;
    private javax.swing.JLabel jLabel286;
    private javax.swing.JLabel jLabel287;
    private javax.swing.JLabel jLabel288;
    private javax.swing.JLabel jLabel289;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel290;
    private javax.swing.JLabel jLabel291;
    private javax.swing.JLabel jLabel292;
    private javax.swing.JLabel jLabel293;
    private javax.swing.JLabel jLabel294;
    private javax.swing.JLabel jLabel295;
    private javax.swing.JLabel jLabel296;
    private javax.swing.JLabel jLabel297;
    private javax.swing.JLabel jLabel298;
    private javax.swing.JLabel jLabel299;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel300;
    private javax.swing.JLabel jLabel301;
    private javax.swing.JLabel jLabel302;
    private javax.swing.JLabel jLabel303;
    private javax.swing.JLabel jLabel304;
    private javax.swing.JLabel jLabel305;
    private javax.swing.JLabel jLabel306;
    private javax.swing.JLabel jLabel307;
    private javax.swing.JLabel jLabel308;
    private javax.swing.JLabel jLabel309;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel310;
    private javax.swing.JLabel jLabel311;
    private javax.swing.JLabel jLabel312;
    private javax.swing.JLabel jLabel313;
    private javax.swing.JLabel jLabel314;
    private javax.swing.JLabel jLabel315;
    private javax.swing.JLabel jLabel316;
    private javax.swing.JLabel jLabel317;
    private javax.swing.JLabel jLabel318;
    private javax.swing.JLabel jLabel319;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel320;
    private javax.swing.JLabel jLabel321;
    private javax.swing.JLabel jLabel322;
    private javax.swing.JLabel jLabel323;
    private javax.swing.JLabel jLabel324;
    private javax.swing.JLabel jLabel325;
    private javax.swing.JLabel jLabel326;
    private javax.swing.JLabel jLabel327;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton21;
    private javax.swing.JRadioButton jRadioButton22;
    private javax.swing.JRadioButton jRadioButton23;
    private javax.swing.JRadioButton jRadioButton24;
    private javax.swing.JRadioButton jRadioButton25;
    private javax.swing.JRadioButton jRadioButton26;
    private javax.swing.JRadioButton jRadioButton27;
    private javax.swing.JRadioButton jRadioButton28;
    private javax.swing.JRadioButton jRadioButton29;
    private javax.swing.JRadioButton jRadioButton30;
    private javax.swing.JRadioButton jRadioButton31;
    private javax.swing.JRadioButton jRadioButton32;
    private javax.swing.JRadioButton jRadioButton33;
    private javax.swing.JRadioButton jRadioButton34;
    private javax.swing.JRadioButton jRadioButton35;
    private javax.swing.JRadioButton jRadioButton36;
    private javax.swing.JRadioButton jRadioButton37;
    private javax.swing.JRadioButton jRadioButton38;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField100;
    private javax.swing.JTextField jTextField101;
    private javax.swing.JTextField jTextField102;
    private javax.swing.JTextField jTextField103;
    private javax.swing.JTextField jTextField104;
    private javax.swing.JTextField jTextField105;
    private javax.swing.JTextField jTextField106;
    private javax.swing.JTextField jTextField107;
    private javax.swing.JTextField jTextField108;
    private javax.swing.JTextField jTextField109;
    private javax.swing.JTextField jTextField110;
    private javax.swing.JTextField jTextField111;
    private javax.swing.JTextField jTextField112;
    private javax.swing.JTextField jTextField113;
    private javax.swing.JTextField jTextField114;
    private javax.swing.JTextField jTextField115;
    private javax.swing.JTextField jTextField116;
    private javax.swing.JTextField jTextField119;
    private javax.swing.JTextField jTextField120;
    private javax.swing.JTextField jTextField121;
    private javax.swing.JTextField jTextField122;
    private javax.swing.JTextField jTextField126;
    private javax.swing.JTextField jTextField127;
    private javax.swing.JTextField jTextField128;
    private javax.swing.JTextField jTextField129;
    private javax.swing.JTextField jTextField130;
    private javax.swing.JTextField jTextField131;
    private javax.swing.JTextField jTextField132;
    private javax.swing.JTextField jTextField133;
    private javax.swing.JTextField jTextField146;
    private javax.swing.JTextField jTextField147;
    private javax.swing.JTextField jTextField148;
    private javax.swing.JTextField jTextField158;
    private javax.swing.JTextField jTextField159;
    private javax.swing.JTextField jTextField160;
    private javax.swing.JTextField jTextField161;
    private javax.swing.JTextField jTextField162;
    private javax.swing.JTextField jTextField163;
    private javax.swing.JTextField jTextField164;
    private javax.swing.JTextField jTextField165;
    private javax.swing.JTextField jTextField166;
    private javax.swing.JTextField jTextField167;
    private javax.swing.JTextField jTextField168;
    private javax.swing.JTextField jTextField169;
    private javax.swing.JTextField jTextField170;
    private javax.swing.JTextField jTextField171;
    private javax.swing.JTextField jTextField172;
    private javax.swing.JTextField jTextField173;
    private javax.swing.JTextField jTextField174;
    private javax.swing.JTextField jTextField175;
    private javax.swing.JTextField jTextField176;
    private javax.swing.JTextField jTextField177;
    private javax.swing.JTextField jTextField178;
    private javax.swing.JTextField jTextField179;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField180;
    private javax.swing.JTextField jTextField183;
    private javax.swing.JTextField jTextField184;
    private javax.swing.JTextField jTextField185;
    private javax.swing.JTextField jTextField186;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField190;
    private javax.swing.JTextField jTextField191;
    private javax.swing.JTextField jTextField192;
    private javax.swing.JTextField jTextField193;
    private javax.swing.JTextField jTextField194;
    private javax.swing.JTextField jTextField195;
    private javax.swing.JTextField jTextField196;
    private javax.swing.JTextField jTextField197;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField210;
    private javax.swing.JTextField jTextField211;
    private javax.swing.JTextField jTextField212;
    private javax.swing.JTextField jTextField222;
    private javax.swing.JTextField jTextField223;
    private javax.swing.JTextField jTextField224;
    private javax.swing.JTextField jTextField225;
    private javax.swing.JTextField jTextField226;
    private javax.swing.JTextField jTextField227;
    private javax.swing.JTextField jTextField228;
    private javax.swing.JTextField jTextField229;
    private javax.swing.JTextField jTextField230;
    private javax.swing.JTextField jTextField231;
    private javax.swing.JTextField jTextField232;
    private javax.swing.JTextField jTextField233;
    private javax.swing.JTextField jTextField234;
    private javax.swing.JTextField jTextField235;
    private javax.swing.JTextField jTextField236;
    private javax.swing.JTextField jTextField237;
    private javax.swing.JTextField jTextField238;
    private javax.swing.JTextField jTextField239;
    private javax.swing.JTextField jTextField240;
    private javax.swing.JTextField jTextField241;
    private javax.swing.JTextField jTextField242;
    private javax.swing.JTextField jTextField243;
    private javax.swing.JTextField jTextField244;
    private javax.swing.JTextField jTextField247;
    private javax.swing.JTextField jTextField248;
    private javax.swing.JTextField jTextField249;
    private javax.swing.JTextField jTextField250;
    private javax.swing.JTextField jTextField254;
    private javax.swing.JTextField jTextField255;
    private javax.swing.JTextField jTextField256;
    private javax.swing.JTextField jTextField257;
    private javax.swing.JTextField jTextField258;
    private javax.swing.JTextField jTextField259;
    private javax.swing.JTextField jTextField260;
    private javax.swing.JTextField jTextField261;
    private javax.swing.JTextField jTextField274;
    private javax.swing.JTextField jTextField275;
    private javax.swing.JTextField jTextField276;
    private javax.swing.JTextField jTextField286;
    private javax.swing.JTextField jTextField287;
    private javax.swing.JTextField jTextField288;
    private javax.swing.JTextField jTextField289;
    private javax.swing.JTextField jTextField290;
    private javax.swing.JTextField jTextField291;
    private javax.swing.JTextField jTextField292;
    private javax.swing.JTextField jTextField293;
    private javax.swing.JTextField jTextField294;
    private javax.swing.JTextField jTextField295;
    private javax.swing.JTextField jTextField296;
    private javax.swing.JTextField jTextField297;
    private javax.swing.JTextField jTextField298;
    private javax.swing.JTextField jTextField299;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField300;
    private javax.swing.JTextField jTextField301;
    private javax.swing.JTextField jTextField302;
    private javax.swing.JTextField jTextField303;
    private javax.swing.JTextField jTextField304;
    private javax.swing.JTextField jTextField305;
    private javax.swing.JTextField jTextField306;
    private javax.swing.JTextField jTextField307;
    private javax.swing.JTextField jTextField308;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField311;
    private javax.swing.JTextField jTextField312;
    private javax.swing.JTextField jTextField313;
    private javax.swing.JTextField jTextField314;
    private javax.swing.JTextField jTextField318;
    private javax.swing.JTextField jTextField319;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField320;
    private javax.swing.JTextField jTextField321;
    private javax.swing.JTextField jTextField322;
    private javax.swing.JTextField jTextField323;
    private javax.swing.JTextField jTextField324;
    private javax.swing.JTextField jTextField325;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField338;
    private javax.swing.JTextField jTextField339;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField340;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField350;
    private javax.swing.JTextField jTextField351;
    private javax.swing.JTextField jTextField352;
    private javax.swing.JTextField jTextField353;
    private javax.swing.JTextField jTextField354;
    private javax.swing.JTextField jTextField355;
    private javax.swing.JTextField jTextField356;
    private javax.swing.JTextField jTextField357;
    private javax.swing.JTextField jTextField358;
    private javax.swing.JTextField jTextField359;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField360;
    private javax.swing.JTextField jTextField361;
    private javax.swing.JTextField jTextField362;
    private javax.swing.JTextField jTextField363;
    private javax.swing.JTextField jTextField364;
    private javax.swing.JTextField jTextField365;
    private javax.swing.JTextField jTextField366;
    private javax.swing.JTextField jTextField367;
    private javax.swing.JTextField jTextField368;
    private javax.swing.JTextField jTextField369;
    private javax.swing.JTextField jTextField37;
    private javax.swing.JTextField jTextField370;
    private javax.swing.JTextField jTextField371;
    private javax.swing.JTextField jTextField372;
    private javax.swing.JTextField jTextField375;
    private javax.swing.JTextField jTextField376;
    private javax.swing.JTextField jTextField377;
    private javax.swing.JTextField jTextField378;
    private javax.swing.JTextField jTextField38;
    private javax.swing.JTextField jTextField382;
    private javax.swing.JTextField jTextField383;
    private javax.swing.JTextField jTextField384;
    private javax.swing.JTextField jTextField385;
    private javax.swing.JTextField jTextField386;
    private javax.swing.JTextField jTextField387;
    private javax.swing.JTextField jTextField388;
    private javax.swing.JTextField jTextField389;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JTextField jTextField40;
    private javax.swing.JTextField jTextField41;
    private javax.swing.JTextField jTextField42;
    private javax.swing.JTextField jTextField43;
    private javax.swing.JTextField jTextField44;
    private javax.swing.JTextField jTextField45;
    private javax.swing.JTextField jTextField46;
    private javax.swing.JTextField jTextField47;
    private javax.swing.JTextField jTextField48;
    private javax.swing.JTextField jTextField49;
    private javax.swing.JTextField jTextField50;
    private javax.swing.JTextField jTextField53;
    private javax.swing.JTextField jTextField54;
    private javax.swing.JTextField jTextField58;
    private javax.swing.JTextField jTextField59;
    private javax.swing.JTextField jTextField60;
    private javax.swing.JTextField jTextField61;
    private javax.swing.JTextField jTextField62;
    private javax.swing.JTextField jTextField63;
    private javax.swing.JTextField jTextField64;
    private javax.swing.JTextField jTextField65;
    private javax.swing.JTextField jTextField66;
    private javax.swing.JTextField jTextField67;
    private javax.swing.JTextField jTextField68;
    private javax.swing.JTextField jTextField69;
    private javax.swing.JTextField jTextField82;
    private javax.swing.JTextField jTextField83;
    private javax.swing.JTextField jTextField84;
    private javax.swing.JTextField jTextField94;
    private javax.swing.JTextField jTextField95;
    private javax.swing.JTextField jTextField96;
    private javax.swing.JTextField jTextField97;
    private javax.swing.JTextField jTextField98;
    private javax.swing.JTextField jTextField99;
    private javax.swing.JPanel mangueraA;
    private javax.swing.JPanel mangueraA1;
    private javax.swing.JPanel mangueraA2;
    private javax.swing.JPanel mangueraA3;
    private javax.swing.JPanel mangueraA4;
    private javax.swing.JPanel mangueraA5;
    private javax.swing.JPanel verificacionVisual;
    // End of variables declaration//GEN-END:variables
}
