import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class TestBase {
    WebDriver driver;
    static Logger logger = LoggerFactory.getLogger(TestBase.class);
    Random random = new Random();

    @BeforeAll
    public static void setDriver() {
        WebDriverManager.chromedriver().setup();
        logger.info("WebDriver set up correctly");
    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://seleniumui.moderntester.pl/form.php");
        driver.manage().window().maximize();
        logger.info("Browser opened correctly");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
        logger.info("Driver teared down correctly");
    }
}