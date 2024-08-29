package NAutomationTesting.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import NAutomationTesting.Abstract.AbstractComponents;

public class ordersPages extends AbstractComponents {
	WebDriver driver;

	public ordersPages(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "tr td:nth-child(3)")
	List<WebElement> orderProducts;

	@FindBy(css = "li button[type='button']")
	WebElement checkOutPage;

	public Boolean VerifyOrdrsDisplay(String ProductName) {

		Boolean match = orderProducts.stream().anyMatch(orderProd -> orderProd.getText().equalsIgnoreCase(ProductName));

		return match;
	}

	public CheckOutPage clickOnCheckoutButton() {
		checkOutPage.click();
		return new CheckOutPage(driver);
	}

}
