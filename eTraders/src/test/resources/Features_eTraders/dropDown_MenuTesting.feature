Feature: feature for test dropdown

  Scenario Outline: Validate dropdown
    Given user is on registration page
    When user is select <title> and <distric> and <city>
    Then The values are selected correctly

    Examples: 
      | title | distric | city |
      | Mrs   | Colombo |  952 |
