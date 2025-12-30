/// <reference types="cypress" />

import { BasePage } from "../utils/BasePage";

export class SearchPage extends BasePage {
    private readonly baseUrl = "https://sauce-demo.myshopify.com/";
    private readonly searchInput = "input[name='q']";

    visit() {
        super.visit(this.baseUrl);
    }

    searchFor(term: string) {
        super.visit(this.baseUrl + "/search");
        this.type(this.searchInput, term + "{enter}");
    }

    verifyTitle(text: string) {
        cy.title().should('include', text);
    }
}
