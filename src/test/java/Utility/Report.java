package Utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Report {

public static ExtentSparkReporter extentSparkReporter;
	
	public static ExtentReports extentReports;
	
	public static ExtentTest extentTest;
	
	public static  ExtentTest node;
	public static void startReport() {

		extentSparkReporter = new ExtentSparkReporter(
				"C:\\Users\\vikram.sreenivasulu\\eclipse-workspace\\laurel-mes\\Reports\\htmlReport.html");
		
		extentSparkReporter.config().setDocumentTitle("Laurel-MES Automation Report");
		extentSparkReporter.config().setTheme(Theme.DARK);
		extentSparkReporter.config().setReportName("Laurel-MES");
		extentSparkReporter.config().setEncoding("utf-8");
		
		
		extentSparkReporter.config().setCss(

				/* ===== GLOBAL FONT & CLEAN UI ===== */
				"body { font-family: 'Segoe UI', sans-serif; }" +

				/* ===== TEST BLOCK (LEFT PANEL) ===== */
				".test-item.pass { background: linear-gradient(90deg, #1f4037, #99f2c9) !important; color:black !important; border-radius:10px; }" +

				/* ===== NODE (Login Page / Login Issue) ===== */
				".card { border-radius:12px !important; overflow:hidden; margin-bottom:15px; }" +
				".card-header { border-radius:12px !important; }" +

				/* ===== PASS NODE GREEN ===== */
				".card-header:has(.pass-bg) { background: linear-gradient(90deg, #00b09b, #96c93d) !important; color:black !important; }" +

				/* ===== FAIL NODE RED ===== */
				".card-header:has(.fail-bg) { background: #f8a5a5  !important; color:black !important; }" +


				
				/* ===== LOG ROWS ===== */
				".event-row:hover { background-color: rgba(255,255,255,0.05); }" +

				/* ===== BADGES ===== */
				".pass-bg { background-color: #28a745 !important; }" +
				".fail-bg { background-color: #dc3545 !important; }" +
				".info-bg { background-color: #17a2b8 !important; }" +

				/* ===== SCREENSHOT BORDER ===== */
				"img { border-radius:8px; border:1px solid #444; }"


				);
		  
		extentReports= new ExtentReports();
		extentReports.setSystemInfo("Name", "Vikram");
		extentReports.setSystemInfo("Team", "Automation Team");
		extentReports.setSystemInfo("System", "CPLBNGLPT103");
		extentReports.attachReporter(extentSparkReporter);

	}
	
	public static void createTest(String testName) {
		 extentTest = extentReports.createTest(testName);

	}
	
	
	public static void Createnode(String testName) {
		 node = extentTest.createNode(testName);
		 node.pass(testName);

	}
	public static void pass(String testName) {
		node.pass(testName);

	}
	
	public static void fail(String testName) {
		node.fail(testName);
		String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
		String fileName =  "failed"+ "_" + timeStamp;
		String screenshotPath = caputreScreenshot(fileName);

		node.fail("Failed Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

	}
	
	public static void flush() {
		extentReports.flush();

	}
	
	public static void logInfo(String info) {
		node.info(info);

		
		String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
		String fileName = info + "_" + timeStamp;
		String screenshotPath = caputreScreenshot(fileName);

		node.info("Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	}
	
	public static String caputreScreenshot(String fileName) {
	    TakesScreenshot ts = (TakesScreenshot) BaseClass.driver;
	    File srcFile = ts.getScreenshotAs(OutputType.FILE);

	    String projectRoot = System.getProperty("user.dir");
	    
	    // Save screenshot relative to Reports folder
	    String relativePath = ".." + File.separator + "Screenshots" + File.separator + fileName + ".png";
	    String absolutePath = projectRoot + File.separator + "Screenshots" + File.separator + fileName + ".png";

	    File dest = new File(absolutePath);
	    dest.getParentFile().mkdirs();

	    try {
	        FileUtils.copyFile(srcFile, dest);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return relativePath; // Return relative path for HTML
	}//caputreScreenshot
	
}
