package helper;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class Utility extends BaseTest {

  public static WebDriver driver;

  public static File getListJsonSchema(String schema) {
    return new File("src/test/java/helper/JSONSchema/" + schema);
  }

  public static void getDriver() {
    //
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless");
    options.addArguments("--no-sandbox");
    options.addArguments("--disable-dev-shm-usage");
    options.addArguments("--remote-allow-origin=*");
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver(options);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
  }

  public static void quitDriver() {
    driver.quit();
  }
}
