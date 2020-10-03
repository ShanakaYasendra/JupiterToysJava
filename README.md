# JupiterToysJava
Jupiter Toys Java Selenium Test

Plant It Test



## Test cases

### Test case 1:
1.	From the home page go to contact page
2.	Click submit button
3.	Validate errors
4.	Populate mandatory fields
5.	Validate errors are gone


### Test case 2:

1.	From the home page go to contact page
2.	Populate mandatory fields
3.	Click submit button
4.	Validate successful submission message


### Test case 3: 

1.	From the home page go to contact page
2.	Populate mandatory fields with invalid data
3.	Validate errors


### Test case 4:

1.	From the home page go to shop page
2.	Click buy button 2 times on “Funny Cow”
3.	Click buy button 1 time on “Fluffy Bunny”
4.	Click the cart menu
5.	Verify the items are in the cart

## Setup

I have used Maven project to develop the project.
Language used 
1.	Java

POM.xml use to add the following dependencies
1.	Selenium.java
2.	selenium-support
3.	selenium-chrome-driver
4.	testing
Install the TestNG and add the TestNG library.

### Config.properties
 Use to configure the URL
“appurl=https://jupiter.cloud.planittesting.com/”

### or.properies
Page object are defined using the or.properties.

