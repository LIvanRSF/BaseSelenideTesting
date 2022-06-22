package tests.registration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

@DisplayName("Тест на изучение Selenide")
public class RegistrationFormTests extends RegFormBaseClass {

    @DisplayName("Успешное заполнение регистрационной формы")
    @Test
    public void successRegistration() {

        //Непосредственно работа с элементами сайта - заполнение формы регистрации, нажатие кнопки "Submit"
        new RegistrationFormPage().setFirstName(testData.firstName)
                                  .setLastName(testData.lastName)
                                  .setUserEmail(testData.userEmail)
                                  .setGender(testData.gender)
                                  .setPhoneNumber(testData.phoneNumber)
                                  .setDateOfBirth(testData.monthOfBirth, testData.yearOfBirth, testData.dayOfBirth)
                                  .setSubject(testData.subject)
                                  .setHobby(testData.hobby)
                                  .uploadUserFile(testData.filePath, testData.pictureName)
                                  .setAddress(testData.address)
                                  .setStateAndCity(testData.state, testData.city)
                                  .clickSubmitButton();

        // Проверка формы подтверждения регистрации. Данные на форме должны соответстовавать
        // введенным ранее данными
        new RegistrationFormPage().checkResult("Student Name", testData.firstName + " " + testData.lastName)
                                  .checkResult("Student Email", testData.userEmail)
                                  .checkResult("Gender", testData.gender)
                                  .checkResult("Mobile", testData.phoneNumber)
                                  .checkResult("Date of Birth",
                                      testData.dayOfBirth + " " + testData.monthOfBirth + "," + testData.yearOfBirth)
                                  .checkResult("Subjects", testData.subject)
                                  .checkResult("Hobbies", testData.hobby)
                                  .checkResult("Picture", testData.pictureName)
                                  .checkResult("Address", testData.address)
                                  .checkResult("State and City", testData.state + " " + testData.city);
    }
}
