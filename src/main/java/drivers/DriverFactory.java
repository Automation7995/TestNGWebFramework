package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.ConfigReader;
import java.net.URL;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    static String browser = ConfigReader.getProperty("browser").toUpperCase();
    static String runMode = ConfigReader.getProperty("runMode").toUpperCase();

    public static WebDriver getDriver() {
        if (driver.get() == null) {

            switch (runMode) {
                case "LOCAL":
                    driver.set(getLocalDriver(browser));
                    break;
                case "GRID":
                    driver.set(getGridDriver(browser));
                    break;
                case "BROWSERSTACK":
                    driver.set(getBrowserStackDriver(browser));
                    break;
                default:
                    throw new RuntimeException("Invalid runMode");
            }
        }
        return driver.get();
    }

    // ---------------- LOCAL ----------------
    private static WebDriver getLocalDriver(String browser) {
        switch (browser) {
            case "CHROME":
                return new ChromeDriver();
            case "FIREFOX":
                return new FirefoxDriver();
            case "EDGE":
                return new EdgeDriver();
            default:
                throw new RuntimeException("Invalid browser");
        }
    }

    // ---------------- GRID ----------------
    private static WebDriver getGridDriver(String browser) {
        try {
            switch (browser) {
                case "CHROME":
                    return new RemoteWebDriver(
                            new URL(ConfigReader.getProperty("gridUrl")),
                            new ChromeOptions()
                    );
                case "FIREFOX":
                    return new RemoteWebDriver(
                            new URL(ConfigReader.getProperty("gridUrl")),
                            new FirefoxOptions()
                    );
                case "EDGE":
                    return new RemoteWebDriver(
                            new URL(ConfigReader.getProperty("gridUrl")),
                            new EdgeOptions()
                    );
                default:
                    throw new RuntimeException("Invalid browser for grid: " + browser);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // ---------------- BROWSERSTACK ----------------
    private static WebDriver getBrowserStackDriver(String browser) {
        try {
            ChromeOptions options = new ChromeOptions();

            options.setCapability("browser", browser);
            options.setCapability("os", "Windows");
            options.setCapability("os_version", "11");
            options.setCapability("name", "Parallel Test");

            String url = "https://"
                    + ConfigReader.getProperty("bs.username")
                    + ":"
                    + ConfigReader.getProperty("bs.accessKey")
                    + "@hub.browserstack.com/wd/hub";

            return new RemoteWebDriver(new URL(url), options);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

}