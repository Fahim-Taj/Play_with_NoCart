package nocart;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;

public class BaseClass
{
    static AppiumDriver driver;

    public static void setupDriver() throws MalformedURLException
    {
        DesiredCapabilities app = new DesiredCapabilities();
        app.setCapability("deviceName", "sdk_gphone_x86_64");
        app.setCapability("udid", "emulator-5554");
        app.setCapability("platformName", "Android");
        app.setCapability("platformVersion", "11");
        app.setCapability("appPackage", "com.nopstation.nopcommerce.nopstationcart");
        app.setCapability("appActivity", "com.bs.ecommerce.main.SplashScreenActivity");
        
        URI uri = URI.create("http://0.0.0.0:4723/wd/hub");
        URL url = uri.toURL();
        driver = new AppiumDriver (url, app);

        System.out.println("Application Started");
    }
}
