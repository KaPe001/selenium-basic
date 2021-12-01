package Sliders;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class Slider extends TestBase{

    @Test
    public void letsSlide(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("ul li:nth-child(3)")));
        driver.findElement(By.cssSelector("ul li:nth-child(3)")).click();

        driver.findElement(By.id("slider-item")).click();
        WebElement slider = driver.findElement(By.id("custom-handle"));
        for(int i = 1; i <= 50; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
        assertThat(slider.getText(), equalTo("50"));
        logger.info("Slider on a position 50");

        try{
            Thread.sleep(1000);
        }catch(Exception e){
            e.printStackTrace();
        }

        for(int i = 50; i <= 79; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
        assertThat(slider.getText(), equalTo("80"));
        logger.info("Slider on a position 80");

        try{
            Thread.sleep(1000);
        }catch(Exception e){
            e.printStackTrace();
        }

        for(int i = 79; i >= 20; i--){
            slider.sendKeys(Keys.ARROW_LEFT);
        }
        assertThat(slider.getText(), equalTo("20"));
        logger.info("Slider on a position 20");

        try{
            Thread.sleep(1000);
        }catch(Exception e){
            e.printStackTrace();
        }

        for(int i = 19; i >= 0; i--){
            slider.sendKeys(Keys.ARROW_LEFT);
        }
        assertThat(slider.getText(), equalTo("0"));
        logger.info("Slider on a position 0");
    }

}
