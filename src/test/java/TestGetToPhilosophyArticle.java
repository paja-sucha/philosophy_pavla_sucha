import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.MainPage;
import pageObjects.RandomArticlePage;
import pageObjects.SelectLanguagePage;

import java.util.concurrent.TimeUnit;

public class TestGetToPhilosophyArticle {
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
        var selectLanguagePage = new SelectLanguagePage(driver, WIKIPEDIA_ORG);

        MainPage mainPage = selectLanguagePage.selectEnglishLanguage();
        RandomArticlePage randomArticle = mainPage.openRandomArticle();
        while (!randomArticle.isThisThePhilosophyArticle(driver).equals("Philosophy")) {
            randomArticle.openNextRandomArticle(driver);
            System.out.println(randomArticle.isThisThePhilosophyArticle(driver));
        }

        Assertions.assertEquals("Philosophy", randomArticle.isThisThePhilosophyArticle(driver), "This is not an article about Philosophy");

//      TODO: count and print out the number of redirects
//      System.out.println("There was " + "number" + " of redirects on my way to philosophy.");
    }

    @Test
    public void browserShouldGetToPhilosophyArticleHidenFirstLink() {

        var selectLanguagePage = new SelectLanguagePage(driver, WIKIPEDIA_ORG);
        MainPage mainPage = selectLanguagePage.selectEnglishLanguage();
        RandomArticlePage randomArticle = mainPage.openRandomArticle();
        while (!randomArticle.isThisThePhilosophyArticle(driver).equals("Philosophy")) {
            randomArticle.openNextRandomArticleWithHidenFirstLink(driver);

            System.out.println(randomArticle.isThisThePhilosophyArticle(driver));
        }
        Assertions.assertEquals("Philosophy", randomArticle.isThisThePhilosophyArticle(driver), "This is not an article about Philosophy");

//        TODO: count and print out the number of redirects
//        System.out.println("There was " + "number" + " of redirects on my way to philosophy.");
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }
}
