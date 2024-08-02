package stepdef;

import helper.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.homePage;

public class homePageStepdef extends BaseTest {
  homePage HomePage;

  @Given("User on home page")
  public void userOnHomePage() {
    HomePage = new homePage(driver);
    HomePage.isHomePage();
  }

  @When("User click on Sign up menu")
  public void userClickOnSignUpMenu() {
    HomePage.clickSignUp();
  }

  @Then("User can see {string} Pop-up shown")
  public void userCanSeePopUpShown(String modal) {
    HomePage.isModalDisplayed("Sign up");
  }

  @And("User input sign up email {string} and sign up password {string}")
  public void userInputEmailWithThisValueUsername(String username, String password) {
    HomePage.inputSignupUsernameAndPassword(username, password);
  }

  @And("User input sign up password with this value {string}")
  public void userInputPasswordWithThisValuePassword(String password) {
    HomePage.inputSignupPassword(password);
  }

  @And("User click on Sign Up button")
  public void userClickOnSignUpButton() {
    HomePage.clickSignUpButton();
  }

  @Then("User can see alert shown with message Sign up successful")
  public void userCanSeeAlertShownWithMessageSignUpSuccessful() {
    HomePage.isSignupSuccess();
  }

  @And("User click OK on alert")
  public void userClickOKOnAlert() {
    HomePage.clickOkAlert();
  }

  @Then("User can see alert shown with message This user already exist")
  public void userCanSeeAlertShownWithMessageThisUserAlreadyExist() {
    HomePage.isSignupFailed();
  }
}
