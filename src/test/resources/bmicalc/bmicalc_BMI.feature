#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Calculate Body Mass Index
  As a user of the Body Mass Index calculator, 
  I want to calculate my Body Mass Index, 
  So that I know if I have overweight

  @tag1
  Scenario Outline: height and mass are correct
  	Given the Body Mass Index calculator
  	When the user with correct mass <m> kg and correct height <h> m clicks on the Calculate BMI button
  	Then the calculator returns a value <v>
  	
  	Examples:
  		| m  | h | v  |
      | 62.0 | 1.81 | 18.924941241109856 |
      | 75.0 | 1.90 | 20.775623268698062 |
      | 75.0 | 1.90 | 20.775623268698062 |

  @tag2
  Scenario Outline: height is incorrect
    Given the Body Mass Index calculator
    When the user with correct mass <m> kg and incorrect height <h> m clicks on the Calculate BMI button
    Then the calculator throws an exception

    Examples: 
    	| m  | h |
      | 61.0 | -1.91 |
      | 50.0 | -1.20 |
      | 80.0 | -1.90 |
      

   @tag3
   Scenario Outline: mass is incorrect
   	Given the Body Mass Index calculator
  	When the user with incorrect mass <m> kg and incorrect height <h> m clicks on the Calculate BMI button
  	Then the calculator throws an exception
   
   	Examples: 
   		| m  | h |
      | -82.0 | 1.81 |
      | -35.0 | 1.10 |
      | -75.0 | 1.90 |