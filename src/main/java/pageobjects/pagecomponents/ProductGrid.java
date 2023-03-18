package pageobjects.pagecomponents;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ProductGrid extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(ProductGrid.class);

    public ProductGrid(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "book-list-inner")
    private WebElement booklistContainer;

    @FindBy(css = ".book-list-inner li")
    private List<WebElement> productsTiles;

    @FindBy(css = ".book-list-inner li a.show-short-desc")
    private List<WebElement> productsNames;


    public List<WebElement> getAllProductTiles() {
        return productsTiles;
    }

    public int getNumberOfProducts() {
        return getAllProductTiles().size();
    }

    public List<String> getAllProductsNames(){
        List<String> allProductsNames = new ArrayList<>();
        for (int i = 0; i < productsNames.size(); i++) {
            String productName = productsNames.get(i).getText();
            allProductsNames.add(productName);
        }
        return allProductsNames;
    }

    public void openRandomProduct(){
        WebElement product = getRandomElement(productsTiles);
        logger.info("Clicking on: " + product.getText());
        click(product);
    }
}
