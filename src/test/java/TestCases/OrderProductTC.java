package TestCases;

import Objects.LogInObject;
import Objects.OrderProductObject;
import Supports.Browsers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrderProductTC {
    OrderProductObject order;
    @BeforeClass
    public  void setUp()
    {
        Browsers.open("chrome");
        order = new OrderProductObject();
        order.load();
    }

    @Test(priority = 1,description = "verify order a product successfully")
    public void orderProductFlow()
    {
        order.orderProduct("Blouse");
    }
}
