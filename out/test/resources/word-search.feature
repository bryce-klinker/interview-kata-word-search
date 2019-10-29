Feature: Word Search

  Scenario: Find words in word search
    Given a fifteen by fifteen word search
    When I find the words
    Then I should see all words in the word search