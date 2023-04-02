package pageobjects.pagecomponents;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Filters extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(Filters.class);

    public Filters(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "filtrCena")
    private WebElement zakresCen;

	@FindBy(id = "cenaod")
	private WebElement cenaOdInput;

    @FindBy(id = "cenado")
	private WebElement cenaDoInput;

    @FindBy(id = "filter_submit")
	private WebElement submitFilterButton;


    public void setPriceRange(double min, double max){
        sendKeys(cenaOdInput, String.valueOf(min));
        sendKeys(cenaDoInput, String.valueOf(max));
        logger.info("Wybrano zakres cen od: " + min + " do: " + max);
        click(submitFilterButton);
    }
}
