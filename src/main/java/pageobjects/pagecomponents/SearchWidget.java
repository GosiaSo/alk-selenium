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

    @FindBy(id = "inputSearch")
    private WebElement searchInput;

    @FindBy(id = "pageTitle")
    private WebElement searchWord;

    @FindBy(css = "#szukanie div.suggest-list")
    private WebElement searchResultDropDownList;

    @FindBy()
    private List<WebElement> searchResultDropDownItem;

    public void searchProduct(String productName) {
        sendKeys(searchInput, productName);
        waitToBeVisible(searchResultDropDownList);
        enter();
    }

    public String getSearchWord() {
        String text = searchWord.getText().trim();
        return text.substring(text.indexOf("\"") + 1, text.lastIndexOf("\"")).trim();
    }
}
