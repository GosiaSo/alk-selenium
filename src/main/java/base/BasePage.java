package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public WebDriver driver;
    public Actions actions;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(System.getProperty("webelementTimeout"))));
    }

    public void click(WebElement element) {
        element.click();
    }

    public void enter() {
        actions.sendKeys(Keys.ENTER).build().perform();;
    }

    public void takeScreenshot() throws IOException {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(".//src/main/resources/screenshot/screen.png"));
    }

    public void sendKeys(WebElement element, String text) {
        element.sendKeys(text);
    }

    public WebElement getRandomElement(List<WebElement> elements) {
        Random random = new Random();
        int randomIndexOfList = random.nextInt(elements.size());
        return elements.get(randomIndexOfList);
    }

    public Map<Integer,WebElement> getRandomElementWithIndex(List<WebElement> elements) {
        Random random = new Random();
        Map<Integer,WebElement> map = new HashMap();
        int randomIndexOfList = random.nextInt(elements.size());
        map.put(randomIndexOfList, elements.get(randomIndexOfList));
        return map;
    }

    public void waitToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForUrlToBe(String url) {
        wait.until(ExpectedConditions.urlToBe(url));
    }

    public void moveToElement(WebElement element) {
        actions.moveToElement(element).perform();
    }

    static ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();

    static public void scheduleWait(long ms){
        try{
            CountDownLatch l = new CountDownLatch(1);
            ses.schedule(l::countDown, ms, TimeUnit.MILLISECONDS);
            l.await();
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public void scrollTo(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
