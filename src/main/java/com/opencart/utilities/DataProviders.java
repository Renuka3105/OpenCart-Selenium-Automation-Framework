package com.opencart.utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "LoginData")
    public Object[][] getLoginData() {

        String filePath = System.getProperty("user.dir")
                + "/src/main/resources/testdata.xlsx";

        ExcelUtility excelUtility =
                new ExcelUtility(filePath, "LoginData");

        Object[][] data = excelUtility.getExcelData();

        excelUtility.closeWorkbook();

        return data;
    }
}