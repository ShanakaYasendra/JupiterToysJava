package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.BaseClass;
import Pages.ContactPage;

/**
 * @author shan
 * This is the Contact Page Test
 */
 

public class ContactPageTest extends BaseClass {

	public ContactPage contactPage;
	

	/** 
    * Test case 1.1:
    * 1.	From the home page go to contact page
    * 2.	Click submit button 
    * 3.	Validate errors
    */

	@Test
	public void ValidateMandatoryFields() 
	{	navBar.getHomePage();
		navBar.GetContactPage();
		 contactPage = new ContactPage();
		 contactPage.ClickSubmit();
		 Assert.assertEquals(contactPage.GetErrorMessage("forename"), "Forename is required");
		 Assert.assertEquals(contactPage.GetErrorMessage("email"), "Email is required");
		 Assert.assertEquals(contactPage.GetErrorMessage("message"), "Message is required");
		 navBar.getHomePage();	
	}
	
	
	/**
	 *  Test case 1.2:
	 *   1.	From the home page go to contact page
	 *   2. Populate mandatory fields
	 *   3. Validate errors are gone
	 */
	@Test
	public void EnterValidDataToMandatoryFields()
	{
		navBar.getHomePage();
		navBar.GetContactPage();
		contactPage = new ContactPage();
		contactPage.EnterDataToForname("Jhon");
		Assert.assertFalse(contactPage.IsErrorPresent("forename"));
		contactPage.EnterDataToEmail("Jhon@test.com");
		Assert.assertFalse(contactPage.IsErrorPresent("email"));
		contactPage.EnterDataToMessage("Well Not good as I thought");
		Assert.assertFalse(contactPage.IsErrorPresent("message"));
		navBar.getHomePage();
	}
	
	/**
	 *  Test case 3:
	 *  1.	From the home page go to contact page
	 *  2.	Populate all fields with invalid data
	 *  3.	Validate errors
	 *  Assumptions only Email field is validate for invalid data.
	 *  I have checked manually no validation for Forename and Message
	 */
	@Test
	public void InvalidDataToAllFields()
	{
		navBar.getHomePage();
		navBar.GetContactPage();
		contactPage.EnterDataToAllFields("Shan123", "Jim@", "123SS", "Hi How are@@@@@34342533////// You", "abc3333@@@");
		Assert.assertEquals(contactPage.GetErrorMessage("email"), "Please enter a valid email");
        Assert.assertEquals(contactPage.GetErrorMessage("telephone"), "Please enter a valid telephone number");
        navBar.getHomePage();
	}
	
	/**
	 * Test case 2:
	 *  1.	From the home page go to contact page
	 *  2.	Populate mandatory fields
	 *  3.	Click submit button
	 *  4.	Validate successful submission message
	 */
	@Test
	public void ValidDataToMandatoryFields()
	{
		navBar.getHomePage();
		navBar.GetContactPage();
		contactPage = new ContactPage();
        contactPage.EnterDataToMandatoryFields("Jim", "Jim@test.com", "Hi How are You");
        contactPage.ClickSubmit();
        Assert.assertEquals(contactPage.WaitForModeltoClose(), "pass");
        Assert.assertEquals(contactPage.GetSuccessMessage(), "Thanks Jim, we appreciate your feedback.");
        navBar.getHomePage();
	}
	

}
