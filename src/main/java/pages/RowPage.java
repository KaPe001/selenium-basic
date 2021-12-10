package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class RowPage {
    public RowPage(WebElement row){
        PageFactory.initElements(new DefaultElementLocatorFactory(row), this);
    }
}
