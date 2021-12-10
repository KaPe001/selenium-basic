package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainFormPage {
    public MainFormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".dropdown:first-child")
    private WebElement basicBtn;

    @FindBy(id = "table-item")
    private WebElement tableBtn;

    public void goToTablePage() {
        basicBtn.click();
        tableBtn.click();
    }
}
