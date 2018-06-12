package pages;

import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class DesignerPage extends Page {
    @Step("Нажатие на кнопку  : Chop")
    public void clickButtonChop() {
        $(byXpath("//div[@class='header-links-full-item header-links-full-item-shop']")).click();
    }
}
