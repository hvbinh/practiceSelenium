package TestCases;

import Supports.Browsers;
import Objects.LogInObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LogInTC {
    public class TodoTestCases {
        LogInObject logIn;
        @BeforeClass
        public  void setUp()
        {
            Browsers.open("chrome");
        }
        @BeforeMethod
        public void precondition()
        {
            logIn = new LogInObject();
            logIn.load();
        }
        @Test
        public void login()
        {
            String actual = logIn.login();
            String expected = "Profile ‹ Automation Blog — WordPress";
            Assert.assertEquals(actual, expected);
        }

    }
}
