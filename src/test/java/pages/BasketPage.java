package pages;

import config.Product;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class BasketPage extends Page {
    @Step("Сравнения ожидаемого названия товара с фактическим")

    public void compareName () {
        String actual = $(byXpath("//div[@class='checkout-product-info-right']//a")).getText();
        boolean equals = equalsIgnoreCase(actual, Product.name );
        report("Ожидаемое названия : " + Product.name);
        report("Фактическое название: " + actual);

        System.out.println("Сравнения ожидаемого названия товара с фактическим : "  + equals);
    }

    @Step("Сравнения ожидаемой цены с фактическою")
    public void comparePrice () {
        String actual = $(byXpath("(//span[@class='cart-price']/span)[1]")).getText();
        boolean equals = equalsIgnoreCase(actual, Product.price );
        report("Ожидаемая цена : " + Product.price);
        report("Фактическая  цена : " + actual);

        System.out.println("Сравнения ожидаемой цены с фактическою : "   + equals);
    }
    @Step("Сравнения ожидаемого размера с фактическим")
    public void compareSize () {
        String actual = $(byXpath("(//dl[@class='item-options'])[1]//dd")).getText();
        boolean equals = equalsIgnoreCase(actual, Product.size );
        report("Ожидаемый размер : " + Product.size);
        report("Фактический размер : " + actual);

        System.out.println("Сравнения ожидаемого размера с фактическим : "   + equals);
    }
    @Step("Сравнения ожидаемого цвета с фактическим")
    public void compareColor () {
        String actual = $(byXpath("(//dl[@class='item-options']//dd)[2]")).getText();
        boolean equals = equalsIgnoreCase(actual, Product.color );
        report("Ожидаемый цвет : " + Product.color);
        report("Фактический цвет : " + actual);

        System.out.println("Сравнения ожидаемого цвета с фактическим : "  + equals);
    }
    @Step("Удаления товара из корзины")
    public void  deleteItem () {
        $(byXpath("//span[@class='glc-ico ico-del']")).should(visible).click();
        $(byXpath("//div[@class='cart-empty-title']")).should(visible);
    }

}
