package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
    private static AppiumDriver driver;

    public static AppiumDriver initialize() {
        try {
            if (driver == null) {
                // Configura las capacidades deseadas
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
                caps.setCapability(MobileCapabilityType.UDID, "183a04f6908a");

                // Capacidades específicas de Android
                caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.calculator");
                caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.calculator2.Calculator");

                // Motor de automatización
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

                // Inicia el servidor de Appium y crea el driver
                driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("La URL está mal formada: " + e.getMessage());
        }
        return driver;
    }

    public static AppiumDriver getDriver() {
        return driver;
    }

    public static void close() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
