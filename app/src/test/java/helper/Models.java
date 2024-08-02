package helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Models {
  private static RequestSpecification request;

  public static void setupHeadersWithToken() {
    request = RestAssured.given()
        .header("Authorization", "Bearer " + Endpoint.Auth_Token)
        .header("Content-Type", "application/json")
        .header("Accept", "application/json");
  }

  public static void setupHeaderNoToken() {
    request = RestAssured.given()
        .header("Content-Type", "application/json")
        .header("Accept", "application/json");
  }

  public static Response hitApiGetListUsersWithToken(String url, String token) {
    if (token.equals("Yes")) {
      setupHeadersWithToken();
    } else {
      setupHeaderNoToken();
    }

    return request.when().get(url);
  }

  public static Response hitApiCreateNewUserWithToken(String url, String token, Object payload) {
    if (token.equals("Yes")) {
      setupHeadersWithToken();
    } else {
      setupHeaderNoToken();
    }

    return request.when().body(payload.toString()).post(url);
  }

  public static String getSpeficicDataFromUser(String url, int id, String field) {
    setupHeadersWithToken();

    return request.when().get(url + id).then().extract().path(field);
  }

  public static Response hitApiGetSpecificUserWithToken(String url, String token, int id) {

    if (token.equals("Yes")) {
      setupHeadersWithToken();
    } else {
      setupHeaderNoToken();
    }

    return request.when().get(url + id);
  }

  public static Response hitApiToUpdateUserWithToken(String url, String token, int id, Object payload) {
    if (token.equals("Yes")) {
      setupHeadersWithToken();
    } else {
      setupHeaderNoToken();
    }

    return request.when().body(payload.toString()).put(url + id);
  }

  public static Response hitApiToUpdateUserPatchWithToken(String url, String token, int id, Object payload) {
    if (token.equals("Yes")) {
      setupHeadersWithToken();
    } else {
      setupHeaderNoToken();
    }

    return request.when().body(payload.toString()).patch(url + id);
  }

  public static Response hitApiToDeleteUserWithToken(String url, String token, int id) {
    if (token.equals("Yes")) {
      setupHeadersWithToken();
    } else {
      setupHeaderNoToken();
    }

    return request.when().delete(url + id);
  }

}
