/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Contoller;

import Class.Aeropuerto;
import Model.AeropuertoModel;
import java.io.FileOutputStream;
import java.util.ArrayList;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;

/**
 *
 * @author Anderson Sachez
 */
public class AeropuertoController {
    AeropuertoModel modelo_aeropuerto = new  AeropuertoModel();
    ArrayList<Aeropuerto> listaAeropuerto = modelo_aeropuerto.Read();
   
    public void ExportData(){
   
        HSSFWorkbook book = new HSSFWorkbook();
        HSSFSheet sheet = book.createSheet();
        book.setSheetName(0, "Lista de Aeropuertos");
        String[] headers = new String[]{
            "Id",
            "Nombre",
            "Ciudad",
            "Pais",
            "Coordenada x",
            "Coordenada y"
        };
       
        CellStyle headerStyle = book.createCellStyle();
        HSSFFont font = book.createFont();
        font.setBold(true);
        headerStyle.setFont(font);
       
        HSSFRow headersRow = sheet.createRow(0);
        //Actulizo el estilo del encabezado
        for (int i = 0; i < headers.length; i++) {
            String header = headers[i];
            HSSFCell cell = headersRow.createCell(i);
            cell.setCellStyle(headerStyle);
            cell.setCellValue(header);
        }
       
        // Llenar el Excel
        for (int i = 0; i < listaAeropuerto.size(); i++) {
            HSSFRow row = sheet.createRow(i+1);
            int id = listaAeropuerto.get(i).getId();
            String nombre = listaAeropuerto.get(i).getNombre();
            String ciudad = listaAeropuerto.get(i).getCiudad();
            String pais = listaAeropuerto.get(i).getPais();
            int cordx = (int) listaAeropuerto.get(i).getCoord_x();
            int cordy = (int) listaAeropuerto.get(i).getCoord_y();
            
           
            row.createCell(0).setCellValue(id);
            row.createCell(1).setCellValue(nombre);
            row.createCell(2).setCellValue(ciudad);
            row.createCell(3).setCellValue(pais);
            row.createCell(4).setCellValue(cordx);
            row.createCell(5).setCellValue(cordy);
        }
       
        //Exportar la informacion
        try{
            FileOutputStream file = new FileOutputStream("Aeropuertos.xls");
            book.write(file);
            file.close();
        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
        }
    }

}
