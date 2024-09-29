package Pages;

import Data.DataHelper;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;
import java.util.Random;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePage {
    private final SelenideElement home = $x("//*[@id=\"nava\"]");
    private final SelenideElement cart = $x("//*[@id=\"cartur\"]");
    private final SelenideElement logIn = $x("//*[@id=\"login2\"]");
    private final SelenideElement signUp = $x("//*[@id=\"signin2\"]");
    private final ElementsCollection itsems = $$x("//*[@id=\"itemc\"]");
    private final SelenideElement content = $x("//*[@id=\"contcont\"]");
    public HomePage() {
        content.shouldBe(visible, Duration.ofSeconds(10));
    }
    Random random = new Random();
    int selectItem;
    ElementsCollection products;

    public void orderWhat(String what) {
        itsems.findBy(Condition.exactText(what)).click();
        int priceList = getPriceFromList();
        products.get(selectItem).click();
        int priceCard = new ProductPage().addToCart();
        assertEquals(priceList, priceCard);
    }

    private int getPriceFromList() {
        $x("//*[@id=\"tbodyid\"]/div").shouldBe(visible);
        products = $$x("//*[@id=\"tbodyid\"]/div");
        selectItem = random.nextInt(products.size());
        String priceFromList = products.get(selectItem).$("h5").getText().substring(1);
        return Integer.parseInt(priceFromList);
    }

    public ProductPage orderProduct() {
        $x("//*[@id=\"tbodyid\"]/div").shouldBe(visible);
         products.get(selectItem).click();
         return new ProductPage();
    }

    public void login(DataHelper.AuthInfo authInfo) {
        logIn.click();
        new LoginPage().loginWithTestData(authInfo);
    }

    public DataHelper.AuthInfo signup() {
        signUp.click();
        return new SignupPage().registerNewUser();
    }


    public CartPage goToCart() {
        cart.click();
        return new CartPage();
    }
}
