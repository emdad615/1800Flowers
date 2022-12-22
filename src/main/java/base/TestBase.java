package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {
	public static WebDriver driver;

	public static void initialization() {
		System.setProperty("webdriver.chrome.driver",

				"/Users/emdadhoque/Developments/Repository/1800Flowers/drivers/chromedriver");

		ChromeOptions options = new ChromeOptions();

		options.addArguments("disable-notifications");

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.1800flowers.com");

	}

}
