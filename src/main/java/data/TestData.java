package data;

public class TestData {

    static DataGenerator dataGenerator = new DataGenerator();

    public static final String INITIALS = dataGenerator.generateNameWithMiddle();
    public static final String INITIALS1 = "Тестов Тест Тестович";
    public static final String EMAIL = dataGenerator.generateEmail();
    public static final String INVALID_EMAIL = "@gmail.com";
    public static final String PHONE_NUMBER = "89000100119";
    public static final String PASSWORD = "12345678";
    public static final String PASSWORD_VALIDATION = "12345678";
    //public String PHONE_NUMBER = dataGenerator.generatePhoneNumber();
}
