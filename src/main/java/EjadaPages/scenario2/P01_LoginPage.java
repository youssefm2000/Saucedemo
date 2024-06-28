package EjadaPages.scenario2;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

    public class P01_LoginPage {

        public WebDriver driver;

        // create constructor to initiliaze elements
        public P01_LoginPage(WebDriver driver){
            this.driver=driver;
        }

        // locate elements use By way
        private final By usernamefield = By.id("user-name");
        private final By passwordfield = By.id("password");
        private final By loginbutton = By.id("login-button");
        private final By titlename = By.xpath("//div[@class='app_logo']");


        // method for login with valid credentials
        public P02_ProductPage userLogin(String user,String pass) throws InterruptedException{

            // find element and take actions to it
            driver.findElement(usernamefield).sendKeys(user);
            driver.findElement(passwordfield).sendKeys(pass);
            driver.findElement(loginbutton).click();


            // wait to locate Dom page until header page present with Swag Labs
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement header = driver.findElement(titlename);
            wait.until(ExpectedConditions.textToBePresentInElement(header,"Swag Labs"));

            // to verify that title of product page is present
            Assert.assertEquals(header.getText(),"Swag Labs" );

            return new P02_ProductPage(driver);
        }
}
