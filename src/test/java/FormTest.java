import org.junit.jupiter.api.Test;
import pages.MenuPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class FormTest extends TestBase {

    @Test
    public void shouldFillFormWithSuccess() {
        String title = driver.getTitle();
        assertThat(title, equalTo("Automation Pratice")); // spelling mistake
        logger.info("Title is correct");

        new MenuPage(driver)
                .getBasicUserInfo("Jan", "Kowalski", "jan.kowalski@email.com")
                .getUserGender()
                .getUserAge("30")
                .getUserYearsOfExperience()
                .getUserProfession()
                .selectUserContinent("europe")
                .selectSeleniumCommands(2)
                .selectSeleniumCommands(3)
                .addNewFile("src/test/resources/someFileForTest.txt")
                .signUserIn()
                .getValidationMessage();
    }
}