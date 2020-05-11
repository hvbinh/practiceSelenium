package TestCases;

import Objects.*;
import Supports.Browsers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginFromProductPage {

        OderProductObject order;
        @BeforeClass
        public  void setUp()
        {
            Browsers.open("chrome");
            order = new OderProductObject();
            order.load();
        }
        @Test
        public void searProduct()
        {
            order.searchOrderProduct("Blouse");
        }




}
