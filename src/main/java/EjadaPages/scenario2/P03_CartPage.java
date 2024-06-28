package EjadaPages.scenario2;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P03_CartPage {

    public WebDriver driver;

    // create constructor to initiliaze elements
    public P03_CartPage(WebDriver driver){
        this.driver=driver;
    }

    // locate elements use By way
    private final By headername = By.xpath("//span[@class='title']");
    private final By checkoutButton = By.id("checkout");


    // - method for check header name and navigate to Checkout Page
    public P04CheckoutPage navigateToCheckout(){

        // to verify that title of product page is present
        WebElement header = driver.findElement(headername);
        Assert.assertEquals(header.getText(),"Your Cart" );

        // to click on checkout button to navigate to checkout page
        driver.findElement(checkoutButton).click();

        return new P04CheckoutPage(driver);

    }
}
