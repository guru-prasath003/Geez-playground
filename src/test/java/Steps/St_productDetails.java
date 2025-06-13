package Steps;

import org.junit.Assert;

import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Then;
import pageObjects.ProductDetails;
import selenium.Waits;

public class St_productDetails {

	TestContext testContext;
	ProductDetails productDetails;
	Object context;

	public St_productDetails(TestContext context) {
		testContext = context;
		productDetails = testContext.getPageManager().getProductDetails();
	}

	@Then("verify its navigated successfully")
	public void message_displayed_login_successfully() throws InterruptedException {
		Waits.waitTillPageLoads(testContext.getWebDriverManager().getDriver());
		context = testContext.getScenContext().getContext(Context.product_name.toString());
		System.out.println(context);
		if (productDetails.verifyIsNavigated()) {
			System.out.println(context + "'s Price : " + productDetails.retrievePriceTag());
			Assert.assertNotEquals(context, productDetails.retrieveNameTag());
			System.out.println("CUCUMBERR WORKSSSS");
		}

	}

}
