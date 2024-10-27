package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FormTestsAuto extends TestData{

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @BeforeEach
    void beforeEach(){

    }

    @DisplayName("автотест на форму авторизации сложную")
    @Test
    void hardTest() {
        Faker faker = new Faker(new Locale("ru"));

        String userName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userEmail = faker.internet().emailAddress();
        String streetAdress = faker.address().streetAddress();

        open("/automation-practice-form");

        $(".text-center")
                .shouldHave(text("Practice Form"));
        $("#firstName").setValue(userName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);

        $("#genterWrapper").$(byText("Male")).click();

        $("#userNumber").setValue("4545444444");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("February");
        $(".react-datepicker__year-select").selectOption("1996");
        $(".react-datepicker__day.react-datepicker__day--014").click();

        $("#hobbiesWrapper").$(byText("Sports")).click();

        $("#uploadPicture").uploadFromClasspath("img/1.png");

        $("#currentAddress").setValue(streetAdress);

        $("#state").click();
        $("#stateCity-wrapper")
                .$(byText("NCR")).click();

        $("#city").click();
        $("#stateCity-wrapper")
                .$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-content").should(appear);
        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Anatoliy"));

        System.out.println("Secseesful test");

    }
}
