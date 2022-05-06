package listeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenerClass.class)
public class DemoTest {
	@Test
	public void test1() {
		System.out.println("Test 1");
	}
	@Test
	public void test2() {
		Assert.assertTrue(false);
		System.out.println("Test 2");
	}
	@Test(dependsOnMethods= {"test2"})
	public void test3() {
		System.out.println("Test3");
	}
}
