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
  public void userInputEmailWithThisValueUsername(String username, String password) {
    homePage.inputSignupUsernameAndPassword(username, password);
  }

  @And("User input field {string} with this value {string}")
  public void userInputEmailWithThisValueEmail(String field, String value) {
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
    homePage.isSignupSuccess(message, userAction);
  }

  @And("User click OK on alert")
  public void userClickOKOnAlert() {
    homePage.clickOkAlert();
  }

}
