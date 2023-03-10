package homepage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//*[@class='mainLinkList']//*[contains(text(),'FLOWERS')]")
	WebElement Flowers;

	public HomePage() {
		PageFactory.initElements(driver, this);

	}

	public void clickOnFlowers() {
		Flowers.click();
	}
}
