package base;

import org.junit.jupiter.api.BeforeEach;
import pageobjects.HomePage;

public class Pages extends BaseTest{

    public HomePage homePage;


    @BeforeEach
    public void testSetup() {
        homePage = new HomePage(driver);
    }
}
