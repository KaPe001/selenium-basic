package Sortable;

import Alerts.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

        List<WebElement> WebElementTable = driver.findElements(By.cssSelector("#sortable li"));
//        for(WebElement webElement : WebElementTable){
//            actionOnElement(tableList.get(), tableList.size());
//        }

        for (int i = 1; i == WebElementTable.size(); i++) {
            actionOnElement(i,tableList.get(i));
        }
    }

    public void actionOnElement(int source, int target) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(driver.findElement(By.xpath("//*[@id='sortable']/li[" + source + "]")),
                        driver.findElement(By.cssSelector("#sortable li:nth-child(" + target + ")")))
                .release()
                .build()
                .perform();
    }
}
