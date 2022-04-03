Feature: menu selection


  @menu
  Scenario Outline: hover over menu option
    Given I am on the homepage "<URL>"
    When I hover over the menu option "<Menu>"
    And I click the link "<Menu>"
    Then I should navigate to the screen "<PageTitle>"

  Examples:
    |URL                    | Menu  |PageTitle       |
    |https://www.next.co.uk/| WOMEN |Womens Clothing|
    |https://www.next.co.uk/| MEN   |Mens Clothing   |
#    |https://www.next.co.uk/| BABY  |Baby Clothes    |