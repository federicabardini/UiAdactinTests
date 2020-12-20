Feature: Hotel booking

  Background:
    Given I have done the login with Username "UtenteProva7" and Password "UtenteProva7"
    When I search for "2" rooms in an hotel in "New York" with check-in in 2 days and check-out in 7 days
    Then The Select Hotel page is displayed with all the hotel options available

  Scenario: Search for a hotel and book a new reservation
    Given I have selected the "Hotel Cornice" option
    When I fill all the payment data for the reservation
    Then I see the booking reservation number
