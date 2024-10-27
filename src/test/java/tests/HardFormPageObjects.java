package tests;


import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.*;

public class HardFormPageObjects extends TestBase {

    @Test
    void seccessfulRegistrationTest() {

        Faker faker = new Faker(new Locale("ru"));

        String name = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String gender = "Male";
        String number = "4545444444";
        String hobbies = "Sports";
        String currentCity = faker.address().fullAddress();
        String imagePath = "img/1.png";
        String state = "NCR";
        String city = "Delhi";
        String[] date = {"14", "February", "1996"};


        registrationPage.openPage()
                .setFirstName(name)
                .setLastName(lastName)
                .setEmail(email)
                .setSex(gender)
                .setNumber(number)
                .selectBirthDay(date)
                .setHobbies(hobbies)
                .setAdress(currentCity)
                .uploadImage(imagePath)
                .selectState(state)
                .selectCity(city)
                .verifyModalResult()
                .verifyResult("Student Name", name + " " + lastName);

        System.out.println("Secseesful test motherfuskers");

    }

    @Test
    void openCalendar() {
        String[] date = {"14", "February", "1996"};

        open("/automation-practice-form");
        registrationPage.selectBirthDay(date)
                .setFirstName("Fix");
    }
}
