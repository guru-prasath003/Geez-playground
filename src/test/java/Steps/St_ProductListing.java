package Steps;

import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.When;
import pageObjects.ProductListing;

public class St_ProductListing {

	TestContext testContext;
	ProductListing prodListing;
	String productName;

	public St_ProductListing(TestContext context) {
		testContext = context;
		prodListing = testContext.getPageManager().getProductList();
	}

	@When("User selects and navigate into details")
	public void user_verifies_details() {
		productName = prodListing.selectProduct();
		testContext.getScenContext().setContext(Context.product_name.toString(), productName);
	}

}
