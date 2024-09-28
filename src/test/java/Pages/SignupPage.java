package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SignupPage {
        private SelenideElement username = $x("//*[@id=\"sign-username\"]");
        private SelenideElement password = $x("//*[@id=\"sign-password\"]");
        private SelenideElement buttonSignup = $x("//*[@id=\"signInModal\"]/div/div/div[3]");


}
