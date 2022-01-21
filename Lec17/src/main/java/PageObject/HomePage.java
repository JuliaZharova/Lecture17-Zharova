package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//rz-user/button")
    private WebElement userButton;

    public HomePage openRozetka(){
        driver.get("https://rozetka.com.ua/");
        System.out.println(driver.getCurrentUrl());
        return new HomePage(driver);
    }

    public LoginPopupPage openLoginPopup(){
        System.out.println("User button is enable: " + userButton.isEnabled());
        userButton.click();
        System.out.println(driver.getCurrentUrl());
        return new LoginPopupPage(driver);
    }
}
