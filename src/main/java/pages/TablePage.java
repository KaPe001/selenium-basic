package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TablePage {

    public TablePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "tbody tr")
    //private List<RowPage> table;
    private List<WebElement> table;

    public void printPeaksInSwitzerlandHigherThan4000() {
        //for (RowPage row : table) {
        for(WebElement webElement : table){

            String rank = webElement.findElement(By.cssSelector("tr th")).getText();
            String peak = webElement.findElement(By.cssSelector("td")).getText();
            String mountainRange = webElement.findElement(By.xpath("td[2]")).getText();
            String state = webElement.findElement(By.xpath("td[3]")).getText();
            int height = Integer.parseInt(webElement.findElement(By.xpath("td[4]")).getText());

            if (state.equals("Switzerland") && height > 4000) {
                System.out.println("Rank: " + rank + " Peak: " + peak + " Mountain Range: "
                        + mountainRange);
            }
        }
    }
}
