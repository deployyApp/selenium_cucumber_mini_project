package stepDefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.AccountPage;

import java.util.Properties;

import static helper.PropertiesHelper.loadFile;

public class LoginStepDefinitions extends DriverFactory {
    AccountPage accountPage = new AccountPage(driver);

    Properties setUp = loadFile();

    private final String registeredUserName = setUp.getProperty("USERNAME");
    private final String registeredPassword = setUp.getProperty("PASSWORD");

    @When("the user enters a valid username and password")
    public void theUserEntersAValidUsernameAndPassword() {
        accountPage.loginWithValidCredentials(registeredUserName, registeredPassword);
    }

    @And("clicks the log in button")
    public void clicksTheLogInButton() {
        accountPage.clickLoginButton();
    }

    @When("the user enters an invalid username or password")
    public void theUserEntersAnInvalidUsernameOrPassword() {
        accountPage.loginWithInvalidCredentials("x", "invalidPassword");
    }
}
