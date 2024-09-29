package Pages;

import Data.DataHelper;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartPage {
    private final SelenideElement cartProducts = $x("//*[@id=\"tbodyid\"]");
    private final ElementsCollection price = $$x("//*[@id=\"tbodyid\"]/tr/td[3]");
    private final SelenideElement total = $x("//*[@id=\"totalp\"]");
    private final SelenideElement placeOrder = $x("//*[@id=\"page-wrapper\"]/div/div[2]/button");
    public CartPage() {
        cartProducts.shouldBe(Condition.visible, Duration.ofSeconds(10));
    }

    public void assertTotal() {
        if (Integer.parseInt(total.shouldBe(Condition.visible).getText()) ==
        getAmount()) placeOrder();
        else System.out.println("Total isn`t equal amount");
    }

    public int getAmount() {
        int amount = 0;
        for (SelenideElement price : price) {
            int item = Integer.parseInt(price.getText());
            amount += item;
        }
        return amount;
    }

    public void placeOrder() {
        placeOrder.click();
        new PlaceOrder().setPurchase(DataHelper.getPlaceOrderInfo());
      //  return
    }
}
