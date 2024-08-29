package NAutomationTesting;

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

import NAutomationTesting.PageObjects.LoginPage;

public class StandaloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String productName = "ADIDAS ORIGINAL";
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		LoginPage login = new LoginPage(driver);
		driver.findElement(By.id("userEmail")).sendKeys("narasimhulu3k@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Narasimha@444");
		driver.findElement(By.id("login")).click();
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		WebElement product = products.stream()
				.filter(prod -> prod.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null);

		product.findElement(By.cssSelector(".card-body button:last-child")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(".ng-animating")));

		driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();

		List<WebElement> cartProduct = driver.findElements(By.cssSelector(".cartSection h3"));

		Boolean match = cartProduct.stream().anyMatch(cartProdu -> cartProdu.getText().equalsIgnoreCase(productName));

		Assert.assertTrue(match);

		driver.findElement(By.cssSelector("li button[type='button']")).click();

		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")), "india").build()
				.perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));

		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();

		driver.findElement(By.cssSelector(".action__submit")).click();

		String successMsg = driver.findElement(By.cssSelector(".hero-primary")).getText();

		Assert.assertTrue(successMsg.equalsIgnoreCase("Thankyou for the order."));

		driver.close();

	}

}
