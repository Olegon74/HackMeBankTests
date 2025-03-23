package ui;

import java.time.Duration;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class HomePage extends BaseConfiguration {

    public void enterFullName() {
        inputInitials.shouldBe(visible).setValue(INITIALS);
    }
    public void enterEmail() {
        inputEmail.shouldBe(visible).setValue(EMAIL);
    }
    public void enterInvalidEmail() {
        inputEmail.shouldBe(visible).setValue(INVALID_EMAIL);
    }
    public void enterPhoneNumber() {
        inputPhoneNumber.shouldBe(visible).setValue(PHONE_NUMBER);
    }
    public void enterPassword() {
        inputPassword.shouldBe(visible).setValue(PASSWORD);
    }
    public void enterPasswordValidation() {
        inputPasswordValidation.shouldBe(visible).setValue(PASSWORD_VALIDATION);
    }
    public void selectTheFirstCheckbox() {
        checkBox1.shouldBe(visible).click();
    }
    public void selectTheSecondCheckbox() {
        checkBox2.shouldBe(visible).click();
    }
    public void clickOnTheReceiveButton() {
        submitLoginButton.shouldBe(visible).click();
    }
    public void clickOnTheOkButton() {
        sleep(5000);
        switchTo().alert().accept();
    }
    public void checkingTheAppearanceOfaPopupVerificationCode() {
        popUpVerificationCode.shouldBe(visible, Duration.ofSeconds(12)).shouldHave(text("Код проверки"));
    }
    public void checkingThatTheErrorTextAppearsInTheEmailField() {
        emailError.shouldHave(cssValue("display", "none"));
    }

}
