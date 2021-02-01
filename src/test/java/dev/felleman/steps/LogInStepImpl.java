package dev.felleman.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dev.felleman.pages.LogInPage;
import dev.felleman.runners.LogInRunner;


public class LogInStepImpl {

	// Declare driver and login page
	public static WebDriver driver = LogInRunner.driver;
	public static LogInPage loginPage = LogInRunner.loginPage;
	

@Given("^the user is at the landing page$")
public void the_user_is_at_the_landing_page() {
	// tell driver to go to login page
    driver.get("http://localhost:8080/Project-1-TRMS/html/index.html");
    
}

@When("^the user types in \"([^\"]*)\" and \"([^\"]*)\" and clicks log in$")
public void the_user_types_in_and_and_clicks_log_in(String email, String password) {
    
	// send key strokes to webelements
	loginPage.emailInput.sendKeys(email);
	loginPage.passwordInput.sendKeys(password);
	loginPage.loginButton.click();
    
}

@Then("^the returned user info should be \"([^\"]*)\" and \"([^\"]*)\"$")
public void the_returned_user_info_should_be_and(String returnedEmail, String returnedPassword) {
    // make sure input is collected correctly
	//Assert.assertEquals(); // hmmmmm not sure I should be testing this here
}

@Then("^the title of the current page should be \"([^\"]*)\"$")
public void the_title_of_the_current_page_should_be(String title) {
    
	Assert.assertEquals(title, driver.getTitle());
	
  
}

}
