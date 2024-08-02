@apiAll
Feature: API Testing

  @test
  Scenario: Get List Users with token
    Given prepare url for "Get_User_List"
    When hit api get list users token "Yes"
    Then validate response code 200
    And validate the respon body
    And validate the json schema for "get_list_user_normal.json"

  @test
  Scenario: API List Users no token
    Given prepare url for "Get_User_List"
    When hit api get list users token "No"
    Then validate response code 200
    And validate the respon body
    And validate the json schema for "get_list_user_normal.json"

  @test
  Scenario: Create new User with token
    Given prepare url for "Create_User"
    When create payload "valid_new_user"
    Then hit api create new user token "Yes"
    And validate response code 201
    And validate the json schema for "get_post_put_specific_user.json"

  @test
  Scenario: Create new user with existing email and with token
    Given prepare url for "Create_User"
    When create payload "valid_specified_user"
    Then hit api create new user token "Yes"
    And validate response code 422
    And validate the json schema for "post_email_exist.json"
  #
  @test
  Scenario: Create user without Gender & Status
    Given prepare url for "Create_User"
    When create payload "without_gender&status"
    Then hit api create new user token "Yes"
    And validate response code 422
    And validate the json schema for "post_without_gender&status.json"

  @test
  Scenario: Create user without payload
    Given prepare url for "Create_User"
    When create payload "Invalid_no_payload"
    Then hit api create new user token "Yes"
    And validate response code 422
    And validate the json schema for "post_without_payload.json"

  @test
  Scenario: Create new user without token
    Given prepare url for "Create_User"
    When create payload "valid_new_user"
    Then hit api create new user token "No"
    And validate response code 401
    And validate the json schema for "without_token.json"

  @test
  Scenario: Try to Get Specific User with token
    Given prepare url for "Get_Single_User"
    When hit api get specific user token "Yes" for created id
    Then validate response code 200
    And validate the json schema for "get_post_put_specific_user.json"

  @test
  Scenario: Try to Get Specific User without token
    Given prepare url for "Get_Single_User"
    When hit api get specific user token "No" for created id
    Then validate response code 404
    And validate the json schema for "without_token.json"

  @test
  Scenario: Try to Get Specific User with token but wrong id
    Given prepare url for "Get_Single_User"
    When hit api get specific user token "No" for created id
    Then validate response code 404
    And validate the json schema for "without_token.json"

  @test
  Scenario: Try to update existing user with token put change name & email
    Given prepare url for "Update_Specific_User"
    When create payload "Update_User"
    Then hit api put update and using new payload and the token is "Yes" using created id and "full" payload
    And validate response code 200
    And validate the json schema for "get_post_put_specific_user.json"

  @test
  Scenario: Try to update existing user with token put change email only
    Given prepare url for "Update_Specific_User"
    When create payload "Update_User"
    Then hit api put update and using new payload and the token is "Yes" using created id and "half" payload
    And validate response code 200
    And validate the json schema for "get_post_put_specific_user.json"

  @test
  Scenario: Try to create new user with token but using invalid id
    Given prepare url for "Update_Specific_User"
    When create payload "Update_User"
    Then hit api put update and using new payload and the token is "No" using created id and "invalid" payload
    And validate response code 404
    And validate the json schema for "without_token.json"

  @test
  Scenario: Try to update existing user with token and only change the name
    Given prepare url for "Update_Specific_User"
    When create payload "only_name"
    Then hit api patch update and using new payload and the token is "Yes" using created id and the payload is "name_only"
    And validate response code 200
    And validate the json schema for "get_post_put_specific_user.json"

  @test
  Scenario: Try to update existing user with token and only change the email
    Given prepare url for "Update_Specific_User"
    When create payload "only_email"
    Then hit api patch update and using new payload and the token is "Yes" using created id and the payload is "email_only"
    And validate response code 200
    And validate the json schema for "get_post_put_specific_user.json"

  @test
  Scenario: Try to update existing user with token and only change the email & name
    Given prepare url for "Update_Specific_User"
    When create payload "without_gender&status"
    Then hit api patch update and using new payload and the token is "Yes" using created id and the payload is "half"
    And validate response code 200
    And validate the json schema for "get_post_put_specific_user.json"

  @test
  Scenario: Try to update existing user with token and only change the email & name witout token
    Given prepare url for "Update_Specific_User"
    When create payload "without_gender&status"
    Then hit api patch update and using new payload and the token is "No" using created id and the payload is "half"
    And validate response code 404
    And validate the json schema for "without_token.json"

  @test
  Scenario: Try to delete existing user without token
    Given prepare url for "Delete_Specific_User"
    When hit api delete user token "No" using created id
    Then validate response code 404
    And validate the json schema for "without_token.json"

  @test
  Scenario: Try to delete existing user with token
    Given prepare url for "Delete_Specific_User"
    When hit api delete user token "Yes" using created id
    Then validate response code 204