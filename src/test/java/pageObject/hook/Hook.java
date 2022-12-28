package pageObject.hook;


import pageObject.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;


/**
 * @author dansanchez
 * @created 22/12/2022
 * @project pageObject
 */
public class Hook  {
    public WebDriver driver;
    public pageObject.pages.HomePage HomePage;
    public Utility util;

    @BeforeTest
    public void setUp()  {
        System.setProperty("webdriver.chrome.driver","drivers/Chrome/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.shopify.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        HomePage = new HomePage(driver);
        util = new Utility(driver);

    }

    @AfterTest
    public void quit(){

        driver.quit();
    }
}
