package pages;

import java.util.Set;
import java.time.Duration;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import static helper.Utility.driver;
import org.openqa.selenium.Alert;

import helper.BaseTest;

public class homePage extends BaseTest {
  WebDriverWait wait;
  String randomEmail = generateRandomEmail();
  String randomPassowrd = getRandomName.generateName() + "123";
  Set<Cookie> cookies;

  // Open page
  public void openPage() {
    driver.get("https://www.demoblaze.com/");
  }

  // Click pada Home
  public void clickHome() {
    driver.findElement(By.xpath("//a[contains(text(), \"Home\")]")).click();
  }

  // Validasi posisi page harus di Home
  public void isHomePage() {
    String homeUrl = "https://www.demoblaze.com/index.html";

    driver.get(homeUrl);
  }

  // Valiasi signup modal muncul
  public void isModalDisplayed(String modal) {
    String modalId = "";

    switch (modal) {
      case "Sign up":
        modalId = "signInModalLabel";
        break;
      case "Log in":
        modalId = "logInModalLabel";
        break;
      case "About us":
        modalId = "videoModalLabel";
        break;
      case "Contact":
        modalId = "exampleModalLabel";
        break;

      default:
        break;
    }
    if (modalId != "") {
      driver.findElement(By.xpath("//h5[@id=\'" + modalId + "\']")).isDisplayed();
    }
  }

  // Click pada Close
  public void clickCloseModal(String modal) {
    String modalId = "";

    switch (modal) {
      case "Log in":
        modalId = "logInModal";
        break;
      case "Sign up":
        modalId = "signInModal";
        break;
      case "About us":
        modalId = "videoModal";
        break;
      case "Contact":
        modalId = "exampleModal";
        break;

      default:
        break;
    }

    if (modalId != "") {
      driver.findElement(By.xpath("//body/div[@id='" + modalId + "']/div[1]/div[1]/div[3]/button[1]"))
          .click();
    }
  }

  // User dapat melihat signup berhasil pada alert
  public void chceckAlertMessage(String message, String userAction) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    wait.until(ExpectedConditions.alertIsPresent());

    Alert alert = driver.switchTo().alert();

    switch (message) {
      case "Sign up successful.":
        alert.getText().contains("Sign up successful.");
        break;

      case "This user already exist.":
        alert.getText().contains("This user already exist.");
        break;

      case "Please fill out Username and Password.":
        alert.getText().contains("Please fill out Username and Password.");
        break;

      case "Wrong passwrod.":
        alert.getText().contains("Wrong passwrod.");
        break;

      case "User does not exist.":
        alert.getText().contains("User does not exist.");
        break;

      case "Thanks for the message!!":
        alert.getText().contains("Thanks for the message!!");
        break;

      case "Product added.":
        alert.getText().contains("Product added.");
        break;

      default:
        break;
    }

    if (userAction == "OK") {
      alert.accept();
    } else {
      alert.dismiss();
    }
  }

  // ----------------- SIGN UP -----------------

  // Click pada Sign Up
  public void clickSignUp() {
    driver.findElement(By.xpath("//a[text()='Sign up']")).click();
  }

  // Memasukan username dan password untuk signup
  public void inputSignupUsernameAndPassword(String username, String password) {
    String parentWindowHandler = driver.getWindowHandle();
    String subWindowHandle = null;

    Set<String> handles = driver.getWindowHandles();
    Iterator<String> iterator = handles.iterator();

    while (iterator.hasNext()) {
      subWindowHandle = iterator.next();
    }
    driver.switchTo().window(subWindowHandle);

    driver.findElement(By.xpath("//*[@id=\"sign-username\"]")).sendKeys(username);
    driver.findElement(By.xpath("//*[@id=\"sign-password\"]")).sendKeys(password);

    driver.switchTo().window(parentWindowHandler);
  }

  // memasukan cuma salah satu field saja (email / password)
  public void inputOneFieldOnly(String field, String something) {
    String parentWindowHandler = driver.getWindowHandle();
    String subWindowHandle = null;

    Set<String> handles = driver.getWindowHandles();
    Iterator<String> iterator = handles.iterator();

    while (iterator.hasNext()) {
      subWindowHandle = iterator.next();
    }
    driver.switchTo().window(subWindowHandle);

    if (field == "email") {
      driver.findElement(By.xpath("//*[@id=\"sign-email\"]")).sendKeys(something);
    } else {
      driver.findElement(By.xpath("//*[@id=\"sign-password\"]")).sendKeys(something);
    }

    driver.switchTo().window(parentWindowHandler);
  }

  // CLick pada Sign up
  public void clickSignUpButton() {
    driver.findElement(By.xpath("//button[contains(text(),'Sign up')]")).click();
  }

  //

  public void inputGeneratedEmailPassword() {
    inputSignupUsernameAndPassword(randomEmail, randomPassowrd);
  }

  // ----------------- LOG IN -----------------

  // CLick pada Log in
  public void clickLogInMenu() {
    driver.findElement(By.xpath("//a[text()='Log in']")).click();
  }

  // Click pada Log in
  public void clickLogInButton() {
    driver.findElement(By.xpath("//button[text()='Log in']")).click();
  }

  // Memasukan username dan password untuk login
  public void inputLoginUsernameAndPassword(String username, String password) {
    String parentWindowHandler = driver.getWindowHandle();
    String subWindowHandle = null;

    Set<String> handles = driver.getWindowHandles();
    Iterator<String> iterator = handles.iterator();

    while (iterator.hasNext()) {
      subWindowHandle = iterator.next();
    }
    driver.switchTo().window(subWindowHandle);

    driver.findElement(By.xpath("//*[@id=\"loginusername\"]")).sendKeys(username);
    driver.findElement(By.xpath("//*[@id=\"loginpassword\"]")).sendKeys(password);

    driver.switchTo().window(parentWindowHandler);
  }

  // memasukan cuma salah satu field saja (email / password)
  public void inputOneFieldOnlyForLogin(String field, String something) {
    String parentWindowHandler = driver.getWindowHandle();
    String subWindowHandle = null;

    Set<String> handles = driver.getWindowHandles();
    Iterator<String> iterator = handles.iterator();

    while (iterator.hasNext()) {
      subWindowHandle = iterator.next();
    }
    driver.switchTo().window(subWindowHandle);

    if (field == "username") {
      driver.findElement(By.xpath("//*[@id=\"loginusername\"]")).sendKeys(something);
    } else {
      driver.findElement(By.xpath("//*[@id=\"loginpassword\"]")).sendKeys(something);
    }

    driver.switchTo().window(parentWindowHandler);
  }

  public void checkUserSuccessLogin() {
    // Cookie variable
    WebElement welcomeElement = driver.findElement(By.xpath("//*[@id='nameofuser']"));
    welcomeElement.isDisplayed();
  }

  // ----------------- CART -----------------

  // Click pada Cart
  public void clickCart() {
    driver.findElement(By.xpath("//*[contains(text(),\"Cart\")]")).click();
  }

  public void isCartPage() {
    String cartUrl = "https://www.demoblaze.com/cart.html";
    driver.get(cartUrl);
  }

  // ----------------- About Us -----------------

  // Click pada About us
  public void clickAboutUsMenu() {
    driver.findElement(By.xpath("//a[text()='About us']")).click();
  }

  public void userCloseAboutUsModal() {
    driver.findElement(By.xpath("//body/div[@id='videoModal']/div[1]/div[1]/div[3]/button[1]")).click();
  }

  // ----------------- Contact us -----------------

  // Click pada Contact us
  public void clickContactMenu() {
    driver.findElement(By.xpath("//a[text()='Contact']")).click();
  }

  // Memasukan semua informasi untuk mengirimkan contact
  public void userFillUpAllTheInformationOnContact(String email, String name, String message) {
    String parentWindowHandler = driver.getWindowHandle();
    String subWindowHandle = null;

    Set<String> handles = driver.getWindowHandles();
    Iterator<String> iterator = handles.iterator();

    while (iterator.hasNext()) {
      subWindowHandle = iterator.next();
    }
    driver.switchTo().window(subWindowHandle);

    driver.findElement(By.xpath("//input[@id=\"recipient-email\"]")).sendKeys(email);
    driver.findElement(By.xpath("//input[@id=\"recipient-name\"]")).sendKeys(name);
    driver.findElement(By.xpath("//textarea[@id=\"message-text\"]")).sendKeys(message);

    driver.switchTo().window(parentWindowHandler);
  }

  // Click pada Send message
  public void clickSendMessage() {
    driver.findElement(By.xpath("//button[contains(text(),'Send message')]")).click();
  }

  public void clickCloseButtonOnContactUs() {
    driver.findElement(By.xpath("//button[contains(text(),'Close')]")).click();
  }

  // User click pada Categories
  public void selectOnCategories(String categories) {
    if (categories != "") {
      driver.findElement(By.xpath("//div[@class=\"list-group\"]/a[text()='" + categories + "']")).click();
    }
  }

  // User pilih produk
  public void clickOnProduct(String product) {
    if (product != "") {
      driver.findElement(By.xpath("//a[contains(text(),'" + product + "')]")).click();
    }
  }

  // // ----------------- Manage Cookied -----------------

  // // Get all the cookied setelah sukses login
  // public void getAllCookies() {
  // cookies = driver.manage().getCookies();
  // for (Cookie getCookie : cookies) {
  // System.out.println("Ini adalah per-vlaue cookie " + getCookie);
  // }
  // }

}
