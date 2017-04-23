package intuTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by Tushar & Gauri on 22/04/2017.
 */
public class BaseMain {


    public BaseMain() {
        PageFactory.initElements(driver, this);
    }

    public static WebDriver driver;

    public void openBrowser() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
        properties.load(fileInputStream);

        System.setProperty("webdriver.chromedriver.driver", "chromedriver.exe");
        System.setProperty("webdriver.ghekodriver.driver", "ghekodriver.exe");

        String url = properties.getProperty("url");
        String browser = properties.getProperty("browser");

        if ("chrome".equalsIgnoreCase(browser)) {
            driver = new ChromeDriver();
            System.out.println("Chrome Browser initialised");
        } else if ("firefox".equalsIgnoreCase(browser)) {
            driver = new FirefoxDriver();
            System.out.println("FireFox Browser initialised");
        } else {
            System.out.println("Failed to invoke Browser");
        }

        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void closeBrowser() {
        driver.quit();
    }
}
