package AutoComplete;

import Alerts.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AutoCompleteClass extends TestBase {

    @Test
    public void autoCompleteInSearch() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li:nth-child(3)")));
        driver.findElement(By.cssSelector("li:nth-child(3)")).click();
        driver.findElement(By.id("autocomplete-item")).click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("search")));
        WebElement search = driver.findElement(By.id("search"));
        search.click();
        search.sendKeys("a");

        List<WebElement> autocompleteList = driver.findElements(By.className("ui-autocomplete"));
        for (WebElement webElement : autocompleteList) {
            System.out.println(webElement.getText());
        }
    }
}
