package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;

    //локатор поля "Личный кабинет"
    private By personalAccountButton = By.xpath(".//a[@class = 'AppHeader_header__link__3D_hX' and @href='/account']");

    //локатор кнопки "Войти в аккаунт"
    private By loginToAccountButton = By.xpath(".//button[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']");

    //Локатор кнопки "Оформить заказ"
    private final By createOrderButton = By.xpath(".//button[text()='Оформить заказ']");

    //локатор кнопки "Булки"
    private By bunsButton = By.xpath(".//span[contains(text(),'Булки')]");

    //локатор кнопки "Соусы"
    private By saucesButton = By.xpath(".//span[contains(text(),'Соусы')]");

    //локатор кнопки "Начинки"
    private By fillingsButton = By.xpath(".//span[contains(text(),'Начинки')]");

    //локатор раздела с ингредиентами
    private By ingredientSection = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажатие на кнопку «Личный кабинет»")
    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }

    @Step("Нажатие на кнопку Войти в аккаунт")
    public void clickLoginToAccountButton() {
        driver.findElement(loginToAccountButton).click();
    }

    @Step("Ожидание кнопки «Оформить заказ»")
    public boolean createOrderButtonIsEnabled() {
        return driver.findElement(createOrderButton).isEnabled();
    }

    @Step("Нажатие на кнопку «Булки»")
    public void clickBunsButton() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(bunsButton));
        driver.findElement(bunsButton).click();
    }

    @Step("Нажатие на кнопку «Соусы»")
    public void clickSaucesButton() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(saucesButton));
        driver.findElement(saucesButton).click();
    }

    @Step("Нажатие на кнопку «Начинки»")
    public void clickFillingsButton() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(fillingsButton));
        driver.findElement(fillingsButton).click();
    }

    @Step("Ожидание загрузки страницы")
    public void waitPageLoad() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(createOrderButton));
    }

    @Step("Переход к разделам")
    public String getSectionText() {
        WebElement ingredients = driver.findElement(ingredientSection);
        return ingredients.getText();
    }
}