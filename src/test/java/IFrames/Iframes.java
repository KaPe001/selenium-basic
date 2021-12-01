package IFrames;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Iframes extends TestBase {

    @Test
    public void goingThroughIframes() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement basic = driver.findElement(By.cssSelector(".dropdown:first-child"));
        basic.click();

        driver.findElement(By.id("iframes-item")).click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".display-4")));

        driver.switchTo().frame("iframe1");
        WebElement firstName = driver.findElement(By.id("inputFirstName3"));
        firstName.sendKeys("Janusz");

        WebElement lastName = driver.findElement(By.id("inputSurname3"));
        lastName.sendKeys("Kowalski");

        WebElement signInButton = driver.findElement(By.cssSelector(".btn-primary"));
        signInButton.click();

        driver.switchTo().defaultContent();

        driver.switchTo().frame("iframe2");
        WebElement login = driver.findElement(By.id("inputLogin"));
        login.sendKeys("Janusz");

        WebElement password = driver.findElement(By.id("inputPassword"));
        password.sendKeys("randomPassword");

        Select continents = new Select(driver.findElement(By.id("inlineFormCustomSelectPref")));
        continents.selectByValue("europe");

        WebElement yearsOfExperience = driver.findElement(By.id("gridRadios7")); //bug
        yearsOfExperience.click();

        WebElement submit = driver.findElement(By.cssSelector(".btn-primary"));
        submit.click();

        driver.switchTo().parentFrame();
        logger.info("Driver back in a parent frame");

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".dropdown:first-child")));
        driver.findElement(By.cssSelector(".dropdown:first-child")).click();
    }
}
