package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.webdriverfactory.DriverManager;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import java.util.List;



public class ExtentReportUtils implements ITestListener {
    public ExtentReports extentReports;
    public ExtentSparkReporter extentSparkReporter;
    public ExtentTest extentTest;
    String reportName;


    public void onStart(ITestContext context) {
        String timestamp = java.time.format.DateTimeFormatter.ofPattern("yyyy.MM.dd.HH.mm.ss")
                .format(java.time.LocalDateTime.now());
        reportName = "Test-Report-" + timestamp + ".html";
        extentSparkReporter = new ExtentSparkReporter(".\\reports\\" + reportName);
        extentSparkReporter.config().setDocumentTitle("JHIPSTER Automation Report");
        extentSparkReporter.config().setReportName("JHIPSTER Functional Testing");
        extentSparkReporter.config().setTheme(Theme.DARK);

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        extentReports.setSystemInfo("Application", "opencart");
        extentReports.setSystemInfo("Module", "Admin");
        extentReports.setSystemInfo("Sub Module", "Customers");
        extentReports.setSystemInfo("User Name", System.getProperty("user.name"));
        extentReports.setSystemInfo("Environment", "QA");

        String operatingSystem = context.getCurrentXmlTest().getParameter("operatingSystem");
        extentReports.setSystemInfo("Operating System", operatingSystem);
        String browser = context.getCurrentXmlTest().getParameter("browser");
        extentReports.setSystemInfo("Browser", browser);

        List<String> includedGroups = context.getCurrentXmlTest().getIncludedGroups();
        if (!includedGroups.isEmpty()) {
            extentReports.setSystemInfo("Groups", includedGroups.toString());
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest=extentReports.createTest(result.getTestClass().getName());
        extentTest.assignCategory(result.getMethod().getGroups());
        extentTest.log(Status.PASS,result.getName()+"executed successfully");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest=extentReports.createTest(result.getTestClass().getName());
        extentTest.assignCategory(result.getMethod().getGroups());
        extentTest.log(Status.FAIL,result.getName()+"got failed");
        extentTest.log(Status.INFO,result.getThrowable().getMessage());
//        try{
//
////            String imagePath=new ScreenShotUtils().takeFullPageScreenshot(DriverManager.getInstance().getDriver(), result.getName());
////            extentTest.addScreenCaptureFromPath(imagePath);
//
//        }catch(IOException exception){
//            exception.printStackTrace();
//        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest=extentReports.createTest(result.getTestClass().getName());
        extentTest.assignCategory(result.getMethod().getGroups());
        extentTest.log(Status.FAIL,result.getName()+"got failed");
        extentTest.log(Status.INFO,result.getThrowable().getMessage());
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
        String pathOfExtentReport=System.getProperty("user.dir")+"\\reports\\"+reportName;
        File extentReport=new File(pathOfExtentReport);
        try{
            Desktop.getDesktop().browse(extentReport.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
