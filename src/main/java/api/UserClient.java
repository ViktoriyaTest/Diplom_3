package api;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class UserClient extends RestClient {

    @Step("Регистрация пол-ля")
    public static ValidatableResponse createUser(User user) {
        return given()
                .header("Content-type", "application/json")
                .spec(getBaseSpec())
                .body(user)
                .when()
                .post(REGISTER_URL)
                .then();
    }

    @Step("Авторизация пол-ля")
    public static ValidatableResponse loginUser(User user) {
        return given()
                .header("Content-type", "application/json")
                .spec(getBaseSpec())
                .and()
                .body(user)
                .when()
                .post(AUTH_URL)
                .then();
    }

    @Step("Удалить пол-ля")
    public static ValidatableResponse deleteUser(String accessToken) {
        return given()
                .header("Authorization", accessToken)
                .spec(getBaseSpec())
                .when()
                .delete(DELETE_URL)
                .then();
    }
}