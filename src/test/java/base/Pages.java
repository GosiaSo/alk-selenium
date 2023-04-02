package base;

import org.junit.jupiter.api.BeforeEach;
import pageobjects.HomePage;
import pageobjects.ProductPage;
import pageobjects.pagecomponents.Filters;
import pageobjects.pagecomponents.Header;
import pageobjects.pagecomponents.ProductGrid;
import pageobjects.pagecomponents.SearchWidget;

public class Pages extends BaseTest{

    public HomePage homePage;
    public Header header;
    public SearchWidget searchWidget;
    public ProductGrid productGrid;
    public ProductPage productPage;
    public Filters filters;


    @BeforeEach
    public void testSetup() {
        homePage = new HomePage(driver);
        header = new Header(driver);
        searchWidget = new SearchWidget(driver);
        productGrid = new ProductGrid(driver);
        productPage = new ProductPage(driver);
        filters = new Filters(driver);
    }
}
