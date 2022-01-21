package PageObject;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.CheckCartPage;

import java.io.FileOutputStream;
import java.io.IOException;

public class ClassForListeners implements ITestListener {
  /*  @Override
    public void onTestFailure(ITestResult result) {
        CheckCartPage checkCartPage = (CheckCartPage) result.getInstance();
        TakesScreenshot src = ((TakesScreenshot) checkCartPage.driver);
        byte[] screenshot = src.getScreenshotAs(OutputType.BYTES);

        String fileName = "screenshot.png";
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            fileOutputStream.write(screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
