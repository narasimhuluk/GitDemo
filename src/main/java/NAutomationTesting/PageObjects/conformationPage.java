package NAutomationTesting.PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import NAutomationTesting.Abstract.AbstractComponents;

public class conformationPage extends AbstractComponents {

	WebDriver driver;

	public conformationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//String successMsg = driver.findElement(By.cssSelector(".hero-primary")).getText();
	
	@FindBy(css=".hero-primary")
	WebElement conformMessage;

	public String getConformMessage()
	{
		return conformMessage.getText();
	}
	
}
