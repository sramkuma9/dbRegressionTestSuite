package bni.regression.libraries.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

public class ReadWriteExcel {
    public FileInputStream fis = null;
    public FileOutputStream fos = null;
    public Workbook workbook = null;
    public Sheet sheet = null;
    public Row row = null;
    public Cell cell = null;
    private String dataCellValue = null;

    public void setExcelFile(String xlFilePath) throws Exception {
        fis = new FileInputStream(xlFilePath);
        workbook = WorkbookFactory.create(fis);
        fis.close();
    }

    public String getCellData(String sheetName, int colNumber, int rowNumber) throws InvalidFormatException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
        //Create Workbook instance holding reference to .xlsx file
        Sheet s = workbook.getSheet(sheetName);
        Row r = s.getRow(rowNumber);
        Cell d = r.getCell(colNumber);
        try {
            dataCellValue = d.getStringCellValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataCellValue;
    }

    public boolean setCellData(String fileName, String sheetName, int colNumber, int rowFlag, String value) {
        try {
            sheet = workbook.getSheet(sheetName);
            int rowNum = sheet.getLastRowNum();
            if (rowFlag == 1) {
                rowNum = rowNum - 1;
            }
            row = sheet.getRow(rowNum + 1);
            if (row == null)
                row = sheet.createRow(rowNum + 1);

            cell = row.getCell(colNumber);
            if (cell == null)
                cell = row.createCell(colNumber);
            cell.setCellValue(value);

            fos = new FileOutputStream(fileName);
            workbook.write(fos);
            fos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean setSqlCount(String fileName, String sheetName, int colNumber, int rowFlag, String value) {
        try {
            sheet = workbook.getSheet(sheetName);
            row = sheet.getRow(1);
            if (row == null)
                row = sheet.createRow(1);

            cell = row.getCell(colNumber);
            if (cell == null)
                cell = row.createCell(colNumber);
            cell.setCellValue(value);

            fos = new FileOutputStream(fileName);
            workbook.write(fos);
            fos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean deleteCellData(String fileName, String sheetName, int colNumber) {
        try {
            sheet = workbook.getSheet(sheetName);
            int rowNum = sheet.getLastRowNum();
            for (int i = 1; i <= rowNum; i++) {
                Row row = sheet.getRow(i);
                row.removeCell(row.getCell(colNumber));
                fos = new FileOutputStream(fileName);
                workbook.write(fos);
                fos.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}