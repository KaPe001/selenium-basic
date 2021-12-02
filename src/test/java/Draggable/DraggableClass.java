package Draggable;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DraggableClass extends TestBase{

    @Test
    public void dragSquare(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("li:nth-child(2)")));
        driver.findElement(By.cssSelector("li:nth-child(2)")).click();
        WebElement draggableOption = driver.findElement(By.id("draggable-item"));
        draggableOption.click();

        WebElement square = driver.findElement(By.id("draggable"));

        Actions action = new Actions(driver);
        action.clickAndHold(square)
                .moveByOffset(1000, -20)
                .moveByOffset(0, 400)
                .moveByOffset(-550, -200)
                .moveByOffset(-500, 200)
                .build()
                .perform();

        logger.info("Square moved around correctly");
    }
}
