package tests;

import PageObject.BasePage;
import PageObject.CartPage;
import PageObject.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static PageObject.BasePage.driver;


public class CheckCartPage {

    @Test (groups = {"cart"})
    public void checkAddItemToCard(){
        WebDriverManager.chromedriver().setup();
        new CartPage(new ChromeDriver())
                .openProductPage()
                .getProductName()
                .checkBuyButtonIsDisplayed()
                .clickOnBuyButton()
                .checkNameCart()
                .checkPopupCartIsDisplayed()
                .checkTextOnContinueShoppingButton()
                .checkTextOnPlaceAnOrderButton()
                .checkCartProductTitleIsDisplayed().
                checkCartProductTitleEqualsProductName();
    }

    @Test (groups = {"cart"})
    public void checkRemoveItemFromCart(){
        WebDriverManager.chromedriver().setup();
        new CartPage(new ChromeDriver())
                .openProductPage()
                .checkBuyButtonIsDisplayed()
                .clickOnBuyButton()
                .checkNameCart()
                .checkPopupCartIsDisplayed()
                .checkCartProductTitleIsDisplayed()
                .checkThreeDotsButtonIsDisplayed()
                .clickOnThreeDotsButton()
                .checkTextOnRemoveButton()
                .clickOnRemoveButton()
                .checkCartImageIsDisplayed()
                .checkTitleCartIsEmpty();
    }

    @AfterMethod
    public void setDown() {
        driver.quit();
    }
}
