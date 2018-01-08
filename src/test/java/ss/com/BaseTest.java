package ss.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * Created by aleksandra on 1/8/18.
 */
public class BaseTest  {


    protected WebDriver driver;
    protected MainPage mainPage;


    @BeforeClass(alwaysRun= true)
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

    @BeforeMethod(alwaysRun = true)
    public void openMainPage() throws InterruptedException {
        //Open ss.com page
        //driver.get("https://www.ss.com/");
        mainPage = new MainPage(driver);
        mainPage.openPage("https://www.ss.com/");

    }

    @AfterClass(alwaysRun = true)
    public void tearDown()

    {
        //Close browse
        driver.quit();

    }

}
