package api;

import data.TestData;
import models.UserRequest;

public class UserFactory {

    private static final TestData testData = new TestData();

    public static UserRequest fillingOutTheFormWithValidData() {
        return UserRequest.builder()
                .userName(testData.INITIALS)
                .login(testData.EMAIL)
                .phoneNumber(testData.PHONE_NUMBER)
                .password(TestData.PASSWORD)
                .passwordValidation(TestData.PASSWORD_VALIDATION)
                .build();
    }

    public static UserRequest fillingOutTheFormWithInvalidEmail() {
        return UserRequest.builder()
                .userName(testData.INITIALS)
                .login(TestData.INVALID_EMAIL)
                .phoneNumber(testData.PHONE_NUMBER)
                .password(TestData.PASSWORD)
                .passwordValidation(TestData.PASSWORD_VALIDATION)
                .build();
    }

}
