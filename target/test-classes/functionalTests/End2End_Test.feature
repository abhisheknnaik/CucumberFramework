Feature: Automate E2E tests
Description: Automate E2E tests for integration testing

Scenario: Customer place an order
Given user is on Home Page
When he search for "dress"
And choose to buy the first item
And moves to checkout from mini cart

@Smoke
Scenario: Customer searches a product 
Given user is on Home Page
When he search for "book"
When Execute fail step
