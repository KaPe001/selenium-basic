package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;
import java.util.Random;

public class MenuPage {
    Random random = new Random();

    public MenuPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#inputFirstName3")
    private WebElement firstNameInput;

    @FindBy(css = "#inputLastName3")
    private WebElement lastNameInput;

    @FindBy(css = "#inputEmail3")
    private WebElement emailInput;

    @FindBy(css = "[name='gridRadiosSex']")
    private List<WebElement> genderRadio;

    @FindBy(css = "#inputAge3")
    private WebElement ageInput;

    @FindBy(name = "gridRadiosExperience")
    private List<WebElement> yearsOfExperience;

    @FindBy(css = "#gridCheckAutomationTester")
    private WebElement professionBtn;

    @FindBy(css = "#selectContinents")
    private WebElement continentsSelect;

    @FindBy(css = "#selectSeleniumCommands")
    private WebElement commandsSelect;

    @FindBy(css = "#chooseFile")
    private WebElement addFile;

    @FindBy(css = ".btn-primary")
    private WebElement signInBtm;

    @FindBy(css = "#validator-message")
    private WebElement validationMsg;

    public MenuPage getBasicUserInfo(String name, String lastName, String email) {
        firstNameInput.sendKeys(name);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        return this;
    }

    public MenuPage getUserGender() {
        int randomGender = random.nextInt(genderRadio.size());
        genderRadio.get(randomGender).click();
        return this;
    }

    public MenuPage getUserAge(String age) {
        ageInput.sendKeys(age);
        return this;
    }

    public MenuPage getUserYearsOfExperience() {
        int randomValueOfYears = random.nextInt(yearsOfExperience.size());
        yearsOfExperience.get(randomValueOfYears).click();
        return this;
    }

    public MenuPage getUserProfession() {
        professionBtn.click();
        return this;
    }

    public MenuPage selectUserContinent(String continent) {
        new Select(continentsSelect).selectByValue(continent);
        return this;
    }

    public MenuPage selectSeleniumCommands(int index) {
        new Select(commandsSelect).selectByIndex(index);
        return this;
    }

    public MenuPage addNewFile(String path) {
        File file = new File(path);
        addFile.sendKeys(file.getAbsolutePath());
        return this;
    }

    public MenuPage signUserIn() {
        signInBtm.click();
        return this;
    }

    public void getValidationMessage() {
        Assert.assertEquals("Form send with success", validationMsg.getText());
        validationMsg.getText();
    }
}