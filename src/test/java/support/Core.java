package support;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Core {
    private WebDriver driver;
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));

    //webdriver config
    public void initBrowser(String URL) {
        driver = getDriver();
        try {
            driver.get(URL);
        } catch (Exception e) {
            throw new RuntimeException("Not possible to connect to: " + URL, e);
        }
    }

    public WebDriver getDriver() {
        if (driver == null) {
            String browser = ConfigLoader.getProperty("BROWSER");
            if (browser.equals("Chrome")) {
                driver = new ChromeDriver();
            } else if (browser.equals("Firefox")) {
                driver = new FirefoxDriver();
            } else {
                throw new IllegalArgumentException("Browser não suportado: " + browser);
            }
            driver.manage().window().setSize(new Dimension(1200, 765));
        }
            return driver;
    }

    public void killDriver() {
        if (driver != null) {
        driver.quit();
        driver = null;
        }
    }

    //actions
    public WebElement getElement(By by) {
        System.out.println("Searching for element..." + by);
       return driver.findElement(by);
    }

    public void clickOnLink(String link) {
        driver.findElement(By.linkText(link)).click();
    }

    public void sendKeys(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public void clickButton(By by) {
        driver.findElement(by).click();
    }

    //assertions
    public void elementIsVisible(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        Assertions.assertTrue(getElement(by).isDisplayed());
    }
}
