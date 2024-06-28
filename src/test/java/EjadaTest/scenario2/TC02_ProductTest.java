package EjadaTest.scenario2;

import EjadaPages.scenario1.P00_LoginPage;
import EjadaPages.scenario2.P01_LoginPage;
import EjadaPages.scenario2.P02_ProductPage;
import EjadaTest.TestBase;
import data.DataReader;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import java.io.IOException;

public class TC02_ProductTest extends TestBase {

    public P01_LoginPage loginPage;
    public P02_ProductPage productPage;

    @Test(description = "Add the most expensive two products to the cart")
    public void addProduct() throws InterruptedException, IOException, ParseException {

        DataReader dataReader = new DataReader();
        dataReader.Reader2();

        loginPage = new P01_LoginPage(driver);
        loginPage.userLogin(dataReader.UserName,dataReader.Password);

        productPage = new P02_ProductPage(driver);
        productPage.checkProduct();

    }

}
