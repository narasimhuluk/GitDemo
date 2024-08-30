package NAutomationTesting;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import NAutomationTesting.PageObjects.CartPage;
import NAutomationTesting.PageObjects.CheckOutPage;
import NAutomationTesting.PageObjects.ProductCatelogPage;
import NAutomationTesting.PageObjects.conformationPage;
import NAutomationTesting.PageObjects.ordersPages;
import NAutomationTesting.TestComponents.BaseTest;

public class SubmitOrderTest extends BaseTest {

	String productName = "ADIDAS ORIGINAL";

	@Test(dataProvider = "getData", groups = "purchasetest")
	public void orderSubmit(HashMap<String, String> input) throws IOException {
		

		ProductCatelogPage pc = loginPage.getloginIntoApp(input.get("email"), input.get("password"));
		pc.getProductsList();
		pc.addProductToCart(input.get("product"));
		CartPage cp = pc.goToCartPage();
		Boolean match = cp.VerifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		CheckOutPage op = cp.clickOnCheckoutButton();
		op.selectCountry();
		conformationPage conpage = op.placeOrder();
		String confMsg = conpage.getConformMessage();
		Assert.assertTrue(confMsg.equalsIgnoreCase("Thankyou for the order."));

	}

	//@Test(dependsOnMethods = "orderSubmit")
	public void orderHistoryTest() {

		ProductCatelogPage pc = loginPage.getloginIntoApp("narasimhulu3k@gmail.com", "Narasimha@444");
		ordersPages op = pc.goToOrdersPage();
		Assert.assertTrue(op.VerifyOrdrsDisplay(productName));
		System.out.println("productname");
		System.out.println("productname");
		System.out.println("productname");

	}

	@DataProvider
	public Object[][] getData() throws IOException {
	/*	HashMap<String, String> map = new HashMap<String, String>();
		map.put("email", "narasimhulu3k@gmail.com");
		map.put("password", "Narasimha@444");
		map.put("productname", "ADIDAS ORIGINAL");

		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("email", "narasimhulu2k@gmail.com");
		map1.put("password", "Nani@444");
		map1.put("productname", "ZARA COAT 3");
    */
		
		List<HashMap<String,String>> data=getJsonToMap(System.getProperty("user.dir") + "//src//test//java//NAutomationTesting//data//PurchaseOrder.json");
		return new Object[][] { {data.get(0)}, {data.get(1)} };
		// return new Object[][] { { "narasimhulu3k@gmail.com", "Narasimha@444", "ADIDAS
		// ORIGINAL" },
		// { "narasimhulu2k@gmail.com", "Nani@444", "ZARA COAT 3" } };
	}

}
