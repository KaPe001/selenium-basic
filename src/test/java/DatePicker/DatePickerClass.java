package DatePicker;

import Alerts.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class DatePickerClass extends TestBase {

    @Test
    public void pickADate() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li:nth-child(3)")));

        driver.findElement(By.cssSelector("li:nth-child(3)")).click();
        driver.findElement(By.id("datepicker-item")).click();

        WebElement dateBox = driver.findElement(By.id("datepicker"));
        dateBox.click();

        String currentDate = new SimpleDateFormat("MM/dd/yyyy").format(new Date());

        WebElement todayDate = driver.findElement(By.className("ui-state-highlight"));
        todayDate.click();
        assertThat(currentDate, equalTo(dateBox.getAttribute("value")));

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        dateBox.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.className("ui-datepicker-calendar")));
        driver.findElement(By.className("ui-icon-circle-triangle-e")).click();
        driver.findElement(By.cssSelector("#ui-datepicker-div tr:nth-child(1) td:nth-child(7)")).click();
        assertThat(dateBox.getAttribute("value"), equalTo("01/01/2022"));

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        dateBox.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.className("ui-datepicker-calendar")));
        driver.findElement(By.cssSelector("#ui-datepicker-div tr:nth-child(6) > td:nth-child(2)")).click();
        assertThat(dateBox.getAttribute("value"), equalTo("01/31/2022"));

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        dateBox.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.className("ui-datepicker-calendar")));
        driver.findElement(By.className("ui-state-active")).click();
        dateBox.getAttribute("value");
        assertThat(dateBox.getAttribute("value"), equalTo("01/31/2022"));

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        dateBox.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.className("ui-datepicker-calendar")));
        driver.findElement(By.className("ui-icon-circle-triangle-w")).click();

        randomDayFromCalendar();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        dateBox.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.className("ui-icon-circle-triangle-w")));
        goToPreviousYearAndGetRandomMonth();
        randomDayFromCalendar();
    }

    public void clickTheArrow(int randomClickAmount){
        for(int i = 0; i < randomClickAmount; i++){
            driver.findElement(By.className("ui-icon-circle-triangle-w")).click();
        }
    }
    public void goToPreviousYearAndGetRandomMonth(){
        int randomMonth;
        randomMonth = ThreadLocalRandom.current().nextInt(0,12);

        while (!driver.findElement(By.className("ui-datepicker-year")).getText().equals("2020")) {
            driver.findElement(By.className("ui-icon-circle-triangle-w")).click();
        }
        clickTheArrow(randomMonth);
    }

    public void randomDayFromCalendar(){
        List<WebElement> calendar = driver.findElements(By.cssSelector(".ui-datepicker-calendar tbody tr"));
        int size = calendar.size();
        int randomDate = ThreadLocalRandom.current().nextInt(0, size);
        calendar.get(randomDate).click();
    }
}