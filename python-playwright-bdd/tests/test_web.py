import pytest
import re
from pytest_bdd import scenario, given, when, then, parsers
from playwright.sync_api import Page, expect

@scenario('../features/web.feature', 'Search for a product')
def test_search_product():
    pass

@given("I open Sauce Demo")
def open_sauce(page: Page):
    page.goto("https://sauce-demo.myshopify.com/")

@when(parsers.parse('I search for "{term}"'))
def search_product(page: Page, term: str):
    page.goto(f"https://sauce-demo.myshopify.com/search?q={term}")
    # Alternatively verify input 
    # page.locator("input[name='q']").fill(term)
    # page.keyboard.press("Enter")

@then(parsers.parse('the title should contain "{text}"'))
def verify_title(page: Page, text: str):
    expect(page).to_have_title(re.compile(text))
