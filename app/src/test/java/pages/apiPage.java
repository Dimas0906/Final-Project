package pages;

import helper.BaseTest;
import helper.Endpoint;
import helper.Models;
import java.util.List;
import helper.Utility;
import java.io.File;
import java.util.concurrent.*;

import org.awaitility.Awaitility;
import org.json.JSONObject;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;

public class apiPage extends BaseTest {
  // all variable
  String targetUrl, userIdCreated, createdUser;
  private static int newUserIdCreated;
  private static String newUserEmailCreated;
  Response res, specificUser;

  // all object
  JSONObject payload = new JSONObject();

  // ----- all method -----

  public String prepareUrl(String Type) {
    switch (Type) {
      case "Get_User_List":
        targetUrl = Endpoint.Get_User_List;
        break;

      case "Get_Single_User":
        targetUrl = Endpoint.Get_Single_User;
        break;

      case "Create_User":
        targetUrl = Endpoint.Create_User;
        break;

      case "Update_Specific_User":
        targetUrl = Endpoint.Update_Specific_User;
        break;

      case "Delete_Specific_User":
        targetUrl = Endpoint.Delete_Specific_User;
        break;

      default:
        return "There's No End poitn Found!";
    }

    return targetUrl;
  }

  public void hitApiGetListUsers(String token) {
    res = Models.hitApiGetListUsersWithToken(targetUrl, token);
  }

  public void validateTheResponBody() {
    List<Object> id = res.jsonPath().getList("id");
    List<Object> name = res.jsonPath().getList("name");
    List<Object> email = res.jsonPath().getList("email");
    List<Object> gender = res.jsonPath().getList("gender");
    List<Object> status = res.jsonPath().getList("status");

    assertThat(id.get(0)).isNotNull();
    assertThat(name.get(0)).isNotNull();
    assertThat(email.get(0)).isNotNull();
    assertThat(gender.get(0)).isIn("male", "female");
    assertThat(status.get(0)).isIn("active", "inactive");
  }

  public void validateTheJsonSchema(String schema) {
    File JsonType = Utility.getListJsonSchema(schema);
    res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JsonType));
  }

  public void createPayload(String payloadType) {
    switch (payloadType) {
      case "valid_new_user":
        payload.put("name", getRandomName.generateName());
        payload.put("email", generateRandomEmail());
        payload.put("gender", chooseRandomGender());
        payload.put("status", randomizeActiveInactive());
        break;

      case "valid_specified_user":
        payload.put("name", "Dimas Maulana");
        payload.put("email", newUserEmailCreated);
        payload.put("gender", chooseRandomGender());
        payload.put("status", randomizeActiveInactive());
        break;

      case "without_gender&status":
        payload.put("name", getRandomName.generateName());
        payload.put("email", generateRandomEmail());
        break;

      case "only_name":
        payload.put("name", getRandomName.generateName());
        break;

      case "only_email":
        payload.put("email", generateRandomEmail());
        break;

      case "Invalid_no_payload":
        break;

      case "Update_User":
        payload.put("name", getRandomName.generateName());
        payload.put("email", generateRandomEmail());
        payload.put("gender", chooseRandomGender());
        payload.put("status", randomizeActiveInactive());
        break;

      default:
        System.out.println("There's No Payload Found!");
    }
  }

  public void hitApiCreateNewUser(String token) {

    res = Models.hitApiCreateNewUserWithToken(targetUrl, token, payload);

    if (res.getStatusCode() == 201) {
      createdUser = res.getBody().asString();

      JsonPath jsonPath = new JsonPath(createdUser);

      newUserIdCreated = jsonPath.getInt("id");
      newUserEmailCreated = jsonPath.getString("email");
    }
  }

  public void validateResponseCode(int code) {
    assertThat(res.getStatusCode()).isEqualTo(code);
  }

  public void hitApiGetSpecificUserUsingCreatedId(String token) {
    // Wait until the newUserIdCreated is not 0
    Awaitility.await()
        .atMost(30, TimeUnit.SECONDS)
        .pollInterval(5, TimeUnit.SECONDS)
        .until(() -> newUserIdCreated != 0);

    if (newUserIdCreated != 0) {
      res = Models.hitApiGetSpecificUserWithToken(targetUrl, token, newUserIdCreated);
    }
  }

  public void hitApiGetSpecificUser(String token, int id) {
    res = Models.hitApiGetSpecificUserWithToken(targetUrl, token, id);
  }

  public void hitApiToUpdateUserPut(String token, String condition) {
    String name, email, newResponse;

    Awaitility.await()
        .atMost(30, TimeUnit.SECONDS)
        .pollInterval(5, TimeUnit.SECONDS)
        .until(() -> newUserIdCreated != 0);

    if (newUserIdCreated != 0) {
      if (condition.equals("full")) {
        name = Models.getSpeficicDataFromUser(Endpoint.Get_Single_User, newUserIdCreated, "name");
        email = Models.getSpeficicDataFromUser(Endpoint.Get_Single_User, newUserIdCreated, "email");

        res = Models.hitApiToUpdateUserWithToken(targetUrl, token, newUserIdCreated, payload);
        newResponse = res.getBody().asString();

        // Validate the response
        assertFalse(newResponse.contains(name));
        assertFalse(newResponse.contains(email));
      } else if (condition.equals("half")) {
        email = Models.getSpeficicDataFromUser(Endpoint.Get_Single_User, newUserIdCreated, "email");

        res = Models.hitApiToUpdateUserWithToken(targetUrl, token, newUserIdCreated, payload);
        newResponse = res.getBody().asString();

        assertFalse(newResponse.contains(email));
      } else {
        res = Models.hitApiToUpdateUserWithToken(targetUrl, token, newUserIdCreated, payload);
      }
    } else {
      res = Models.hitApiToUpdateUserWithToken(targetUrl, token, 0, payload);
    }

  }

  public void hitApiToUpdateUserPatch(String token, String condition) {
    String name, email, newResponse;

    Awaitility.await()
        .atMost(30, TimeUnit.SECONDS)
        .pollInterval(5, TimeUnit.SECONDS)
        .until(() -> newUserIdCreated != 0);

    if (newUserIdCreated != 0) {
      if (condition.equals("half")) {
        name = Models.getSpeficicDataFromUser(Endpoint.Get_Single_User, newUserIdCreated, "name");
        email = Models.getSpeficicDataFromUser(Endpoint.Get_Single_User, newUserIdCreated, "email");

        res = Models.hitApiToUpdateUserPatchWithToken(targetUrl, token, newUserIdCreated, payload);
        newResponse = res.getBody().asString();

        // Validate the response
        assertFalse(newResponse.contains(name));
        assertFalse(newResponse.contains(email));
      } else if (condition.equals("email_only")) {
        email = Models.getSpeficicDataFromUser(Endpoint.Get_Single_User, newUserIdCreated, "email");

        res = Models.hitApiToUpdateUserPatchWithToken(targetUrl, token, newUserIdCreated, payload);
        newResponse = res.getBody().asString();

        assertFalse(newResponse.contains(email));
      } else if (condition.equals("name_only")) {
        name = Models.getSpeficicDataFromUser(Endpoint.Get_Single_User, newUserIdCreated, "name");

        res = Models.hitApiToUpdateUserPatchWithToken(targetUrl, token, newUserIdCreated, payload);
        newResponse = res.getBody().asString();

        assertFalse(newResponse.contains(name));
      } else {
        res = Models.hitApiToUpdateUserPatchWithToken(targetUrl, token, newUserIdCreated, payload);
      }
    } else {
      res = Models.hitApiToUpdateUserPatchWithToken(targetUrl, token, 0, payload);
    }
  }

  public void hitApiToDeleteUser(String token) {
    Awaitility.await()
        .atMost(30, TimeUnit.SECONDS)
        .pollInterval(5, TimeUnit.SECONDS)
        .until(() -> newUserIdCreated != 0);

    if (newUserIdCreated != 0) {
      res = Models.hitApiToDeleteUserWithToken(targetUrl, token, newUserIdCreated);
    } else {
      res = Models.hitApiToDeleteUserWithToken(targetUrl, token, 0);
    }
  }
}
