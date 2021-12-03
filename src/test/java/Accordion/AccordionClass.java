package Accordion;

import Alerts.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

public class AccordionClass extends TestBase {

    @Test
    public void openSectionsAndPrintOutMessage(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li:nth-child(3)")));
        driver.findElement(By.cssSelector("li:nth-child(3)")).click();
        driver.findElement(By.id("accordion-item")).click();

        WebElement firstText = driver.findElement(By.id("ui-id-2"));
        System.out.println("First text = " + firstText.getText());
        logger.info("First text printed out correctly");

        driver.findElement(By.id("ui-id-3")).click();

        WebElement secondText = driver.findElement(By.id("ui-id-4"));
        System.out.println("\nSecond text = " + secondText.getText());
        logger.info("Second text printed out correctly");

        driver.findElement(By.id("ui-id-5")).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("ui-id-6")));
        WebElement thirdTextP = driver.findElement(By.cssSelector("[id='ui-id-6'] p"));
        System.out.println("\nThird text = " + thirdTextP.getText());

        List<WebElement> thirdTextUl = driver.findElements(By.cssSelector("[id='ui-id-6'] ul"));
        for (WebElement webElement : thirdTextUl) {
            System.out.println(webElement.getText());
        }

        logger.info("Third text printed out correctly");

        driver.findElement(By.id("ui-id-7")).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("ui-id-8")));
        WebElement fourthText = driver.findElement(By.id("ui-id-8"));
        System.out.println("\nFourth text = " + fourthText.getText());
        logger.info("Fourth text printed out correctly");
    }
}
