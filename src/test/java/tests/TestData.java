package tests;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {
    Faker faker = new Faker(new Locale("ru"));

    String name = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = "t0l4ik.kas1@gmail.com";
    String gender = "Male";
    String number = "4545444444";
    String hobbies = "Sports";
    String currentCity = faker.address().fullAddress();
    String imagePath = "img/1.png";
    String state = "NCR";
    String city = "Delhi";
    String[] date = {"14", "February", "1996"};

}
