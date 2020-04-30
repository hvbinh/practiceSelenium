package TestCases;

import Supports.Browsers;
import Objects.LogInObject;
import org.testng.Assert;
import org.testng.annotations.*;

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

       @Test (priority = 2,description = "verify update profile",dataProvider = "profile")
        public void myUpdateProfile(String color, boolean b, String firstName, String lastName, String displayName, String webSite, String biographyInfo)
        {
            String expected = "Profile updated.";
            String txt = logIn.updateProfile(color, b, firstName, lastName, displayName, webSite, biographyInfo);
            Assert.assertEquals(txt,expected);
        }
        @Test(priority = 3,description = "verify that clear profile successfully")
        public void clearProfile()
        {
            String expected = "Profile updated.";
            String txt = logIn.reSetProfile();
            Assert.assertEquals(txt,expected);
        }
/*        @AfterClass
        public void tearDown()
        {
            Browsers.getDriver().close();
        }*/
        @DataProvider(name = "profile")
        public Object[][] profile()
        {
            return new Object[][]
                    {
                            new Object[] {"Light",true, "Binh", "Ha", "binhha", "url.com", "text area"},
                            //new Object[] {"Default",true, "Binh1", "Ha1", "binhha", "url.com1", "text area1"}
                    };
        }


    }
}
