package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"/Users/emdadhoque/Developments/Repository/1800Flowers/src/test/resources/Config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	public static void initialization() throws Exception {
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("disable-notifications");
//		String browserName = prop.getProperty("browser");
//
//		if (browserName.equals("chrome")) {
//			System.setProperty("webdriver.chrome.driver",
//					"D:\\Selenium\\Eclipse Workplace\\1800Flowers\\drivers\\chromedriver.exe");
//			driver = new ChromeDriver(options);
//		} else if (browserName.equals("Firefox")) {
//			System.setProperty("webdriver.gecko.driver",
//					"D:\\Selenium\\Eclipse Workplace\\Heatclinic\\WebDrivers\\geckodriver.exe");
//			driver = new FirefoxDriver();
//		} else if (browserName.equalsIgnoreCase("Edge")) {
//			System.setProperty("webdriver.edge.driver",
//					"D:\\Selenium\\Eclipse Workplace\\Heatclinic\\WebDrivers\\msedgedriver.exe");
//			driver = new EdgeDriver();
//		} else {
//
//			throw new Exception("Browser is not correct, Please use Chrome, Firefox or Edge");
//		}
//
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//		driver.get(prop.getProperty("url"));
//
//	}

	public static void initialization() throws Exception {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");

		String browserName = prop.getProperty("browser");

		System.getProperty("os.name");
		System.out.println("My current operating system is " + System.getProperty("os.name"));

		if (System.getProperty("os.name").contains("Window")) {

			if (browserName.equals("Chrome")) {
				// System.setProperty("webdriver.chrome.driver",
				// "D:\\Selenium\\Eclipse
				// Workplace\\1800Flowers\\src\\test\\resources\\Driver\\chromedriver.exe");
				driver = new ChromeDriver(options);
//				System.setProperty("webdriver.chrome.driver",
//				System.getProperty("user.dir", "\\src\\test\\resources\\Driver\\chromedriver.exe"));	

			} else if (browserName.equals("Firefox")) {

				System.setProperty("webdriver.gecko.driver",
						"D:\\Selenium\\Eclipse Workplace\\1800Flowers\\src\\test\\resources\\Driver\\geckodriver.exe");
				driver = new FirefoxDriver();

			} else if (browserName.equalsIgnoreCase("Edge")) {

				System.setProperty("webdriver.edge.driver",
						"D:\\Selenium\\Eclipse Workplace\\1800Flowers\\src\\test\\resources\\Driver\\msedgedriver.exe");

				driver = new EdgeDriver();
			} else {

				throw new Exception("Browser is not correct, Please use Chrome, Firefox or Edge");
			}

		} else if (System.getProperty("os.name").contains("Linux")) {

			if (browserName.equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"D:\\Selenium\\Eclipse Workplace\\1800Flowers\\src\\test\\resources\\Driver\\chromedriver");
				driver = new ChromeDriver(options);

			} else if (browserName.equals("Firefox")) {

				System.setProperty("webdriver.gecko.driver",
						"D:\\Selenium\\Eclipse Workplace\\1800Flowers\\src\\test\\resources\\Driver\\geckodriver");
				driver = new FirefoxDriver();

			} else if (browserName.equalsIgnoreCase("Edge")) {

				System.setProperty("webdriver.edge.driver",
						"D:\\Selenium\\Eclipse Workplace\\1800Flowers\\src\\test\\resources\\Driver\\msedgedriver");

				driver = new EdgeDriver();
			} else {

				throw new Exception("Browser is not correct, Please use Chrome, Firefox or Edge");
			}

		} else if (System.getProperty("os.name").contains("Mac")) {
			if (browserName.equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"/Users/emdadhoque/Developments/Repository/1800Flowers/src/test/resources/Driver/chromedriver");
				driver = new ChromeDriver(options);

			} else if (browserName.equals("Firefox")) {

				System.setProperty("webdriver.gecko.driver",
						"/Users/emdadhoque/Developments/Repository/1800Flowers/src/test/resources/Driver/geckodriver");
				driver = new FirefoxDriver();

			} else if (browserName.equalsIgnoreCase("Edge")) {

				System.setProperty("webdriver.edge.driver",
						"/Users/emdadhoque/Developments/Repository/1800Flowers/src/test/resources/Driver/msedgedriver");

				driver = new EdgeDriver();
			} else {

				throw new Exception("Browser is not correct, Please use Chrome, Firefox or Edge");
			}

		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(prop.getProperty("url"));
	}

	public void HighlightElement(String xpath) {

		WebElement ele = driver.findElement(By.xpath(xpath));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].setAttribute('style', 'background: white; border: 4px solid yellow;');", ele);
	}

}
