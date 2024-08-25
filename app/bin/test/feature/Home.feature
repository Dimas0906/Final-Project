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