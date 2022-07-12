package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FirstSeleniumTest {
    WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--window-size=1920x1080");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        //Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        //Explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Init Actions class
        /*actions = new Actions(driver);*/

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void testLandingPage() throws InterruptedException {
        driver.get("http://training.skillo-bg.com/");
        By loginLinkBy = By.id("nav-link-login");
        WebElement loginLink = driver.findElement(loginLinkBy);
        Assert.assertTrue(loginLink.isDisplayed());

        List<WebElement> listPosts = driver.findElements(By.xpath("//div[@class = 'row post-list-container']//app-post-detail"));
        Assert.assertEquals(listPosts.size(), 3);
        loginLink.click();
        WebElement signInTxt = driver.findElement(By.xpath("//p[text()='Sign in']"));
        Assert.assertTrue(signInTxt.isDisplayed());
        //Thread.sleep(5000);
    }

    @Test
    public void testLoginPage() {
        driver.get("http://training.skillo-bg.com/users/login");
        WebElement userName = driver.findElement(By.cssSelector("#defaultLoginFormUsername"));
        /*wait.until(ExpectedConditions.visibilityOf(userName));*/
        WebElement password = driver.findElement(By.cssSelector("#defaultLoginFormPassword"));
        WebElement signInBtn = driver.findElement(By.cssSelector("#sign-in-button"));

/*        userName.click();
        userName.clear();*/
        userName.sendKeys("danibot");
      /*  actions.click(userName).sendKeys("danibot").build().perform();*/

        password.sendKeys("dani123");
        signInBtn.click();

        By logoutLink = By.cssSelector(".fas.fa-sign-out-alt.fa-lg");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(logoutLink)));
        Assert.assertTrue(driver.findElement(logoutLink).isDisplayed());

    }

    @Test(invocationCount = 2)
    public void testMobileBg(){
        String carMarka = "Mini";
        String carModel = "Cooper";

        driver.get("https://www.mobile.bg/pcgi/mobile.cgi");
        By marka = By.xpath("//select[@name='marka']");
        By model = By.xpath("//select[@name='model']");
        By search = By.xpath("//input[@id='button2']");
        By toSite = By.xpath("//p[text() = 'Към сайта']");
        driver.findElement(toSite).click();

        Select markaDropdown = new Select(driver.findElement(marka));
        markaDropdown.selectByVisibleText(carMarka);

        Select modelDropdown = new Select(driver.findElement(model));
        modelDropdown.selectByValue(carModel);
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(search)));
        driver.findElement(search).click();

        List<WebElement> listAdds = driver.findElements(By.xpath("//form[@name = 'search']//a[@class = 'mmm']"));
        listAdds.forEach(add->{
            Assert.assertTrue(add.getText().contains(carMarka+ " " + carModel ));
        });


    }

}
