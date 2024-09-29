package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginAccountPage;
import pageObjects.MyAccountPage;
import pageObjects.NewRegisterPage;
import utilities.WaitHelper;


public class NewRegistration extends BaseClass {

    public NewRegisterPage newRegistrationPage;
    public WaitHelper waitHelper;
    LoginAccountPage loginAccountPage;
    MyAccountPage myAccountPage;    
	
    
    @Before
    public void setup2() throws IOException {
    	 logger=Logger.getLogger("CucumberParabank"); //Added logger
         PropertyConfigurator.configure("log4j.properties"); //Added logger
      	
         //Reading properties
         configProp=new Properties();
         FileInputStream configPropFile=new FileInputStream("config.properties");
         configProp.load(configPropFile);
         
         String br=(configProp.getProperty("browser")).toLowerCase();
         
         // Set up the ChromeDriver path if needed (adjust path as per your setup)
         if(br.equals("chrome")) 
         {
        	 driver = new ChromeDriver(); // Initialize the driver
         }
         
         else if(br.equals("firefox"))
         {
        	 driver = new FirefoxDriver(); // Initialize the driver
         }
         
         else if(br.equals("edge"))
         {
        	 driver = new EdgeDriver(); // Initialize the driver
         }
         else {
        	 System.out.println("Browser is wrong selected");
         }
        
         
          logger.info("********  Browser is launched *********");
          driver.manage().window().maximize();
    } 

    @Given("the user is on the New Registration page {string}")
    public void the_user_is_on_the_new_registration_page(String URL) {
    	
    	driver.get(URL);
    	logger.info("********  Opening URL *********");
        waitHelper = new WaitHelper(driver);
       
    }

    @When("the user enters valid New Registration details")
    public void the_user_enters_valid_new_registration_details() {
    	logger.info("********  Entering Registration Details *********");
    	newRegistrationPage = new NewRegisterPage(driver);

        // Enter First Name
        waitHelper.waitForElement(newRegistrationPage.getFirstName(), Duration.ofSeconds(30));
        newRegistrationPage.sendFirstName("Admin2");
        

        // Enter Last Name
        waitHelper.waitForElement(newRegistrationPage.getLastName(), Duration.ofSeconds(30));
        newRegistrationPage.sendLasttName("admin");

        // Enter Address
        waitHelper.waitForElement(newRegistrationPage.getaddressstreet(), Duration.ofSeconds(30));
        newRegistrationPage.sendAddressstreet("baner,pune");

        // Enter City
        waitHelper.waitForElement(newRegistrationPage.getaddresscity(), Duration.ofSeconds(30));
        newRegistrationPage.sendaddresscity("pune");

        // Enter State
        waitHelper.waitForElement(newRegistrationPage.getaddressstate(), Duration.ofSeconds(30));
        newRegistrationPage.sendaddressstate("MH");

        // Enter Zip Code
        waitHelper.waitForElement(newRegistrationPage.getaddresszipCode(), Duration.ofSeconds(30));
        newRegistrationPage.sendAddresszipCode("1234");

        // Enter Phone Number
        waitHelper.waitForElement(newRegistrationPage.getphoneNumber(), Duration.ofSeconds(30));
        newRegistrationPage.sendphoneNumber("123456789");

        // Enter SSN
        waitHelper.waitForElement(newRegistrationPage.getcustomerssn(), Duration.ofSeconds(30));
        newRegistrationPage.sendcustomerssn("254");

        // Enter Username
        waitHelper.waitForElement(newRegistrationPage.getUserName(), Duration.ofSeconds(30));
        newRegistrationPage.sendUserName("sagar126"+super.randomString());
        

        // Enter Password
        waitHelper.waitForElement(newRegistrationPage.getPasswordName(), Duration.ofSeconds(30));
        newRegistrationPage.sendPasswordName("sagar1234");

        // Enter Repeat Password
        waitHelper.waitForElement(newRegistrationPage.getRepeatPasswordName(), Duration.ofSeconds(30));
        newRegistrationPage.sendRepeatPasswordName("sagar1234");

        // Click Register button
       }
    
    @When("the user clicks the Register button")
    public void the_user_clicks_the_register_button() {
    	logger.info("********  Clicking New Register Button *********");
    	waitHelper.waitForElement(newRegistrationPage.getRegister(), Duration.ofSeconds(30));
    	newRegistrationPage.clickOnNewUserRegister();
    }
    
    @Then("the account should be created successfully {string}")
    public void the_account_should_be_created_successfully(String successMessage) {
        // Logic to verify account creation success
    	LoginAccountPage loginAccountPage=new LoginAccountPage(driver);
    	waitHelper.waitForElement(loginAccountPage.getyourAccountWasCreatedSucce(), Duration.ofSeconds(10));
    	
    	
    	String Expected=successMessage;
    	String Actual=loginAccountPage.isDisplayedyourAccountWasCreatedSucce();
    	System.out.println(Expected);
    	System.out.println(Actual);
    	boolean Result =Actual.equals(Expected);
        
    	Assert.assertTrue("Registration_of_new_user is Failed", Result);
    	//Assert.assertEquals(Actual, Expected, "Registration_of_new_user is Failed"+Actual);
    	
    }
    
    @And ("Logout After successfully Done New Registration")
    public void Logout_After_successfully_Done_New_Registration() {
    	 myAccountPage=new MyAccountPage(driver);
    	 
    	 myAccountPage.clickOnlogOut();
    	
    }
    
 
}
    