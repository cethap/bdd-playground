import { createBdd } from 'playwright-bdd';
import { test } from '@playwright/test';
import { SearchPage } from './pages/SearchPage';

const { Given, When, Then } = createBdd();

Given('I open Sauce Demo', async ({ page }) => {
    const searchPage = new SearchPage(page);
    await searchPage.goto();
});

When('I search for {string}', async ({ page }, term: string) => {
    const searchPage = new SearchPage(page);
    await searchPage.searchFor(term);
});

Then('the title should contain {string}', async ({ page }, text: string) => {
    const searchPage = new SearchPage(page);
    await searchPage.verifyTitle(text);
});
