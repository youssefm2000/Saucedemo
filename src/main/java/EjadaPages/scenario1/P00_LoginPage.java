package EjadaPages.scenario1;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class P00_LoginPage {

    public WebDriver driver;

    // create constructor to initiliaze elements
    public P00_LoginPage(WebDriver driver){

        this.driver=driver;
    }

    // locate elements use By way
    private final By usernamefield = By.id("user-name");
    private final By passwordfield = By.id("password");
    private final By loginbutton = By.id("login-button");
    private final By errormessage = By.xpath("//h3[@data-test='error']");



    // method for login with invalid credentials and check error message
    public void userLogin(String user,String pass){

        // find element and take actions to it
        driver.findElement(usernamefield).sendKeys(user);
        driver.findElement(passwordfield).sendKeys(pass);
        driver.findElement(loginbutton).click();

        // wait until alert message is present
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // to check error message that can not log in
        WebElement error = driver.findElement(errormessage);
        Assert.assertEquals(error.getText(),"Epic sadface: Username and password do not match any user in this service" );

    }
}
