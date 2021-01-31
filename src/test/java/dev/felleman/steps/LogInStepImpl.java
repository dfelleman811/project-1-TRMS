package dev.felleman.steps;

import org.openqa.selenium.WebDriver;

import dev.felleman.pages.LogInPage;
import dev.felleman.runners.LogInRunner;

public class LogInStepImpl {

	// Declare driver and login page
	public static WebDriver driver = LogInRunner.driver;
	public static LogInPage loginPage = LogInRunner.loginPage;

}
