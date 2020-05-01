package TestCases;

import Objects.registerAccountObject;
import Supports.Browsers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegisterTC {
    registerAccountObject register;
    @BeforeClass
    public void setUp()
    {
        Browsers.open("chrome");
        register = new registerAccountObject();
        register.load();
    }

    @Test(description = "Verify that register new account work correctly")
    public void registerNewAccount()
    {
        String message = register.registerNewAccount();
        String expectedMessage = "Registration complete. Please check your email.";
        Assert.assertEquals(message, expectedMessage);
    }
}
