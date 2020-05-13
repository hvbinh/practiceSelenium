package Objects;

import Supports.Browsers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class OrderProductObject extends LoadableComponent<OrderProductObject> {

    public OrderProductObject()
    {
        PageFactory.initElements(Browsers.getDriver(), this);
    }

    @Override
    public void load() {
        Browsers.getDriver()
                .get("http://automationpractice.com/index.php?fbclid=IwAR39QNaOjORVKIIaWMBuP59YAhn1DOL_rDkNVJX2HeBJ09AqCKe2zQxfkgI");
    }

    @Override
    protected void isLoaded() throws Error {

    }
    //expose element
    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    WebElement proceedToCheckOut1_button;
    @FindBy(xpath = "//p[@class='cart_navigation clearfix']/a[@title='Proceed to checkout']")
    WebElement proceedToCheckOut2_button;
    @FindBy(id="email_create")
    WebElement emailAddress_textfield;
    @FindBy(id="SubmitCreate")
    WebElement createAccount_button;
    @FindBy(xpath="//input[@id='id_gender1']")
    WebElement mrGender_radio;
    @FindBy(id="customer_firstname")
    WebElement firstName_textfield;
    @FindBy(id="customer_lastname")
    WebElement lastName_textfield;
    @FindBy(id="passwd")
    WebElement passWord_Textfield;
    @FindBy(id="days")
    WebElement day_dropdown;
    @FindBy(id="months")
    WebElement month_dropdown;
    @FindBy(id="years")
    WebElement year_dropdown;
    @FindBy(id="newsletter")
    WebElement receiveNewLetter_checkbox;
    @FindBy(id="optin")
    WebElement receiveSpecialOffer_checkbox;
    @FindBy(id="firstname")
    WebElement firstName1_textfield;
    @FindBy(id="lastname")
    WebElement lastName1_textfield;
    @FindBy(id="company")
    WebElement company_textfield;
    @FindBy(id="address1")
    WebElement address1_textfield;
    @FindBy(id="address2")
    WebElement address2_textfield;
    @FindBy(id="city")
    WebElement city_textfield;
    @FindBy(id="id_state")
    WebElement state_dropdown;
    @FindBy(id="postcode")
    WebElement postalCode_textfield;
    @FindBy(id="phone_mobile")
    WebElement mobilePhone_textfield;
    @FindBy(id="alias")
    WebElement addressAlias_textfield;
    @FindBy(id="submitAccount")
    WebElement register_button;
    @FindBy(xpath = "//button[@type='submit']/span[contains(text(),'Proceed to checkout')]")
    WebElement proceedToCheckOut3_button;
    @FindBy(id = "cgv")
    WebElement agree_checkbox;
    @FindBy(xpath = "//button[@type='submit']/span[contains(text(),'Proceed to checkout')]")
    WebElement proceedToCheckOut4_button;
    @FindBy(xpath = "//a[@title='Pay by check.']")
    WebElement payMyCheck_option;
    @FindBy(xpath = "//button[@type='submit']/span[.='I confirm my order']")
    WebElement confirmOrder_button;
    @FindBy(xpath = "//p[@class='alert alert-success']")
    WebElement success_message;
    @FindBy(id = "search_query_top")
    WebElement search_textfield;
    @FindBy(xpath = "//button[@class='btn btn-default button-search']")
    WebElement search_button;
    @FindBy(id="email")
    WebElement email_textfield;
    @FindBy(id="SubmitLogin")
    WebElement signIn_button;
    @FindBy(xpath="//a[@title='Back to orders']")
    WebElement backToOrder_link;
    @FindBy(xpath = "//span[contains(text(),'Home')]")
    WebElement home_button;
    @FindBy(xpath = "//a[@class='login']")
    WebElement signIn_link;
    @FindBy(xpath = "//a[@title='Information']")
    WebElement personalInfo_link;
    @FindBy(xpath = "//input[@id='old_passwd']")
    WebElement currentPass_textfield;
    @FindBy(xpath = "//input[@id='confirmation']")
    WebElement confirmPass_textfield;
    @FindBy(xpath = "//button[@name='submitIdentity']")
    WebElement save_button;
    @FindBy(xpath = "//ul[@class='footer_links clearfix']//a[1]")
    WebElement backToYourAccount_link;




    public WebElement productName(String name)
    {
       return Browsers.getDriver().findElement(By.xpath(String.format("//a[@title='%s']", name)));
    }


    public List<WebElement> productList()
    {
        return  Browsers.getDriver().findElements(By.xpath("//div[@class='tab-content']/ul[@id='homefeatured']/li"));
    }
    public void addToCart(WebElement e)
    {
        e.findElement(By.xpath("//span[contains(text(),'Add to cart')]")).click();
    }

    public String orderProduct(String name)
    {
        Actions act = new Actions(Browsers.getDriver());
        WebElement e = productName("Blouse");
        act.moveToElement(e).perform();
        e.findElement(By.xpath("//a[@title='Blouse']/../../../..//a[@class='button ajax_add_to_cart_button btn btn-default']")).click();
        WebDriverWait wait = new WebDriverWait(Browsers.getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Proceed to checkout']")));
        proceedToCheckOut1_button.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='cart_navigation clearfix']/a[@title='Proceed to checkout']")));
        proceedToCheckOut2_button.click();


        /*DateFormat dateFormat = new SimpleDateFormat("yyyymmddHHmmss");
        Calendar cal = Calendar.getInstance();
        String time = dateFormat.format(cal.getTime());*/

        emailAddress_textfield.sendKeys("testabc1@test.com");

        createAccount_button.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='id_gender1']")));
        inputRegisterForm();

        proceedToCheckOut3_button.click();

        agree_checkbox.click();

        proceedToCheckOut4_button.click();

        payMyCheck_option.click();

        confirmOrder_button.click();

        return success_message.getText();


    }
    public void inputRegisterForm()
    {
        mrGender_radio.click();
        firstName_textfield.sendKeys("first name");
        lastName_textfield.sendKeys("last name");
        passWord_Textfield.sendKeys("123456");
        Select day = new Select(day_dropdown);
        day.selectByValue("5");
        Select month = new Select(month_dropdown);
        month.selectByValue("6");
        Select year = new Select(year_dropdown);
        year.selectByValue("1990");
        receiveNewLetter_checkbox.click();
        receiveSpecialOffer_checkbox.click();

        firstName1_textfield.sendKeys("Tony");
        lastName1_textfield.sendKeys("Ferguson");
        company_textfield.sendKeys("UFC");
        address1_textfield.sendKeys("Califonia");
        city_textfield.sendKeys("Arizona");
        Select state = new Select(state_dropdown);
        state.selectByValue("3");
        postalCode_textfield.sendKeys("12345");
        mobilePhone_textfield.sendKeys("0542345890");
        addressAlias_textfield.clear();
        addressAlias_textfield.sendKeys("my test");
        addressAlias_textfield.clear();
        addressAlias_textfield.sendKeys("only test");
        register_button.click();
    }
    public String searchOrderProduct(String name)
    {
        JavascriptExecutor js = (JavascriptExecutor) Browsers.getDriver();
        search_textfield.sendKeys(name);
        search_button.click();
        WebDriverWait wait = new WebDriverWait(Browsers.getDriver(), 20);
        Actions act = new Actions(Browsers.getDriver());
        WebElement e = productName(name);
        wait.until(ExpectedConditions.visibilityOf(e));

        act.moveToElement(e).perform();
        e.findElement(By.xpath(String.format("//a[@title='%s']/../../../..//a[@class='button ajax_add_to_cart_button btn btn-default']",name))).click();
        wait.until(ExpectedConditions.visibilityOf(proceedToCheckOut1_button));
        proceedToCheckOut1_button.click();
        wait.until(ExpectedConditions.visibilityOf(proceedToCheckOut2_button));
        proceedToCheckOut2_button.click();

        email_textfield.sendKeys("testabc1@test.com");
        passWord_Textfield.sendKeys("123456");
        signIn_button.click();

        wait.until(ExpectedConditions.visibilityOf(proceedToCheckOut3_button));
        proceedToCheckOut3_button.click();

        wait.until(ExpectedConditions.visibilityOf(proceedToCheckOut4_button));
        agree_checkbox.click();
        proceedToCheckOut4_button.click();

        wait.until(ExpectedConditions.visibilityOf(payMyCheck_option));
        payMyCheck_option.click();

        wait.until(ExpectedConditions.visibilityOf(confirmOrder_button));
        confirmOrder_button.click();


        //js.executeScript("window.scrollBy(0,1000)");
        wait.until(ExpectedConditions.visibilityOf(backToOrder_link));
        backToOrder_link.click();


        //js.executeScript("window.scrollBy(0,1000)");
        wait.until(ExpectedConditions.visibilityOf(home_button));
        home_button.click();

        return Browsers.getDriver().getTitle();


    }
    public String updateProfile()
    {
        signIn_link.click();
        WebDriverWait wait = new WebDriverWait(Browsers.getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOf(email_textfield));
        email_textfield.sendKeys("testabc1@test.com");
        passWord_Textfield.sendKeys("1234567");
        signIn_button.click();
        wait.until(ExpectedConditions.visibilityOf(personalInfo_link));
        personalInfo_link.click();
        firstName1_textfield.clear();
        firstName1_textfield.sendKeys("Tony a");
        lastName1_textfield.clear();
        lastName1_textfield.sendKeys("Fer a");
        Select day = new Select(day_dropdown);
        day.selectByValue("1");
        Select month = new Select(month_dropdown);
        month.selectByValue("5");
        Select year = new Select(year_dropdown);
        year.selectByValue("1980");
        currentPass_textfield.sendKeys("1234567");
        passWord_Textfield.sendKeys("12345678");
        confirmPass_textfield.sendKeys("12345678");
        receiveNewLetter_checkbox.click();
        receiveNewLetter_checkbox.click();
        receiveSpecialOffer_checkbox.click();
        receiveSpecialOffer_checkbox.click();
        save_button.click();
        wait.until(ExpectedConditions.visibilityOf(backToYourAccount_link));
        backToYourAccount_link.click();
        return Browsers.getDriver().getTitle();

    }




}
