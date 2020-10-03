package Pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Common.NavBar;


public class BaseClass {
	
	//Create variable for Webdriver and NavBar Page
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static NavBar navBar;
	
	//Create variable for Config file and Object repository  files
	public static Properties config= new Properties();
	public static Properties or= new Properties();
	
	//Create input file stream
	public static FileInputStream fis;
	
	
	public BaseClass() {
	
		if(driver == null) {
			try {
				fis= new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties/config.properties");
				System.out.println(config.getProperty("appurl"));
			}
			
			catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
			
			try {
				config.load(fis);
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			  try {
	               fis = new FileInputStream(
	                       System.getProperty("user.dir") + "/src/test/resources/properties/or.properties");
	           } catch (FileNotFoundException e) {
	         
	               e.printStackTrace();
	           }
	           
	           //load the or.properties file
	           try {
	               or.load(fis);
	           } catch (IOException e) {
	               
	               e.printStackTrace();
	           }
			
			//set the driver
			
			driver= new ChromeDriver();
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.get(config.getProperty("appurl"));
			driver.manage().window().maximize();
			navBar= new NavBar(driver);
		}
		
	}

	// Click on button
	public void clickBtn(String element) {
		//System.out.println(element);

		if (element.contains("XP")) {
			driver.findElement(By.xpath(or.getProperty(element))).click();
		}

		else if (element.contains("ID")) {
			driver.findElement(By.id(or.getProperty(element))).click();
		}

		else if (element.contains("NAME")) {
			driver.findElement(By.name(or.getProperty(element))).click();
		} else if (element.contains("CSS")) {
			System.out.println(element);
			System.out.println(or.getProperty(element));
			driver.findElement(By.cssSelector(or.getProperty(element))).click();
		} else if (element.contains("Link")) {
			driver.findElement(By.linkText(or.getProperty(element))).click();
		} else if (element.contains("TAG")) {
			driver.findElement(By.tagName(or.getProperty(element))).click();
		}

	}

	// Enter Text to the input box
	public void enterText(String element, String value) {
		if (element.contains("XP")) {
			driver.findElement(By.xpath(or.getProperty(element))).clear();
			driver.findElement(By.xpath(or.getProperty(element))).sendKeys(value);
		} else if (element.contains("ID")) {
			driver.findElement(By.id(or.getProperty(element))).clear();
			;
			driver.findElement(By.id(or.getProperty(element))).sendKeys(value);
		} else if (element.contains("NAME")) {
			driver.findElement(By.name(or.getProperty(element))).clear();
			driver.findElement(By.name(or.getProperty(element))).sendKeys(value);
		} else if (element.contains("CSS")) {
			driver.findElement(By.cssSelector(or.getProperty(element))).clear();
			driver.findElement(By.cssSelector(or.getProperty(element))).sendKeys(value);
		} else if (element.contains("Link")) {
			driver.findElement(By.linkText(or.getProperty(element))).clear();
			driver.findElement(By.linkText(or.getProperty(element))).sendKeys(value);
		} else if (element.contains("TAG")) {
			driver.findElement(By.tagName(or.getProperty(element))).clear();
			driver.findElement(By.tagName(or.getProperty(element))).sendKeys(value);
		}

	}

	// Get Text from the element
	public String GetText(String element) {
		if (element.contains("XP")) {
			return driver.findElement(By.xpath(or.getProperty(element))).getText();
		} else if (element.contains("ID")) {
			return driver.findElement(By.id(or.getProperty(element))).getText();
		} else if (element.contains("NAME")) {
			return driver.findElement(By.name(or.getProperty(element))).getText();
		} else if (element.contains("CSS")) {
			return driver.findElement(By.cssSelector(or.getProperty(element))).getText();
		} else if (element.contains("Link")) {
			return driver.findElement(By.linkText(or.getProperty(element))).getText();
		} else if (element.contains("TAG")) {
			return driver.findElement(By.tagName(or.getProperty(element))).getText();
		} else {
			return null;
		}

	}

	// Return Element is display on the page
	public boolean isElementDisplay(String element) {

		if (element.contains("XP")) {
			return driver.findElement(By.xpath(or.getProperty(element))).isDisplayed();
		} else if (element.contains("ID")) {
			return driver.findElement(By.id(or.getProperty(element))).isDisplayed();
		} else if (element.contains("NAME")) {
			return driver.findElement(By.name(or.getProperty(element))).isDisplayed();
		} else if (element.contains("CSS")) {
			return driver.findElement(By.cssSelector(or.getProperty(element))).isDisplayed();
		} else if (element.contains("Link")) {
			return driver.findElement(By.linkText(or.getProperty(element))).isDisplayed();
		} else if (element.contains("TAG")) {
			return driver.findElement(By.tagName(or.getProperty(element))).isDisplayed();
		} else {
			return false;
		}

	}

	// Return Error message text

	public String GetErrorMessageText(String element) {
		return driver.findElement(By.id(element)).getText();
	}

	// Return dynamic elements visibility
	public boolean IsElementDisplay(String element) {
		try {
			driver.findElement(By.id(element));
			return true;
		} catch (Exception e) {
			return false;
			// TODO: handle exception
		}
	}

}

