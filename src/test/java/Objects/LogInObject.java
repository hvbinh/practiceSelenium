package Objects;

import Supports.Browsers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
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
        Browsers.getDriver().get("https://kiemthutudong.com/blog");
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
    public String updateProfile(String color, boolean b, String firstName, String lastName, String displayName, String webSite, String biographyInfo)
    {

        adminColorScheme(color);
        checkToolbar(b);
        setFirstName(firstName);
        setLastName(lastName);
        Select select = new Select(selectName_dropdown);
        displayNamePublicky(displayName);
        webSite(webSite);
        biographicalInfo(biographyInfo);
        submit_btn.click();
        return profile_message.getText();
    }
    public String reSetProfile()
    {
        adminColorScheme("Default");
        checkToolbar(true);
        firstName_txt.clear();
        lastName_txt.clear();
        url.clear();
        area_txt.clear();
        submit_btn.click();
        return profile_message.getText();
    }
    public void adminColorScheme(String color)
    {
           Browsers.getElement(How.XPATH,String.format("//div/label[.='%s']/preceding-sibling::input[@type='radio']", color)).click();
    }
    public void checkToolbar(boolean b)
    {
        if(b==true)
        {
            if(!checkbox_btn.isSelected())
            {
                checkbox_btn.click();
            }
        }
        else if(b==false)
        {
            if(checkbox_btn.isSelected())
            {
                checkbox_btn.click();
            }
        }
    }
    public void setFirstName(String firstName)
    {
        firstName_txt.sendKeys(firstName);
    }
    public void setLastName(String lastName)
    {
        firstName_txt.sendKeys(lastName);
    }
    public void displayNamePublicky(String displayName)
    {
        Select select = new Select(selectName_dropdown);
        select.selectByVisibleText(displayName);
    }
    public void webSite(String str)
    {
        url.sendKeys(str);
    }
    public void biographicalInfo(String str)
    {
        area_txt.sendKeys(str);
    }



}
