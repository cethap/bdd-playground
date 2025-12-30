// Generated from: features/search.feature
import { test } from "playwright-bdd";

test.describe('Sauce Demo Search', () => {

  test('Search for a product', async ({ Given, When, Then, page }) => { 
    await Given('I open Sauce Demo', null, { page }); 
    await When('I search for "jacket"', null, { page }); 
    await Then('the title should contain "Sauce Demo"', null, { page }); 
  });

});

// == technical section ==

test.use({
  $test: [({}, use) => use(test), { scope: 'test', box: true }],
  $uri: [({}, use) => use('features/search.feature'), { scope: 'test', box: true }],
  $bddFileData: [({}, use) => use(bddFileData), { scope: "test", box: true }],
});

const bddFileData = [ // bdd-data-start
  {"pwTestLine":6,"pickleLine":6,"tags":[],"steps":[{"pwStepLine":7,"gherkinStepLine":7,"keywordType":"Context","textWithKeyword":"Given I open Sauce Demo","stepMatchArguments":[]},{"pwStepLine":8,"gherkinStepLine":8,"keywordType":"Action","textWithKeyword":"When I search for \"jacket\"","stepMatchArguments":[{"group":{"start":13,"value":"\"jacket\"","children":[{"start":14,"value":"jacket","children":[{"children":[]}]},{"children":[{"children":[]}]}]},"parameterTypeName":"string"}]},{"pwStepLine":9,"gherkinStepLine":9,"keywordType":"Outcome","textWithKeyword":"Then the title should contain \"Sauce Demo\"","stepMatchArguments":[{"group":{"start":25,"value":"\"Sauce Demo\"","children":[{"start":26,"value":"Sauce Demo","children":[{"children":[]}]},{"children":[{"children":[]}]}]},"parameterTypeName":"string"}]}]},
]; // bdd-data-end