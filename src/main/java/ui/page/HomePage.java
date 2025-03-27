package ui.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import data.TestData;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class HomePage extends TestData {

    @FindBy(id = "userName")
    public SelenideElement inputInitials;

    @FindBy(id = "email")
    public SelenideElement inputEmail;

    @FindBy(id = "phoneNumber")
    public SelenideElement inputPhoneNumber;

    @FindBy(id = "password")
    public SelenideElement inputPassword;

    @FindBy(id = "passwordValidation")
    public SelenideElement inputPasswordValidation;

    @FindBy(xpath = "//label[span[contains(text(), 'Принимаю условия обработки персональных данных')]]")
    public SelenideElement checkBox1;

    @FindBy(xpath = "//label[span[contains(text(), 'Даю согласие получать информацию о специальных предложениях')]]")
    public SelenideElement checkBox2;

    @FindBy(id = "submitLogin")
    public SelenideElement submitLoginButton;

    @FindBy(xpath = "//h1[@class ='otp__h1']")
    public SelenideElement popUpVerificationCode;

    @FindBy(xpath = "//input[@id='email']/following::div[text()='Текст ошибки'][1]")
    public SelenideElement emailError;

    @Step("Ввод полного имени: {fullName}")
    public void enterFullName(String fullName) {
        inputInitials.shouldBe(Condition.visible).setValue(fullName);
    }

    @Step("Ввод email: {email}")
    public void enterEmail(String email) {
        inputEmail.shouldBe(Condition.visible).setValue(email);
    }

    @Step("Ввод номера телефона: {phoneNumber}")
    public void enterPhoneNumber(String phoneNumber) {
        inputPhoneNumber.shouldBe(Condition.visible).setValue(phoneNumber);
    }

    @Step("Ввод пароля: {password}")
    public void enterPassword(String password) {
        inputPassword.shouldBe(Condition.visible).setValue(password);
    }

    @Step("Подтверждение пароля: {passwordValidation}")
    public void enterPasswordValidation(String passwordValidation) {
        inputPasswordValidation.shouldBe(Condition.visible).setValue(passwordValidation);
    }

    @Step("Выбор первого чекбокса")
    public void selectTheFirstCheckbox() {
        checkBox1.shouldBe(Condition.visible).click();
    }

    @Step("Выбор второго чекбокса")
    public void selectTheSecondCheckbox() {
        checkBox2.shouldBe(Condition.visible).click();
    }

    @Step("Нажатие на кнопку 'Получить'")
    public void clickOnTheReceiveButton() {
        submitLoginButton.shouldBe(Condition.visible).click();
    }

    @Step("Подтверждение alert (нажатие 'OK')")
    public void clickOnTheOkButton() {
        Selenide.sleep(5000);
        com.codeborne.selenide.Selenide.switchTo().alert().accept();
    }

    @Step("Проверка появления попапа с текстом 'Код проверки'")
    public void checkingTheAppearanceOfaPopupVerificationCode() {
        popUpVerificationCode.shouldBe(Condition.visible, Duration.ofSeconds(12))
                .shouldHave(Condition.text("Код проверки"));
    }

    @Step("Проверка отображения ошибки в поле email")
    public void checkingThatTheErrorTextAppearsInTheEmailField() {
        emailError.shouldHave(Condition.cssValue("display", "none"));
    }

}
