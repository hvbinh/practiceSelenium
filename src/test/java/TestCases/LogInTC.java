package TestCases;

import Supports.Browsers;
import Objects.LogInObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class LogInTC {
    public class TodoTestCases {
        LogInObject logIn;
        @BeforeClass
        public  void setUp()
        {
            Browsers.open("chrome");
            logIn = new LogInObject();
            logIn.load();
        }

        @Test (priority = 1,description = "verify login")
        public void login()
        {

            logIn.login();
            String actual = Browsers.getDriver().getTitle();
            String expected = "Profile ‹ Automation Blog — WordPress";
            Assert.assertEquals(actual, expected);
        }
        
       @Test (priority = 2,description = "verify update profile")
        public void myUpdateProfile()
        {
            String expected = "Profile updated.";
            String txt = logIn.updateProfile();
            Assert.assertEquals(txt,expected);
        }

    }
}
