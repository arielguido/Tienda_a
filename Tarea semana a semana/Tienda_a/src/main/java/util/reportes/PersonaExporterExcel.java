package util.reportes;

import com.Tienda.entity.Persona;
import com.lowagie.text.Paragraph;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PersonaExporterExcel {

    private XSSFWorkbook libro;
    private XSSFSheet hoja;

    private List<Persona> listaPersona;

    public PersonaExporterExcel(List<Persona> listaPersona) {
        this.listaPersona = listaPersona;
        libro = new XSSFWorkbook();
        hoja = libro.createSheet("Personas");
    }

    private void escribirCabeceraDeTabla() {
        Row fila = hoja.createRow(0);

        Paragraph titulo = new Paragraph("Reporte de Personas");
		titulo.setAlignment(Paragraph.ALIGN_CENTER);
		
        
        CellStyle estilo = libro.createCellStyle();
        XSSFFont fuente = libro.createFont();
        fuente.setBold(true);
        fuente.setFontHeight(16);
        estilo.setFont(fuente);

        Cell celda = fila.createCell(0);
        celda.setCellValue("ID");
        celda.setCellStyle(estilo);

        celda = fila.createCell(1);
        celda.setCellValue("Nombre");
        celda.setCellStyle(estilo);

        celda = fila.createCell(2);
        celda.setCellValue("Apellido 1");
        celda.setCellStyle(estilo);

        celda = fila.createCell(3);
        celda.setCellValue("Apellido 2");
        celda.setCellStyle(estilo);

        celda = fila.createCell(4);
        celda.setCellValue("Email");
        celda.setCellStyle(estilo);

        celda = fila.createCell(5);
        celda.setCellValue("Telefono");
        celda.setCellStyle(estilo);

        celda = fila.createCell(6);
        celda.setCellValue("Pais");
        celda.setCellStyle(estilo);
    }

    private void escribirDatosDeLaTabla() {
        int nueroFilas = 1;

        CellStyle estilo = libro.createCellStyle();
        XSSFFont fuente = libro.createFont();
        fuente.setFontHeight(14);
        estilo.setFont(fuente);

        for (Persona persona : listaPersona) {
            Row fila = hoja.createRow(nueroFilas++);

            Cell celda = fila.createCell(0);
            celda.setCellValue(persona.getId());
            hoja.autoSizeColumn(0);
            celda.setCellStyle(estilo);

            celda = fila.createCell(1);
            celda.setCellValue(persona.getNombre());
            hoja.autoSizeColumn(1);
            celda.setCellStyle(estilo);

            celda = fila.createCell(2);
            celda.setCellValue(persona.getApellido1());
            hoja.autoSizeColumn(2);
            celda.setCellStyle(estilo);

            celda = fila.createCell(3);
            celda.setCellValue(persona.getApellido2());
            hoja.autoSizeColumn(3);
            celda.setCellStyle(estilo);

            celda = fila.createCell(4);
            celda.setCellValue(persona.getEmail());
            hoja.autoSizeColumn(4);
            celda.setCellStyle(estilo);

            celda = fila.createCell(5);
            celda.setCellValue(persona.getTelefono());
            hoja.autoSizeColumn(5);
            celda.setCellStyle(estilo);
            
            celda = fila.createCell(6);
            celda.setCellValue(persona.getPais().getPais());
            hoja.autoSizeColumn(6);
            celda.setCellStyle(estilo);

        }
    }

    public void exportar(HttpServletResponse response) throws IOException {
        escribirCabeceraDeTabla();
        escribirDatosDeLaTabla();

        ServletOutputStream outPutStream = response.getOutputStream();
        libro.write(outPutStream);

        libro.close();
        outPutStream.close();
    }
}
