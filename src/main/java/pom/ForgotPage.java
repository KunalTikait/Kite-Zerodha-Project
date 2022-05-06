package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPage {
@FindBy(xpath="//img[@alt='Kite']")private WebElement logo;
@FindBy(xpath="//h2[text()='Forgot user ID or password?']")private WebElement forgotText;
@FindBy(xpath="//label[@for='radio-56']")private WebElement rememberId;
@FindBy(xpath="//label[@for='radio-57']")private WebElement forgotId;
@FindBy(xpath="//input[@placeholder='User ID']")private WebElement userId;
@FindBy(xpath="//input[@placeholder='PAN']")private WebElement pan;
@FindBy(xpath="//label[@for='radio-61']")private WebElement email;
@FindBy(xpath="//label[@for='radio-62']")private WebElement sms;
@FindBy(xpath="//input[@placeholder='E-mail (as on account)']")private WebElement emailId;
@FindBy(xpath="//div[@class='reset-captcha']")private WebElement resetCaptcha;
@FindBy(xpath="//img[contains(@src,'data:image/png;base64')]")private WebElement captchaImg;
@FindBy(xpath="//input[@placeholder='Captcha']")private WebElement captcha;
@FindBy(xpath="//button[@type='submit']")private WebElement reset;
@FindBy(xpath="//a[contains(@class,'text-xsmall')]")private WebElement backToLogin;

public ForgotPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public void verifyLogo() {
	logo.isDisplayed();
}
public String verifyForgotTextd() {
	return forgotText.getText();
}
public void clickOnRememberId() {
	rememberId.click();
}
public void clickOnForgotId() {
	forgotId.click();
}
public void insertUserId(String id) {
	userId.sendKeys(id);
}
public void insertPANNo(String panNo) {
	pan.sendKeys(panNo);
}
public void clickOnEmail() {
	email.click();
}
public void clickOnSMS() {
	sms.click();
}
public void insertEmailId(String emailID) {
	emailId.sendKeys(emailID);
}
public void clickOnResetCaptcha() {
	resetCaptcha.click();
}
public void verifyCaptchaImg() {
	captchaImg.isDisplayed();
}
public void insertCaptcha(String captchaNo) {
	captcha.sendKeys(captchaNo);
}
public void clickOnReset() {
	reset.click();
}
public void clickOnBackToLogin() {
	backToLogin.click();
}

}









