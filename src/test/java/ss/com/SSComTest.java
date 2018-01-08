package ss.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;
import static org.testng.Assert.assertTrue;

/**
 * Created by aleksandra on 12/12/17.
 */
public class SSComTest extends BaseTest{




    @Test
    public void mainPageTest() {
        //check that main page is opened

        String url = mainPage.getPageUrl();
        assertEquals(url ,"https://www.ss.com/","ss.comm page opened fail");


    }



    @Test
    public void testRealEstateCategory() throws InterruptedException {
        //find real estate category link
        String url = mainPage
                .openCategoryPage("real-estate")
         .getPageUrl();
        assertTrue(url.endsWith("real-estate/"),"real estate page is not opened");

    }



    @Test
    public void searchTodayFlatTest() throws InterruptedException {
        //open page
        mainPage.openPage("https://www.ss.com/lv/real-estate/flats/riga/centre");
        //driver.get("https://www.ss.com/lv/real-estate/flats/riga/centre");
        SearchPage searchPage = new SearchPage (driver)
                .selectDayFilter(1)
                .enterMaxPrice("10")
                .clickSearchButton();


        //check that only 1 is found
        List<WebElement> searchResults = searchPage.getArticles();
        assertEquals(searchResults.size(),1,"More that 1 was found");
        


    }



}
