package pages;

import config.Product;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class ShopPage extends Page {

    @Step("Выбор рандомного товара")
    public void selectRandomProduct() {
        int r = $$(byXpath("//div[@class='item-in']")).size();
        int s = getRandomNumber(1,r);
        Product.name = $(byXpath("(//div[@class='product-info'])[" + s + "]//a")).getText();
        Product.price = $(byXpath("(//div[@class='price-box-wrap'])[" + s + "]//span")).getText();
        $(byXpath("(//div[@class='item-in'])[" + s + "]")).should(visible).click();
        report("Выбран товар: " + Product.name);

        System.out.println("Найдено товаров " + r );
        System.out.println("Выбрано товар № " + s);
        System.out.println("Названия товара " + Product.name);
        System.out.println("Цена товара " + Product.price);
        System.out.println(" ");
    }
}
