package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class TablePage {

    public TablePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "tbody tr")
    public static List<WebElement> table;

    public List<RowPage> createListOfRowPages() {
        List<RowPage> newList = new ArrayList<>();
        for (WebElement webElement : table) {
            newList.add(new RowPage(webElement));
        }
        return newList;
    }

    public void print() {
        for (RowPage rowPage : createListOfRowPages()) {
            if ((rowPage.getTextFromState().equals("Switzerland")) && (rowPage.getTextFromHeight() > 4000)) {
                System.out.println("Rank: " + rowPage.getTextFromRank() + ", Peak: " + rowPage.getTextFromPeak() + ", Mountain Range: "
                        + rowPage.getTextFromMountainRange());
            }
        }
    }
}

