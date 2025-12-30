import { Given, When, Then } from "@badeball/cypress-cucumber-preprocessor";
import { SearchPage } from "../pages/SearchPage";

const searchPage = new SearchPage();

Given("I open Sauce Demo", () => {
    searchPage.visit();
});

When("I search for {string}", (term: string) => {
    searchPage.searchFor(term);
});

Then("the title should contain {string}", (text: string) => {
    searchPage.verifyTitle(text);
});
