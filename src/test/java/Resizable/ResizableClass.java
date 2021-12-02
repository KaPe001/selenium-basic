package Resizable;

import Alerts.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ResizableClass extends TestBase {

    @Test
    public void resizeItem(){

        driver.findElement(By.cssSelector("li:nth-child(2)")).click();
        driver.findElement(By.id("resizable-item")).click();

        WebElement resizableArea = driver.findElement(By.cssSelector(".ui-resizable-handle:last-child"));

        Actions action = new Actions(driver);
        action.clickAndHold(resizableArea)
                //put 100 bc it's more visible how it's moving
                .moveByOffset(100, 0)
                .moveByOffset(0, 100)
                .moveByOffset(100, 100)
                .release()
                .perform();
    }
}
