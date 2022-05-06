package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
@FindBy(xpath="//h2[text()='Signup now']")private WebElement signUpText;
@FindBy(xpath="//input[@id='user_mobile']")private WebElement mob;
@FindBy(xpath="//button[@type='submit']")private WebElement continueButton;
@FindBy(xpath="//a[text()='Want to open an NRI account?']")private WebElement nriAcc;

public SignUpPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public String verifySignUpText() {
	return signUpText.getText();
}
public void insertMobileNo(String mobNo) {
	mob.sendKeys(mobNo);
}
public void clickOnContinue() {
	continueButton.click();
}
public void clickOnNriAcc() {
	nriAcc.click();
}
}
