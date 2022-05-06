package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
	public static ExtentReports addReport() {
		ExtentSparkReporter esr = new ExtentSparkReporter("extentReport.html");
		ExtentReports er = new ExtentReports();
		
		er.attachReporter(esr);
		
		er.setSystemInfo("Project", "Kite-Zerodha");
		er.setSystemInfo("Tester", "Kunal Tikait");
		er.setSystemInfo("Environment", "SIT");
		er.setSystemInfo("Testing", "Regression");
		
		return er;
	}
}
