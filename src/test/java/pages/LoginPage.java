package pages;


import config.Values;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends Page {
    @Step("Ввод логина и пароля")
    public void logIn() {
        $(byXpath("//div[@class='bhi-link-right']")).click();
        $("#header-login-form-email").setValue(Values.login);
        $("#header-login-form-password").setValue(Values.password);
        $(byXpath("//button[@class='button btn-proceed-checkout btn-checkout youama-ajaxlogin-button']")).click();
        report("Логин : " + Values.login);
        report("Пароль : " + Values.password);
    }
}
