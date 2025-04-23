package ui.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.ScreenShotUtils;
import utilities.webdriverfactory.DriverManager;

public class ListenerImplementationClass implements ITestListener {
    private static final Logger logger=  LogManager.getLogger(ListenerImplementationClass.class);

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test successfull");
    }

    @Override
    public void onTestFailure(ITestResult result) {

//        ScreenShotUtils screenShotUtils=new ScreenShotUtils();
//        String filename= result.getName();
//        screenShotUtils.takeFullPageScreenshot(DriverManager.getInstance().getDriver(),filename );
        logger.error("test failed capturing screenshot");
    }
}
