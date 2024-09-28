import Data.DataHelper;
import Pages.*;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DemoTest {
    DataHelper dataHelper;
    HomePage homePage;
    ProductPage productPage;
    DataHelper.AuthInfo authInfo;
    CartPage cartPage;
    PlaceOrder placeOrder;

    @BeforeEach
    void setup() {
        homePage = open("https://www.demoblaze.com", HomePage.class);
        var loginPage = homePage.login();
        authInfo = dataHelper.testData();
        loginPage.loginWithTestData(authInfo);
    }

    @Test
    void test() {
        int priceListPhone = homePage.orderWhat("Phones");
        productPage = homePage.orderProduct();
        int priceCardPhone = productPage.addToCart();
        homePage = productPage.backHome();
        int priceListLaptop = homePage.orderWhat("Laptops");
        productPage = homePage.orderProduct();
        int priceCardLaptop = productPage.addToCart();
        homePage = productPage.backHome();
        int priceListMonitor = homePage.orderWhat("Monitors");
        productPage = homePage.orderProduct();
        int priceCardMonitor = productPage.addToCart();
        homePage = productPage.backHome();
        cartPage = homePage.goToCart();
        int total = cartPage.getTotal();
        int amount = cartPage.getAmount();
        placeOrder = cartPage.placeOrder();
        placeOrder.setPurchase(dataHelper.getPlaceOrderInfo());
        assertAll(() -> assertEquals(priceListPhone, priceCardPhone),
                () -> assertEquals(priceListLaptop, priceCardLaptop),
                () -> assertEquals(priceListMonitor, priceCardMonitor),
                () -> assertEquals(total, amount));
    }
}
