package tests;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPage;
import pages.UserFormPage;
import utils.WaitHelper;

public class ValidateActivities extends BaseTest {

	WaitHelper wait;
	
	By userNameInput = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
	By searchBtn = By.xpath("//button[text()=' Search ']");
	By webTable = By.xpath("//div[@role='table']");


	@Test
	public void validation() {
		wait = new WaitHelper(driver);

		// Step 1: Login
		LoginPage login = new LoginPage(driver);
		login.loginToWeb("Admin", "admin123");

		// Step 2: Navigate to Admin Page
		UserFormPage navigate = new UserFormPage(driver);
		navigate.navigateToAdmin();

		// Step 3: Search & Verify user
		searchNewUser("Ranjith");
		
		// Step 4: Edit User
		editUserData("ESS", "Rahul  Das", "Disabled");
		
		// Step 5: Validate Updated Details
		printUpdatedData("Ranjith");
		
		// Step 6: Delete User
		deleteUser("Ranjith");
	}

	public void searchNewUser(String user) {
		
		wait.waitForElementVisible(userNameInput, 10);
		wait.waitForElementClickable(userNameInput, 10).sendKeys(user);
		wait.waitForElementClickable(searchBtn, 10).click();

		wait.waitForElementVisible(webTable, 10);
		By userRow = By.xpath("//div[normalize-space(text())='" + user + "']");
		wait.waitForElementVisible(userRow, 20);

		Assert.assertTrue(driver.findElements(userRow).size() > 0, "User not found in table: " + user);
		System.out.println(" User verified in table: " + user);
	}

	public void editUserData(String Role, String eName, String Status ) {
		By pencilIcon = By.xpath("//i[@class='oxd-icon bi-pencil-fill']");
		wait.waitForElementVisible(pencilIcon, 15);
		wait.waitForElementClickable(pencilIcon, 10).click();
		
		UserFormPage edit = new UserFormPage(driver);
		edit.selectUserRole(Role);
		edit.chooseEmployeeName(eName);
		edit.selectStatus(Status);
		edit.clickSaveBtn();
	}
	 
	public void printUpdatedData(String user) {
		    wait.waitForElementVisible(userNameInput, 10);
		    wait.waitForElementClickable(userNameInput, 10).sendKeys(user);
		    wait.waitForElementClickable(searchBtn, 10).click();
		    
		    wait.waitForElementVisible(webTable, 10);
		    
		    // Locate the row containing the user name
		    By userRow = By.xpath("//div[@role='row' and .//div[normalize-space(text())='" + user + "']]");
		    wait.waitForElementVisible(userRow, 20);

		    // Fetch all columns in that row
		    List<WebElement> columns = driver.findElements(By.xpath("//div[@role='row' and .//div[normalize-space(text())='" + user + "']]//div[@role='cell']"));

		    // Print all column data
		    System.out.println("Details for user '" + user + "':");
		    for (WebElement col : columns) {
		        System.out.print(col.getText() + " | ");
		    }
		    System.out.println(); // line break after row
		    
		    // Assertion check
		    Assert.assertTrue(columns.size() > 0, "User not found in table: " + user);
	}
	
	public void deleteUser(String user) {
		By TrashBinIcon = By.xpath("//i[@class='oxd-icon bi-trash']");
		wait.waitForElementVisible(TrashBinIcon, 15);
		wait.waitForElementClickable(TrashBinIcon, 10).click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		By userRow = By.xpath("//div[normalize-space(text())='" + user + "']");
		wait.waitForElementVisible(userRow, 20);

		Assert.assertFalse(driver.findElements(userRow).size() > 0, "User not found in table: " + user);
		System.out.println(user+" Successfully Deleted");
	}
}