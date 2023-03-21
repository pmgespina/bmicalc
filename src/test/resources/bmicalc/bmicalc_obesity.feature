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
Feature: Determine if the user has or not abdominal obesity
  As a user of the Body Mass Index calculator
	I want to determine if I have abdominal obesity
	So that I know if I am obese or not

  @tag1
  Scenario Outline: gender and waist circumference are OK
    Given the Body Mass Index calculator
    When an user introduces <x> gender and <y> cm as waist circumference
    Then the calculator returns boolean <b>
    
    Examples:
    	| x  | y | b |
      | 'F' | 48.0 | "false" |
      | 'F' | 120.0 | "true" |
      | 'M' | 100.0 | "true" |
      | 'M' | 75.0 | "false" |

  @tag2
  Scenario Outline: gender is incorrect and waist circumference OK
    Given the Body Mass Index calculator
    When an user introduces incorrect <x> gender and <y> as waist circumference
    Then the calculator throws an exception

    Examples: 
      | x  | y |
      | 'G' | 48.0 |
      | 'T' | 120.0 |
      | 'Z' | 100.0 |
      | 'P' | 75.0 |
      
  @tag3
  Scenario Outline: gender is OK and waist circumference is incorrect
    Given the Body Mass Index calculator
    When an user introduces <x> gender and incorrect <y> cm as waist circumference
    Then the calculator throws an exception

    Examples: 
      | x  | y |
      | 'M' | -98.0 |
      | 'F' | -113.0 |
      | 'F' | -70.0 |
      | 'M' | -95.0 |
