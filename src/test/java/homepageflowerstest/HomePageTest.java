package homepageflowerstest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import base.TestBase;

public class HomePageTest extends TestBase {
	homepage.HomePage home;

	@BeforeMethod

	public void setup() {
		initialization();

		home = new homepage.HomePage();

	}

	/*
	 * @Test public void clickOnFlowersTest() { home.clickOnFlowers();
	 * 
	 * System.out.println("clicked"); }
	 */

	@AfterMethod
	public void teardown() {
		driver.quit();

	}

}
