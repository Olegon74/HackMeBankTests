package data;

import net.datafaker.Faker;

public class DataGenerator {

    Faker faker = new Faker(new java.util.Locale("ru"));

//Генерация ФИО
    public String generateNameWithMiddle() {
        String lastName, firstName, patronymic;
        String fullName;

        do {
            lastName = cleanString(faker.name().lastName());
            firstName = cleanString(faker.name().firstName());
            patronymic = cleanString(faker.name().nameWithMiddle().split(" ")[1]);
            fullName = lastName + " " + firstName + " " + patronymic;
        } while (!isValidName(fullName));

        return fullName;
    }

    // Метод для очистки строки от не-русских символов
    private String cleanString(String input) {
        return input.replaceAll("[^А-Яа-яЁё]", "");
    }

    // Метод для проверки длины и наличия всех частей
    private boolean isValidName(String name) {
        return name.length() <= 30 && name.split(" ").length == 3;
    }

    //генерация Номера телефона
    public String generatePhoneNumber() {
        String phoneNumber;

        do {
            phoneNumber = generateValidPhoneNumber();
        } while (!isValidPhoneNumber(phoneNumber));

        return phoneNumber;
    }

    // Генерация номера телефона (начинается с 8 или 7, 11 цифр)
    public String generateValidPhoneNumber() {
        // Генерация номера телефона, начинающегося с 8 или 7
        int prefix = faker.random().nextInt(2) == 0 ? 8 : 7;
        StringBuilder phoneNumber = new StringBuilder(String.valueOf(prefix));

        for (int i = 0; i < 10; i++) {
            phoneNumber.append(faker.random().nextInt(10));  // Добавляем случайные цифры
        }

        return phoneNumber.toString();
    }

    public boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("^7\\d{10}$") || phoneNumber.matches("^8\\d{10}$");
    }

    //генерация Email
    Faker faker1 = new Faker();

    public String generateEmail() {
        return faker1.internet().emailAddress();
    }


}
