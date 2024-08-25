package stepdef;

import helper.Utility;
import helper.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class cucumberHook extends BaseTest {
  @Before
  public void beforeTest() {
    Utility.getDriver();
  }

  @After
  public void afterTest() {
    Utility.quitDriver();
  }
}
