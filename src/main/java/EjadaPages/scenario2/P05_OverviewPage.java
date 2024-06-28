package EjadaPages.scenario2;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P05_OverviewPage {

    public WebDriver driver;

    // create constructor to initiliaze elements
    public P05_OverviewPage(WebDriver driver){
        this.driver=driver;
    }


    // locate elements use By way
    private final By  headertitle = By.xpath("//span[@class='title']");
    private final By  finishbutton = By.id("finish");


    // method for that you have been navigated to the “Overview” pag and check header title
    public P06_CompletePage itemTotals(){

        // store header title in header webelement
        WebElement header = driver.findElement(headertitle);

        // wait to locate Dom page until header page present with Checkout: Overview
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.textToBePresentInElement(header,"Checkout: Overview"));

        // to verify that you have been navigated to the “Overview” page
        Assert.assertEquals(header.getText(),"Checkout: Overview" );


        // Verify tha URL that  as same as
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://www.saucedemo.com/checkout-step-two.html" );

        driver.findElement(finishbutton).click();

        return new P06_CompletePage(driver);

    }
}
