package Sortable;

import Alerts.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.*;

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

        List<WebElement> WebElementTable = driver.findElements(By.id("sortable"));
        List<String> beforeShuffling = Arrays.asList(new String[WebElementTable.size()]);

        for(int i = 0; i< WebElementTable.size(); i++){
            beforeShuffling.set(i, WebElementTable.get(i).getText());
        }
//        System.out.println((beforeShuffling));

        System.out.println("After the shuffling");
//        Collections.shuffle(beforeShuffling);

        System.out.println(beforeShuffling);
    }
//    public static void Print(List<String> ar){
//        for(int i = 0; i < ar.size(); i++){
//            System.out.println(ar.get(i));
//        }
//    }
}
