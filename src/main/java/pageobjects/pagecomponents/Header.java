package pageobjects.pagecomponents;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Header extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(Header.class);

    public Header(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".logo a")
    private WebElement homeButton;

    @FindBy(xpath = "//nav[contains(@class, 'main-menu')]/ul/li[1]/a")
    private WebElement ksiazki;

    @FindBy(xpath = "//nav[contains(@class, 'main-menu')]/ul/li[2]/a")
    private WebElement ebooki;

    @FindBy()
    private WebElement basketCount;

    @FindBy()
    private WebElement basketBtn;

    @FindBy(css = "")
    private WebElement login;

    @FindBy()
    private WebElement loginButton;

    public void returnToHomepage(){
        click(homeButton);
    }


    public void goToEbookiPage(){
        click(ebooki);
        logger.info("Przejście do strony Ebooki");
    }

    public void goToLoginPage() {
        click(login);
    }

    public void goToCart() {
        click(basketBtn);
        try {
            takeScreenshot();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void goToAccount() {
//        click(accountName);
    }
}
