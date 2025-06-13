package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductListing {

	WebDriver driver;

	public ProductListing(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='_75nlfW']//a[1]")
	private List<WebElement> itemList;

	@FindBy(xpath = "//div[@class='_75nlfW']//a[@title[1]]")
	private List<WebElement> itemNameList;

	public String selectProduct() {
		String name = itemNameList.get(0).getText();
		itemList.get(0).click();
		String winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			if (!winHandle.equals(winHandleBefore))
				driver.switchTo().window(winHandle);
		}
		return name;
	}

}
