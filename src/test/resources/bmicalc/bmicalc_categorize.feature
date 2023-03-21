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
Feature: Categorize a user depending on its Body Mass Index
  As a user of the Body Mass Index calculator
	I want to categorize myself according to my BMI result
	So that I know if I have to change to a healthy lifestyle

  @tag1
  Scenario Outline: the value of BMI is correct
    Given the Body Mass Index calculator
    When the user with a correct value <v> as BMI categorize himself
    Then the calculator returns <c>
    
    Examples: 
      | v  | c |
      | 10.0 | "UNDERWEIGHT" |
      | 18.4 | "UNDERWEIGHT" |
      | 18.5 | "NORMAL" |
      | 21.0 | "NORMAL" |
      | 24.9 | "NORMAL" |
      | 25.0 | "OVERWEIGHT" |
      | 29.9 | "OVERWEIGHT" |
      | 30.0 | "OBESE" |
      | 32.0 | "OBESE" |

  @tag2
  Scenario Outline: the value of BMI is incorrect
    Given the Body Mass Index calculator
    When the user with an incorrect value <v> as BMI categorize himself
    Then the calculator throws an exception

    Examples: 
      | v  |
      | -3.0 |
      | -5.0 |
      | 0.0 |
      | -100.0 |
      
      