package stepDefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.AccountPage;

import java.util.Properties;

import static helper.PropertiesHelper.loadFile;

public class RegisterStepDefinitions extends DriverFactory {
    AccountPage accountPage;
    Properties setUp = loadFile();

    private final String userName = setUp.getProperty("USERNAME");
    private final String emailAddress = setUp.getProperty("EMAIL");
    private final String password = setUp.getProperty("PASSWORD");


    @Given("the user opens the browser")
    public void theUserOpensTheBrowser() {
        accountPage = new AccountPage(driver);
    }

    @And("navigates to the login and register page at {string}")
    public void navigatesToTheLoginAndRegisterPageAt(String link) {
        accountPage.navigateToAccountPage(link);
    }

    @When("the user enters {string} {string} and {string} in the registration form")
    public void theUserEntersInTheRegistrationForm(String userName, String emailAddress, String password) {
        accountPage.setUsername(userName);
        accountPage.setEmail(emailAddress);
        accountPage.setPassword(password);
    }

    @And("clicks the register button")
    public void clicksTheRegisterButton() {
        accountPage.clickRegisterButton();
    }

    @Then("the user should be logged in and redirected to the account dashboard")
    public void theUserShouldBeLoggedInAndRedirectedToTheAccountDashboard() {
        String expectedRegisteredAccount = accountPage.verifySuccessfullyRegistered();
        Assert.assertEquals(expectedRegisteredAccount, "Hello");
    }

    @When("the user enters an already registered email address and any password")
    public void theUserEntersAnAlreadyRegisteredEmailAddressAndAnyPassword() {
        accountPage.setUsername(userName);
        accountPage.setEmail(emailAddress);
        accountPage.setPassword(password);
    }

    @Then("an error message {string} should be displayed")
    public void anErrorMessageShouldBeDisplayed(String actualErrorInlineMessage) {
        String expectedErrorInlineMessage = accountPage.verifyErrorInlineMessage();
        Assert.assertEquals(actualErrorInlineMessage, expectedErrorInlineMessage);
    }

    @When("the user leaves the email or password field empty in the registration form")
    public void theUserLeavesTheEmailOrPasswordFieldEmptyInTheRegistrationForm() {
        accountPage.setUsername("");
        accountPage.setEmail("");
        accountPage.setPassword("");
    }
}