package pages;

import com.microsoft.playwright.Page;
import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SearchPagePlaywright {
    private final Page page;
    private final String baseUrl = "https://sauce-demo.myshopify.com/";
    private final String searchInput = "input[name='q']";

    public SearchPagePlaywright(Page page) {
        this.page = page;
    }

    public void gotoPage() {
        page.navigate(baseUrl);
    }

    public void searchFor(String term) {
        page.navigate(baseUrl + "/search");
        page.fill(searchInput, term);
        page.press(searchInput, "Enter");
    }

    public void verifyTitle(String text) {
        assertThat(page).hasTitle(Pattern.compile(text));
    }
}
