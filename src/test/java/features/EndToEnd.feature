Feature:  Verify the Login Feature
      i want to check user can logib in sauce website
  Background:

  @e2eTest
  Scenario Outline: Test Login Functionality with Standard user
    Given user naviagte to website
    When User attempts to login with valid valid data "<username>" ,"<password>"
    Then user should be directed to product catalog page
    And Add the most expensive Products To The Cart and Click On The Cart Icon
    Then User Should be in Cart Page And able to see his products
    And Click On Checkout
    Then User Should be in Checkout Page
    And user Fill The information with below valid credentials And Click On Continue "<firstName>" ,"<LastName>" , "<ZipCode>"
    Then user should be in Overview page
    And click on Finish
    Then user Should be in Complete page see a message Thank you for your order
    Examples:
      | username      | password    |      firstName  |    LastName    |ZipCode|
      | standard_user | secret_sauce |      Youssef    |     Elshemy    |12345  |