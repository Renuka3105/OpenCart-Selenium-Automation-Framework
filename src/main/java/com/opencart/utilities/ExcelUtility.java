package com.opencart.utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtility {

    private XSSFWorkbook workbook;
    private Sheet sheet;

    public ExcelUtility(String filePath, String sheetName) {

        try {
            FileInputStream file = new FileInputStream(filePath);

            workbook = new XSSFWorkbook(file);

            sheet = workbook.getSheet(sheetName);

        } catch (IOException e) {
            throw new RuntimeException("Unable to load Excel file : " + e.getMessage());
        }
    }

    public int getRowCount() {
        return sheet.getLastRowNum();
    }

    public int getColumnCount() {
        return sheet.getRow(0).getLastCellNum();
    }

    public String getCellData(int rowNum, int colNum) {

        DataFormatter formatter = new DataFormatter();

        Row row = sheet.getRow(rowNum);

        return formatter.formatCellValue(row.getCell(colNum));
    }

    public Object[][] getExcelData() {

        int rows = getRowCount();
        int cols = getColumnCount();

        Object[][] data = new Object[rows][cols];

        for (int i = 1; i <= rows; i++) {

            for (int j = 0; j < cols; j++) {

                data[i - 1][j] = getCellData(i, j);

            }
        }

        return data;
    }

    public void closeWorkbook() {

        try {

            workbook.close();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}