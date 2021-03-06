/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Dictamen;
import Controlador.LibreriaBDControlador;
import Controlador.LibreriaToolsControlador;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
/**
 *
 * @author joseluis.caamal
 */
public class catalogoDocumentoDictamen extends javax.swing.JDialog {

    /**
     * Creates new form catalogoDocumentoDictamen
     */
    LibreriaBDControlador lbd = new LibreriaBDControlador();
    LibreriaToolsControlador lbt = new LibreriaToolsControlador();
    public  String cadenaDispensario;
    public  String cadenaDispensarioA;
    public  String cadenaDispensarioB;
    public  String cadenaDispensarioC;
    public  String cadenaDispensarioD;
    public  String cadenaDispensarioE;
    public  String cadenaDispensarioF;
    private String folioDocumento;
    private String noEstacion;
    private int dispensarioActual;
    private String HorarioInicio, HorarioFin, Fecha;
    public catalogoDocumentoDictamen(java.awt.Frame parent, 
            boolean modal,int i,String noEstacion, String folioDocumento,String Fecha, String HoraInicio,String HoraFin) {
        super(parent, modal);
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Multimedia/icono_GasValid.jpg")).getImage());
        //AutoAcompletar en comboBox 13/07/2021
        //Auto Acompletar Marca
        AutoCompleteDecorator.decorate(campoMarcaA);
        AutoCompleteDecorator.decorate(campoMarcaB);
        AutoCompleteDecorator.decorate(campoMarcaC);
        AutoCompleteDecorator.decorate(campoMarcaD);
        AutoCompleteDecorator.decorate(campoMarcaE);
        AutoCompleteDecorator.decorate(campoMarcaF);
        //Auto Acompletar Serie
        AutoCompleteDecorator.decorate(campoSerieA);
        AutoCompleteDecorator.decorate(campoSerieB);
        AutoCompleteDecorator.decorate(campoSerieC);
        AutoCompleteDecorator.decorate(campoSerieD);
        AutoCompleteDecorator.decorate(campoSerieE);
        AutoCompleteDecorator.decorate(campoSerieF);
        //Auto Acompletar Modelo
        AutoCompleteDecorator.decorate(campoModeloA);
        AutoCompleteDecorator.decorate(campoModeloB);
        AutoCompleteDecorator.decorate(campoModeloC);
        AutoCompleteDecorator.decorate(campoModeloD);
        AutoCompleteDecorator.decorate(campoModeloE);
        AutoCompleteDecorator.decorate(campoModeloF);
        //Auto Acompletar Profeco
        AutoCompleteDecorator.decorate(campoProfecoA);
        AutoCompleteDecorator.decorate(campoProfecoB);
        AutoCompleteDecorator.decorate(campoProfecoC);
        AutoCompleteDecorator.decorate(campoProfecoD);
        AutoCompleteDecorator.decorate(campoProfecoE);
        AutoCompleteDecorator.decorate(campoProfecoF);
        //Auto Acompletar UVA
        AutoCompleteDecorator.decorate(campoUVAA);
        AutoCompleteDecorator.decorate(campoUVAB);
        AutoCompleteDecorator.decorate(campoUVAC);
        AutoCompleteDecorator.decorate(campoUVAD);
        AutoCompleteDecorator.decorate(campoUVAE);
        AutoCompleteDecorator.decorate(campoUVAF);
        //Auto Acompletar Precinto
        AutoCompleteDecorator.decorate(campoPrecintoA);
        AutoCompleteDecorator.decorate(campoPrecintoB);
        AutoCompleteDecorator.decorate(campoPrecintoC);
        AutoCompleteDecorator.decorate(campoPrecintoD);
        AutoCompleteDecorator.decorate(campoPrecintoE);
        AutoCompleteDecorator.decorate(campoPrecintoF);
        
      //this.dispensarioActual = i+1;
        this.folioDocumento = folioDocumento;
        this.noEstacion = noEstacion;
        this.HorarioFin = HoraFin;
        this.HorarioInicio = HoraInicio;
        this.Fecha = Fecha;
        campoFolioDictamen.setText(folioDocumento);
        campoEstacion.setText(noEstacion);
       // campoDispensario.setText(String.valueOf(i+1));
        
        //lbd.openConnection();
        List<String> marcasGasolina = lbd.obtenerMarcaGasolinaDisp(noEstacion);
        List<String> noSerieDisponibles = lbd.obtenerNumeroSerieDisponibles(noEstacion);
        List<String> noModeloDisponibles = lbd.obtenerModeloDisponibles(noEstacion);
        List<String> noHologramaUVA = lbd.obtenerHologramas(1);
        List<String> noHologramaProfeco = lbd.obtenerHologramas(2);
        
        //lbd.closeConnection();
        
        campoMarcaA.removeAllItems();
        campoMarcaB.removeAllItems();
        campoMarcaC.removeAllItems();
        campoMarcaD.removeAllItems();
        campoMarcaE.removeAllItems();
        campoMarcaF.removeAllItems();
        
        campoSerieA.removeAllItems();
        campoSerieB.removeAllItems();
        campoSerieC.removeAllItems();
        campoSerieD.removeAllItems();
        campoSerieE.removeAllItems();
        campoSerieF.removeAllItems();
        
        campoModeloA.removeAllItems();
        campoModeloB.removeAllItems();
        campoModeloC.removeAllItems();
        campoModeloD.removeAllItems();
        campoModeloE.removeAllItems();
        campoModeloF.removeAllItems();
        
        campoProfecoA.removeAllItems();
        campoProfecoB.removeAllItems();
        campoProfecoC.removeAllItems();
        campoProfecoD.removeAllItems();
        campoProfecoE.removeAllItems();
        campoProfecoF.removeAllItems();
        
        campoUVAA.removeAllItems();
        campoUVAB.removeAllItems();
        campoUVAC.removeAllItems();
        campoUVAD.removeAllItems();
        campoUVAE.removeAllItems();
        campoUVAF.removeAllItems();
        
        campoDispensario.removeAllItems();
        
        for(int u=1; u<(i+1);u++){
        campoDispensario.addItem(""+u);
        }
        
        for(i=0; i< marcasGasolina.size();i++){
           campoMarcaA.addItem(marcasGasolina.get(i));
           campoMarcaB.addItem(marcasGasolina.get(i));
           campoMarcaC.addItem(marcasGasolina.get(i));
           campoMarcaD.addItem(marcasGasolina.get(i));
           campoMarcaE.addItem(marcasGasolina.get(i));
           campoMarcaF.addItem(marcasGasolina.get(i));
        }
        
        for(i=0; i< noSerieDisponibles.size();i++){
           campoSerieA.addItem(noSerieDisponibles.get(i));
           campoSerieB.addItem(noSerieDisponibles.get(i));
           campoSerieC.addItem(noSerieDisponibles.get(i));
           campoSerieD.addItem(noSerieDisponibles.get(i));
           campoSerieE.addItem(noSerieDisponibles.get(i));
           campoSerieF.addItem(noSerieDisponibles.get(i));
        }
        
        for(i=0; i< noModeloDisponibles.size();i++){
           campoModeloA.addItem(noModeloDisponibles.get(i));
           campoModeloB.addItem(noModeloDisponibles.get(i));
           campoModeloC.addItem(noModeloDisponibles.get(i));
           campoModeloD.addItem(noModeloDisponibles.get(i));
           campoModeloE.addItem(noModeloDisponibles.get(i));
           campoModeloF.addItem(noModeloDisponibles.get(i));
        }
        
        for(i=0; i< noHologramaProfeco.size();i++){
           campoProfecoA.addItem(noHologramaProfeco.get(i));
           campoProfecoB.addItem(noHologramaProfeco.get(i));
           campoProfecoC.addItem(noHologramaProfeco.get(i));
           campoProfecoD.addItem(noHologramaProfeco.get(i));
           campoProfecoE.addItem(noHologramaProfeco.get(i));
           campoProfecoF.addItem(noHologramaProfeco.get(i));
        }
        
        for(i=0; i< noHologramaUVA.size();i++){
           campoUVAA.addItem(noHologramaUVA.get(i));
           campoUVAB.addItem(noHologramaUVA.get(i));
           campoUVAC.addItem(noHologramaUVA.get(i));
           campoUVAD.addItem(noHologramaUVA.get(i));
           campoUVAE.addItem(noHologramaUVA.get(i));
           campoUVAF.addItem(noHologramaUVA.get(i));
        }
        //campoMarcaA.addItem();
        
        
        
    }

    public String getCadenaDispensario() {
        return cadenaDispensario;
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
        jPanel15 = new javax.swing.JPanel();
        jLabel473 = new javax.swing.JLabel();
        jLabel474 = new javax.swing.JLabel();
        jLabel475 = new javax.swing.JLabel();
        jLabel476 = new javax.swing.JLabel();
        jLabel477 = new javax.swing.JLabel();
        jLabel478 = new javax.swing.JLabel();
        jLabel479 = new javax.swing.JLabel();
        jLabel480 = new javax.swing.JLabel();
        jLabel482 = new javax.swing.JLabel();
        jLabel488 = new javax.swing.JLabel();
        jLabel489 = new javax.swing.JLabel();
        jLabel490 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        campoCumpleA = new javax.swing.JCheckBox();
        campoCumpleB = new javax.swing.JCheckBox();
        campoCumpleC = new javax.swing.JCheckBox();
        campoCumpleD = new javax.swing.JCheckBox();
        campoCumpleE = new javax.swing.JCheckBox();
        campoCumpleF = new javax.swing.JCheckBox();
        campoMarcaA = new javax.swing.JComboBox<>();
        campoMarcaB = new javax.swing.JComboBox<>();
        campoMarcaC = new javax.swing.JComboBox<>();
        campoMarcaD = new javax.swing.JComboBox<>();
        campoMarcaE = new javax.swing.JComboBox<>();
        campoMarcaF = new javax.swing.JComboBox<>();
        campoSerieA = new javax.swing.JComboBox<>();
        campoSerieB = new javax.swing.JComboBox<>();
        campoSerieC = new javax.swing.JComboBox<>();
        campoSerieD = new javax.swing.JComboBox<>();
        campoSerieE = new javax.swing.JComboBox<>();
        campoSerieF = new javax.swing.JComboBox<>();
        campoProfecoA = new javax.swing.JComboBox<>();
        campoProfecoB = new javax.swing.JComboBox<>();
        campoProfecoC = new javax.swing.JComboBox<>();
        campoProfecoD = new javax.swing.JComboBox<>();
        campoProfecoE = new javax.swing.JComboBox<>();
        campoProfecoF = new javax.swing.JComboBox<>();
        campoUVAE = new javax.swing.JComboBox<>();
        campoUVAD = new javax.swing.JComboBox<>();
        campoUVAC = new javax.swing.JComboBox<>();
        campoUVAA = new javax.swing.JComboBox<>();
        campoUVAF = new javax.swing.JComboBox<>();
        campoUVAB = new javax.swing.JComboBox<>();
        jLabel491 = new javax.swing.JLabel();
        campoModeloA = new javax.swing.JComboBox<>();
        campoModeloB = new javax.swing.JComboBox<>();
        campoModeloC = new javax.swing.JComboBox<>();
        campoModeloD = new javax.swing.JComboBox<>();
        campoModeloE = new javax.swing.JComboBox<>();
        campoModeloF = new javax.swing.JComboBox<>();
        campoDispensario = new javax.swing.JComboBox<>();
        jLabel492 = new javax.swing.JLabel();
        campoPrecintoA = new javax.swing.JComboBox<>();
        campoPrecintoF = new javax.swing.JComboBox<>();
        campoPrecintoB = new javax.swing.JComboBox<>();
        campoPrecintoE = new javax.swing.JComboBox<>();
        campoPrecintoD = new javax.swing.JComboBox<>();
        campoPrecintoC = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        campoEstacion = new javax.swing.JLabel();
        botonDictamen = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        campoFolioDictamen = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel15.setBackground(new java.awt.Color(204, 255, 255));

        jLabel473.setText("A");

        jLabel474.setText("B");

        jLabel475.setText("C");

        jLabel476.setText("D");

        jLabel477.setText("E");

        jLabel478.setText("F");

        jLabel479.setText("Lado");

        jLabel480.setText("Dispensario");

        jLabel482.setText("Marca G.");

        jLabel488.setText("No. Serie");

        jLabel489.setText("H/Profeco");

        jLabel490.setText("H/UVA");

        jLabel5.setText("Estatus");

        campoCumpleA.setText("Cumple");
        campoCumpleA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCumpleAActionPerformed(evt);
            }
        });

        campoCumpleB.setText("Cumple");

        campoCumpleC.setText("Cumple");

        campoCumpleD.setText("Cumple");

        campoCumpleE.setText("Cumple");

        campoCumpleF.setText("Cumple");

        campoMarcaA.setEditable(true);
        campoMarcaA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        campoMarcaA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoMarcaAActionPerformed(evt);
            }
        });

        campoMarcaB.setEditable(true);
        campoMarcaB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        campoMarcaC.setEditable(true);
        campoMarcaC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        campoMarcaD.setEditable(true);
        campoMarcaD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        campoMarcaE.setEditable(true);
        campoMarcaE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        campoMarcaF.setEditable(true);
        campoMarcaF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        campoSerieA.setEditable(true);
        campoSerieA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        campoSerieB.setEditable(true);
        campoSerieB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        campoSerieC.setEditable(true);
        campoSerieC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        campoSerieD.setEditable(true);
        campoSerieD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        campoSerieE.setEditable(true);
        campoSerieE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        campoSerieF.setEditable(true);
        campoSerieF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        campoProfecoA.setEditable(true);
        campoProfecoA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        campoProfecoA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoProfecoAActionPerformed(evt);
            }
        });

        campoProfecoB.setEditable(true);
        campoProfecoB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        campoProfecoC.setEditable(true);
        campoProfecoC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        campoProfecoD.setEditable(true);
        campoProfecoD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        campoProfecoE.setEditable(true);
        campoProfecoE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        campoProfecoF.setEditable(true);
        campoProfecoF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        campoUVAE.setEditable(true);
        campoUVAE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        campoUVAD.setEditable(true);
        campoUVAD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        campoUVAC.setEditable(true);
        campoUVAC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        campoUVAA.setEditable(true);
        campoUVAA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        campoUVAA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoUVAAActionPerformed(evt);
            }
        });

        campoUVAF.setEditable(true);
        campoUVAF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        campoUVAB.setEditable(true);
        campoUVAB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel491.setText("Modelo");

        campoModeloA.setEditable(true);
        campoModeloA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        campoModeloB.setEditable(true);
        campoModeloB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        campoModeloC.setEditable(true);
        campoModeloC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        campoModeloD.setEditable(true);
        campoModeloD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        campoModeloE.setEditable(true);
        campoModeloE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        campoModeloF.setEditable(true);
        campoModeloF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        campoDispensario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel492.setText("Precinto");

        campoPrecintoA.setEditable(true);
        campoPrecintoA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        campoPrecintoA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoPrecintoAActionPerformed(evt);
            }
        });

        campoPrecintoF.setEditable(true);
        campoPrecintoF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        campoPrecintoB.setEditable(true);
        campoPrecintoB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        campoPrecintoE.setEditable(true);
        campoPrecintoE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        campoPrecintoE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoPrecintoEActionPerformed(evt);
            }
        });

        campoPrecintoD.setEditable(true);
        campoPrecintoD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        campoPrecintoC.setEditable(true);
        campoPrecintoC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel480)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoDispensario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel475, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                            .addComponent(jLabel476, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel477, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel478, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel474, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel473, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoMarcaA, 0, 150, Short.MAX_VALUE)
                            .addComponent(campoMarcaB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(campoMarcaC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(campoMarcaD, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(campoMarcaE, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(campoMarcaF, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel479)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel482)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(campoSerieA, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campoSerieB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campoSerieC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campoSerieD, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campoSerieE, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campoSerieF, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel488))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(campoModeloA, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campoModeloB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campoModeloC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campoModeloD, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campoModeloE, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campoModeloF, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel491))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(campoProfecoA, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campoProfecoB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campoProfecoC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campoProfecoD, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campoProfecoE, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campoProfecoF, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel489))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel490)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(campoUVAA, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campoUVAB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campoUVAC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campoUVAD, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campoUVAE, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campoUVAF, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel492)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(campoPrecintoA, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campoPrecintoB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campoPrecintoC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campoPrecintoD, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campoPrecintoE, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campoPrecintoF, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoCumpleF)
                    .addComponent(campoCumpleE)
                    .addComponent(campoCumpleD)
                    .addComponent(campoCumpleC)
                    .addComponent(campoCumpleB)
                    .addComponent(campoCumpleA)
                    .addComponent(jLabel5))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel480)
                    .addComponent(campoDispensario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel482)
                                .addComponent(jLabel479)
                                .addComponent(jLabel488)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(campoMarcaA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(campoSerieA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel15Layout.createSequentialGroup()
                                    .addComponent(campoSerieB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(campoSerieC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(campoSerieD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(campoSerieE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(campoSerieF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel15Layout.createSequentialGroup()
                                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel473)
                                        .addComponent(campoCumpleA))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel474)
                                        .addComponent(campoCumpleB)
                                        .addComponent(campoMarcaB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel475)
                                        .addComponent(campoCumpleC)
                                        .addComponent(campoMarcaC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel476)
                                        .addComponent(campoCumpleD)
                                        .addComponent(campoMarcaD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel477)
                                        .addComponent(campoCumpleE)
                                        .addComponent(campoMarcaE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel478)
                                        .addComponent(campoCumpleF)
                                        .addComponent(campoMarcaF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(1, 1, 1)))))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel491)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(campoModeloB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoModeloC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoModeloD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoModeloE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoModeloF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(campoModeloA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel489)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoProfecoA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(campoProfecoB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoProfecoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoProfecoD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoProfecoE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoProfecoF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(jLabel490)
                                        .addGap(18, 18, 18))
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(jLabel492)
                                        .addGap(18, 18, 18)))
                                .addComponent(campoUVAA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(campoUVAB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoUVAC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoUVAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoUVAE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoUVAF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(1, 1, 1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addComponent(campoPrecintoA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(campoPrecintoB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoPrecintoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoPrecintoD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoPrecintoE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoPrecintoF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("No. CRE:");

        campoEstacion.setText("jLabel3");

        botonDictamen.setText("Guardar");
        botonDictamen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDictamenActionPerformed(evt);
            }
        });

        jLabel4.setText("Folio Dictamen:");

        campoFolioDictamen.setText("jLabel3");

        jButton1.setText("Terminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(campoEstacion)
                                        .addGap(97, 97, 97)
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(campoFolioDictamen))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(464, 464, 464)
                                .addComponent(botonDictamen, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoEstacion)
                    .addComponent(jLabel4)
                    .addComponent(campoFolioDictamen))
                .addGap(18, 18, 18)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonDictamen)
                    .addComponent(jButton1))
                .addContainerGap())
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonDictamenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDictamenActionPerformed
        // TODO add your handling code here:
        
        String miDispensarioActual=(String) campoDispensario.getSelectedItem();
        System.out.println("Dispensario " +miDispensarioActual);
        dispensarioActual=Integer.parseInt(miDispensarioActual);

        String campoMarcaADocumento = (String) campoMarcaA.getSelectedItem();
        String campoMarcaBDocumento = (String) campoMarcaB.getSelectedItem();
        String campoMarcaCDocumento = (String) campoMarcaC.getSelectedItem();
        String campoMarcaDDocumento = (String) campoMarcaD.getSelectedItem();
        String campoMarcaEDocumento = (String) campoMarcaE.getSelectedItem();
        String campoMarcaFDocumento = (String) campoMarcaF.getSelectedItem();
        
        String campoSerieADocumento = (String) campoSerieA.getSelectedItem();
        String campoSerieBDocumento = (String) campoSerieB.getSelectedItem();
        String campoSerieCDocumento = (String) campoSerieC.getSelectedItem();
        String campoSerieDDocumento = (String) campoSerieD.getSelectedItem();
        String campoSerieEDocumento = (String) campoSerieE.getSelectedItem();
        String campoSerieFDocumento = (String) campoSerieF.getSelectedItem();
        
        String campoModeloADocumento = (String) campoModeloA.getSelectedItem();
        String campoModeloBDocumento = (String) campoModeloB.getSelectedItem();
        String campoModeloCDocumento = (String) campoModeloC.getSelectedItem();
        String campoModeloDDocumento = (String) campoModeloD.getSelectedItem();
        String campoModeloEDocumento = (String) campoModeloE.getSelectedItem();
        String campoModeloFDocumento = (String) campoModeloF.getSelectedItem();
        
        String campoProfecoADocumento = (String) campoProfecoA.getSelectedItem();
        String campoProfecoBDocumento = (String) campoProfecoB.getSelectedItem();
        String campoProfecoCDocumento = (String) campoProfecoC.getSelectedItem();
        String campoProfecoDDocumento = (String) campoProfecoD.getSelectedItem();
        String campoProfecoEDocumento = (String) campoProfecoE.getSelectedItem();
        String campoProfecoFDocumento = (String) campoProfecoF.getSelectedItem();
        
        String campoUVAADocumento = (String) campoUVAA.getSelectedItem();
        String campoUVABDocumento = (String) campoUVAB.getSelectedItem();
        String campoUVACDocumento = (String) campoUVAC.getSelectedItem();
        String campoUVADDocumento = (String) campoUVAD.getSelectedItem();
        String campoUVAEDocumento = (String) campoUVAE.getSelectedItem();
        String campoUVAFDocumento = (String) campoUVAF.getSelectedItem();
        
        String campoPrecintoADocumento = (String) campoPrecintoA.getSelectedItem();
        String campoPrecintoBDocumento = (String) campoPrecintoB.getSelectedItem();
        String campoPrecintoCDocumento = (String) campoPrecintoC.getSelectedItem();
        String campoPrecintoDDocumento = (String) campoPrecintoD.getSelectedItem();
        String campoPrecintoEDocumento = (String) campoPrecintoE.getSelectedItem();
        String campoPrecintoFDocumento = (String) campoPrecintoF.getSelectedItem();
        
        String campoCumpleADocumento = "No Cumple";
        String campoCumpleBDocumento = "No Cumple";
        String campoCumpleCDocumento = "No Cumple";
        String campoCumpleDDocumento = "No Cumple";
        String campoCumpleEDocumento = "No Cumple";
        String campoCumpleFDocumento = "No Cumple";
        
        if(campoCumpleA.isSelected()){
            campoCumpleADocumento = "Cumple";
        }
        if(campoCumpleB.isSelected()){
            campoCumpleBDocumento = "Cumple";
        }
        if(campoCumpleC.isSelected()){
            campoCumpleCDocumento = "Cumple";
        }
        if(campoCumpleD.isSelected()){
            campoCumpleDDocumento = "Cumple";
        }
        if(campoCumpleE.isSelected()){
            campoCumpleEDocumento = "Cumple";
        }
        if(campoCumpleF.isSelected()){
            campoCumpleFDocumento = "Cumple";
        }
        
//        cadenaDispensario =      
//         "N??mero Estaci??n: "+noEstacion+"\t Folio: "+folioDocumento+"\t Dispensario: "+dispensarioActual+"\n"+       
//         "Lado A\t TipoGasolina: "+campoMarcaADocumento+"\t N. Serie: "+campoSerieADocumento+"\t Modelo:"+campoModeloADocumento+"\t HologramaProfeco: "+campoProfecoADocumento+"\t HologramaUVA: "+campoUVAADocumento+"\t Estatus: "+campoCumpleADocumento+"\n"+
//         "Lado B\t TipoGasolina: "+campoMarcaBDocumento+"\t N. Serie: "+campoSerieBDocumento+"\t Modelo:"+campoModeloBDocumento+"\t HologramaProfeco: "+campoProfecoBDocumento+"\t HologramaUVA: "+campoUVABDocumento+"\t Estatus: "+campoCumpleBDocumento+"\n"+
//         "Lado C\t TipoGasolina: "+campoMarcaCDocumento+"\t N. Serie: "+campoSerieCDocumento+"\t Modelo:"+campoModeloCDocumento+"\t HologramaProfeco: "+campoProfecoCDocumento+"\t HologramaUVA: "+campoUVACDocumento+"\t Estatus: "+campoCumpleCDocumento+"\n"+
//         "Lado D\t TipoGasolina: "+campoMarcaDDocumento+"\t N. Serie: "+campoSerieDDocumento+"\t Modelo:"+campoModeloDDocumento+"\t HologramaProfeco: "+campoProfecoDDocumento+"\t HologramaUVA: "+campoUVADDocumento+"\t Estatus: "+campoCumpleDDocumento+"\n"+
//         "Lado E\t TipoGasolina: "+campoMarcaEDocumento+"\t N. Serie: "+campoSerieEDocumento+"\t Modelo:"+campoModeloEDocumento+"\t HologramaProfeco: "+campoProfecoEDocumento+"\t HologramaUVA: "+campoUVAEDocumento+"\t Estatus: "+campoCumpleEDocumento+"\n"+
//         "Lado F\t TipoGasolina: "+campoMarcaFDocumento+"\t N. Serie: "+campoSerieFDocumento+"\t Modelo:"+campoModeloFDocumento+"\t HologramaProfeco: "+campoProfecoFDocumento+"\t HologramaUVA: "+campoUVAFDocumento+"\t Estatus: "+campoCumpleFDocumento+"\n";
//        
         cadenaDispensario =      
         "N??mero Estaci??n: "+noEstacion+"\t Folio: "+folioDocumento+"\t Dispensario: "+dispensarioActual+"\n";
         cadenaDispensarioA =      
         "Lado A\t TGas: "+campoMarcaADocumento+"\t N.Serie: "+campoSerieADocumento+"\t Mod:"+campoModeloADocumento+"\t HProfeco: "+campoProfecoADocumento+"\t HUVA: "+campoUVAADocumento+"\t Estatus: "+campoCumpleADocumento+"\t Precinto: "+campoPrecintoADocumento+"\n";
         cadenaDispensarioB =
         "Lado B\t TGas: "+campoMarcaBDocumento+"\t N.Serie: "+campoSerieBDocumento+"\t Mod:"+campoModeloBDocumento+"\t HProfeco: "+campoProfecoBDocumento+"\t HUVA: "+campoUVABDocumento+"\t Estatus: "+campoCumpleBDocumento+"\t Precinto: "+campoPrecintoBDocumento+"\n";
         cadenaDispensarioC =
         "Lado C\t TGas: "+campoMarcaCDocumento+"\t N.Serie: "+campoSerieCDocumento+"\t Mod:"+campoModeloCDocumento+"\t HProfeco: "+campoProfecoCDocumento+"\t HUVA: "+campoUVACDocumento+"\t Estatus: "+campoCumpleCDocumento+"\t Precinto: "+campoPrecintoCDocumento+"\n";
         cadenaDispensarioD =
         "Lado D\t TGas: "+campoMarcaDDocumento+"\t N.Serie: "+campoSerieDDocumento+"\t Mod:"+campoModeloDDocumento+"\t HProfeco: "+campoProfecoDDocumento+"\t HUVA: "+campoUVADDocumento+"\t Estatus: "+campoCumpleDDocumento+"\t Precinto: "+campoPrecintoDDocumento+"\n";
         cadenaDispensarioE =
         "Lado E\t TGas: "+campoMarcaEDocumento+"\t N.Serie: "+campoSerieEDocumento+"\t Mod:"+campoModeloEDocumento+"\t HProfeco: "+campoProfecoEDocumento+"\t HUVA: "+campoUVAEDocumento+"\t Estatus: "+campoCumpleEDocumento+"\t Precinto: "+campoPrecintoEDocumento+"\n";
         cadenaDispensarioF =
         "Lado F\t TGas: "+campoMarcaFDocumento+"\t N.Serie: "+campoSerieFDocumento+"\t Mod:"+campoModeloFDocumento+"\t HProfeco: "+campoProfecoFDocumento+"\t HUVA: "+campoUVAFDocumento+"\t Estatus: "+campoCumpleFDocumento+"\t Precinto: "+campoPrecintoFDocumento+"\n";
        
        //lbd.openConnection();
        int validaProceso = lbd.validarDispensario(dispensarioActual);
        if(validaProceso == 0){
            lbd.insertarDatosDictamen("",folioDocumento, noEstacion, cadenaDispensario, Fecha, HorarioInicio, HorarioFin,dispensarioActual,"Z");
            lbd.insertarDatosDictamen("",folioDocumento, noEstacion, cadenaDispensarioA, Fecha, HorarioInicio, HorarioFin,dispensarioActual,"A");
            lbd.insertarDatosDictamen("",folioDocumento, noEstacion, cadenaDispensarioB, Fecha, HorarioInicio, HorarioFin,dispensarioActual,"B");
            lbd.insertarDatosDictamen("",folioDocumento, noEstacion, cadenaDispensarioC, Fecha, HorarioInicio, HorarioFin,dispensarioActual,"C");
            lbd.insertarDatosDictamen("",folioDocumento, noEstacion, cadenaDispensarioD, Fecha, HorarioInicio, HorarioFin,dispensarioActual,"D");
            lbd.insertarDatosDictamen("",folioDocumento, noEstacion, cadenaDispensarioE, Fecha, HorarioInicio, HorarioFin,dispensarioActual,"E");
            lbd.insertarDatosDictamen("",folioDocumento, noEstacion, cadenaDispensarioF, Fecha, HorarioInicio, HorarioFin,dispensarioActual,"F");
            lbd.insertarDatosDictamen("",folioDocumento, noEstacion, "________________________________________________________________________________________________________", Fecha, HorarioInicio, HorarioFin,dispensarioActual,"G");
            JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa.");
        }
        else{
            int dialogButton = JOptionPane.YES_NO_OPTION;
            JOptionPane.showMessageDialog(null, "Ya has actualizado el Dispensario: "+ dispensarioActual);
            int dialogResult = JOptionPane.showConfirmDialog (null, "??Desea editar el dispensario?.","Warning",dialogButton);
            if(dialogResult == JOptionPane.YES_OPTION){
                //Nota: Se env??an los datos adicionales por si en alg??n momento es necesario utilizarlos. JLCI 07/05/2021
                lbd.actualizarDatosDictamen("",folioDocumento, noEstacion, cadenaDispensario, Fecha, HorarioInicio, HorarioFin,dispensarioActual,"Z");
                lbd.actualizarDatosDictamen("",folioDocumento, noEstacion, cadenaDispensarioA, Fecha, HorarioInicio, HorarioFin,dispensarioActual,"A");
                lbd.actualizarDatosDictamen("",folioDocumento, noEstacion, cadenaDispensarioB, Fecha, HorarioInicio, HorarioFin,dispensarioActual,"B");
                lbd.actualizarDatosDictamen("",folioDocumento, noEstacion, cadenaDispensarioC, Fecha, HorarioInicio, HorarioFin,dispensarioActual,"C");
                lbd.actualizarDatosDictamen("",folioDocumento, noEstacion, cadenaDispensarioD, Fecha, HorarioInicio, HorarioFin,dispensarioActual,"D");
                lbd.actualizarDatosDictamen("",folioDocumento, noEstacion, cadenaDispensarioE, Fecha, HorarioInicio, HorarioFin,dispensarioActual,"E");
                lbd.actualizarDatosDictamen("",folioDocumento, noEstacion, cadenaDispensarioF, Fecha, HorarioInicio, HorarioFin,dispensarioActual,"F");
                lbd.actualizarDatosDictamen("",folioDocumento, noEstacion, "________________________________________________________________________________________________________", Fecha, HorarioInicio, HorarioFin,dispensarioActual,"G");
                JOptionPane.showMessageDialog(null, "Datos actualizados de forma exitosa.");
            }
            else{
                JOptionPane.showMessageDialog(null, "Los datos permanecer??n iguales.");
            }
            
        }
        
        
        //lbd.closeConnection();
        
        System.out.println(cadenaDispensario);
        //this.dispose();
    }//GEN-LAST:event_botonDictamenActionPerformed

    private void campoMarcaAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoMarcaAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoMarcaAActionPerformed

    private void campoProfecoAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoProfecoAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoProfecoAActionPerformed

    private void campoCumpleAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCumpleAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoCumpleAActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void campoUVAAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoUVAAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoUVAAActionPerformed

    private void campoPrecintoAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoPrecintoAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoPrecintoAActionPerformed

    private void campoPrecintoEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoPrecintoEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoPrecintoEActionPerformed

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
//            java.util.logging.Logger.getLogger(catalogoDocumentoDictamen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(catalogoDocumentoDictamen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(catalogoDocumentoDictamen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(catalogoDocumentoDictamen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                catalogoDocumentoDictamen dialog = new catalogoDocumentoDictamen(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonDictamen;
    private javax.swing.JCheckBox campoCumpleA;
    private javax.swing.JCheckBox campoCumpleB;
    private javax.swing.JCheckBox campoCumpleC;
    private javax.swing.JCheckBox campoCumpleD;
    private javax.swing.JCheckBox campoCumpleE;
    private javax.swing.JCheckBox campoCumpleF;
    private javax.swing.JComboBox<String> campoDispensario;
    private javax.swing.JLabel campoEstacion;
    private javax.swing.JLabel campoFolioDictamen;
    private javax.swing.JComboBox<String> campoMarcaA;
    private javax.swing.JComboBox<String> campoMarcaB;
    private javax.swing.JComboBox<String> campoMarcaC;
    private javax.swing.JComboBox<String> campoMarcaD;
    private javax.swing.JComboBox<String> campoMarcaE;
    private javax.swing.JComboBox<String> campoMarcaF;
    private javax.swing.JComboBox<String> campoModeloA;
    private javax.swing.JComboBox<String> campoModeloB;
    private javax.swing.JComboBox<String> campoModeloC;
    private javax.swing.JComboBox<String> campoModeloD;
    private javax.swing.JComboBox<String> campoModeloE;
    private javax.swing.JComboBox<String> campoModeloF;
    private javax.swing.JComboBox<String> campoPrecintoA;
    private javax.swing.JComboBox<String> campoPrecintoB;
    private javax.swing.JComboBox<String> campoPrecintoC;
    private javax.swing.JComboBox<String> campoPrecintoD;
    private javax.swing.JComboBox<String> campoPrecintoE;
    private javax.swing.JComboBox<String> campoPrecintoF;
    private javax.swing.JComboBox<String> campoProfecoA;
    private javax.swing.JComboBox<String> campoProfecoB;
    private javax.swing.JComboBox<String> campoProfecoC;
    private javax.swing.JComboBox<String> campoProfecoD;
    private javax.swing.JComboBox<String> campoProfecoE;
    private javax.swing.JComboBox<String> campoProfecoF;
    private javax.swing.JComboBox<String> campoSerieA;
    private javax.swing.JComboBox<String> campoSerieB;
    private javax.swing.JComboBox<String> campoSerieC;
    private javax.swing.JComboBox<String> campoSerieD;
    private javax.swing.JComboBox<String> campoSerieE;
    private javax.swing.JComboBox<String> campoSerieF;
    private javax.swing.JComboBox<String> campoUVAA;
    private javax.swing.JComboBox<String> campoUVAB;
    private javax.swing.JComboBox<String> campoUVAC;
    private javax.swing.JComboBox<String> campoUVAD;
    private javax.swing.JComboBox<String> campoUVAE;
    private javax.swing.JComboBox<String> campoUVAF;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel473;
    private javax.swing.JLabel jLabel474;
    private javax.swing.JLabel jLabel475;
    private javax.swing.JLabel jLabel476;
    private javax.swing.JLabel jLabel477;
    private javax.swing.JLabel jLabel478;
    private javax.swing.JLabel jLabel479;
    private javax.swing.JLabel jLabel480;
    private javax.swing.JLabel jLabel482;
    private javax.swing.JLabel jLabel488;
    private javax.swing.JLabel jLabel489;
    private javax.swing.JLabel jLabel490;
    private javax.swing.JLabel jLabel491;
    private javax.swing.JLabel jLabel492;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    // End of variables declaration//GEN-END:variables
}
