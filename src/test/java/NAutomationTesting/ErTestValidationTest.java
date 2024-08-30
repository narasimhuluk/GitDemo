package NAutomationTesting;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import NAutomationTesting.PageObjects.CartPage;
import NAutomationTesting.PageObjects.LoginPage;
import NAutomationTesting.PageObjects.CheckOutPage;
import NAutomationTesting.PageObjects.ProductCatelogPage;
import NAutomationTesting.PageObjects.conformationPage;
import NAutomationTesting.TestComponents.BaseTest;

public class ErTestValidationTest extends BaseTest {

	@Test(groups = { "ErrorHandling" }, retryAnalyzer = NAutomationTesting.TestComponents.Retry.class)
	public void ErrorMsg() throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		String productName = "ADIDAS ORIGINAL";
		ProductCatelogPage pc = loginPage.getloginIntoApp("anshika@gmail.com", "Iamki000");
		Assert.assertTrue(false);
	}

	@Test
	public void getTexterror11() throws InterruptedException {
		String productName = "ADIDAS ORIGINAL";
		ProductCatelogPage pc = loginPage.getloginIntoApp("anshika@gmail.com", "Iamki000");

	}

	@Test
	public void getTexterror22() throws InterruptedException {
		String productName = "ADIDAS ORIGINAL";
		ProductCatelogPage pc = loginPage.getloginIntoApp("anshika@gmail.com", "Iamki000");

	}

	@Test
	public void getTexterror() throws InterruptedException {
		String productName = "ADIDAS ORIGINAL";
		ProductCatelogPage pc = loginPage.getloginIntoApp("anshika@gmail.com", "Iamki000");

	}

	@Test
	public void getTexterror2() throws InterruptedException {
		String productName = "ADIDAS ORIGINAL";
		ProductCatelogPage pc = loginPage.getloginIntoApp("anshika@gmail.com", "Iamki000");

	}

	@Test
	public void getTexterror3() throws InterruptedException {
		String productName = "ADIDAS ORIGINAL";
		ProductCatelogPage pc = loginPage.getloginIntoApp("anshika@gmail.com", "Iamki000");
		Assert.assertTrue(false);
	}
}
