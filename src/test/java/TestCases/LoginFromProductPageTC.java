package TestCases;

import Objects.LogInObject;
import Supports.Browsers;
import org.testng.annotations.BeforeClass;

public class LoginFromProductPage {
    LogInObject logIn;
    @BeforeClass
    public  void setUp()
    {
        Browsers.open("chrome");
        logIn = new LogInObject();
        logIn.load();
    }
    

}
