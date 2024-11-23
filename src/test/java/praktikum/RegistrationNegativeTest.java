package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RegistrationNegativeTest extends BaseTest {

    private final String name = RandomStringUtils.randomAlphabetic(5);
    private final String email = RandomStringUtils.randomAlphabetic(5) + "@yandex.ru";
    private final String invalidPassword = RandomStringUtils.randomAlphabetic(5);

    @Test
    @DisplayName("Проверка создания пользователя с помощью некорректного пароля")
    @Description("При вводе пароля меньше шести символов возникает ошибка")
    public void registrationWithInvalidPasswordTest() {
        objHomePage.clickPersonalAccountButton();
        objLoginPage.clickRegisterButton();
        objRegistrationPage.enterUserCreds(name, email, invalidPassword);
        objRegistrationPage.clickRegisterButton();
        assertTrue(objRegistrationPage.invalidPasswordMessageIsDisplayed());
    }
}