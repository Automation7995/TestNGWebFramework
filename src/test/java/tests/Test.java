package tests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

    public static void launchBrowser() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(375,812));
        driver.get("https://www.jiomart.com");
        Thread.sleep(3000);
    }

    public static void main(String[] args) throws InterruptedException {
        launchBrowser();
    }
}

//Map<String, Object> mobileEmulation = new HashMap<>();
//mobileEmulation.put("deviceName", "iPhone X");
//
//ChromeOptions options = new ChromeOptions();
//options.setExperimentalOption("mobileEmulation", mobileEmulation);
//
//WebDriver driver = new ChromeDriver(options);
