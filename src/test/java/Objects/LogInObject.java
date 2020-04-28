package Objects;

import Supports.Browsers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

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

    public String login()
    {
        login_link.click();
        userName_txt.sendKeys("binhha");
        password_txt.sendKeys("12345678x@X");
        LogIn_btn.click();
        return  Browsers.getDriver().getTitle();

    }


}
