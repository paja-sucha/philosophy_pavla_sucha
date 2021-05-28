package pageObjects;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RandomArticlePage {

    public final WebDriver driver;

    public RandomArticlePage(WebDriver driver) {
        this.driver = driver;
    }

    /*
    //Does not lead to Philosophy
    public void openNextRandomArticle(WebDriver driver) {
        boolean isElementDisplayed = (driver.findElements(By.className("//div/div/div/p//span/a[starts-with(@href,'/wiki/Help:IPA/')]")).isEmpty());
        if (!isElementDisplayed) {
            driver.findElement(By.xpath("//div/div/div/p//span/a[starts-with(@href,'/wiki/Help:IPA/')]")).click();
            driver.findElement(By.xpath("//div/div/div/p//a[starts-with(@href,'/wiki')]")).click();
        } else {
            WebElement firstLinkToArticle = driver.findElement(By.xpath("//div/div/div/p/a[starts-with(@href,'/wiki')]"));
            firstLinkToArticle.click();
        }
    }

     */

    //TODO: theoretical concept, find xpath
    public void openNextRandomArticleBracketsExcluded(WebDriver driver) {
        boolean isElementDisplayed = (driver.findElements(By.xpath("//div/div/div/p/b/following-sibling::a[@class='mw-redirect']"))).isEmpty();
        if (!isElementDisplayed) {
            driver.findElement(By.xpath("//div/div/div/p/a[2]")).click();
        } else {
            WebElement firstLinkToArticle = driver.findElement(By.xpath("//div/div/div/p/a[starts-with(@href,'/wiki')]"));
            firstLinkToArticle.click();
        }
    }

    public String checkThisIsArticleAboutPhilosophy(WebDriver driver) {
        WebElement philosophyArticle = driver.findElement(By.id("firstHeading"));
        return philosophyArticle.getText();
    }

    public void thisShouldBeArticleAboutPhilosophy(WebDriver driver) {
        WebElement philosophyArticle = driver.findElement(By.id("firstHeading"));
        Assertions.assertEquals("Philosophy", philosophyArticle.getText(), "This is not an article about Philosophy");
    }
}
