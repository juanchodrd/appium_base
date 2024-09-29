package stepDefinition;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

import java.time.Duration;

public class openCalculatorSteps {

    private AppiumDriver driver; // Variable de clase

    @Given("Abro la calculadora")
    public void abro_la_calculadora() throws Exception {
        // Inicializa y asigna el driver a la variable de clase
        driver = DriverManager.initialize();
    }

    @When("Ingreso un numero")
    public void ingresoUnNumero() {
        // Utiliza el driver inicializado para interactuar con la aplicación
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement digit5 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.calculator:id/digit_5")));
        digit5.click();
    }
}
