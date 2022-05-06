package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	@FindBy(xpath="//div[@class='form-header text-center']")private WebElement loginText;
	@FindBy(xpath="//input[@id='userid']") private WebElement userId;
	@FindBy(xpath="//input[@id='password']") private WebElement password;
	@FindBy(xpath="//button[@type='submit']") private WebElement login;
	@FindBy(xpath="//a[text()='Forgot user ID or password?']") private WebElement forgot;
	@FindBy(xpath="//a[@class='text-light']")private WebElement signUp;
	
	@FindBy(xpath="//input[@id='pin']")private WebElement pin;
	@FindBy(xpath="//button[@type='submit']")private WebElement continueButton;
	@FindBy(xpath="//a[text()='Forgot 2FA?']")private WebElement forgot2FA;
	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getLoginText() {
		return loginText.getText();
	}
	public void enterUserId(String id) {
		userId.sendKeys(id);
	}
	
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void clickOnLogin() {
		login.click();
	}
	
	public void clickOnForgot() {
		forgot.click();
	}
	
	public void clickOnSignUp() {
		signUp.click();
	}
	
	public void enterPin(String pinNo,WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(2000));
		wait.until(ExpectedConditions.visibilityOf(pin));
		pin.sendKeys(pinNo);
	}
	
	public void clickOnContinue() {
		continueButton.click();
	}
	
	public void clickOnForgot2FA() {
		forgot2FA.click();
	}
}
