import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {
    WebDriver driver;

    public void webDriver() {
        //Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        //Yandex
     /*  System.setProperty("webdriver.chrome.driver", "C:\\yandexdriver\\yandexdriver.exe");
        ChromeOptions options = new ChromeOptions();
       options.setBinary("C:\\Yandex\\YandexBrowser\\Application\\browser.exe");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        driver = new ChromeDriver(options); */
    }
}