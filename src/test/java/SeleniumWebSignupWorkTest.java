import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class SeleniumWebSignupWorkTest {
    //import the selenium WebDriver
    private WebDriver driver;

@BeforeTest
    public void start() throws InterruptedException {
        //locate where the webdriver is
        System.setProperty ("webdriver.chrome.driver", " Resources/chromedriver.exe");
        //1. Open your Chrome browser
        driver = new ChromeDriver();
        //2. Input your Selenium Demo Page URL (https://selenium-blog.herokuapp.com)
        driver.get("https://selenium-blog.herokuapp.com");
        Thread.sleep(5000);
        //3. Maximize the browser
        driver.manage().window().maximize();
        //4. Then click on the signup button to open signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
    }

@Test(priority = 2)
    public void PositiveSignup() throws InterruptedException {
    //5. Input your username on the username field
    driver.findElement(By.id("user_username")).sendKeys("mummy");
    //6.Locate the email address field and input an email address on the email field
    driver.findElement(By.id("user_email")).sendKeys("mummy2@gmail.com");
    //7.Locate the password field and input your password on the username field
    driver.findElement(By.id("user_password")).sendKeys("4020");
    //8.Click on the signup button
    driver.findElement(By.id("submit")).click();
    Thread.sleep(5000);
}
@Test(priority = 3)
    public void clickUserpage1() throws InterruptedException {
    //9. Click on the User1 on the list page
    driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
    Thread.sleep(5000);
}
@Test(priority = 4)
    public void verifyuseritem() throws InterruptedException {
    //.search for an item (using python with selenium) and confirm that it is present
    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
    Thread.sleep(5000);
}

@Test(priority = 5)
    public void user1present() throws InterruptedException {
    // check that user1 is present
    driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
    // click on logout
    driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
    Thread.sleep(5000);
    // click on the login button to open the login page
    driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[1]/a")).click();
    Thread.sleep(5000);
}
@Test(priority = 6)
    public void login() throws InterruptedException {
    // click on login()
    driver.findElement(By.xpath("/html/body/div[2]/div/a[1]")).click();
    // Check that the user cannot login with less than or equal to one character
    driver.findElement(By.xpath("session_email")).sendKeys("o");
    driver.findElement(By.id("session_password")).sendKeys("j");
    Thread.sleep(5000);
    driver.findElement(By.xpath("/html/body/div[2]/form/div[3]/div")).click();
    Thread.sleep(5000);
}

@Test(priority = 1)
public void NegativeSignup() throws InterruptedException {
    //Input your username on the username field
    //Test4. confirm that user cannot signup with invalid email address
    driver.findElement(By.id("user_username")).sendKeys("mummy");
    //Input email on the email field
    driver.findElement(By.id("user_email")).sendKeys(".gmail.com");
    //Input password on the password field
    driver.findElement(By.xpath("user_password")).sendKeys("4020");
    //click on the signup button
    driver.findElement(By.id("submit")).click();
    Thread.sleep(5000);
}

@Test(priority = 0)
    public void NegativeSignup1() throws InterruptedException {

    //Input your username on the username field
    //Test6. confirm that user cannot signup with either or all field blank
    driver.findElement(By.id("user_username")).sendKeys("mummy");
    //Locate the email address field and input an email address on the email field
    driver.findElement(By.id("user_email")).sendKeys("blank");
    //Locate the password field and input your password on the username field
    driver.findElement(By.id("user_password")).sendKeys("4020");
    //Click on the signup button
    driver.findElement(By.id("submit")).click();
    Thread.sleep(5000);

}
    @AfterTest
    public void closeBrowser() {
        //Quit the browser
        driver.quit();
    }
}

