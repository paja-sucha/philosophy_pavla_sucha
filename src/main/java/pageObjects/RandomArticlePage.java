package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RandomArticlePage {
    private WebDriver driver;

    public RandomArticlePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openNextRandomArticle(WebDriver driver) {
        WebElement firstLinkToArticle = driver.findElement(By.xpath("//p//a[starts-with(@href,'/wiki')]"));
        firstLinkToArticle.click();
    }

    public void openNextRandomArticleWithHidenFirstLink(WebDriver driver) {
        WebElement irregularFirstLinkToArticle = driver.findElement(By.xpath("//a[@class='mw-redirect']"));
        if (irregularFirstLinkToArticle.isDisplayed()) {
            irregularFirstLinkToArticle.click();
        } else {
            WebElement firstLinkToArticle = driver.findElement(By.xpath("//p//a[starts-with(@href,'/wiki')]"));
            firstLinkToArticle.click();
        }
    }

    public String isThisThePhilosophyArticle(WebDriver driver) {
        WebElement philosophyArticle = driver.findElement(By.id("firstHeading"));
        return philosophyArticle.getText();
    }
}
