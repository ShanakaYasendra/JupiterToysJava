package Pages;

import org.openqa.selenium.By;

public class ShopPage extends BaseClass {
	
	
	//Click Buy button from Funny Cow
	public void BuyFunnyCow() {
		
	//	try {
	//		Thread.sleep(1000);
			clickBtn("FunnyCow_CSS");
	//	} catch (InterruptedException e) {
			
//
//			e.printStackTrace();
//		}
//	
	}
	
	//Click Buy button from Bunny
	public void BuyBunny()
	{
		clickBtn("Bunny_CSS");
		
	}
	
	//Return number of item in Cart Link
	public String GetCartUpdate() {
		 return driver.findElement(By.xpath("//a[@href='#/cart']")).getText();
		
	}

}
