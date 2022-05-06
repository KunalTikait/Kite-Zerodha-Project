package utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {
	public static void getScreeshot(WebDriver driver , String name) throws IOException {
		String date = Screenshot.currentDate();
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destination = new File("D:\\Automation\\ZerodhaProject\\Screenshot\\"+name+""+date+".jpg");
		FileHandler.copy(source, destination);
	}
	
	public static String currentDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("(dd-MM-YYYY) (hh-mm-ss)");
		LocalDateTime now = LocalDateTime.now();
		String d = dtf.format(now);
		return d;
	}
}
