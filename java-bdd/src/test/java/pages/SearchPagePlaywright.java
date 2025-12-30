package pages;

import com.microsoft.playwright.Page;
import java.util.regex.Pattern;
import utils.BasePagePlaywright;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SearchPagePlaywright extends BasePagePlaywright {
    private final String baseUrl = "https://sauce-demo.myshopify.com/";
    private final String searchInput = "input[name='q']";

    public SearchPagePlaywright(Page page) {
        super(page);
    }

    public void gotoPage() {
        navigate(baseUrl);
    }

    public void searchFor(String term) {
        navigate(baseUrl + "/search");
        fill(searchInput, term);
        press(searchInput, "Enter");
    }

    public void verifyTitle(String text) {
        assertThat(page).hasTitle(Pattern.compile(text));
    }
}
