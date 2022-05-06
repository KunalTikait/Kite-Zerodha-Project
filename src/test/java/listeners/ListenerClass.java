package listeners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import utilities.Screenshot;

public class ListenerClass extends BaseTest implements ITestListener{
	
	public void onTestStart(ITestResult result) {//run at start of every test
		System.out.println("Test has started :- "+result.getName());
	}
	
	public void onTestSuccess(ITestResult result) {//execute when test pass
		System.out.println(result.getName()+" :- Test is passed");
	}
	
	public void onTestFailure(ITestResult result) {//execute when test fail
		System.out.println("Test Failed :- "+result.getName());
		try {
			Screenshot.getScreeshot(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult result) {//execute when test skipped
		System.out.println(result.getName()+" :- Test skipped");
	}
}
