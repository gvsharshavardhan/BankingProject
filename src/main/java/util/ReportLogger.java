package util;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ReportLogger {

    public static void info(String message){
        ReportManager.getExtentTest().info(message);
    }
    public static void pass(String message){
        ReportManager.getExtentTest().pass(message);
    }
    public static void fail(String message){
        ReportManager.getExtentTest().fail(message);
    }
    public static void infoAndScreenShot(String message){
        ReportManager.getExtentTest().info(message);
        ReportManager.getExtentTest().info(takeScreenShot());
    }
    public static void passAndScreenShot(String message){
        ReportManager.getExtentTest().pass(message);
        ReportManager.getExtentTest().pass(takeScreenShot());
    }
    public static void failAndScreenShot(String message){
        ReportManager.getExtentTest().fail(message);
        ReportManager.getExtentTest().fail(takeScreenShot());
    }

    public static Media takeScreenShot(){
        String screenshot =  ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
        return MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build();
    }

}