package Contoller;



import Class.Avion;
import Model.AvionModel;
import java.io.FileOutputStream;
import java.util.ArrayList;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Anderson Sachez
 */
public class AvionController {
     AvionModel modelo_avion = new  AvionModel();
    ArrayList<Avion> listaAvion = modelo_avion.Read();
   
    public void ExportData(){
   
        HSSFWorkbook book = new HSSFWorkbook();
        HSSFSheet sheet = book.createSheet();
        book.setSheetName(0, "Lista de Aviones");
        String[] headers = new String[]{
            "Id",
            "Modelo",
            "N° asientos",
            "N° sillas",
            "Capcidad maxima peso"
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
        for (int i = 0; i < listaAvion.size(); i++) {
            HSSFRow row = sheet.createRow(i+1);
            int id = listaAvion.get(i).getId();
            String modelo = listaAvion.get(i).getModelo();
            int nasienos = listaAvion.get(i).getNumero_asientos();
            int nbanos= listaAvion.get(i).getNumero_banos();
            int capmax = (int) listaAvion.get(i).getCapasiad_max_peso();
            
            
           
            row.createCell(0).setCellValue(id);
            row.createCell(1).setCellValue(modelo);
            row.createCell(2).setCellValue(nasienos);
            row.createCell(3).setCellValue(nbanos);
            row.createCell(4).setCellValue(capmax);
            
        }
       
        //Exportar la informacion
        try{
            FileOutputStream file = new FileOutputStream("Aviones.xls");
            book.write(file);
            file.close();
        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
        }
    }

}
