package NAutomationTesting.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import NAutomationTesting.Abstract.AbstractComponents;

public class ProductCatelogPage extends AbstractComponents {

	WebDriver driver;

	public ProductCatelogPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

	@FindBy(css = ".mb-3")
	List<WebElement> products;

	By productsBy = By.cssSelector(".mb-3");
	By addCart = By.cssSelector(".card-body button:last-child");
	By toast = By.cssSelector("#toast-container");
	By animating=By.className(".ng-animating");

	public List<WebElement> getProductsList() {
		waitForWebElementToAppear(productsBy);
		return products;
	}

	public WebElement getProductName(String productName) {
		return products.stream()
				.filter(prod -> prod.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null);
	}

	public void addProductToCart(String productName) {
		getProductName(productName).findElement(addCart).click();
		waitForWebElementToAppear(toast);
		waitWebElementToDisappear(animating);
	}
}
