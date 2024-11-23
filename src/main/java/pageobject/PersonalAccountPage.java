package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalAccountPage {

    private WebDriver driver;

    //кнопка "Выход"
    private final By exitButton = By.xpath(".//button[text()='Выход']");

    //кнопка "Конструктор"
    private By constructorButton = By.xpath(".//a[@class='AppHeader_header__link__3D_hX' and @href = '/']");


    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Проверка видимости кнопки «Выход»")
    public boolean exitButtonIsEnabled() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(exitButton));
        return driver.findElement(exitButton).isEnabled();
    }

    @Step("Нажатие на кнопку «Конструктор»")
    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    @Step("Нажатие на кнопку «Выход»")
    public void clickExitButton() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(exitButton));
        driver.findElement(exitButton).click();
    }
}