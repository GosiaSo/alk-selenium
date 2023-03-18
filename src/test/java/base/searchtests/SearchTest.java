package base.searchtests;

import base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SearchTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(SearchTest.class);

    @Test
    @DisplayName("Search for random product")
    public void searchForRandomProduct() {
        logger.info(">>>> Start test Random Product >>>>>");
         // testt
        logger.info(">>>> End of Random Product Search test >>>>>");
    }
}
