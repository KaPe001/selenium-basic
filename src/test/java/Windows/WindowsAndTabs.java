package Windows;

import Alerts.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowsAndTabs extends TestBase {

    @Test
    public void goingThroughNewTabs() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".dropdown:first-child")));
        driver.findElement(By.cssSelector(".dropdown:first-child")).click();

        WebElement alerts = driver.findElement(By.id("windows-tabs-item"));
        alerts.click();

        //new browser window handling
        driver.findElement(By.id("newBrowserWindow")).click();

        String parent = driver.getWindowHandle();
        Set<String> s = driver.getWindowHandles();

        for (String childWindow : s) {
            if (!parent.equals(childWindow)) {
                driver.switchTo().window(childWindow);
                logger.info("Switched to the new window");
            }
        }
        tableMethod();

        driver.close();
        driver.switchTo().window(parent);
        logger.info("Driver return to the parent window");

        //new message window handling
        driver.findElement(By.id("newMessageWindow")).click();

        String newParent = driver.getWindowHandle();
        Set<String> s2 = driver.getWindowHandles();

        for (String childWindow : s2) {
            if (!newParent.equals(childWindow)) {
                driver.switchTo().window(childWindow);
                logger.info("Switched to the new message window");
                System.out.println("Window message: " + driver.findElement(By.tagName("body")).getText());
            }
        }
        driver.close();
        driver.switchTo().window(newParent);
        logger.info("Driver return to the parent window");

        //new tab handling
        driver.findElement(By.id("newBrowserTab")).click();
        String oldTab = driver.getWindowHandle();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        tableMethod();

        driver.close();
        driver.switchTo().window(oldTab);
        logger.info("Driver return to the old tab");
    }

    public void tableMethod() {
        List<WebElement> table = driver.findElements(By.cssSelector("tbody tr"));
        for (WebElement row : table) {

            String rank = row.findElement(By.cssSelector("tr th")).getText();
            String peak = row.findElement(By.cssSelector("td")).getText();
            String mountainRange = row.findElement(By.xpath("td[2]")).getText();
            String state = row.findElement(By.xpath("td[3]")).getText();
            int height = Integer.parseInt(row.findElement(By.xpath("td[4]")).getText());

            if (state.equals("Switzerland") && height > 4000) {
                System.out.println("Rank: " + rank + " Peak: " + peak + " Mountain Range: "
                        + mountainRange);
            }
        }
    }
}
