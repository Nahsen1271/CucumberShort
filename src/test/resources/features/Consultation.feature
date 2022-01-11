@driver
Feature: Consultation
  As a user I want to go to first consultation part

  Scenario Outline: Go to consultation part and can choose the sections

    Given User is on the home page
    And User clicks the free first Consultation
    When User can choose the choices on the next page
    Then User can see <"the choices"> are correct
    Examples:
      | "the choices"                  |
      | Test management services       |
      | TaaS - Test as a service       |
      | Performance/ automated testing |
      | QA & test consultancy          |

