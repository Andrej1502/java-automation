package lv.acodemy.page_object;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Header {

    ChromeDriver driver;

    @FindBy(how = How.CLASS_NAME, className = "shopping_cart_badge")
    @Getter
    private WebElement shoppingCartBadge;

    public Header(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
