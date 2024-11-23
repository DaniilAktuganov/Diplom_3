package praktikum;

import api.User;
import api.UserClient;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.apache.http.HttpStatus.SC_ACCEPTED;
import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {

    private User user;
    private UserClient userClient;
    private Response response;

    private final String name = RandomStringUtils.randomAlphabetic(5);
    private final String email = RandomStringUtils.randomAlphabetic(5) + "@yandex.ru";
    private final String password = RandomStringUtils.randomAlphabetic(6);

    @Before
    public void setupUser() {
        user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);
        userClient = new UserClient();
        response = userClient.sendPostRequestAuthRegister(user);
    }
    @Test
    @DisplayName("Успешный вход по кнопке «Войти в аккаунт» на главной")
    @Description("Проверка входа в аккаунт по кнопке «Войти в аккаунт» на главной")
    public void loginToAccountButtonTest() {
        objHomePage.clickLoginToAccountButton();
        objLoginPage.login(email, password);
        objHomePage.waitPageLoad();
        assertTrue(objHomePage.createOrderButtonIsEnabled());
    }

    @Test
    @DisplayName("Успешный вход через кнопку «Личный кабинет»")
    @Description("Проверка входа в аккаунт через «Личный кабинет»")
    public void loginPersonalAccountButtonTest() {
        objHomePage.clickPersonalAccountButton();
        objLoginPage.login(email, password);
        objHomePage.waitPageLoad();
        assertTrue(objHomePage.createOrderButtonIsEnabled());
    }

    @Test
    @DisplayName("Успешный вход через кнопку в форме регистрации")
    @Description("Проверка входа в аккаунт через кнопку в форме регистрации")
    public void loginInRegistrationPageTest() {
        objHomePage.clickPersonalAccountButton();
        objLoginPage.clickRegisterButton();
        objRegistrationPage.clickLoginButton();
        objLoginPage.login(email, password);
        objHomePage.waitPageLoad();
        assertTrue(objHomePage.createOrderButtonIsEnabled());
    }

    @Test
    @DisplayName("Успешный вход через кнопку в форме восстановления пароля")
    @Description("Проверка входа в аккаунт через кнопку в форме восстановления пароля")
    public void loginInPasswordRecoveryPageTest() {
        objHomePage.clickLoginToAccountButton();
        objLoginPage.clickRecoverPasswordButton();
        objPasswordRecoveryPage.clickRegisterButton();
        objLoginPage.login(email, password);
        objHomePage.waitPageLoad();
        assertTrue(objHomePage.createOrderButtonIsEnabled());
    }

    @After
    public void deleteUser() {
        String accessToken = userClient.getAccessToken(response);
        userClient.sendDeleteRequestAuthUser(accessToken).then().statusCode(SC_ACCEPTED);
    }
}