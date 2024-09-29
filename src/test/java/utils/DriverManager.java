package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
    private static AppiumDriver driver; // Cambiar MobileElement a WebElement

    public static AppiumDriver initialize() throws MalformedURLException {
        if (driver == null) {
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
        }
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void close(Scenario scenario) {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
