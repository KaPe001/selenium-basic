package Droppable;

import Alerts.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DroppableClass extends TestBase {

    @Test
    public void dropSquare(){

        driver.findElement(By.cssSelector("li:nth-child(2)")).click();
        driver.findElement(By.id("droppable-item")).click();

        WebElement draggableSquare = driver.findElement(By.id("draggable"));
        WebElement droppableArea = driver.findElement(By.id("droppable"));

        Actions action = new Actions(driver);
        action.clickAndHold(draggableSquare)
                .moveToElement(droppableArea)
                .release()
                .perform();
    }
}
