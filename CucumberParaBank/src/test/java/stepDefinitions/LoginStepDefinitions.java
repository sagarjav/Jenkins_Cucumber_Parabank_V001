package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
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
import pageObjects.HomePage;
import pageObjects.MyAccountPage;

public class LoginStepDefinitions extends BaseClass {

    private HomePage homePage;
    private MyAccountPage myAccountPage;

    @Before
    public void setup() throws IOException {
        // Logger setup
        logger = Logger.getLogger("CucumberParabank");
        PropertyConfigurator.configure("log4j.properties");

        // Reading properties
        configProp = new Properties();
        FileInputStream configPropFile = new FileInputStream("config.properties");
        configProp.load(configPropFile);

        String browser = configProp.getProperty("browser").toLowerCase();

        // Initialize the driver only if it's not initialized
        if (driver == null) {
            switch (browser) 
            {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid browser specified in config file");
            }
            driver.manage().window().maximize();
            logger.info("******** Browser Opened and Maximized ********");
        }
    }

    @Given("the user is on the Parabank login page {string}")
    public void the_user_is_on_the_Parabank_login_page(String url) {
        driver.get(url);
        logger.info("Navigated to " + url);

        // Initialize page objects
        homePage = new HomePage(driver);
        myAccountPage = new MyAccountPage(driver);
    }

    @When("the user enters valid username {string} and password {string}")
    public void the_user_enters_valid_username_and_password(String username, String password) {
        logger.info("Entering login details");
        homePage.sendusername(username);
        homePage.sendpassword(password);
    }

    @And("clicks the login button")
    public void clicks_the_login_button() {
        homePage.clickOnlogIn();
    }

    @Then("the user should be logged in successfully")
    public void the_user_should_be_logged_in_successfully() {
        boolean isLogoutButtonVisible = myAccountPage.isDisablelogOut();
        Assert.assertTrue("User is not logged in successfully", isLogoutButtonVisible);
        logger.info("User logged in successfully");
    }

    @And("close the browser")
    public void tearDown() {
        driver.close();
        logger.info("Browser closed");
    }
}
