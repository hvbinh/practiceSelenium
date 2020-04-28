package Objects;

import Supports.Browsers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;

public class LogInObject extends LoadableComponent<LogInObject> {

    public LogInObject()
    {
        PageFactory.initElements(Browsers.getDriver(), this);
    }

    @Override
    public void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }
    //expose element
    @FindBy(linkText ="Log in")
    WebElement login_link;
    @FindBy(id = "user_login")
    WebElement userName_txt;
    @FindBy(id="user_pass")
    WebElement password_txt;
    @FindBy(id="wp-submit")
    WebElement LogIn_btn;
    @FindBy(id = "admin_color_coffee")
    WebElement coffeeColor_bar;
    @FindBy(xpath = "//div/input[@id='admin_bar_front']")
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
    @FindBy(className = "ab-item")
    WebElement userName_menu;
    @FindBy(linkText = "Edit My Profile")
    WebElement link_txt;

    public void check()
    {
        if(!checkbox_btn.isSelected())
        {
            checkbox_btn.click();
        }
        else
        {
            checkbox_btn.click();
        }
    }

    public void loadPage()
    {
        Browsers.getDriver().get("https://kiemthutudong.com/blog");
    }
    public void login()
    {
        login_link.click();
        userName_txt.sendKeys("binhha");
        password_txt.sendKeys("12345678x@X");
        LogIn_btn.click();
        //return  Browsers.getDriver().getTitle();

    }
    public void updateProfile()
    {
        /*Actions act = new Actions(Browsers.getDriver());
        act.moveToElement(userName_menu).click(link_txt).perform();
        coffeeColor_bar.click();*/
        check();
        firstName_txt.sendKeys("Binh");
        lastName_txt.sendKeys("Ha");
        Select select = new Select(selectName_dropdown);
        select.selectByVisibleText("binhha;a");
        url.sendKeys("abc.com");
        area_txt.sendKeys("this is text area");
        submit_btn.click();
    }


}
