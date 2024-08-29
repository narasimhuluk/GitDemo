package NAutomationTesting.PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import NAutomationTesting.Abstract.AbstractComponents;

public class LoginPage extends AbstractComponents {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement userEmail=driver.findElement(By.id("userEmail"));

	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement password;

	@FindBy(id = "login")
	WebElement submit;

	@FindBy(css = ".ng-tns-c4-28.toast-message")
	WebElement errorMsg;

	By errMsg = By.cssSelector(".ng-tns-c4-28.toast-message");

	public String getErrorMsg() throws InterruptedException {
		waitForWebElementToAppear(errMsg);
		return errorMsg.getText();
	}

	public ProductCatelogPage getloginIntoApp(String username, String passwords) {
		userEmail.sendKeys(username);
		password.sendKeys(passwords);
		submit.click();
		return new ProductCatelogPage(driver);
	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
}
