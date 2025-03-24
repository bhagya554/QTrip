import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverSingleton {

    private static WebDriver driver = null;

    private DriverSingleton(){}


    public static WebDriver getDriver(String browser) throws MalformedURLException{

        if(driver == null){

            switch(browser){

                case "chrome":
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-gpu");
                    driver = new ChromeDriver(options);
                    break;

                case "firefox":
                    FirefoxOptions ffOptions = new FirefoxOptions();
                    ffOptions.addArguments("--no-sandbox");
                    ffOptions.addArguments("--disable-gpu");
                    driver = new FirefoxDriver(ffOptions);
                    break;
            }

            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();

        }
        return driver;
    }

    public static void launchApp(String appURL) {
        driver.get(appURL);

    }
}