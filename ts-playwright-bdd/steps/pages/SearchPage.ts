import { Page, expect } from '@playwright/test';

export class SearchPage {
    readonly page: Page;
    readonly searchInput = "input[name='q']";
    readonly baseUrl = 'https://sauce-demo.myshopify.com/';

    constructor(page: Page) {
        this.page = page;
    }

    async goto() {
        await this.page.goto(this.baseUrl);
    }

    async searchFor(term: string) {
        await this.page.goto(this.baseUrl + '/search');
        await this.page.fill(this.searchInput, term);
        await this.page.press(this.searchInput, 'Enter');
    }

    async verifyTitle(text: string) {
        await expect(this.page).toHaveTitle(new RegExp(text));
    }
}
