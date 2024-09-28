package Pages;

import Data.DataHelper;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class PlaceOrder {
    private final SelenideElement header = $x("//*[@id=\"orderModalLabel\"]");
    private final SelenideElement name = $x("//*[@id=\"name\"]");
    private final SelenideElement country = $x("//*[@id=\"country\"]");
    private final SelenideElement city = $x("//*[@id=\"city\"]");
    private final SelenideElement card = $x("//*[@id=\"card\"]");
    private final SelenideElement month = $x("//*[@id=\"month\"]");
    private final SelenideElement years = $x("//*[@id=\"year\"]");
    private final SelenideElement purchase = $x("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]");
    public PlaceOrder() {
        header.shouldBe(Condition.visible, Duration.ofSeconds(10));
    }

    public void setPurchase(DataHelper.PlaceOrderInfo placeOrderInfo){
        name.setValue(placeOrderInfo.getName());
        country.setValue(placeOrderInfo.getCountry());
        city.setValue(placeOrderInfo.getCity());
        card.setValue(placeOrderInfo.getCard());
        month.setValue(placeOrderInfo.getMonth());
        years.setValue(placeOrderInfo.getYear());
        purchase.click();
    }
}
