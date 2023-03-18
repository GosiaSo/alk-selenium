package pageobjects;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "book-details h1 span")
    private WebElement productName;

    @FindBy(css = ".center-body-center")
    private WebElement longDescriptionProduct;

    public String getProductName(){
        return productName.getText();
    }

    public String getLongDescriptionProduct(){
        return longDescriptionProduct.getText();
    }
}
