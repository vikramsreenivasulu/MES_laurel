package Utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Report {

	public static ExtentSparkReporter extentSparkReporter;

	public static ExtentReports extentReports;

	public static ExtentTest extentTest;

	public static ExtentTest node;

	public static void startReport() {

		extentSparkReporter = new ExtentSparkReporter(
				"C:\\Users\\vikram.sreenivasulu\\eclipse-workspace\\laurel-mes\\Reports\\htmlReport.html");

		extentSparkReporter.config().setDocumentTitle("Laurel-MES Automation Report");
		extentSparkReporter.config().setTheme(Theme.DARK);
		extentSparkReporter.config().setReportName("Laurel-MES");
		extentSparkReporter.config().setEncoding("utf-8");

		extentSparkReporter.config().setCss(

				/* ===== PASS NODE ===== */
				".card-header:has(.pass-bg) {" + "border-left: 1px solid #00c853 !important;"
						+ "color: #ffffff !important;" + "}" +

						/* ===== FAIL NODE ===== */
						".card-header:has(.fail-bg) {" + "border-left: 1px solid #ff5252 !important;"
						+ "color: #ffffff !important;" + "}" +

						/* ===== NODE TEXT ===== */
						".node-name {" + "color: #ffffff !important;" + "font-weight: 600 !important;" + "}" +

						/* ===== TEST NAME ===== */
						".test-name {" + "color: #ffffff !important;" + "}" +

						/* ===== SCREENSHOT ===== */
						"img {" + "border-radius: 6px;" + "border: 2px solid #d6d6d6;" + "}");

		extentReports = new ExtentReports();
		extentReports.setSystemInfo("Name", "Vikram");
		extentReports.setSystemInfo("Team", "Automation Team");
		extentReports.setSystemInfo("System", "CPLBNGLPT103");
		extentReports.attachReporter(extentSparkReporter);

	}
	
	

	public static void createTest(String testName) {
		extentTest = extentReports.createTest(testName);

	}

	public static void createNode(String testName) {
		node = extentTest.createNode(testName);
	}

	public static void pass(String pass) {

		String styledMessage = "<span style='color:#90ee90;'>" + pass + "</span>"; // #90ee90 is light green
		node.pass(styledMessage);

	}

	public static void fail(String fail) {
		// node.fail(fail);
		String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
		String fileName = "failed" + "_" + timeStamp;
		String screenshotPath = caputreScreenshot(fileName);

		String styledMessage = "<b><span style='color:#ff4c4c;'>" + fail + "</span></b>";
		node.fail(styledMessage);
		node.fail("Failed Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

	}

	public static void flush() {
		extentReports.flush();

	}

	public static void logInfo(String info) {

		// node.info(info);

		String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));

		String fileName = info + "_" + timeStamp;

		String screenshotPath = caputreScreenshot(fileName);

		node.info("<span style='color:#00bfff;'>" + info + "</span>");

		node.info("Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	}

	public static void screenshotBase64() {
		String base64Screenshot = ((TakesScreenshot) BaseClass.driver).getScreenshotAs(OutputType.BASE64);
		node.fail("Screenshot on failure:",
				MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
	}

	public static void screenshotBase64InTest() {
		String base64Screenshot = ((TakesScreenshot) BaseClass.driver).getScreenshotAs(OutputType.BASE64);
		extentTest.fail("Screenshot on failure:",
				MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
	}

	public static void failBase64(String fail) {
		String styledMessage = "<b><span style='color:#ff4c4c;'>" + fail + "</span></b>";
		node.fail(styledMessage);
		screenshotBase64();

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
	}// caputreScreenshot

	public static void getResult(ITestResult result) {

		String errorMessage = "";
		int status = result.getStatus();

		if (status == ITestResult.FAILURE) {

			errorMessage = result.getThrowable().getMessage();

			System.out.println(errorMessage);
			screenshotBase64InTest();
			extentTest.log(Status.FAIL, MarkupHelper.createLabel(errorMessage, ExtentColor.RED));
			extentTest.fail(MarkupHelper.createCodeBlock(ExceptionUtils.getStackTrace(result.getThrowable())));

		} else if (status == ITestResult.SKIP) {

			String methodName = result.getMethod().getMethodName();
			extentTest.log(Status.SKIP, MarkupHelper.createLabel(
					"<b>" + methodName + "----> SKIPPED" + "+_____________________+Ran on Local--->" + methodName,
					ExtentColor.ORANGE));

			extentTest.skip(result.getThrowable());

		} else if (status == ITestResult.SUCCESS) {

			String methodName = result.getMethod().getMethodName();
			extentTest.log(Status.PASS, MarkupHelper.createLabel(
					"<b>" + methodName + "----> PASSED" + "+_____________________+Ran on Local--->" + methodName,
					ExtentColor.GREEN));
		}
	}

}
