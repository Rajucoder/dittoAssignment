package utils;

import org.openqa.selenium.*;
import java.io.File;
import java.nio.file.Files;

public class ScreenshotUtils {

    public static String capture(WebDriver driver, String name) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String path = "screenshots/" + name + ".png";
            File target = new File(path);
            target.getParentFile().mkdirs();
            Files.copy(src.toPath(), target.toPath());
            return path;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
