package ModalDialog;

import Alerts.TestBase;
import com.tngtech.java.junit.dataprovider.DataProvider;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ModalDialogClass extends TestBase {

    @DataProvider
    public static Object[][] provideDataToCreateNewUser() {
        return new Object[][]{
                {"Janek Kowalski", "kowalskiMail@pl", "12345"}
        };
    }

    @ParameterizedTest
    @MethodSource("provideDataToCreateNewUser")
    public void createNewUser(String a, String b, String c) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li:nth-child(3)")));
        driver.findElement(By.cssSelector("li:nth-child(3)")).click();
        driver.findElement(By.id("modal-dialog-item")).click();

        WebElement tableBeforeNewUser = driver.findElement(By.id("users"));
        System.out.println("\nTable before creating new user: " + "\n" + tableBeforeNewUser.getText());

        wait.until(ExpectedConditions.elementToBeClickable(By.id("create-user")));
        driver.findElement(By.id("create-user")).click();

        WebElement name = driver.findElement(By.id("name"));
        name.clear();
        name.sendKeys(a);

        WebElement email = driver.findElement(By.id("email"));
        email.clear();
        email.sendKeys(b);

        WebElement password = driver.findElement(By.id("password"));
        password.clear();
        password.sendKeys(c);

        driver.findElement(By.cssSelector(".ui-dialog-buttonset button")).click();

        WebElement tableAfterNewUser = driver.findElement(By.id("users"));
        System.out.println("\nTable after creating new user: " + "\n" + tableAfterNewUser.getText());

        WebElement nameInTable = driver.findElement(By.cssSelector("[id='users'] tr:nth-child(2) td:first-child"));

        WebElement emailInTable = driver.findElement(By.cssSelector("[id='users'] tr:nth-child(2) td:nth-child(2)"));

        WebElement passwordInTable = driver.findElement(By.cssSelector("[id='users'] tr:nth-child(2) td:last-child"));

        assertThat(nameInTable.getText(), equalTo("Janek Kowalski"));
        assertThat(emailInTable.getText(), equalTo("kowalskiMail@pl"));
        assertThat(passwordInTable.getText(), equalTo("12345"));
    }
}