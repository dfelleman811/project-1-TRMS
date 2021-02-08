# Tuition Reimbursement Management System - README
### Dan Felleman - 2101 Java w/ETL - Project 1

> This Project was completed to fulfill the requirements of Project 1 furing Training at Revature LLC.
>
> The client was looking for a Web Application with which to track reimbursements for their employees, who are each given a $1,000 
stipend to use for Professional Development. The resulting application allows employees to login, submit requests for reimbursements, and 
check the status of their requests. It also allows management to approve or deny requests, as well as track the reimbursement payments.  

### Package Structure
**Models:** Java Beans that represent tables in the Oracle SQL Database  
**Repositories:** Data Access Objects used to query the Database  
**Services:** Any necessary business logic - in this application, the Service Layer simply calls the Repository Layer  
**Controllers:** Application logic for handling HttpRequests and formatting HttpResponses  
**Servlets:** HttpServlet to listen for incoming requests and send corresponding responses  
**Utilities:** JDBC Connection Class to configure credentials and make connections to the AWS RDS instance

### Features
- Session Tracking  
  - HttpSession objects used to store and access session information (such as current logged in user and the professional development resource in question)
- AJAX Calls
  - JavaScript is implemented for frent end design in order to send and receive asynchronous HTTP Requests and Responses  
- HTML Design
  - Bootstrap  used for CSS  
  - JavaScript used for DOM Manipulation  
### Testing
**Cucumber BDD**  
Feature file, step implementation, and runner class located in src/test folders in order to test user interaction on the login page (using Selenium WebDriver to automate user input and navigation)  

**JUnit**  
Some test cases implemented to ensure proper database connection and retrieval of information.  

### Further Development  
Some appropriate imrpovements would be to implement a messaging service tied to employees, supervisors, and their development resources.  
Implementation of file uploading is not functional yet.  
Archiving of closed requests, while a table exists in the database, is not yet implemented.  

### Required Dependencies
##### The below dependencies are required in the pom.xml file in order to ensure proper execution.
- Testing
  - JUnit v.4
  - Cucumber
  - Selenium WebDriver (this project uses chromedriver)
- Database Access
  - Java Servlet
  - Oracle JDBC Driver
- Other
  - Google Gson (for formatting/sending/receiving HttpRequest and HttpResponses
```
  <dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.11</version>
    <scope>test</scope>
  </dependency>
  <dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>4.0.1</version>
    <scope>provided</scope>
  </dependency>
  <dependency>
    <groupId>com.oracle.ojdbc</groupId>
    <artifactId>ojdbc8</artifactId>
    <version>19.3.0.0</version>
  </dependency>
  <dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.8.6</version>
  </dependency>
  <dependency>
    <groupId>info.cukes</groupId>
    <artifactId>cucumber-junit</artifactId>
    <version>1.2.5</version>
    <scope>test</scope>
  </dependency>
  <!-- https://mvnrepository.com/artifact/info.cukes/cucumber-java -->
  <dependency>
    <groupId>info.cukes</groupId>
    <artifactId>cucumber-java</artifactId>
    <version>1.2.5</version>
  </dependency>
  <dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>3.8.1</version>
  </dependency>
  <dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-chrome-driver</artifactId>
    <version>3.8.1</version>
  </dependency>
  <!-- https://mvnrepository.com/artifact/org.mockito/mockito-core -->
  <dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <version>3.6.28</version>
    <scope>test</scope>
  </dependency>
```
