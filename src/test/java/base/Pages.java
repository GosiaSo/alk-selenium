package base;

import org.junit.jupiter.api.BeforeEach;
import pageobjects.HomePage;
import pageobjects.ProductPage;
import pageobjects.pagecomponents.ProductGrid;
import pageobjects.pagecomponents.SearchWidget;

public class Pages extends BaseTest{

    public HomePage homePage;
    public SearchWidget searchWidget;
    public ProductGrid productGrid;
    public ProductPage productPage;


    @BeforeEach
    public void testSetup() {
        homePage = new HomePage(driver);
        searchWidget = new SearchWidget(driver);
        productGrid = new ProductGrid(driver);
        productPage = new ProductPage(driver);
    }
}
