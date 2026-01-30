package utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

    public static String takeScreenshots(WebDriver driver) {

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String path = "screenshot/" + System.currentTimeMillis() + ".png";

        try {

            FileUtils.copyFile(src, new File(path));

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return path;
    }
}