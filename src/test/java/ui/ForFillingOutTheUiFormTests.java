package ui;

import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;



@Tag("UI")
public class ForFillingOutTheUiFormTests extends BaseConfiguration {


    @Test
    @AllureId("1")
    @Owner("Олег О.")
    @Description("Проверка что при валидном заполнении формы и клике по кнопке Получить, появляется попап с текстом, Код проверки")
    public void fillingOutTheFormWithValidDataUiTest() {
        step("Ввод данных в поле ФИО", () -> {
            inputInitials.shouldBe(visible).setValue(INITIALS);
        });
        step("Ввод данных в поле email", () -> {
            inputEmail.shouldBe(visible).setValue(EMAIL);
        });
        step("Ввод данных в поле телефон", () -> {
            inputPhoneNumber.shouldBe(visible).setValue(PHONE_NUMBER);
        });
        step("Ввод данных в поле пароль", () -> {
            inputPassword.shouldBe(visible).setValue(PASSWORD);
        });
        step("Ввод данных в поле повторите пароль", () -> {
            inputPasswordValidation.shouldBe(visible).setValue(PASSWORD_VALIDATION);
        });
        step("Выбираем первый чек-бокс", () -> {
            checkBox1.shouldBe(visible).click();
        });
        step("Выбираем второй чек-бокс", () -> {
            checkBox2.shouldBe(visible).click();
        });
        step("Клик по кнопке Получить", () -> {
            submitLoginButton.shouldBe(visible).click();
        });
        step("Клик по кнопке OK, в диалоговом окне", () -> {
            sleep(5000);
            switchTo().alert().accept();
        });
        step("Проверка что появился попап с текстом, Код проверки", () -> {
            popUpVerificationCode.shouldBe(visible, Duration.ofSeconds(12)).shouldHave(text("Код проверки"));
        });

    }

    @Test
    @AllureId("2")
    @Owner("Олег О.")
    @Description("Проверка, что при не валидном заполнении поля email, появляется сообщение об ошибке")
    public void fillingOutTheFormWithAnInvalidEmailUiTest() {
        step("Ввод данных в поле ФИО", () -> {
            inputInitials.shouldBe(visible).setValue(INITIALS);
        });
        step("Ввод данных в поле email", () -> {
            inputEmail.shouldBe(visible).setValue(INVALID_EMAIL);
        });
        step("Ввод данных в поле телефон", () -> {
            inputPhoneNumber.shouldBe(visible).setValue(PHONE_NUMBER);
        });
        step("Ввод данных в поле пароль", () -> {
            inputPassword.shouldBe(visible).setValue(PASSWORD);
        });
        step("Ввод данных в поле повторите пароль", () -> {
            inputPasswordValidation.shouldBe(visible).setValue(PASSWORD_VALIDATION);
        });
        step("Выбираем первый чек-бокс", () -> {
            checkBox1.shouldBe(visible).click();
        });
        step("Выбираем второй чек-бокс", () -> {
            checkBox2.shouldBe(visible).click();
        });
        step("Клик по кнопке Получить", () -> {
            submitLoginButton.shouldBe(visible).click();
        });
        step("Проверка что после клика, появился текст ошибки", () -> {
            emailError.shouldHave(cssValue("display", "none"));
        });

    }

}


