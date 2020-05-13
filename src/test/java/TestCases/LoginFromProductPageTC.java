package TestCases;

import Objects.*;
import Supports.Browsers;
import org.testng.Assert;
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
        @Test (description = "verify update profile successfully")
        public void updateProfile()
        {
            String actual = order.updateProfile();
            String expect = "My account - My Store";
            Assert.assertEquals(actual, expect);

        }




}
