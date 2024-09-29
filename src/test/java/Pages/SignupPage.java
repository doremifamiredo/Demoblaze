package Pages;

import Data.DataHelper;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SignupPage {
        private final SelenideElement header = $x("//*[@id=\"signInModalLabel\"]");
        private final SelenideElement username = $x("//*[@id=\"sign-username\"]");
        private final SelenideElement password = $x("//*[@id=\"sign-password\"]");
        private final SelenideElement buttonSignup = $x("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]");
        public SignupPage() {
                header.shouldHave(Condition.text("Sign up"));
        }
        public DataHelper.AuthInfo registerNewUser() {
                DataHelper.AuthInfo newUser = DataHelper.generateValidUser();
                username.setValue(newUser.getLogin());
                password.setValue(newUser.getPassword());
                buttonSignup.click();
                String msg = Selenide.switchTo().alert().getText();
                if (msg.equals("Sign up successful.")) Selenide.switchTo().alert().accept();
                return newUser;
        }
}
