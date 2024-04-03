import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {

    ChromeDriver driver;

    @BeforeMethod
    public void beforeTest() {
         driver = new ChromeDriver();
    }

    @Test
    public void googleTest() {
        driver.get("https://google.lv");

        //click on accept all
        driver.findElement(By.xpath("//div[text()='Accept all']//parent::button")).click();

        //write input into a search input field
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys("acodemy IT kursi");
        searchInput.sendKeys(Keys.ENTER);

        Assert.assertEquals(driver.getTitle(), "acodemy IT kursi - Google Search");
        Assertions.assertThat(driver.getTitle()).contains("acodemy IT kursi");
    }

    @Test(description = "Login with standart user")
    public void successLoginTest() {
        driver.get("https://www.saucedemo.com/");
       WebElement userameField = driver.findElement(By.id("user-name"));
        userameField.sendKeys("standard_user");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("password"));
        loginButton.submit();

        WebElement inventoryList = driver.findElement(By.className("inventory_list"));
        Assertions.assertThat(inventoryList.isDisplayed()).isTrue();
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
