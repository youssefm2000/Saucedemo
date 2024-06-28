package EjadaPages.scenario2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P02_ProductPage {

     public WebDriver driver;

    // create constructor to initiliaze elements
    public P02_ProductPage(WebDriver driver){
        this.driver=driver;
    }

    // locate elements use By way
    private final By allelements = By.className("inventory_item");
    private final By productname = By.className("inventory_item_name");
    private final By productprice = By.className("inventory_item_price");
    private final By addbutton = By.tagName("button");
    private final By carticon = By.xpath("//a[@class='shopping_cart_link']");



    // method to add two products to my cart
    public P03_CartPage checkProduct() throws InterruptedException{

        // List to hold products
        List<Product> productsList = new ArrayList<>();

        // Find all product elements
        List<WebElement> products = driver.findElements(allelements);

        for (WebElement product : products) {
            // Extract the product name
            String name = product.findElement(productname).getText();
            // Extract and clean the product price text
            String priceText = product.findElement(productprice).getText().replace("$", "");
            // Convert the price to a double
            double price = Double.parseDouble(priceText);
            // Find the add to cart button
            WebElement addToCartButton = product.findElement(addbutton);
            // Create a product object and add to the list
            productsList.add(new Product(name, price, addToCartButton));
        }

        // Sort products by price in descending order
        Collections.sort(productsList, (p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice()));

        // Add the two most expensive products to the cart
        for (int i = 0; i < 2; i++) {
            productsList.get(i).getAddToCartButton().click();

        }

        Product mostExpensive = productsList.get(0);
        Product secondMostExpensive = productsList.get(1);

        String mostexpensiveprice=  mostExpensive.getName();
        String secondmostexpensiveprice = secondMostExpensive.getName();


        System.out.println("Most Expensive Product Price: $" + mostExpensive.getPrice()+" and the name is: "+mostexpensiveprice);
        System.out.println("Second Most Expensive Product Price: $" + secondMostExpensive.getPrice()+" and the name is: "+secondmostexpensiveprice);


        // to click on Cart Icon
        WebElement CartIcon = driver.findElement(carticon);
        CartIcon.click();

        return new P03_CartPage(driver);

    }
}
