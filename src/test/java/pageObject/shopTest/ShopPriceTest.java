package pageObject.shopTest;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.hook.Hook;
import pageObject.pages.PricingPage;

import java.time.Duration;

/**
 * @author dansanchez
 * @created 22/12/2022
 * @project BasePOM
 */
public class ShopPriceTest extends Hook {
    String urlHome="https://www.shopify.com/";

    String urlPricing="https://www.shopify.com/pricing";

    @Test
    public void pricingTest(){
        //Check the url and the title
        boolean findUrl = util.getUrl(urlHome);
        Assert.assertTrue(findUrl);


        //Do click on the price tab menu
        PricingPage PricingPage = HomePage.clickBtnPricing();

        WebDriverWait waitClick = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitClick.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h1")));

        //Check the new url
        boolean findUrlPricing = util.getUrl(urlPricing);
        Assert.assertTrue(findUrlPricing);

        //Check exist a new specific text
        boolean exist = PricingPage.findH1();
        Assert.assertTrue(exist);
    }
}
