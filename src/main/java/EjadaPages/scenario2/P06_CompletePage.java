package EjadaPages.scenario2;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P06_CompletePage {

    public WebDriver driver;

    // create constructor to initiliaze elements
    public P06_CompletePage(WebDriver driver){
        this.driver=driver;
    }

    // locate elements use By way
    private final By headertitle = By.xpath("//span[@class='title']");
    private final By  firstmessage = By.xpath("//h2[@class='complete-header']");
    private final By  secondmessage = By.xpath("//div[@class='complete-text']");


    public void checkSuccessMessage(){

        // store header title in header webelement
        WebElement header = driver.findElement(headertitle);

        // wait to locate Dom page until header page present with Checkout: Complete!
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.textToBePresentInElement(header,"Checkout: Complete!"));

        // to verify that you have been navigated to the “Overview” page
        Assert.assertEquals(header.getText(),"Checkout: Complete!" );


        // verify the success message is as same as
        WebElement SuccessM = driver.findElement(firstmessage);
        Assert.assertEquals(SuccessM.getText(),"Thank you for your order!" );

        // verify Your order has been dispatched message is as same as
        WebElement dispatchedM = driver.findElement(secondmessage);
        Assert.assertEquals(dispatchedM.getText(),"Your order has been dispatched, and will arrive just as fast as the pony can get there!" );

    }
}
