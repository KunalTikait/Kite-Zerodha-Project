package tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.DashboardPage;
import pom.LoginPage;
import utilities.Excel;

public class BuySellTest {
	WebDriver driver;
@BeforeMethod
public void launchBrowserAndLogin() throws EncryptedDocumentException, IOException, InterruptedException {
	 driver = Browser.openBrowser("https://kite.zerodha.com/");
	 LoginPage loginpage = new LoginPage(driver);
	 String userId = Excel.getData("Credentials", 0, 2);
	 loginpage.enterUserId(userId);
	 String password = Excel.getData("Credentials", 1, 2);
	 loginpage.enterPassword(password);
	 loginpage.clickOnLogin();
	 String pin = Excel.getData("Credentials", 2, 2);
	 loginpage.enterPin(pin, driver);
	 loginpage.clickOnContinue();
}

@Test
public void buyShare() throws EncryptedDocumentException, IOException, InterruptedException {
	DashboardPage dashboardpage = new DashboardPage(driver);
	Assert.assertTrue(dashboardpage.verifyAvatar(driver));
	String shareName = Excel.getData("Credentials", 3, 2);
	dashboardpage.insertShareName(shareName);
	dashboardpage.selectFirstShare(driver);
	dashboardpage.clickOnBSymbol();
	dashboardpage.clickOnBuy();
}
@Test
public void sellShare() throws EncryptedDocumentException, IOException, InterruptedException {
	DashboardPage dashboardpage = new DashboardPage(driver);
	Assert.assertTrue(dashboardpage.verifyAvatar(driver));
	String shareName = Excel.getData("Credentials", 3, 2);
	dashboardpage.insertShareName(shareName);
	dashboardpage.selectFirstShare(driver);
	dashboardpage.clickOnSSymbol();
	dashboardpage.clickOnSell();
}
}
