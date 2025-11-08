package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.WaitHelper;

public class UserFormPage {
	WebDriver driver;
	WaitHelper wait;
	
	public UserFormPage(WebDriver driver) {
	    this.wait = new WaitHelper(driver);
	}


	By adminBtn = By.xpath("//span[text()='Admin']");
	By addBtn = By.xpath("//button[text()=' Add ']");
	
	By userRoleField = By.xpath("(//div[@class='oxd-select-text-input'])[1]");
	By employeeNameField = By.xpath("//input[@placeholder='Type for hints...']");
	By statusField = By.xpath("(//div[@class='oxd-select-text-input'])[2]");
	By userNameField = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
	By passwordField = By.xpath("(//span[text()='Configuration ']/following::input)[3]");
	By confirmPasswordField = By.xpath("//label[text()='Confirm Password']/following::input"); 
	By saveBtn = By.xpath("//button[text()=' Save ']");
	
	public void navigateToAdmin() {
		wait.waitForElementVisible(adminBtn, 10);
		wait.waitForElementClickable(adminBtn, 10).click();
	}
	
	public void clickAddBtn() {
		wait.waitForElementVisible(addBtn, 10);
		wait.waitForElementClickable(addBtn, 10).click();
	}
	
	public void selectUserRole(String Role) {
		wait.waitForElementVisible(userRoleField, 10);
		wait.waitForElementClickable(userRoleField, 10).click();
		By selectRole = By.xpath("//div[@role='option']//span[text()='" + Role + "']");
		switch (Role.toLowerCase()) {
		
		case "admin":
			wait.waitForElementClickable(selectRole, 10).click();
			break;
			
		case "ess":
			wait.waitForElementClickable(selectRole, 10).click();
			break;
		default:
			System.out.println("Invalid Role");
			break;
		}
	}

	public void chooseEmployeeName(String eName) {
		wait.waitForElementVisible(employeeNameField, 10);
		WebElement suggestion = wait.waitForElementClickable(employeeNameField, 10);
		suggestion.sendKeys(eName);
		suggestion.sendKeys(Keys.ARROW_DOWN);
		suggestion.sendKeys(Keys.ENTER);
	}

	public void selectStatus(String Status) {
		wait.waitForElementVisible(statusField, 10);
		wait.waitForElementClickable(statusField, 10).click();
		By selectStatus = By.xpath("//div[@role='option']//span[text()='" + Status + "']");
		switch (Status.toLowerCase()) {
		
		case "enabled":
			wait.waitForElementClickable(selectStatus, 10).click();
			break;
			
		case "disabled":
			wait.waitForElementClickable(selectStatus, 10).click();
			break;
		default:
			System.out.println("Invalid Status");
			break;
		}
	}

	public void enterUserName(String uName) {
		wait.waitForElementVisible(userNameField, 10);
		wait.waitForElementClickable(userNameField, 10).sendKeys(uName);
	}

	public void enterPassword(String Password) {
		wait.waitForElementVisible(passwordField, 15);
		wait.waitForElementClickable(passwordField, 15).sendKeys(Password);
	}

	public void enterConfirmPassword(String ConfirmPassword) {
		wait.waitForElementVisible(confirmPasswordField, 15);
		wait.waitForElementClickable(confirmPasswordField, 15).sendKeys(ConfirmPassword);
	}
	
	public void clickSaveBtn() {
		wait.waitForElementClickable(saveBtn, 15).click();
	}
	
	public void CreateNewUser(String Role, String eName, String Status, String uName, String Password, String ConfirmPassword) {
		selectUserRole(Role);
		chooseEmployeeName(eName);
		selectStatus(Status);
		enterUserName(uName);
		enterPassword(Password);
		enterConfirmPassword(ConfirmPassword);
		clickSaveBtn();
	}
}
