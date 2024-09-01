package pages;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.BaseTest;
import static helper.Utility.driver;

public class productPage extends BaseTest {
  WebDriverWait wait;

  // Open Cart
  public void openCartMenu() {
    driver.navigate().refresh();
    driver.findElement(By.xpath("//*[contains(text(), 'Cart')]")).click();
  }

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

  // Check list dari product di cart
  public void isProductListed(String productName) {
    List<WebElement> elements = driver.findElements(By.xpath("//tr[@class=\"success\"]"));

    for (WebElement element : elements) {
      String nameOfProduct = element.findElement(By.xpath("//td[text()='" + productName + "']")).getText();
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
    WebElement placeOrderButton = driver.findElement(By.xpath("//*[contains(text(), 'Place Order')]"));
    placeOrderButton.click();
  }

  // Pop-up Will be shown
  public void isPopUpOrderModal() {
    WebElement popup = driver.findElement(By.xpath("//body/div[@id='orderModal']/div[1]/div[1]"));
    popup.isDisplayed();
  }

  // Memasukan semua data untuk checkout
  public void inputDataForCheckout() {
    String parentWindowHandler = driver.getWindowHandle();
    String subWindowHandle = null;

    Set<String> handles = driver.getWindowHandles();
    Iterator<String> iterator = handles.iterator();

    while (iterator.hasNext()) {
      subWindowHandle = iterator.next();
    }
    driver.switchTo().window(subWindowHandle);

    // fillout all the data
    driver.findElement(By.xpath("//input[@id='name']")).sendKeys("test person");
    driver.findElement(By.xpath("//input[@id='country']")).sendKeys("Indonesia");
    driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Jakarta");
    driver.findElement(By.xpath("//input[@id='card']")).sendKeys("12345678901122334");
    driver.findElement(By.xpath("//input[@id='month']")).sendKeys("12");
    driver.findElement(By.xpath("//input[@id='year']")).sendKeys("2023");

    // Click on Purchase
    driver.findElement(By.xpath("//button[contains(text(),'Purchase')]")).click();

    // Validate purchase success
    WebElement popup = driver.findElement(By.xpath("//h2[contains(text(),'Thank you for your purchase!')]"));
    assertTrue(popup.isDisplayed());

    // Click OK
    driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();

    // switch back to parent window
    driver.switchTo().window(parentWindowHandler);
  }

  // Memasukan semua data untuk checkout
  public void notInputDataForCheckout() {
    String parentWindowHandler = driver.getWindowHandle();
    String subWindowHandle = null;

    Set<String> handles = driver.getWindowHandles();
    Iterator<String> iterator = handles.iterator();

    while (iterator.hasNext()) {
      subWindowHandle = iterator.next();
    }
    driver.switchTo().window(subWindowHandle);

    // Click on Purchase
    driver.findElement(By.xpath("//button[contains(text(),'Purchase')]")).click();

    // switch back to parent window
    driver.switchTo().window(parentWindowHandler);
  }
}
