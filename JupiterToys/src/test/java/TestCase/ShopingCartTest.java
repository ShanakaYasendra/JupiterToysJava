package TestCase;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import Pages.BaseClass;
import Pages.CartPage;
import Pages.ShopPage;

/**
 * @author shan
 * This is Shopping Cart test
 */
public class ShopingCartTest extends BaseClass 
{

	
	/**
	 *  Test case 4:
	 *  1.	From the home page go to shop page
	 *  2.	Click buy button 2 times on “Funny Cow”
	 *  3.	Click buy button 1 time on “Fluffy Bunny”
	 *  4.	Click the cart menu
	 */
	@Test
	public void AddItemsToCartTest()
	{
		navBar.getShopPage();
		ShopPage shPage= new ShopPage();
		shPage.BuyFunnyCow();
		shPage.BuyFunnyCow();
		shPage.BuyBunny();
		String cartVal= shPage.GetCartUpdate();
		System.out.println(cartVal);
		Assert.assertTrue(cartVal.contains("3"));

		
	}
	/**
	 * Test case 4.1:
	 * 1.	Verify the items are in the cart
	 */
	@Test
	public void CheckTheCart() {
		
		navBar.getCartPage();
		CartPage cartPage= new CartPage();
		Assert.assertTrue(cartPage.getIteminTheCart("Bunny"));
		Assert.assertTrue(cartPage.getIteminTheCart("Funny Cow"));
	}
	
	@AfterTest
	public void TearDown() {
		driver.close();
	}

}
