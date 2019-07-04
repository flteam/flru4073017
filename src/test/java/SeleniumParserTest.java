import browser.Browser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import parsers.AviParser;
import parsers.MarketParser;
import parsers.SalexyParser;
import parsers.TelParser;
import uril.FileUtil;

import java.util.List;
import java.util.Random;

class SeleniumParserTest {

    private static final TelParser AVI_PARSER = new AviParser();
    private static final TelParser MARKET_PARSER = new MarketParser();
    private static final TelParser SALEXY_PARSER = new SalexyParser();

    private static final List<String> AVI_URLS = FileUtil.getUrlsFromFile("avi.txt");
    private static final List<String> MARKET_URLS = FileUtil.getUrlsFromFile("market.txt");
    private static final List<String> SALEXY_URLS = FileUtil.getUrlsFromFile("salexy.txt");

    @Test
    void allStressTest() {
        try {
            Random random = new Random();
            for (int i = 0; i < 100; i++) {
                String url = AVI_URLS.get(random.nextInt(AVI_URLS.size()));
                Assertions.assertNotNull(AVI_PARSER.getTel(url));
                url = MARKET_URLS.get(random.nextInt(MARKET_URLS.size()));
                Assertions.assertNotNull(MARKET_PARSER.getTel(url));
                url = SALEXY_URLS.get(random.nextInt(SALEXY_URLS.size()));
                Assertions.assertNotNull(SALEXY_PARSER.getTel(url));
            }
        } catch (Throwable e) {
            Assertions.fail(e);
        } finally {
            Browser.close();
        }
    }

    @Test
    void aviStressTest() {
        try {
            for (int i = 0; i < 100; i++) {
                for (String url : AVI_URLS) {
                    Assertions.assertNotNull(AVI_PARSER.getTel(url));
                }
            }
        } catch (Throwable e) {
            Assertions.fail(e);
        } finally {
            Browser.close();
        }
    }

    @Test
    void salexyStressTest() {
        try {
            for (int i = 0; i < 100; i++) {
                for (String url : SALEXY_URLS) {
                    Assertions.assertNotNull(SALEXY_PARSER.getTel(url));
                }
            }
        } catch (Throwable e) {
            Assertions.fail(e);
        } finally {
            Browser.close();
        }
    }

    @Test
    void marketStressTest() {
        try {
            for (int i = 0; i < 100; i++) {
                for (String url : MARKET_URLS) {
                    Assertions.assertNotNull(MARKET_PARSER.getTel(url));
                }
            }
        } catch (Throwable e) {
            Assertions.fail(e);
        } finally {
            Browser.close();
        }
    }

}
