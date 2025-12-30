package utils;

import com.microsoft.playwright.Page;

public abstract class BasePagePlaywright {
    protected Page page;

    public BasePagePlaywright(Page page) {
        this.page = page;
    }

    public void navigate(String url) {
        page.navigate(url);
    }

    public void click(String selector) {
        page.click(selector);
    }

    public void fill(String selector, String text) {
        page.fill(selector, text);
    }

    public void press(String selector, String key) {
        page.press(selector, key);
    }
}
