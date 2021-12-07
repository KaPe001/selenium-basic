package SelectMenu;

import Alerts.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Selectable extends TestBase {

    @Test
    public void selectMenu() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li:nth-child(3)")));
        driver.findElement(By.cssSelector("li:nth-child(3)")).click();
        driver.findElement(By.id("selectmenu-item")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("speed-button")));
        driver.findElement(By.id("speed-button")).click();

        Random random = new Random();
        List<WebElement> options = driver.findElements(By.className("ui-menu-item"));
        int menuItem = random.nextInt(options.size());
        options.get(menuItem).click();

        ((JavascriptExecutor)driver).executeScript("jQuery('select').css('display','block')");
        Select files = new Select(driver.findElement(By.xpath(".//select[@id='files']")));
        files.selectByVisibleText("Some unknown file");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("number-button")));

        ((JavascriptExecutor)driver).executeScript("jQuery('select').css('display','block')");
        Select number = new Select(driver.findElement(By.xpath(".//select[@id='number']")));
        number.selectByIndex(6);

        wait.until(ExpectedConditions.elementToBeClickable(By.id("salutation-button")));
        driver.findElement(By.id("salutation-button")).click();

        List<WebElement> titleList = driver.findElements(By.cssSelector("#salutation-menu .ui-menu-item"));
        int randomOption=random.ints(1, titleList.size()).findFirst().getAsInt();
        titleList.get(randomOption).click();
    }
}
