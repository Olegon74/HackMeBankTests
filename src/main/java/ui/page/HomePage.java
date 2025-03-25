package ui.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import data.TestData;
import ui.BasePageElement;

import java.time.Duration;

public class HomePage extends BasePageElement {

    public void enterFullName() {
        inputInitials.shouldBe(Condition.visible).setValue(INITIALS);
    }
    public void enterEmail() {
        inputEmail.shouldBe(Condition.visible).setValue(EMAIL);
    }
    public void enterInvalidEmail() {
        inputEmail.shouldBe(Condition.visible).setValue(TestData.INVALID_EMAIL);
    }
    public void enterPhoneNumber() {
        inputPhoneNumber.shouldBe(Condition.visible).setValue(TestData.PHONE_NUMBER);
    }
    public void enterPassword() {
        inputPassword.shouldBe(Condition.visible).setValue(TestData.PASSWORD);
    }
    public void enterPasswordValidation() {
        inputPasswordValidation.shouldBe(Condition.visible).setValue(TestData.PASSWORD_VALIDATION);
    }
    public void selectTheFirstCheckbox() {
        checkBox1.shouldBe(Condition.visible).click();
    }
    public void selectTheSecondCheckbox() {
        checkBox2.shouldBe(Condition.visible).click();
    }
    public void clickOnTheReceiveButton() {
        submitLoginButton.shouldBe(Condition.visible).click();
    }
    public void clickOnTheOkButton() {
        Selenide.sleep(5000);
        Selenide.switchTo().alert().accept();
    }
    public void checkingTheAppearanceOfaPopupVerificationCode() {
        popUpVerificationCode.shouldBe(Condition.visible, Duration.ofSeconds(12)).shouldHave(Condition.text("Код проверки"));
    }
    public void checkingThatTheErrorTextAppearsInTheEmailField() {
        emailError.shouldHave(Condition.cssValue("display", "none"));
    }

}
