package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetails {

	WebDriver driver;

	public ProductDetails(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='Nx9bqj CxhGGd']")
	WebElement priceTag;

	@FindBy(xpath = "//span[@class='VU-ZEz']")
	WebElement NameTag;

	public boolean verifyIsNavigated() {
		return driver.findElement(By.xpath("//input[@placeholder='Enter Delivery Pincode']")).isDisplayed();
	}

	public String retrievePriceTag() {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));
		return priceTag.getText();
	}

	public String retrieveNameTag() {
		return NameTag.getText();
	}

}
