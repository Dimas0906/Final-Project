package pages;

import java.util.Set;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePage {

  WebDriver driver;

  // Constructor untuk Home Pages
  public homePage(WebDriver driver) {
    this.driver = driver;
  }

  // Click pada Home
  public void clickHome() {
    driver.findElement(By.xpath("//a[text()='Home']")).click();
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

  // Click pada Sign Up
  public void clickSignUp() {
    driver.findElement(By.xpath("//a[text()='Sign up']")).click();
  }

  // CLick pada Log in
  public void clickLogIn() {
    driver.findElement(By.xpath("//a[text()='Log in']")).click();
  }

  // Click pada Cart
  public void clickCart() {
    driver.findElement(By.xpath("//a[text()='Cart']")).click();
  }

  // Click pada About us
  public void clickAboutUs() {
    driver.findElement(By.xpath("//a[text()='About us']")).click();
  }

  // Click pada Contact
  public void clickContact() {
    driver.findElement(By.xpath("//a[text()='Contact']")).click();
  }

  // Memasukan username untuk signup
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

    driver.switchTo().window(parentWindowHandler);
  }

  // Memasukan password untuk signup
  public void inputSignupPassword(String password) {
    driver.findElement(By.xpath("//input[@id=\"sign-password\"]")).sendKeys(password);
  }

  // CLick pada Sign up
  public void clickSignUpButton() {
    driver.findElement(By.xpath("//button[contains(text(),'Sign up')]")).click();
  }

  // Click pada Log in
  public void clickLogInButton() {
    driver.findElement(By.xpath("//button[text()='Log in']")).click();
  }

  // Memasukan username untuk login
  public void inputLoginUsername(String username) {
    driver.findElement(By.xpath("//input[@id=\"loginusername\"]")).sendKeys(username);
  }

  // Memasukan password untuk login
  public void inputLoginPassword(String password) {
    driver.findElement(By.xpath("//input[@id=\"loginpassword\"]")).sendKeys(password);
  }

  // Click pada Close atau Log In
  public void clickCloseLogin(String button) {
    driver.findElement(By.xpath("//button[text()='" + button + "']/following-sibling::button[text()=\"Log in\"]"))
        .click();
  }

  // Memasukan contact email
  public void inputContactEmail(String email) {
    driver.findElement(By.xpath("//input[@id=\"recipient-email\"]")).sendKeys(email);
  }

  // Memasukan Contact name
  public void inputContactName(String name) {
    driver.findElement(By.xpath("//input[@id=\"recipient-name\"]")).sendKeys(name);
  }

  // Memasukan Contact message
  public void inputContactMessage(String message) {
    driver.findElement(By.xpath("//textarea[@id=\"message-text\"]")).sendKeys(message);
  }

  // Click pada Send Message
  public void clickSendMessage() {
    driver.findElement(By.xpath("//button[text()='Send message']")).click();
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

  // User dapat melihat Signup sukses pada alert
  public void isSignupSuccess() {
    driver.switchTo().alert().getText().contains("Sign up successful.");
  }

  // User dapat melihat signup gagal pada alert karena user sudah ada
  public void isSignupFailed() {
    driver.switchTo().alert().getText().contains("This user already exist.");
  }

  // User click OK pada allert
  public void clickOkAlert() {
    driver.switchTo().alert().accept();
  }
}
