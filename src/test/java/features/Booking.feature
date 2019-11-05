Feature: Validate Car Booking

Scenario: Booking the car

Given Initialize the browser with chrome
And Navigate to "https://www.phptravels.net/" site
When Search for the car
Then Book the car as per requirements