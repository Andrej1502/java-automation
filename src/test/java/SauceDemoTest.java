import lv.acodemy.page_object.AuthorizationPage;
import lv.acodemy.page_object.Header;
import lv.acodemy.page_object.InventoryPage;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SauceDemoTest {

    //initialize driver
    //open web page
    //login
    //add item from inventory to the cart
    //purchase them
    ChromeDriver driver;

    AuthorizationPage authorizationPage;
    InventoryPage inventoryPage;

    Header header;

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
        authorizationPage = new AuthorizationPage(driver);
        inventoryPage = new InventoryPage(driver);
        header = new Header(driver);
    }

    @Test
    public void purchaseItemFromInventoryTest() {


        driver.get("https://saucedemo.com");
        authorizationPage.authorize("standard_user", "secret_sauce");

        inventoryPage.getInventoryElements().get(0).findElement(By.xpath(".//div[@class='pricebar']//button")).click();

        Assertions.assertThat(header.getShoppingCartBadge().getText()).isEqualTo("1");


    }
    @AfterMethod
     public void afterTest() {
        driver.close();
        driver.quit();
    }
}
