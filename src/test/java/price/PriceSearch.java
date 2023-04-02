package price;

import base.Pages;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PriceSearch extends Pages {
    private static final Logger logger = LoggerFactory.getLogger(PriceSearch.class);

    @Test
    @DisplayName("id:004- Search for expensive book")
    @Tag("price")
    public void testPriceRange() {
        logger.info(">>>> Start test 004>>>>>");
        header.goToEbookiPage();

        filters.setPriceRange(1000, 1000);
        int result = productGrid.getNumberOfProducts();
        assertThat(result).isEqualTo(0);
        logger.info("Nie znaleziono produktów w tym zakresie cenowym");

        logger.info(">>>> End of search for expensive book >>>>>");
    }

    @Test
    @DisplayName("id:005- Search for ebook in price range")
    @Tag("price")
    public void searchForEbookInPriceRange() {
        logger.info(">>>> Start test 005>>>>>");
        header.goToEbookiPage();

        double min = 90;
        double max = 101;
        filters.setPriceRange(min, max);
        Map<Integer, WebElement> randomProduct = productGrid.chooseRandomProduct();
        double priceOfRandomProductAfterSale = productGrid.getPriceAfterSale(randomProduct);
        double priceOfRandomProductWithoutSale = productGrid.getPriceWithoutSale(randomProduct);
        productGrid.clickProduct(randomProduct);

        double priceOfEbookAfterSale = productPage.getPriceAfterSale();
        double priceOfEbookWithoutSale = productPage.getPriceWithoutSale();
        logger.info("Cena ebooka przed promocją: " + priceOfRandomProductWithoutSale);
        logger.info("Cena ebooka po promocji: " + priceOfEbookAfterSale);
        assertThat(priceOfRandomProductAfterSale).isEqualTo(priceOfEbookAfterSale);
        assertThat(priceOfRandomProductWithoutSale).isEqualTo(priceOfEbookWithoutSale);

        assertThat(priceOfRandomProductAfterSale, is(both(greaterThan(max)).and(lessThan(min))));

        logger.info(">>>> End of test 005 >>>>>");
    }
}
