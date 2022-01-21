package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class LoginPopupPage extends BasePage {

    public LoginPopupPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//single-modal-window/div[3]")
    private WebElement popup;

    @FindBy(xpath = "//h3[@class=\"modal__heading\"]")
    private WebElement titlePopup;

    @FindBy(id = "auth_email")
    private WebElement emailFieldInLoginPopUp;

    @FindBy(id = "auth_pass")
    private WebElement passwordInLoginPopUp;

    @FindBy(xpath = "//button[@class=\"button button--large button--green auth-modal__submit ng-star-inserted\"]")
    private WebElement enterButton;

    @FindBy(xpath = "//*[@id=\"rc-anchor-container\"]")
    private WebElement reCAPTCHAdiv;

    @FindBy(xpath = "//div[@class=\"recaptcha-checkbox-border\"]")
    private WebElement reCAPTCHAcheckbox;

    @FindBy(xpath = "//rz-auth//div[4]/rz-re-captcha//p")
    private WebElement messageYouAreNotRobot;

    @FindBy(xpath = "//p[@class=\"error-message ng-star-inserted\"]")
    private  WebElement inlineErrorWrongLogin;


    SoftAssert softAssert = new SoftAssert();

    public LoginPopupPage checkPopUpIsDisplaed() {
        System.out.println("Pop-up is displayed: " + popup.isDisplayed());
        softAssert.assertTrue(popup.isDisplayed());
        return this;
    }

    public LoginPopupPage checkPopUpTitle() {
        String titlePopUp = titlePopup.getText();
        Assert.assertEquals(titlePopUp, "Вход");
        softAssert.assertAll();
        return this;
    }

    public LoginPopupPage inputEmail(String email) {
        emailFieldInLoginPopUp.sendKeys(email);
        return this;
    }

    public LoginPopupPage inputPassword(String password) {
        passwordInLoginPopUp.sendKeys(password);
        return this;
    }

    public LoginPopupPage clickEnterButton() throws InterruptedException {
        System.out.println("Button 'Войти' is enabled: " + enterButton.isEnabled());
        enterButton.click();
        return this;
    }

    public LoginPopupPage checkInlineErrorWrongLoginIsDisplayed(){
        System.out.println("Error 'Введен неверный адрес эл.почты или номер телефона' is displayed:  " + inlineErrorWrongLogin.isDisplayed());
        System.out.println(inlineErrorWrongLogin.getText());
        softAssert.assertEquals(inlineErrorWrongLogin.getText(), "Введен неверный адрес эл.почты или номер телефона");
        return this;
    }

    public LoginPopupPage checkMessageYouAreNotRobot(){
        System.out.println("Message 'Необходимо подтвердить, что вы не робот' is displaed: " + messageYouAreNotRobot.isDisplayed());
        softAssert.assertEquals(messageYouAreNotRobot.getText(), "Необходимо подтвердить, что вы не робот");
        softAssert.assertAll();
        return this;
    }
    public LoginPopupPage checkreCAPTCHAdivIsDisplaed() {
        System.out.println("reCAPTCHA is displaed:" + reCAPTCHAdiv.isDisplayed());
        return this;
    }

    public LoginPopupPage checkreCAPTCHAcheckboxIsDisplaed() {
        System.out.println("reCAPTCHA checkbox is displaed:" + reCAPTCHAcheckbox.isDisplayed());
        return this;
    }

    public LoginPopupPage clickOnReCAPTCHAcheckbox() {
        reCAPTCHAcheckbox.click();
        return this;
    }

    public LoginPopupPage checkPopUpClosed() {
        System.out.println("Pop-up is displayed: " + popup.isDisplayed());
        softAssert.assertFalse(popup.isDisplayed());
        System.out.println(driver.getCurrentUrl());
        softAssert.assertAll();
        return this;
    }

}
