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

public class PersonalAccountTest extends BaseTest {

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
        objHomePage.clickLoginToAccountButton();
        objLoginPage.login(email, password);
    }

    @Test
    @DisplayName("Успешный переход в личный кабинет")
    @Description("Проверка, что пользователя может перейти в личный кабинет по клику по кнопке «Личный кабинет»")
    public void goToPersonalAccountTest() {
        objHomePage.clickPersonalAccountButton();
        assertTrue(objPersonalAccountPage.exitButtonIsEnabled());
    }

    @Test
    @DisplayName("Успешный переход из личного кабинета в конструктор")
    @Description("Проверка, что пользователя может перейти из личного кабинета в конструктор»")
    public void goToConstructorTest() {
        objHomePage.clickPersonalAccountButton();
        objPersonalAccountPage.clickConstructorButton();
        assertTrue(objHomePage.createOrderButtonIsEnabled());
    }

    @Test
    @DisplayName("Успешный выход из аккаунта")
    @Description("Проверка, что пользователя может выйти из аккаунта")
    public void logoutTest() {
        objHomePage.clickPersonalAccountButton();
        objPersonalAccountPage.clickExitButton();
        objLoginPage.waitPageLoad();
        assertTrue(objLoginPage.loginButtonIsEnabled());
    }

    @After
    public void deleteUser() {
        String accessToken = userClient.getAccessToken(response);
        userClient.sendDeleteRequestAuthUser(accessToken).then().statusCode(SC_ACCEPTED);
    }
}