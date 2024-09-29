package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
				    features = ".//Features/Registration.feature", // Correct the path if necessary --> ".//Features/Registration.feature"
				    glue = {"stepDefinitions"}, // Ensure the package name matches where your step definitions are located
				    plugin = {"pretty", "html:target/cucumber-reports.html"}, // Updated 'format' to 'plugin' for proper reporting
				    monochrome = true, // Makes console output more readable
				    dryRun = false // Set to true to check mapping between feature file and step definitions without executing the tests
				    //strict = true // Ensures that undefined or pending steps will cause the test to fail
				   // tags = "@regression"// Corrected tag format to run tests with specific tags -->  tags = "@sanity and @regression" -->tags = "@sanity and not @regression"
                   
		
		)

public class TestRunner {
    // Empty class body as it only serves as the entry point for running Cucumber tests
}
