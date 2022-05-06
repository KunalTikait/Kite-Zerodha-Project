package tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pojo.Browser;
import pom.LoginPage;
import utilities.Excel;

public class LoginTestWithAssertions {
	WebDriver driver;
@BeforeMethod
public void launchBrowser() {
	driver = Browser.openBrowser("https://kite.zerodha.com/");
}

@Test 
public void verifyLoginTextByHardAssert() throws EncryptedDocumentException, IOException, InterruptedException {
 LoginPage loginpage = new LoginPage(driver);
 
 String actualText = loginpage.getLoginText();
 String expectedText = "Login Kite";
 Assert.assertEquals(actualText, expectedText);
 
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
public void verifyLoginTextBySoftAssert() throws EncryptedDocumentException, IOException {
	LoginPage loginpage = new LoginPage(driver);
	
	String actualText = loginpage.getLoginText();
	String expectedText = "Login Kite";
	SoftAssert assertion = new SoftAssert();
	assertion.assertEquals(actualText, expectedText);
	
	String userId = Excel.getData("Credentials", 0, 1);
	loginpage.enterUserId(userId);
	String password = Excel.getData("Credentials", 1, 1);
	loginpage.enterPassword(password);
	loginpage.clickOnLogin();
	String pin = Excel.getData("Credentials", 2, 1);
	loginpage.enterPin(pin, driver);
	loginpage.clickOnContinue();
	
	assertion.assertAll();
}
}











