package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class StorePage {
    private WebDriver driver;

    public StorePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    




}
