package stepDefinitions;

import org.testng.Assert;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import pageObjects.HomePage;

public class HomePageSteps {
	TestContext testContext;
	HomePage homePage;

	public HomePageSteps(TestContext context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
	}

	@Given("^user is on Home Page$")
	public void user_is_on_Home_Page() {
		homePage.navigateTo_HomePage();
	}

	@When("^he search for \"([^\"]*)\"$")
	public void he_search_for(String product) {
		homePage.perform_Search(product);
	}

	@When("^Execute fail step$")
	public void failStep() {
		Assert.assertEquals("new test", "new test fail");
	}

	@Given("^Step from \"([^\"]*) in \"([^\"]*) feature file$")
	public void step(String scenario, String file) {
		System.out.format("Thread ID - %2d - %s from %s feature file.\n", Thread.currentThread().getId(), scenario,
				file);
	}
}
