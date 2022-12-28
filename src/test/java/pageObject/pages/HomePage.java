package pageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author dansanchez
 * @created 22/12/2022
 * @project pageObject
 */
public class HomePage {
    WebDriver driver;

    String tabPricing="//*[@href='/pricing']";
    String tabLoginLinkText="Log in";

    public HomePage(WebDriver remoteDriver){
        driver = remoteDriver;
    }

    public PricingPage clickBtnPricing() {
        driver.findElement(By.xpath(tabPricing)).click();
        PricingPage nextPage = new PricingPage(driver);
        return nextPage;
    }

    public LoginPage clickBtnLogin() {
        driver.findElement(By.linkText(tabLoginLinkText)).click();
        LoginPage nextPage = new LoginPage(driver);
        return nextPage;
    }
}
