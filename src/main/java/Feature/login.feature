Feature: login


  Scenario: User should be able to submit form by entering valid details
    Given URL should open successfully
    When user click on walk_through button
    When  user enter first name
    When  user enter last name
    When  user enter email address
    When user enter phone number
    When user enter valid date
    Then user click on submit button
    Then form should be submitted successfully 'Thank you for contacting us. Your Demo has been scheduled.'

