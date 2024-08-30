@featureAll
Feature: Product Feature

  @product
  Scenario: Add product to cart
    Given User try to login using this "testemasil123@gc.cm.test" username and "12345678" password
    When User try check is the is "Nokia lumia 1520" available
    Then User try click on "Nokia lumia 1520"
    And User add to cart the product
    Then User can see alert shown with message "Product added." and Click "OK"

  @product
  Scenario: User try to add more than one product to cart
    Given User try to login using this "testemasil123@gc.cm.test" username and "12345678" password
    When User try check is the is "Nokia lumia 1520" available
    Then User try click on "Nokia lumia 1520"
    And User add to cart the product
    Then User can see alert shown with message "Product added." and Click "OK"
    And User click on Home menu to go back
    When User try check is the is "Sony vaio i5" available
    Then User try click on "Sony vaio i5"
    And User add to cart the product
    Then User can see alert shown with message "Product added." and Click "OK"


