import re
from playwright.sync_api import Page, expect

class SearchPage:
    BASE_URL = "https://sauce-demo.myshopify.com/"
    SEARCH_INPUT = "input[name='q']"

    def __init__(self, page: Page):
        self.page = page

    def goto(self):
        self.page.goto(self.BASE_URL)

    def search_for(self, term: str):
        self.page.goto(f"{self.BASE_URL}/search")
        self.page.fill(self.SEARCH_INPUT, term)
        self.page.keyboard.press("Enter")

    def verify_title(self, text: str):
        expect(self.page).to_have_title(re.compile(text))
