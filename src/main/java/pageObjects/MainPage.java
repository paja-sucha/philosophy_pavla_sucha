package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //TODO: xpath
    public RandomArticlePage openRandomArticle() {
        WebElement openRandomArticle = driver.findElement(By.xpath("/html/body/div[5]/div[2]/nav[1]/div/ul/li[4]/a"));
        openRandomArticle.click();

        return new RandomArticlePage(driver);
    }
}
