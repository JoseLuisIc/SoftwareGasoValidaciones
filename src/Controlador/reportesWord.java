package Controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFFooter;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;


public class reportesWord{
LibreriaToolsControlador lbtc = new LibreriaToolsControlador();
//    public static void main(String[] args) throws IOException, InvalidFormatException {
//        
//        reportesWord rp = new reportesWord();
//        //rp.crearArchivoWord("D:\\formatos\\","Nuevo.docx","Hola Mundo");
//        reemplazarDatosWord("CONTRATO2021.docx","DocumentoNuevo.docx", "D:\\formatos\\" , "«TESTIGO»", "Jose Luis Caamal Ic");
//        rp.openWord("DocumentoNuevo.docx");
//    }
//    
    
public static void reemplazarDatosWord(String name,String nameSalida, String direccion, String palabra, String reemplazo) throws InvalidFormatException, IOException{
    
    
    XWPFDocument doc = new XWPFDocument(OPCPackage.open(direccion+name));
    for (XWPFParagraph p : doc.getParagraphs()) {
        List<XWPFRun> runs = p.getRuns();
        if (runs != null) {
            for (XWPFRun r : runs) {
                String text = r.getText(0);
                if (text != null && text.contains(palabra)) {
                    text = text.replace(palabra, reemplazo);
                    r.setText(text, 0);
                     r.setBold(r.isBold());
                }
            }
        }
    }
    for (XWPFTable tbl : doc.getTables()) {
       for (XWPFTableRow row : tbl.getRows()) {
          for (XWPFTableCell cell : row.getTableCells()) {
             for (XWPFParagraph p : cell.getParagraphs()) {
                for (XWPFRun r : p.getRuns()) {
                  String text = r.getText(0);
                  if (text != null && text.contains(palabra)) {
                    text = text.replace(palabra, reemplazo);
                    r.setText(text,0);
                    r.setBold(true);
                  }
                }
             }
          }
       }
    }
    doc.write(new FileOutputStream(nameSalida));
    doc.close();
    
}
//        Crea un archivo en Word
//        nombreArchivo = "D:\\formatos\\"; Ruta que se va enviar
//        fileName = "newFile.docx"; Nombre Archivo Generado
//        contenidoArchivo  = "Hola"; Contenido del archivo
//        @Author Jose Luis Caamal Ic
//        @References: http://poi.apache.org/help/faq.html#faq-N10025, https://www.youtube.com/watch?v=sPiZVlFCHeg

    public int crearArchivoWord(String carpeta, String nombreArchivo, String nameSalida, String contenidoArchivo )  throws IOException, InvalidFormatException {
        
        XWPFDocument doc = new XWPFDocument();
        XWPFParagraph tmpPH = doc.createParagraph();
        XWPFRun tmpRun = tmpPH.createRun();
        tmpRun.setText(contenidoArchivo);
  
        File fileDocx = new File(carpeta);
        if(!fileDocx.exists()){
            System.out.println("Create Folder:"+carpeta);
            fileDocx.mkdirs();
        }
        
        FileOutputStream salida = new FileOutputStream(new File(carpeta + nombreArchivo));
        doc.write(salida);
        doc.close();
        
        System.out.println("Lo que escribí:"+carpeta+fileDocx);
        salida.close();
        
        reemplazarDatosWord(nombreArchivo,nameSalida, carpeta, "Hola", "Mundo");
        
        return 1;
    }
    
    //Referencia y uso:
    //Ejecutamos todos:
    
    private void iterateThroughParagraphs(XWPFDocument doc, Map<String, String> fieldsForReport) throws Exception {
        for (XWPFParagraph paragraph : doc.getParagraphs()) {
            iterateThroughRuns(paragraph, fieldsForReport);
        }
    }

    private void iterateThroughTables(XWPFDocument doc, Map<String, String> fieldsForReport) throws Exception {
        for (XWPFTable tbl : doc.getTables()) {
            for (XWPFTableRow row : tbl.getRows()) {
                for (XWPFTableCell cell : row.getTableCells()) {
                    for (XWPFParagraph paragraph : cell.getParagraphs()) {
                        iterateThroughRuns(paragraph, fieldsForReport);
                    }
                }
            }
        }
    }

    private void iterateThroughFooters(XWPFDocument doc, Map<String, String> fieldsForReport) throws Exception {
        for (XWPFFooter footer : doc.getFooterList()) {
            for (XWPFParagraph paragraph : footer.getParagraphs()) {
                iterateThroughRuns(paragraph, fieldsForReport);
            }
        }
    }

    private void iterateThroughRuns(XWPFParagraph paragraph, Map<String, String> fieldsForReport) throws Exception {
        List<XWPFRun> runs = paragraph.getRuns();

        if (runs != null) {
            int runsSize = runs.size();

            for (int index = 0; index < runsSize; index++) {
                XWPFRun currentRun = runs.get(index);
                String text = currentRun.getText(0);

                if (text != null && text.contains("#")) {
                    if (text.matches("(?i).*#[a-zA-Z0-9]+#.*")) {
                        Matcher m = Pattern.compile("#[a-zA-Z0-9]+#")
                                .matcher(text);

                        while (m.find()) {
                            String variableWithHash = m.group();
                            String variableWithoutHash = variableWithHash.replace("#", "");

                            if (fieldsForReport.get(variableWithoutHash) == null) {
                                continue;
                            }

                            String newText = currentRun.getText(0).replace(variableWithHash, fieldsForReport.get(variableWithoutHash));
                            currentRun.setText(newText, 0);
                        }
                        continue;
                    }

                    if (("#".equals(text) || " #".equals(text)) && index + 1 < runsSize) {
                        replaceVariableBetweenDifferentRuns(index, runs, fieldsForReport);
                        index += 2;
                    }
                }
            }
        }
    }
    
    private void replaceVariableBetweenDifferentRuns(int index, List<XWPFRun> runs, Map<String, String> fieldsForReport) throws Exception {
        XWPFRun currentRun = runs.get(index);
        String text = currentRun.getText(0);

        XWPFRun middleRun = runs.get(index + 1);
        String middleText = middleRun.getText(0);

        String newVariableValue = fieldsForReport.get(middleText);

        if (newVariableValue == null) {
            throw new Exception("Variable: " + middleText + " is not presented in the data from DB during report prepared.");
        }

        XWPFRun lastRun = runs.get(index + 2);
        String lastText = lastRun.getText(0);

        if (middleText.matches("[a-zA-Z0-9]+") && "#".equals(lastText)) {
            currentRun.setText(text.replace("#", ""), 0);
            middleRun.setText(newVariableValue, 0);
            lastRun.setText("", 0);
        } else {
            throw new Exception("Problems were occurred during variable replacement");
        }
    }
    /*
    Crea el tipo de documento contrato o solicitud
    Jose Luis Caamal Ic
    31/08/2020
    */
    public void creaDocContrato(/*String name,
            String nameSalida,
            String carpetaSalida,
            String direccion, */
            String[] datosPalabra,
            Object[] datosReemplazo, int tipoDocumento, String folioDocumento) 
            throws InvalidFormatException, IOException{
        
        /*El nombre de la carpeta de salida debe ser fijo*/
        String carpetaSalida = "C:\\Formatos\\";
        
        File archivoFinalFormato = new File(carpetaSalida);
        if (archivoFinalFormato.mkdirs()) {//Se crea la carpeta
                System.out.println("Directorio C:\\Formatos\\ creado.");
        } else {
                System.out.println("Directorio C:\\Formatos\\ ya existe.");
        }    
        /*El nombre de la carpeta de salida debe ser fijo*/
        String nameSalida = ".docx"; //Pretendo recibir folio y fecha //06/08/2020
        String extensiónSalida = ".docx";
        //Direccion del machote en el proyecto
        String direccion = "src\\Controlador\\Formatos\\";
        //Nombre del documento que se usara para reemplazar
        String name = lbtc.tipoDocumentoImprimir(tipoDocumento);
        //Obtengo el machote para no afectar y crear una copia en la cual se va trabajar
        XWPFDocument doc = new XWPFDocument(OPCPackage.open(direccion+name));
        //XWPFDocument docTempAux = doc;
        //String nameCarpeta =
        //Folio´+ "-"+(String) datosReemplazo[0];
        nameSalida = folioDocumento+"-"+tipoDocumento; //Genera el nombre único
        carpetaSalida = carpetaSalida+"\\"+folioDocumento+"\\"; //Creo la carpeta
        nameSalida = nameSalida + extensiónSalida;
        
        File archivoFinal = new File(carpetaSalida);
//        
//        if (!archivoFinal.exists()) {
            if (archivoFinal.mkdirs()) {//Se crea la carpeta
                System.out.println("Directorio "+carpetaSalida+" creado.");
            } else {
                System.out.println("Directorio "+carpetaSalida+" ya existe.");
            }
                
                FileOutputStream salida = new FileOutputStream(carpetaSalida+nameSalida);
                doc.write(salida); //Copio el documento en la salida
                doc.close();
                System.out.println("Lo que escribí:"+carpetaSalida+nameSalida);
                salida.close();
                crearDocumentoContrato( datosPalabra,datosReemplazo, carpetaSalida, nameSalida, tipoDocumento);
                if(tipoDocumento == 4) //Crea el documento solo si es igual a 4.
                    crearDictamenBomba(carpetaSalida, folioDocumento, tipoDocumento,datosReemplazo);
//                System.out.println("Error al crear directorio");
//                crearDocumentoContrato( datosPalabra,datosReemplazo, carpetaSalida, nameSalida, tipoDocumento);
            
//        }
//        else{
//            int dialogButton = JOptionPane.YES_NO_OPTION;
//            JOptionPane.showMessageDialog(null,"El directorio ya existe, verifica en la siguiente dirección: "+carpetaSalida);
//            int dialogResult = JOptionPane.showConfirmDialog (null, "¿Desea abrir el archivo generado?","Warning",dialogButton);
//            if(dialogResult == JOptionPane.YES_OPTION){
//              // Saving code here
//              nameSalida = lbtc.tipoDocumentoGenerar(tipoDocumento, nameSalida);
//              lbtc.openWord(carpetaSalida+nameSalida);
//            }
//        }
    }
    
    public void crearDocumentoContrato(String[] datosPalabra,
            Object[] datosReemplazo, String direccion, String nameArchive, int tipoDoc) 
            throws InvalidFormatException, IOException{
   
         //Obtengo el documento creado para no afectar el de la raíz
        //doc = new XWPFDocument(OPCPackage.open(direccion+name));
        XWPFDocument doc = new XWPFDocument(OPCPackage.open(direccion+nameArchive));
        System.out.println(doc.toString());
        for(int i = 0;i<datosReemplazo.length; i++ ){
//            if(datosReemplazo[i].equals("")||datosReemplazo[i]==null){
//                datosReemplazo[i] = "";
//            }
            for (XWPFParagraph p : doc.getParagraphs()) {
                List<XWPFRun> runs = p.getRuns();
                if (runs != null) {
                    for (XWPFRun r : runs) {
                        String text = r.getText(0);
                        if (text != null && text.contains(datosPalabra[i])) {
                            text = text.replace(datosPalabra[i], (String) datosReemplazo[i]);
                            r.setText(text, 0);
                            r.setBold(r.isBold());
                        }
                    }
                }
            }
            for (XWPFTable tbl : doc.getTables()) {
               for (XWPFTableRow row : tbl.getRows()) {
                  for (XWPFTableCell cell : row.getTableCells()) {
                     for (XWPFParagraph p : cell.getParagraphs()) {
                        for (XWPFRun r : p.getRuns()) {
                          String text = r.getText(0);
                          if (text != null && text.contains(datosPalabra[i])) {
                            text = text.replace(datosPalabra[i], (String) datosReemplazo[i]);
                            r.setText(text,0);
                            r.setBold(true);
                          }
                        }
                     }
                  }
               }
            }
//            doc.write(new FileOutputStream(direccion+nameArchive));
//            doc.close();
            
        }
        
//            FileOutputStream salida = new FileOutputStream(direccion+nameArchive);
//            System.out.println("Lo que escribí:"+direccion+nameArchive);
//            doc.write(salida);
//            doc.close();
//            salida.close();
//            String nombreNuevo = "ContratoFolio-"+nameArchive;
            String nombreNuevo = lbtc.tipoDocumentoGenerar(tipoDoc, nameArchive);
            try (FileOutputStream fileOut = new FileOutputStream(direccion+nombreNuevo)) {
                doc.write(fileOut);
                doc.close();
            }
            //Files.delete(Paths.get(direccion+nameArchive));
            //Files.move(Paths.get(direccion+nameArchive+".docx"), Paths.get(direccion+nameArchive+".docx"));
            if(tipoDoc != 4 && tipoDoc != 3){ //Evita abrir los archivos de bombas 14/07/2021
                int dialogButton = JOptionPane.YES_NO_OPTION;
                JOptionPane.showMessageDialog(null,"El archivo se creo con éxito en la siguiente dirección: "+direccion+nombreNuevo);
                int dialogResult = JOptionPane.showConfirmDialog (null, "¿Desea abrir el archivo generado?","Warning",dialogButton);
                if(dialogResult == JOptionPane.YES_OPTION){
                  // Saving code here
                  //nameArchive archivoGenerado sin permiso :v
                  int elimine = lbtc.deleteDocumento(direccion+nameArchive);
                  if(elimine == 1){
                    lbtc.openWord(direccion+nombreNuevo);
                  }
                  else{
                      System.out.println("La dirección:"+direccion+nameArchive+". No Existe.");
                  }
                }else{
                    System.out.println("Independientemente de la documentación, se eliminan los archivos extras.");
                    //lbtc.deleteDocumento(direccion+nameArchive);
                }
            }
            lbtc.deleteDocumento(direccion+nameArchive);
            direccion_local = direccion;
    
    }
    public String direccion_local = "";
    public void crearDictamenBomba(String direccion, String folioDocumento, int tipoDocumento,Object[] datosReemplazo) 
            throws InvalidFormatException, IOException{
        String nombreAux = "";
        String nameSalida = "";
        String extensiónSalida = ".docx";
        tipoDocumento = 3;
        nameSalida = folioDocumento+"-"+tipoDocumento; //Genera el nombre único
        //carpetaSalida = carpetaSalida+"\\"+folioDocumento+"\\"; //Creo la carpeta
        nameSalida = nameSalida + extensiónSalida;
        String nombreNuevo = lbtc.tipoDocumentoGenerar(tipoDocumento, nameSalida);
        nombreAux = nombreNuevo;
        //String nombreNuevo = lbtc.tipoDocumentoGenerar(tipoDoc, nameArchive);
        XWPFDocument doc = new XWPFDocument(OPCPackage.open(direccion+nombreNuevo));
        System.out.println("Salida original: "+direccion+nombreNuevo);
        //String nombreNuevo = lbtc.tipoDocumentoGenerar(tipoDoc, nameArchive);
        tipoDocumento = 4;
        nameSalida = folioDocumento+"-"+tipoDocumento; //Genera el nombre único
        //carpetaSalida = carpetaSalida+"\\"+folioDocumento+"\\"; //Creo la carpeta
        nameSalida = nameSalida + extensiónSalida;
        nombreNuevo = lbtc.tipoDocumentoGenerar(tipoDocumento, nameSalida);
        System.out.println("Salida copia: "+direccion+nombreNuevo);
        XWPFDocument docCopy = new XWPFDocument(OPCPackage.open(direccion+nombreNuevo));
        tipoDocumento = 5;
        crearDictamenBombaDoc(doc, docCopy,direccion,tipoDocumento,nameSalida, datosReemplazo);
        eliminarCopiaDictamen(direccion,nombreNuevo,nombreAux);
//        XWPFDocument doc = new XWPFDocument(OPCPackage.open(direccion+nameArchive));
//        System.out.println(doc.toString());
//        String nombreNuevo = lbtc.tipoDocumentoGenerar(tipoDoc, nameArchive);
//        try (FileOutputStream fileOut = new FileOutputStream(direccion+nombreNuevo)) {
//                doc.write(fileOut);
//                doc.close();
//        }
    }
    /*Une los documentos para tener un solo documento
    @Jose Luis Caamal Ic
    doc = documento original
    docCopy = documento que se unira al original
    14/07/2021
    */
    public void crearDictamenBombaDoc( XWPFDocument doc, XWPFDocument docCopy, 
        String direccion,int tipoDocumento, String nombreArchivo, Object [] datosReemplazo) throws FileNotFoundException, IOException{
        int pos = doc.getParagraphs().size() - 1;
        System.out.println(pos);
        int contador = 0;
        System.out.println("datosReemplazo.length:"+datosReemplazo.length +3);
        for (XWPFParagraph par : docCopy.getParagraphs()) {
            doc.createParagraph();
            if(contador < datosReemplazo.length +3){ //Se complementa y no permite ingresar más caracteres
                doc.setParagraph(par, pos++);
                contador ++;
            }
//            System.out.println("par: "+par.toString()+":");
//            System.out.println("pos:"+pos);
        }
        System.out.println(tipoDocumento);
        System.out.println(nombreArchivo);
        String nombreNuevo = lbtc.tipoDocumentoGenerar(tipoDocumento, nombreArchivo);
        System.out.println(direccion+nombreNuevo);
        try (FileOutputStream fileOut = new FileOutputStream(direccion+nombreNuevo)) {
                doc.write(fileOut);
                doc.close();
        }
        
        int dialogButton = JOptionPane.YES_NO_OPTION;
        JOptionPane.showMessageDialog(null,"El archivo se creo con éxito en la siguiente dirección: "+direccion+nombreNuevo);
        int dialogResult = JOptionPane.showConfirmDialog (null, "¿Desea abrir el archivo generado?","Warning",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){
              // Saving code here
              //nameArchive archivoGenerado sin permiso :v
              
            lbtc.openWord(direccion+nombreNuevo);
             
        }else{
            System.out.println("El archivo no se que desea abrir.");
               // lbtc.deleteDocumento(direccion+nameArchive);
        }
        
    }
    public void eliminarCopiaDictamen(String direccion, String nameArchive, String nombreAux){
        lbtc.deleteDocumento(direccion+nameArchive);
        lbtc.deleteDocumento(direccion+nombreAux);
        System.out.println("Se borran los archivos finales.");
    }
}