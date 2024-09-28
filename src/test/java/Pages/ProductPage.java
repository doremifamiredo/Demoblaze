package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class ProductPage {
    private final SelenideElement header = $x("//*[@id=\"tbodyid\"]/h2");
    private final SelenideElement price = $x("//*[@id=\"tbodyid\"]/h3");
    private final SelenideElement buttonAddToCart = $x("//*[@id=\"tbodyid\"]/div[2]/div/a");
    private final SelenideElement backHome = $x("//*[@id=\"nava\"]");
    public ProductPage(){
        header.shouldBe(Condition.visible, Duration.ofSeconds(10));
    }

    public int addToCart() {
        String priceFromCard = price.getText();
        var cut = priceFromCard.indexOf(" ");
        priceFromCard = priceFromCard.substring(1, cut);
        buttonAddToCart.click();
        Selenide.switchTo().alert().accept();
        return Integer.parseInt(priceFromCard);
    }

    public HomePage backHome() {
        backHome.click();
        return new HomePage();
    }

}
