import pytest
from pytest_bdd import scenario, given, when, then, parsers
from playwright.sync_api import Page
from pages.search_page import SearchPage

@scenario('../features/web.feature', 'Search for a product')
def test_search_product():
    pass

@given("I open Sauce Demo")
def open_sauce(page: Page):
    search_page = SearchPage(page)
    search_page.goto()

@when(parsers.parse('I search for "{term}"'))
def search_product(page: Page, term: str):
    search_page = SearchPage(page)
    search_page.search_for(term)

@then(parsers.parse('the title should contain "{text}"'))
def verify_title(page: Page, text: str):
    search_page = SearchPage(page)
    search_page.verify_title(text)
