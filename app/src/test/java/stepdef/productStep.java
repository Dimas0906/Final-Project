package stepdef;

import helper.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.productPage;
import pages.homePage;

public class productStep extends BaseTest {
  productPage productPage = new productPage();
  homePage homePage = new homePage();

  // User mengakses Cart
  @Given("User try to open Cart menu")
  public void userOpenCartMenu() {
    productPage.openCartMenu();
  }

  // User melakukan login dengan akun yang sudah ada
  @Given("User try to login using this {string} username and {string} password")
  public void systemPerformLoginUsingExistingUser(String username, String password) {
    homePage.openPage();
    homePage.clickLogInMenu();
    homePage.inputLoginUsernameAndPassword(username, password);
    homePage.clickLogInButton();
    homePage.checkUserSuccessLogin();
  }

  // User melakukan click pada spesifik product
  @When("User try check is the is {string} available")
  public void userCheckProductAvailability(String productName) {
    productPage.isTheProductThere(productName);
  }

  @Then("User try click on {string}")
  public void userClickOnProduct(String productName) {
    productPage.clickProduct(productName);
  }

  @And("User add to cart the product")
  public void userAddProductToCart() {
    productPage.clickAddToCart();
  };

  @And("User click on Home menu to go back")
  public void userClickOnHomeMenu() {
    homePage.clickHome();
  }

  @Then("User can see product {string} on cart")
  public void userCheckProductOnCart(String productName) {
    productPage.isProductListed(productName);
  }

  @And("User click on Place Order button")
  public void userClickOnPlaceOrder() {
    productPage.clickPlaceOrder();
  }

  @And("Place Order pop-up shown")
  public void orderModalPopUpShown() {
    productPage.isPopUpOrderModal();
  }

  @Then("User fill out data for and finish checkout proccess")
  public void userFillOutDataAndFinishCheckout() {
    productPage.inputDataForCheckout();
  }

  @Then("User not fill out data for chcekout and just proccess the checkout")
  public void userNotFillOutDataAndFinishCheckout() {
    productPage.notInputDataForCheckout();
  }
}
