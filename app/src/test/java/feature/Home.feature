@homepage
Feature: Test UI Automation


  # ------------ Sign Up ------------

  @signup
  Scenario: Register for new user using valid email and password
    Given open web page
    When User click on Sign up menu
    Then User can see "Sign up" Pop-up shown
    And User input sign up email "testemasil123@gc.cm.test" and sign up password "12345678"
    And User click on Sign Up button
    Then User can see alert shown with message "Sign up successful" and Click "OK"

  @signup
  Scenario: Register new user with existing email and password
    Given open web page
    When User click on Sign up menu
    Then User can see "Sign up" Pop-up shown
    And User input sign up email "testemasil123@gc.cm.test" and sign up password "12345678"
    And User click on Sign Up button
    Then User can see alert shown with message "This user already exist." and Click "OK"

  @signup
  Scenario: Register new user without fill up password
    Given open web page
    When User click on Sign up menu
    Then User can see "Sign up" Pop-up shown
    And User input field "email" with this value "testemaisl123741092@gmc.cm.test"
    And User click on Sign Up button
    Then User can see alert shown with message "Please fill out Username and Password" and Click "OK"

  @signup
  Scenario: Register new user without fill up email
    Given open web page
    When User click on Sign up menu
    Then User can see "Sign up" Pop-up shown
    And User input field "password" with this value "password123"
    And User click on Sign Up button
    Then User can see alert shown with message "Please fill out Username and Password" and Click "OK"

  @signup
  Scenario: Register for new user using generated email and password
    Given open web page
    When User click on Sign up menu
    Then User can see "Sign up" Pop-up shown
    And Let the system generated random email and password
    And User click on Sign Up button
    Then User can see alert shown with message "Sign up successful" and Click "OK"


  # ------------ Login ------------

  @login
  Scenario: Login using registered username and password
    Given open web page
    When User click on Log in menu
    Then User can see "Log in" Pop-up shown
    And User input log in username "testemasil123@gc.cm.test" and log in password "12345678"
    And User click on Log in button
    Then User can see Welcome user on the top right of the page

  @login
  Scenario: Login using unregistered username and password
    Given open web page
    When User click on Log in menu
    Then User can see "Log in" Pop-up shown
    And User input log in username "randomized882@gmc.cm.test" and log in password "unregistered123"
    And User click on Log in button
    Then User can see alert shown with message "User does not exist." and Click "OK"

  @login
  Scenario: Login using wrong password
    Given open web page
    When User click on Log in menu
    Then User can see "Log in" Pop-up shown
    And User input log in username "testemasil123@gc.cm.test" and log in password "testingrandom123"
    And User click on Log in button
    Then User can see alert shown with message "Wrong password." and Click "OK"

  @login
  Scenario: Login without fill out password
    Given open web page
    When User click on Log in menu
    Then User can see "Log in" Pop-up shown
    And User input field "email" with this value "testmaillogin123@gmc.cm.test" on log in
    And User click on Log in button
    Then User can see alert shown with message "Please fill out Username and Password" and Click "OK"

  @login
  Scenario: Login without fill out email
    Given open web page
    When User click on Log in menu
    Then User can see "Log in" Pop-up shown
    And User input field "password" with this value "randompassword123" on log in
    And User click on Log in button
    Then User can see alert shown with message "Please fill out Username and Password" and Click "OK"


  # ------------ About Us ------------
  @aboutus
  Scenario: User try to see about us pop-up
    Given open web page
    When User click on About Us menu
    Then User can see "About us" Pop-up shown
    And User can click on Close button on about us pop-up


  # ------------ Contact Us ------------

  @contactus
  Scenario: User try to send message to contact admin using Contact us
    Given open web page
    When User click on Contact menu
    Then User can see "Contact us" Pop-up shown
    And User input "testemasil123@gc.cm.test" for email, "Test Person" for name, and "Hello from new user" for message
    Then User click on Send Message button
    Then User can see alert shown with message "Thanks for the message!!" and Click "OK"

  @contactus
  Scenario: User try to click on Close after open the Contact us pop-up
    Given open web page
    When User click on Contact menu
    Then User can see "Contact us" Pop-up shown
    And User click on Close button on Contact Us