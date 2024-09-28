package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CartPage {
    private final SelenideElement cartProducts = $x("//*[@id=\"tbodyid\"]");
    private final ElementsCollection price = $$x("//*[@id=\"tbodyid\"]/tr/td[3]");
    private final SelenideElement total = $x("//*[@id=\"totalp\"]");
    private final SelenideElement placeOrder = $x("//*[@id=\"page-wrapper\"]/div/div[2]/button");
    public CartPage() {
        cartProducts.shouldBe(Condition.visible, Duration.ofSeconds(10));
    }

    public int getTotal() {
        total.shouldBe(Condition.visible);
        return Integer.parseInt(total.getText());
    }

    public int getAmount() {
        int amount = 0;
        for (SelenideElement price : price) {
            int item = Integer.parseInt(price.getText());
            amount += item;
        }
        return amount;
    }

    public PlaceOrder placeOrder() {
        placeOrder.click();
        return new PlaceOrder();
    }
}
