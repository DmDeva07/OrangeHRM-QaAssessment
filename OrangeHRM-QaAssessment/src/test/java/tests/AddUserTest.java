package tests;

import base.BaseTest;
import com.aventstack.extentreports.Status;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.UserFormPage;
import utils.TestDataReader;

public class AddUserTest extends BaseTest {
	
	@BeforeClass
    public void loginOnce() {
        test = extent.createTest("Login Session");

        LoginPage login = new LoginPage(driver);
        login.loginToWeb("Admin", "admin123");
        System.out.println("Successfully Login");
        test.log(Status.INFO, "Logged in successfully");
    }
	
    @DataProvider(name = "UserData")
    public Object[][] getData() {
        String filePath = "./testdata/UserData.xlsx";
        return TestDataReader.getExcelData(filePath, "Sheet1");
    }
    
    @Test(dataProvider = "UserData")
    public void VerifyNewUser(String Role, String eName, String Status, String uName, String Password, String ConfirmPassword) {
			
    	test = extent.createTest("Data-Driven User Creation: " + uName);
    	System.out.println("Session ID: " + ((RemoteWebDriver) driver).getSessionId());
    	System.out.println("Running test for: " + uName);

    	// Create Users
        UserFormPage add = new UserFormPage(driver);
       add.navigateToAdmin();
       add.CreateNewUser(Role, eName, Status, uName, Password, ConfirmPassword);
    }
}
