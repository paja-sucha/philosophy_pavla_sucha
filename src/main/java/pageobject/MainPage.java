package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public RandomArticlePage openRandomArticle() {
        var openRandomArticle = driver.findElement(By.xpath("/html/body/div[5]/div[2]/nav[1]/div/ul/li[4]/a"));
        openRandomArticle.click();

        return new RandomArticlePage(driver);
    }
}
