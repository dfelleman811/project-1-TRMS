Feature: Login button and input works


	Background: 
		Given the user is at the landing page
		
		
	Scenario Outline: the user tries to log in
		When the user types in "<email>" and "<password>" and clicks log in
		Then the returned user info should be "<returnedEmail>" and "<returnedPassword>"
		Then the title of the current page should be "<title>"
		
	Examples:
		|	email						|	password	|	returnedEmail				|	returnedPassword	|	title	|
		|	basic.employee@example.com	|	password	|	basic.employee@example.com	|	password			|	home	|
		
	
	
		