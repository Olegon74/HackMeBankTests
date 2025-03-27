package ui;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import data.TestData;

public class BasePageElement extends TestData {

    public SelenideElement inputInitials = Selenide.$(Selectors.byId("userName"));
    public SelenideElement inputEmail = Selenide.$(Selectors.byId("email"));
    public SelenideElement inputPhoneNumber = Selenide.$(Selectors.byId("phoneNumber"));
    public SelenideElement inputPassword = Selenide.$(Selectors.byId("password"));
    public SelenideElement inputPasswordValidation = Selenide.$(Selectors.byId("passwordValidation"));
    public SelenideElement checkBox1 = Selenide.$(Selectors.byXpath("//label[span[contains(text(), 'Принимаю условия обработки персональных данных')]]"));
    public SelenideElement checkBox2 = Selenide.$(Selectors.byXpath("//label[span[contains(text(), 'Даю согласие получать информацию о специальных предложениях')]]"));
    public SelenideElement submitLoginButton = Selenide.$(Selectors.byId("submitLogin"));
    public SelenideElement popUpVerificationCode = Selenide.$(Selectors.byXpath("//h1[@class ='otp__h1']"));
    public SelenideElement emailError = Selenide.$(Selectors.byXpath("//input[@id='email']/following::div[text()='Текст ошибки'][1]"));


}
