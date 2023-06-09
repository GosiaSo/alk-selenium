package pageobjects.pagecomponents;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductGrid extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(ProductGrid.class);

    public ProductGrid(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "book-list-inner")
    private WebElement booklistContainer;

    @FindBy(xpath = "//div[contains(@class, 'book-list-inner')]/ul/li")
    private List<WebElement> productsTiles;

    @FindBy(xpath = "//div[contains(@class, 'book-list-inner')]/ul/li/a")
    private List<WebElement> products;

    @FindBy(css = "a.short-title")
    private List<WebElement> productsNames;

    @FindBy(css = "div.book-info a.short-title")
    private List<WebElement> productTitles;


    public List<WebElement> getAllProductTiles() {
        return productsTiles;
    }

    public int getNumberOfProducts() {
        return getAllProductTiles().size();
    }

    public List<String> getAllProductsNames(){
        List<String> allProductsNames = new ArrayList<>();
        for (int i = 0; i < productsNames.size(); i++) {
            String productName = productsNames.get(i).getText().trim();
            allProductsNames.add(productName);
        }
        return allProductsNames;
    }

    public Map<Integer, WebElement> chooseRandomProduct(){
        return getRandomElementWithIndex(products);
    }

    public void clickProduct(Map<Integer, WebElement> element){
        Integer index = element.keySet().iterator().next();
        logger.info("Clicking on: " + getTitleOfProduct(element));
        click(element.get(index));
    }

    public String getTitleOfProduct(Map<Integer, WebElement> element){
        Integer index = element.keySet().iterator().next();
        return productTitles.get(index).getText();
    }
}
