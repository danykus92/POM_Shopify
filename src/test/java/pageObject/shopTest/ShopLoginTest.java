package pageObject.shopTest;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.hook.Hook;
import pageObject.pages.HomePage;
import pageObject.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * @author dansanchez
 * @created 22/12/2022
 * @project BasePOM
 */
public class ShopLoginTest extends Hook {
    String urlLogin = "https://accounts.shopify.com";



    @Test
    public void emailLoginTest() throws InterruptedException {



        //haga clic en la parte inferior de inicio de sesión
        pageObject.pages.HomePage HomePage = new HomePage(driver);
        LoginPage LoginPage = HomePage.clickBtnLogin();

        WebDriverWait waitClick = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitClick.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@name='commit']")));

        //Revisa la url
        boolean findUrl = util.getUrl(urlLogin);
        Assert.assertTrue(findUrl);



        //escriba un correo electrónico falso y haga clic en el siguiente fondo
        LoginPage.sendKeys();
        LoginPage.submitNextBtn();


        //Compruebe que el error está desplegado
        boolean exist = LoginPage.messageOkDisplayed();
        Assert.assertTrue(exist);


    }
}
