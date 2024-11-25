package praktikum;

import api.User;
import api.UserClient;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Test;

import static org.apache.http.HttpStatus.SC_ACCEPTED;
import static org.junit.Assert.assertTrue;

public class RegistrationTest extends BaseTest {

    private final String name = RandomStringUtils.randomAlphabetic(5);
    private final String email = RandomStringUtils.randomAlphabetic(5) + "@yandex.ru";
    private final String password = RandomStringUtils.randomAlphabetic(6);

    @Test
    @DisplayName("Успешное создание пользователя")
    @Description("Проверка, что пользователя можно создать с корректными данными")
    public void registrationTest() {
        objHomePage.clickPersonalAccountButton();
        objLoginPage.clickRegisterButton();
        objRegistrationPage.enterUserCreds(name, email, password);
        objRegistrationPage.clickRegisterButton();
        objLoginPage.waitPageLoad();
        assertTrue(objLoginPage.loginButtonIsEnabled());
    }

    @After
    public void deleteUser() {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);
        UserClient userClient = new UserClient();
        Response response = userClient.sendPostRequestAuthLogin(user);
        String accessToken = userClient.getAccessToken(response);
        userClient.sendDeleteRequestAuthUser(accessToken).then().statusCode(SC_ACCEPTED);
    }
}