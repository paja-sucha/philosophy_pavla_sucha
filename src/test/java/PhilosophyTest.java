import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.MainPage;
import pageObjects.RandomArticlePage;
import pageObjects.SelectLanguagePage;

import java.util.concurrent.TimeUnit;

public class PhilosophyTest {
    private static WebDriver driver;
    private static final String WIKIPEDIA_ORG = "https://www.wikipedia.org/";

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void browserShouldGetToPhilosophyArticle() {
        int count = 0;
        var selectLanguagePage = new SelectLanguagePage(driver, WIKIPEDIA_ORG);

        MainPage mainPage = selectLanguagePage.selectEnglishLanguage();
        RandomArticlePage randomArticle = mainPage.openRandomArticle();

        while (!randomArticle.checkThisIsArticleAboutPhilosophy(driver).equals("Philosophy")) {
            String headerOfArticle = driver.findElement(By.xpath("//h1")).getText();
            randomArticle.openNextRandomArticle(driver);
            count++;
            System.out.println(count + ". " + randomArticle.checkThisIsArticleAboutPhilosophy(driver));
            if (randomArticle.checkThisIsArticleAboutPhilosophy(driver).equals("Philosophy")) {
                break;
            }

            randomArticle.openNextRandomArticle(driver);
            count++;
            System.out.println(count + ". " + randomArticle.checkThisIsArticleAboutPhilosophy(driver));
            String headerOfNextArticle = driver.findElement(By.xpath("//h1")).getText();

            if (headerOfArticle.equals(headerOfNextArticle)) {
                randomArticle.openNextRandomArticle(driver);
                randomArticle.openNextLinkToRandomArticle(driver);
            }
        }
        randomArticle.thisShouldBeArticleAboutPhilosophy(driver);
        System.out.println("There was " + count + " of redirects on my way to philosophy");
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }
}
