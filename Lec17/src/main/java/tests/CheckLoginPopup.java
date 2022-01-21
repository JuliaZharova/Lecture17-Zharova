package tests;

import PageObject.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import static PageObject.BasePage.*;

public class CheckLoginPopup {

    @DataProvider(name = "validDataForEmailPassword")
    public Object[][] dataForEmailAndPassword() {
        return new Object[][]{
                {"julia.amp.zharova@gmail.com", "QwEr22"},
        };
    }

    @DataProvider(name = "invalidDataForEmailPassword")
    public Object[][] dataForEmailPassword() {
        return new Object[][]{
                {"julia.amp.zharova@gmail.com", "qwerty"}, //валидная почта, невалидный пароль
                {"julia@gmail.com", "QwEr22"}, // невалидная почта, валидный пароль
                {"j@gmail.com", "qwer5"}, // невалидная почта, невалидный пароль
        };
    }

    @Test(groups = {"login"},
            dataProvider = "validDataForEmailPassword")
    public void positiveCheckLoginPopup(String email, String password) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        new HomePage(new ChromeDriver())
                .openRozetka()
                .openLoginPopup()
                .checkPopUpIsDisplaed()
                .checkPopUpTitle()
                .inputEmail(email)
                .inputPassword(password)
                .clickEnterButton()
                .checkPopUpTitle()
                .checkMessageYouAreNotRobot();

    }

    @Test(groups = {"login"})
    public void checkEmptyFieldsInLoginPopup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        new HomePage(new ChromeDriver())
                .openRozetka()
                .openLoginPopup()
                .checkPopUpIsDisplaed()
                .checkPopUpTitle()
                .inputEmail("")
                .inputPassword("")
                .checkInlineErrorWrongLoginIsDisplayed()
                .clickEnterButton()
                .checkPopUpTitle();
    }

    @Test (groups = {"login"},
            dataProvider = "invalidDataForEmailPassword")
    public void negativeCheckLoginPopup(String email, String password) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        new HomePage(new ChromeDriver())
                .openRozetka()
                .openLoginPopup()
                .checkPopUpIsDisplaed()
                .checkPopUpTitle()
                .inputEmail(email)
                .inputPassword(password)
                .clickEnterButton()
                .checkPopUpTitle()
                .checkMessageYouAreNotRobot();
    }
    @AfterMethod
    public void setDown() {
        driver.quit();
    }
}
