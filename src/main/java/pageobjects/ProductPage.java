package pageobjects;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".book-details h1 span")
    private WebElement productName;

    @FindBy(css = ".center-body-center")
    private WebElement longDescriptionProduct;

    @FindBy(css="#box_ebook p.book-price del")
    private WebElement priceWithoutSale;

    @FindBy(id = "cena_e")
    private WebElement priceAfterSale;

    public String getProductName(){
        return productName.getText();
    }

    public String getLongDescriptionProduct(){
        return longDescriptionProduct.getText();
    }

    public double getPriceWithoutSale(){
        String text = priceWithoutSale.getText();
        String price = text.substring(0, text.indexOf(" ")).replace(',','.').trim();
        return Double.parseDouble(price);
    }

    public double getPriceAfterSale(){
        String text = priceWithoutSale.getText();
        String price = text.substring(0, text.indexOf(" ")).replace(',','.').trim();
        return Double.parseDouble(price);
    }
}
