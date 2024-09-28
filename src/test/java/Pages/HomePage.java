package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;
import java.util.Random;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

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

    public int orderWhat(String what) {
        itsems.findBy(Condition.text(what)).click();
        return getPriceFromList();
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

    public LoginPage login() {
        logIn.click();
        return new LoginPage();
    }


    public CartPage goToCart() {
        cart.click();
        return new CartPage();
    }
}
