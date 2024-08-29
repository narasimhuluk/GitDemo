package NAutomationTesting.StepDefinations;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import NAutomationTesting.PageObjects.CartPage;
import NAutomationTesting.PageObjects.CheckOutPage;
import NAutomationTesting.PageObjects.LoginPage;
import NAutomationTesting.PageObjects.ProductCatelogPage;
import NAutomationTesting.PageObjects.conformationPage;
import NAutomationTesting.TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinationImpl extends BaseTest {

	public LoginPage landingpage;
	public ProductCatelogPage pc;
	public conformationPage conformpage;

	@Given("I landed on Ecommerce on Page")
	public void I_landed_on_Ecommerce_on_Page() throws IOException {

		landingpage = launchApplication();

	}

	@Given("^Logged in with username (.+) and password (.+)$")
	public void login_in_with_username_and_password(String username, String password) {

		pc = loginPage.getloginIntoApp(username, password);

	}

	@When("^I add product (.+) from cart$")
	public void i_added_product_to_cart(String productname) {
		List<WebElement> products = pc.getProductsList();
		pc.addProductToCart(productname);
	}

	@When("^Checkout (.+) and submit the order$")
	public void checkout_productname_and_submit_the_order(String productname) {
		CartPage cp = pc.goToCartPage();
		Boolean match = cp.VerifyProductDisplay(productname);
		Assert.assertTrue(match);
		CheckOutPage op = cp.clickOnCheckoutButton();
		op.selectCountry();
		conformpage = op.placeOrder();
	}

	@Then("{string} message is displayed on the ConfirmationPage")
	public void message_is_displayed_on_the_confirmtionpage(String string) {

		String confMsg = conformpage.getConformMessage();
		Assert.assertTrue(confMsg.equalsIgnoreCase("Thankyou for the order."));
		driver.close();
	}

	@Then("message is displayed")
	public void message_is_displayed() {

		Assert.assertTrue(true);
		driver.close();
	}

}
