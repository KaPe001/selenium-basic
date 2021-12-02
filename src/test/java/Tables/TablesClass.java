package Tables;

import Alerts.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TablesClass extends TestBase {

    @Test
    public void workOnTables() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".dropdown:first-child")));
        driver.findElement(By.cssSelector(".dropdown:first-child")).click();

        driver.findElement(By.id("table-item")).click();

        try {
            Thread.sleep(1500);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<WebElement> table = driver.findElements(By.cssSelector("tbody tr"));
        for (WebElement row : table) {

            String rank = row.findElement(By.cssSelector("tr th")).getText();
            String peak = row.findElement(By.cssSelector("td")).getText();
            String mountainRange = row.findElement(By.xpath("td[2]")).getText();
            String state = row.findElement(By.xpath("td[3]")).getText();
            int height = Integer.parseInt(row.findElement(By.xpath("td[4]")).getText());

            if (state.equals("Switzerland") && height > 4000) {
                System.out.println("Rank: " + rank + " Peak: " + peak + " Mountain Range: "
                        + mountainRange);
            }
        }
    }
}

