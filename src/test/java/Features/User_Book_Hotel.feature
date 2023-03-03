Feature:Hotel Booking
  A feature to book the hotel

  Background: User Login successfully
    Given A user is on the home page
    When  A user navigates to the Login page using "http://adactinhotelapp.com/"
    And A user enter "Muchangana" and "197613@Tt"
    And A user clicks the login button
    Then A user has login successfully

  Scenario Outline: Book Hotel successfully
    Given A user enters "<location>", "<hotel>", "<room_type>","<no_room>","<check_in>","<check_out>","<adults>","<children>"
    And A user enters "<firstname>", "<lastname>", "<bill-address>", "<card-number>", "<cvv-number>"
    Then The hotel was booked successfully

    Examples:
      |location|hotel|room_type|no_room|check_in|check_out|adults|children| firstname| lastname| bill-address| card-number| cvv-number|
      |London  |Hotel Sunshine|Standard| 1 |04/03/2022|06/03/2022|2   |0 | Timmy  | Tom |  123 ABC Street  | 1234567890654321  |  123 |






