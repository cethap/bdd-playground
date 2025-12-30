import { Page } from '@playwright/test';

export class BasePage {
    readonly page: Page;

    constructor(page: Page) {
        this.page = page;
    }

    async navigate(url: string) {
        await this.page.goto(url);
    }

    async click(selector: string) {
        await this.page.click(selector);
    }

    async fill(selector: string, text: string) {
        await this.page.fill(selector, text);
    }

    async press(selector: string, key: string) {
        await this.page.press(selector, key);
    }
}
