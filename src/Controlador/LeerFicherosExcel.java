/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author joseluis.caamal
 */
//package com.ecodeup.ficherosexcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LeerFicherosExcel {

	public static void main(String[] args) {
		String nombreArchivo = "registropruebas.xlsx";
                String nombreArchivoAux = "registropruebas2.xlsx";
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

			Row row;
			// se recorre cada fila hasta el final
			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				//se obtiene las celdas por fila
				Iterator<Cell> cellIterator = row.cellIterator();
				Cell cell;
				//se recorre cada celda
				while (cellIterator.hasNext()) {
					// se obtiene la celda en específico y se la imprime
					cell = cellIterator.next();
					System.out.print(cell.getStringCellValue()+" | ");
                                        if(cell.getStringCellValue().equals("DISP"))
                                            cell.setCellValue("Hola");
                                        //System.out.println(cell.toString());
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.getMessage();
		}
                
                rutaArchivo = "src\\Controlador\\Formatos\\" + nombreArchivoAux;
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

                } catch (Exception e) {
                    e.printStackTrace();
                }
	}
}