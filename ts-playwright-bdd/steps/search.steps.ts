import { createBdd } from 'playwright-bdd';
import { test } from '@playwright/test';

const { Given, When, Then } = createBdd();

Given('I open Sauce Demo', async ({ page }) => {
    await page.goto('https://sauce-demo.myshopify.com/');
});

When('I search for {string}', async ({ page }, term: string) => {
    await page.goto(`https://sauce-demo.myshopify.com/search?q=${term}`);
});

Then('the title should contain {string}', async ({ page }, text: string) => {
    await test.expect(page).toHaveTitle(new RegExp(text));
});
