package tests.registration;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.RegistrationFormPage;

public class RegFormBaseClass {

    RegistrationFormPage formPage = new RegistrationFormPage();
    RegFormTestData testData;

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        System.out.println("Конфигурация теста установлена");
    }

    @BeforeEach
    public void beforEach() {
        testData = new RegFormTestData();
        formPage.openPage();
        System.out.println("Тестовые данные сгенерированы. Веб-страница открыта");
    }
}
