package parsers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AviParser implements TelParser {

    @Override
    public String getTel(String url) {
        WEB_DRIVER.get(url);
        List<WebElement> webElements = WEB_DRIVER.findElements(By.className("j-v-contacts-expand-link"));
        webElements.forEach(webElement -> new Actions(WEB_DRIVER).click(webElement).perform());
        WebDriverWait webDriverWait = new WebDriverWait(WEB_DRIVER, 5);
        String tel = webDriverWait
                .pollingEvery(Duration.ofSeconds(1))
                .until(webDriver -> {
                    WebElement webElement = webDriver.findElement(By.className("j-c-phones"));
                    if (!webElement.getText().contains("x")) {
                        return webElement.getText();
                    } else {
                        return null;
                    }
                });
        System.out.println(tel);
        return tel;
    }

}
