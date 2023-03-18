package pageobjects.pagecomponents;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class Header extends BasePage {
    public Header(WebDriver driver) {
        super(driver);
    }

    @FindBy()
    private WebElement basketCount;

    @FindBy()
    private WebElement basketBtn;

    @FindBy(css = "")
    private WebElement login;

    @FindBy()
    private WebElement loginButton;

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
