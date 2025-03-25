package ui;

import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;
import ui.page.HomePage;
import ui.page.MainPage;

@Tag("UI")
public class PageObjectUiTests extends BaseConfiguration {

    HomePage homePage = new HomePage();

   @Test
    @AllureId("5")
    @Owner("Олег О.")
    @Description("Проверка что при валидном заполнении формы и клике по кнопке Получить, появляется попап с текстом, Код проверки")
    public void validFormFillingTest() {
        homePage.enterFullName();
        homePage.enterEmail();
        homePage.enterPhoneNumber();
        homePage.enterPassword();
        homePage.enterPasswordValidation();
        homePage.selectTheFirstCheckbox();
        homePage.selectTheSecondCheckbox();
        homePage.clickOnTheReceiveButton();
        homePage.clickOnTheOkButton();
        homePage.checkingTheAppearanceOfaPopupVerificationCode();

    }

    @Test
    @AllureId("6")
    @Owner("Олег О.")
    @Description("Проверка, что при не валидном заполнении поля email, появляется сообщение об ошибке")
    public void fillingOutTheFormWithAnInvalidEmailTest() {
        homePage.enterFullName();
        homePage.enterInvalidEmail();
        homePage.enterPhoneNumber();
        homePage.enterPassword();
        homePage.enterPasswordValidation();
        homePage.selectTheFirstCheckbox();
        homePage.selectTheSecondCheckbox();
        homePage.clickOnTheReceiveButton();
        homePage.checkingThatTheErrorTextAppearsInTheEmailField();
    }

    MainPage mainPage = new MainPage();

    @Test
    @AllureId("7")
    @Owner("Олег О.")
    @Description("Проверка что при валидном заполнении формы и клике по кнопке Получить, появляется попап с текстом, Код проверки")
    public void validFormFillingTest2() {
        mainPage.enterFullName();
        mainPage.enterEmail();
        mainPage.enterPhoneNumber();
        mainPage.enterPassword();
        mainPage.enterPasswordValidation();
        mainPage.selectTheFirstCheckbox();
        mainPage.selectTheSecondCheckbox();
        mainPage.clickOnTheReceiveButton();
        mainPage.clickOnTheOkButton();
        mainPage.checkingTheAppearanceOfaPopupVerificationCode();

    }

    @Test
    @AllureId("8")
    @Owner("Олег О.")
    @Description("Проверка, что при не валидном заполнении поля email, появляется сообщение об ошибке")
    public void fillingOutTheFormWithAnInvalidEmailTest2() {
        mainPage.enterFullName();
        mainPage.enterInvalidEmail();
        mainPage.enterPhoneNumber();
        mainPage.enterPassword();
        mainPage.enterPasswordValidation();
        mainPage.selectTheFirstCheckbox();
        mainPage.selectTheSecondCheckbox();
        mainPage.clickOnTheReceiveButton();
        mainPage.checkingThatTheErrorTextAppearsInTheEmailField();

    }

}
