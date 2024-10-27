package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selenide.*;

public class HardFormPageObjects extends TestBase {

    @DisplayName("автотест на сложную форму авторизации используя тестобджект")
    @Test
    void seccessfulRegistrationTest() {

        registrationPage.openPage()
                .setFirstName(data.name)
                .setLastName(data.lastName)
                .setEmail(data.email)
                .setSex(data.gender)
                .setNumber(data.number)
                .selectBirthDay(data.date)
                .setHobbies(data.hobbies)
                .setAdress(data.currentCity)
                .uploadImage(data.imagePath)
                .selectState(data.state)
                .selectCity(data.city)
                .verifyModalResult()
                .verifyResult("Student Name", data.name + " " + data.lastName);

        System.out.println("Secseesful test motherfuskers");

    }


    @DisplayName("Проверка ввода даты рождения")
    @Test
    void openCalendar() {
        String[] date = {"14", "February", "1996"};

        open("/automation-practice-form");
        registrationPage.selectBirthDay(date)
                .setFirstName("Fix");
    }
}
