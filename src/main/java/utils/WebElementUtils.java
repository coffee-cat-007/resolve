package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

public class WebElementUtils extends BasePage {

    public static void enterText(WebElement element, String text){
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public static void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static boolean checkButtonStatus(WebElement button) {
        if(button.isEnabled()) {
            return true;
        } else {
            return false;
        }
    }

    public static String getElementXpath(int i, int j) {
        return "//*[@id=\"test-6-div\"]/div/table/tbody/tr[" + i + "]/td[" + j + "]";
    }


}
