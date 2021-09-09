/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Jose Luis
 */
public class reporteExcel {
    LibreriaToolsControlador lbtc = new LibreriaToolsControlador();
    String folioDocumento;
    int tipoDocumento;
    public reporteExcel(){}
    
    public void crearDocumentoExcel(int tipoDocumento, 
            String folioDocumento, 
            informacionCliente infoCliente, 
            informacionDispensarios infoDispensarios){
                /*Lista de etiquetas en el Excel:
                
                */
                //String nombreArchivo = "registropruebas.xlsx"; 
                String nombreArchivo = lbtc.tipoDocumentoImprimir(tipoDocumento);
                /*El nombre de la carpeta de salida debe ser fijo*/
                String carpetaSalida = "C:\\Formatos\\";
                /*Crea la carpeta Formatos, si no existe*/
                File archivoFinalFormato = new File(carpetaSalida);
                if (archivoFinalFormato.mkdirs()) {//Se crea la carpeta
                        System.out.println("Directorio C:\\Formatos\\ creado.");
                } else {
                        System.out.println("Directorio C:\\Formatos\\ ya existe.");
                }
                String nombreSalida = ".xlsx"; //Pretendo recibir folio y fecha //25/07/2021
                String extensionSalida = ".xlsx";
                nombreSalida = folioDocumento+"-"+tipoDocumento; //Genera el nombre único
                carpetaSalida = carpetaSalida+"\\"+folioDocumento+"\\"; //Creo la carpeta
                nombreSalida = nombreSalida + extensionSalida;
                File archivoFinal = new File(carpetaSalida);
                //        
                //        if (!archivoFinal.exists()) {
                if (archivoFinal.mkdirs()) {//Se crea la carpeta
                    System.out.println("Directorio "+carpetaSalida+" creado.");
                } else {
                    System.out.println("Directorio "+carpetaSalida+" ya existe.");
                }
                String nombreArchivoAux = lbtc.tipoDocumentoGenerar(tipoDocumento, nombreSalida);
                //String nombreArchivoAux = "registropruebas2.xlsx";
		String rutaArchivo = "src\\Controlador\\Formatos\\" + nombreArchivo;
		String hoja = "Hoja1";
                XSSFWorkbook worbook = null;
		try (FileInputStream file = new FileInputStream(new File(rutaArchivo))) {
			// leer archivo excel
			worbook = new XSSFWorkbook(file);
			//obtener la hoja que se va leer
			XSSFSheet sheet = worbook.getSheetAt(0);
			//obtener todas las filas de la hoja excel
			Iterator<Row> rowIterator = sheet.iterator();
                        //System.out.println(rowIterator.toString());
			Row row;
			// se recorre cada fila hasta el final
			while (rowIterator.hasNext()) {
				row = rowIterator.next();
                                //System.out.println(row.getHeight());
				//se obtiene las celdas por fila
				Iterator<Cell> cellIterator = row.cellIterator();
				Cell cell;
				//se recorre cada celda
				while (cellIterator.hasNext()) {
					// se obtiene la celda en específico y se la imprime
					cell = cellIterator.next();
					System.out.print(" | "+cell.getStringCellValue()+" | ");
                                        if(cell.getStringCellValue().equals("DISP"))
                                            cell.setCellValue("20.2");
                                        //System.out.println(cell.toString());
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.getMessage();
		}
                
                rutaArchivo = carpetaSalida + nombreArchivoAux;
                File excelFile;
                excelFile = new File(rutaArchivo); // Referenciando a la ruta y el archivo Excel a crear
                try (FileOutputStream fileOuS = new FileOutputStream(excelFile)) {
                if (excelFile.exists()) { // Si el archivo existe lo eliminaremos
                    excelFile.delete();
                    System.out.println("Archivo eliminado.!");
                }
               //worbook = new XSSFWorkbook(fileOuS);
                worbook.write(fileOuS);
                fileOuS.flush();
                fileOuS.close();
                System.out.println("Archivo Creado.!");
                int dialogButton = JOptionPane.YES_NO_OPTION;
                JOptionPane.showMessageDialog(null,"El archivo se creo con éxito en la siguiente dirección: "+rutaArchivo);
                int dialogResult = JOptionPane.showConfirmDialog (null, "¿Desea abrir el archivo generado?","Warning",dialogButton);
                if(dialogResult == JOptionPane.YES_OPTION){
                      // Saving code here
                      //nameArchive archivoGenerado sin permiso :v

                    lbtc.openWord(rutaArchivo);

                }else{
                    System.out.println("El archivo no se que desea abrir.");
                       // lbtc.deleteDocumento(direccion+nameArchive);
                }
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }
    
    }
}
