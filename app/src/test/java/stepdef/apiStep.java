package stepdef;

import helper.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.apiPage;

public class apiStep extends BaseTest {
  apiPage apiPage = new apiPage();

  @Given("prepare url for {string}")
  public void GetUrl(String type) {
    apiPage.prepareUrl(type);
  }

  @When("hit api get list users token {string}")
  public void hitApiGetListUsers(String token) {
    apiPage.hitApiGetListUsers(token);
  }

  @Then("validate response code {int}") // validate response code 201
  public void validateResponseCode(int code) {
    apiPage.validateResponseCode(code);
  }

  @And("validate the respon body")
  public void validateTheResponBody() {
    apiPage.validateTheResponBody();
  }

  @And("validate the json schema for {string}")
  public void validateTheJsonSchema(String schema) {
    apiPage.validateTheJsonSchema(schema);
  }

  @Given("create payload {string}")
  public void createPayload(String payloadType) {
    apiPage.createPayload(payloadType);
  }

  @Then("hit api create new user token {string}")
  public void hitApiCreateNewUser(String token) {
    apiPage.hitApiCreateNewUser(token);
  }

  @When("hit api get specific user token {string} for created id")
  public void hitApiGetSpecificUserUsingCreatedId(String token) {
    apiPage.hitApiGetSpecificUserUsingCreatedId(token);
  }

  @Then("hit api get specific user token {string} using this id {int}")
  public void hitApiGetSpecificUser(String token, int id) {
    apiPage.hitApiGetSpecificUser(token, id);
  }

  @Then("hit api put update and using new payload and the token is {string} using created id and {string} payload")
  public void hitApiToUpdateUserPut(String token, String condition) {
    apiPage.hitApiToUpdateUserPut(token, condition);
  }

  @Then("hit api patch update and using new payload and the token is {string} using created id and the payload is {string}")
  public void hitApiToUpdateUserPatch(String token, String condition) {
    apiPage.hitApiToUpdateUserPatch(token, condition);
  }

  @Then("hit api delete user token {string} using created id")
  public void hitApiToDeleteUser(String token) {
    apiPage.hitApiToDeleteUser(token);
  }
}
