package lv.acodemy.page_object;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AuthorizationPage {

    ChromeDriver driver;

    @FindBy(how = How.XPATH, xpath = "//input[@data-test='username']")
    @Getter
    private WebElement usernameField;

    @FindBy(how = How.XPATH, xpath = "//input[@data-test='password']")
    @Getter
    private WebElement passwordField;

    @FindBy(how = How.XPATH, xpath = "//input[contains(@class,'submit-button')]")
    @Getter
    private WebElement submitButton;


    public AuthorizationPage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void authorize(String username, String password) {
        getUsernameField().sendKeys(username);
        getPasswordField().sendKeys(password);
        getSubmitButton().click();
    }
}
