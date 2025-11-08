package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitHelper;

public class LoginPage {
	WebDriver driver;
	WaitHelper wait;
	
	public LoginPage(WebDriver driver) {
        this.wait = new WaitHelper(driver);
    }
	
	By nameField = By.xpath("//input[@placeholder='Username']"); 
	By passwordField = By.xpath("//input[@placeholder='Password']"); 
	By loginBtn = By.xpath("//button[@type='submit']");
	
	public void enterUsername(String username) {
		wait.waitForElementClickable(nameField, 10).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		wait.waitForElementClickable(passwordField, 10).sendKeys(password);
	}
	
	public void clickLogin() {
		wait.waitForElementClickable(loginBtn, 10).click();
	}
	
	public void loginToWeb(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickLogin();
	}
}
