package base;

import org.junit.jupiter.api.BeforeEach;
import pageobjects.HomePage;
import pageobjects.pagecomponents.ProductGrid;
import pageobjects.pagecomponents.SearchWidget;

public class Pages extends BaseTest{

    public HomePage homePage;
    public SearchWidget searchWidget;
    public ProductGrid productGrid;


    @BeforeEach
    public void testSetup() {
        homePage = new HomePage(driver);
        searchWidget = new SearchWidget(driver);
        productGrid = new ProductGrid(driver);
    }
}
