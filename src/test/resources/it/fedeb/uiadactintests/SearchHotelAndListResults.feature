Feature: Adactin Search Hotel and List Results

  Background:
    Given I launched the AdactIn application in the browser
    When I insert a valid Username "UtenteProva7" and Password "UtenteProva7"
    And I click the Login button
    Then Search Hotel page appears
    And in the page I find the message Hello "UtenteProva7"!

  Scenario: Search hotel&list results with multiple rooms, days reservation and hotel choices
    Given I inserted Location: "New York"
    And I inserted Number of Rooms: "10"
    And I inserted Check in within 2 days
    And I inserted Check out within 5 days
    And I inserted Adults per room: "3"
    When I click the Search Button
    Then Select Hotel page is displayed
    And I check that there are more than one result displayed
    #TODO And I check that all the results displayed have location "New York", 10 rooms booked, 3 days stay
    #TODO And I check that "Hotel Creek" is one of the results with 3750 AUD total price
