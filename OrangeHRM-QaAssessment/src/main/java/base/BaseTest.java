package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.ExtentManager;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

public class BaseTest {
	protected WebDriver driver;
	protected static ExtentReports extent;
	protected ExtentTest test;

	@BeforeSuite
	// Initialize Report [Static makes ExtentReport global - one report for all test classes]
	public void startReport() {
		extent = ExtentManager.getInstance();
	}

	@BeforeClass
	// Launch Browser with URL
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@AfterMethod
	// TearDown [ITestResult - Report Card]
	public void tearDown(ITestResult result) {
		if (test != null) {
			if (result.getStatus() == ITestResult.FAILURE) { 
				test.log(Status.FAIL, "Test Failed: " + result.getThrowable());
				String path = takeScreenshot(result.getName());
				test.addScreenCaptureFromPath(path);} 
			
			else if (result.getStatus() == ITestResult.SUCCESS) {
				test.log(Status.PASS, "Test Passed");} 
			
			else {
				test.log(Status.SKIP, "Test Skipped");}
		}
	}

	
	  @AfterClass 
	  public void tearDown() { 
		  if (driver != null) { 
			  driver.quit();
			  System.out.println("Browser session closed after all student rows completed."); 
			  } 
		  }
	 

	@AfterSuite 
	public void endReport() {
		extent.flush(); }
   
	// Screenshot
	private String takeScreenshot(String testName) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String timestamp = String.valueOf(System.currentTimeMillis());
		String path = "reports/screenshots/" + testName + "_" + timestamp + ".png";
		File dest = new File(path);
		dest.getParentFile().mkdirs();
		try {
			Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
}
