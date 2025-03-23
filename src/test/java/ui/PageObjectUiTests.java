package ui;

import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Test;

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

}
