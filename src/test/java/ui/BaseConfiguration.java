package ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import data.TestData;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Map;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class BaseConfiguration extends TestData {

    SelenideElement inputInitials = $(byId("userName"));
    SelenideElement inputEmail = $(byId("email"));
    SelenideElement inputPhoneNumber = $(byId("phoneNumber"));
    SelenideElement inputPassword = $(byId("password"));
    SelenideElement inputPasswordValidation = $(byId("passwordValidation"));
    SelenideElement checkBox1 = $(byXpath("//label[span[contains(text(), 'Принимаю условия обработки персональных данных')]]"));
    SelenideElement checkBox2 = $(byXpath("//label[span[contains(text(), 'Даю согласие получать информацию о специальных предложениях')]]"));
    SelenideElement submitLoginButton = $(byId("submitLogin"));
    SelenideElement popUpVerificationCode = $(byXpath("//h1[@class ='otp__h1']"));
    SelenideElement emailError = $(byXpath("//input[@id='email']/following::div[text()='Текст ошибки'][1]"));


    @BeforeMethod
    void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.baseUrl = "https://tl.af-ctf.ru/#inputForAuth";
        Configuration.browser = "chrome";
        Configuration.timeout = 8000;
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        open(baseUrl);

    }
    @AfterMethod
    void tearDown() {
        closeWebDriver();
    }

}
