
import com.sun.rowset.internal.Row;
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author R2D2
 */
public class Convertidor {

    private FileInputStream archivoIS;
    private File archivo;
    private ArrayList<Double> filas;

    Convertidor(File archivo) {
        this.archivo = archivo;
    }

    public ArrayList<Double> getDatos() throws Exception {
        if (filas == null) {
            try {
                filas = new ArrayList<Double>();
                archivoIS = new FileInputStream(archivo);
                XSSFWorkbook wb;
                wb = new XSSFWorkbook(archivoIS);
                XSSFSheet sheet = wb.getSheetAt(0);
                XSSFRow row;
                XSSFCell cell;

                int rows;
                rows = sheet.getPhysicalNumberOfRows();

                int cols = 0;
                int tmp = 0;

                for (int i = 0; i < 10 || i < rows; i++) {
                    row = sheet.getRow(i);
                    if (row != null) {
                        tmp = sheet.getRow(i).getPhysicalNumberOfCells();
                        if (tmp > cols) {
                            cols = tmp;
                        }
                    }
                }

                for (int r = 0; r < rows; r++) {
                    row = sheet.getRow(r);
                    if (row != null) {
                        for (int c = 0; c < cols; c++) {
                            cell = row.getCell(c);
                            if (cell != null) {
                                filas.add(round(cell.getNumericCellValue()));
                            }
                        }
                    }
                }
            } catch (Exception e) {
                filas = null;
                throw new Exception(e.getMessage());
            }
        }
        return filas;
    }

    public static double round(double value) {
        long factor = (long) Math.pow(10, 2);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    /**
     * @return the archivoIS
     */
    public FileInputStream getArchivoIS() {
        return archivoIS;
    }

    /**
     * @param archivoIS the archivoIS to set
     */
    public void setArchivoIS(FileInputStream archivoIS) {
        this.archivoIS = archivoIS;
    }

    /**
     * @return the archivo
     */
    public File getArchivo() {
        return archivo;
    }

    /**
     * @param archivo the archivo to set
     */
    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

}
