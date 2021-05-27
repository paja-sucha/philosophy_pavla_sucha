package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectLanguagePage {

    private final WebDriver driver;

    public SelectLanguagePage(WebDriver browser) {
        this.driver = browser;
    }

    public SelectLanguagePage(WebDriver browser, String defaultUrl) {
        this(browser);
        openPageWithUrl(defaultUrl);
    }

    public void openPageWithUrl(String url) {
        driver.navigate().to(url);
    }

    public MainPage selectEnglishLanguage() {
        WebElement EnglishLanguageBtn = driver.findElement(By.xpath("//a[@id = 'js-link-box-en']"));
        EnglishLanguageBtn.click();

        return new MainPage(driver);
    }
}
