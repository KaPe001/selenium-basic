package Selectable;

import Alerts.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class SelectableClass extends TestBase {

    @Test
    public void selectItems(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("li:nth-child(2)")));

        driver.findElement(By.cssSelector("li:nth-child(2)")).click();
        driver.findElement(By.id("selectable-item")).click();

        List<WebElement> items = driver.findElements(By.className("ui-widget-content"));
        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL)
                .click(items.get(0))
                .click(items.get(2))
                .click(items.get(3))
                .keyUp(Keys.CONTROL)
                .build()
                .perform();

        WebElement confirmMessage = driver.findElement(By.id("feedback"));
        assertThat(confirmMessage.getText(), equalTo("You've selected: #1 #3 #4."));
        logger.info("Specific items selected, message confirmed");
    }
}
