Feature: User Login
  A feature to test a login to a application

  Scenario Outline: User Logins successfully
    Given A user is on the home page
    When  A user navigates to the Login page using "<URL>"
    And A user enter "<username>" and "<password>"
    And A user clicks the login button
    Then A user has login successfully

    Examples:
      |URL|username|password|
      | http://adactinhotelapp.com/ |  Muchangana | 197613@Tt  |
      | http://adactinhotelapp.com/ |  Mutsonga | 123456@abc |
