package Def;

import Supports.Browsers;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

public class MyStepdefsLogin  {

    By login_link = By.linkText("Log in");
    By userName_txt = By.id("user_login");
    By password_txt = By.id("user_pass");
    By LogIn_btn= By.id("wp-submit");
    @FindBy(id = "admin_color_coffee")
    WebElement coffeeColor_bar;
    @FindBy(xpath = "//input[@id='admin_bar_front']")
    WebElement checkbox_btn;
    @FindBy(id="first_name")
    WebElement firstName_txt;
    @FindBy(id="last_name")
    WebElement lastName_txt;
    @FindBy(id="display_name")
    WebElement selectName_dropdown;
    @FindBy(id = "url")
    WebElement url;
    @FindBy(id="description")
    WebElement area_txt;
    @FindBy(id="submit")
    WebElement submit_btn;
    @FindBy(xpath = "//div[@id='message']/p/strong")
    WebElement profile_message;


    @Given("^i am on login page$")
    public void iAmOnLoginPage() {
    Browsers.open("chrome");
    Browsers.getDriver().get("https://kiemthutudong.com/blog");
    Browsers.getDriver().findElement(login_link).click();


    }

    @When("^i input username$")
    public void iInputUsername() {
        Browsers.getDriver().findElement(userName_txt).sendKeys("binhha");
    }

    @And("^i input password$")
    public void iInputPassword() {
        Browsers.getDriver().findElement(password_txt).sendKeys("12345678x@X");
    }

    @And("^i click on submit button$")
    public void iClickOnSubmitButton() {
        Browsers.getDriver().findElement(LogIn_btn).click();
    }

    @When("^the system navigate to Home app$")
    public void theSystemNavigateToHomeApp() {
        String actual = Browsers.getDriver().getTitle();
        String expected = "Profile ‹ Automation Blog — WordPress";
        Assert.assertEquals(actual, expected);
    }


}
