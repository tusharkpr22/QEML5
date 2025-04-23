package ui.dataproviders;

import org.testng.annotations.DataProvider;
import utilities.ExcelUtils;

import java.io.IOException;

public class DataProviders {

    @DataProvider(name="loginData")
    public String[][] getLoginData() throws IOException {
        String path=".\\testdata\\jhipster_loginData.xlsx";
        ExcelUtils excelUtils=new ExcelUtils(path);
        int totalRows= excelUtils.getRowCount("Sheet1");
        int totalCols= excelUtils.getCellCount("Sheet1",1);
        String[][] logInData=new String[totalRows][totalCols];
        for (int i = 1; i <=totalRows ; i++) {
            for (int j = 0; j < totalCols; j++) {
                logInData[i-1][j]=excelUtils.getCellData("Sheet1",i,j);
            }

        }
        return logInData;
    }
    @DataProvider(name="registrationData")
    public String[][] getRegistrationData() throws IOException {
        String path=".\\testdata\\jhipster_registrationdata.xlsx";
        ExcelUtils excelUtils=new ExcelUtils(path);
        int totalRows= excelUtils.getRowCount("Sheet1");
        int totalCols= excelUtils.getCellCount("Sheet1",1);
        String[][] logInData=new String[totalRows][totalCols];
        for (int i = 1; i <=totalRows ; i++) {
            for (int j = 0; j < totalCols; j++) {
                logInData[i-1][j]=excelUtils.getCellData("Sheet1",i,j);
            }

        }
        return logInData;
    }
}
