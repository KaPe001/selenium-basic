package Tooltip;

import Alerts.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class Tooltip extends TestBase {

    @Test
    public void doingToolTips() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("li:nth-child(3)")));
        driver.findElement(By.cssSelector("li:nth-child(3)")).click();
        driver.findElement(By.id("tooltip-item")).click();

        WebElement tooltipMessage = driver.findElement(By.id("age"));

        String getActualMessage = tooltipMessage.getAttribute("title");
        System.out.println(getActualMessage);
        assertThat(getActualMessage, equalTo("We ask for your age only for statistical purposes."));
        logger.info("Tooltip message printed");


    }
}
