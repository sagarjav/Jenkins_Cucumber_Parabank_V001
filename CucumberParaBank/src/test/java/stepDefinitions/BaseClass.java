package stepDefinitions;

import java.util.Properties;

import org.apache.log4j.Logger;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObjects.HomePage;
import pageObjects.LoginAccountPage;
import pageObjects.MyAccountPage;
import pageObjects.NewRegisterPage;
import utilities.WaitHelper;

public class BaseClass {
	
	
	public static WebDriver driver; // Make driver static to ensure only one instance is used
    public HomePage homePage;
    public MyAccountPage myAccountPage;
    public static Logger logger;
    public Properties configProp;
    
   //some changes
	
	//for Unique Username 
	public static String randomString() {
		String generatedString1=RandomStringUtils.randomAlphabetic(2) ;
		return generatedString1;
		
	}
	
	

}
