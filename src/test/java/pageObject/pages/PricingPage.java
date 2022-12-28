package pageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * @author dansanchez
 * @created 22/12/2022
 * @project BasePOM
 */
public class PricingPage {
    WebDriver driver;

    String findText="Set up your store, pick a plan later";

    public PricingPage(WebDriver remoteDriver){
        driver = remoteDriver;
    }

    public boolean findH1() {
        boolean exist = false;
        List<WebElement> h1 = driver.findElements(By.tagName("h1"));
        for (WebElement element : h1) {
            if (element.getText().equals(findText)) {
                exist = true;
            }
        }
        return exist;
    }
}
