package steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import EjadaPages.scenario2.*;
import EjadaTest.TestBase;

public class EndToEndSteps extends TestBase {

    public P01_LoginPage loginPage;
    public P02_ProductPage productPage;
    public P03_CartPage cartPage;
    public P04CheckoutPage checkoutPage;
    public P05_OverviewPage overviewPage;
    public P06_CompletePage completePage;

    @Given("user naviagte to website")
    public void user_naviagte_to_website() throws InterruptedException {

    }
    @When("User attempts to login with valid valid data {string} ,{string}")
    public void user_attempts_to_login_with_valid_valid_data(String username, String password) throws InterruptedException {
        loginPage = new P01_LoginPage(driver);
        loginPage.userLogin(username,password);
    }
    @Then("user should be directed to product catalog page")
    public void user_should_be_directed_to_product_catalog_page() {


    }
    @Then("Add the most expensive Products To The Cart and Click On The Cart Icon")
    public void add_the_most_expensive_products_to_the_cart_and_click_on_the_cart_icon(String username, String password) throws InterruptedException {
        loginPage = new P01_LoginPage(driver);
        loginPage.userLogin(username,password);

        productPage = new P02_ProductPage(driver);
        productPage.checkProduct();
    }
    @Then("User Should be in Cart Page And able to see his products")
    public void user_should_be_in_cart_page_and_able_to_see_his_products() {

    }
    @Then("Click On Checkout")
    public void click_on_checkout(String username, String password) throws InterruptedException {
        loginPage = new P01_LoginPage(driver);
        loginPage.userLogin(username,password);

        productPage = new P02_ProductPage(driver);
        productPage.checkProduct();

        cartPage = new P03_CartPage(driver);
        cartPage.navigateToCheckout();
    }
    @Then("User Should be in Checkout Page")
    public void user_should_be_in_checkout_page() {

    }
    @Then("user Fill The information with below valid credentials And Click On Continue {string} ,{string} , {string}")
    public void user_fill_the_information_with_below_valid_credentials_and_click_on_continue(String username, String password,String firstName,String LastName, String ZipCode ) throws InterruptedException {
        loginPage = new P01_LoginPage(driver);
        loginPage.userLogin(username,password);

        productPage = new P02_ProductPage(driver);
        productPage.checkProduct();

        cartPage = new P03_CartPage(driver);
        cartPage.navigateToCheckout();

        checkoutPage = new P04CheckoutPage(driver);
        checkoutPage.fillform(firstName,LastName,ZipCode);
    }
    @Then("user should be in Overview page")
    public void user_should_be_in_overview_page() {

    }
    @Then("click on Finish")
    public void click_on_finish(String username, String password,String firstName,String LastName, String ZipCode) throws InterruptedException {
        loginPage = new P01_LoginPage(driver);
        loginPage.userLogin(username,password);

        productPage = new P02_ProductPage(driver);
        productPage.checkProduct();

        cartPage = new P03_CartPage(driver);
        cartPage.navigateToCheckout();

        checkoutPage = new P04CheckoutPage(driver);
        checkoutPage.fillform(firstName,LastName,ZipCode);

        overviewPage = new P05_OverviewPage(driver);
        overviewPage.itemTotals();
    }
    @Then("user Should be in Complete page see a message Thank you for your order")
    public void user_should_be_in_complete_page_see_a_message_thank_you_for_your_order(String username, String password,String firstName,String LastName, String ZipCode) throws InterruptedException {
        loginPage = new P01_LoginPage(driver);
        loginPage.userLogin(username,password);

        productPage = new P02_ProductPage(driver);
        productPage.checkProduct();

        cartPage = new P03_CartPage(driver);
        cartPage.navigateToCheckout();

        checkoutPage = new P04CheckoutPage(driver);
        checkoutPage.fillform(firstName,LastName,ZipCode);

        overviewPage = new P05_OverviewPage(driver);
        overviewPage.itemTotals();

        completePage = new P06_CompletePage(driver);
        completePage.checkSuccessMessage();
    }
}
