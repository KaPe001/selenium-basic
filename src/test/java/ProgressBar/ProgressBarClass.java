package ProgressBar;

import Alerts.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ProgressBarClass extends TestBase {

    @Test
    public void waitThisComplete() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li:nth-child(3)")));
        driver.findElement(By.cssSelector("li:nth-child(3)")).click();
        driver.findElement(By.id("progressbar-item")).click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("ui-progressbar-complete")));
        WebElement completeInfo = driver.findElement(By.className("progress-label"));
        assertThat(completeInfo.getText(), equalTo("Complete!"));
    }
}