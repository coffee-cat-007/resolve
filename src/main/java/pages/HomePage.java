package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static utils.WebElementUtils.checkButtonStatus;
import static utils.WebElementUtils.enterText;
import static utils.WebElementUtils.waitForElement;
import static utils.WebElementUtils.getElementXpath;

public class HomePage extends BasePage{

    @FindBy(id = "inputEmail")
    private WebElement usernameField;

    @FindBy(id = "inputPassword")
    private WebElement passwordField;

    @FindBy(css = ".form-signin .btn")
    private  WebElement submitButton;

    @FindBy(css = ".nav-link")
    private List<WebElement> navLinks;

    @FindBy(css = ".list-group-item")
    private List<WebElement> listItems;

    @FindBy(css = ".list-group-item .badge-pill")
    private List<WebElement> listBadgeValues;

    @FindBy(id = "dropdownMenuButton")
    private WebElement dropdownValue;

    @FindBy(css = ".dropdown-menu .dropdown-item")
    private List<WebElement> dropdownValues;

    @FindBy(css = "#test-4-div .btn-lg")
    private List<WebElement> module4Buttons;

    @FindBy(css ="#test-5-div .btn-lg")
    private WebElement module5Button;

    @FindBy(css = ".alert")
    private WebElement alertMessage;

    public HomePage() { PageFactory.initElements(driver, this); }

    public boolean checkUsernameField() {
        return this.usernameField.isDisplayed();
    }

    public boolean checkPasswordField() {
        return this.passwordField.isDisplayed();
    }

    public boolean checkSubmitButton() {
        return this.submitButton.isDisplayed();
    }

    public void enterUsername(String username) { enterText(usernameField, username); }

    public void enterPassword(String password) {
        enterText(passwordField, password);
    }

    public void navigatetoHomePage() {
        navLinks.get(0).click();
    }

    public void navigatetoGuidePage() {
        navLinks.get(1).click();
    }

    public int getListCount() {
        return listItems.size();
    }

    public String getListValue(int i) {
        return listItems.get(i).getText().replace(listBadgeValues.get(i).getText(), "").trim();
    }

    public int getListBadgeValue(int i) {
        return Integer.parseInt(listBadgeValues.get(i).getText());
    }

    public String getSelectedValue() {
        return dropdownValue.getText();
    }

    public boolean selectValueFromDropdown(String selectedDropdownValue) {
        dropdownValue.click();
        for(WebElement element:dropdownValues) {
            if(element.getText().equals(selectedDropdownValue)) {
                element.click();
                return true;
            }
        }
        return false;
    }

    public boolean checkModule4Buttons() {
        if(checkButtonStatus(module4Buttons.get(0))) {
            if(!checkButtonStatus(module4Buttons.get(1))) {
                return true;
            }
        }
        return false;
    }

    public String checkButtonMessage() {
        waitForElement(module5Button);
        module5Button.click();
        return alertMessage.getText();
    }

    public boolean checkdisabledButtonModule5() {
        return !checkButtonStatus(module5Button);
    }

    public String getValuefromTable(int i, int j) {
        return (driver.findElement(By.xpath(getElementXpath(i+1,j+1))).getText());
    }


}
