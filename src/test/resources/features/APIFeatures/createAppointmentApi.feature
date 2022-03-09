@US_07_API
Feature: User_Story_07_Test

  @US_07_TC_05_ApiCreateAppointment
  Scenario Outline: TC_01_create_Appointment_Api
    Given user sets the path params
    And user sets the expected data "<firstname>","<lastname>" "<SSN>" "<email>" "<phone>" and "<date>"
    And user sends the request and gets the response
    When user saves the api records to correspondent files
    Then user validates api records

    Examples: TC_01_create_Appointment_Api_Data
      |firstname|lastname|SSN        |email              |phone       |date      |
      |eymen    |arzu    |253-48-4848|eymenhasta@arzu.com|123-123-1234|11.03.2023|

