package NAutomationTesting.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import NAutomationTesting.Abstract.AbstractComponents;

public class CheckOutPage extends AbstractComponents {

	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();

	@FindBy(css = "input[placeholder='Select Country']")
	WebElement Country;

	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	WebElement selectCountry;
	
	@FindBy(css=".action__submit")
	WebElement placeOrder;

	By country = By.cssSelector(".ta-results");

	//driver.findElement(By.cssSelector(".action__submit")).click();
	
	public void selectCountry() {
		Actions a = new Actions(driver);
		a.sendKeys(Country, "india").build().perform();
		waitForWebElementToAppear(country);
		selectCountry.click();
	}
	
	public conformationPage placeOrder()
	{
		placeOrder.click();
		return new conformationPage(driver);
	}

}
