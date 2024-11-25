package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    private WebDriver driver;

    //локатор поля "Имя"
    private By nameField = By.xpath(".//label[text()='Имя']/following-sibling::input");

    //локатор поля "Email"
    private By emailField = By.xpath(".//label[text()='Email']/following-sibling::input");

    //локатор поля "Пароль"
    private By passwordField = By.xpath(".//label[text()='Пароль']/following-sibling::input");

    //локатор кнопки "Зарегистрироваться"
    private By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");

    //локатор кнопки "Войти"
    private By loginButton = By.className("Auth_link__1fOlj");

    //локатор сообщения об ошибке "Некорректный пароль"
    private By invalidPasswordError = By.xpath(".//p[text()='Некорректный пароль']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("//Нажатие на кнопку «Войти»")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Появление сообщения об ошибке «Некорректный пароль»")
    public boolean invalidPasswordMessageIsDisplayed() {
        return driver.findElement(invalidPasswordError).isDisplayed();
    }

    //Ввод значения в поле «Имя»
    void enterName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    //Ввод значения в поле «Email»
    void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    //Ввод значения в поле «Пароль»
    void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Ввод данных пользователя")
    public void enterUserCreds(String name, String email, String password) {
        enterName(name);
        enterEmail(email);
        enterPassword(password);
    }

    @Step("Нажатие на кнопку «Зарегистрироваться»")
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }
}