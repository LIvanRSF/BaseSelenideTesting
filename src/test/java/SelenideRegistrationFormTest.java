import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;

import java.io.File;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тест на изучение Selenide")
public class SelenideRegistrationFormTest extends SelenideBaseClass {

    @DisplayName("Заполнение регистрационной формы")
    @Test
    public void successRegistration() {
        String firstName = "John";
        String lastName = "Doe";
        String email = "qaqa@yahoo.com";
        String gender = "Male";
        String phoneNumber = "9932223344";
        String subject = "Arts";
        String hobbies = "Sports";
        String picture = "test.png";
        String address = "Lenina 17";
        String state = "Haryana";
        String city = "Karnal";

        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(phoneNumber);
        $("#subjectsInput").setValue(subject).pressEnter();
        $("#hobbiesWrapper").$(byText(hobbies)).click();
        $("#uploadPicture").uploadFile
                               (new File("src/test/resources/" + picture));
        $("#currentAddress").setValue(address);
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        $("#submit").click();

        $(".modal-body").shouldHave(text(firstName + " " + lastName),
            text(email),
            text(gender),
            text(phoneNumber),
            text(gender),
            text(subject),
            text(hobbies),
            text(picture),
            text(gender),
            text(address),
            text(state + " " + city));
    }
}
