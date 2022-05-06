package tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.LoginPage;
import utilities.Excel;
import utilities.Screenshot;

public class LoginTest {
	WebDriver driver;
@BeforeMethod
public void launchBrowser() {
	driver = Browser.openBrowser("https://kite.zerodha.com/");
}

@Test 
public void loginWithValidCredentials() throws EncryptedDocumentException, IOException, InterruptedException {
 LoginPage loginpage = new LoginPage(driver);
 String userId = Excel.getData("Credentials", 0, 1);
 loginpage.enterUserId(userId);
 String password = Excel.getData("Credentials", 1, 1);
 loginpage.enterPassword(password);
 loginpage.clickOnLogin();
 String pin = Excel.getData("Credentials", 2, 1);
 loginpage.enterPin(pin, driver);
 loginpage.clickOnContinue();
}
@Test
public void clickOnForgotUserIDOrPassword() {
	LoginPage loginpage = new LoginPage(driver);
	loginpage.clickOnForgot();
}
@Test
public void clickOnSignUp() {
	LoginPage loginpage = new LoginPage(driver);
	loginpage.clickOnSignUp();
	
}
@AfterMethod
public void afterMethod() throws IOException {
	Screenshot obj = new Screenshot();
	obj.getScreeshot(driver, "ZerodhaLogin");
}
}











