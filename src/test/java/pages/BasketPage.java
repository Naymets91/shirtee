package pages;

import config.Product;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static org.testng.AssertJUnit.assertTrue;

public class BasketPage extends Page {
    @Step("Сравнения ожидаемого названия товара с фактическим")

    public void compareName () {
        String actual = $(byXpath("//div[@class='checkout-product-info-right']//a")).getText();
        assertTrue("Названия трансфера не корректно" + " Ожидалось : " + Product.name + " Фактически: " + actual, actual.equalsIgnoreCase(Product.name));
    }

    @Step("Сравнения ожидаемой цены с фактическою")
    public void comparePrice () {
        String actual = $(byXpath("(//span[@class='cart-price']/span)[1]")).getText();
        assertTrue("Сумма трансфера не корректна" + " Ожидалось : " + Product.price + " Фактически: " + actual, actual.equalsIgnoreCase(Product.price));
    }

    @Step("Сравнения ожидаемого размера с фактическим")
    public void compareSize () {
        String actual = $(byXpath("(//dl[@class='item-options'])[1]//dd")).getText();
        assertTrue("Размер трансфера не корректный" + " Ожидалось : " + Product.size + " Фактически: " + actual, actual.equalsIgnoreCase(Product.size));
    }

    @Step("Сравнения ожидаемого цвета с фактическим")
    public void compareColor () {
        String actual = $(byXpath("(//dl[@class='item-options']//dd)[2]")).getText();
        assertTrue("Цвет трансфера не корректный" + " Ожидалось : " + Product.color + " Фактически: " + actual, actual.equalsIgnoreCase(Product.color));
    }

    @Step("Удаления товара из корзины")
    public void  deleteItem () {
        $(byXpath("//span[@class='glc-ico ico-del']")).should(visible).click();
        $(byXpath("//div[@class='cart-empty-title']")).should(visible);
    }

}
