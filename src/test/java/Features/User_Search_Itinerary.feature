Feature:Search
  A feature to search the itinerary

  Background:  User Login successfully
    Given A user is on the home page
    When  A user navigates to the Login page using "http://adactinhotelapp.com/"
    And A user enter "Muchangana" and "197613@Tt"
    And A user clicks the login button
    Then A user has login successfully

  Scenario: Search successfully
    Given A user enters "London", "Hotel Sunshine", "Standard","1","04/03/2022","07/03/2022","2","0"
    And A user enters "Timmy", "Tom", "123 ABC Street", "1234567890654321", "123"
    And The hotel was booked successfully
    And A user clicks on search hotel
    And A user enter order number and click on the go button
    Then The search is successful