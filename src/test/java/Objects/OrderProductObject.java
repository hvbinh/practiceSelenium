package Objects;

import Supports.Browsers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

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
    @FindBy(xpath = "//a[@title='Add to cart']/span[.='Add to cart']")
    WebElement addToCart_button;

    public WebElement productName(WebElement e, String nameProduct)
    {
        return e.findElement(By.xpath(String.format("//div/div/div/a[@title='%s']",nameProduct)));
    }
    public WebElement addToCart(WebElement e, String nameProduct)
    {
        return e.findElement(By.xpath(String.format("//div/div/div/a[@title='%s']/span[.='Add to cart']",nameProduct)));
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
        List<WebElement> list = productList();
        System.out.println("size: "+list.size());
        for(WebElement e: list)
        {
            System.out.println("size: "+e.getAttribute("class"));
            WebElement product = productName(e,name);
            if(product.getAttribute("title").equalsIgnoreCase("Blouse"))
            {
                act.moveToElement(product).click(product.findElement(By.xpath("//span[contains(text(),'Add to cart')]"))).perform();
                //Browsers.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                break;

            }



        }



    }


}
