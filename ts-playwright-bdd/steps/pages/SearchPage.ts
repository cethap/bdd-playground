import { Page, expect } from '@playwright/test';
import { BasePage } from '../utils/BasePage';

export class SearchPage extends BasePage {
    readonly searchInput = "input[name='q']";
    readonly baseUrl = 'https://sauce-demo.myshopify.com/';

    constructor(page: Page) {
        super(page);
    }

    async goto() {
        await this.navigate(this.baseUrl);
    }

    async searchFor(term: string) {
        await this.navigate(this.baseUrl + '/search');
        await this.fill(this.searchInput, term);
        await this.press(this.searchInput, 'Enter');
    }

    async verifyTitle(text: string) {
        await expect(this.page).toHaveTitle(new RegExp(text));
    }
}
