/// <reference types="cypress" />

export class SearchPage {
    private readonly baseUrl = "https://sauce-demo.myshopify.com/";
    private readonly searchInput = "input[name='q']";

    visit() {
        cy.visit(this.baseUrl);
    }

    searchFor(term: string) {
        cy.visit(this.baseUrl + "/search");
        cy.get(this.searchInput).type(term + "{enter}");
    }

    verifyTitle(text: string) {
        cy.title().should('include', text);
    }
}
