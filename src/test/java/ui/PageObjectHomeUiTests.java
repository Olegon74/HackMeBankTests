package ui;

import com.codeborne.selenide.Selenide;
import data.TestData;
import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;
import ui.page.HomePage;

@Tag("UI")
public class PageObjectHomeUiTests extends BaseConfiguration {

    HomePage homePage = Selenide.page(HomePage.class);

   @Test
    @AllureId("5")
    @Owner("Олег О.")
    @Description("Проверка что при валидном заполнении формы и клике по кнопке Получить, появляется попап с текстом, Код проверки")
    public void validFormFillingTest() {
        homePage.enterFullName(TestData.INITIALS);
        homePage.enterEmail(TestData.EMAIL);
        homePage.enterPhoneNumber(TestData.PHONE_NUMBER);
        homePage.enterPassword(TestData.PASSWORD);
        homePage.enterPasswordValidation(TestData.PASSWORD_VALIDATION);
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
        homePage.enterFullName(TestData.INITIALS);
        homePage.enterEmail(TestData.INVALID_EMAIL);
        homePage.enterPhoneNumber(TestData.PHONE_NUMBER);
        homePage.enterPassword(TestData.PASSWORD);
        homePage.enterPasswordValidation(TestData.PASSWORD_VALIDATION);
        homePage.selectTheFirstCheckbox();
        homePage.selectTheSecondCheckbox();
        homePage.clickOnTheReceiveButton();
        homePage.checkingThatTheErrorTextAppearsInTheEmailField();
    }

}
