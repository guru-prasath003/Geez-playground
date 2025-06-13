package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.Homepage;
import pageObjects.ProductDetails;
import pageObjects.ProductListing;

public class PageManager {

	public WebDriver driver;
	Homepage home;
	ProductListing productListing;
	ProductDetails productDetails;

	public PageManager(WebDriver driver) {
		this.driver = driver;
	}

	public Homepage getHomePage() {
		return home == null ? home = new Homepage(driver) : home;

	}

	public ProductListing getProductList() {
		return productListing == null ? productListing = new ProductListing(driver) : productListing;
	}

	public ProductDetails getProductDetails() {
		return productDetails == null ? productDetails = new ProductDetails(driver) : productDetails;
	}

}
