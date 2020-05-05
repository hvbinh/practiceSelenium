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
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public void orderProduct(String name)
    {
        Actions act = new Actions(Browsers.getDriver());
        WebElement e = productName("Blouse");
        act.moveToElement(e).perform();
        e.findElement(By.xpath("//a[@title='Blouse']/../../../..//a[@class='button ajax_add_to_cart_button btn btn-default']")).click();
        WebDriverWait wait = new WebDriverWait(Browsers.getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Proceed to checkout']")));
        proceedToCheckOut1_button.click();
       /* JavascriptExecutor js = (JavascriptExecutor) Browsers.getDriver();
        js.executeScript("window.scrollBy(0,1000)");*/
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='cart_navigation clearfix']/a[@title='Proceed to checkout']")));
        proceedToCheckOut2_button.click();


    }


}
