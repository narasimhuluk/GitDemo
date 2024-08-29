package NAutomationTesting.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import NAutomationTesting.Abstract.AbstractComponents;

public class CartPage extends AbstractComponents {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".cartSection h3")
	List<WebElement> cartProducts;

	@FindBy(css = "li button[type='button']")
	WebElement checkOutPage;

	public Boolean VerifyProductDisplay(String ProductName) {

		Boolean match = cartProducts.stream().anyMatch(cartProdu -> cartProdu.getText().equalsIgnoreCase(ProductName));

		return match;
	}

	public CheckOutPage clickOnCheckoutButton() {
		checkOutPage.click();
		return new CheckOutPage(driver);
	}

}
