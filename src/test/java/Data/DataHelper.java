package Data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Random;

public class DataHelper {
     static Faker faker = new Faker();
     static Random random = new Random();

    public static AuthInfo testData() {
        return new AuthInfo("doremi@fasollasi.ru", "qwerty");
    }

    public static PlaceOrderInfo getPlaceOrderInfo() {
        return new PlaceOrderInfo(faker.name().firstName(), faker.country().name(),
                faker.country().capital(), faker.numerify("################"),
                Integer.toString(random.nextInt(12)), "2025");
    }

    public static void generateValidUser() {

    }

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    @Value
    public static class PlaceOrderInfo {
        String name;
        String country;
        String city;
        String card;
        String month;
        String year;
    }
}
