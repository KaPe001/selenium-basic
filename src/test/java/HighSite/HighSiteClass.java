package HighSite;

import Alerts.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class HighSiteClass extends TestBase {

    @Test
    public void scrollDownThePage() throws IOException {
        WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li:nth-child(4)")));

        driver.findElement(By.cssSelector("li:nth-child(4)")).click();
        driver.findElement(By.id("high-site-item")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, document.body.scrollHeight)");

        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("src/test/java/HighSite_scr.png"));
    }
}
