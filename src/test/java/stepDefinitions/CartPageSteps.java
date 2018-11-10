package stepDefinitions;

import org.testng.Assert;

import com.cucumber.listener.Reporter;

import cucumber.TestContext;
import cucumber.api.java.en.When;
import pageObjects.CartPage;

public class CartPageSteps {

	TestContext testContext;
	CartPage cartPage;

	public CartPageSteps(TestContext context) {
		testContext = context;
		cartPage = testContext.getPageObjectManager().getCartPage();
	}

	@When("^moves to checkout from mini cart$")
	public void moves_to_checkout_from_mini_cart(){
		cartPage.clickOn_Cart();
		Reporter.addScenarioLog("Clicked on Cart");
		cartPage.clickOn_ContinueToCheckout();	
		Assert.assertEquals("Failed to verify : ","abhi", "abhishek");
	}
}