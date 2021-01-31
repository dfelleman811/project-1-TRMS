package dev.felleman.runners;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import dev.felleman.pages.LogInPage;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue = "dev.felleman.steps")
public class LogInRunner {

	// Declare driver
	public static WebDriver driver;

	// Declare page instance
	public static LogInPage loginPage;

	// Set up method to run before all tests

	@BeforeClass
	public static void setUp() {
		// build and instantiate driver
		File file = new File("src/test/resources/chromedriver");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

		driver = new ChromeDriver();

		// instantiate login page
		loginPage = new LogInPage(driver);
	}

	// Tear down method to run after all tests

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
