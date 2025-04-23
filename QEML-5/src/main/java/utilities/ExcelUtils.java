package utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

    private final String filePath;

    public ExcelUtils(String filePath) {
        this.filePath = filePath;
    }

    public int getRowCount(String sheetName) throws IOException {
        try (XSSFWorkbook workbook = getWorkbook()) {
            XSSFSheet sheet = workbook.getSheet(sheetName);
            return sheet.getLastRowNum();
        }
    }

    public int getCellCount(String sheetName, int rowNum) throws IOException {
        try (XSSFWorkbook workbook = getWorkbook()) {
            XSSFSheet sheet = workbook.getSheet(sheetName);
            XSSFRow row = sheet.getRow(rowNum);
            return row != null ? row.getLastCellNum() : 0;
        }
    }

    public String getCellData(String sheetName, int rowNum, int colNum) throws IOException {
        try (XSSFWorkbook workbook = getWorkbook()) {
            XSSFSheet sheet = workbook.getSheet(sheetName);
            XSSFRow row = sheet.getRow(rowNum);
            if (row == null) {
                return "";
            }
            XSSFCell cell = row.getCell(colNum);
            DataFormatter formatter = new DataFormatter();
            return cell != null ? formatter.formatCellValue(cell) : "";
        }
    }

    private XSSFWorkbook getWorkbook() throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            return new XSSFWorkbook(fileInputStream);
        }
    }
}