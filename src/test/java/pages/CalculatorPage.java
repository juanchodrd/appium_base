package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalculatorPage {
    private AppiumDriver driver; // Guardar referencia al driver

    // Constructor
    public CalculatorPage(AppiumDriver driver) {
        this.driver = driver;
    }

    // Método para presionar el número 5
    public void pressDigit5() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement digit5 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.calculator:id/digit_5")));
        digit5.click();
    }
}

