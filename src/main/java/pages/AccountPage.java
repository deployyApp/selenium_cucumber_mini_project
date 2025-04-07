package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
    private final WebDriver driver;

    public AccountPage(WebDriver driver){
        this.driver = driver;
    }

    // REGISTER

    By reg_username = By.xpath("//input[@id='reg_username']");

    By reg_email = By.xpath("//input[@id='reg_email']");

    By reg_password = By.xpath("//input[@id='reg_password']");

    By registerButton = By.xpath("//button[@name='register']");

    By verAccount = By.xpath("//p[contains(text(),'Hello')]");

    By errorInlineMessage = By.cssSelector("div[id='content'] li:nth-child(1)");


    public void navigateToAccountPage(String link){
        driver.get(link);
    }

    public void setUsername(String username){
        driver.findElement(reg_username).sendKeys(username);
    }

    public void setEmail(String email){
        driver.findElement(reg_email).sendKeys(email);
    }

    public void setPassword(String password){
        driver.findElement(reg_password).sendKeys(password);
    }

    public void clickRegisterButton(){
        driver.findElement(registerButton).click();
    }

    public String verifySuccessfullyRegistered(){
        return driver.findElement(verAccount).getText();
    }

    public String verifyErrorInlineMessage(){
        return driver.findElement(errorInlineMessage).getText();
    }


    // LOGIN

    By login_username = By.xpath("//input[@id='username']");

    By login_password = By.xpath("//input[@id='password']");

    By checkRememberMe = By.xpath("//input[@id='rememberme']");

    By loginButton = By.xpath("//button[normalize-space()='Log in']");

    public void loginWithValidCredentials(String username, String password){
        driver.findElement(login_username).sendKeys(username);
        driver.findElement(login_password).sendKeys(password);
    }

    public void clickLoginButton(){
        driver.findElement(checkRememberMe).click();
        driver.findElement(loginButton).click();
    }

    public void loginWithInvalidCredentials(String username, String password){
        driver.findElement(login_username).sendKeys(username);
        driver.findElement(login_password).sendKeys(password);
    }
}