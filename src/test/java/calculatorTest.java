import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;

public class calculatorTest {
    public static void main(String[] args) {
        try {
            // Configura las capacidades deseadas
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
            caps.setCapability(MobileCapabilityType.UDID, "183a04f6908a");  // Usa adb devices para obtener el ID del dispositivo

            // Usa las capacidades específicas de Android
            caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.calculator"); // Paquete de la calculadora
            caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.calculator2.Calculator"); // Actividad de la calculadora

            // Motor de automatizacion
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");


            // Inicia el servidor de Appium y crea el driver
            AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);

            // Interactúa con la app (ejemplo: presionar el botón '5' de la calculadora)
            //driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_5")).click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            WebElement digit5 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.calculator:id/digit_5")));
            digit5.click();

            // Finaliza la sesión
            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
