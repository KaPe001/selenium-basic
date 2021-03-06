package Sortable;

import Alerts.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortableClass extends TestBase {

    @Test
    public void sortThingsOut() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li:nth-child(2)")));
        driver.findElement(By.cssSelector("li:nth-child(2)")).click();
        driver.findElement(By.id("sortable-item")).click();

        Integer[] table = {1, 2, 3, 4, 5, 6, 7};
        List<Integer> tableList = Arrays.asList(table);
        Collections.shuffle(tableList);
        System.out.println(Arrays.toString(table));

        for (Integer webElement : tableList) {
            actionOnElement(webElement, tableList.indexOf(webElement) + 1);
        }
    }

    public void actionOnElement(int source, int target) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(driver.findElement(By.xpath("//li[text()='Item " + source + "']")),
                        driver.findElement(By.cssSelector("#sortable li:nth-child(" + target + ")")))
                .build()
                .perform();
    }
}
