package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportManager {

    private static ExtentReports extentReports;
    private static ExtentTest extentTest;
    private static ThreadLocal<ExtentTest> tlTest = new ThreadLocal<>();

    public static void initReport() {
        extentReports = new ExtentReports();
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("target/bank.html");
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setDocumentTitle("XYZ Bank Report");
        extentReports.attachReporter(extentSparkReporter);
    }

    public static void createExtentTest(String testName){
        extentTest = extentReports.createTest(testName);
        tlTest.set(extentTest);
    }

    public static ExtentTest getExtentTest(){
        return tlTest.get();
    }

    public static void closeReport(){
        extentReports.flush();
    }

}