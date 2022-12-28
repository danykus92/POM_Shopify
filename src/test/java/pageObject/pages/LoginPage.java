package pageObject.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * @author dansanchez
 * @created 22/12/2022
 * @project BasePOM
 */
public class LoginPage {
    WebDriver driver;
    Faker faker = new Faker();
    String idInputFormEmail="account_email";
    String Email= faker.internet().emailAddress();
    String nextXpath="//button[@name='commit']";
    String messCss =".validation-error__message";

    public LoginPage(WebDriver remoteDriver){
        driver = remoteDriver;
    }

    public void sendKeys() {
        WebElement input = driver.findElement(By.id(idInputFormEmail));
        input.sendKeys(Email);
    }

    public void sendKeysError() {
        WebElement input = driver.findElement(By.id(idInputFormEmail));
        input.sendKeys("correo-errado.com");
    }

    public void submitNextBtn() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath(nextXpath))).click();


    }
    public boolean messageErrorDisplayed(){
        WebElement message = driver.findElement(By.cssSelector(messCss));
        boolean exist = message.isDisplayed();
        return exist;
    }
}
