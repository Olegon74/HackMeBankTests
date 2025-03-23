package api;

import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.testng.Tag;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.UserRequest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static api.Specification.*;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

@Tag("API")
public class ForFillingOutTheApiFormTests {

    @BeforeClass
    public static void setup() {
        Specification.setup();
    }

    @Test
    @AllureId("3")
    @Owner("Олег О.")
    @Description("отправка Post запроса на url https://tl.af-ctf.ru/calluserforsignup, с валидными данными")
    public void fillingOutTheFormWithValidDataApiTest() {
        UserRequest user = UserFactory.fillingOutTheFormWithValidData();
        Response response = given()
                .spec(requestSpec)
                .body(user)
                .when()
                .post("/calluserforsignup");
        response.then()
                .spec(responseSpec);

        JsonPath jsonPath = response.jsonPath();
        assertEquals(true, jsonPath.getBoolean("type"));
        assertEquals("Сейчас на ваш телефон поступит звонок или сообщение, последние 4 цифры являются кодом",
                jsonPath.getString("text"));

    }

    @Test
    @AllureId("4")
    @Owner("Олег О.")
    @Description("Отправка Post запроса на url https://tl.af-ctf.ru/calluserforsignup, с не валидным email")
    public void fillingOutTheFormWithAnInvalidEmailApiTest() {

        UserRequest user = UserFactory.fillingOutTheFormWithInvalidEmail();
        Response response = given()
                .spec(requestSpec)
                .body(user)
                .when()
                .post("/calluserforsignup");
        response.then()
                .spec(responseSpec);

        JsonPath jsonPath = response.jsonPath();
        assertEquals(false, jsonPath.getBoolean("type"), "Проверка типа ошибки");
        String message = jsonPath.get("message");
        assertEquals("\"login\" must be a valid email", message, "Проверка общего сообщения об ошибке");
        String nestedMessage = jsonPath.get("login.message");
        assertEquals("\"login\" must be a valid email", nestedMessage, "Проверка сообщения внутри login");

    }

}
