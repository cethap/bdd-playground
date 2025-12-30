import re
from playwright.sync_api import Page, expect
from utils.base_page import BasePage

class SearchPage(BasePage):
    BASE_URL = "https://sauce-demo.myshopify.com/"
    SEARCH_INPUT = "input[name='q']"

    def __init__(self, page: Page):
        super().__init__(page)

    def goto(self):
        self.navigate(self.BASE_URL)

    def search_for(self, term: str):
        self.navigate(f"{self.BASE_URL}/search")
        self.fill(self.SEARCH_INPUT, term)
        self.press(self.SEARCH_INPUT, "Enter")

    def verify_title(self, text: str):
        expect(self.page).to_have_title(re.compile(text))
