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

    @DisplayName("Успешное заполнение регистрационной формы")
    @Test
    public void successRegistration() {

        //блок с данными вынесен отдельно, чтобы было по минимуму хардкода
        String firstName = "John";
        String lastName = "Doe";
        String email = "qaqa@yahoo.com";
        String gender = "Male";
        String phoneNumber = "9932223344";
        String monthOfBirth = "August";
        String yearOfBirth = "2001";
        String dayOfBirth = "07";
        String subject = "Arts";
        String hobbies = "Sports";
        String pictureName = "test.png";
        String filePath = "src/test/resources/";
        String address = "Lenina 17";
        String state = "Haryana";
        String city = "Karnal";

        //открываем сайт и убираем лишнее (рекламные баннеры)
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        //непосредственно работа с элементами сайта
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(phoneNumber);

        //блок с календарем
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(".react-datepicker__day--0" + dayOfBirth).click();

        $("#subjectsInput").setValue(subject).pressEnter();
        $("#hobbiesWrapper").$(byText(hobbies)).click();
        $("#uploadPicture").uploadFile
                               (new File(filePath + pictureName));
        $("#currentAddress").setValue(address);
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        $("#submit").click();

        // Проверка формы подтверждения регистрации. Данные на форме должны соответстовавать
        // введенным ранее данным
        $(".modal-body").shouldHave(text(firstName + " " + lastName),
            text(email),
            text(gender),
            text(phoneNumber),
            text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth),
            text(subject),
            text(hobbies),
            text(pictureName),
            text(address),
            text(state + " " + city));
    }
}
