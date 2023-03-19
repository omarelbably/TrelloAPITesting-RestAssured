Feature: Testing Trello API

  Scenario: Testing all the API
    When Create an Organization
    And get an organization for a member
    And create a new board
    And get a board
    And create a new list
    And get a list
    Then archive a list
    And delete a board
    And delete an organization
