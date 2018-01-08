package ss.com;

import org.openqa.selenium.WebDriver;

/**
 * Created by aleksandra on 1/8/18.
 */
public abstract class WebPage {
    protected WebDriver driver;
    WebPage (WebDriver driver) {
        this.driver=driver;

    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }
    public void openPage(String url) throws InterruptedException {
        driver.get(url);
        Thread.sleep(2000);

    }


}
