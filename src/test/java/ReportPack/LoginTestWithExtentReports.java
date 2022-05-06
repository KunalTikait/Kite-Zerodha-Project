package ReportPack;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import listeners.BaseTest;
import listeners.ListenerClass;
import pojo.Browser;
import pom.LoginPage;
import utilities.Excel;
import utilities.Reports;
import utilities.Screenshot;
@Listeners(ListenerClass.class)
public class LoginTestWithExtentReports extends BaseTest {
//	WebDriver driver;
	ExtentReports er;
	ExtentTest et;
@BeforeClass
public void configureExtentReports() {
	er = Reports.addReport();
}
	
@BeforeMethod
public void launchBrowser() {
	driver = Browser.openBrowser("https://kite.zerodha.com/");
}

@Test 
public void loginWithValidCredentials() throws EncryptedDocumentException, IOException, InterruptedException {

 et = er.createTest("loginWithValidCredentials");
 
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
	
	et = er.createTest("clickOnForgotUserIDOrPassword");
	
	LoginPage loginpage = new LoginPage(driver);
	loginpage.clickOnForgot();
	Assert.assertTrue(false);
}
@Test(dependsOnMethods= {"clickOnForgotUserIDOrPassword"})
public void clickOnSignUp() {
	
	et = er.createTest("clickOnSignUp");
	
	LoginPage loginpage = new LoginPage(driver);
	loginpage.clickOnSignUp();
}
@Test
public void verifyLoginTextBySoftAssert() throws EncryptedDocumentException, IOException {
	
	et = er.createTest("verifyLoginTextBySoftAssert");
	
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
@AfterMethod
public void addTestResult(ITestResult result) {
	if(result.getStatus()==ITestResult.FAILURE) {
		et.log(Status.FAIL, result.getName());
	}
	else if(result.getStatus()==ITestResult.SUCCESS) {
		et.log(Status.PASS, result.getName());
	}
	else {
		et.log(Status.SKIP, result.getName());
	}
}
@AfterClass
public void flushResult() {
	er.flush();
}
}











