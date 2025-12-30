import { Given, When, Then } from "@badeball/cypress-cucumber-preprocessor";

Given("I open Sauce Demo", () => {
    cy.visit("https://sauce-demo.myshopify.com/");
});

When("I search for {string}", (term: string) => {
    cy.visit(`https://sauce-demo.myshopify.com/search?q=${term}`);
});

Then("the title should contain {string}", (text: string) => {
    cy.title().should('include', text);
});
