package stepdef;

import helper.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class cucumberHook extends BaseTest {
  @Before
  public void beforeTest() {
    getDriver();
  }

  @After
  public void afterTest() {
    driver.quit();
  }
}
