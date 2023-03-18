package pageobjects.pagecomponents;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchWidget extends BasePage {
    public SearchWidget(WebDriver driver) {
        super(driver);
    }

    @FindBy()
    private WebElement searchInput;

    @FindBy()
    private WebElement searchWord;

    @FindBy()
    private WebElement searchResultDropDownList;

    @FindBy()
    private List<WebElement> searchResultDropDownItem;

    public void searchProduct(String productName) {
        sendKeys(searchInput, productName);
        waitToBeVisible(searchResultDropDownList);
        enter();
    }

    public String getSearchWord(){
        return searchWord.getText();
    }
}
