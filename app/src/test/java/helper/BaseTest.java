package helper;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
  protected static WebDriver driver;

  protected void getDriver() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless");
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver(options);
  }

  public class getRandomName {
    private static final String[] FIRST_NAMES = { "James", "Mary", "John", "Patricia", "Robert", "Jennifer", "Michael",
        "Linda", "Santo", "Ryu" };
    private static final String[] LAST_NAMES = { "Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller",
        "Davis", "Ahmad", "Samid" };

    public static String generateName() {
      Random random = new Random();
      String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
      String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
      return firstName + " " + lastName;
    }
  }

  public static String generateRandomEmail() {
    String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    String emailDomain = "@gmc.cm.test";
    StringBuilder email = new StringBuilder();
    Random random = new Random();
    for (int i = 0; i < 10; i++) { // Generate 10-character long email prefix
      int index = random.nextInt(characters.length());
      email.append(characters.charAt(index));
    }
    email.append(emailDomain);
    return email.toString();
  }

  public static String chooseRandomGender() {
    Random random = new Random();
    String[] genders = { "male", "female" };
    return genders[random.nextInt(genders.length)];
  }

  public static String randomizeActiveInactive() {
    Random random = new Random();
    String[] status = { "active", "inactive" };
    return status[random.nextInt(status.length)];
  }
}
