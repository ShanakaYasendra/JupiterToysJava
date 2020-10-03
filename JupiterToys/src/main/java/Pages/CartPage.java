package Pages;

import org.openqa.selenium.By;

public class CartPage extends BaseClass {

	public String getTitle() {
		return driver.getTitle();
		
	}
	
	public boolean getIteminTheCart(String item) {
		return driver.findElement(By.xpath("//td[contains(.,'" + item + "')]")).isDisplayed();
		
	}

}
