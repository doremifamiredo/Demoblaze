package Pages;

import Data.DataHelper;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private SelenideElement username = $x("//*[@id=\"loginusername\"]");
    private SelenideElement password = $x("//*[@id=\"loginpassword\"]");
    private SelenideElement buttonLogin = $x("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]");

    public void loginWithTestData(DataHelper.AuthInfo authInfo) {
        username.setValue(authInfo.getLogin());
        password.setValue(authInfo.getPassword());
        buttonLogin.click();
    }
}
