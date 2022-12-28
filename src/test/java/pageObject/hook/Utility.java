package pageObject.hook;

import org.openqa.selenium.WebDriver;



/**
 * @author dansanchez
 * @created 22/12/2022
 * @project BasePOM
 */
public class Utility {
    WebDriver driver;

    public Utility(WebDriver remoteDriver){

        driver = remoteDriver;
    }

    public boolean getTitle(String titleText){
        String title = driver.getTitle();
        boolean findText = title.contains(titleText);
        return findText;
    }

    public boolean getUrl(String urlLoginExpected){
        String Url = driver.getCurrentUrl();
        boolean findUrl = Url.contains(urlLoginExpected);
        return findUrl;
    }
}
