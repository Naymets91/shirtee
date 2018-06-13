package pages;

import config.Product;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class ProduckPage extends Page {

    @Step("Выбор рандомного цвета")
    public void selectRandomColor() {
        int r = $$(byXpath("//span[@onclick='changeColor(this)']")).size();
        int s = getRandomNumber(1,r);
        $(byXpath("(//span[@onclick='changeColor(this)'])[" + s + "]")).should(visible).click();
        Product.color = $(byXpath("//span[@class='color-btn active']")).getAttribute("title");
        report("Цвет выбран: " + Product.color);
    }

    @Step("Выбор рандомного размера")
    public void selectRandomSize() {
        int r = $$(byXpath("//input[@type='radio']")).size();
        int s = getRandomNumber(1,r);
        $(byXpath("(//div[@name='addition_size[]']//label)[" + s + "]")).should(visible).click();
        Product.size = $(byXpath("(//div[@name='addition_size[]']//label)[" + s + "]")).getText();
        report("Размер выбран: " + Product.size);
    }

    @Step("Нажать на кнопку : Add To Cart")
    public  void clickButtonCart() {
        $(byXpath("//button[@class='button btn-cart']")).click();
    }

    @Step("Нажать на кнопку :  To The Basket")
    public  void clickButtonBasket() {
        $(byXpath("//div[@class='header-cart']/a")).click();
    }

}
