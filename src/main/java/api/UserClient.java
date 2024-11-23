package api;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient {

    private static final String CREATE_USER_URL = "/api/auth/register";
    private static final String LOGIN_USER_URL = "/api/auth/login";
    private static final String DELETE_USER_URL = "/api/auth/user";

    @Step("Создание пользователя")
    public Response sendPostRequestAuthRegister(User user) {
        return given(RequestSpecBuilder.getRequestSpec())
                .header("Content-type", "application/json")
                .body(user)
                .when()
                .post(CREATE_USER_URL);
    }

    @Step("Логин пользователя в системе")
    public Response sendPostRequestAuthLogin(User user) {
        return given(RequestSpecBuilder.getRequestSpec())
                .header("Content-type", "application/json")
                .body(user)
                .when()
                .post(LOGIN_USER_URL);
    }

    @Step("Получение токена")
    public String getAccessToken(Response response) {
        return response.path("accessToken");
    }

    @Step("Удаление пользователя")
    public Response sendDeleteRequestAuthUser(String accessToken) {
        return given(RequestSpecBuilder.getRequestSpec())
                .header("Authorization", accessToken)
                .when()
                .delete(DELETE_USER_URL);
    }
}