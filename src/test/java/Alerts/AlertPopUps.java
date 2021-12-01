package Alerts;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class AlertPopUps extends TestBase {

    @Test
    public void handleAlerts() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".dropdown:first-child")));
        driver.findElement(By.cssSelector(".dropdown:first-child")).click();

        WebElement alerts = driver.findElement(By.id("alerts-item"));
        alerts.click();

        //simple alert
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("simple-alert")));
        driver.findElement(By.id("simple-alert")).click();

        driver.switchTo().alert().accept();
        WebElement confirmMessageSimple = driver.findElement(By.cssSelector("[id='simple-alert-label']"));
        assertThat(confirmMessageSimple.getText(), equalTo("OK button pressed"));
        logger.info("Simple alert done");

        //prompt alert
        WebElement promptAlert = driver.findElement(By.id("prompt-alert"));
        promptAlert.click();
        driver.switchTo().alert().sendKeys("Lord Vader");
        driver.switchTo().alert().accept();

        WebElement confirmMessagePrompt = driver.findElement(By.id("prompt-label"));
        assertThat(confirmMessagePrompt.getText(), equalTo("Hello Lord Vader! How are you today?"));
        logger.info("Prompt alert done");

        //confirm alert
        WebElement confirmAlert = driver.findElement(By.id("confirm-alert"));
        confirmAlert.click();
        driver.switchTo().alert().dismiss();

        WebElement confirmMessageConfirm = driver.findElement(By.id("confirm-label"));
        assertThat(confirmMessageConfirm.getText(), equalTo("You pressed Cancel!"));
        logger.info("Cancel confirm alert done");

        confirmAlert.click();
        driver.switchTo().alert().accept();
        assertThat(confirmMessageConfirm.getText(), equalTo("You pressed OK!"));
        logger.info("Accept confirm alert done");
    }
}
