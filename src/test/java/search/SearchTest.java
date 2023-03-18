package search;

import base.Pages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchTest extends Pages {
    private static final Logger logger = LoggerFactory.getLogger(SearchTest.class);

    @Test
    @DisplayName("id:001- Search for istqb products")
    @Tag("search")
    public void searchForIstqbProducts() {
        logger.info(">>>> Start test ISTQB Product >>>>>");

        String searchItem = "istqb";
        searchWidget.searchProduct(searchItem);
        String searchWord = searchWidget.getSearchWord();
        assertThat(searchWord).isEqualTo(searchItem);
        logger.info("Szukany tekst to: " + searchWord);

        List<String> allProductsNames = productGrid.getAllProductsNames();
        String searchBook = "Certyfikowany tester ISTQB. Poziom podstawowy";
        assertThat(allProductsNames, hasItems(searchBook));
        logger.info("Znaleziono produkt: " + searchBook);

        logger.info(">>>> End of ISQTB Product Search test >>>>>");
    }


    @Test
    @DisplayName("id:003- Search for random product")
    @Tag("search")
    public void searchForRandomProduct() {
        logger.info(">>>> Start test Random Product >>>>>");
         // testt
        logger.info(">>>> End of Random Product Search test >>>>>");
    }
}
