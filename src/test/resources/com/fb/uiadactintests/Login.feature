Feature: Adactin Login

  Scenario: Adactin Login happy path
    Given I launched the AdactIn application in the browser
    When I insert a valid Username "UtenteProva7" and Password "UtenteProva7"
    And I click the Login button
    Then Search Hotel page appears
    And in the page I find the message Hello "UtenteProva7"!