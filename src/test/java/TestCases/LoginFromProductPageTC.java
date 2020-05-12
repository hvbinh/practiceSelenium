package TestCases;

import Objects.*;
import Supports.Browsers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginFromProductPageTC {

        OrderProductObject order;
        @BeforeClass
        public  void setUp()
        {
            Browsers.open("chrome");
            order = new OrderProductObject();
            order.load();
        }
        @Test
        public void searProduct()
        {
            order.updateProfile();

        }




}
