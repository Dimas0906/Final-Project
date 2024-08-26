package stepdef;

import helper.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.homePage;

public class homePageStep extends BaseTest {
  homePage homePage;

  public homePageStep() {
    homePage = new homePage();
  }

  @Given("open web page")
  public void openWebPage() {
    homePage.openPage();
  }

  @When("User click on Sign up menu")
  public void userClickOnSignUpMenu() {
    homePage.clickSignUp();
  }

  @Then("User can see {string} Pop-up shown") // General scenario for pop-up
  public void userCanSeePopUpShown(String modal) {
    homePage.isModalDisplayed("Sign up");
  }

  @And("User input sign up email {string} and sign up password {string}")
  public void userSignupWithSpecificUsernameAndPassword(String username, String password) {
    homePage.inputSignupUsernameAndPassword(username, password);
  }

  @And("User input field {string} with this value {string}")
  public void userInputOnlyOneField(String field, String value) {
    homePage.inputOneFieldOnly(field, value);
  }

  @And("Let the system generated random email and password")
  public void systemGeneratedRandomEmailAndPassword() {
    homePage.inputGeneratedEmailPassword();
  }

  @And("User click on Sign Up button")
  public void userClickOnSignUpButton() {
    homePage.clickSignUpButton();
  }

  @Then("User can see alert shown with message {string} and Click {string}")
  public void userCanSeeAlertShownWithMessageSignUpSuccessful(String message, String userAction) {
    homePage.chceckAlertMessage(message, userAction);
  }

  @And("User click OK on alert")
  public void userClickOKOnAlert() {
    homePage.clickOkAlert();
  }

  @When("User click on Log in menu")
  public void userClickOnLoginMenu() {
    homePage.clickLogInMenu();
  }

  @Then("User click on Log in button")
  public void userClickOnLoginButton() {
    homePage.clickLogInButton();
  }

  @Then("User can see Welcom user on the top right of the page")
  public void userCanSeeWelcomeUserOnTheTopRightOfThePage() {
    homePage.checkUserSuccessLogin();
  }

  @And("User input log in username {string} and log in password {string}")
  public void userInputLoginUsernameAndPassword(String username, String password) {
    homePage.inputLoginUsernameAndPassword(username, password);
  }

  @And("User input field {string} with this value {string} on log in")
  public void userInputOnlyOneFieldForLogin(String field, String value) {
    homePage.inputOneFieldOnlyForLogin(field, value);
  }

}
