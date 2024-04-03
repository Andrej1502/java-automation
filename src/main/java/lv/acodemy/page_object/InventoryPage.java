package lv.acodemy.page_object;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InventoryPage {

    ChromeDriver driver;

    @FindBy(how = How.CLASS_NAME, className = "inventory_item")
    @Getter
    List<WebElement> inventoryElements;


    public InventoryPage(ChromeDriver diver) {
        this.driver = diver;
        PageFactory.initElements(driver,this);
    }
}
