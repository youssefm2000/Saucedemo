package EjadaTest.scenario2;
import EjadaPages.scenario1.P00_LoginPage;
import EjadaPages.scenario2.P01_LoginPage;
import EjadaTest.TestBase;
import data.DataReader;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import java.io.IOException;

public class TC01_LoginTest extends TestBase {

    public P01_LoginPage loginPage;

    @Test(description = "User Can Login")
    public void loginWithInvalidData() throws InterruptedException, IOException, ParseException {
        DataReader dataReader = new DataReader();
        dataReader.Reader2();

        loginPage = new P01_LoginPage(driver);
        loginPage.userLogin(dataReader.UserName,dataReader.Password);
    }
}