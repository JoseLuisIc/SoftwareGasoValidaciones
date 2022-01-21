/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.InspeccionDeMedicion;

import Controlador.LibreriaBDControlador;
import Controlador.LibreriaToolsControlador;
import Controlador.colorTabla;
import Controlador.configuracionDictamen;
import Controlador.informacionCliente;
import Controlador.informacionDispensarios;
import Controlador.reporteExcel;
import Controlador.reportesWord;
import Modelo.modeloTablaUsuario;
import java.awt.Component;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;
import Modelo.modeloVerificacionVisual;
import javax.swing.ButtonGroup;

/**
 *
 * @author Jose Luis
 */
public class catalogoInspeccionDeMedicion extends javax.swing.JFrame {
    LibreriaBDControlador lbd = new LibreriaBDControlador();
    LibreriaToolsControlador lbtc = new LibreriaToolsControlador();
    modeloTablaUsuario mtu = new modeloTablaUsuario();
    reportesWord reporteWord = new reportesWord();
    informacionCliente infoCliente = new informacionCliente();
    informacionDispensarios infoDispensarios = new informacionDispensarios();
    colorTabla colorT = new colorTabla(0,0);
    public Map<Integer, Integer> mapDispensarios = null;
    /*Variables para saber si se incluyen o no la información en el excel*/
    public int incluirA = 0;
    public int incluirB = 0;
    public int incluirC = 0;
    public int incluirD = 0;
    public int incluirE = 0;
    public int incluirF = 0;
    /**
     * Creates new form catalogoInspeccionDeMedicion
     */
    public catalogoInspeccionDeMedicion() {
        
        initComponents();
        AutoCompleteDecorator.decorate(jComboBoxJarraA);
        AutoCompleteDecorator.decorate(jComboBoxJarraB);
        AutoCompleteDecorator.decorate(jComboBoxJarraC);
        AutoCompleteDecorator.decorate(jComboBoxJarraD);
        AutoCompleteDecorator.decorate(jComboBoxJarraE);
        AutoCompleteDecorator.decorate(jComboBoxJarraF);
        
        setIconImage(new ImageIcon(getClass().getResource("/Multimedia/icono_GasValid.jpg")).getImage());
//        // Indicamos como sera el resaltado de la tabla
//        jTable1.setDefaultRenderer(Object.class, colorT);
//        colorT.setColumna(0);
//        colorT.setColumna(2);
//        //colorT.setColumna(2);
         //lleno el combo de termometros
         //lleno la hora
         Date fecha = new Date();
         Date dateNow = new Date();
        SimpleDateFormat formFecha = new SimpleDateFormat("dd/MM/yyyy");         
         Date fechaCalA = new Date();
         Date fechaCalB = new Date();
         Date fechaCalC = new Date();
         Date fechaCalD = new Date();
         Date fechaCalE = new Date();
         Date fechaCalF = new Date();
         
         jDateChooserFechaIM.setDate(fecha);  
         
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
         //Llenado automático de combobox y espacios de información del área de las jarras.
         // Hecho por Ángel González Ríncón
         listaAux = lbd.obtenerJarrasId(2,"");
         lista = new String[listaAux.size()];
         lista = listaAux.toArray(lista);        
         jComboBoxJarraA.setModel((new javax.swing.DefaultComboBoxModel<>(lista)));
         item_seleccionado = jComboBoxJarraA.getSelectedItem().toString();
         listaAux = lbd.obtenerJarrasId(1,item_seleccionado);         
         AV20.setText(listaAux.get(0).toString());
         AKC.setText(listaAux.get(1).toString());        
         FechaCal_A.setText(listaAux.get(2).toString());
         InfCal_A.setText(listaAux.get(3).toString());         
         
         listaAux = lbd.obtenerJarrasId(2,"");
         lista = new String[listaAux.size()];
         lista = listaAux.toArray(lista);        
         jComboBoxJarraB.setModel((new javax.swing.DefaultComboBoxModel<>(lista)));
         item_seleccionado = jComboBoxJarraB.getSelectedItem().toString();
         listaAux = lbd.obtenerJarrasId(1,item_seleccionado);         
         BV20.setText(listaAux.get(0).toString());
         BKC.setText(listaAux.get(1).toString());        
         FechaCal_B.setText(listaAux.get(2).toString());
         InfCal_B.setText(listaAux.get(3).toString());          

         listaAux = lbd.obtenerJarrasId(2,"");
         lista = new String[listaAux.size()];
         lista = listaAux.toArray(lista);        
         jComboBoxJarraC.setModel((new javax.swing.DefaultComboBoxModel<>(lista)));
         item_seleccionado = jComboBoxJarraC.getSelectedItem().toString();
         listaAux = lbd.obtenerJarrasId(1,item_seleccionado);         
         CV20.setText(listaAux.get(0).toString());
         CKC.setText(listaAux.get(1).toString());        
         FechaCal_C.setText(listaAux.get(2).toString());
         InfCal_C.setText(listaAux.get(3).toString());
         
         listaAux = lbd.obtenerJarrasId(2,"");
         lista = new String[listaAux.size()];
         lista = listaAux.toArray(lista);        
         jComboBoxJarraD.setModel((new javax.swing.DefaultComboBoxModel<>(lista)));
         item_seleccionado = jComboBoxJarraD.getSelectedItem().toString();
         listaAux = lbd.obtenerJarrasId(1,item_seleccionado);         
         DV20.setText(listaAux.get(0).toString());
         DKC.setText(listaAux.get(1).toString());        
         FechaCal_D.setText(listaAux.get(2).toString());
         InfCal_D.setText(listaAux.get(3).toString());   
         
         listaAux = lbd.obtenerJarrasId(2,"");
         lista = new String[listaAux.size()];
         lista = listaAux.toArray(lista);        
         jComboBoxJarraE.setModel((new javax.swing.DefaultComboBoxModel<>(lista)));
         item_seleccionado = jComboBoxJarraE.getSelectedItem().toString();
         listaAux = lbd.obtenerJarrasId(1,item_seleccionado);         
         EV20.setText(listaAux.get(0).toString());
         EKC.setText(listaAux.get(1).toString());        
         FechaCal_E.setText(listaAux.get(2).toString());
         InfCal_E.setText(listaAux.get(3).toString());

         listaAux = lbd.obtenerJarrasId(2,"");
         lista = new String[listaAux.size()];
         lista = listaAux.toArray(lista);        
         jComboBoxJarraF.setModel((new javax.swing.DefaultComboBoxModel<>(lista)));
         item_seleccionado = jComboBoxJarraF.getSelectedItem().toString();
         listaAux = lbd.obtenerJarrasId(1,item_seleccionado);         
         FV20.setText(listaAux.get(0).toString());
         FKC.setText(listaAux.get(1).toString());        
         FechaCal_F.setText(listaAux.get(2).toString());
         InfCal_F.setText(listaAux.get(3).toString());         
         
        String fechaCalibA = listaAux.get(2).toString();                
        String fechaCalibB = listaAux.get(2).toString();                
        String fechaCalibC = listaAux.get(2).toString();                
        String fechaCalibD = listaAux.get(2).toString();                
        String fechaCalibE = listaAux.get(2).toString();                
        String fechaCalibF = listaAux.get(2).toString();  
        
            
        
         
         lbd.closeConnection();
  
         
         System.out.println(fecha);
         
entraonoentra();
operacionesdeInspeccionMedicion();
    // Analiza las fechas de las jarras con respecto a las actuales para saber si ya caducaron o están por caducar.
    // Hecho por Ángel González Rincón
        System.out.println("Fecha A: "+fechaCalibA);
        fechaCalA =  lbtc.fechaFormato(fechaCalibA);
        System.out.println("Fecha calibración A: "+formFecha.format(fechaCalA));    
        System.out.println("Fecha actual: "+formFecha.format(fecha));
        
            long diffA = fechaCalA.getTime() - dateNow.getTime();
            TimeUnit timeA = TimeUnit.DAYS; 
            long diferenciaA = timeA.convert(diffA, TimeUnit.MILLISECONDS);        
            System.out.println("Diferencia en días de la calibración Manguera A: " + diferenciaA);
            if(diferenciaA >= 1 && diferenciaA <= 90){
                avisoLabelA.setText("*La jarra está por caducar*");
            }else if(diferenciaA <= 0){
                JOptionPane.showMessageDialog(null, "¡La jarra ya ha caducado!");
                avisoLabelA.setText("");
            }            
        System.out.println("Fecha B: "+fechaCalibB);
        fechaCalB =  lbtc.fechaFormato(fechaCalibB);
        System.out.println("Fecha calibración B: "+formFecha.format(fechaCalB));    
        System.out.println("Fecha actual: "+formFecha.format(fecha));
        
            long diffB = fechaCalB.getTime() - dateNow.getTime();
            TimeUnit timeB = TimeUnit.DAYS; 
            long diferenciaB = timeB.convert(diffB, TimeUnit.MILLISECONDS);        
            System.out.println("Diferencia en días de la calibración Manguera B: " + diferenciaB);
            if(diferenciaB >= 1 && diferenciaB <= 90){
                avisoLabelB.setText("*La jarra está por caducar*");
            }else if(diferenciaB <= 0){
                JOptionPane.showMessageDialog(null, "¡La jarra ya ha caducado!");
                avisoLabelB.setText("");
            }
        System.out.println("Fecha C: "+fechaCalibC);
        fechaCalC =  lbtc.fechaFormato(fechaCalibC);
        System.out.println("Fecha calibración B: "+formFecha.format(fechaCalC));    
        System.out.println("Fecha actual: "+formFecha.format(fecha));
        
            long diffC = fechaCalC.getTime() - dateNow.getTime();
            TimeUnit timeC = TimeUnit.DAYS; 
            long diferenciaC = timeC.convert(diffC, TimeUnit.MILLISECONDS);        
            System.out.println("Diferencia en días de la calibración Manguera C: " + diferenciaC);
            if(diferenciaC >= 1 && diferenciaC <= 90){
                avisoLabelC.setText("*La jarra está por caducar*");
            }else if(diferenciaC <= 0){
                JOptionPane.showMessageDialog(null, "¡La jarra ya ha caducado!");
                avisoLabelC.setText("");
            }
        System.out.println("Fecha D: "+fechaCalibD);
        fechaCalD =  lbtc.fechaFormato(fechaCalibD);
        System.out.println("Fecha calibración D: "+formFecha.format(fechaCalD));    
        System.out.println("Fecha actual: "+formFecha.format(fecha));
        
            long diffD = fechaCalD.getTime() - dateNow.getTime();
            TimeUnit timeD = TimeUnit.DAYS; 
            long diferenciaD = timeD.convert(diffD, TimeUnit.MILLISECONDS);        
            System.out.println("Diferencia en días de la calibración Manguera D: " + diferenciaD);
            if(diferenciaD >= 1 && diferenciaD <= 90){
                avisoLabelD.setText("*La jarra está por caducar*");
            }else if(diferenciaD <= 0){
                JOptionPane.showMessageDialog(null, "¡La jarra ya ha caducado!");
                avisoLabelD.setText("");
            }
        System.out.println("Fecha E: "+fechaCalibE);
        fechaCalE =  lbtc.fechaFormato(fechaCalibE);
        System.out.println("Fecha calibración E: "+formFecha.format(fechaCalE));    
        System.out.println("Fecha actual: "+formFecha.format(fecha));
        
            long diffE = fechaCalE.getTime() - dateNow.getTime();
            TimeUnit timeE = TimeUnit.DAYS; 
            long diferenciaE = timeE.convert(diffE, TimeUnit.MILLISECONDS);        
            System.out.println("Diferencia en días de la calibración Manguera E: " + diferenciaE);
            if(diferenciaE >= 1 && diferenciaE <= 90){
                avisoLabelE.setText("*La jarra está por caducar*");
            }else if(diferenciaE <= 0){
                JOptionPane.showMessageDialog(null, "¡La jarra ya ha caducado!");
                avisoLabelE.setText("");
            }
        System.out.println("Fecha F: "+fechaCalibF);
        fechaCalF =  lbtc.fechaFormato(fechaCalibF);
        System.out.println("Fecha calibración F: "+formFecha.format(fechaCalF));    
        System.out.println("Fecha actual: "+formFecha.format(fecha));
        
            long diffF = fechaCalF.getTime() - dateNow.getTime();
            TimeUnit timeF = TimeUnit.DAYS; 
            long diferenciaF = timeF.convert(diffF, TimeUnit.MILLISECONDS);        
            System.out.println("Diferencia en días de la calibración Manguera F: " + diferenciaF);
            if(diferenciaF >= 1 && diferenciaF <= 90){
                avisoLabelF.setText("*La jarra está por caducar*");
            }else if(diferenciaF <= 0){
                JOptionPane.showMessageDialog(null, "¡La jarra ya ha caducado!");
                avisoLabelF.setText("");
            }

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
    System.out.println("+==++==++==++==++==++==++==++==++==++==++==++==+++==++==+");
        //a-> manguera  p1->numero de prueba med->min,med,max
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
    
    
    //CTS promedio e individual
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
        
        //VCMV promedio max med y min
        double  av20,akc ,avcmvmax,avcmvmed,avcmvmin;
        av20=Double.parseDouble(this.AV20.getText());
        akc=Double.parseDouble(this.AKC.getText());

        double avcmv1,avcmv2,avcmv3,avcmv4,avcmv5,avcmv6,avcmv7,avcmv8,avcmv9;
    //vcmv individual
avcmv1=Math.round((av20+alcprommax*akc*actsmaxp1)*100.0)/100.0;
   System.out.println("VCMV maximo P1 MA "+avcmv1);  
 avcmv2=Math.round((av20+alcprommax*akc*actsmaxp2)*100.0)/100.0;
   System.out.println("VCMV maximo P2 MA "+avcmv2);  
   avcmv3=Math.round((av20+alcprommax*akc*actsmaxp3)*100.0)/100.0;
   System.out.println("VCMV maximo P3 MA "+avcmv3);  
    avcmv4=Math.round((av20+alcprommed*akc*actsmedp1)*100.0)/100.0;
   System.out.println("VCMV medio P1 MA "+avcmv4);  
    avcmv5=Math.round((av20+alcprommed*akc*actsmedp2)*100.0)/100.0;
   System.out.println("VCMV medio P2 MA "+avcmv5);  
    avcmv6=Math.round((av20+alcprommed*akc*actsmedp3)*100.0)/100.0;
   System.out.println("VCMV medio P3 MA "+avcmv6);  
    avcmv7=Math.round((av20+alcprommin*akc*actsminp1)*100.0)/100.0;
   System.out.println("VCMV minimo P1 MA "+avcmv7);  
    avcmv8=Math.round((av20+alcprommin*akc*actsminp2)*100.0)/100.0;
   System.out.println("VCMV minimo P2 MA "+avcmv8);  
    avcmv9=Math.round((av20+alcprommin*akc*actsminp3)*100.0)/100.0;
   System.out.println("VCMV minimo P3 MA "+avcmv9);  
   
   
//promedio max med y min
        avcmvmax=Math.round((av20+alcprommax*akc*actsmaxprom)*100.0)/100.0;
        System.out.println("VCMV maximo promedio MA "+avcmvmax);
        avcmvmed=Math.round((av20+alcprommed*akc*actsmedprom)*100.0)/100.0;
                System.out.println("VCMV medio promedio MA "+avcmvmed);
        avcmvmin=Math.round((av20+alcprommin*akc*actsminprom)*100.0)/100.0;
                System.out.println("VCMV minimo promedio MA "+avcmvmin);
        
        
            AVCMVMAX.setText(String.valueOf(avcmvmax));
             AVCMVMED.setText(String.valueOf(avcmvmed));
             AVCMVMIN.setText(String.valueOf(avcmvmin));

//Error indicacion
//individual
double ae1,ae2,ae3,ae4,ae5,ae6,ae7,ae8,ae9,ai1,ai2,ai3,ai4,ai5,ai6,ai7,ai8,ai9;
 ai1=Double.parseDouble(this.AI1MAX.getText());    
 ae1=ai1-avcmv1;
System.out.println("ErrorIndicacion 1 MA "+ae1);
 ai2=Double.parseDouble(this.AI2MAX.getText());    
 ae2=ai2-avcmv2;
System.out.println("ErrorIndicacion 2 MA "+ae2);
 ai3=Double.parseDouble(this.AI3MAX.getText());    
 ae3=ai3-avcmv3;
System.out.println("ErrorIndicacion 3 MA "+ae3);
 ai4=Double.parseDouble(this.AI1MED.getText());    
 ae4=ai4-avcmv4;
System.out.println("ErrorIndicacion 4 MA "+ae4);
 ai5=Double.parseDouble(this.AI2MED.getText());    
 ae5=ai5-avcmv5;
System.out.println("ErrorIndicacion 5 MA "+ae5);
 ai6=Double.parseDouble(this.AI3MED.getText());    
 ae6=ai6-avcmv6;
System.out.println("ErrorIndicacion 6 MA "+ae6);
 ai7=Double.parseDouble(this.AI1MIN.getText());    
 ae7=ai7-avcmv7;
System.out.println("ErrorIndicacion 7 MA "+ae7);
 ai8=Double.parseDouble(this.AI2MIN.getText());    
 ae8=ai8-avcmv8;
System.out.println("ErrorIndicacion 8 MA "+ae8);
 ai9=Double.parseDouble(this.AI3MIN.getText());    
 ae9=ai9-avcmv9;
System.out.println("ErrorIndicacion 9 MA "+ae9);

//promedio
double aeprom1,aeprom2,aeprom3;
aeprom1=Math.round(((ae1+ae2+ae3)/3)*100.0)/100.0;
System.out.println("ErrorIndicacion prom 1 MA "+aeprom1);
aeprom2=Math.round(((ae4+ae5+ae6)/3)*100.0)/100.0;
System.out.println("ErrorIndicacion prom 2 MA "+aeprom2);
aeprom3=Math.round(((ae7+ae8+ae9)/3)*100.0)/100.0;
System.out.println("ErrorIndicacion prom 3 MA "+aeprom3);

  AEMAX.setText(String.valueOf(aeprom1));
    AEMED.setText(String.valueOf(aeprom2));
      AEMIN.setText(String.valueOf(aeprom3));
      
      //Error repetivilidad
      double aemax,aemin,aer;
      
      double [] aErroresIndicacion= new double[]{ae1,ae2,ae3 ,ae4,ae5,ae6,ae7,ae8,ae9};
       aemax=aErroresIndicacion[0];
         //se analizan los 9 erroresIndicacion para saber cual es el mayor
      for(int aciclo=1;  aciclo<aErroresIndicacion.length; aciclo++){
      if (aErroresIndicacion[aciclo]>aemax){
      aemax=aErroresIndicacion[aciclo];}
      }System.out.println("MA El error maximo es "+aemax);

          aemin=aErroresIndicacion[0];
                //se analizan los 9 erroresIndicacion para saber cual es el menor
      for(int aciclo=1;  aciclo<aErroresIndicacion.length; aciclo++){
      if (aErroresIndicacion[aciclo]<aemin){
      aemin=aErroresIndicacion[aciclo];}
      }System.out.println("MA El error minimo es "+aemin);
            //diferenncia de el maximo y el minimo para error repetivilidad
      aer=aemax-aemin;
      System.out.println("MA El error repetibilidad "+aer);
      
//tiempototal
  double attmax1,attmax2,attmax3,attmed1,attmed2,attmed3,attmin1,attmin2,attmin3;
double atimax1,atimax2,atimax3,atimed1,atimed2,atimed3,atimin1,atimin2,atimin3;

     atimax1= Double.parseDouble(this.ATIMAX1.getText());
     atimax2= Double.parseDouble(this.ATIMAX2.getText());
     atimax3= Double.parseDouble(this.ATIMAX3.getText());
     atimed1= Double.parseDouble(this.ATIMED1.getText());
     atimed2= Double.parseDouble(this.ATIMED2.getText());
     atimed3= Double.parseDouble(this.ATIMED3.getText());
     atimin1= Double.parseDouble(this.ATIMIN1.getText());
     atimin2= Double.parseDouble(this.ATIMIN2.getText());
     atimin3= Double.parseDouble(this.ATIMIN3.getText());
     
     if(atimax1!=0 && atimax2!=0 && atimax3!=0 && atimed1!=0 && atimed2!=0 && atimed3!=0 && atimin1!=0 && atimin2!=0 && atimin3!=0){
     
         attmax1=Math.round(((atimax1/60)*4)*100.0)/100.0;
     attmax2=Math.round(((atimax2/60)*4)*100.0)/100.0;
     attmax3=Math.round(((atimax3/60)*4)*100.0)/100.0;
     attmed1=Math.round(((atimed1/60)*4)*100.0)/100.0;
     attmed2=Math.round(((atimed2/60)*4)*100.0)/100.0;
     attmed3=Math.round(((atimed3/60)*4)*100.0)/100.0;
     attmin1=Math.round(((atimin1/60)*4)*100.0)/100.0;
     attmin2=Math.round(((atimin2/60)*4)*100.0)/100.0;
     attmin3=Math.round(((atimin3/60)*4)*100.0)/100.0;
     
        System.out.println("TiempoTotal max p1 MA "+attmax1);
        System.out.println("TiempoTotal max p2 MA "+attmax2);
        System.out.println("TiempoTotal max p3 MA "+attmax3);
        System.out.println("TiempoTotal med p1 MA "+attmed1);
        System.out.println("TiempoTotal med p2 MA "+attmed2);
        System.out.println("TiempoTotal med p3 MA "+attmed3);
        System.out.println("TiempoTotal min p1 MA "+attmin1);
        System.out.println("TiempoTotal min p2 MA "+attmin2);
        System.out.println("TiempoTotal min p3 MA "+attmin3);

//QV
double aqv1,aqv2,aqv3,aqv4,aqv5,aqv6,aqv7,aqv8,aqv9,aqvmax,aqvmed,aqvmin;

aqv1=avcmv1/attmax1;
aqv2=avcmv2/attmax2;
aqv3=avcmv3/attmax3;
aqv4=avcmv4/attmed1;
aqv5=avcmv5/attmed2;
aqv6=avcmv6/attmed3;
aqv7=avcmv7/attmin1;
aqv8=avcmv8/attmin2;
aqv9=avcmv9/attmin3;

aqvmax=Math.round(((aqv1+aqv2+aqv3)/3)*100.0)/100.0;
aqvmed=Math.round(((aqv4+aqv5+aqv6)/3)*100.0)/100.0;
aqvmin=Math.round(((aqv7+aqv8+aqv9)/3)*100.0)/100.0;

 System.out.println("QV 1 MA "+aqv1);
   System.out.println("QV 2 MA "+aqv2);
    System.out.println("QV 3 MA "+aqv3);
          System.out.println("QV 4 MA "+aqv4);
          System.out.println("QV 5 MA "+aqv5);
            System.out.println("QV 6 MA "+aqv6);
             System.out.println("QV 7 MA "+aqv7);
              System.out.println("QV 8 MA "+aqv8);
                System.out.println("QV 9 MA "+aqv9);

                  System.out.println("QV max MA "+aqvmax);
                System.out.println("QV med MA "+aqvmed);
                System.out.println("QV min MA "+aqvmin);
                
             AQVMAX.setText(String.valueOf(aqvmax));
            AQVMED.setText(String.valueOf(aqvmed));
            AQVMIN.setText(String.valueOf(aqvmin));
                
     }else {System.out.println("ADVERTENCIA TIEMPO TOTAL MA EN 0\n INGRESE UN VALOR VALIDO\n");}
     
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

        double bvcmv1,bvcmv2,bvcmv3,bvcmv4,bvcmv5,bvcmv6,bvcmv7,bvcmv8,bvcmv9;
    //vcmv individual
bvcmv1=Math.round((bv20+blcprommax*bkc*bctsmaxp1)*100.0)/100.0;
   System.out.println("VCMV maximo P1 MB "+bvcmv1);  
 bvcmv2=Math.round((bv20+blcprommax*bkc*bctsmaxp2)*100.0)/100.0;
   System.out.println("VCMV maximo P2 MB "+bvcmv2);  
   bvcmv3=Math.round((bv20+blcprommax*bkc*bctsmaxp3)*100.0)/100.0;
   System.out.println("VCMV maximo P3 MB "+bvcmv3);  
    bvcmv4=Math.round((bv20+blcprommed*bkc*bctsmedp1)*100.0)/100.0;
   System.out.println("VCMV medio P1 MB "+bvcmv4);  
    bvcmv5=Math.round((bv20+blcprommed*bkc*bctsmedp2)*100.0)/100.0;
   System.out.println("VCMV medio P2 MB "+bvcmv5);  
    bvcmv6=Math.round((bv20+blcprommed*bkc*bctsmedp3)*100.0)/100.0;
   System.out.println("VCMV medio P3 MB "+bvcmv6);  
    bvcmv7=Math.round((bv20+blcprommin*bkc*bctsminp1)*100.0)/100.0;
   System.out.println("VCMV minimo P1 MB "+bvcmv7);  
    bvcmv8=Math.round((bv20+blcprommin*bkc*bctsminp2)*100.0)/100.0;
   System.out.println("VCMV minimo P2 MB "+bvcmv8);  
    bvcmv9=Math.round((bv20+blcprommin*bkc*bctsminp3)*100.0)/100.0;
   System.out.println("VCMV minimo P3 MB "+bvcmv9);  
   
//promedio max med y min
        bvcmvmax=Math.round((bv20+blcprommax*bkc*bctsmaxprom)*100.0)/100.0;
        System.out.println("VCMV maximo promedio MB "+bvcmvmax);
        bvcmvmed=Math.round((bv20+blcprommed*bkc*bctsmedprom)*100.0)/100.0;
                System.out.println("VCMV medio promedio MB "+bvcmvmed);
        bvcmvmin=Math.round((bv20+blcprommin*bkc*bctsminprom)*100.0)/100.0;
                System.out.println("VCMV minimo promedio MB "+bvcmvmin);
        
        
            BVCMVMAX.setText(String.valueOf(bvcmvmax));
             BVCMVMED.setText(String.valueOf(bvcmvmed));
             BVCMVMIN.setText(String.valueOf(bvcmvmin));
             
             //Error indicacion
//individual
double be1,be2,be3,be4,be5,be6,be7,be8,be9,bi1,bi2,bi3,bi4,bi5,bi6,bi7,bi8,bi9;
 bi1=Double.parseDouble(this.BI1MAX.getText());    
 be1=bi1-bvcmv1;
System.out.println("ErrorIndicacion 1 MB "+be1);
 bi2=Double.parseDouble(this.BI2MAX.getText());    
 be2=bi2-bvcmv2;
System.out.println("ErrorIndicacion 2 MB "+be2);
 bi3=Double.parseDouble(this.BI3MAX.getText());    
 be3=bi3-bvcmv3;
System.out.println("ErrorIndicacion 3 MB "+be3);
 bi4=Double.parseDouble(this.BI1MED.getText());    
 be4=bi4-bvcmv4;
System.out.println("ErrorIndicacion 4 MB "+be4);
 bi5=Double.parseDouble(this.BI2MED.getText());    
 be5=bi5-bvcmv5;
System.out.println("ErrorIndicacion 5 MB "+be5);
 bi6=Double.parseDouble(this.BI3MED.getText());    
 be6=bi6-bvcmv6;
System.out.println("ErrorIndicacion 6 MB "+be6);
 bi7=Double.parseDouble(this.BI1MIN.getText());    
 be7=bi7-bvcmv7;
System.out.println("ErrorIndicacion 7 MB "+be7);
 bi8=Double.parseDouble(this.BI2MIN.getText());    
 be8=bi8-bvcmv8;
System.out.println("ErrorIndicacion 8 MB "+be8);
 bi9=Double.parseDouble(this.BI3MIN.getText());    
 be9=bi9-bvcmv9;
System.out.println("ErrorIndicacion 9 MB "+be9);

//promedio
double beprom1,beprom2,beprom3;
beprom1=Math.round(((be1+be2+be3)/3)*100.0)/100.0;
System.out.println("ErrorIndicacion prom 1 MB "+beprom1);
beprom2=Math.round(((be4+be5+be6)/3)*100.0)/100.0;
System.out.println("ErrorIndicacion prom 2 MB "+beprom2);
beprom3=Math.round(((be7+be8+be9)/3)*100.0)/100.0;
System.out.println("ErrorIndicacion prom 3 MB "+beprom3);

  BEMAX.setText(String.valueOf(beprom1));
    BEMED.setText(String.valueOf(beprom2));
      BEMIN.setText(String.valueOf(beprom3));

      
      //Error repetivilidad
      double bemax,bemin,ber;
      
      double [] bErroresIndicacion= new double[]{be1,be2,be3 ,be4,be5,be6,be7,be8,be9};
       bemax=bErroresIndicacion[0];
         //se analizan los 9 erroresIndicacion para saber cual es el mayor
      for(int aciclo=1;  aciclo<bErroresIndicacion.length; aciclo++){
      if (bErroresIndicacion[aciclo]>bemax){
      bemax=bErroresIndicacion[aciclo ];}
      }System.out.println("MB El error maximo es "+bemax);

          bemin=bErroresIndicacion[0];
                //se analizan los 9 erroresIndicacion para saber cual es el menor
      for(int aciclo=1;  aciclo<bErroresIndicacion.length; aciclo++){
      if (bErroresIndicacion[aciclo]<bemin){
      bemin=bErroresIndicacion[aciclo];}
      }System.out.println("MB El error minimo es "+bemin);
            //diferenncia de el maximo y el minimo para error repetivilidad
      ber=bemax-bemin;
      System.out.println("MB El error repetibilidad "+ber);
      
      //tiempototal
  double bttmax1,bttmax2,bttmax3,bttmed1,bttmed2,bttmed3,bttmin1,bttmin2,bttmin3;
double btimax1,btimax2,btimax3,btimed1,btimed2,btimed3,btimin1,btimin2,btimin3;

     btimax1= Double.parseDouble(this.BTIMAX1.getText());
     btimax2= Double.parseDouble(this.BTIMAX2.getText());
     btimax3= Double.parseDouble(this.BTIMAX3.getText());
     btimed1= Double.parseDouble(this.BTIMED1.getText());
     btimed2= Double.parseDouble(this.BTIMED2.getText());
     btimed3= Double.parseDouble(this.BTIMED3.getText());
     btimin1= Double.parseDouble(this.BTIMIN1.getText());
     btimin2= Double.parseDouble(this.BTIMIN2.getText());
     btimin3= Double.parseDouble(this.BTIMIN3.getText());
     
     if(btimax1!=0 && btimax2!=0 && btimax3!=0 && btimed1!=0 && btimed2!=0 && btimed3!=0 && btimin1!=0 && btimin2!=0 && btimin3!=0){
     
         bttmax1=Math.round(((btimax1/60)*4)*100.0)/100.0;
     bttmax2=Math.round(((btimax2/60)*4)*100.0)/100.0;
     bttmax3=Math.round(((btimax3/60)*4)*100.0)/100.0;
     bttmed1=Math.round(((btimed1/60)*4)*100.0)/100.0;
     bttmed2=Math.round(((btimed2/60)*4)*100.0)/100.0;
     bttmed3=Math.round(((btimed3/60)*4)*100.0)/100.0;
     bttmin1=Math.round(((btimin1/60)*4)*100.0)/100.0;
     bttmin2=Math.round(((btimin2/60)*4)*100.0)/100.0;
     bttmin3=Math.round(((btimin3/60)*4)*100.0)/100.0;
     
        System.out.println("TiempoTotal max p1 MB "+bttmax1);
        System.out.println("TiempoTotal max p2 MB "+bttmax2);
        System.out.println("TiempoTotal max p3 MB "+bttmax3);
        System.out.println("TiempoTotal med p1 MB "+bttmed1);
        System.out.println("TiempoTotal med p2 MB "+bttmed2);
        System.out.println("TiempoTotal med p3 MB "+bttmed3);
        System.out.println("TiempoTotal min p1 MB "+bttmin1);
        System.out.println("TiempoTotal min p2 MB "+bttmin2);
        System.out.println("TiempoTotal min p3 MB "+bttmin3);

//QV
double bqv1,bqv2,bqv3,bqv4,bqv5,bqv6,bqv7,bqv8,bqv9,bqvmax,bqvmed,bqvmin;

bqv1=bvcmv1/bttmax1;
bqv2=bvcmv2/bttmax2;
bqv3=bvcmv3/bttmax3;
bqv4=bvcmv4/bttmed1;
bqv5=bvcmv5/bttmed2;
bqv6=bvcmv6/bttmed3;
bqv7=bvcmv7/bttmin1;
bqv8=bvcmv8/bttmin2;
bqv9=bvcmv9/bttmin3;

bqvmax=Math.round(((bqv1+bqv2+bqv3)/3)*100.0)/100.0;
bqvmed=Math.round(((bqv4+bqv5+bqv6)/3)*100.0)/100.0;
bqvmin=Math.round(((bqv7+bqv8+bqv9)/3)*100.0)/100.0;

 System.out.println("QV 1 MB "+bqv1);
   System.out.println("QV 2 MB "+bqv2);
    System.out.println("QV 3 MB "+bqv3);
          System.out.println("QV 4 MB "+bqv4);
          System.out.println("QV 5 MB "+bqv5);
            System.out.println("QV 6 MB "+bqv6);
             System.out.println("QV 7 MB "+bqv7);
              System.out.println("QV 8 MB "+bqv8);
                System.out.println("QV 9 MB "+bqv9);

                  System.out.println("QV max MB "+bqvmax);
                System.out.println("QV med MB "+bqvmed);
                System.out.println("QV min MB "+bqvmin);
                
             BQVMAX.setText(String.valueOf(bqvmax));
            BQVMED.setText(String.valueOf(bqvmed));
            BQVMIN.setText(String.valueOf(bqvmin));
                
     }else {System.out.println("ADVERTENCIA TIEMPO TOTAL MB EN 0\n INGRESE UN VALOR VALIDO\n");}
     
      
    //------------------------------------------------------------------------------
           //MANGUERA C  
     double  cp1maxI,cp2maxI,cp3maxI,cp1medI,cp2medI,cp3medI,cp1minI,cp2minI,cp3minI, clcprommax,clcprommed,clcprommin;
//Prueba maximo
 cp1maxI= Double.parseDouble(this.CP1MAX.getText());
      cp2maxI= Double.parseDouble(this.CP2MAX.getText());
       cp3maxI=Double.parseDouble(this.CP3MAX.getText());
    clcprommax=Math.round((  (cp1maxI+cp2maxI+cp3maxI)/3)*100.0)/100.0;
    //LC max
    CLCMAX.setText(String.valueOf(clcprommax));
    //Prueba medio
     cp1medI= Double.parseDouble(this.CP1MED.getText());
      cp2medI= Double.parseDouble(this.CP2MED.getText());
       cp3medI= Double.parseDouble(this.CP3MED.getText());
    clcprommed= Math.round(((cp1medI+cp2medI+cp3medI)/3)*100.0)/100.0;
        //LC med
    CLCMED.setText(String.valueOf(clcprommed));
    
        //Prueba minimo
     cp1minI= Double.parseDouble(this.CP1MIN.getText());
      cp2minI= Double.parseDouble(this.CP2MIN.getText());
       cp3minI= Double.parseDouble(this.CP3MIN.getText());
    clcprommin= Math.round(((cp1minI+cp2minI+cp3minI)/3)*100.0)/100.0;
        //LC min
    CLCMIN.setText(String.valueOf(clcprommin));
    
    
    //CTS
    double  cctsmaxp1,cctsmaxp2,cctsmaxp3,cctsmedp1,cctsmedp2,cctsmedp3,cctsminp1,cctsminp2,cctsminp3;
    double ctmaxp1,ctmaxp2,ctmaxp3,ctmedp1,ctmedp2,ctmedp3,ctminp1,ctminp2,ctminp3;
    double cctsmaxprom,cctsmedprom,cctsminprom;

  ctmaxp1=Double.parseDouble(this.CTMAXP1.getText());
    cctsmaxp1=1+(0.0000477)*(ctmaxp1-20);
        ctmaxp2=Double.parseDouble(this.CTMAXP2.getText());
    cctsmaxp2=1+(0.0000477)*(ctmaxp2-20);
        ctmaxp3=Double.parseDouble(this.CTMAXP3.getText());
    cctsmaxp3=1+(0.0000477)*(ctmaxp3-20);
    
    cctsmaxprom=(cctsmaxp1+cctsmaxp2+cctsmaxp3)/3;
        System.out.println("CTS maximo promedio MC "+cctsmaxprom);
    
        ctmedp1=Double.parseDouble(this.CTMEDP1.getText());
    cctsmedp1=1+(0.0000477)*(ctmedp1-20);
        ctmedp2=Double.parseDouble(this.CTMEDP2.getText());
    cctsmedp2=1+(0.0000477)*(ctmedp2-20);
        ctmedp3=Double.parseDouble(this.CTMEDP3.getText());
    cctsmedp3=1+(0.0000477)*(ctmedp3-20);
    
        cctsmedprom=(cctsmedp1+cctsmedp2+cctsmedp3)/3;
            System.out.println("CTS medio promedio MC "+cctsmedprom);
            
        ctminp1=Double.parseDouble(this.CTMINP1.getText());
    cctsminp1=1+(0.0000477)*(ctminp1-20);
        ctminp2=Double.parseDouble(this.CTMINP2.getText());
    cctsminp2=1+(0.0000477)*(ctminp2-20);
        ctminp3=Double.parseDouble(this.CTMINP3.getText());
    cctsminp3=1+(0.0000477)*(ctminp3-20);
    
        cctsminprom=(cctsminp1+cctsminp2+cctsminp3)/3;
        System.out.println("CTS minimo promedio MC "+cctsminprom);
        
        //VCMV
        double  cv20,ckc ,cvcmvmax,cvcmvmed,cvcmvmin;
        cv20=Double.parseDouble(this.CV20.getText());
        ckc=Double.parseDouble(this.CKC.getText());

        double cvcmv1,cvcmv2,cvcmv3,cvcmv4,cvcmv5,cvcmv6,cvcmv7,cvcmv8,cvcmv9;
    //vcmv individual
cvcmv1=Math.round((cv20+clcprommax*ckc*cctsmaxp1)*100.0)/100.0;
   System.out.println("VCMV maximo P1 MC "+cvcmv1);  
 cvcmv2=Math.round((cv20+clcprommax*ckc*cctsmaxp2)*100.0)/100.0;
   System.out.println("VCMV maximo P2 MC "+cvcmv2);  
   cvcmv3=Math.round((cv20+clcprommax*ckc*cctsmaxp3)*100.0)/100.0;
   System.out.println("VCMV maximo P3 MC "+cvcmv3);  
    cvcmv4=Math.round((cv20+clcprommed*ckc*cctsmedp1)*100.0)/100.0;
   System.out.println("VCMV medio P1 MC "+cvcmv4);  
    cvcmv5=Math.round((cv20+clcprommed*ckc*cctsmedp2)*100.0)/100.0;
   System.out.println("VCMV medio P2 MC "+cvcmv5);  
    cvcmv6=Math.round((cv20+clcprommed*ckc*cctsmedp3)*100.0)/100.0;
   System.out.println("VCMV medio P3 MC "+cvcmv6);  
    cvcmv7=Math.round((cv20+clcprommin*ckc*cctsminp1)*100.0)/100.0;
   System.out.println("VCMV minimo P1 MC "+cvcmv7);  
    cvcmv8=Math.round((cv20+clcprommin*ckc*cctsminp2)*100.0)/100.0;
   System.out.println("VCMV minimo P2 MC "+cvcmv8);  
    cvcmv9=Math.round((cv20+clcprommin*ckc*cctsminp3)*100.0)/100.0;
   System.out.println("VCMV minimo P3 MC "+cvcmv9);  
   
//promedio max med y min
        cvcmvmax=Math.round((cv20+clcprommax*ckc*cctsmaxprom)*100.0)/100.0;
        System.out.println("VCMV maximo promedio MC "+cvcmvmax);
        cvcmvmed=Math.round((cv20+clcprommed*ckc*cctsmedprom)*100.0)/100.0;
                System.out.println("VCMV medio promedio MC "+cvcmvmed);
        cvcmvmin=Math.round((cv20+clcprommin*ckc*cctsminprom)*100.0)/100.0;
                System.out.println("VCMV minimo promedio MC "+cvcmvmin);
        
        
            CVCMVMAX.setText(String.valueOf(cvcmvmax));
             CVCMVMED.setText(String.valueOf(cvcmvmed));
             CVCMVMIN.setText(String.valueOf(cvcmvmin));
             
             //Error indicacion
//individual
double ce1,ce2,ce3,ce4,ce5,ce6,ce7,ce8,ce9,ci1,ci2,ci3,ci4,ci5,ci6,ci7,ci8,ci9;
 ci1=Double.parseDouble(this.CI1MAX.getText());    
 ce1=ci1-cvcmv1;
System.out.println("ErrorIndicacion 1 MC "+ce1);
 ci2=Double.parseDouble(this.CI2MAX.getText());    
 ce2=ci2-cvcmv2;
System.out.println("ErrorIndicacion 2 MC "+ce2);
 ci3=Double.parseDouble(this.CI3MAX.getText());    
 ce3=ci3-cvcmv3;
System.out.println("ErrorIndicacion 3 MC "+ce3);
 ci4=Double.parseDouble(this.CI1MED.getText());    
 ce4=ci4-cvcmv4;
System.out.println("ErrorIndicacion 4 MC "+ce4);
 ci5=Double.parseDouble(this.CI2MED.getText());    
 ce5=ci5-cvcmv5;
System.out.println("ErrorIndicacion 5 MC "+ce5);
 ci6=Double.parseDouble(this.CI3MED.getText());    
 ce6=ci6-cvcmv6;
System.out.println("ErrorIndicacion 6 MC "+ce6);
 ci7=Double.parseDouble(this.CI1MIN.getText());    
 ce7=ci7-cvcmv7;
System.out.println("ErrorIndicacion 7 MC "+ce7);
 ci8=Double.parseDouble(this.CI2MIN.getText());    
 ce8=ci8-cvcmv8;
System.out.println("ErrorIndicacion 8 MC "+ce8);
 ci9=Double.parseDouble(this.CI3MIN.getText());    
 ce9=ci9-cvcmv9;
System.out.println("ErrorIndicacion 9 MC "+ce9);

//promedio
double ceprom1,ceprom2,ceprom3;
ceprom1=Math.round(((ce1+ce2+ce3)/3)*100.0)/100.0;
System.out.println("ErrorIndicacion prom 1 MC "+ceprom1);
ceprom2=Math.round(((ce4+ce5+ce6)/3)*100.0)/100.0;
System.out.println("ErrorIndicacion prom 2 MC "+ceprom2);
ceprom3=Math.round(((ce7+ce8+ce9)/3)*100.0)/100.0;
System.out.println("ErrorIndicacion prom 3 MC "+ceprom3);

  CEMAX.setText(String.valueOf(ceprom1));
    CEMED.setText(String.valueOf(ceprom2));
      CEMIN.setText(String.valueOf(ceprom3));
      
            //Error repetivilidad
      double cemax,cemin,cer;
      
      double [] cErroresIndicacion= new double[]{ce1,ce2,ce3 ,ce4,ce5,ce6,ce7,ce8,ce9};
       cemax=cErroresIndicacion[0];
         //se analizan los 9 erroresIndicacion para saber cual es el mayor
      for(int aciclo=1;  aciclo<cErroresIndicacion.length; aciclo++){
      if (cErroresIndicacion[aciclo]>cemax){
      cemax=cErroresIndicacion[aciclo ];}
      }System.out.println("MC El error maximo es "+cemax);

          cemin=cErroresIndicacion[0];
                //se analizan los 9 erroresIndicacion para saber cual es el menor
      for(int aciclo=1;  aciclo<cErroresIndicacion.length; aciclo++){
      if (cErroresIndicacion[aciclo]<cemin){
      cemin=cErroresIndicacion[aciclo];}
      }System.out.println("MC El error minimo es "+cemin);
            //diferenncia de el maximo y el minimo para error repetivilidad
      cer=cemax-cemin;
      System.out.println("MC El error repetibilidad "+cer);
      
      //tiempototal
  double cttmax1,cttmax2,cttmax3,cttmed1,cttmed2,cttmed3,cttmin1,cttmin2,cttmin3;
double ctimax1,ctimax2,ctimax3,ctimed1,ctimed2,ctimed3,ctimin1,ctimin2,ctimin3;

     ctimax1= Double.parseDouble(this.CTIMAX1.getText());
     ctimax2= Double.parseDouble(this.CTIMAX2.getText());
     ctimax3= Double.parseDouble(this.CTIMAX3.getText());
     ctimed1= Double.parseDouble(this.CTIMED1.getText());
     ctimed2= Double.parseDouble(this.CTIMED2.getText());
     ctimed3= Double.parseDouble(this.CTIMED3.getText());
     ctimin1= Double.parseDouble(this.CTIMIN1.getText());
     ctimin2= Double.parseDouble(this.CTIMIN2.getText());
     ctimin3= Double.parseDouble(this.CTIMIN3.getText());
     
     if(ctimax1!=0 && ctimax2!=0 && ctimax3!=0 && ctimed1!=0 && ctimed2!=0 && ctimed3!=0 && ctimin1!=0 && ctimin2!=0 && ctimin3!=0){
     
       cttmax1=Math.round(((ctimax1/60)*4)*100.0)/100.0;
     cttmax2=Math.round(((ctimax2/60)*4)*100.0)/100.0;
     cttmax3=Math.round(((ctimax3/60)*4)*100.0)/100.0;
     cttmed1=Math.round(((ctimed1/60)*4)*100.0)/100.0;
     cttmed2=Math.round(((ctimed2/60)*4)*100.0)/100.0;
     cttmed3=Math.round(((ctimed3/60)*4)*100.0)/100.0;
     cttmin1=Math.round(((ctimin1/60)*4)*100.0)/100.0;
     cttmin2=Math.round(((ctimin2/60)*4)*100.0)/100.0;
     cttmin3=Math.round(((ctimin3/60)*4)*100.0)/100.0;
     
        System.out.println("TiempoTotal max p1 MC "+cttmax1);
        System.out.println("TiempoTotal max p2 MC "+cttmax2);
        System.out.println("TiempoTotal max p3 MC "+cttmax3);
        System.out.println("TiempoTotal med p1 MC "+cttmed1);
        System.out.println("TiempoTotal med p2 MC "+cttmed2);
        System.out.println("TiempoTotal med p3 MC "+cttmed3);
        System.out.println("TiempoTotal min p1 MC "+cttmin1);
        System.out.println("TiempoTotal min p2 MC "+cttmin2);
        System.out.println("TiempoTotal min p3 MC "+cttmin3);

//QV
double cqv1,cqv2,cqv3,cqv4,cqv5,cqv6,cqv7,cqv8,cqv9,cqvmax,cqvmed,cqvmin;

cqv1=cvcmv1/cttmax1;
cqv2=cvcmv2/cttmax2;
cqv3=cvcmv3/cttmax3;
cqv4=cvcmv4/cttmed1;
cqv5=cvcmv5/cttmed2;
cqv6=cvcmv6/cttmed3;
cqv7=cvcmv7/cttmin1;
cqv8=cvcmv8/cttmin2;
cqv9=cvcmv9/cttmin3;

cqvmax=Math.round(((cqv1+cqv2+cqv3)/3)*100.0)/100.0;
cqvmed=Math.round(((cqv4+cqv5+cqv6)/3)*100.0)/100.0;
cqvmin=Math.round(((cqv7+cqv8+cqv9)/3)*100.0)/100.0;

 System.out.println("QV 1 MC "+cqv1);
   System.out.println("QV 2 MC "+cqv2);
    System.out.println("QV 3 MC "+cqv3);
          System.out.println("QV 4 MC "+cqv4);
          System.out.println("QV 5 MC "+cqv5);
            System.out.println("QV 6 MC "+cqv6);
             System.out.println("QV 7 MC "+cqv7);
              System.out.println("QV 8 MC "+cqv8);
                System.out.println("QV 9 MC "+cqv9);

                  System.out.println("QV max MC "+cqvmax);
                System.out.println("QV med MC "+cqvmed);
                System.out.println("QV min MC "+cqvmin);
                
             CQVMAX.setText(String.valueOf(cqvmax));
            CQVMED.setText(String.valueOf(cqvmed));
            CQVMIN.setText(String.valueOf(cqvmin));
                
     }else {System.out.println("ADVERTENCIA TIEMPO TOTAL MC EN 0\n INGRESE UN VALOR VALIDO\n");}
     
    //------------------------------------------------------------------------------
               //MANGUERA D  
     double  dp1maxI,dp2maxI,dp3maxI,dp1medI,dp2medI,dp3medI,dp1minI,dp2minI,dp3minI, dlcprommax,dlcprommed,dlcprommin;
//Prueba maximo
dp1maxI= Double.parseDouble(this.DP1MAX.getText());
      dp2maxI= Double.parseDouble(this.DP2MAX.getText());
       dp3maxI=Double.parseDouble(this.DP3MAX.getText());
    dlcprommax=Math.round((  (dp1maxI+dp2maxI+dp3maxI)/3)*100.0)/100.0;
    //LC max
    DLCMAX.setText(String.valueOf(dlcprommax));
    //Prueba medio
     dp1medI= Double.parseDouble(this.DP1MED.getText());
      dp2medI= Double.parseDouble(this.DP2MED.getText());
       dp3medI= Double.parseDouble(this.DP3MED.getText());
    dlcprommed= Math.round(((dp1medI+dp2medI+dp3medI)/3)*100.0)/100.0;
        //LC med
    DLCMED.setText(String.valueOf(dlcprommed));
    
        //Prueba minimo
     dp1minI= Double.parseDouble(this.DP1MIN.getText());
      dp2minI= Double.parseDouble(this.DP2MIN.getText());
       dp3minI= Double.parseDouble(this.DP3MIN.getText());
    dlcprommin= Math.round(((dp1minI+dp2minI+dp3minI)/3)*100.0)/100.0;
        //LC min
    DLCMIN.setText(String.valueOf(dlcprommin));
    
    
    //CTS
    double  dctsmaxp1,dctsmaxp2,dctsmaxp3,dctsmedp1,dctsmedp2,dctsmedp3,dctsminp1,dctsminp2,dctsminp3;
    double dtmaxp1,dtmaxp2,dtmaxp3,dtmedp1,dtmedp2,dtmedp3,dtminp1,dtminp2,dtminp3;
    double dctsmaxprom,dctsmedprom,dctsminprom;

  dtmaxp1=Double.parseDouble(this.DTMAXP1.getText());
    dctsmaxp1=1+(0.0000477)*(dtmaxp1-20);
        dtmaxp2=Double.parseDouble(this.DTMAXP2.getText());
    dctsmaxp2=1+(0.0000477)*(dtmaxp2-20);
        dtmaxp3=Double.parseDouble(this.DTMAXP3.getText());
    dctsmaxp3=1+(0.0000477)*(dtmaxp3-20);
    
    dctsmaxprom=(dctsmaxp1+dctsmaxp2+dctsmaxp3)/3;
        System.out.println("CTS maximo promedio MD "+dctsmaxprom);
    
        dtmedp1=Double.parseDouble(this.DTMEDP1.getText());
    dctsmedp1=1+(0.0000477)*(dtmedp1-20);
        dtmedp2=Double.parseDouble(this.DTMEDP2.getText());
    dctsmedp2=1+(0.0000477)*(dtmedp2-20);
        dtmedp3=Double.parseDouble(this.DTMEDP3.getText());
    dctsmedp3=1+(0.0000477)*(dtmedp3-20);
    
        dctsmedprom=(dctsmedp1+dctsmedp2+dctsmedp3)/3;
            System.out.println("CTS medio promedio MD "+dctsmedprom);
            
        dtminp1=Double.parseDouble(this.DTMINP1.getText());
    dctsminp1=1+(0.0000477)*(dtminp1-20);
        dtminp2=Double.parseDouble(this.DTMINP2.getText());
    dctsminp2=1+(0.0000477)*(dtminp2-20);
        dtminp3=Double.parseDouble(this.DTMINP3.getText());
    dctsminp3=1+(0.0000477)*(dtminp3-20);
    
        dctsminprom=(dctsminp1+dctsminp2+dctsminp3)/3;
        System.out.println("CTS minimo promedio MD "+dctsminprom);
        
        //VCMV
        double  dv20,dkc ,dvcmvmax,dvcmvmed,dvcmvmin;
        dv20=Double.parseDouble(this.DV20.getText());
        dkc=Double.parseDouble(this.DKC.getText());

        
        double dvcmv1,dvcmv2,dvcmv3,dvcmv4,dvcmv5,dvcmv6,dvcmv7,dvcmv8,dvcmv9;
    //vcmv individual
dvcmv1=Math.round((dv20+dlcprommax*dkc*dctsmaxp1)*100.0)/100.0;
   System.out.println("VCMV maximo P1 MD "+dvcmv1);  
 dvcmv2=Math.round((dv20+dlcprommax*dkc*dctsmaxp2)*100.0)/100.0;
   System.out.println("VCMV maximo P2 MD "+dvcmv2);  
   dvcmv3=Math.round((dv20+dlcprommax*dkc*dctsmaxp3)*100.0)/100.0;
   System.out.println("VCMV maximo P3 MD "+dvcmv3);  
    dvcmv4=Math.round((dv20+dlcprommed*dkc*dctsmedp1)*100.0)/100.0;
   System.out.println("VCMV medio P1 MD "+dvcmv4);  
    dvcmv5=Math.round((dv20+dlcprommed*dkc*dctsmedp2)*100.0)/100.0;
   System.out.println("VCMV medio P2 MD "+dvcmv5);  
    dvcmv6=Math.round((dv20+dlcprommed*dkc*dctsmedp3)*100.0)/100.0;
   System.out.println("VCMV medio P3 MD "+dvcmv6);  
    dvcmv7=Math.round((dv20+dlcprommin*dkc*dctsminp1)*100.0)/100.0;
   System.out.println("VCMV minimo P1 MD "+dvcmv7);  
    dvcmv8=Math.round((dv20+dlcprommin*dkc*dctsminp2)*100.0)/100.0;
   System.out.println("VCMV minimo P2 MD "+dvcmv8);  
    dvcmv9=Math.round((dv20+dlcprommin*dkc*dctsminp3)*100.0)/100.0;
   System.out.println("VCMV minimo P3 MD "+dvcmv9);  
   
   
//promedio max med y min
        
        dvcmvmax=Math.round((dv20+dlcprommax*dkc*dctsmaxprom)*100.0)/100.0;
        System.out.println("VCMV maximo promedio MD "+dvcmvmax);
        dvcmvmed=Math.round((dv20+dlcprommed*dkc*dctsmedprom)*100.0)/100.0;
                System.out.println("VCMV medio promedio MD "+dvcmvmed);
        dvcmvmin=Math.round((dv20+dlcprommin*dkc*dctsminprom)*100.0)/100.0;
                System.out.println("VCMV minimo promedio MD "+dvcmvmin);
        
        
            DVCMVMAX.setText(String.valueOf(dvcmvmax));
             DVCMVMED.setText(String.valueOf(dvcmvmed));
             DVCMVMIN.setText(String.valueOf(dvcmvmin));
             
                          //Error indicacion
//individual
double de1,de2,de3,de4,de5,de6,de7,de8,de9,di1,di2,di3,di4,di5,di6,di7,di8,di9;
 di1=Double.parseDouble(this.DI1MAX.getText());    
 de1=di1-dvcmv1;
System.out.println("ErrorIndicacion 1 MD "+de1);
 di2=Double.parseDouble(this.DI2MAX.getText());    
 de2=di2-dvcmv2;
System.out.println("ErrorIndicacion 2 MD "+de2);
 di3=Double.parseDouble(this.DI3MAX.getText());    
 de3=di3-dvcmv3;
System.out.println("ErrorIndicacion 3 MD "+de3);
 di4=Double.parseDouble(this.DI1MED.getText());    
 de4=di4-dvcmv4;
System.out.println("ErrorIndicacion 4 MD "+de4);
 di5=Double.parseDouble(this.DI2MED.getText());    
 de5=di5-dvcmv5;
System.out.println("ErrorIndicacion 5 MD "+de5);
 di6=Double.parseDouble(this.DI3MED.getText());    
 de6=di6-dvcmv6;
System.out.println("ErrorIndicacion 6 MD "+de6);
 di7=Double.parseDouble(this.DI1MIN.getText());    
 de7=di7-dvcmv7;
System.out.println("ErrorIndicacion 7 MD "+de7);
 di8=Double.parseDouble(this.DI2MIN.getText());    
 de8=di8-dvcmv8;
System.out.println("ErrorIndicacion 8 MD "+de8);
 di9=Double.parseDouble(this.DI3MIN.getText());    
 de9=di9-dvcmv9;
System.out.println("ErrorIndicacion 9 MD "+de9);

//promedio
double deprom1,deprom2,deprom3;
deprom1=Math.round(((de1+de2+de3)/3)*100.0)/100.0;
System.out.println("ErrorIndicacion prom 1 MD "+deprom1);
deprom2=Math.round(((de4+de5+de6)/3)*100.0)/100.0;
System.out.println("ErrorIndicacion prom 2 MD "+deprom2);
deprom3=Math.round(((de7+de8+de9)/3)*100.0)/100.0;
System.out.println("ErrorIndicacion prom 3 MD "+deprom3);

  DEMAX.setText(String.valueOf(deprom1));
    DEMED.setText(String.valueOf(deprom2));
      DEMIN.setText(String.valueOf(deprom3));
      
      
            //Error repetivilidad
      double demax,demin,der;
      
      double [] dErroresIndicacion= new double[]{de1,de2,de3 ,de4,de5,de6,de7,de8,de9};
       demax=dErroresIndicacion[0];
         //se analizan los 9 erroresIndicacion para saber cual es el mayor
      for(int aciclo=1;  aciclo<dErroresIndicacion.length; aciclo++){
      if (dErroresIndicacion[aciclo]>demax){
     demax=dErroresIndicacion[aciclo ];}
      }System.out.println("MD El error maximo es "+demax);

          demin=dErroresIndicacion[0];
                //se analizan los 9 erroresIndicacion para saber cual es el menor
      for(int aciclo=1;  aciclo<dErroresIndicacion.length; aciclo++){
      if (dErroresIndicacion[aciclo]<demin){
      demin=dErroresIndicacion[aciclo];}
      }System.out.println("MD El error minimo es "+demin);
            //diferenncia de el maximo y el minimo para error repetivilidad
      der=demax-demin;
      System.out.println("MD El error repetibilidad "+der);
            
//tiempototal
  double dttmax1,dttmax2,dttmax3,dttmed1,dttmed2,dttmed3,dttmin1,dttmin2,dttmin3;
double dtimax1,dtimax2,dtimax3,dtimed1,dtimed2,dtimed3,dtimin1,dtimin2,dtimin3;

     dtimax1= Double.parseDouble(this.DTIMAX1.getText());
     dtimax2= Double.parseDouble(this.DTIMAX2.getText());
     dtimax3= Double.parseDouble(this.DTIMAX3.getText());
     dtimed1= Double.parseDouble(this.DTIMED1.getText());
     dtimed2= Double.parseDouble(this.DTIMED2.getText());
     dtimed3= Double.parseDouble(this.DTIMED3.getText());
     dtimin1= Double.parseDouble(this.DTIMIN1.getText());
     dtimin2= Double.parseDouble(this.DTIMIN2.getText());
     dtimin3= Double.parseDouble(this.DTIMIN3.getText());
     
     if(dtimax1!=0 && dtimax2!=0 && dtimax3!=0 && dtimed1!=0 && dtimed2!=0 && dtimed3!=0 && dtimin1!=0 && dtimin2!=0 && dtimin3!=0){
     
    dttmax1=Math.round(((dtimax1/60)*4)*100.0)/100.0;
     dttmax2=Math.round(((dtimax2/60)*4)*100.0)/100.0;
     dttmax3=Math.round(((dtimax3/60)*4)*100.0)/100.0;
     dttmed1=Math.round(((dtimed1/60)*4)*100.0)/100.0;
     dttmed2=Math.round(((dtimed2/60)*4)*100.0)/100.0;
     dttmed3=Math.round(((dtimed3/60)*4)*100.0)/100.0;
     dttmin1=Math.round(((dtimin1/60)*4)*100.0)/100.0;
     dttmin2=Math.round(((dtimin2/60)*4)*100.0)/100.0;
     dttmin3=Math.round(((dtimin3/60)*4)*100.0)/100.0;
     
        System.out.println("TiempoTotal max p1 MD "+dttmax1);
        System.out.println("TiempoTotal max p2 MD "+dttmax2);
        System.out.println("TiempoTotal max p3 MD "+dttmax3);
        System.out.println("TiempoTotal med p1 MD "+dttmed1);
        System.out.println("TiempoTotal med p2 MD "+dttmed2);
        System.out.println("TiempoTotal med p3 MD "+dttmed3);
        System.out.println("TiempoTotal min p1 MD "+dttmin1);
        System.out.println("TiempoTotal min p2 MD "+dttmin2);
        System.out.println("TiempoTotal min p3 MD "+dttmin3);

//QV
double dqv1,dqv2,dqv3,dqv4,dqv5,dqv6,dqv7,dqv8,dqv9,dqvmax,dqvmed,dqvmin;

dqv1=dvcmv1/dttmax1;
dqv2=dvcmv2/dttmax2;
dqv3=dvcmv3/dttmax3;
dqv4=dvcmv4/dttmed1;
dqv5=dvcmv5/dttmed2;
dqv6=dvcmv6/dttmed3;
dqv7=dvcmv7/dttmin1;
dqv8=dvcmv8/dttmin2;
dqv9=dvcmv9/dttmin3;

dqvmax=Math.round(((dqv1+dqv2+dqv3)/3)*100.0)/100.0;
dqvmed=Math.round(((dqv4+dqv5+dqv6)/3)*100.0)/100.0;
dqvmin=Math.round(((dqv7+dqv8+dqv9)/3)*100.0)/100.0;

 System.out.println("QV 1 MD "+dqv1);
   System.out.println("QV 2 MD "+dqv2);
    System.out.println("QV 3 MD "+dqv3);
          System.out.println("QV 4 MD "+dqv4);
          System.out.println("QV 5 MD "+dqv5);
            System.out.println("QV 6 MD "+dqv6);
             System.out.println("QV 7 MD "+dqv7);
              System.out.println("QV 8 MD "+dqv8);
                System.out.println("QV 9 MD "+dqv9);

                  System.out.println("QV max MD "+dqvmax);
                System.out.println("QV med MD "+dqvmed);
                System.out.println("QV min MD "+dqvmin);
                
             DQVMAX.setText(String.valueOf(dqvmax));
            DQVMED.setText(String.valueOf(dqvmed));
            DQVMIN.setText(String.valueOf(dqvmin));
                
     }else {System.out.println("ADVERTENCIA TIEMPO TOTAL MD EN 0\n INGRESE UN VALOR VALIDO\n");}
        //------------------------------------------------------------------------------
               //MANGUERA E  
     double  ep1maxI,ep2maxI,ep3maxI,ep1medI,ep2medI,ep3medI,ep1minI,ep2minI,ep3minI, elcprommax,elcprommed,elcprommin;
//Prueba maximo
ep1maxI= Double.parseDouble(this.EP1MAX.getText());
      ep2maxI= Double.parseDouble(this.EP2MAX.getText());
       ep3maxI=Double.parseDouble(this.EP3MAX.getText());
    elcprommax=Math.round((  (ep1maxI+ep2maxI+ep3maxI)/3)*100.0)/100.0;
    //LC max
    ELCMAX.setText(String.valueOf(elcprommax));
    //Prueba medio
     ep1medI= Double.parseDouble(this.EP1MED.getText());
      ep2medI= Double.parseDouble(this.EP2MED.getText());
       ep3medI= Double.parseDouble(this.EP3MED.getText());
    elcprommed= Math.round(((ep1medI+ep2medI+ep3medI)/3)*100.0)/100.0;
        //LC med
    ELCMED.setText(String.valueOf(elcprommed));
    
        //Prueba minimo
     ep1minI= Double.parseDouble(this.EP1MIN.getText());
      ep2minI= Double.parseDouble(this.EP2MIN.getText());
       ep3minI= Double.parseDouble(this.EP3MIN.getText());
    elcprommin= Math.round(((ep1minI+ep2minI+ep3minI)/3)*100.0)/100.0;
        //LC min
    ELCMIN.setText(String.valueOf(elcprommin));
    
    
    //CTS
    double  ectsmaxp1,ectsmaxp2,ectsmaxp3,ectsmedp1,ectsmedp2,ectsmedp3,ectsminp1,ectsminp2,ectsminp3;
    double etmaxp1,etmaxp2,etmaxp3,etmedp1,etmedp2,etmedp3,etminp1,etminp2,etminp3;
    double ectsmaxprom,ectsmedprom,ectsminprom;

  etmaxp1=Double.parseDouble(this.ETMAXP1.getText());
    ectsmaxp1=1+(0.0000477)*(etmaxp1-20);
        etmaxp2=Double.parseDouble(this.ETMAXP2.getText());
    ectsmaxp2=1+(0.0000477)*(etmaxp2-20);
        etmaxp3=Double.parseDouble(this.ETMAXP3.getText());
    ectsmaxp3=1+(0.0000477)*(etmaxp3-20);
    
    ectsmaxprom=(ectsmaxp1+ectsmaxp2+ectsmaxp3)/3;
        System.out.println("CTS maximo promedio ME "+ectsmaxprom);
    
        etmedp1=Double.parseDouble(this.ETMEDP1.getText());
    ectsmedp1=1+(0.0000477)*(etmedp1-20);
        etmedp2=Double.parseDouble(this.ETMEDP2.getText());
    ectsmedp2=1+(0.0000477)*(etmedp2-20);
        etmedp3=Double.parseDouble(this.ETMEDP3.getText());
    ectsmedp3=1+(0.0000477)*(etmedp3-20);
    
        ectsmedprom=(ectsmedp1+ectsmedp2+ectsmedp3)/3;
            System.out.println("CTS medio promedio ME "+ectsmedprom);
            
        etminp1=Double.parseDouble(this.ETMINP1.getText());
    ectsminp1=1+(0.0000477)*(etminp1-20);
        etminp2=Double.parseDouble(this.ETMINP2.getText());
    ectsminp2=1+(0.0000477)*(etminp2-20);
        etminp3=Double.parseDouble(this.ETMINP3.getText());
    ectsminp3=1+(0.0000477)*(etminp3-20);
    
        ectsminprom=(ectsminp1+ectsminp2+ectsminp3)/3;
        System.out.println("CTS minimo promedio ME "+ectsminprom);
        
        //VCMV
        double  ev20,ekc ,evcmvmax,evcmvmed,evcmvmin;
        ev20=Double.parseDouble(this.EV20.getText());
        ekc=Double.parseDouble(this.EKC.getText());

        double evcmv1,evcmv2,evcmv3,evcmv4,evcmv5,evcmv6,evcmv7,evcmv8,evcmv9;
    //vcmv individual
evcmv1=Math.round((ev20+elcprommax*ekc*ectsmaxp1)*100.0)/100.0;
   System.out.println("VCMV maximo P1 ME "+evcmv1);  
 evcmv2=Math.round((ev20+elcprommax*ekc*ectsmaxp2)*100.0)/100.0;
   System.out.println("VCMV maximo P2 ME "+evcmv2);  
   evcmv3=Math.round((ev20+elcprommax*ekc*ectsmaxp3)*100.0)/100.0;
   System.out.println("VCMV maximo P3 ME "+evcmv3);  
    evcmv4=Math.round((ev20+elcprommed*ekc*ectsmedp1)*100.0)/100.0;
   System.out.println("VCMV medio P1 ME "+evcmv4);  
    evcmv5=Math.round((ev20+elcprommed*ekc*ectsmedp2)*100.0)/100.0;
   System.out.println("VCMV medio P2 ME "+evcmv5);  
    evcmv6=Math.round((ev20+elcprommed*ekc*ectsmedp3)*100.0)/100.0;
   System.out.println("VCMV medio P3 ME "+evcmv6);  
    evcmv7=Math.round((ev20+elcprommin*ekc*ectsminp1)*100.0)/100.0;
   System.out.println("VCMV minimo P1 ME "+evcmv7);  
    evcmv8=Math.round((ev20+elcprommin*ekc*ectsminp2)*100.0)/100.0;
   System.out.println("VCMV minimo P2 ME "+evcmv8);  
    evcmv9=Math.round((ev20+elcprommin*ekc*ectsminp3)*100.0)/100.0;
   System.out.println("VCMV minimo P3 ME "+evcmv9);  
   
   
//promedio max med y min
        evcmvmax=Math.round((ev20+elcprommax*ekc*ectsmaxprom)*100.0)/100.0;
        System.out.println("VCMV maximo promedio ME "+evcmvmax);
        evcmvmed=Math.round((ev20+elcprommed*ekc*ectsmedprom)*100.0)/100.0;
                System.out.println("VCMV medio promedio ME "+evcmvmed);
        evcmvmin=Math.round((ev20+elcprommin*ekc*ectsminprom)*100.0)/100.0;
                System.out.println("VCMV minimo promedio ME "+evcmvmin);
        
        
            EVCMVMAX.setText(String.valueOf(evcmvmax));
             EVCMVMED.setText(String.valueOf(evcmvmed));
             EVCMVMIN.setText(String.valueOf(evcmvmin));
             
                          //Error indicacion
//individual
double ee1,ee2,ee3,ee4,ee5,ee6,ee7,ee8,ee9,ei1,ei2,ei3,ei4,ei5,ei6,ei7,ei8,ei9;
 ei1=Double.parseDouble(this.EI1MAX.getText());    
 ee1=ei1-evcmv1;
System.out.println("ErrorIndicacion 1 ME "+ee1);
 ei2=Double.parseDouble(this.EI2MAX.getText());    
 ee2=ei2-evcmv2;
System.out.println("ErrorIndicacion 2 ME "+ee2);
 ei3=Double.parseDouble(this.EI3MAX.getText());    
 ee3=ei3-evcmv3;
System.out.println("ErrorIndicacion 3 ME "+ee3);
 ei4=Double.parseDouble(this.EI1MED.getText());    
 ee4=ei4-evcmv4;
System.out.println("ErrorIndicacion 4 ME "+ee4);
 ei5=Double.parseDouble(this.EI2MED.getText());    
 ee5=ei5-evcmv5;
System.out.println("ErrorIndicacion 5 ME "+ee5);
 ei6=Double.parseDouble(this.EI3MED.getText());    
 ee6=ei6-evcmv6;
System.out.println("ErrorIndicacion 6 ME "+ee6);
 ei7=Double.parseDouble(this.EI1MIN.getText());    
 ee7=ei7-evcmv7;
System.out.println("ErrorIndicacion 7 ME "+ee7);
 ei8=Double.parseDouble(this.EI2MIN.getText());    
 ee8=ei8-evcmv8;
System.out.println("ErrorIndicacion 8 ME "+ee8);
 ei9=Double.parseDouble(this.EI3MIN.getText());    
 ee9=ei9-evcmv9;
System.out.println("ErrorIndicacion 9 ME "+ee9);

//promedio
double eeprom1,eeprom2,eeprom3;
eeprom1=Math.round(((ee1+ee2+ee3)/3)*100.0)/100.0;
System.out.println("ErrorIndicacion prom 1 ME "+eeprom1);
eeprom2=Math.round(((ee4+ee5+ee6)/3)*100.0)/100.0;
System.out.println("ErrorIndicacion prom 2 ME "+eeprom2);
eeprom3=Math.round(((ee7+ee8+ee9)/3)*100.0)/100.0;
System.out.println("ErrorIndicacion prom 3 ME "+eeprom3);

  EEMAX.setText(String.valueOf(eeprom1));
    EEMED.setText(String.valueOf(eeprom2));
      EEMIN.setText(String.valueOf(eeprom3));
      
      
            //Error repetivilidad
      double eemax,eemin,eer;
      
      double [] eErroresIndicacion= new double[]{ee1,ee2,ee3 ,ee4,ee5,ee6,ee7,ee8,ee9};
       eemax=eErroresIndicacion[0];
         //se analizan los 9 erroresIndicacion para saber cual es el mayor
      for(int aciclo=1;  aciclo<eErroresIndicacion.length; aciclo++){
      if (eErroresIndicacion[aciclo]>eemax){
      eemax=eErroresIndicacion[aciclo ];}
      }System.out.println("ME El error maximo es "+eemax);

          eemin=eErroresIndicacion[0];
                //se analizan los 9 erroresIndicacion para saber cual es el menor
      for(int aciclo=1;  aciclo<eErroresIndicacion.length; aciclo++){
      if (eErroresIndicacion[aciclo]<eemin){
      eemin=eErroresIndicacion[aciclo];}
      }System.out.println("ME El error minimo es "+eemin);
            //diferenncia de el maximo y el minimo para error repetivilidad
      eer=eemax-eemin;
      System.out.println("ME El error repetibilidad "+eer);
      
            
//tiempototal
  double ettmax1,ettmax2,ettmax3,ettmed1,ettmed2,ettmed3,ettmin1,ettmin2,ettmin3;
double etimax1,etimax2,etimax3,etimed1,etimed2,etimed3,etimin1,etimin2,etimin3;

     etimax1= Double.parseDouble(this.ETIMAX1.getText());
     etimax2= Double.parseDouble(this.ETIMAX2.getText());
     etimax3= Double.parseDouble(this.ETIMAX3.getText());
     etimed1= Double.parseDouble(this.ETIMED1.getText());
     etimed2= Double.parseDouble(this.ETIMED2.getText());
     etimed3= Double.parseDouble(this.ETIMED3.getText());
     etimin1= Double.parseDouble(this.ETIMIN1.getText());
     etimin2= Double.parseDouble(this.ETIMIN2.getText());
     etimin3= Double.parseDouble(this.ETIMIN3.getText());
     
     if(etimax1!=0 && etimax2!=0 && etimax3!=0 && etimed1!=0 && etimed2!=0 && etimed3!=0 && etimin1!=0 && etimin2!=0 && etimin3!=0){
     
         ettmax1=Math.round(((etimax1/60)*4)*100.0)/100.0;
     ettmax2=Math.round(((etimax2/60)*4)*100.0)/100.0;
     ettmax3=Math.round(((etimax3/60)*4)*100.0)/100.0;
     ettmed1=Math.round(((etimed1/60)*4)*100.0)/100.0;
     ettmed2=Math.round(((etimed2/60)*4)*100.0)/100.0;
     ettmed3=Math.round(((etimed3/60)*4)*100.0)/100.0;
     ettmin1=Math.round(((etimin1/60)*4)*100.0)/100.0;
     ettmin2=Math.round(((etimin2/60)*4)*100.0)/100.0;
     ettmin3=Math.round(((etimin3/60)*4)*100.0)/100.0;
     
        System.out.println("TiempoTotal max p1 ME "+ettmax1);
        System.out.println("TiempoTotal max p2 ME "+ettmax2);
        System.out.println("TiempoTotal max p3 ME "+ettmax3);
        System.out.println("TiempoTotal med p1 ME "+ettmed1);
        System.out.println("TiempoTotal med p2 ME "+ettmed2);
        System.out.println("TiempoTotal med p3 ME "+ettmed3);
        System.out.println("TiempoTotal min p1 ME "+ettmin1);
        System.out.println("TiempoTotal min p2 ME "+ettmin2);
        System.out.println("TiempoTotal min p3 ME "+ettmin3);

//QV
double eqv1,eqv2,eqv3,eqv4,eqv5,eqv6,eqv7,eqv8,eqv9,eqvmax,eqvmed,eqvmin;

eqv1=evcmv1/ettmax1;
eqv2=evcmv2/ettmax2;
eqv3=evcmv3/ettmax3;
eqv4=evcmv4/ettmed1;
eqv5=evcmv5/ettmed2;
eqv6=evcmv6/ettmed3;
eqv7=evcmv7/ettmin1;
eqv8=evcmv8/ettmin2;
eqv9=evcmv9/ettmin3;

eqvmax=Math.round(((eqv1+eqv2+eqv3)/3)*100.0)/100.0;
eqvmed=Math.round(((eqv4+eqv5+eqv6)/3)*100.0)/100.0;
eqvmin=Math.round(((eqv7+eqv8+eqv9)/3)*100.0)/100.0;

 System.out.println("QV 1 ME "+eqv1);
   System.out.println("QV 2 ME "+eqv2);
    System.out.println("QV 3 ME "+eqv3);
          System.out.println("QV 4 ME "+eqv4);
          System.out.println("QV 5 ME "+eqv5);
            System.out.println("QV 6 ME "+eqv6);
             System.out.println("QV 7 ME "+eqv7);
              System.out.println("QV 8 ME "+eqv8);
                System.out.println("QV 9 ME "+eqv9);

                  System.out.println("QV max ME "+eqvmax);
                System.out.println("QV med ME "+eqvmed);
                System.out.println("QV min ME "+eqvmin);
                
             EQVMAX.setText(String.valueOf(eqvmax));
            EQVMED.setText(String.valueOf(eqvmed));
            EQVMIN.setText(String.valueOf(eqvmin));
                
     }else {System.out.println("ADVERTENCIA TIEMPO TOTAL ME EN 0\n INGRESE UN VALOR VALIDO\n");}
    //------------------------------------------------------------------------------
                   //MANGUERA F  
     double  fp1maxI,fp2maxI,fp3maxI,fp1medI,fp2medI,fp3medI,fp1minI,fp2minI,fp3minI, flcprommax,flcprommed,flcprommin;
//Prueba maximo
fp1maxI= Double.parseDouble(this.FP1MAX.getText());
      fp2maxI= Double.parseDouble(this.FP2MAX.getText());
       fp3maxI=Double.parseDouble(this.FP3MAX.getText());
    flcprommax=Math.round((  (fp1maxI+fp2maxI+fp3maxI)/3)*100.0)/100.0;
    //LC max
    FLCMAX.setText(String.valueOf(flcprommax));
    //Prueba medio
     fp1medI= Double.parseDouble(this.FP1MED.getText());
      fp2medI= Double.parseDouble(this.FP2MED.getText());
       fp3medI= Double.parseDouble(this.FP3MED.getText());
    flcprommed= Math.round(((fp1medI+fp2medI+fp3medI)/3)*100.0)/100.0;
        //LC med
    FLCMED.setText(String.valueOf(flcprommed));
    
        //Prueba minimo
     fp1minI= Double.parseDouble(this.FP1MIN.getText());
      fp2minI= Double.parseDouble(this.FP2MIN.getText());
       fp3minI= Double.parseDouble(this.FP3MIN.getText());
    flcprommin= Math.round(((fp1minI+fp2minI+fp3minI)/3)*100.0)/100.0;
        //LC min
    FLCMIN.setText(String.valueOf(flcprommin));
    
    
    //CTS
    double  fctsmaxp1,fctsmaxp2,fctsmaxp3,fctsmedp1,fctsmedp2,fctsmedp3,fctsminp1,fctsminp2,fctsminp3;
    double ftmaxp1,ftmaxp2,ftmaxp3,ftmedp1,ftmedp2,ftmedp3,ftminp1,ftminp2,ftminp3;
    double fctsmaxprom,fctsmedprom,fctsminprom;

  ftmaxp1=Double.parseDouble(this.FTMAXP1.getText());
    fctsmaxp1=1+(0.0000477)*(ftmaxp1-20);
        ftmaxp2=Double.parseDouble(this.FTMAXP2.getText());
    fctsmaxp2=1+(0.0000477)*(ftmaxp2-20);
        ftmaxp3=Double.parseDouble(this.FTMAXP3.getText());
    fctsmaxp3=1+(0.0000477)*(ftmaxp3-20);
    
    fctsmaxprom=(fctsmaxp1+fctsmaxp2+fctsmaxp3)/3;
        System.out.println("CTS maximo promedio MF "+fctsmaxprom);
    
        ftmedp1=Double.parseDouble(this.FTMEDP1.getText());
    fctsmedp1=1+(0.0000477)*(ftmedp1-20);
        ftmedp2=Double.parseDouble(this.FTMEDP2.getText());
    fctsmedp2=1+(0.0000477)*(ftmedp2-20);
        ftmedp3=Double.parseDouble(this.FTMEDP3.getText());
    fctsmedp3=1+(0.0000477)*(ftmedp3-20);
    
        fctsmedprom=(fctsmedp1+fctsmedp2+fctsmedp3)/3;
            System.out.println("CTS medio promedio MF "+fctsmedprom);
            
        ftminp1=Double.parseDouble(this.FTMINP1.getText());
    fctsminp1=1+(0.0000477)*(ftminp1-20);
        ftminp2=Double.parseDouble(this.FTMINP2.getText());
    fctsminp2=1+(0.0000477)*(ftminp2-20);
        ftminp3=Double.parseDouble(this.FTMINP3.getText());
    fctsminp3=1+(0.0000477)*(ftminp3-20);
    
        fctsminprom=(fctsminp1+fctsminp2+fctsminp3)/3;
        System.out.println("CTS minimo promedio MF "+fctsminprom);
        
        //VCMV
        double  fv20,fkc ,fvcmvmax,fvcmvmed,fvcmvmin;
        fv20=Double.parseDouble(this.FV20.getText());
        fkc=Double.parseDouble(this.FKC.getText());

        double fvcmv1,fvcmv2,fvcmv3,fvcmv4,fvcmv5,fvcmv6,fvcmv7,fvcmv8,fvcmv9;
    //vcmv individual
fvcmv1=Math.round((fv20+flcprommax*fkc*fctsmaxp1)*100.0)/100.0;
   System.out.println("VCMV maximo P1 MF "+fvcmv1);  
 fvcmv2=Math.round((fv20+flcprommax*fkc*fctsmaxp2)*100.0)/100.0;
   System.out.println("VCMV maximo P2 MF "+fvcmv2);  
   fvcmv3=Math.round((fv20+flcprommax*fkc*fctsmaxp3)*100.0)/100.0;
   System.out.println("VCMV maximo P3 MF "+fvcmv3);  
    fvcmv4=Math.round((fv20+flcprommed*fkc*fctsmedp1)*100.0)/100.0;
   System.out.println("VCMV medio P1 MF "+fvcmv4);  
    fvcmv5=Math.round((fv20+flcprommed*fkc*fctsmedp2)*100.0)/100.0;
   System.out.println("VCMV medio P2 MF "+fvcmv5);  
    fvcmv6=Math.round((fv20+flcprommed*fkc*fctsmedp3)*100.0)/100.0;
   System.out.println("VCMV medio P3 MF "+fvcmv6);  
    fvcmv7=Math.round((fv20+flcprommin*fkc*fctsminp1)*100.0)/100.0;
   System.out.println("VCMV minimo P1 MF "+fvcmv7);  
    fvcmv8=Math.round((fv20+flcprommin*fkc*fctsminp2)*100.0)/100.0;
   System.out.println("VCMV minimo P2 MF "+fvcmv8);  
    fvcmv9=Math.round((fv20+flcprommin*fkc*fctsminp3)*100.0)/100.0;
   System.out.println("VCMV minimo P3 MF "+fvcmv9);  
   
   
//promedio max med y min
        
        fvcmvmax=Math.round((fv20+flcprommax*fkc*fctsmaxprom)*100.0)/100.0;
        System.out.println("VCMV maximo promedio MF "+fvcmvmax);
        fvcmvmed=Math.round((fv20+flcprommed*fkc*fctsmedprom)*100.0)/100.0;
                System.out.println("VCMV medio promedio MF "+fvcmvmed);
        fvcmvmin=Math.round((fv20+flcprommin*fkc*fctsminprom)*100.0)/100.0;
                System.out.println("VCMV minimo promedio MF "+fvcmvmin);
        
        
            FVCMVMAX.setText(String.valueOf(fvcmvmax));
             FVCMVMED.setText(String.valueOf(fvcmvmed));
             FVCMVMIN.setText(String.valueOf(fvcmvmin));
              
                          //Error indicacion
//individual
double fe1,fe2,fe3,fe4,fe5,fe6,fe7,fe8,fe9,fi1,fi2,fi3,fi4,fi5,fi6,fi7,fi8,fi9;
 fi1=Double.parseDouble(this.FI1MAX.getText());    
 fe1=fi1-fvcmv1;
System.out.println("ErrorIndicacion 1 MF "+fe1);
 fi2=Double.parseDouble(this.FI2MAX.getText());    
 fe2=fi2-fvcmv2;
System.out.println("ErrorIndicacion 2 MF "+fe2);
 fi3=Double.parseDouble(this.FI3MAX.getText());    
 fe3=fi3-fvcmv3;
System.out.println("ErrorIndicacion 3 MF "+fe3);
 fi4=Double.parseDouble(this.FI1MED.getText());    
 fe4=fi4-fvcmv4;
System.out.println("ErrorIndicacion 4 MF "+fe4);
 fi5=Double.parseDouble(this.FI2MED.getText());    
 fe5=fi5-fvcmv5;
System.out.println("ErrorIndicacion 5 MF "+fe5);
 fi6=Double.parseDouble(this.FI3MED.getText());    
 fe6=fi6-fvcmv6;
System.out.println("ErrorIndicacion 6 MF "+fe6);
 fi7=Double.parseDouble(this.FI1MIN.getText());    
 fe7=fi7-fvcmv7;
System.out.println("ErrorIndicacion 7 MF "+fe7);
 fi8=Double.parseDouble(this.FI2MIN.getText());    
 fe8=fi8-fvcmv8;
System.out.println("ErrorIndicacion 8 MF "+fe8);
 fi9=Double.parseDouble(this.FI3MIN.getText());    
 fe9=fi9-fvcmv9;
System.out.println("ErrorIndicacion 9 MF "+fe9);

//promedio
double feprom1,feprom2,feprom3;
feprom1=Math.round(((fe1+fe2+fe3)/3)*100.0)/100.0;
System.out.println("ErrorIndicacion prom 1 MF "+feprom1);
feprom2=Math.round(((fe4+fe5+fe6)/3)*100.0)/100.0;
System.out.println("ErrorIndicacion prom 2 MF "+feprom2);
feprom3=Math.round(((fe7+fe8+fe9)/3)*100.0)/100.0;
System.out.println("ErrorIndicacion prom 3 MF "+feprom3);

  FEMAX.setText(String.valueOf(feprom1));
    FEMED.setText(String.valueOf(feprom2));
      FEMIN.setText(String.valueOf(feprom3));
             
            //Error repetivilidad
      double femax,femin,fer;
      
      double [] fErroresIndicacion= new double[]{fe1,fe2,fe3 ,fe4,fe5,fe6,fe7,fe8,fe9};
       femax=fErroresIndicacion[0];
         //se analizan los 9 erroresIndicacion para saber cual es el mayor
      for(int aciclo=1;  aciclo<fErroresIndicacion.length; aciclo++){
      if (fErroresIndicacion[aciclo]>femax){
      femax=fErroresIndicacion[aciclo ];}
      }System.out.println("MF El error maximo es "+femax);

          femin=fErroresIndicacion[0];
                //se analizan los 9 erroresIndicacion para saber cual es el menor
      for(int aciclo=1;  aciclo<fErroresIndicacion.length; aciclo++){
      if (fErroresIndicacion[aciclo]<femin){
      femin=fErroresIndicacion[aciclo];}
      }System.out.println("MF El error minimo es "+femin);
            //diferenncia de el maximo y el minimo para error repetivilidad
      fer=femax-femin;
      System.out.println("MF El error repetibilidad "+fer);
      
            
//tiempototal
  double fttmax1,fttmax2,fttmax3,fttmed1,fttmed2,fttmed3,fttmin1,fttmin2,fttmin3;
double ftimax1,ftimax2,ftimax3,ftimed1,ftimed2,ftimed3,ftimin1,ftimin2,ftimin3;

     ftimax1= Double.parseDouble(this.FTIMAX1.getText());
     ftimax2= Double.parseDouble(this.FTIMAX2.getText());
     ftimax3= Double.parseDouble(this.FTIMAX3.getText());
     ftimed1= Double.parseDouble(this.FTIMED1.getText());
     ftimed2= Double.parseDouble(this.FTIMED2.getText());
     ftimed3= Double.parseDouble(this.FTIMED3.getText());
     ftimin1= Double.parseDouble(this.FTIMIN1.getText());
     ftimin2= Double.parseDouble(this.FTIMIN2.getText());
     ftimin3= Double.parseDouble(this.FTIMIN3.getText());
     
     if(atimax1!=0 && atimax2!=0 && atimax3!=0 && atimed1!=0 && atimed2!=0 && atimed3!=0 && atimin1!=0 && atimin2!=0 && atimin3!=0){
     
         fttmax1=Math.round(((ftimax1/60)*4)*100.0)/100.0;
     fttmax2=Math.round(((ftimax2/60)*4)*100.0)/100.0;
     fttmax3=Math.round(((ftimax3/60)*4)*100.0)/100.0;
     fttmed1=Math.round(((ftimed1/60)*4)*100.0)/100.0;
     fttmed2=Math.round(((ftimed2/60)*4)*100.0)/100.0;
     fttmed3=Math.round(((ftimed3/60)*4)*100.0)/100.0;
     fttmin1=Math.round(((ftimin1/60)*4)*100.0)/100.0;
     fttmin2=Math.round(((ftimin2/60)*4)*100.0)/100.0;
     fttmin3=Math.round(((ftimin3/60)*4)*100.0)/100.0;
     
        System.out.println("TiempoTotal max p1 MF "+fttmax1);
        System.out.println("TiempoTotal max p2 MF "+fttmax2);
        System.out.println("TiempoTotal max p3 MF "+fttmax3);
        System.out.println("TiempoTotal med p1 MF "+fttmed1);
        System.out.println("TiempoTotal med p2 MF "+fttmed2);
        System.out.println("TiempoTotal med p3 MF "+fttmed3);
        System.out.println("TiempoTotal min p1 MF "+fttmin1);
        System.out.println("TiempoTotal min p2 MF "+fttmin2);
        System.out.println("TiempoTotal min p3 MF "+fttmin3);

//QV
double fqv1,fqv2,fqv3,fqv4,fqv5,fqv6,fqv7,fqv8,fqv9,fqvmax,fqvmed,fqvmin;

fqv1=fvcmv1/fttmax1;
fqv2=fvcmv2/fttmax2;
fqv3=fvcmv3/fttmax3;
fqv4=fvcmv4/fttmed1;
fqv5=fvcmv5/fttmed2;
fqv6=fvcmv6/fttmed3;
fqv7=fvcmv7/fttmin1;
fqv8=fvcmv8/fttmin2;
fqv9=fvcmv9/fttmin3;

fqvmax=Math.round(((fqv1+fqv2+fqv3)/3)*100.0)/100.0;
fqvmed=Math.round(((fqv4+fqv5+fqv6)/3)*100.0)/100.0;
fqvmin=Math.round(((fqv7+fqv8+fqv9)/3)*100.0)/100.0;

 System.out.println("QV 1 MF "+fqv1);
   System.out.println("QV 2 MF "+fqv2);
    System.out.println("QV 3 MF "+fqv3);
          System.out.println("QV 4 MF "+fqv4);
          System.out.println("QV 5 MF "+fqv5);
            System.out.println("QV 6 MF "+fqv6);
             System.out.println("QV 7 MF "+fqv7);
              System.out.println("QV 8 MF "+fqv8);
                System.out.println("QV 9 MF "+fqv9);

                  System.out.println("QV max MF "+fqvmax);
                System.out.println("QV med MF "+fqvmed);
                System.out.println("QV min MF "+fqvmin);
                
             FQVMAX.setText(String.valueOf(fqvmax));
            FQVMED.setText(String.valueOf(fqvmed));
            FQVMIN.setText(String.valueOf(fqvmin));
                
     }else {System.out.println("ADVERTENCIA TIEMPO TOTAL MF EN 0\n INGRESE UN VALOR VALIDO\n");}
      
      
             System.out.println("+==++==++==++==++==++==++==++==++==++==++==++==+++==++==+");

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
        campoInformacionEstacion = new javax.swing.JTextField();
        jComboBoxCronometro = new javax.swing.JComboBox<String>();
        jComboBoxDispensarios = new javax.swing.JComboBox<String>();
        jComboBoxTermometro = new javax.swing.JComboBox<String>();
        campoTipoVerificacion = new javax.swing.JTextField();
        datosTermometro = new javax.swing.JTextField();
        datosCronometro = new javax.swing.JTextField();
        jDateChooserFechaIM = new com.toedter.calendar.JDateChooser();
        btnGuardarExcel = new javax.swing.JButton();
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
        ATIMED1 = new javax.swing.JTextField();
        ATIMAX1 = new javax.swing.JTextField();
        ATIMIN1 = new javax.swing.JTextField();
        ATIMAX2 = new javax.swing.JTextField();
        ATIMED2 = new javax.swing.JTextField();
        ATIMIN2 = new javax.swing.JTextField();
        ATIMIN3 = new javax.swing.JTextField();
        ATIMED3 = new javax.swing.JTextField();
        ATIMAX3 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        AI1MAX = new javax.swing.JTextField();
        AI2MAX = new javax.swing.JTextField();
        AI3MAX = new javax.swing.JTextField();
        AI4MAX = new javax.swing.JTextField();
        AI4MED = new javax.swing.JTextField();
        AI4MIN = new javax.swing.JTextField();
        AI3MIN = new javax.swing.JTextField();
        AI3MED = new javax.swing.JTextField();
        AI2MED = new javax.swing.JTextField();
        AI2MIN = new javax.swing.JTextField();
        AI1MIN = new javax.swing.JTextField();
        AI1MED = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        FechaCal_A = new javax.swing.JTextField();
        InfCal_A = new javax.swing.JTextField();
        AV20 = new javax.swing.JTextField();
        AKC = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jComboBoxJarraA = new javax.swing.JComboBox<String>();
        avisoLabelA = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        etiquetaIncluir = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jTextField64 = new javax.swing.JTextField();
        jTextField67 = new javax.swing.JTextField();
        jTextField68 = new javax.swing.JTextField();
        jTextField69 = new javax.swing.JTextField();
        jLabel328 = new javax.swing.JLabel();
        campoPrecintoA = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        AVCMVMIN = new javax.swing.JTextField();
        AVCMVMED = new javax.swing.JTextField();
        AVCMVMAX = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        AQVMAX = new javax.swing.JTextField();
        AEMAX = new javax.swing.JTextField();
        AEMED = new javax.swing.JTextField();
        AQVMED = new javax.swing.JTextField();
        AQVMIN = new javax.swing.JTextField();
        AEMIN = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jTextField65 = new javax.swing.JTextField();
        jTextField66 = new javax.swing.JTextField();
        botonIncluirMA = new javax.swing.JButton();
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
        BTIMED1 = new javax.swing.JTextField();
        BTIMAX1 = new javax.swing.JTextField();
        BTIMIN1 = new javax.swing.JTextField();
        BTIMAX2 = new javax.swing.JTextField();
        BTIMED2 = new javax.swing.JTextField();
        BTIMIN2 = new javax.swing.JTextField();
        BTIMIN3 = new javax.swing.JTextField();
        BTIMED3 = new javax.swing.JTextField();
        BTIMAX3 = new javax.swing.JTextField();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        BI1MAX = new javax.swing.JTextField();
        BI2MAX = new javax.swing.JTextField();
        BI3MAX = new javax.swing.JTextField();
        BI4MAX = new javax.swing.JTextField();
        BI4MED = new javax.swing.JTextField();
        BI4MIN = new javax.swing.JTextField();
        BI3MIN = new javax.swing.JTextField();
        BI3MED = new javax.swing.JTextField();
        BI2MED = new javax.swing.JTextField();
        BI2MIN = new javax.swing.JTextField();
        BI1MIN = new javax.swing.JTextField();
        BI1MED = new javax.swing.JTextField();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel107 = new javax.swing.JLabel();
        FechaCal_B = new javax.swing.JTextField();
        InfCal_B = new javax.swing.JTextField();
        BV20 = new javax.swing.JTextField();
        BKC = new javax.swing.JTextField();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jComboBoxJarraB = new javax.swing.JComboBox<String>();
        avisoLabelB = new javax.swing.JLabel();
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
        campoPrecintoB = new javax.swing.JTextField();
        jLabel329 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        BVCMVMIN = new javax.swing.JTextField();
        BVCMVMED = new javax.swing.JTextField();
        BVCMVMAX = new javax.swing.JTextField();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        BQVMAX = new javax.swing.JTextField();
        BEMAX = new javax.swing.JTextField();
        BEMED = new javax.swing.JTextField();
        BQVMED = new javax.swing.JTextField();
        BQVMIN = new javax.swing.JTextField();
        BEMIN = new javax.swing.JTextField();
        jLabel121 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jTextField132 = new javax.swing.JTextField();
        jTextField133 = new javax.swing.JTextField();
        botonIncluirMB = new javax.swing.JButton();
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
        CTIMED1 = new javax.swing.JTextField();
        CTIMAX1 = new javax.swing.JTextField();
        CTIMIN1 = new javax.swing.JTextField();
        CTIMAX2 = new javax.swing.JTextField();
        CTIMED2 = new javax.swing.JTextField();
        CTIMIN2 = new javax.swing.JTextField();
        CTIMIN3 = new javax.swing.JTextField();
        CTIMED3 = new javax.swing.JTextField();
        CTIMAX3 = new javax.swing.JTextField();
        jLabel147 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        jLabel149 = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        jLabel151 = new javax.swing.JLabel();
        jLabel152 = new javax.swing.JLabel();
        jLabel153 = new javax.swing.JLabel();
        CI1MAX = new javax.swing.JTextField();
        CI2MAX = new javax.swing.JTextField();
        CI3MAX = new javax.swing.JTextField();
        CI4MAX = new javax.swing.JTextField();
        CI4MED = new javax.swing.JTextField();
        CI4MIN = new javax.swing.JTextField();
        CI3MIN = new javax.swing.JTextField();
        CI3MED = new javax.swing.JTextField();
        CI2MED = new javax.swing.JTextField();
        CI2MIN = new javax.swing.JTextField();
        CI1MIN = new javax.swing.JTextField();
        CI1MED = new javax.swing.JTextField();
        jLabel154 = new javax.swing.JLabel();
        jLabel155 = new javax.swing.JLabel();
        jLabel156 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel157 = new javax.swing.JLabel();
        FechaCal_C = new javax.swing.JTextField();
        InfCal_C = new javax.swing.JTextField();
        CV20 = new javax.swing.JTextField();
        CKC = new javax.swing.JTextField();
        jLabel158 = new javax.swing.JLabel();
        jLabel159 = new javax.swing.JLabel();
        jLabel160 = new javax.swing.JLabel();
        jLabel161 = new javax.swing.JLabel();
        jLabel162 = new javax.swing.JLabel();
        jComboBoxJarraC = new javax.swing.JComboBox<String>();
        avisoLabelC = new javax.swing.JLabel();
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
        campoPrecintoC = new javax.swing.JTextField();
        jLabel330 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        CVCMVMIN = new javax.swing.JTextField();
        CVCMVMED = new javax.swing.JTextField();
        CVCMVMAX = new javax.swing.JTextField();
        jLabel168 = new javax.swing.JLabel();
        jLabel169 = new javax.swing.JLabel();
        jLabel170 = new javax.swing.JLabel();
        CQVMAX = new javax.swing.JTextField();
        CEMAX = new javax.swing.JTextField();
        CEMED = new javax.swing.JTextField();
        CQVMED = new javax.swing.JTextField();
        CQVMIN = new javax.swing.JTextField();
        CEMIN = new javax.swing.JTextField();
        jLabel171 = new javax.swing.JLabel();
        jLabel172 = new javax.swing.JLabel();
        jLabel173 = new javax.swing.JLabel();
        jLabel174 = new javax.swing.JLabel();
        jLabel175 = new javax.swing.JLabel();
        jLabel176 = new javax.swing.JLabel();
        jLabel177 = new javax.swing.JLabel();
        jTextField196 = new javax.swing.JTextField();
        jTextField197 = new javax.swing.JTextField();
        botonIncluirMC = new javax.swing.JButton();
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
        DTIMED1 = new javax.swing.JTextField();
        DTIMAX1 = new javax.swing.JTextField();
        DTIMIN1 = new javax.swing.JTextField();
        DTIMAX2 = new javax.swing.JTextField();
        DTIMED2 = new javax.swing.JTextField();
        DTIMIN2 = new javax.swing.JTextField();
        DTIMIN3 = new javax.swing.JTextField();
        DTIMED3 = new javax.swing.JTextField();
        DTIMAX3 = new javax.swing.JTextField();
        jLabel197 = new javax.swing.JLabel();
        jLabel198 = new javax.swing.JLabel();
        jLabel199 = new javax.swing.JLabel();
        jLabel200 = new javax.swing.JLabel();
        jLabel201 = new javax.swing.JLabel();
        jLabel202 = new javax.swing.JLabel();
        jLabel203 = new javax.swing.JLabel();
        DI1MAX = new javax.swing.JTextField();
        DI2MAX = new javax.swing.JTextField();
        DI3MAX = new javax.swing.JTextField();
        DI4MAX = new javax.swing.JTextField();
        DI4MED = new javax.swing.JTextField();
        DI4MIN = new javax.swing.JTextField();
        DI3MIN = new javax.swing.JTextField();
        DI3MED = new javax.swing.JTextField();
        DI2MED = new javax.swing.JTextField();
        DI2MIN = new javax.swing.JTextField();
        DI1MIN = new javax.swing.JTextField();
        DI1MED = new javax.swing.JTextField();
        jLabel204 = new javax.swing.JLabel();
        jLabel205 = new javax.swing.JLabel();
        jLabel206 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jLabel207 = new javax.swing.JLabel();
        FechaCal_D = new javax.swing.JTextField();
        InfCal_D = new javax.swing.JTextField();
        DV20 = new javax.swing.JTextField();
        DKC = new javax.swing.JTextField();
        jLabel208 = new javax.swing.JLabel();
        jLabel209 = new javax.swing.JLabel();
        jLabel210 = new javax.swing.JLabel();
        jLabel211 = new javax.swing.JLabel();
        jLabel212 = new javax.swing.JLabel();
        jComboBoxJarraD = new javax.swing.JComboBox<String>();
        avisoLabelD = new javax.swing.JLabel();
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
        campoPrecintoD = new javax.swing.JTextField();
        jLabel331 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        DVCMVMIN = new javax.swing.JTextField();
        DVCMVMED = new javax.swing.JTextField();
        DVCMVMAX = new javax.swing.JTextField();
        jLabel218 = new javax.swing.JLabel();
        jLabel219 = new javax.swing.JLabel();
        jLabel220 = new javax.swing.JLabel();
        DQVMAX = new javax.swing.JTextField();
        DEMAX = new javax.swing.JTextField();
        DEMED = new javax.swing.JTextField();
        DQVMED = new javax.swing.JTextField();
        DQVMIN = new javax.swing.JTextField();
        DEMIN = new javax.swing.JTextField();
        jLabel221 = new javax.swing.JLabel();
        jLabel222 = new javax.swing.JLabel();
        jLabel223 = new javax.swing.JLabel();
        jLabel224 = new javax.swing.JLabel();
        jLabel225 = new javax.swing.JLabel();
        jLabel226 = new javax.swing.JLabel();
        jLabel227 = new javax.swing.JLabel();
        jTextField260 = new javax.swing.JTextField();
        jTextField261 = new javax.swing.JTextField();
        botonIncluirMD = new javax.swing.JButton();
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
        ETIMED1 = new javax.swing.JTextField();
        ETIMAX1 = new javax.swing.JTextField();
        ETIMIN1 = new javax.swing.JTextField();
        ETIMAX2 = new javax.swing.JTextField();
        ETIMED2 = new javax.swing.JTextField();
        ETIMIN2 = new javax.swing.JTextField();
        ETIMIN3 = new javax.swing.JTextField();
        ETIMED3 = new javax.swing.JTextField();
        ETIMAX3 = new javax.swing.JTextField();
        jLabel247 = new javax.swing.JLabel();
        jLabel248 = new javax.swing.JLabel();
        jLabel249 = new javax.swing.JLabel();
        jLabel250 = new javax.swing.JLabel();
        jLabel251 = new javax.swing.JLabel();
        jLabel252 = new javax.swing.JLabel();
        jLabel253 = new javax.swing.JLabel();
        EI1MAX = new javax.swing.JTextField();
        EI2MAX = new javax.swing.JTextField();
        EI3MAX = new javax.swing.JTextField();
        EI4MAX = new javax.swing.JTextField();
        EI4MED = new javax.swing.JTextField();
        EI4MIN = new javax.swing.JTextField();
        EI3MIN = new javax.swing.JTextField();
        EI3MED = new javax.swing.JTextField();
        EI2MED = new javax.swing.JTextField();
        EI2MIN = new javax.swing.JTextField();
        EI1MIN = new javax.swing.JTextField();
        EI1MED = new javax.swing.JTextField();
        jLabel254 = new javax.swing.JLabel();
        jLabel255 = new javax.swing.JLabel();
        jLabel256 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jLabel257 = new javax.swing.JLabel();
        FechaCal_E = new javax.swing.JTextField();
        InfCal_E = new javax.swing.JTextField();
        EV20 = new javax.swing.JTextField();
        EKC = new javax.swing.JTextField();
        jLabel258 = new javax.swing.JLabel();
        jLabel259 = new javax.swing.JLabel();
        jLabel260 = new javax.swing.JLabel();
        jLabel261 = new javax.swing.JLabel();
        jLabel262 = new javax.swing.JLabel();
        jComboBoxJarraE = new javax.swing.JComboBox<String>();
        avisoLabelE = new javax.swing.JLabel();
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
        campoPrecintoE = new javax.swing.JTextField();
        jLabel333 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        EVCMVMIN = new javax.swing.JTextField();
        EVCMVMED = new javax.swing.JTextField();
        EVCMVMAX = new javax.swing.JTextField();
        jLabel268 = new javax.swing.JLabel();
        jLabel269 = new javax.swing.JLabel();
        jLabel270 = new javax.swing.JLabel();
        EQVMAX = new javax.swing.JTextField();
        EEMAX = new javax.swing.JTextField();
        EEMED = new javax.swing.JTextField();
        EQVMED = new javax.swing.JTextField();
        EQVMIN = new javax.swing.JTextField();
        EEMIN = new javax.swing.JTextField();
        jLabel271 = new javax.swing.JLabel();
        jLabel272 = new javax.swing.JLabel();
        jLabel273 = new javax.swing.JLabel();
        jLabel274 = new javax.swing.JLabel();
        jLabel275 = new javax.swing.JLabel();
        jLabel276 = new javax.swing.JLabel();
        jLabel277 = new javax.swing.JLabel();
        jTextField324 = new javax.swing.JTextField();
        jTextField325 = new javax.swing.JTextField();
        botonIncluirME = new javax.swing.JButton();
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
        FTIMED1 = new javax.swing.JTextField();
        FTIMAX1 = new javax.swing.JTextField();
        FTIMIN1 = new javax.swing.JTextField();
        FTIMAX2 = new javax.swing.JTextField();
        FTIMED2 = new javax.swing.JTextField();
        FTIMIN2 = new javax.swing.JTextField();
        FTIMIN3 = new javax.swing.JTextField();
        FTIMED3 = new javax.swing.JTextField();
        FTIMAX3 = new javax.swing.JTextField();
        jLabel297 = new javax.swing.JLabel();
        jLabel298 = new javax.swing.JLabel();
        jLabel299 = new javax.swing.JLabel();
        jLabel300 = new javax.swing.JLabel();
        jLabel301 = new javax.swing.JLabel();
        jLabel302 = new javax.swing.JLabel();
        jLabel303 = new javax.swing.JLabel();
        FI1MAX = new javax.swing.JTextField();
        FI2MAX = new javax.swing.JTextField();
        FI3MAX = new javax.swing.JTextField();
        FI4MAX = new javax.swing.JTextField();
        FI4MED = new javax.swing.JTextField();
        FI4MIN = new javax.swing.JTextField();
        FI3MIN = new javax.swing.JTextField();
        FI3MED = new javax.swing.JTextField();
        FI2MED = new javax.swing.JTextField();
        FI2MIN = new javax.swing.JTextField();
        FI1MIN = new javax.swing.JTextField();
        FI1MED = new javax.swing.JTextField();
        jLabel304 = new javax.swing.JLabel();
        jLabel305 = new javax.swing.JLabel();
        jLabel306 = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        jLabel307 = new javax.swing.JLabel();
        FechaCal_F = new javax.swing.JTextField();
        InfCal_F = new javax.swing.JTextField();
        FV20 = new javax.swing.JTextField();
        FKC = new javax.swing.JTextField();
        jLabel308 = new javax.swing.JLabel();
        jLabel309 = new javax.swing.JLabel();
        jLabel310 = new javax.swing.JLabel();
        jLabel311 = new javax.swing.JLabel();
        jLabel312 = new javax.swing.JLabel();
        jComboBoxJarraF = new javax.swing.JComboBox<String>();
        avisoLabelF = new javax.swing.JLabel();
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
        campoPrecintoF = new javax.swing.JTextField();
        jLabel332 = new javax.swing.JLabel();
        jPanel40 = new javax.swing.JPanel();
        FVCMVMIN = new javax.swing.JTextField();
        FVCMVMED = new javax.swing.JTextField();
        FVCMVMAX = new javax.swing.JTextField();
        jLabel318 = new javax.swing.JLabel();
        jLabel319 = new javax.swing.JLabel();
        jLabel320 = new javax.swing.JLabel();
        FQVMAX = new javax.swing.JTextField();
        FEMAX = new javax.swing.JTextField();
        FEMED = new javax.swing.JTextField();
        FQVMED = new javax.swing.JTextField();
        FQVMIN = new javax.swing.JTextField();
        FEMIN = new javax.swing.JTextField();
        jLabel321 = new javax.swing.JLabel();
        jLabel322 = new javax.swing.JLabel();
        jLabel323 = new javax.swing.JLabel();
        jLabel324 = new javax.swing.JLabel();
        jLabel325 = new javax.swing.JLabel();
        jLabel326 = new javax.swing.JLabel();
        jLabel327 = new javax.swing.JLabel();
        jTextField388 = new javax.swing.JTextField();
        jTextField389 = new javax.swing.JTextField();
        botonIncluirMF = new javax.swing.JButton();

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
        jComboBoxTermometro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTermometroActionPerformed(evt);
            }
        });

        datosTermometro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datosTermometroActionPerformed(evt);
            }
        });

        jDateChooserFechaIM.setEnabled(false);

        btnGuardarExcel.setText("Guardar");
        btnGuardarExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarExcelActionPerformed(evt);
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
                                    .addComponent(campoTipoVerificacion)))
                            .addComponent(campoInformacionEstacion)
                            .addComponent(datosTermometro, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(datosCronometro, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCheckBoxImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardarExcel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                            .addComponent(campoInformacionEstacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxDispensarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel8)
                                    .addComponent(campoTipoVerificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(btnGuardarExcel))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 583, Short.MAX_VALUE)
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

        ATIMED1.setText("1");
        ATIMED1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ATIMED1FocusLost(evt);
            }
        });

        ATIMAX1.setText("1");
        ATIMAX1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ATIMAX1FocusLost(evt);
            }
        });

        ATIMIN1.setText("1");
        ATIMIN1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ATIMIN1FocusLost(evt);
            }
        });

        ATIMAX2.setText("1");
        ATIMAX2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ATIMAX2FocusLost(evt);
            }
        });

        ATIMED2.setText("1");
        ATIMED2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ATIMED2FocusLost(evt);
            }
        });
        ATIMED2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ATIMED2ActionPerformed(evt);
            }
        });

        ATIMIN2.setText("1");
        ATIMIN2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ATIMIN2FocusLost(evt);
            }
        });

        ATIMIN3.setText("1");
        ATIMIN3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ATIMIN3FocusLost(evt);
            }
        });

        ATIMED3.setText("1");
        ATIMED3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ATIMED3FocusLost(evt);
            }
        });

        ATIMAX3.setText("1");
        ATIMAX3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ATIMAX3FocusLost(evt);
            }
        });

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

        AI1MAX.setText("20000");
        AI1MAX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                AI1MAXFocusLost(evt);
            }
        });

        AI2MAX.setText("20000");
        AI2MAX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                AI2MAXFocusLost(evt);
            }
        });

        AI3MAX.setText("20000");
        AI3MAX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                AI3MAXFocusLost(evt);
            }
        });

        AI4MAX.setEditable(false);
        AI4MAX.setText("20000");

        AI4MED.setEditable(false);
        AI4MED.setText("20000");

        AI4MIN.setEditable(false);
        AI4MIN.setText("20000");

        AI3MIN.setText("20000");
        AI3MIN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                AI3MINFocusLost(evt);
            }
        });

        AI3MED.setText("20000");
        AI3MED.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                AI3MEDFocusLost(evt);
            }
        });

        AI2MED.setText("20000");
        AI2MED.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                AI2MEDFocusLost(evt);
            }
        });

        AI2MIN.setText("20000");
        AI2MIN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                AI2MINFocusLost(evt);
            }
        });

        AI1MIN.setText("20000");
        AI1MIN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                AI1MINFocusLost(evt);
            }
        });

        AI1MED.setText("20000");
        AI1MED.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                AI1MEDFocusLost(evt);
            }
        });

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
                                    .addComponent(AI1MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(AI1MAX)
                                        .addComponent(AI1MED, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(AI2MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(AI2MAX)
                                        .addComponent(AI2MED, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(AI3MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(AI3MAX)
                                        .addComponent(AI3MED, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(AI4MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(AI4MAX)
                                        .addComponent(AI4MED, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                                    .addComponent(ATIMIN1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(ATIMAX1)
                                        .addComponent(ATIMED1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel40))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ATIMIN2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(ATIMAX2)
                                                .addComponent(ATIMED2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ATIMIN3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(ATIMAX3)
                                                .addComponent(ATIMED3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                        .addComponent(ATIMAX2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ATIMED2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ATIMIN2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(ATIMAX3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ATIMED3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ATIMIN3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(AI1MAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel45))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(AI1MED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel46))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(AI1MIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel47)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(AI2MAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AI2MED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AI2MIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(AI3MAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AI3MED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AI3MIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(AI4MAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AI4MED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AI4MIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ATIMAX1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel42))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ATIMED1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel43))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ATIMIN1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel44)))))
                .addGap(35, 35, 35))
        );

        jPanel12.setBackground(new java.awt.Color(204, 255, 204));

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel48.setText("Jarra");

        FechaCal_A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FechaCal_AActionPerformed(evt);
            }
        });

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

        jComboBoxJarraA.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxJarraA.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxJarraAItemStateChanged(evt);
            }
        });
        jComboBoxJarraA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxJarraAActionPerformed(evt);
            }
        });

        avisoLabelA.setForeground(new java.awt.Color(255, 0, 0));
        avisoLabelA.setText("Aviso");

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
                            .addComponent(avisoLabelA)
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
                                    .addComponent(FechaCal_A)
                                    .addComponent(InfCal_A, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                                .addComponent(InfCal_A, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AKC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel49)))
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(FechaCal_A, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel52)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(avisoLabelA)
                .addGap(69, 69, 69))
        );

        jPanel13.setBackground(new java.awt.Color(255, 153, 153));

        jPanel15.setBackground(new java.awt.Color(204, 255, 204));

        etiquetaIncluir.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        etiquetaIncluir.setForeground(new java.awt.Color(0, 102, 51));
        etiquetaIncluir.setText("ACEPTADA");
        etiquetaIncluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                etiquetaIncluirMouseClicked(evt);
            }
        });
        etiquetaIncluir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                etiquetaIncluirKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiquetaIncluir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiquetaIncluir)
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

        jLabel328.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel328.setText("Precinto");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel328)
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
                    .addComponent(jTextField69, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoPrecintoA, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(82, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoPrecintoA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel328))
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

        AQVMAX.setEditable(false);

        AEMAX.setEditable(false);
        AEMAX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AEMAXActionPerformed(evt);
            }
        });

        AEMED.setEditable(false);

        AQVMED.setEditable(false);

        AQVMIN.setEditable(false);

        AEMIN.setEditable(false);

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

        botonIncluirMA.setText("Incluir");
        botonIncluirMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIncluirMAActionPerformed(evt);
            }
        });

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
                            .addComponent(AEMAX)
                            .addComponent(AQVMAX)
                            .addComponent(AVCMVMAX, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(AVCMVMED, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                .addComponent(AEMED)
                                .addComponent(AQVMED))
                            .addComponent(jLabel59))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel60)
                                .addGap(185, 185, 185))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(AVCMVMIN, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                    .addComponent(AEMIN)
                                    .addComponent(AQVMIN))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel73)
                                    .addComponent(jLabel62)
                                    .addComponent(jLabel61))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField65, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField66, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botonIncluirMA, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)))))
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
                            .addComponent(AEMAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel55))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AQVMAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel56)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(AVCMVMED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AEMED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AQVMED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(AVCMVMIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AEMIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AQVMIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(botonIncluirMA))))
                .addContainerGap(88, Short.MAX_VALUE))
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

        BTIMED1.setText("1");
        BTIMED1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                BTIMED1FocusLost(evt);
            }
        });

        BTIMAX1.setText("1");
        BTIMAX1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                BTIMAX1FocusLost(evt);
            }
        });
        BTIMAX1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTIMAX1ActionPerformed(evt);
            }
        });

        BTIMIN1.setText("1");
        BTIMIN1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                BTIMIN1FocusLost(evt);
            }
        });

        BTIMAX2.setText("1");
        BTIMAX2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                BTIMAX2FocusLost(evt);
            }
        });

        BTIMED2.setText("1");
        BTIMED2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                BTIMED2FocusLost(evt);
            }
        });

        BTIMIN2.setText("1");
        BTIMIN2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                BTIMIN2FocusLost(evt);
            }
        });

        BTIMIN3.setText("1");
        BTIMIN3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                BTIMIN3FocusLost(evt);
            }
        });

        BTIMED3.setText("1");
        BTIMED3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                BTIMED3FocusLost(evt);
            }
        });

        BTIMAX3.setText("1");
        BTIMAX3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                BTIMAX3FocusLost(evt);
            }
        });

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

        BI1MAX.setText("20000");
        BI1MAX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                BI1MAXFocusLost(evt);
            }
        });

        BI2MAX.setText("20000");
        BI2MAX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                BI2MAXFocusLost(evt);
            }
        });

        BI3MAX.setText("20000");
        BI3MAX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                BI3MAXFocusLost(evt);
            }
        });

        BI4MAX.setEditable(false);
        BI4MAX.setText("20000");

        BI4MED.setEditable(false);
        BI4MED.setText("20000");

        BI4MIN.setEditable(false);
        BI4MIN.setText("20000");

        BI3MIN.setText("20000");
        BI3MIN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                BI3MINFocusLost(evt);
            }
        });

        BI3MED.setText("20000");
        BI3MED.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                BI3MEDFocusLost(evt);
            }
        });
        BI3MED.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BI3MEDActionPerformed(evt);
            }
        });

        BI2MED.setText("20000");
        BI2MED.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                BI2MEDFocusLost(evt);
            }
        });

        BI2MIN.setText("20000");
        BI2MIN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                BI2MINFocusLost(evt);
            }
        });

        BI1MIN.setText("20000");
        BI1MIN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                BI1MINFocusLost(evt);
            }
        });

        BI1MED.setText("20000");
        BI1MED.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                BI1MEDFocusLost(evt);
            }
        });

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
                                    .addComponent(BI1MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(BI1MAX)
                                        .addComponent(BI1MED, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BI2MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(BI2MAX)
                                        .addComponent(BI2MED, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BI3MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(BI3MAX)
                                        .addComponent(BI3MED, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BI4MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(BI4MAX)
                                        .addComponent(BI4MED, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                                    .addComponent(BTIMIN1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(BTIMAX1)
                                        .addComponent(BTIMED1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel99))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(BTIMIN2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(BTIMAX2)
                                                .addComponent(BTIMED2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(BTIMIN3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(BTIMAX3)
                                                .addComponent(BTIMED3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                        .addComponent(BTIMAX2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTIMED2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTIMIN2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(BTIMAX3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTIMED3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTIMIN3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(BI1MAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel104))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(BI1MED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel105))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(BI1MIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel106)))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(BI2MAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BI2MED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BI2MIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(BI3MAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BI3MED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BI3MIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(BI4MAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BI4MED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BI4MIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel16Layout.createSequentialGroup()
                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(BTIMAX1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel101))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(BTIMED1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel102))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(BTIMIN1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jComboBoxJarraB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxJarraB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxJarraBItemStateChanged(evt);
            }
        });

        avisoLabelB.setForeground(new java.awt.Color(255, 0, 0));
        avisoLabelB.setText("Aviso");

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
                            .addComponent(avisoLabelB)
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
                                    .addComponent(FechaCal_B)
                                    .addComponent(InfCal_B, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(138, Short.MAX_VALUE))))
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
                                .addComponent(InfCal_B, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BKC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel108)))
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(FechaCal_B, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel111)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(avisoLabelB)
                .addGap(68, 68, 68))
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

        jLabel329.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel329.setText("Precinto");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel329)
                        .addGap(18, 18, 18)
                        .addComponent(campoPrecintoB, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
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
                            .addComponent(jTextField122, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(82, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel329)
                    .addComponent(campoPrecintoB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        BQVMAX.setEditable(false);

        BEMAX.setEditable(false);
        BEMAX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEMAXActionPerformed(evt);
            }
        });

        BEMED.setEditable(false);

        BQVMED.setEditable(false);

        BQVMIN.setEditable(false);

        BEMIN.setEditable(false);

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

        botonIncluirMB.setText("Incluir");
        botonIncluirMB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIncluirMBActionPerformed(evt);
            }
        });

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
                            .addComponent(BEMAX)
                            .addComponent(BQVMAX)
                            .addComponent(BVCMVMAX, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(BVCMVMED, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                .addComponent(BEMED)
                                .addComponent(BQVMED))
                            .addComponent(jLabel123))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addComponent(jLabel124)
                                .addGap(185, 185, 185))
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(BVCMVMIN, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                    .addComponent(BEMIN)
                                    .addComponent(BQVMIN))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel127)
                                    .addComponent(jLabel126)
                                    .addComponent(jLabel125))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField132, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField133, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botonIncluirMB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)))))
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
                            .addComponent(BEMAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel119))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BQVMAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel120)))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(BVCMVMED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BEMED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BQVMED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(BVCMVMIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BEMIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BQVMIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(botonIncluirMB))))
                .addContainerGap(88, Short.MAX_VALUE))
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
        CP1MAX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CP1MAXFocusLost(evt);
            }
        });

        CP1MED.setText("-10");
        CP1MED.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CP1MEDFocusLost(evt);
            }
        });

        CP1MIN.setText("-10");
        CP1MIN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CP1MINFocusLost(evt);
            }
        });

        CP2MIN.setText("-10");
        CP2MIN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CP2MINFocusLost(evt);
            }
        });

        CP2MAX.setText("-10");
        CP2MAX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CP2MAXFocusLost(evt);
            }
        });

        CP2MED.setText("-10");
        CP2MED.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CP2MEDFocusLost(evt);
            }
        });

        CP3MIN.setText("-10");
        CP3MIN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CP3MINFocusLost(evt);
            }
        });

        CP3MED.setText("-10");
        CP3MED.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CP3MEDFocusLost(evt);
            }
        });

        CP3MAX.setText("-10");
        CP3MAX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CP3MAXFocusLost(evt);
            }
        });

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
        CTMEDP1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CTMEDP1FocusLost(evt);
            }
        });

        CTMEDP2.setText("0");
        CTMEDP2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CTMEDP2FocusLost(evt);
            }
        });

        CTMEDP3.setText("0");
        CTMEDP3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CTMEDP3FocusLost(evt);
            }
        });

        CTMAXP3.setText("0");
        CTMAXP3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CTMAXP3FocusLost(evt);
            }
        });

        CTMINP1.setText("0");
        CTMINP1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CTMINP1FocusLost(evt);
            }
        });

        CTMINP3.setText("0");
        CTMINP3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CTMINP3FocusLost(evt);
            }
        });

        CTMAXP2.setText("0");
        CTMAXP2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CTMAXP2FocusLost(evt);
            }
        });

        CTMINP2.setText("0");
        CTMINP2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CTMINP2FocusLost(evt);
            }
        });

        CTMAXP1.setText("0");
        CTMAXP1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CTMAXP1FocusLost(evt);
            }
        });

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

        CTIMED1.setText("1");
        CTIMED1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CTIMED1FocusLost(evt);
            }
        });
        CTIMED1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CTIMED1ActionPerformed(evt);
            }
        });

        CTIMAX1.setText("1");
        CTIMAX1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CTIMAX1FocusLost(evt);
            }
        });

        CTIMIN1.setText("1");
        CTIMIN1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CTIMIN1FocusLost(evt);
            }
        });

        CTIMAX2.setText("1");
        CTIMAX2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CTIMAX2FocusLost(evt);
            }
        });

        CTIMED2.setText("1");
        CTIMED2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CTIMED2FocusLost(evt);
            }
        });

        CTIMIN2.setText("1");
        CTIMIN2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CTIMIN2FocusLost(evt);
            }
        });

        CTIMIN3.setText("1");
        CTIMIN3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CTIMIN3FocusLost(evt);
            }
        });

        CTIMED3.setText("1");
        CTIMED3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CTIMED3FocusLost(evt);
            }
        });

        CTIMAX3.setText("1");
        CTIMAX3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CTIMAX3FocusLost(evt);
            }
        });

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

        CI1MAX.setText("20000");
        CI1MAX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CI1MAXFocusLost(evt);
            }
        });

        CI2MAX.setText("20000");
        CI2MAX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CI2MAXFocusLost(evt);
            }
        });

        CI3MAX.setText("20000");
        CI3MAX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CI3MAXFocusLost(evt);
            }
        });

        CI4MAX.setEditable(false);
        CI4MAX.setText("20000");

        CI4MED.setEditable(false);
        CI4MED.setText("20000");

        CI4MIN.setEditable(false);
        CI4MIN.setText("20000");

        CI3MIN.setText("20000");
        CI3MIN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CI3MINFocusLost(evt);
            }
        });

        CI3MED.setText("20000");
        CI3MED.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CI3MEDFocusLost(evt);
            }
        });

        CI2MED.setText("20000");
        CI2MED.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CI2MEDFocusLost(evt);
            }
        });

        CI2MIN.setText("20000");
        CI2MIN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CI2MINFocusLost(evt);
            }
        });

        CI1MIN.setText("20000");
        CI1MIN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CI1MINFocusLost(evt);
            }
        });

        CI1MED.setText("20000");
        CI1MED.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CI1MEDFocusLost(evt);
            }
        });

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
                                    .addComponent(CI1MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(CI1MAX)
                                        .addComponent(CI1MED, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CI2MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(CI2MAX)
                                        .addComponent(CI2MED, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CI3MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(CI3MAX)
                                        .addComponent(CI3MED, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CI4MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(CI4MAX)
                                        .addComponent(CI4MED, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                                    .addComponent(CTIMIN1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(CTIMAX1)
                                        .addComponent(CTIMED1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel149))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel21Layout.createSequentialGroup()
                                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(CTIMIN2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(CTIMAX2)
                                                .addComponent(CTIMED2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(CTIMIN3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(CTIMAX3)
                                                .addComponent(CTIMED3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                        .addComponent(CTIMAX2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CTIMED2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CTIMIN2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(CTIMAX3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CTIMED3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CTIMIN3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CI1MAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel154))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CI1MED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel155))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CI1MIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel156)))
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addComponent(CI2MAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CI2MED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CI2MIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addComponent(CI3MAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CI3MED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CI3MIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addComponent(CI4MAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CI4MED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CI4MIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel21Layout.createSequentialGroup()
                            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(CTIMAX1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel151))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(CTIMED1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel152))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(CTIMIN1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel153)))))
                .addGap(35, 35, 35))
        );

        jPanel22.setBackground(new java.awt.Color(204, 255, 204));

        jLabel157.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel157.setText("Jarra");

        CV20.setText("0");
        CV20.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CV20FocusLost(evt);
            }
        });

        CKC.setText("0");
        CKC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CKCFocusLost(evt);
            }
        });

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

        jComboBoxJarraC.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxJarraC.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxJarraCItemStateChanged(evt);
            }
        });

        avisoLabelC.setForeground(new java.awt.Color(255, 0, 0));
        avisoLabelC.setText("Aviso");

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
                            .addComponent(avisoLabelC)
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
                                    .addComponent(FechaCal_C)
                                    .addComponent(InfCal_C, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(138, Short.MAX_VALUE))))
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
                                .addComponent(InfCal_C, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CKC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel158)))
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(FechaCal_C, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel161)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(avisoLabelC)
                .addGap(55, 55, 55))
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

        jLabel330.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel330.setText("Preciento");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
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
                            .addComponent(jTextField186, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel330)
                        .addGap(18, 18, 18)
                        .addComponent(campoPrecintoC, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(82, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel330)
                    .addComponent(campoPrecintoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        CQVMAX.setEditable(false);

        CEMAX.setEditable(false);
        CEMAX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CEMAXActionPerformed(evt);
            }
        });

        CEMED.setEditable(false);

        CQVMED.setEditable(false);

        CQVMIN.setEditable(false);

        CEMIN.setEditable(false);

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

        botonIncluirMC.setText("Incluir");
        botonIncluirMC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIncluirMCActionPerformed(evt);
            }
        });

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
                            .addComponent(CEMAX)
                            .addComponent(CQVMAX)
                            .addComponent(CVCMVMAX, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(CVCMVMED, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                .addComponent(CEMED)
                                .addComponent(CQVMED))
                            .addComponent(jLabel173))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addComponent(jLabel174)
                                .addGap(185, 185, 185))
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(CVCMVMIN, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                    .addComponent(CEMIN)
                                    .addComponent(CQVMIN))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel177)
                                    .addComponent(jLabel176)
                                    .addComponent(jLabel175))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField196, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField197, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botonIncluirMC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)))))
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
                            .addComponent(CEMAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel169))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CQVMAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel170)))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(CVCMVMED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CEMED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CQVMED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(CVCMVMIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CEMIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CQVMIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(botonIncluirMC))))
                .addContainerGap(88, Short.MAX_VALUE))
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
        DP1MAX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DP1MAXFocusLost(evt);
            }
        });

        DP1MED.setText("-10");
        DP1MED.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DP1MEDFocusLost(evt);
            }
        });

        DP1MIN.setText("-10");
        DP1MIN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DP1MINFocusLost(evt);
            }
        });

        DP2MIN.setText("-10");
        DP2MIN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DP2MINFocusLost(evt);
            }
        });

        DP2MAX.setText("-10");
        DP2MAX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DP2MAXFocusLost(evt);
            }
        });

        DP2MED.setText("-10");
        DP2MED.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DP2MEDFocusLost(evt);
            }
        });

        DP3MIN.setText("-10");
        DP3MIN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DP3MINFocusLost(evt);
            }
        });

        DP3MED.setText("-10");
        DP3MED.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DP3MEDFocusLost(evt);
            }
        });

        DP3MAX.setText("-10");
        DP3MAX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DP3MAXFocusLost(evt);
            }
        });

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
        DTMEDP1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DTMEDP1FocusLost(evt);
            }
        });

        DTMEDP2.setText("0");
        DTMEDP2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DTMEDP2FocusLost(evt);
            }
        });

        DTMEDP3.setText("0");
        DTMEDP3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DTMEDP3FocusLost(evt);
            }
        });

        DTMAXP3.setText("0");
        DTMAXP3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DTMAXP3FocusLost(evt);
            }
        });

        DTMINP1.setText("0");
        DTMINP1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DTMINP1FocusLost(evt);
            }
        });

        DTMINP3.setText("0");
        DTMINP3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DTMINP3FocusLost(evt);
            }
        });

        DTMAXP2.setText("0");
        DTMAXP2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DTMAXP2FocusLost(evt);
            }
        });

        DTMINP2.setText("0");
        DTMINP2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DTMINP2FocusLost(evt);
            }
        });

        DTMAXP1.setText("0");
        DTMAXP1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DTMAXP1FocusLost(evt);
            }
        });

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

        DTIMED1.setText("1");
        DTIMED1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DTIMED1FocusLost(evt);
            }
        });

        DTIMAX1.setText("1");
        DTIMAX1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DTIMAX1FocusLost(evt);
            }
        });

        DTIMIN1.setText("1");
        DTIMIN1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DTIMIN1FocusLost(evt);
            }
        });

        DTIMAX2.setText("1");
        DTIMAX2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DTIMAX2FocusLost(evt);
            }
        });

        DTIMED2.setText("1");
        DTIMED2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DTIMED2FocusLost(evt);
            }
        });

        DTIMIN2.setText("1");
        DTIMIN2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DTIMIN2FocusLost(evt);
            }
        });

        DTIMIN3.setText("1");
        DTIMIN3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DTIMIN3FocusLost(evt);
            }
        });

        DTIMED3.setText("1");
        DTIMED3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DTIMED3FocusLost(evt);
            }
        });

        DTIMAX3.setText("1");
        DTIMAX3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DTIMAX3FocusLost(evt);
            }
        });

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

        DI1MAX.setText("20000");
        DI1MAX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DI1MAXFocusLost(evt);
            }
        });

        DI2MAX.setText("20000");
        DI2MAX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DI2MAXFocusLost(evt);
            }
        });

        DI3MAX.setText("20000");
        DI3MAX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DI3MAXFocusLost(evt);
            }
        });

        DI4MAX.setEditable(false);
        DI4MAX.setText("20000");

        DI4MED.setEditable(false);
        DI4MED.setText("20000");

        DI4MIN.setEditable(false);
        DI4MIN.setText("20000");

        DI3MIN.setText("20000");
        DI3MIN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DI3MINFocusLost(evt);
            }
        });

        DI3MED.setText("20000");
        DI3MED.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DI3MEDFocusLost(evt);
            }
        });

        DI2MED.setText("20000");
        DI2MED.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DI2MEDFocusLost(evt);
            }
        });

        DI2MIN.setText("20000");
        DI2MIN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DI2MINFocusLost(evt);
            }
        });

        DI1MIN.setText("20000");
        DI1MIN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DI1MINFocusLost(evt);
            }
        });

        DI1MED.setText("20000");
        DI1MED.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DI1MEDFocusLost(evt);
            }
        });

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
                                    .addComponent(DI1MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(DI1MAX)
                                        .addComponent(DI1MED, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DI2MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(DI2MAX)
                                        .addComponent(DI2MED, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DI3MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(DI3MAX)
                                        .addComponent(DI3MED, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DI4MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(DI4MAX)
                                        .addComponent(DI4MED, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                                    .addComponent(DTIMIN1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(DTIMAX1)
                                        .addComponent(DTIMED1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel199))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel26Layout.createSequentialGroup()
                                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(DTIMIN2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(DTIMAX2)
                                                .addComponent(DTIMED2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(DTIMIN3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(DTIMAX3)
                                                .addComponent(DTIMED3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                        .addComponent(DTIMAX2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DTIMED2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DTIMIN2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(DTIMAX3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DTIMED3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DTIMIN3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(DI1MAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel204))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(DI1MED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel205))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(DI1MIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel206)))
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addComponent(DI2MAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DI2MED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DI2MIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addComponent(DI3MAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DI3MED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DI3MIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addComponent(DI4MAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DI4MED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DI4MIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel26Layout.createSequentialGroup()
                            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(DTIMAX1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel201))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(DTIMED1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel202))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(DTIMIN1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel203)))))
                .addGap(35, 35, 35))
        );

        jPanel27.setBackground(new java.awt.Color(204, 255, 204));

        jLabel207.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel207.setText("Jarra");

        DV20.setText("0");
        DV20.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DV20FocusLost(evt);
            }
        });

        DKC.setText("0");
        DKC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DKCFocusLost(evt);
            }
        });

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

        jComboBoxJarraD.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxJarraD.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxJarraDItemStateChanged(evt);
            }
        });

        avisoLabelD.setForeground(new java.awt.Color(255, 0, 0));
        avisoLabelD.setText("Aviso");

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
                            .addComponent(avisoLabelD)
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
                                    .addComponent(FechaCal_D)
                                    .addComponent(InfCal_D, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(138, Short.MAX_VALUE))))
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
                                .addComponent(InfCal_D, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DKC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel208)))
                    .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(FechaCal_D, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel211)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(avisoLabelD)
                .addGap(71, 71, 71))
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

        jLabel331.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel331.setText("Precinto");

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(jLabel331)
                        .addGap(18, 18, 18)
                        .addComponent(campoPrecintoD, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel28Layout.createSequentialGroup()
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
                            .addComponent(jTextField250, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(82, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel331)
                    .addComponent(campoPrecintoD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        DQVMAX.setEditable(false);

        DEMAX.setEditable(false);
        DEMAX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DEMAXActionPerformed(evt);
            }
        });

        DEMED.setEditable(false);

        DQVMED.setEditable(false);

        DQVMIN.setEditable(false);

        DEMIN.setEditable(false);

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

        botonIncluirMD.setText("Incluir");
        botonIncluirMD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIncluirMDActionPerformed(evt);
            }
        });

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
                            .addComponent(DEMAX)
                            .addComponent(DQVMAX)
                            .addComponent(DVCMVMAX, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(DVCMVMED, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                .addComponent(DEMED)
                                .addComponent(DQVMED))
                            .addComponent(jLabel223))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel30Layout.createSequentialGroup()
                                .addComponent(jLabel224)
                                .addGap(185, 185, 185))
                            .addGroup(jPanel30Layout.createSequentialGroup()
                                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(DVCMVMIN, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                    .addComponent(DEMIN)
                                    .addComponent(DQVMIN))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel227)
                                    .addComponent(jLabel226)
                                    .addComponent(jLabel225))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField260, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField261, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botonIncluirMD, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)))))
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
                            .addComponent(DEMAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel219))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DQVMAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel220)))
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addComponent(DVCMVMED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DEMED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DQVMED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addComponent(DVCMVMIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DEMIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DQVMIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(botonIncluirMD))))
                .addContainerGap(88, Short.MAX_VALUE))
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
        EP1MAX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                EP1MAXFocusLost(evt);
            }
        });

        EP1MED.setText("-10");
        EP1MED.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                EP1MEDFocusLost(evt);
            }
        });

        EP1MIN.setText("-10");
        EP1MIN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                EP1MINFocusLost(evt);
            }
        });

        EP2MIN.setText("-10");
        EP2MIN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                EP2MINFocusLost(evt);
            }
        });

        EP2MAX.setText("-10");
        EP2MAX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                EP2MAXFocusLost(evt);
            }
        });

        EP2MED.setText("-10");
        EP2MED.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                EP2MEDFocusLost(evt);
            }
        });

        EP3MIN.setText("-10");
        EP3MIN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                EP3MINFocusLost(evt);
            }
        });

        EP3MED.setText("-10");
        EP3MED.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                EP3MEDFocusLost(evt);
            }
        });

        EP3MAX.setText("-10");
        EP3MAX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                EP3MAXFocusLost(evt);
            }
        });

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
        ETMEDP1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ETMEDP1FocusLost(evt);
            }
        });

        ETMEDP2.setText("0");
        ETMEDP2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ETMEDP2FocusLost(evt);
            }
        });

        ETMEDP3.setText("0");
        ETMEDP3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ETMEDP3FocusLost(evt);
            }
        });

        ETMAXP3.setText("0");
        ETMAXP3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ETMAXP3FocusLost(evt);
            }
        });

        ETMINP1.setText("0");
        ETMINP1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ETMINP1FocusLost(evt);
            }
        });

        ETMINP3.setText("0");
        ETMINP3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ETMINP3FocusLost(evt);
            }
        });

        ETMAXP2.setText("0");
        ETMAXP2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ETMAXP2FocusLost(evt);
            }
        });

        ETMINP2.setText("0");
        ETMINP2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ETMINP2FocusLost(evt);
            }
        });

        ETMAXP1.setText("0");
        ETMAXP1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ETMAXP1FocusLost(evt);
            }
        });

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

        ETIMED1.setText("1");
        ETIMED1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ETIMED1FocusLost(evt);
            }
        });

        ETIMAX1.setText("1");
        ETIMAX1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ETIMAX1FocusLost(evt);
            }
        });

        ETIMIN1.setText("1");
        ETIMIN1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ETIMIN1FocusLost(evt);
            }
        });

        ETIMAX2.setText("1");
        ETIMAX2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ETIMAX2FocusLost(evt);
            }
        });

        ETIMED2.setText("1");
        ETIMED2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ETIMED2FocusLost(evt);
            }
        });

        ETIMIN2.setText("1");
        ETIMIN2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ETIMIN2FocusLost(evt);
            }
        });

        ETIMIN3.setText("1");
        ETIMIN3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ETIMIN3FocusLost(evt);
            }
        });

        ETIMED3.setText("1");
        ETIMED3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ETIMED3FocusLost(evt);
            }
        });

        ETIMAX3.setText("1");
        ETIMAX3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ETIMAX3FocusLost(evt);
            }
        });

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

        EI1MAX.setText("20000");
        EI1MAX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                EI1MAXFocusLost(evt);
            }
        });

        EI2MAX.setText("20000");
        EI2MAX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                EI2MAXFocusLost(evt);
            }
        });

        EI3MAX.setText("20000");
        EI3MAX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                EI3MAXFocusLost(evt);
            }
        });

        EI4MAX.setEditable(false);
        EI4MAX.setText("20000");

        EI4MED.setEditable(false);
        EI4MED.setText("20000");

        EI4MIN.setEditable(false);
        EI4MIN.setText("20000");

        EI3MIN.setText("20000");
        EI3MIN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                EI3MINFocusLost(evt);
            }
        });

        EI3MED.setText("20000");
        EI3MED.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                EI3MEDFocusLost(evt);
            }
        });

        EI2MED.setText("20000");
        EI2MED.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                EI2MEDFocusLost(evt);
            }
        });

        EI2MIN.setText("20000");
        EI2MIN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                EI2MINFocusLost(evt);
            }
        });

        EI1MIN.setText("20000");
        EI1MIN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                EI1MINFocusLost(evt);
            }
        });

        EI1MED.setText("20000");
        EI1MED.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                EI1MEDFocusLost(evt);
            }
        });

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
                                    .addComponent(EI1MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(EI1MAX)
                                        .addComponent(EI1MED, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(EI2MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(EI2MAX)
                                        .addComponent(EI2MED, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(EI3MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(EI3MAX)
                                        .addComponent(EI3MED, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(EI4MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(EI4MAX)
                                        .addComponent(EI4MED, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                                    .addComponent(ETIMIN1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(ETIMAX1)
                                        .addComponent(ETIMED1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel249))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel31Layout.createSequentialGroup()
                                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ETIMIN2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(ETIMAX2)
                                                .addComponent(ETIMED2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ETIMIN3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(ETIMAX3)
                                                .addComponent(ETIMED3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(ETIMAX2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ETIMED2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ETIMIN2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(ETIMAX3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ETIMED3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ETIMIN3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel31Layout.createSequentialGroup()
                                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(EI1MAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel254))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(EI1MED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel255))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(EI1MIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel256)))
                            .addGroup(jPanel31Layout.createSequentialGroup()
                                .addComponent(EI2MAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(EI2MED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(EI2MIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel31Layout.createSequentialGroup()
                                .addComponent(EI3MAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(EI3MED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(EI3MIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel31Layout.createSequentialGroup()
                                .addComponent(EI4MAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(EI4MED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(EI4MIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel31Layout.createSequentialGroup()
                            .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ETIMAX1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel251))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ETIMED1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel252))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ETIMIN1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel253)))))
                .addGap(35, 35, 35))
        );

        jPanel32.setBackground(new java.awt.Color(204, 255, 204));

        jLabel257.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel257.setText("Jarra");

        EV20.setText("0");
        EV20.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                EV20FocusLost(evt);
            }
        });

        EKC.setText("0");
        EKC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                EKCFocusLost(evt);
            }
        });

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

        jComboBoxJarraE.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxJarraE.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxJarraEItemStateChanged(evt);
            }
        });

        avisoLabelE.setForeground(new java.awt.Color(255, 0, 0));
        avisoLabelE.setText("Aviso");

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
                            .addComponent(avisoLabelE)
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
                                    .addComponent(FechaCal_E)
                                    .addComponent(InfCal_E, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(138, Short.MAX_VALUE))))
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
                                .addComponent(InfCal_E, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EKC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel258)))
                    .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(FechaCal_E, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel261)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(avisoLabelE)
                .addGap(40, 40, 40))
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

        jLabel333.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel333.setText("Precinto");

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addComponent(jLabel333)
                        .addGap(18, 18, 18)
                        .addComponent(campoPrecintoE, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel33Layout.createSequentialGroup()
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
                            .addComponent(jTextField314, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(82, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel333)
                    .addComponent(campoPrecintoE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        EQVMAX.setEditable(false);

        EEMAX.setEditable(false);
        EEMAX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EEMAXActionPerformed(evt);
            }
        });

        EEMED.setEditable(false);

        EQVMED.setEditable(false);

        EQVMIN.setEditable(false);

        EEMIN.setEditable(false);

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

        botonIncluirME.setText("Incluir");
        botonIncluirME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIncluirMEActionPerformed(evt);
            }
        });

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
                            .addComponent(EEMAX)
                            .addComponent(EQVMAX)
                            .addComponent(EVCMVMAX, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(EVCMVMED, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                .addComponent(EEMED)
                                .addComponent(EQVMED))
                            .addComponent(jLabel273))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel35Layout.createSequentialGroup()
                                .addComponent(jLabel274)
                                .addGap(185, 185, 185))
                            .addGroup(jPanel35Layout.createSequentialGroup()
                                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(EVCMVMIN, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                    .addComponent(EEMIN)
                                    .addComponent(EQVMIN))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel277)
                                    .addComponent(jLabel276)
                                    .addComponent(jLabel275))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField324, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField325, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botonIncluirME, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)))))
                    .addComponent(jLabel271, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
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
                            .addComponent(EEMAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel269))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EQVMAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel270)))
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addComponent(EVCMVMED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EEMED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EQVMED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addComponent(EVCMVMIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EEMIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EQVMIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(botonIncluirME))))
                .addContainerGap(88, Short.MAX_VALUE))
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
        FP1MAX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FP1MAXFocusLost(evt);
            }
        });

        FP1MED.setText("-10");
        FP1MED.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FP1MEDFocusLost(evt);
            }
        });

        FP1MIN.setText("-10");
        FP1MIN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FP1MINFocusLost(evt);
            }
        });

        FP2MIN.setText("-10");
        FP2MIN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FP2MINFocusLost(evt);
            }
        });

        FP2MAX.setText("-10");
        FP2MAX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FP2MAXFocusLost(evt);
            }
        });

        FP2MED.setText("-10");
        FP2MED.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FP2MEDFocusLost(evt);
            }
        });

        FP3MIN.setText("-10");
        FP3MIN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FP3MINFocusLost(evt);
            }
        });

        FP3MED.setText("-10");
        FP3MED.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FP3MEDFocusLost(evt);
            }
        });

        FP3MAX.setText("-10");
        FP3MAX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FP3MAXFocusLost(evt);
            }
        });

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
        FTMEDP1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FTMEDP1FocusLost(evt);
            }
        });

        FTMEDP2.setText("0");
        FTMEDP2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FTMEDP2FocusLost(evt);
            }
        });

        FTMEDP3.setText("0");
        FTMEDP3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FTMEDP3FocusLost(evt);
            }
        });

        FTMAXP3.setText("0");
        FTMAXP3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FTMAXP3FocusLost(evt);
            }
        });

        FTMINP1.setText("0");
        FTMINP1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FTMINP1FocusLost(evt);
            }
        });

        FTMINP3.setText("0");
        FTMINP3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FTMINP3FocusLost(evt);
            }
        });

        FTMAXP2.setText("0");
        FTMAXP2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FTMAXP2FocusLost(evt);
            }
        });

        FTMINP2.setText("0");
        FTMINP2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FTMINP2FocusLost(evt);
            }
        });

        FTMAXP1.setText("0");
        FTMAXP1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FTMAXP1FocusLost(evt);
            }
        });

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

        FTIMED1.setText("1");
        FTIMED1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FTIMED1FocusLost(evt);
            }
        });

        FTIMAX1.setText("1");
        FTIMAX1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FTIMAX1FocusLost(evt);
            }
        });

        FTIMIN1.setText("1");
        FTIMIN1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FTIMIN1FocusLost(evt);
            }
        });

        FTIMAX2.setText("1");
        FTIMAX2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FTIMAX2FocusLost(evt);
            }
        });

        FTIMED2.setText("1");
        FTIMED2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FTIMED2FocusLost(evt);
            }
        });

        FTIMIN2.setText("1");
        FTIMIN2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FTIMIN2FocusLost(evt);
            }
        });

        FTIMIN3.setText("1");
        FTIMIN3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FTIMIN3FocusLost(evt);
            }
        });

        FTIMED3.setText("1");
        FTIMED3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FTIMED3FocusLost(evt);
            }
        });

        FTIMAX3.setText("1");
        FTIMAX3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FTIMAX3FocusLost(evt);
            }
        });

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

        FI1MAX.setText("20000");
        FI1MAX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FI1MAXFocusLost(evt);
            }
        });

        FI2MAX.setText("20000");
        FI2MAX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FI2MAXFocusLost(evt);
            }
        });

        FI3MAX.setText("20000");
        FI3MAX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FI3MAXFocusLost(evt);
            }
        });

        FI4MAX.setEditable(false);
        FI4MAX.setText("20000");

        FI4MED.setEditable(false);
        FI4MED.setText("20000");

        FI4MIN.setEditable(false);
        FI4MIN.setText("20000");

        FI3MIN.setText("20000");
        FI3MIN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FI3MINFocusLost(evt);
            }
        });

        FI3MED.setText("20000");
        FI3MED.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FI3MEDFocusLost(evt);
            }
        });

        FI2MED.setText("20000");
        FI2MED.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FI2MEDFocusLost(evt);
            }
        });

        FI2MIN.setText("20000");
        FI2MIN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FI2MINFocusLost(evt);
            }
        });

        FI1MIN.setText("20000");
        FI1MIN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FI1MINFocusLost(evt);
            }
        });

        FI1MED.setText("20000");
        FI1MED.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FI1MEDFocusLost(evt);
            }
        });

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
                                                        .addComponent(jTextField340, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(jPanel36Layout.createSequentialGroup()
                                                .addGap(118, 118, 118)
                                                .addComponent(FI4MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                                    .addComponent(FI1MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(FI1MAX)
                                        .addComponent(FI1MED, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(FI2MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(FI2MAX)
                                        .addComponent(FI2MED, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(FI3MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(FI3MAX)
                                        .addComponent(FI3MED, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(FI4MAX)
                                    .addComponent(FI4MED, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                                    .addComponent(FTIMIN1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(FTIMAX1)
                                        .addComponent(FTIMED1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel299))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel36Layout.createSequentialGroup()
                                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(FTIMIN2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(FTIMAX2)
                                                .addComponent(FTIMED2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(FTIMIN3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(FTIMAX3)
                                                .addComponent(FTIMED3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                        .addComponent(FTIMAX2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FTIMED2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FTIMIN2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(FTIMAX3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FTIMED3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FTIMIN3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel36Layout.createSequentialGroup()
                                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(FI1MAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel304))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(FI1MED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel305))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(FI1MIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel306)))
                            .addGroup(jPanel36Layout.createSequentialGroup()
                                .addComponent(FI2MAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FI2MED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FI2MIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel36Layout.createSequentialGroup()
                                .addComponent(FI3MAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FI3MED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FI3MIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel36Layout.createSequentialGroup()
                                .addComponent(FI4MAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FI4MED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FI4MIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel36Layout.createSequentialGroup()
                            .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(FTIMAX1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel301))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(FTIMED1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel302))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(FTIMIN1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel303)))))
                .addGap(35, 35, 35))
        );

        jPanel37.setBackground(new java.awt.Color(204, 255, 204));

        jLabel307.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel307.setText("Jarra");

        FV20.setText("0");
        FV20.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FV20FocusLost(evt);
            }
        });

        FKC.setText("0");
        FKC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FKCFocusLost(evt);
            }
        });

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

        jComboBoxJarraF.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxJarraF.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxJarraFItemStateChanged(evt);
            }
        });

        avisoLabelF.setForeground(new java.awt.Color(255, 0, 0));
        avisoLabelF.setText("Aviso");

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
                            .addComponent(avisoLabelF)
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
                                    .addComponent(FechaCal_F)
                                    .addComponent(InfCal_F, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(138, Short.MAX_VALUE))))
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
                                .addComponent(InfCal_F, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FKC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel308)))
                    .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(FechaCal_F, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel311)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(avisoLabelF)
                .addGap(60, 60, 60))
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

        jLabel332.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel332.setText("Precinto");

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addComponent(jLabel332)
                        .addGap(18, 18, 18)
                        .addComponent(campoPrecintoF, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel38Layout.createSequentialGroup()
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
                            .addComponent(jTextField378, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(82, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel332)
                    .addComponent(campoPrecintoF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        FQVMAX.setEditable(false);

        FEMAX.setEditable(false);
        FEMAX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FEMAXActionPerformed(evt);
            }
        });

        FEMED.setEditable(false);

        FQVMED.setEditable(false);

        FQVMIN.setEditable(false);

        FEMIN.setEditable(false);

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

        botonIncluirMF.setText("Incluir");
        botonIncluirMF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIncluirMFActionPerformed(evt);
            }
        });

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
                            .addComponent(FEMAX)
                            .addComponent(FQVMAX)
                            .addComponent(FVCMVMAX, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(FVCMVMED, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                .addComponent(FEMED)
                                .addComponent(FQVMED))
                            .addComponent(jLabel323))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel40Layout.createSequentialGroup()
                                .addComponent(jLabel324)
                                .addGap(185, 185, 185))
                            .addGroup(jPanel40Layout.createSequentialGroup()
                                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(FVCMVMIN, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                    .addComponent(FEMIN)
                                    .addComponent(FQVMIN))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel327)
                                    .addComponent(jLabel326)
                                    .addComponent(jLabel325))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField388, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField389, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botonIncluirMF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)))))
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
                            .addComponent(FEMAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel319))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FQVMAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel320)))
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addComponent(FVCMVMED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FEMED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FQVMED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addComponent(FVCMVMIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FEMIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FQVMIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(botonIncluirMF))))
                .addContainerGap(88, Short.MAX_VALUE))
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
            
            jComboBoxDispensarios.removeAllItems();
            String folioSol = folioSolicitud.getText();
            int validaFSol = 0;
            int validaEstacion = 0;
            String noEstacion = "";
            String tipoVerificacion = "";
            lbd.openConnection();
                validaFSol = lbd.validaFolioSolicitud(folioSol);
                noEstacion = lbd.obtenerEstacionDeFolio(folioSol);
                validaEstacion = lbd.obtenerEstaciones(noEstacion);
                tipoVerificacion = lbd.obtenerTipoVerificación(folioSol, noEstacion);
            lbd.closeConnection();
            
            if(validaFSol != 0 && validaEstacion != 0){

                JOptionPane.showMessageDialog(null,"El folio es valido.");
                if(validaEstacion != 0){
                //JOptionPane.showMessageDialog(null,"El cliente si existe, da si para cargar la información");
                int dialogButton = JOptionPane.YES_NO_OPTION;
                campoEstacion.setText(noEstacion);
                JOptionPane.showMessageDialog(null,"Se cargaran los datos del cliente: "+campoEstacion.getText());
                int dialogResult = JOptionPane.showConfirmDialog (null, "¿Está de acuerdo?","Warning",dialogButton);
                if(dialogResult == JOptionPane.YES_OPTION){
                   lbd.openConnection();
                   Object [] estacion = lbd.obtenerArrEstaciones(noEstacion);
                   campoInformacionEstacion.setText(Arrays.toString(estacion));
                   mapDispensarios = lbd.obtenerDispensarios(noEstacion);
                   infoCliente = lbd.infoCliente(noEstacion); /*Obtiene la infor del cliente 10/08/2021*/
                   //this.infoCliente = infoCliente;
                   System.out.println(infoCliente.toString());
                   lbd.closeConnection();
                   System.out.println(mapDispensarios.toString());
                   /*Recorre el mapa y lo llena con el dispensario :)*/
                   mapDispensarios.forEach((k,v)->{
                   System.out.println("LLave = " + k + ", Valor = " + v);
                    //Aqui llenas tu JComboBox
                    jComboBoxDispensarios.addItem(String.valueOf(v));
                   });
                   campoTipoVerificacion.setText(tipoVerificacion);
                }
                else{
                
                }
                }
                else{

                    JOptionPane.showMessageDialog(null,"No existe el cliente que quiere consultar.");
                }
            }
            else{

                JOptionPane.showMessageDialog(null,"No existe el folio ó la estación que quiere imprimir.");
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

    private void AEMAXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AEMAXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AEMAXActionPerformed

    private void jTextField65ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField65ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField65ActionPerformed

    private void BEMAXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEMAXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BEMAXActionPerformed

    private void jTextField132ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField132ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField132ActionPerformed

    private void CEMAXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CEMAXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CEMAXActionPerformed

    private void jTextField196ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField196ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField196ActionPerformed

    private void DEMAXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DEMAXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DEMAXActionPerformed

    private void jTextField260ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField260ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField260ActionPerformed

    private void EEMAXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EEMAXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EEMAXActionPerformed

    private void jTextField324ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField324ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField324ActionPerformed

    private void FEMAXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FEMAXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FEMAXActionPerformed

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
                   lbd.openConnection();
                   Object [] estacion = lbd.obtenerArrEstaciones(nEstacion);
                   campoInformacionEstacion.setText(Arrays.toString(estacion));
                   informacionCliente infoCliente = lbd.infoCliente(nEstacion);
                   System.out.println(infoCliente.toString());
                   lbd.closeConnection();
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

    private void btnGuardarExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarExcelActionPerformed
        // TODO add your handling code here:
        reporteExcel repExcel = new reporteExcel();
        if(!folioSolicitud.getText().isEmpty() /*&& !campoEstacion.getText().isEmpty()*/){
//            int proceoExitoso = lbd.obtenerValidacionFolioEstacion(folioSolicitud.getText(),campoEstacion.getText());
//            if(proceoExitoso == 1)
              //Aquí vamos a insertar la información a la base de datos JLCI 12/09/2021
              //Instancio la clase modelo verificacion visual
              modeloVerificacionVisual modeloVVisual = new modeloVerificacionVisual();
              //Después no es necesario el seteo dentro el metodo de la información solamente llenamos según lo que correspondá
              modeloVVisual.setId(0); //El valor es cero por defecto al insertar
              modeloVVisual.setFolio(folioSolicitud.getText());
              modeloVVisual.setN_estacion(folioSolicitud.getText());
              modeloVVisual.setDispensario((String) jComboBoxDispensarios.getSelectedItem());
              
              if(jRadioButton21.isSelected())
                modeloVVisual.setLeyendas("C");
              else
                modeloVVisual.setLeyendas("N");
              
              if(jRadioButton24.isSelected())
                modeloVVisual.setPlaca("C");
              else
                modeloVVisual.setPlaca("N");
              
              if(jRadioButton26.isSelected())
                modeloVVisual.setCaratula("C");
              else
                modeloVVisual.setCaratula("N");
              
              if(jRadioButton28.isSelected())
                modeloVVisual.setSigno("C");
              else
                modeloVVisual.setSigno("N");
              
              if(jRadioButton30.isSelected())
                modeloVVisual.setDisp_contador("C");
              else
                modeloVVisual.setDisp_contador("N");
              
              if(jRadioButton32.isSelected())
                modeloVVisual.setMecanismo("C");
              else
                modeloVVisual.setMecanismo("N");
              
              if(jRadioButton34.isSelected())
                modeloVVisual.setDisp_despacho("C");
              else
                modeloVVisual.setDisp_despacho("N");
              
              if(jRadioButton36.isSelected())
                modeloVVisual.setGolpes("C");
              else
                modeloVVisual.setGolpes("N");
              
              if(jRadioButton38.isSelected())
                modeloVVisual.setTiempo("C");
              else
                modeloVVisual.setTiempo("N");
              
              //modeloVVisual.setPlaca(folioSolicitud.getText());
              //modeloVVisual.setCaratula(folioSolicitud.getText());
              //modeloVVisual.setSigno(folioSolicitud.getText());
              //modeloVVisual.setDisp_contador(folioSolicitud.getText());
              //modeloVVisual.setMecanismo(folioSolicitud.getText());
              //modeloVVisual.setDisp_despacho(folioSolicitud.getText());
              //modeloVVisual.setGolpes(folioSolicitud.getText());
              //modeloVVisual.setTiempo(folioSolicitud.getText());
              //por qué el modelo ya se inserto pero imprimo para ver el contenido
              System.out.println(modeloVVisual.toString());
              lbd.openConnection(); //Abro Conexíon
              int operacionExitosa = lbd.insertarModeloVerificacionVisual(modeloVVisual);
              lbd.closeConnection(); //Cierro Conexíon
              if(operacionExitosa == 1){
                  JOptionPane.showMessageDialog(null, "Los datos de la verificiación "
                          + "visual fueron ingresados correctamente.");
                  //repExcel.crearDocumentoExcel(6, folioSolicitud.getText(),infoCliente, infoDispensarios);
              }
              else{
                  JOptionPane.showMessageDialog(null, "Los datos de la verificiación "
                          + "visual ya fueron ingresados anteriormente. ");
              }
              
        }
        else{
            JOptionPane.showMessageDialog(null, "El folio no se ingreso ó no es válido.");
        }
        
    }//GEN-LAST:event_btnGuardarExcelActionPerformed

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

    private void ATIMED2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ATIMED2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ATIMED2ActionPerformed

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

    private void BI3MEDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BI3MEDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BI3MEDActionPerformed

    private void BTMAXP3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTMAXP3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTMAXP3ActionPerformed

    private void BTMEDP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTMEDP1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTMEDP1ActionPerformed

    private void BTMINP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTMINP2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTMINP2ActionPerformed

    private void BTIMAX1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTIMAX1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTIMAX1ActionPerformed

    private void CTIMED1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CTIMED1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CTIMED1ActionPerformed

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

    private void CP1MAXFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CP1MAXFocusLost
      operacionesdeInspeccionMedicion();  // TODO add your handling code here:
    }//GEN-LAST:event_CP1MAXFocusLost

    private void CP2MAXFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CP2MAXFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_CP2MAXFocusLost

    private void CP3MAXFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CP3MAXFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_CP3MAXFocusLost

    private void CP1MEDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CP1MEDFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_CP1MEDFocusLost

    private void CP2MEDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CP2MEDFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_CP2MEDFocusLost

    private void CP3MEDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CP3MEDFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_CP3MEDFocusLost

    private void CP1MINFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CP1MINFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_CP1MINFocusLost

    private void CP2MINFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CP2MINFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_CP2MINFocusLost

    private void CP3MINFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CP3MINFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_CP3MINFocusLost

    private void CTMAXP1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CTMAXP1FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_CTMAXP1FocusLost

    private void CTMAXP2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CTMAXP2FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_CTMAXP2FocusLost

    private void CTMAXP3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CTMAXP3FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_CTMAXP3FocusLost

    private void CTMEDP1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CTMEDP1FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_CTMEDP1FocusLost

    private void CTMEDP2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CTMEDP2FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_CTMEDP2FocusLost

    private void CTMEDP3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CTMEDP3FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_CTMEDP3FocusLost

    private void CTMINP1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CTMINP1FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_CTMINP1FocusLost

    private void CTMINP2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CTMINP2FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_CTMINP2FocusLost

    private void CTMINP3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CTMINP3FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_CTMINP3FocusLost

    private void CV20FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CV20FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_CV20FocusLost

    private void CKCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CKCFocusLost
        operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_CKCFocusLost

    private void DP1MAXFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DP1MAXFocusLost
    operacionesdeInspeccionMedicion();     // TODO add your handling code here:
    }//GEN-LAST:event_DP1MAXFocusLost

    private void DP2MAXFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DP2MAXFocusLost
operacionesdeInspeccionMedicion();         // TODO add your handling code here:
    }//GEN-LAST:event_DP2MAXFocusLost

    private void DP3MAXFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DP3MAXFocusLost
operacionesdeInspeccionMedicion();         // TODO add your handling code here:
    }//GEN-LAST:event_DP3MAXFocusLost

    private void DP1MEDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DP1MEDFocusLost
operacionesdeInspeccionMedicion();         // TODO add your handling code here:
    }//GEN-LAST:event_DP1MEDFocusLost

    private void DP2MEDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DP2MEDFocusLost
operacionesdeInspeccionMedicion();         // TODO add your handling code here:
    }//GEN-LAST:event_DP2MEDFocusLost

    private void DP3MEDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DP3MEDFocusLost
operacionesdeInspeccionMedicion();         // TODO add your handling code here:
    }//GEN-LAST:event_DP3MEDFocusLost

    private void DP1MINFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DP1MINFocusLost
operacionesdeInspeccionMedicion();         // TODO add your handling code here:
    }//GEN-LAST:event_DP1MINFocusLost

    private void DP2MINFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DP2MINFocusLost
operacionesdeInspeccionMedicion();         // TODO add your handling code here:
    }//GEN-LAST:event_DP2MINFocusLost

    private void DP3MINFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DP3MINFocusLost
operacionesdeInspeccionMedicion();         // TODO add your handling code here:
    }//GEN-LAST:event_DP3MINFocusLost

    private void DTMAXP1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DTMAXP1FocusLost
operacionesdeInspeccionMedicion();         // TODO add your handling code here:
    }//GEN-LAST:event_DTMAXP1FocusLost

    private void DTMAXP2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DTMAXP2FocusLost
operacionesdeInspeccionMedicion();         // TODO add your handling code here:
    }//GEN-LAST:event_DTMAXP2FocusLost

    private void DTMAXP3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DTMAXP3FocusLost
operacionesdeInspeccionMedicion();         // TODO add your handling code here:
    }//GEN-LAST:event_DTMAXP3FocusLost

    private void DTMEDP1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DTMEDP1FocusLost
operacionesdeInspeccionMedicion();         // TODO add your handling code here:
    }//GEN-LAST:event_DTMEDP1FocusLost

    private void DTMEDP2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DTMEDP2FocusLost
operacionesdeInspeccionMedicion();         // TODO add your handling code here:
    }//GEN-LAST:event_DTMEDP2FocusLost

    private void DTMEDP3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DTMEDP3FocusLost
operacionesdeInspeccionMedicion();         // TODO add your handling code here:
    }//GEN-LAST:event_DTMEDP3FocusLost

    private void DTMINP1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DTMINP1FocusLost
operacionesdeInspeccionMedicion();         // TODO add your handling code here:
    }//GEN-LAST:event_DTMINP1FocusLost

    private void DTMINP2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DTMINP2FocusLost
operacionesdeInspeccionMedicion();         // TODO add your handling code here:
    }//GEN-LAST:event_DTMINP2FocusLost

    private void DTMINP3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DTMINP3FocusLost
operacionesdeInspeccionMedicion();         // TODO add your handling code here:
    }//GEN-LAST:event_DTMINP3FocusLost

    private void DV20FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DV20FocusLost
operacionesdeInspeccionMedicion();         // TODO add your handling code here:
    }//GEN-LAST:event_DV20FocusLost

    private void DKCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DKCFocusLost
operacionesdeInspeccionMedicion();         // TODO add your handling code here:
    }//GEN-LAST:event_DKCFocusLost

    private void EP1MAXFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EP1MAXFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_EP1MAXFocusLost

    private void EP2MAXFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EP2MAXFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_EP2MAXFocusLost

    private void EP3MAXFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EP3MAXFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_EP3MAXFocusLost

    private void EP1MEDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EP1MEDFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_EP1MEDFocusLost

    private void EP2MEDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EP2MEDFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_EP2MEDFocusLost

    private void EP3MEDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EP3MEDFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_EP3MEDFocusLost

    private void EP1MINFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EP1MINFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_EP1MINFocusLost

    private void EP2MINFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EP2MINFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_EP2MINFocusLost

    private void EP3MINFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EP3MINFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_EP3MINFocusLost

    private void ETMAXP1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ETMAXP1FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_ETMAXP1FocusLost

    private void ETMAXP2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ETMAXP2FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_ETMAXP2FocusLost

    private void ETMAXP3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ETMAXP3FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_ETMAXP3FocusLost

    private void ETMEDP1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ETMEDP1FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_ETMEDP1FocusLost

    private void ETMEDP2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ETMEDP2FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_ETMEDP2FocusLost

    private void ETMEDP3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ETMEDP3FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_ETMEDP3FocusLost

    private void ETMINP1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ETMINP1FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_ETMINP1FocusLost

    private void ETMINP2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ETMINP2FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_ETMINP2FocusLost

    private void ETMINP3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ETMINP3FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_ETMINP3FocusLost

    private void EV20FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EV20FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_EV20FocusLost

    private void EKCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EKCFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_EKCFocusLost

    private void FP1MAXFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FP1MAXFocusLost
    operacionesdeInspeccionMedicion();    // TODO add your handling code here:
    }//GEN-LAST:event_FP1MAXFocusLost

    private void FP2MAXFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FP2MAXFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_FP2MAXFocusLost

    private void FP3MAXFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FP3MAXFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_FP3MAXFocusLost

    private void FP1MEDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FP1MEDFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_FP1MEDFocusLost

    private void FP2MEDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FP2MEDFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_FP2MEDFocusLost

    private void FP3MEDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FP3MEDFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_FP3MEDFocusLost

    private void FP1MINFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FP1MINFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_FP1MINFocusLost

    private void FP2MINFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FP2MINFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_FP2MINFocusLost

    private void FP3MINFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FP3MINFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_FP3MINFocusLost

    private void FTMAXP1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FTMAXP1FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_FTMAXP1FocusLost

    private void FTMAXP2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FTMAXP2FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_FTMAXP2FocusLost

    private void FTMAXP3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FTMAXP3FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_FTMAXP3FocusLost

    private void FTMEDP1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FTMEDP1FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_FTMEDP1FocusLost

    private void FTMEDP2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FTMEDP2FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_FTMEDP2FocusLost

    private void FTMEDP3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FTMEDP3FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_FTMEDP3FocusLost

    private void FTMINP1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FTMINP1FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_FTMINP1FocusLost

    private void FTMINP2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FTMINP2FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_FTMINP2FocusLost

    private void FTMINP3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FTMINP3FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_FTMINP3FocusLost

    private void FV20FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FV20FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_FV20FocusLost

    private void FKCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FKCFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_FKCFocusLost

    private void AI1MAXFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AI1MAXFocusLost
    operacionesdeInspeccionMedicion();    // TODO add your handling code here:
    }//GEN-LAST:event_AI1MAXFocusLost

    private void AI2MAXFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AI2MAXFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_AI2MAXFocusLost

    private void AI3MAXFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AI3MAXFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_AI3MAXFocusLost

    private void AI1MEDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AI1MEDFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_AI1MEDFocusLost

    private void AI2MEDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AI2MEDFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_AI2MEDFocusLost

    private void AI3MEDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AI3MEDFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_AI3MEDFocusLost

    private void AI1MINFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AI1MINFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_AI1MINFocusLost

    private void AI2MINFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AI2MINFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_AI2MINFocusLost

    private void AI3MINFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AI3MINFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_AI3MINFocusLost

    private void BI1MAXFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BI1MAXFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_BI1MAXFocusLost

    private void BI2MAXFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BI2MAXFocusLost
operacionesdeInspeccionMedicion();operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_BI2MAXFocusLost

    private void BI3MAXFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BI3MAXFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_BI3MAXFocusLost

    private void BI1MEDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BI1MEDFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_BI1MEDFocusLost

    private void BI2MEDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BI2MEDFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_BI2MEDFocusLost

    private void BI3MEDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BI3MEDFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_BI3MEDFocusLost

    private void BI1MINFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BI1MINFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_BI1MINFocusLost

    private void BI2MINFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BI2MINFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_BI2MINFocusLost

    private void BI3MINFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BI3MINFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_BI3MINFocusLost

    private void CI1MAXFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CI1MAXFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_CI1MAXFocusLost

    private void CI2MAXFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CI2MAXFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_CI2MAXFocusLost

    private void CI3MAXFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CI3MAXFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_CI3MAXFocusLost

    private void CI1MEDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CI1MEDFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_CI1MEDFocusLost

    private void CI2MEDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CI2MEDFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_CI2MEDFocusLost

    private void CI3MEDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CI3MEDFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_CI3MEDFocusLost

    private void CI1MINFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CI1MINFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_CI1MINFocusLost

    private void CI2MINFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CI2MINFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_CI2MINFocusLost

    private void CI3MINFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CI3MINFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_CI3MINFocusLost

    private void DI1MAXFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DI1MAXFocusLost
   operacionesdeInspeccionMedicion();     // TODO add your handling code here:
    }//GEN-LAST:event_DI1MAXFocusLost

    private void DI2MAXFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DI2MAXFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_DI2MAXFocusLost

    private void DI3MAXFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DI3MAXFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_DI3MAXFocusLost

    private void DI1MEDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DI1MEDFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_DI1MEDFocusLost

    private void DI2MEDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DI2MEDFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_DI2MEDFocusLost

    private void DI3MEDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DI3MEDFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_DI3MEDFocusLost

    private void DI1MINFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DI1MINFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_DI1MINFocusLost

    private void DI2MINFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DI2MINFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_DI2MINFocusLost

    private void DI3MINFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DI3MINFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_DI3MINFocusLost

    private void EI1MAXFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EI1MAXFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_EI1MAXFocusLost

    private void EI2MAXFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EI2MAXFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_EI2MAXFocusLost

    private void EI3MAXFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EI3MAXFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_EI3MAXFocusLost

    private void EI1MEDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EI1MEDFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_EI1MEDFocusLost

    private void EI2MEDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EI2MEDFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_EI2MEDFocusLost

    private void EI3MEDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EI3MEDFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_EI3MEDFocusLost

    private void EI1MINFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EI1MINFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_EI1MINFocusLost

    private void EI2MINFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EI2MINFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_EI2MINFocusLost

    private void EI3MINFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EI3MINFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_EI3MINFocusLost

    private void FI1MAXFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FI1MAXFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_FI1MAXFocusLost

    private void FI2MAXFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FI2MAXFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_FI2MAXFocusLost

    private void FI3MAXFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FI3MAXFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_FI3MAXFocusLost

    private void FI1MEDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FI1MEDFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_FI1MEDFocusLost

    private void FI2MEDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FI2MEDFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_FI2MEDFocusLost

    private void FI3MEDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FI3MEDFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_FI3MEDFocusLost

    private void FI1MINFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FI1MINFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_FI1MINFocusLost

    private void FI2MINFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FI2MINFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_FI2MINFocusLost

    private void FI3MINFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FI3MINFocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_FI3MINFocusLost

    private void ATIMAX1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ATIMAX1FocusLost
  operacionesdeInspeccionMedicion();      // TODO add your handling code here:
    }//GEN-LAST:event_ATIMAX1FocusLost

    private void ATIMAX2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ATIMAX2FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_ATIMAX2FocusLost

    private void ATIMAX3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ATIMAX3FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_ATIMAX3FocusLost

    private void ATIMED1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ATIMED1FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_ATIMED1FocusLost

    private void ATIMED2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ATIMED2FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_ATIMED2FocusLost

    private void ATIMED3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ATIMED3FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_ATIMED3FocusLost

    private void ATIMIN1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ATIMIN1FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_ATIMIN1FocusLost

    private void ATIMIN2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ATIMIN2FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_ATIMIN2FocusLost

    private void ATIMIN3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ATIMIN3FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_ATIMIN3FocusLost

    private void BTIMAX1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BTIMAX1FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_BTIMAX1FocusLost

    private void BTIMAX2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BTIMAX2FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_BTIMAX2FocusLost

    private void BTIMAX3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BTIMAX3FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_BTIMAX3FocusLost

    private void BTIMED1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BTIMED1FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_BTIMED1FocusLost

    private void BTIMED2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BTIMED2FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_BTIMED2FocusLost

    private void BTIMED3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BTIMED3FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_BTIMED3FocusLost

    private void BTIMIN1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BTIMIN1FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_BTIMIN1FocusLost

    private void BTIMIN2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BTIMIN2FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_BTIMIN2FocusLost

    private void BTIMIN3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BTIMIN3FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_BTIMIN3FocusLost

    private void CTIMAX1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CTIMAX1FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_CTIMAX1FocusLost

    private void CTIMAX2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CTIMAX2FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_CTIMAX2FocusLost

    private void CTIMAX3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CTIMAX3FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_CTIMAX3FocusLost

    private void CTIMED1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CTIMED1FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_CTIMED1FocusLost

    private void CTIMED2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CTIMED2FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_CTIMED2FocusLost

    private void CTIMED3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CTIMED3FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_CTIMED3FocusLost

    private void CTIMIN1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CTIMIN1FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_CTIMIN1FocusLost

    private void CTIMIN2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CTIMIN2FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_CTIMIN2FocusLost

    private void CTIMIN3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CTIMIN3FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_CTIMIN3FocusLost

    private void DTIMAX1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DTIMAX1FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_DTIMAX1FocusLost

    private void DTIMAX2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DTIMAX2FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_DTIMAX2FocusLost

    private void DTIMAX3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DTIMAX3FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_DTIMAX3FocusLost

    private void DTIMED1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DTIMED1FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_DTIMED1FocusLost

    private void DTIMED2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DTIMED2FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_DTIMED2FocusLost

    private void DTIMED3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DTIMED3FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_DTIMED3FocusLost

    private void DTIMIN1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DTIMIN1FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_DTIMIN1FocusLost

    private void DTIMIN2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DTIMIN2FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_DTIMIN2FocusLost

    private void DTIMIN3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DTIMIN3FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_DTIMIN3FocusLost

    private void ETIMAX1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ETIMAX1FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_ETIMAX1FocusLost

    private void ETIMAX2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ETIMAX2FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_ETIMAX2FocusLost

    private void ETIMAX3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ETIMAX3FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_ETIMAX3FocusLost

    private void ETIMED1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ETIMED1FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_ETIMED1FocusLost

    private void ETIMED2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ETIMED2FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_ETIMED2FocusLost

    private void ETIMED3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ETIMED3FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_ETIMED3FocusLost

    private void ETIMIN1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ETIMIN1FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_ETIMIN1FocusLost

    private void ETIMIN2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ETIMIN2FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_ETIMIN2FocusLost

    private void ETIMIN3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ETIMIN3FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_ETIMIN3FocusLost

    private void FTIMAX1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FTIMAX1FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_FTIMAX1FocusLost

    private void FTIMAX2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FTIMAX2FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_FTIMAX2FocusLost

    private void FTIMAX3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FTIMAX3FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_FTIMAX3FocusLost

    private void FTIMED1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FTIMED1FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_FTIMED1FocusLost

    private void FTIMED2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FTIMED2FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_FTIMED2FocusLost

    private void FTIMED3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FTIMED3FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_FTIMED3FocusLost

    private void FTIMIN1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FTIMIN1FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_FTIMIN1FocusLost

    private void FTIMIN2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FTIMIN2FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_FTIMIN2FocusLost

    private void FTIMIN3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FTIMIN3FocusLost
operacionesdeInspeccionMedicion();        // TODO add your handling code here:
    }//GEN-LAST:event_FTIMIN3FocusLost

    private void jComboBoxTermometroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTermometroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTermometroActionPerformed

    private void jComboBoxJarraAItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxJarraAItemStateChanged
        Date dateNow = new Date();
        Date dateCalibA = new Date();
        SimpleDateFormat formFecha = new SimpleDateFormat("dd/MM/yyyy");
        
        lbd.openConnection();
        List <String> listaAux = lbd.obtenerJarrasId(1,(String) evt.getItem());
        
        AV20.setText(listaAux.get(0).toString());
        AKC.setText(listaAux.get(1).toString());        
        FechaCal_A.setText(listaAux.get(2).toString());
        InfCal_A.setText(listaAux.get(3).toString());
        lbd.closeConnection();
        
        String fechaCalibA = listaAux.get(2).toString();
        System.out.println("Fecha A: "+fechaCalibA);
        dateCalibA =  lbtc.fechaFormato(fechaCalibA);
        System.out.println("Fecha calibración A: "+formFecha.format(dateCalibA));    
        System.out.println("Fecha actual: "+formFecha.format(dateNow));
        
        if(jComboBoxJarraA.getSelectedItem().equals(evt.getItem())){
            long diff = dateCalibA.getTime() - dateNow.getTime();
            TimeUnit time = TimeUnit.DAYS; 
            long diferencia = time.convert(diff, TimeUnit.MILLISECONDS);        
            System.out.println("Diferencia en días de la calibración Manguera A: " + diferencia);
            if(diferencia >= 1 && diferencia <= 90){
                avisoLabelA.setText("*La jarra está por caducar*");
            }else if(diferencia <= 0){
                JOptionPane.showMessageDialog(null, "¡La jarra ya ha caducado!");
                avisoLabelA.setText("");
            }            
        }
        
    }//GEN-LAST:event_jComboBoxJarraAItemStateChanged

    private void jComboBoxJarraAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxJarraAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxJarraAActionPerformed

    private void FechaCal_AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FechaCal_AActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FechaCal_AActionPerformed

    private void jComboBoxJarraBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxJarraBItemStateChanged
        Date dateNow = new Date();
        Date dateCalibB = new Date();
        SimpleDateFormat formFecha = new SimpleDateFormat("dd/MM/yyyy");
                
        lbd.openConnection();
        List <String> listaAux = lbd.obtenerJarrasId(1,(String) evt.getItem());
        
        //System.out.println((String) evt.getItem());
        //System.out.println(listaAux.toString());
        
        BV20.setText(listaAux.get(0).toString());
        BKC.setText(listaAux.get(1).toString());        
        FechaCal_B.setText(listaAux.get(2).toString());
        InfCal_B.setText(listaAux.get(3).toString());
        
        lbd.closeConnection();
        
        String fechaCalibB = listaAux.get(2).toString();
        System.out.println("Fecha B: "+fechaCalibB);
        dateCalibB =  lbtc.fechaFormato(fechaCalibB);
        System.out.println("Fecha calibración B: "+formFecha.format(dateCalibB));    
        System.out.println("Fecha actual: "+formFecha.format(dateNow));
        
        if(jComboBoxJarraB.getSelectedItem().equals(evt.getItem())){
            long diff = dateCalibB.getTime() - dateNow.getTime();
            TimeUnit time = TimeUnit.DAYS; 
            long diferencia = time.convert(diff, TimeUnit.MILLISECONDS);        
            System.out.println("Diferencia en días de la calibración Manguera B: " + diferencia);
            if(diferencia >= 1 && diferencia <= 90){
                avisoLabelB.setText("*La jarra está por caducar*");
            }else if(diferencia <= 0){
                JOptionPane.showMessageDialog(null, "¡La jarra ya ha caducado!");
                avisoLabelB.setText("");
            }            
        }
        
    }//GEN-LAST:event_jComboBoxJarraBItemStateChanged

    private void jComboBoxJarraCItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxJarraCItemStateChanged
        Date dateNow = new Date();
        Date dateCalibC = new Date();
        SimpleDateFormat formFecha = new SimpleDateFormat("dd/MM/yyyy");        
        lbd.openConnection();
        List <String> listaAux = lbd.obtenerJarrasId(1,(String) evt.getItem());
        
        //System.out.println((String) evt.getItem());
        //System.out.println(listaAux.toString());
        
        CV20.setText(listaAux.get(0).toString());
        CKC.setText(listaAux.get(1).toString());        
        FechaCal_C.setText(listaAux.get(2).toString());
        InfCal_C.setText(listaAux.get(3).toString());
        
        lbd.closeConnection();  
        String fechaCalibC = listaAux.get(2).toString();
        System.out.println("Fecha C: "+fechaCalibC);
        dateCalibC =  lbtc.fechaFormato(fechaCalibC);
        System.out.println("Fecha calibración C: "+formFecha.format(dateCalibC));    
        System.out.println("Fecha actual: "+formFecha.format(dateNow));
        
        if(jComboBoxJarraC.getSelectedItem().equals(evt.getItem())){
            long diff = dateCalibC.getTime() - dateNow.getTime();
            TimeUnit time = TimeUnit.DAYS; 
            long diferencia = time.convert(diff, TimeUnit.MILLISECONDS);        
            System.out.println("Diferencia en días de la calibración Manguera C: " + diferencia);
            if(diferencia >= 1 && diferencia <= 90){
                avisoLabelC.setText("*La jarra está por caducar*");
            }else if(diferencia <= 0){
                JOptionPane.showMessageDialog(null, "¡La jarra ya ha caducado!");
                avisoLabelC.setText("");
            }            
        }        
    }//GEN-LAST:event_jComboBoxJarraCItemStateChanged

    private void jComboBoxJarraDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxJarraDItemStateChanged
        Date dateNow = new Date();
        Date dateCalibD = new Date();
        SimpleDateFormat formFecha = new SimpleDateFormat("dd/MM/yyyy");         
        lbd.openConnection();
        List <String> listaAux = lbd.obtenerJarrasId(1,(String) evt.getItem());
        
        //System.out.println((String) evt.getItem());
        //System.out.println(listaAux.toString());
        
        DV20.setText(listaAux.get(0).toString());
        DKC.setText(listaAux.get(1).toString());        
        FechaCal_D.setText(listaAux.get(2).toString());
        InfCal_D.setText(listaAux.get(3).toString());
        
        lbd.closeConnection();
        String fechaCalibD = listaAux.get(2).toString();
        System.out.println("Fecha D: "+fechaCalibD);
        dateCalibD =  lbtc.fechaFormato(fechaCalibD);
        System.out.println("Fecha calibración D: "+formFecha.format(dateCalibD));    
        System.out.println("Fecha actual: "+formFecha.format(dateNow));
        
        if(jComboBoxJarraD.getSelectedItem().equals(evt.getItem())){
            long diff = dateCalibD.getTime() - dateNow.getTime();
            TimeUnit time = TimeUnit.DAYS; 
            long diferencia = time.convert(diff, TimeUnit.MILLISECONDS);        
            System.out.println("Diferencia en días de la calibración Manguera D: " + diferencia);
            if(diferencia >= 1 && diferencia <= 90){
                avisoLabelD.setText("*La jarra está por caducar*");
            }else if(diferencia <= 0){
                JOptionPane.showMessageDialog(null, "¡La jarra ya ha caducado!");
                avisoLabelD.setText("");
            }            
        }        
    }//GEN-LAST:event_jComboBoxJarraDItemStateChanged

    private void jComboBoxJarraEItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxJarraEItemStateChanged
        Date dateNow = new Date();
        Date dateCalibE = new Date();
        SimpleDateFormat formFecha = new SimpleDateFormat("dd/MM/yyyy");         
        lbd.openConnection();
        List <String> listaAux = lbd.obtenerJarrasId(1,(String) evt.getItem());
        
        //System.out.println((String) evt.getItem());
        //System.out.println(listaAux.toString());
        
        EV20.setText(listaAux.get(0).toString());
        EKC.setText(listaAux.get(1).toString());        
        FechaCal_E.setText(listaAux.get(2).toString());
        InfCal_E.setText(listaAux.get(3).toString());
        
        lbd.closeConnection();
        String fechaCalibE = listaAux.get(2).toString();
        System.out.println("Fecha E: "+fechaCalibE);
        dateCalibE =  lbtc.fechaFormato(fechaCalibE);
        System.out.println("Fecha calibración E: "+formFecha.format(dateCalibE));    
        System.out.println("Fecha actual: "+formFecha.format(dateNow));
        
        if(jComboBoxJarraE.getSelectedItem().equals(evt.getItem())){
            long diff = dateCalibE.getTime() - dateNow.getTime();
            TimeUnit time = TimeUnit.DAYS; 
            long diferencia = time.convert(diff, TimeUnit.MILLISECONDS);        
            System.out.println("Diferencia en días de la calibración Manguera E: " + diferencia);
            if(diferencia >= 1 && diferencia <= 90){
                avisoLabelE.setText("*La jarra está por caducar*");
            }else if(diferencia <= 0){
                JOptionPane.showMessageDialog(null, "¡La jarra ya ha caducado!");
                avisoLabelE.setText("");
            }            
        }        
    }//GEN-LAST:event_jComboBoxJarraEItemStateChanged

    private void jComboBoxJarraFItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxJarraFItemStateChanged
        Date dateNow = new Date();
        Date dateCalibF = new Date();
        SimpleDateFormat formFecha = new SimpleDateFormat("dd/MM/yyyy");          
        lbd.openConnection();
        List <String> listaAux = lbd.obtenerJarrasId(1,(String) evt.getItem());
        
        //System.out.println((String) evt.getItem());
        //System.out.println(listaAux.toString());
        
        FV20.setText(listaAux.get(0).toString());
        FKC.setText(listaAux.get(1).toString());        
        FechaCal_F.setText(listaAux.get(2).toString());
        InfCal_F.setText(listaAux.get(3).toString());
        
        lbd.closeConnection();
        String fechaCalibF = listaAux.get(2).toString();
        System.out.println("Fecha F: "+fechaCalibF);
        dateCalibF =  lbtc.fechaFormato(fechaCalibF);
        System.out.println("Fecha calibración F: "+formFecha.format(dateCalibF));    
        System.out.println("Fecha actual: "+formFecha.format(dateNow));
        
        if(jComboBoxJarraF.getSelectedItem().equals(evt.getItem())){
            long diff = dateCalibF.getTime() - dateNow.getTime();
            TimeUnit time = TimeUnit.DAYS; 
            long diferencia = time.convert(diff, TimeUnit.MILLISECONDS);        
            System.out.println("Diferencia en días de la calibración Manguera F: " + diferencia);
            if(diferencia >= 1 && diferencia <= 90){
                avisoLabelF.setText("*La jarra está por caducar*");
            }else if(diferencia <= 0){
                JOptionPane.showMessageDialog(null, "¡La jarra ya ha caducado!");
                avisoLabelF.setText("");
            }            
        }        
    }//GEN-LAST:event_jComboBoxJarraFItemStateChanged

    private void etiquetaIncluirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_etiquetaIncluirKeyPressed
//         TODO add your handling code here:
//        JOptionPane.showMessageDialog(null, "El proyecto ya paso");
    }//GEN-LAST:event_etiquetaIncluirKeyPressed

    private void etiquetaIncluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_etiquetaIncluirMouseClicked
//         TODO add your handling code here:
//        JOptionPane.showMessageDialog(null, "El proyecto ya paso");
    }//GEN-LAST:event_etiquetaIncluirMouseClicked

    private void botonIncluirMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIncluirMAActionPerformed
        // TODO add your handling code here:
        if( botonIncluirMA.getText().equals("Incluir")){
           incluirA = 1;
           botonIncluirMA.setText("No Incluir");
        }
        else{
           incluirA = 0;
           botonIncluirMA.setText("Incluir");
        }
    }//GEN-LAST:event_botonIncluirMAActionPerformed

    private void botonIncluirMBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIncluirMBActionPerformed
        // TODO add your handling code here:
        if( botonIncluirMB.getText().equals("Incluir")){
           incluirB = 1;
           botonIncluirMB.setText("No Incluir");
        }
        else{
            incluirB = 0;
           botonIncluirMB.setText("Incluir");
        }
    }//GEN-LAST:event_botonIncluirMBActionPerformed

    private void botonIncluirMCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIncluirMCActionPerformed
        // TODO add your handling code here:
        if( botonIncluirMC.getText().equals("Incluir")){
            incluirC = 1;
           botonIncluirMC.setText("No Incluir");
        }
        else{
            incluirC = 0;
           botonIncluirMC.setText("Incluir");
        }
    }//GEN-LAST:event_botonIncluirMCActionPerformed

    private void botonIncluirMDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIncluirMDActionPerformed
        // TODO add your handling code here:
        if( botonIncluirMD.getText().equals("Incluir")){
            incluirD = 1;
           botonIncluirMD.setText("No Incluir");
        }
        else{
           incluirD = 0;
           botonIncluirMD.setText("Incluir");
        }
        
    }//GEN-LAST:event_botonIncluirMDActionPerformed

    private void botonIncluirMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIncluirMEActionPerformed
        // TODO add your handling code here:
        if( botonIncluirME.getText().equals("Incluir")){
            incluirE = 1;
           botonIncluirME.setText("No Incluir");
        }
        else{
             incluirE = 0;
           botonIncluirME.setText("Incluir");
        }
    }//GEN-LAST:event_botonIncluirMEActionPerformed

    private void botonIncluirMFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIncluirMFActionPerformed
        // TODO add your handling code here:
        if( botonIncluirMF.getText().equals("Incluir")){
             incluirF = 1;
           botonIncluirMF.setText("No Incluir");
        }
        else{
           incluirF = 0;
           botonIncluirMF.setText("Incluir");
        }
    }//GEN-LAST:event_botonIncluirMFActionPerformed

    private void datosTermometroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datosTermometroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_datosTermometroActionPerformed

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
    private javax.swing.JTextField AEMAX;
    private javax.swing.JTextField AEMED;
    private javax.swing.JTextField AEMIN;
    private javax.swing.JTextField AI1MAX;
    private javax.swing.JTextField AI1MED;
    private javax.swing.JTextField AI1MIN;
    private javax.swing.JTextField AI2MAX;
    private javax.swing.JTextField AI2MED;
    private javax.swing.JTextField AI2MIN;
    private javax.swing.JTextField AI3MAX;
    private javax.swing.JTextField AI3MED;
    private javax.swing.JTextField AI3MIN;
    private javax.swing.JTextField AI4MAX;
    private javax.swing.JTextField AI4MED;
    private javax.swing.JTextField AI4MIN;
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
    private javax.swing.JTextField AQVMAX;
    private javax.swing.JTextField AQVMED;
    private javax.swing.JTextField AQVMIN;
    private javax.swing.JTextField ATIMAX1;
    private javax.swing.JTextField ATIMAX2;
    private javax.swing.JTextField ATIMAX3;
    private javax.swing.JTextField ATIMED1;
    private javax.swing.JTextField ATIMED2;
    private javax.swing.JTextField ATIMED3;
    private javax.swing.JTextField ATIMIN1;
    private javax.swing.JTextField ATIMIN2;
    private javax.swing.JTextField ATIMIN3;
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
    private javax.swing.JTextField BEMAX;
    private javax.swing.JTextField BEMED;
    private javax.swing.JTextField BEMIN;
    private javax.swing.JTextField BI1MAX;
    private javax.swing.JTextField BI1MED;
    private javax.swing.JTextField BI1MIN;
    private javax.swing.JTextField BI2MAX;
    private javax.swing.JTextField BI2MED;
    private javax.swing.JTextField BI2MIN;
    private javax.swing.JTextField BI3MAX;
    private javax.swing.JTextField BI3MED;
    private javax.swing.JTextField BI3MIN;
    private javax.swing.JTextField BI4MAX;
    private javax.swing.JTextField BI4MED;
    private javax.swing.JTextField BI4MIN;
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
    private javax.swing.JTextField BQVMAX;
    private javax.swing.JTextField BQVMED;
    private javax.swing.JTextField BQVMIN;
    private javax.swing.JTextField BTIMAX1;
    private javax.swing.JTextField BTIMAX2;
    private javax.swing.JTextField BTIMAX3;
    private javax.swing.JTextField BTIMED1;
    private javax.swing.JTextField BTIMED2;
    private javax.swing.JTextField BTIMED3;
    private javax.swing.JTextField BTIMIN1;
    private javax.swing.JTextField BTIMIN2;
    private javax.swing.JTextField BTIMIN3;
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
    private javax.swing.JTextField CEMAX;
    private javax.swing.JTextField CEMED;
    private javax.swing.JTextField CEMIN;
    private javax.swing.JTextField CI1MAX;
    private javax.swing.JTextField CI1MED;
    private javax.swing.JTextField CI1MIN;
    private javax.swing.JTextField CI2MAX;
    private javax.swing.JTextField CI2MED;
    private javax.swing.JTextField CI2MIN;
    private javax.swing.JTextField CI3MAX;
    private javax.swing.JTextField CI3MED;
    private javax.swing.JTextField CI3MIN;
    private javax.swing.JTextField CI4MAX;
    private javax.swing.JTextField CI4MED;
    private javax.swing.JTextField CI4MIN;
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
    private javax.swing.JTextField CQVMAX;
    private javax.swing.JTextField CQVMED;
    private javax.swing.JTextField CQVMIN;
    private javax.swing.JTextField CTIMAX1;
    private javax.swing.JTextField CTIMAX2;
    private javax.swing.JTextField CTIMAX3;
    private javax.swing.JTextField CTIMED1;
    private javax.swing.JTextField CTIMED2;
    private javax.swing.JTextField CTIMED3;
    private javax.swing.JTextField CTIMIN1;
    private javax.swing.JTextField CTIMIN2;
    private javax.swing.JTextField CTIMIN3;
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
    private javax.swing.JTextField DEMAX;
    private javax.swing.JTextField DEMED;
    private javax.swing.JTextField DEMIN;
    private javax.swing.JTextField DI1MAX;
    private javax.swing.JTextField DI1MED;
    private javax.swing.JTextField DI1MIN;
    private javax.swing.JTextField DI2MAX;
    private javax.swing.JTextField DI2MED;
    private javax.swing.JTextField DI2MIN;
    private javax.swing.JTextField DI3MAX;
    private javax.swing.JTextField DI3MED;
    private javax.swing.JTextField DI3MIN;
    private javax.swing.JTextField DI4MAX;
    private javax.swing.JTextField DI4MED;
    private javax.swing.JTextField DI4MIN;
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
    private javax.swing.JTextField DQVMAX;
    private javax.swing.JTextField DQVMED;
    private javax.swing.JTextField DQVMIN;
    private javax.swing.JTextField DTIMAX1;
    private javax.swing.JTextField DTIMAX2;
    private javax.swing.JTextField DTIMAX3;
    private javax.swing.JTextField DTIMED1;
    private javax.swing.JTextField DTIMED2;
    private javax.swing.JTextField DTIMED3;
    private javax.swing.JTextField DTIMIN1;
    private javax.swing.JTextField DTIMIN2;
    private javax.swing.JTextField DTIMIN3;
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
    private javax.swing.JTextField EEMAX;
    private javax.swing.JTextField EEMED;
    private javax.swing.JTextField EEMIN;
    private javax.swing.JTextField EI1MAX;
    private javax.swing.JTextField EI1MED;
    private javax.swing.JTextField EI1MIN;
    private javax.swing.JTextField EI2MAX;
    private javax.swing.JTextField EI2MED;
    private javax.swing.JTextField EI2MIN;
    private javax.swing.JTextField EI3MAX;
    private javax.swing.JTextField EI3MED;
    private javax.swing.JTextField EI3MIN;
    private javax.swing.JTextField EI4MAX;
    private javax.swing.JTextField EI4MED;
    private javax.swing.JTextField EI4MIN;
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
    private javax.swing.JTextField EQVMAX;
    private javax.swing.JTextField EQVMED;
    private javax.swing.JTextField EQVMIN;
    private javax.swing.JTextField ETIMAX1;
    private javax.swing.JTextField ETIMAX2;
    private javax.swing.JTextField ETIMAX3;
    private javax.swing.JTextField ETIMED1;
    private javax.swing.JTextField ETIMED2;
    private javax.swing.JTextField ETIMED3;
    private javax.swing.JTextField ETIMIN1;
    private javax.swing.JTextField ETIMIN2;
    private javax.swing.JTextField ETIMIN3;
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
    private javax.swing.JTextField FEMAX;
    private javax.swing.JTextField FEMED;
    private javax.swing.JTextField FEMIN;
    private javax.swing.JTextField FI1MAX;
    private javax.swing.JTextField FI1MED;
    private javax.swing.JTextField FI1MIN;
    private javax.swing.JTextField FI2MAX;
    private javax.swing.JTextField FI2MED;
    private javax.swing.JTextField FI2MIN;
    private javax.swing.JTextField FI3MAX;
    private javax.swing.JTextField FI3MED;
    private javax.swing.JTextField FI3MIN;
    private javax.swing.JTextField FI4MAX;
    private javax.swing.JTextField FI4MED;
    private javax.swing.JTextField FI4MIN;
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
    private javax.swing.JTextField FQVMAX;
    private javax.swing.JTextField FQVMED;
    private javax.swing.JTextField FQVMIN;
    private javax.swing.JTextField FTIMAX1;
    private javax.swing.JTextField FTIMAX2;
    private javax.swing.JTextField FTIMAX3;
    private javax.swing.JTextField FTIMED1;
    private javax.swing.JTextField FTIMED2;
    private javax.swing.JTextField FTIMED3;
    private javax.swing.JTextField FTIMIN1;
    private javax.swing.JTextField FTIMIN2;
    private javax.swing.JTextField FTIMIN3;
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
    private javax.swing.JTextField FechaCal_A;
    private javax.swing.JTextField FechaCal_B;
    private javax.swing.JTextField FechaCal_C;
    private javax.swing.JTextField FechaCal_D;
    private javax.swing.JTextField FechaCal_E;
    private javax.swing.JTextField FechaCal_F;
    private javax.swing.ButtonGroup G;
    private javax.swing.ButtonGroup H;
    private javax.swing.ButtonGroup I;
    private javax.swing.JTextField InfCal_A;
    private javax.swing.JTextField InfCal_B;
    private javax.swing.JTextField InfCal_C;
    private javax.swing.JTextField InfCal_D;
    private javax.swing.JTextField InfCal_E;
    private javax.swing.JTextField InfCal_F;
    private javax.swing.JLabel avisoLabelA;
    private javax.swing.JLabel avisoLabelB;
    private javax.swing.JLabel avisoLabelC;
    private javax.swing.JLabel avisoLabelD;
    private javax.swing.JLabel avisoLabelE;
    private javax.swing.JLabel avisoLabelF;
    private javax.swing.JButton botonIncluirMA;
    private javax.swing.JButton botonIncluirMB;
    private javax.swing.JButton botonIncluirMC;
    private javax.swing.JButton botonIncluirMD;
    private javax.swing.JButton botonIncluirME;
    private javax.swing.JButton botonIncluirMF;
    private javax.swing.JButton btnGuardarExcel;
    private javax.swing.JTextField campoEstacion;
    private javax.swing.JTextField campoInformacionEstacion;
    private javax.swing.JTextField campoPrecintoA;
    private javax.swing.JTextField campoPrecintoB;
    private javax.swing.JTextField campoPrecintoC;
    private javax.swing.JTextField campoPrecintoD;
    private javax.swing.JTextField campoPrecintoE;
    private javax.swing.JTextField campoPrecintoF;
    private javax.swing.JTextField campoTipoVerificacion;
    private javax.swing.JTextField datosCronometro;
    private javax.swing.JTextField datosTermometro;
    private javax.swing.JLabel etiquetaIncluir;
    private javax.swing.JTextField folioSolicitud;
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
    private javax.swing.JLabel jLabel328;
    private javax.swing.JLabel jLabel329;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel330;
    private javax.swing.JLabel jLabel331;
    private javax.swing.JLabel jLabel332;
    private javax.swing.JLabel jLabel333;
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
    private javax.swing.JTextField jTextField119;
    private javax.swing.JTextField jTextField120;
    private javax.swing.JTextField jTextField121;
    private javax.swing.JTextField jTextField122;
    private javax.swing.JTextField jTextField132;
    private javax.swing.JTextField jTextField133;
    private javax.swing.JTextField jTextField146;
    private javax.swing.JTextField jTextField147;
    private javax.swing.JTextField jTextField148;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField183;
    private javax.swing.JTextField jTextField184;
    private javax.swing.JTextField jTextField185;
    private javax.swing.JTextField jTextField186;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField196;
    private javax.swing.JTextField jTextField197;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField210;
    private javax.swing.JTextField jTextField211;
    private javax.swing.JTextField jTextField212;
    private javax.swing.JTextField jTextField247;
    private javax.swing.JTextField jTextField248;
    private javax.swing.JTextField jTextField249;
    private javax.swing.JTextField jTextField250;
    private javax.swing.JTextField jTextField260;
    private javax.swing.JTextField jTextField261;
    private javax.swing.JTextField jTextField274;
    private javax.swing.JTextField jTextField275;
    private javax.swing.JTextField jTextField276;
    private javax.swing.JTextField jTextField311;
    private javax.swing.JTextField jTextField312;
    private javax.swing.JTextField jTextField313;
    private javax.swing.JTextField jTextField314;
    private javax.swing.JTextField jTextField324;
    private javax.swing.JTextField jTextField325;
    private javax.swing.JTextField jTextField338;
    private javax.swing.JTextField jTextField339;
    private javax.swing.JTextField jTextField340;
    private javax.swing.JTextField jTextField375;
    private javax.swing.JTextField jTextField376;
    private javax.swing.JTextField jTextField377;
    private javax.swing.JTextField jTextField378;
    private javax.swing.JTextField jTextField388;
    private javax.swing.JTextField jTextField389;
    private javax.swing.JTextField jTextField64;
    private javax.swing.JTextField jTextField65;
    private javax.swing.JTextField jTextField66;
    private javax.swing.JTextField jTextField67;
    private javax.swing.JTextField jTextField68;
    private javax.swing.JTextField jTextField69;
    private javax.swing.JTextField jTextField82;
    private javax.swing.JTextField jTextField83;
    private javax.swing.JTextField jTextField84;
    private javax.swing.JPanel mangueraA;
    private javax.swing.JPanel mangueraA1;
    private javax.swing.JPanel mangueraA2;
    private javax.swing.JPanel mangueraA3;
    private javax.swing.JPanel mangueraA4;
    private javax.swing.JPanel mangueraA5;
    private javax.swing.JPanel verificacionVisual;
    // End of variables declaration//GEN-END:variables
}
