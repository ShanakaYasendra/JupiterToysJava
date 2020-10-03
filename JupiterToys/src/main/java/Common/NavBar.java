package Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Pages.CartPage;
import Pages.ContactPage;
import Pages.HomePage;
import Pages.ShopPage;

public class NavBar {

	WebDriver driver;

	public NavBar(WebDriver driver) {
	
		this.driver= driver;
	}
	
	//Navigate to Home Page
	public HomePage getHomePage() 
	{
		
	driver.findElement(By.linkText("Home")).click();
	return new HomePage();
	
	}
	
	//Navigate to Shop page
	public ShopPage getShopPage() {
		driver.findElement(By.linkText("Shop")).click();
		return new ShopPage();
		
	}
	//Navigate to Cart Page
	public CartPage getCartPage() {
		driver.findElement(By.xpath("//a[@href='#/cart']")).click();
		return new CartPage();
		
	}
	//Navigate to Contact Page
    public ContactPage GetContactPage()
    {
    	driver.findElement(By.linkText("Contact")).click();
    	return new ContactPage();
    }
    

}
