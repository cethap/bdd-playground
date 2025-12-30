/// <reference types="cypress" />

export class BasePage {
    visit(url: string) {
        cy.visit(url);
    }

    find(selector: string) {
        return cy.get(selector);
    }

    type(selector: string, text: string) {
        this.find(selector).type(text);
    }

    click(selector: string) {
        this.find(selector).click();
    }
}
