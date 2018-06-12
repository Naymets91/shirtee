package pages;



import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class CabinetPage extends Page {
    @Step("Нажатие на кнопку  : Create A Campaign!")
    public void clickButtonCreateCampaign() {
         $(byXpath("//a[@class='cc-btn cc-dismiss']")).should(visible).click();
        $(byXpath("//div[@class='footer-top-1-link']")).should(visible).click();
    }

}
