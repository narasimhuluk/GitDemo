package NAutomationTesting.Abstract;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import NAutomationTesting.PageObjects.CartPage;
import NAutomationTesting.PageObjects.CheckOutPage;
import NAutomationTesting.PageObjects.ordersPages;

public class AbstractComponents {

	WebDriver driver;

	public AbstractComponents(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "button[routerlink='/dashboard/cart']")
	WebElement cartButton;
	
	@FindBy(css = "button[routerlink='/dashboard/myorders']")
	WebElement ordersButton;

	public ordersPages goToOrdersPage() {
		ordersButton.click();
		return new ordersPages(driver);
	}
	
	public CartPage goToCartPage() {
		cartButton.click();
		return new CartPage(driver);
	}

	public void waitForWebElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void waitWebElementToDisappear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));

	}

}
