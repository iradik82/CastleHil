package Utils;

import Steps.PageInitializer;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CommonMethods extends PageInitializer {

    public static WebDriver driver;

    public static void openBrowser(){

        ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        switch(ConfigReader.getPropertyValue("browser")){
            case "chrome":


                ChromeOptions chromeOptions=new ChromeOptions();
                chromeOptions.setHeadless(true);
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();

                break;

            case "firefox":

                FirefoxOptions firefoxOptions=new FirefoxOptions();
                firefoxOptions.setHeadless(true);
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();

                break;


            default:
                throw new RuntimeException("invalid browser name");
        }



        Dimension newDimension = new Dimension(1920,1080);
        driver.manage().window().setSize(newDimension);
        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
        initializePageObjects();


    }

    public static void closeBrowser(){
        driver.quit();
    }

    public static void sendText(WebElement element, String textToSend){
        element.clear();
        element.sendKeys(textToSend);
    }

    /*
    Method to get webDriver wait
     */

    public static WebDriverWait getWait(){
        WebDriverWait wait = new WebDriverWait(driver,Constants.EXPLICIT_WAIT);
        return wait;
    }


    public static void waitForClickability(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    /*
     method will perform click operation but before click,it will wait
     for element to be clickable
     */

    public static void click(WebElement element){
        waitForClickability(element);
        element.click();
    }



    /*
    Method to get TimeStamp for ScreenShot
     */

    public static String getTimeStamp(String pattern){
        Date date =new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return  sdf.format(date);
    }

    /*
    Method to Take Screenshots
     */

    public static byte[] takeScreenshot(String fileNmae){
        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(sourceFile,
                    new File(Constants.SCREENSHOT_FILEPATH + fileNmae + " " +
                            getTimeStamp("yyyy-MM-dd-HH-mm-ss")+".png"));
        }catch(IOException e){
            e.printStackTrace();
        }
        return picBytes;
    }
}
