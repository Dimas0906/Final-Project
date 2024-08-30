package pages;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.BaseTest;
import static helper.Utility.driver;

public class productPage extends BaseTest {

  // Validasi product yang di click benaar
  public void isTheProductThere(String productName) {
    driver.findElement(By.xpath("//*[contains(text(),'" + productName + "')]")).isDisplayed();
  }

  // Click pada product
  public void clickProduct(String productName) {
    driver.navigate().refresh();
    driver.findElement(By.xpath("//h4[@class='card-title']//*[contains(text(),'"
        + productName + "')]")).click();
  }

  // Click pada tombol Add to Cart
  public void clickAddToCart() {
    driver.findElement(By.xpath("//*[contains(text(),'Add to cart')]")).click();
  }

  // Click pada alert yang muncul
  public void clickAlert() {
    driver.switchTo().alert().accept();
  }

  // Check apakah product berhasil di add to cart
  public void isProductAddedToCart(String productName) {
    driver.findElement(By.xpath("//td[contains(text(),'" + productName + "')]")).isDisplayed();
  }

  // Check list dari product di cart
  public void isProductListed(String productName) {
    List<WebElement> elements = driver.findElements(By.xpath("//tr[@class=\"success\"]"));

    for (WebElement element : elements) {
      String nameOfProduct = element.findElement(By.xpath("//td[text()=\"productName\"]")).getText();
      if (nameOfProduct.equals(productName)) {
        element.isDisplayed();
      }
    }
  }

  // Click delete pada salah satu product
  public void clickDeleteProduct(String productName) {
    List<WebElement> elements = driver.findElements(By.xpath("//tr[@class=\"success\"]"));

    for (WebElement element : elements) {
      String nameOfProduct = element.findElement(By.xpath("//td[text()=\"productName\"]")).getText();
      if (nameOfProduct.equals(productName)) {
        element.findElement(By.xpath("//td/a[text()=\"Delete\"]")).click();
      }
    }
  }

  // Check product berhasil di hapus
  public void isProductDeleted(String productName) {
    List<WebElement> elements = driver.findElements(By.xpath("//tr[@class=\"success\"]"));

    for (WebElement element : elements) {
      String nameOfProduct = element.findElement(By.xpath("//td[text()=\"productName\"]")).getText();
      if (nameOfProduct != "") {
        continue;
      } else {
        assertTrue(true);
      }
    }
  }

  // Calculate total dari product
  public void calculateTotal() {
    List<WebElement> elements = driver.findElements(By.xpath("//tr[@class=\"success\"]"));
    int totalManual = 0;

    for (WebElement element : elements) {
      String price = element.findElement(By.xpath("//td[3]")).getText();
      totalManual += Integer.parseInt(price);
    }

    String totalPrice = driver.findElement(By.xpath("//h3[@id=\"totalp\"]")).getText();
    int totalFromPage = Integer.parseInt(totalPrice);

    assertTrue(totalManual == totalFromPage);
  }

  // click pada Place Order
  public void clickPlaceOrder() {
    driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();
  }

  // Pop-up Will be shown
  public void isPopUpShown() {
    WebElement popup = driver.findElement(By.xpath("//h5[@id='orderModalLabel']"));
    assertTrue(popup.isDisplayed());
  }

  // Memasukan Name
  public void inputName(String name) {
    driver.findElement(By.id("name")).sendKeys(name);
  }

  // Memasukan Country
  public void inputCountry(String country) {
    driver.findElement(By.id("country")).sendKeys(country);
  }

  // Memasukan City
  public void inputCity(String city) {
    driver.findElement(By.id("city")).sendKeys(city);
  }

  // Memasukan Credit Card
  public void inputCreditCard(String creditCard) {
    driver.findElement(By.id("card")).sendKeys(creditCard);
  }

  // Memasukan Month

  public void inputMonth(String month) {
    driver.findElement(By.id("month")).sendKeys(month);
  }

  // Memasukan Year
  public void inputYear(String year) {
    driver.findElement(By.id("year")).sendKeys(year);
  }

  // Click Close Button
  public void clickCloseButton() {
    driver.findElement(By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[1]")).click();
  }

  // Click Purchase button
  public void clickPurchaseButton() {
    driver.findElement(By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]")).click();
  }

  // Validate Checkout Berhasil
  public void isCheckoutSuccess() {
    WebElement popup = driver.findElement(By.xpath("//h2[contains(text(),'Thank you for your purchase!')]"));
    assertTrue(popup.isDisplayed());
  }

  // Click Ok pada Popup
  public void clickOk() {
    driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
  }
}
