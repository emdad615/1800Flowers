package homepageflowerstest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;

public class HomePageTest extends TestBase {
	homepage.HomePage home;
	
	public HomePageTest() {
		super();
	}

	@BeforeMethod

	public void setup() throws Exception {
		initialization();

		home = new homepage.HomePage();

	}

	@Test
	public void clickOnFlowersTest() {
		home.clickOnFlowers();
		System.out.println("clicked");
	}

	@AfterMethod
	public void teardown() {
		driver.quit();

	}

}
