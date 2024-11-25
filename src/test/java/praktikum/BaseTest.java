package praktikum;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import pageobject.*;

import static driver.WebDriverCreator.createWebDriver;

public class BaseTest {

    protected WebDriver driver;
    protected HomePage objHomePage;
    protected LoginPage objLoginPage;
    protected RegistrationPage objRegistrationPage;
    protected PasswordRecoveryPage objPasswordRecoveryPage;
    protected PersonalAccountPage objPersonalAccountPage;

    @Before
    public void setUp() {
        driver = createWebDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        objHomePage = new HomePage(driver);
        objLoginPage = new LoginPage(driver);
        objRegistrationPage = new RegistrationPage(driver);
        objPasswordRecoveryPage = new PasswordRecoveryPage(driver);
        objPersonalAccountPage = new PersonalAccountPage(driver);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}