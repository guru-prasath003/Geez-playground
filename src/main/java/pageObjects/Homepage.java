package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import selenium.Waits;

public class Homepage {
	private WebDriver driver;

	public Homepage(WebDriver driver) { // to connect to other class constructor
		this.driver = driver; // initialized to use driver in this page
		PageFactory.initElements(driver, this); // initialized to use or share methods to different teststeps
	}

	@FindBy(how = How.CSS, using = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!")
	private WebElement homepage;

	public void verifyFlipHome() {
		try {
			if (homepage.isDisplayed()) {
				System.out.println("User is in Filp's home");
			}
		} catch (Exception e) {
		}
	}

	public void navigateTo(String url) {
		driver.get(url);
	}

	public void globalSearchFor(String item) {
		driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']")).sendKeys(item);
		Waits.untiljQueryIsDone(driver, 20);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

}
