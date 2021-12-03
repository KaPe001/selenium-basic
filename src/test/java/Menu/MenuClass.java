package Menu;

import Alerts.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MenuClass extends TestBase {

    @Test
    public void clickOnMenuOption() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li:nth-child(3)")));
        driver.findElement(By.cssSelector("li:nth-child(3)")).click();
        driver.findElement(By.id("menu-item")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("ui-id-9")));
        driver.findElement(By.id("ui-id-9")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("ui-id-13")));
        driver.findElement(By.id("ui-id-13")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("ui-id-16")));
        driver.findElement(By.id("ui-id-16")).click();
    }
}