@US_07_UI
Feature: User_Story_07_Test

  @US_07_TC_01

  Scenario: TC_01_positive_Scenario
    Given user on the common page
    And user validate common page
    And user navigates to make an appointment
    And user sends current date on Appointment DateTime
    And should not get any error and message
    And user sends future date on Appointment DateTime
    Then should not get any error and message


  @US_07_TC_02

  Scenario: TC_01_negative_Scenario
    Given user on the common page
    And user validate common page
    And user navigates to make an appointment
    And user sends invalid date on Appointment DateTime
    Then user should get error and message

  @US_07_TC_03

  Scenario: TC_01_positive_Scenario
    Given user on the common page
    And user validate common page
    And user navigates to make an appointment
    And the order for date should be mm/day/year on Appointment DateTime
    Then should not get any error and massage

  @US_07_TC_04

  Scenario: TC_01_negative_Scenario
    Given user on the common page
    And user validate common page
    And user navigates to make an appointment
    And the order for date should be day/mm/year on Appointment DateTime
    Then should not get any error and massage

