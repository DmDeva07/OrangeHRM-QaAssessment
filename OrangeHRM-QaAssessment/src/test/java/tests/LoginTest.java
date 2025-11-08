package tests;

import base.BaseTest;
import pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
	
	@Test
	public void verifyLoginFunctionality() {
		LoginPage login = new LoginPage(driver);
		login.loginToWeb("Admin", "admin123");
		System.out.println("Login test executed successfully");
		}
    }
