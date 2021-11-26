import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class FormTest extends TestBase {

    @Test
    public void shouldFillFormWithSuccess() {
        String title = driver.getTitle();
        assertThat(title, equalTo("Automation Pratice")); // spelling mistake
        logger.info("Title is correct");

        WebElement firstName = driver.findElement(By.cssSelector("#inputFirstName3"));
        firstName.sendKeys("someFirstName");

        WebElement lastName = driver.findElement(By.cssSelector("#inputLastName3"));
        lastName.sendKeys("someLastName");

        WebElement email = driver.findElement(By.cssSelector("#inputEmail3"));
        email.sendKeys("someEmail@example.example");

        List<WebElement> gender = driver.findElements(By.cssSelector("fieldset:nth-child(4) > div > div  input"));
        int genderIndex = random.nextInt(gender.size());
        gender.get(genderIndex).click();

        WebElement age = driver.findElement(By.cssSelector("#inputAge3"));
        age.sendKeys("26");

        List<WebElement> yearsOfExperience = driver.findElements(By.cssSelector("fieldset:nth-child(6) > div > div input"));
        int YearsOfExperienceIndex = random.nextInt(yearsOfExperience.size());
        yearsOfExperience.get(YearsOfExperienceIndex).click();

        WebElement profession = driver.findElement(By.cssSelector("fieldset:nth-child(7) > div > div > div:nth-child(2) input"));
        profession.click();

        Select continents = new Select(driver.findElement(By.id("selectContinents")));
        continents.selectByValue("europe");

        Select seleniumCommands = new Select(driver.findElement(By.id("selectSeleniumCommands")));
        seleniumCommands.selectByIndex(2);
        seleniumCommands.selectByIndex(3);

        File file = new File("src/test/resources/someFileForTest.txt");
        WebElement addFile = driver.findElement(By.id("chooseFile"));
        addFile.sendKeys(file.getAbsolutePath());
        logger.info("File uploaded correctly");

        WebElement signInButton = driver.findElement(By.cssSelector(".needs-validation div:nth-child(13) button"));
        signInButton.click();

        WebElement confirmMessage = driver.findElement(By.id("validator-message"));
        assertThat(confirmMessage.getText(), equalTo("Form send with success"));
        logger.info("Confirmation message appeared");
    }
}
