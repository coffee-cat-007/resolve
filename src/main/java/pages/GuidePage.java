package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GuidePage extends BasePage {

    @FindBy(className = "search-input")
    private WebElement search;
}
