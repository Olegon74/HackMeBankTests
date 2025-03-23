package api;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.with;

public class Specification {

    public static RequestSpecification requestSpec;
    public static ResponseSpecification responseSpec;

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://tl.af-ctf.ru";

        requestSpec = with()
                .baseUri(RestAssured.baseURI)
                .log().all()
                .contentType(ContentType.JSON);

        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .log(io.restassured.filter.log.LogDetail.ALL)
                .build();

    }

}
