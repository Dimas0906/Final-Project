# @Signup
# Feature: Sign Up

#   This Feature is for SignUp new User

#   @positive @newUser @test
#   Scenario: Try to register using new email and password
#     Given User on home page
#     When User click on Sign up menu
#     Then User can see "Sign up" Pop-up shown
#     And User input sign up email "tesitngperson123@gmc.cm.test" and sign up password "testpassword123"
#     And User click on Sign Up button
#     Then User can see alert shown with message Sign up successful
#     And User click OK on alert

#   @negative @newUser
#   Scenario: Try to register using existing email and password
#     Given User on home page
#     When User click on Sign up menu
#     Then User can see "Sign up" Pop-up shown
#     And User input sign up email with this value "testperson123@gmc.cm.test"
#     And User input sign up password with this value "test123"
#     And User click on Sign Up button
#     Then User can see alert shown with message This user already exist
#     And User click OK on alert