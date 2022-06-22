package tests.registration;

import com.github.javafaker.Faker;

public class RegFormTestData {

    Faker faker = new Faker();

    //блок с данными вынесен отдельно, чтобы было по минимуму хардкода
    String firstName = faker.address().firstName();
    String lastName = faker.address().lastName();
    String userEmail = faker.internet().emailAddress();
    String gender = "Male";
    String phoneNumber = faker.number().digits(10);
    String monthOfBirth = "August";
    String yearOfBirth = String.valueOf(faker.number().numberBetween(1925,2022));
    String dayOfBirth = "07";
    String subject = "Arts";
    String hobby = "Sports";
    String pictureName = "test.png";
    String filePath = "src/test/resources/";
    String address = faker.address().fullAddress();
    String state = "Haryana";
    String city = "Karnal";
}
