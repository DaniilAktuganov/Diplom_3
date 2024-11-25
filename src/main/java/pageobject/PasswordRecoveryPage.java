package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPage {

    private WebDriver driver;

    //локатор кнопки "Войти"
    private By loginButton = By.xpath(".//a[@class='Auth_link__1fOlj']");

    public PasswordRecoveryPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажатие на кнопку «Войти»")
    public void clickRegisterButton() {
        driver.findElement(loginButton).click();
    }
}