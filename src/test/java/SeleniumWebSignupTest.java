import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumWebSignupTest {
    //Import the selenium WebDriver
    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        //locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
        //1 . Open your chrome browser
        driver = new ChromeDriver();
        //2. Input your Selenium Demo Page URL (https://selenium-blog.herokuapp.com)
        driver.get("https://selenium-blog.herokuapp.com");
        //Test 1. Verify user inputs the right url and on the right webpage
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com"))
            //Pass
            System.out.println("correct Webpage");
        else
            //fail
            System.out.println("wrong Webpage");
        Thread.sleep(50000);
        //3. Maximize the browser
        driver.manage().window().maximize();
        //4. Click on Signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
    }


    @Test(priority = 0)
      public void positiveSignup() throws InterruptedException {
        //Test7. Verify that user is successfully signed up when valid details are imputed.
        //Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("arike1");
        //6. locate the email address field and input an email address on the email field
        driver.findElement(By.id("user_email")).sendKeys("arike@gmail.com");
        //7. locate the password field and input your password on the username field
        driver.findElement(By.id("user_password")).sendKeys("2040");
        //8. Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 1)
    public void clickUser1Item() throws InterruptedException {
        //9.Click on the User1 item on the listpage
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        //Test2.Verify that user is directed to the signup page when clicking on the signup button
        String expectedUrl = "selenium-blog.herokuapp.com/signup";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //Pass
            System.out.println("correct Webpage");
        else
            //fail
            System.out.println("wrong Webpage");
        Thread.sleep(5000);
    }

    @Test(priority = 2)
    public void verifyItem() throws InterruptedException {
        //Test9.Search for an item (using Python with selenium) and confirm it is present
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
        String expectedPageURL = "http://selenium-blog.herokuapp.com/users/1";
        String actualPageURL = driver.getCurrentUrl();
        if (actualPageURL.contains(expectedPageURL))
            //pass
            System.out.println("correct User1page");
        else
            //fail
            System.out.println("wrong User1page");
        Thread.sleep(5000);
    }

        @Test(priority = 3)
                public void logoutSuccessfully(){

            //11. Click on log out
            driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
            // Test 10. Verify that when the user logs out,he/she is directed back to the home page
            String expectedTitle = "AlphaBlog";
            String actualTitle = driver.getTitle();
            if (expectedTitle.contains(actualTitle))
                //pass
                System.out.println("correct title");
            else
                //fail
            System.out.println("wrong title");
        }

    @Test(priority = 4)
    public void negativeSignup() throws InterruptedException {
       // Click on Signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        //Test3 Verify user cannot signup with username less than 3
        //5.Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("ji");
        //6.Locate the email address field and input an email address on the email field
        driver.findElement(By.id("user_email")).sendKeys("arike@gmail.com");
        //7.Locate the password field and input your password on the username field
        driver.findElement(By.id("user_password")).sendKeys("2040");
        //8.Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }


    @AfterTest
    public void closeBrowser() {
        //Quit the browser
        driver.quit();
    }

}
