package pageobject;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RandomArticlePage {
    public final WebDriver driver;

    public RandomArticlePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openNextRandomArticle(WebDriver driver, int linkOrder) {
        var isElementDisplayed =
                (driver.findElements(By.xpath("//div/div/div/p/b/following-sibling::a[starts-with(@href,'/wiki/Help:IPA/')]"))).isEmpty();
        if (!isElementDisplayed) {
            driver.findElement(By.xpath(setXpathNextArticle(1 + linkOrder))).click();
        } else {
            driver.findElement(By.xpath(setXpathNextArticle(linkOrder))).click();
        }
    }

    public String setXpathNextArticle(int linkOrder) {
        var xpath = "//div/div/div/p/a[starts-with(@href,'/wiki')][" + linkOrder + "]";
        return xpath;
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
