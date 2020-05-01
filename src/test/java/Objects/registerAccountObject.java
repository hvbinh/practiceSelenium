package Objects;

import Supports.Browsers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class registerAccountObject extends LoadableComponent<registerAccountObject> {
    public registerAccountObject()
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
    @FindBy(xpath = "//a[contains(text(),'Create New Account')]")
    WebElement createNewAccount_btn;
    @FindBy(id="user_login")
    WebElement userName_textfield;
    @FindBy(id="user_email")
    WebElement email_textfield;
    @FindBy(id="wp-submit")
    WebElement register_button;
    @FindBy(xpath = "//p[@class='message']")
    WebElement successMessage_text;

    public String registerNewAccount()
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyymmddhhmmss");
        Calendar calendar = Calendar.getInstance();
        String dateTime = dateFormat.format(calendar.getTime());

        createNewAccount_btn.click();
        userName_textfield.sendKeys("test"+dateTime);
        email_textfield.sendKeys("test"+dateTime+"@email.com");
        register_button.click();

        return successMessage_text.getText();

    }



}
