package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {

    private static final WebDriver WEB_DRIVER = new ChromeDriver(getChromeOptions());

    private static ChromeOptions getChromeOptions() {
        System.setProperty("webdriver.chrome.driver", Browser.class.getResource("/chromedriver").getFile());
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("user-agent=Mozilla/5.0 (Linux; Android 5.0; SM-G900P Build/LRX21T) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Mobile Safari/537.36");
        chromeOptions.addArguments("window-size=360,640");
        chromeOptions.setHeadless(false);
        return chromeOptions;
    }

    public static WebDriver instance() {
        return WEB_DRIVER;
    }

    public static void close() {
        WEB_DRIVER.quit();
    }

    private Browser() {
    }

}
