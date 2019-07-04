package parsers;

import browser.Browser;
import org.openqa.selenium.WebDriver;

public interface TelParser {

    WebDriver WEB_DRIVER = Browser.instance();

    String getTel(String url);

}
