package ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ui.page.HomePage;

import java.util.Map;

import static com.codeborne.selenide.Configuration.baseUrl;

public class BaseConfiguration extends HomePage {

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
        Selenide.open(baseUrl);

    }

    @AfterMethod
    void tearDown() {
        Selenide.closeWebDriver();
    }

}
