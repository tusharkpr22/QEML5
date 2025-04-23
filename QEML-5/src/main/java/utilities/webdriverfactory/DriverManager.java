package utilities.webdriverfactory;

import customexceptions.InvalidBrowserException;
import org.openqa.selenium.WebDriver;

public class DriverManager {
//    private static final ThreadLocal<WebDriver> driverThreadLocal=new ThreadLocal<>();
//    private static DriverManager instance;
//    protected WebDriver driver;
//
//    private DriverManager(){}
//
//    public  static  DriverManager getInstance(){
////        if(instance==null){
////            synchronized (DriverManager.class){
//                if(instance==null){
//                    instance= new DriverManager();
//                }
////            }
////        }
//        return instance;
//    }
//
//    public WebDriver setDriver(String browser) {
//        if (driverThreadLocal.get() == null) {
//            driverThreadLocal.set(switch (browser.toLowerCase()) {
//                case "chrome" -> new ChromeDriverFactory().createDriver();
//                case "edge" -> new EdgeDriverFactory().createDriver();
//                default -> throw new InvalidBrowserException("invalid browser type");
//            });
//
//
//        }
//        return driverThreadLocal.get();
//    }
//    public  WebDriver getDriver() {
//        return driverThreadLocal.get();
//    }
//    public void cleanDriver(){
////        driver=driverThreadLocal.get();
////        if(driver!=null){
//            driverThreadLocal.get().quit();
//            driverThreadLocal.remove();
////        }
//    }

private static DriverManager instance;
    private static final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    public static WebDriver getThreadLocalDriver() {
        return threadLocalDriver.get();
    }

    public static void setThreadLocalDriver(String browser) {
        threadLocalDriver.set(getInstance().getDriver(browser));
    }

    public static void quitDriverAndRemove() {
        getThreadLocalDriver().quit();
        threadLocalDriver.remove();
    }

    private DriverManager() {}

    private synchronized static DriverManager getInstance() {
        if (instance == null){
            return instance = new DriverManager();
        }
        return instance;
    }

    private WebDriver getDriver(String browser){
        return switch (browser.toLowerCase()){
            case "chrome" -> new ChromeDriverFactory().createDriver();
            case "edge" -> new EdgeDriverFactory().createDriver();
//            case "firefox" -> new FirefoxDriverFactory().createDriver();
            default -> throw new InvalidBrowserException("Browser is not available");
        };
    }
}

