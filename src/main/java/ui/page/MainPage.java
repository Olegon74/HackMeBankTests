package ui.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import data.TestData;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends TestData {

    public void enterFullName() {
        $(byId("userName")).shouldBe(Condition.visible).setValue(INITIALS);
    }
    public void enterEmail() {
        $(byId("email")).shouldBe(Condition.visible).setValue(EMAIL);
    }
    public void enterInvalidEmail() {
        $(byId("email")).shouldBe(Condition.visible).setValue(TestData.INVALID_EMAIL);
    }
    public void enterPhoneNumber() {
        $(byId("phoneNumber")).shouldBe(Condition.visible).setValue(TestData.PHONE_NUMBER);
    }
    public void enterPassword() {
        $(byId("password")).shouldBe(Condition.visible).setValue(TestData.PASSWORD);
    }
    public void enterPasswordValidation() {
        $(byId("passwordValidation")).shouldBe(Condition.visible).setValue(TestData.PASSWORD_VALIDATION);
    }
    public void selectTheFirstCheckbox() {
        $(byXpath("//label[span[contains(text(), 'Принимаю условия обработки персональных данных')]]")).shouldBe(Condition.visible).click();
    }
    public void selectTheSecondCheckbox() {
        $(byXpath("//label[span[contains(text(), 'Даю согласие получать информацию о специальных предложениях')]]")).shouldBe(Condition.visible).click();
    }
    public void clickOnTheReceiveButton() {
        $(byId("submitLogin")).shouldBe(Condition.visible).click();
    }
    public void clickOnTheOkButton() {
        Selenide.sleep(5000);
        Selenide.switchTo().alert().accept();
    }
    public void checkingTheAppearanceOfaPopupVerificationCode() {
        $(byXpath("//h1[@class ='otp__h1']")).shouldBe(Condition.visible, Duration.ofSeconds(12)).shouldHave(Condition.text("Код проверки"));
    }
    public void checkingThatTheErrorTextAppearsInTheEmailField() {
        $(byXpath("//input[@id='email']/following::div[text()='Текст ошибки'][1]")).shouldHave(Condition.cssValue("display", "none"));

    }
}
