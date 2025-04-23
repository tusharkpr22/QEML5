package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ScreenShotUtils {
    public String takeFullPageScreenshot(WebDriver driver,String fileName)throws IOException{

        TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
        File screenshot= takesScreenshot.getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String targetFileName=System.getProperty("user.dir")+"./screenshots/"+fileName + "_" + timestamp + ".png";
            FileUtils.copyFile(screenshot,new File("./screenshots/"+fileName + "_" + timestamp + ".png"));
         return targetFileName;
    }
}
