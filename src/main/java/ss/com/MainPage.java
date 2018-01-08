package ss.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by aleksandra on 1/8/18.
 */
public class MainPage extends WebPage{


    MainPage(WebDriver driver) {
        super(driver);
    }
    public CategoryPage openCategoryPage(final String categoryName) throws InterruptedException {
        WebElement link = driver.findElement(By.cssSelector("h2 > a[href*='" + categoryName + "']"));
        // click the link
        link.click();
        //wait page to load
        Thread.sleep(2000);
        return new CategoryPage (driver);
    }
}
