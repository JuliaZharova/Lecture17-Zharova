package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

@FindBy(xpath = "//h1[@class=\"product__title\"]")
    private WebElement productName;

@FindBy(xpath = "//button[@class=\"buy-button button button_with_icon button_color_green button_size_large ng-star-inserted\"]")
    private WebElement buyButton;

@FindBy(xpath = "//div[@class=\"modal__holder modal__holder_show_animation modal__holder--large\"]")
    private WebElement popupCart;

@FindBy(xpath = "//h3[@class=\"modal__heading\"]")
    private WebElement nameCart;

@FindBy(xpath = "//a[@class=\"cart-product__title\"]")
    private WebElement cartProductTitle;

@FindBy(linkText = "Оформить заказ")
    private WebElement placeAnOrderButton;

@FindBy(linkText = "Продолжить покупки")
    private WebElement continueShoppingButton;

@FindBy(id = "cartProductActions0")
    private WebElement threeDotsButton;

@FindBy(xpath = "//button[@class=\"button button--medium button--with-icon button--link context-menu-actions__button\"]")
    private WebElement removeButton;

@FindBy(xpath = "//img[@class=\"cart-dummy__illustration\"]")
    private WebElement imgCart;

@FindBy(xpath = "//h4[@class=\"cart-dummy__heading\"]")
    private WebElement titleCartIsEmpty;

    SoftAssert softAssert = new SoftAssert();


    public CartPage openProductPage(){
        driver.get("https://rozetka.com.ua/207066595/p207066595/");
        System.out.println(driver.getCurrentUrl());
    return this;
    }

    public CartPage getProductName() {
        System.out.println("Product name: " + productName.getText());
        return this;
    }

    public CartPage checkBuyButtonIsDisplayed() {
        System.out.println("Buy button is enabled: " + buyButton.isEnabled());
        return this;
    }

    public CartPage clickOnBuyButton() {
       buyButton.click();
       return this;
    }

    public CartPage checkPopupCartIsDisplayed() {
        System.out.println("Pop-up Cart is displayed: " + popupCart.isDisplayed());
        softAssert.assertTrue(popupCart.isDisplayed());
        return this;
    }

    public CartPage checkNameCart() {
        System.out.println(nameCart.getText());
        softAssert.assertEquals(nameCart.getText(), "Корзина");
        return this;
    }

    public CartPage checkCartProductTitleIsDisplayed() {
        System.out.println("Cart product title is displayed: " + cartProductTitle.isDisplayed());
        softAssert.assertTrue(cartProductTitle.isDisplayed());
        return this;
    }

    public CartPage checkCartProductTitleEqualsProductName() {
        softAssert.assertEquals(cartProductTitle.getText(), productName.getText());
        softAssert.assertAll();
        return this;
    }

    public CartPage checkTextOnPlaceAnOrderButton() {
        System.out.println(placeAnOrderButton.getText());
        softAssert.assertEquals(placeAnOrderButton.getText(), "Оформить заказ");
        return this;
    }

    public CartPage checkTextOnContinueShoppingButton() {
        System.out.println(continueShoppingButton.getText());
        softAssert.assertEquals(continueShoppingButton.getText(), "Продолжить покупки");
        return this;
    }

    public CartPage checkThreeDotsButtonIsDisplayed() {
        System.out.println("Button 'Three dots' is displayed: " + threeDotsButton.isDisplayed());
        return this;
    }

    public CartPage clickOnThreeDotsButton() {
        threeDotsButton.click();
        return this;
    }

    public CartPage checkTextOnRemoveButton() {
    System.out.println(removeButton.getText());
    softAssert.assertEquals(removeButton.getText(), "Удалить");
    return this;
}
    public CartPage clickOnRemoveButton(){
      removeButton.click();
      return this;
    }

public CartPage checkCartImageIsDisplayed(){
    System.out.println("Image is displayed: " + imgCart.isDisplayed());
    softAssert.assertTrue(imgCart.isDisplayed());
    return this;
}

public CartPage checkTitleCartIsEmpty(){
    softAssert.assertEquals(titleCartIsEmpty.getText(), "Корзина пуста");
    System.out.println(titleCartIsEmpty.getText());
    softAssert.assertAll();
        return this;
    }
}









