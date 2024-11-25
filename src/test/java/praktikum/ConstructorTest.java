package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class ConstructorTest extends BaseTest {

    @Test
    @DisplayName("Переход к разделу «Булки»")
    @Description("Проверка, что можно перейти к разделу «Булки» на главной странице")
    public void goToBunsTest() {
        objHomePage.clickSaucesButton();
        objHomePage.clickBunsButton();
        Assert.assertEquals("Булки", objHomePage.getSectionText());
    }

    @Test
    @DisplayName("Переход к разделу «Соусы»")
    @Description("Проверка, что можно перейти к разделу «Соусы» на главной странице")
    public void goToSaucesTest() {
        objHomePage.clickSaucesButton();
        Assert.assertEquals("Соусы", objHomePage.getSectionText());
    }

    @Test
    @DisplayName("Переход к разделу «Начинки»")
    @Description("Проверка, что можно перейти к разделу «Начинки» на главной странице")
    public void goToFillingsTest() {
        objHomePage.clickFillingsButton();
        Assert.assertEquals("Начинки", objHomePage.getSectionText());
    }
}