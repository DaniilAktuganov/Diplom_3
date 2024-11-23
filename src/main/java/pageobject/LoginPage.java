package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;

    //локатор кнопки "Войти"
    private By loginButton = By.xpath(".//button[text()='Войти']");

    //локатор кнопки "Зарегистрироваться"
    private By registerButton = By.xpath(".//a[text()='Зарегистрироваться']");

    //локатор поля "Email"
    private By emailField = By.xpath(" .//input[@class='text input__textfield text_type_main-default' and @type='text']");

    //локатор поля "Пароль"
    private By passwordField = By.xpath(".//input[@class = 'text input__textfield text_type_main-default' and@type = 'password']");

    //локатор кнопки "Восстановить пароль"
    private By recoverPasswordButton = By.xpath(".//a[text()='Восстановить пароль']");

    //локатор страницы "Вход"
    private By loginScreen = By.xpath("//h2[text()='Вход']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажатие на кнопку «Зарегистрироваться»")
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    @Step("Ожидание появления кнопки «Войти»")
    public boolean loginButtonIsEnabled() {
        return driver.findElement(loginButton).isEnabled();
    }

    @Step("Нажатие на кнопку «Восстановить пароль»")
    public void clickRecoverPasswordButton() {
        driver.findElement(recoverPasswordButton).click();
    }

    @Step("Ожидание загрузки страницы")
    public void waitPageLoad() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(loginScreen));
    }

    //Ввод значения в поле «Email»
    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    //Ввод значения в поле «Password»
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    //Нажатие на кнопку «Войти»
    public void clickLoginButton() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();
    }

    @Step("Вход по кнопке «Войти в аккаунт» на главной")
    public void login(String email, String password){
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }
}