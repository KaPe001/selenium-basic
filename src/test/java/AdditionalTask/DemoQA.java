package AdditionalTask;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class DemoQA {
    WebDriver driver;
    public static Logger logger = LoggerFactory.getLogger(DemoQA.class);

    @BeforeAll
    public static void setUpDriver() {
        WebDriverManager.chromedriver().setup();
        logger.info("Driver set up correctly");
    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @RepeatedTest(10)
    public void fillTheForm() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        Random random = new Random();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement closeTheAd = driver.findElement(By.id("close-fixedban"));
        closeTheAd.click();

        WebElement subjects = driver.findElement(By.cssSelector("#userForm .subjects-auto-complete__control"));
        subjects.click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#userForm .subjects-auto-complete__control--is-focused")));

        WebElement subjectsInput = driver.findElement(By.cssSelector("#userForm .subjects-auto-complete__input input"));
        js.executeScript("arguments[0].value='M';", subjectsInput);
        subjectsInput.sendKeys("a");

        wait.until(ExpectedConditions.elementToBeClickable(By.className("subjects-auto-complete__menu")));
        WebElement autocompleteMenu = driver.findElement(By.className("subjects-auto-complete__menu"));
        autocompleteMenu.click();

        WebElement confirmFirstInput = driver.findElement(By.className("subjects-auto-complete__multi-value__label"));
        assertThat(confirmFirstInput.getText(), equalTo("Maths"));
        WebElement elements = driver.findElement(By.className("subjects-auto-complete__value-container"));
        System.out.println("After first option selected: \n" + elements.getText());

        subjectsInput.sendKeys("c");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("subjects-auto-complete__menu")));

        List<WebElement> menuListAutoComplete = driver.findElements(By.className("subjects-auto-complete__option"));
        int option = random.nextInt(menuListAutoComplete.size());
        menuListAutoComplete.get(option).click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("subjects-auto-complete__multi-value__label")));
        System.out.println("After second option selected: \n" + elements.getText());

        subjectsInput.sendKeys("a");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("subjects-auto-complete__option")));
        List<WebElement> newList = driver.findElements(By.className("subjects-auto-complete__option"));
        int newOption = random.nextInt(newList.size());
        newList.get(newOption).click();
        System.out.println("After third option selected: \n" + elements.getText());

        WebElement deleteLastOne = driver.findElement(By.cssSelector(".subjects-auto-complete__multi-value:nth-child(3) .subjects-auto-complete__multi-value__remove"));
        deleteLastOne.click();
        System.out.println("After deleting last option: \n" + elements.getText());

        WebElement deleteAll = driver.findElement(By.className("subjects-auto-complete__indicator"));
        deleteAll.click();
        System.out.println("After deleting all options: \n" + elements.getText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
        logger.info("Driver tore down correctly");
    }
}