import listeners.AllureOnFailListener;
import org.testng.annotations.Listeners;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;


import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Listeners({AllureOnFailListener.class})

public class ShirteeTest {

    LoginPage loginPg;
    CabinetPage cabinetPg;
    DesignerPage designerPg;
    ShopPage shopPg;
    ProduckPage produckPg;
    BasketPage basketPg;
    CheckingBasketPage checkingBasketPg;


    @BeforeClass
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.timeout = 20000;
        Configuration.savePageSource = false;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-infobars");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-dev-tools");
        WebDriver myWebDriver = new ChromeDriver(options);
        WebDriverRunner.setWebDriver(myWebDriver);
        open("https://www.shirtee.com");

        loginPg = new LoginPage();
        cabinetPg = new CabinetPage();
        designerPg = new DesignerPage();
        shopPg = new ShopPage();
        produckPg = new ProduckPage();
        basketPg = new BasketPage();
        checkingBasketPg = new CheckingBasketPage();
    }

    @Test()
    public void test() {
        loginPg.logIn();

        cabinetPg.clickButtonCreateCampaign();

        designerPg.clickButtonChop();

        checkingBasketPg.check();

        shopPg.selectRandomProduct();

        produckPg.selectRandomColor();
        produckPg.selectRandomSize();
        produckPg.clickButtonCart();
        produckPg.clickButtonBasket();

        basketPg.comparePrice();
        basketPg.compareName();
        basketPg.compareSize();
        basketPg.compareColor();
        basketPg.deleteItem();
    }

    @AfterClass
    public void after() {
        getWebDriver().quit();
    }
}
