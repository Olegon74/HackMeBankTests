package data;

public class TestData {

    DataGenerator dataGenerator = new DataGenerator();

    public String INITIALS = dataGenerator.generateNameWithMiddle();
    public String EMAIL = dataGenerator.generateEmail();
    public static final String EMAIL1 = "test@mail.ru";
    public static final String INVALID_EMAIL = "@gmail.com";
    public static final String PHONE_NUMBER = "89000100119";
    public static final String PASSWORD = "12345678";
    public static final String PASSWORD_VALIDATION = "12345678";
    //public String PHONE_NUMBER = dataGenerator.generatePhoneNumber();
}
