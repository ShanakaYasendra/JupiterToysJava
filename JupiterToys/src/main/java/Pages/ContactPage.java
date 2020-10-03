package Pages;

import org.openqa.selenium.By;

public class ContactPage extends BaseClass {
	
	
	//Enter details for Mandatory fields
	public void EnterDataToMandatoryFields(String forename, String email, String msg) {
		
		enterText("forename_ID", forename);
		enterText("email_ID", email);
		enterText("message_ID", msg);
		
	}
	
	//Enter data to all Fields
	public void EnterDataToAllFields(String forename, String email, String telno, String message, String surname) {
	
		enterText("forename_ID", forename);
		enterText("email_ID", email);
		enterText("message_ID", message);
		enterText("telephone_ID", telno);
		 enterText("surname_ID", surname);
	
	}
	
	
	
	//Click Submit Button
	public void ClickSubmit()
	{
		clickBtn("Submit_XP");
	}
	
	//Get the Text of the Error Message
	  public String GetErrorMessage(String fieldName)
      {
          String element = fieldName + "-err";
          return GetErrorMessageText(element);
      }
	  
	  //Enter Data to forename
	  public void EnterDataToForname(String forename) {
		  
		  enterText("forename_ID", forename);
	  }
	  
	  //Enter Data to email
	  public void EnterDataToEmail(String email) {
		  
		  enterText("email_ID", email);
	  } 
	  
	  //Enter Data to message	  
	  public void EnterDataToMessage(String message) {
		  
		  enterText("message_ID", message);
	  }  
	  
	  //Enter Data to telephone
	  public void EnterDataToTelephone(String telephone) {
		  
		  enterText("telephone_ID", telephone);
	  }
	  
	  //Enter Data to Surname
	  public void EnterDataToSurname(String surname) {
		  
		  enterText("surname_ID", surname);
	  }  
		
	  // Check error is Visible 
	  public boolean IsErrorPresent(String fieldName)
      {
          String element = fieldName + "-err";
          return IsElementDisplay(element);
      }

	  // Get the success message
	  public String GetSuccessMessage() {
		 return GetText("SuccessMsg_XP");
		
	}
	  
	  //Wait for Model to close
	public String WaitForModeltoClose() {
		boolean isDisplay = true;
		int count =0;
        while( (isDisplay==true)||(count<50))
        {
            // count = driver.WindowHandles.Count;
            try
            {
                isDisplay = driver.findElement(By.cssSelector(".modal-body")).isEnabled();
              // System.out.println(isDisplay);
               count++;
              // System.out.println(count);

            }
            catch (Exception e)
            {
                isDisplay = false;
                return "pass";
            }
            
        }
        return "fail";
	}
	  
	  

}
