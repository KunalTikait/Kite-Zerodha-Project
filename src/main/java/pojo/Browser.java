package pojo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {
	public static WebDriver openBrowser (String url) {
		ChromeOptions options = new ChromeOptions();//ChromeOptions is a Class of Selenium
		options.addArguments("--disable-notifications");//to disable the chrome notification
//		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\ZerodhaProject\\src\\main\\resources\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\ZerodhaProject\\src\\main\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
}
