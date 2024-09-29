import Data.DataHelper;
import Pages.*;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DemoTest {
    HomePage homePage;
    static DataHelper.AuthInfo authInfo;
    CartPage cartPage;

    @BeforeEach
    void setup() {
        homePage = open("https://www.demoblaze.com", HomePage.class);
        authInfo = homePage.signup();
        homePage.login(authInfo);
        System.out.println(authInfo.getLogin());
        System.out.println(authInfo.getPassword());
    }

    @Test
    void test() {
        homePage.orderWhat("Phones");
        homePage.orderWhat("Laptops");
        homePage.orderWhat("Monitors");
        cartPage = homePage.goToCart();
        cartPage.assertTotal();
    }
}
