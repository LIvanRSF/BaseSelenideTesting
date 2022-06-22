package pages;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

import com.codeborne.selenide.Selenide;
import java.io.File;
import pages.components.CalendarPageComponent;
import pages.components.StateAndCityPageComponent;
import pages.components.ResultsTablePageComponent;

public class RegistrationFormPage {

    public CalendarPageComponent calendarPageComponent = new CalendarPageComponent();
    public ResultsTablePageComponent resultsTablePageComponent = new ResultsTablePageComponent();
    public StateAndCityPageComponent stateAndCityPageComponent = new StateAndCityPageComponent();

    public RegistrationFormPage openPage() {
        //открываем сайт и убираем лишнее (рекламные баннеры)
        Selenide.open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationFormPage setFirstName(String firstName) {
        $("#firstName").setValue(firstName);

        return this;
    }

    public RegistrationFormPage setLastName(String lastName) {
        $("#lastName").setValue(lastName);

        return this;
    }

    public RegistrationFormPage setUserEmail(String userEmail) {
        $("#userEmail").setValue(userEmail);

        return this;
    }

    public RegistrationFormPage setGender(String gender) {
        $("#genterWrapper").$(byText(gender)).click();

        return this;
    }

    public RegistrationFormPage setPhoneNumber(String phoneNumber) {
        $("#userNumber").setValue(phoneNumber);

        return this;
    }

    public RegistrationFormPage setSubject(String subject) {
        $("#subjectsInput").setValue(subject).pressEnter();

        return this;
    }

    public RegistrationFormPage setHobby(String hobby) {
        $("#hobbiesWrapper").$(byText(hobby)).click();

        return this;
    }

    public RegistrationFormPage uploadUserFile(String filePath, String pictureName) {
        $("#uploadPicture").uploadFile
                               (new File(filePath + pictureName));

        return this;
    }

    public RegistrationFormPage setDateOfBirth(String month, String year, String day) {
        $("#dateOfBirthInput").click();
        calendarPageComponent.setDate(month, year, day);

        return this;
    }

    public RegistrationFormPage setAddress(String address) {
        $("#currentAddress").setValue(address);

        return this;
    }

    public RegistrationFormPage setStateAndCity(String state, String city) {
        $("#state").scrollTo().click();
        stateAndCityPageComponent.setLocation(state, city);

        return this;
    }

    public RegistrationFormPage clickSubmitButton() {
        $("#submit").click();

        return this;
    }

    public RegistrationFormPage checkResult(String key, String value) {
        resultsTablePageComponent.checkResult(key, value);

        return this;
    }
}
