package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

@FindBy(xpath="//div[@id='avatar-83']")private WebElement avatar;
@FindBy(xpath="//input[@icon='search']")private WebElement searchBox;
@FindBy(xpath="//ul[@class='omnisearch-results']//div//li[1]")private WebElement Firstshare;
@FindBy(xpath="//button[@data-balloon='Buy']")private WebElement BSymbol;
@FindBy(xpath="//input[@type='number']")private WebElement qty;
@FindBy(xpath="//button[@data-balloon='Sell']")private WebElement SSymbol;
@FindBy(xpath="//button[@type='submit']")private WebElement buyButton;
@FindBy(xpath="//button[@class='submit']")private WebElement sellButton;
public DashboardPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public boolean verifyAvatar(WebDriver driver) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000));
	wait.until(ExpectedConditions.visibilityOf(avatar));
	return avatar.isDisplayed();
}
public void insertShareName(String name) {
	searchBox.sendKeys(name);
}
public void selectFirstShare(WebDriver driver) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000));
	wait.until(ExpectedConditions.visibilityOf(Firstshare));
	Actions act = new Actions(driver);
	act.moveToElement(Firstshare);
	act.perform();
}

public void clickOnBSymbol() {
	BSymbol.click();
}

public void clickOnSSymbol() {
	SSymbol.click();
}
public void clickOnBuy() {
	buyButton.click();
}
public void clickOnSell() {
	sellButton.click();
}
}
