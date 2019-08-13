package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;
import utils.Config;
import utils.DriverFactory;

import java.nio.file.Path;
import java.nio.file.Paths;

import static utils.Config.USERNAME;
import static utils.Config.PASSWORD;

public class HomePageTest {

    public HomePage homePage;
    public GuidePage guidePage;

    @BeforeTest(alwaysRun = true)
    public void setUp(){
        WebDriver driver=DriverFactory.getDriver();
        final String dir = System.getProperty("user.dir");
        String baseUrl = dir + "/src/main/resources/" + Config.URL;
        Path urlPath = Paths.get(baseUrl);
        driver.get("file:\\\\\\" + urlPath);
        homePage = new HomePage();
    }

    @Test (description = "Test 1 :: verify the username, password field and login button in module 1")
    public void verifySimpleLogin() throws Exception {
        homePage.navigatetoHomePage();
        Assert.assertTrue(homePage.checkUsernameField());
        Assert.assertTrue(homePage.checkPasswordField());
        Assert.assertTrue(homePage.checkSubmitButton());
        homePage.enterUsername(USERNAME);
        homePage.enterPassword(PASSWORD);
    }

    @Test (description = "Test 2 :: verify the list values in module 2")
    public void verifyList() throws Exception {
        homePage.navigatetoHomePage();
        Assert.assertEquals(homePage.getListCount(), 3);
        Assert.assertEquals(homePage.getListValue(1), "List Item 2");
        Assert.assertEquals(homePage.getListBadgeValue(1),6 );
    }

    @Test (description = "Test 3 :: verify the dropdown in module 3")
    public void verifyDropDown() throws Exception {
        homePage.navigatetoHomePage();
        Assert.assertEquals(homePage.getSelectedValue(), "Option 1");
        Assert.assertTrue(homePage.selectValueFromDropdown("Option 3"));
        Assert.assertEquals(homePage.getSelectedValue(), "Option 3");
    }

    @Test (description = "Test 4 :: verify the enabled and disabled buttons in module 4")
    public void verifyButtonsModule4() throws Exception {
        homePage.navigatetoHomePage();
        Assert.assertTrue(homePage.checkModule4Buttons());
    }

    @Test (description = "Test 5 :: verify the messages and buttons in module 5")
    public void verifyMessageModule5() throws Exception {
        homePage.navigatetoHomePage();
        Assert.assertNotNull(homePage.checkButtonMessage());
        Assert.assertTrue(homePage.checkdisabledButtonModule5());
    }

    @Test (description = "Test 6 :: validate the table in module 6")
    public void verifyTableModule6() throws Exception {
        homePage.navigatetoHomePage();
        Assert.assertEquals(homePage.getValuefromTable(2,2), "Ventosanzap");
    }

    @AfterTest(alwaysRun = true)
    public void tearDown(){
        DriverFactory.closeDriver();

    }

}
