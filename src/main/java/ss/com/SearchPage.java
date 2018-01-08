package ss.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by aleksandra on 1/8/18.
 */
public class SearchPage extends WebPage{

    SearchPage(WebDriver driver) {
        super(driver);
    }
    public List<WebElement> getArticles() {
        return driver.findElements(By.cssSelector("#filter_frm table:nth-child(3) tr input[type='checkbox']"));
    }

    public SearchPage clickSearchButton() throws InterruptedException {
        WebElement searchButton = driver.findElement(By.cssSelector("#filter_tbl > tbody > tr > td:nth-child(2) > input"));
        searchButton.click();
        Thread.sleep(2000);
        return this;
    }

    public SearchPage enterMaxPrice(String price) {
        WebElement maxPriceInput = driver.findElement(By.id("f_o_8_max"));
        maxPriceInput.clear();
        maxPriceInput.sendKeys(price);
        return this;
    }

    public SearchPage selectDayFilter(int index) {
        Select daysFilter = new Select(driver.findElement(By.id("today_cnt_sl")));
        daysFilter.selectByIndex(index);
        return this;
    }
}
