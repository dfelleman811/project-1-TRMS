package dev.felleman.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {

	// Declare driver
	public WebDriver driver;

	// Grab the elements we want to interact with

	@FindBy(css = "input[id='emailInput']") // not tested yet! still need to build the page
	public WebElement emailInput;

	@FindBy(css = "input[id='passwordInput']")
	public WebElement passwordInput;

	@FindBy(css = "button[id='logInButton']")
	public WebElement loginButton;

	// Constructor to initialize these elements in this class
	public LogInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
