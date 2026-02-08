package base;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import drivers.DriverFactory;
import utils.ConfigReader;

public abstract class BaseTest {

    protected WebDriver driver;
    
    @BeforeClass
    public void setUp() {
         driver = DriverFactory.getDriver();
         driver.manage().window().maximize();
         driver.get(ConfigReader.getProperty("url"));
    }

    @AfterClass
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
