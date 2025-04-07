package stepDefinitions.Hooks;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp(){
        DriverFactory.driverSetUp();
    }

    @After
    public void tearDown(){
        DriverFactory.tearDown();
    }
}
