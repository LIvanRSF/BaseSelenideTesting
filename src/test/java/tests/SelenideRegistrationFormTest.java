package tests;

import static com.codeborne.selenide.Selenide.$;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

@DisplayName("Тест на изучение Selenide")
public class SelenideRegistrationFormTest extends SelenideBaseClass {

    @DisplayName("Заполнение регистрационной формы")
    @Test
    public void successRegistration() {

        //блок с данными вынесен отдельно, чтобы было по минимуму хардкода
        String firstName = "John";
        String lastName = "Doe";
        String userEmail = "qaqa@yahoo.com";
        String gender = "Male";
        String phoneNumber = "9932223344";
        String monthOfBirth = "August";
        String yearOfBirth = "2001";
        String dayOfBirth = "07";
        String subject = "Arts";
        String hobby = "Sports";
        String pictureName = "test.png";
        String filePath = "src/test/resources/";
        String address = "Lenina 17";
        String state = "Haryana";
        String city = "Karnal";

        //непосредственно работа с элементами сайта
        new RegistrationFormPage().openPage()
                                  .setFirstName(firstName)
                                  .setLastName(lastName)
                                  .setUserEmail(userEmail)
                                  .setGender(gender)
                                  .setPhoneNumber(phoneNumber)
                                  .setDateOfBirth(monthOfBirth, yearOfBirth, dayOfBirth)
                                  .setSubject(subject)
                                  .setHobby(hobby)
                                  .uploadUserFile(filePath, pictureName)
                                  .setAddress(address)
                                  .setStateAndCity(state, city)
                                  .clickSubmitButton();

        // Проверка формы подтверждения регистрации. Данные на форме должны соответстовавать
        // введенным ранее данным
        new RegistrationFormPage().checkResult("Student Name", firstName + " " + lastName)
                                  .checkResult("Student Email", userEmail)
                                  .checkResult("Gender", gender)
                                  .checkResult("Mobile", phoneNumber)
                                  .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                                  .checkResult("Subjects", subject)
                                  .checkResult("Hobbies", hobby)
                                  .checkResult("Picture", pictureName)
                                  .checkResult("Address", address)
                                  .checkResult("State and City", state + " " + city);
    }
}
