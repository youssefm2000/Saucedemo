package EjadaTest.scenario2;
import EjadaPages.scenario2.P01_LoginPage;
import EjadaPages.scenario2.P02_ProductPage;
import EjadaPages.scenario2.P03_CartPage;
import EjadaPages.scenario2.P04CheckoutPage;
import EjadaTest.TestBase;
import data.DataReader;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import java.io.IOException;

public class TC04_CheckoutTest extends TestBase {

    public P01_LoginPage loginPage;
    public P02_ProductPage productPage;
    public P03_CartPage cartPage;
    public P04CheckoutPage checkoutPage;

    @Test(description = "check header title and Fill all the displayed form with data to continue to Overview Page")
    public void addProduct() throws InterruptedException, IOException, ParseException {

        DataReader dataReader = new DataReader();
        dataReader.Reader2();

        loginPage = new P01_LoginPage(driver);
        loginPage.userLogin(dataReader.UserName,dataReader.Password);

        productPage = new P02_ProductPage(driver);
        productPage.checkProduct();

        cartPage = new P03_CartPage(driver);
        cartPage.navigateToCheckout();

        checkoutPage = new P04CheckoutPage(driver);
        checkoutPage.fillform("Youssef","Elshemy","315125");

    }
}
