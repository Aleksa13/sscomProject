package ss.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;
import static org.testng.Assert.assertTrue;

/**
 * Created by aleksandra on 12/12/17.
 */
public class SSComTest {
    private WebDriver driver;

    @BeforeClass (alwaysRun= true)
    public void setUp()
    {
        //Open chrome browser
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();

        //Maximize window
        driver.manage().window().maximize();
        //Set timeouts
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @BeforeMethod (alwaysRun = true)
    public void openMainPage(){
        //Open ss.com page
        driver.get("https://www.ss.com/");

    }

    @AfterClass(alwaysRun = true)
    public void tearDown()

    {
        //Close browse
        driver.quit();

    }


    @Test
    public void mainPageTest() {
        //check that main page is opened

       String url = driver.getCurrentUrl();
       assertEquals(url ,"https://www.ss.com/","ss.comm page opened fail");


    }

    @Test
    public void testRealEstateCategory() throws InterruptedException {
        //find real estate category link
        WebElement link = driver.findElement(By.cssSelector("h2 > a[href*='real-estate']"));
        // click the link
        link.click();
        //wait page to load
        Thread.sleep(2000);
        //check that correct page opened
        String url =driver.getCurrentUrl();
        assertTrue(url.endsWith("real-estate/"),"real estate page is not opened");

    }

    @Test
    public void searchTodayFlatTest() throws InterruptedException {
        //open page
        driver.get("https://www.ss.com/lv/real-estate/flats/riga/centre");
        Thread.sleep(2000);
        //select Today's advertisement
//        WebElement daysFilter = driver.findElement(By.id ("today_cnt_sl"));
//        //click on the enter field to select
//        daysFilter.click();

        Select daysFilter = new Select(driver.findElement(By.id("today_cnt_sl")));
        daysFilter.selectByIndex(1);

        //max price 10 to be added
        WebElement maxPriceInput = driver.findElement(By.id("f_o_8_max"));
        maxPriceInput.clear();
        maxPriceInput.sendKeys("100");

        WebElement minPriceInput = driver.findElement(By.id ("f_o_8_min"));
        minPriceInput.clear();
        minPriceInput.sendKeys("50");

        Select RoomsFilterMin = new Select(driver.findElement(By.id("f_o_1")));
        RoomsFilterMin.selectByIndex(1);

        Select RoomsFilterMax = new Select(driver.findElement(By.name("topt[1][max]")));
        RoomsFilterMax.selectByIndex(5);

        WebElement minSizeInput = driver.findElement(By.id ("f_o_3_min"));
        minSizeInput.clear();
        minSizeInput.sendKeys("27");


        WebElement maxSizeInput = driver.findElement(By.id ("f_o_3_max"));
        maxSizeInput.clear();
        maxSizeInput.sendKeys("70");


        WebElement minFloorInput = driver.findElement(By.id ("f_o_4_min"));
        minFloorInput.clear();
        minFloorInput.sendKeys("3");


        WebElement maxFloorInput = driver.findElement(By.id ("f_o_4_max"));
        maxFloorInput.clear();
        maxFloorInput.sendKeys("5");


        Select SerijaFilter = new Select(driver.findElement(By.id("f_o_6")));
        SerijaFilter.selectByIndex(8);


        //click search button
        WebElement searchButton = driver.findElement(By.cssSelector("#filter_tbl > tbody > tr > td:nth-child(2) > input"));
        searchButton.click();
        Thread.sleep(2000);


        //check that only 1 is found
        List<WebElement> searchResults = driver.findElements(By.cssSelector("#filter_frm table:nth-child(3) tr input[type='checkbox']"));
        assertEquals(searchResults.size(),2,"More than 2 were found");
        


    }

}
