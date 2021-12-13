package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class RowPage {
    public RowPage(WebElement row) {
        PageFactory.initElements(new DefaultElementLocatorFactory(row), this);
    }

    @FindBy(css = "th")
    WebElement rank;

    @FindBy(css = "td")
    WebElement peak;

    @FindBy(xpath = "td[2]")
    WebElement mountainRange;

    @FindBy(xpath = "td[3]")
    WebElement state;

    @FindBy(xpath = "td[4]")
    WebElement height;

    public String getTextFromRank() {
        return rank.getText();
    }

    public String getTextFromPeak() {
        return peak.getText();
    }

    public String getTextFromMountainRange() {
        return mountainRange.getText();
    }

    public String getTextFromState() {
        return state.getText();
    }

    public int getTextFromHeight() {
        return Integer.parseInt(height.getText());
    }
}
