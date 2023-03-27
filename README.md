![example workflow](https://github.com/jmhorcas/bmicalc/actions/workflows/maven.yml/badge.svg)

# BMI calculator
A biomedical calculator for the body mass index (BMI) and other parameters.

For method bmi(mass, height) we will have these different tests:
- mass with a negative value and height with a negative value: "EXCEPTION: Invalid arguments"
- mass with a negative value and height equal to zero: "EXCEPTION: Invalid arguments"
- mass with a negative value and height equal to 1.81: "EXCEPTION: Invalid arguments"
- mass equal to zero height with a negative value: "EXCEPTION: Invalid arguments"
- mass equal to 62 and height with a negative value: "EXCEPTION: Invalid arguments"
- mass equal to 62 and height equal to 1.81: we expect 18.92
- mass equal to 75 and height equal to 1.90: we expect 20.73

For method category(bmi) we will have these different tests:
- bmi equal to -2: "EXCEPTION: Invalid arguments"
- bmi equal to zero: "EXCEPTION: Invalid arguments"
- bmi equal to 10: we expect "UNDERWEIGHT"
- bmi equal to 18.4: we expect "UNDERWEIGHT"
- bmi equal to 18.5: we expect "NORMAL"
- bmi equal to 20: we expect "NORMAL"
- bmi equal to 24.9: we expect "NORMAL"
- bmi equal to 25: we expect "OVERWEIGHT"
- bmi equal to 27: we expect "OVERWEIGHT"
- bmi equal to 29.9: we expect "OVERWEIGHT"
- bmi equal to 30: we expect "OBSESE"
- bmi equal to 35: we expect "OBESE"

For method abdominalObesity(waistCircunference, gender) we will have these different tests:
- waistCircunference with a negative value and gender equal to 'M': "EXCEPTION: Invalid arguments"
- waistCircunference equal to zero and gender equal to 'F': "EXCEPTION: Invalid arguments"
- waistCircunference equal to 56 and gender equal to 'P': "EXCEPTION: Invalid arguments"
- waistCircunference equal to 2 and gender equal to 'Q': "EXCEPTION: Invalid arguments"
- waistCircunference equal to 43 and gender equal to 'K': "EXCEPTION: Invalid arguments"
- waistCircunference with a negative value and gender equal to 'F': "EXCEPTION: Invalid arguments"
- waistCircunference equal to zero and gender equal to 'M': "EXCEPTION: Invalid arguments"
- waistCircunference equal to 10 and gender equal to 'M': we expect FALSE
- waistCircunference equal to 70 and gender equal to 'M': we expect FALSE
- waistCircunference equal to 90 and gender equal to 'M': we expect FALSE
- waistCircunference equal to 91 and gender equal to 'M': we expect TRUE
- waistCircunference equal to 100 and gender equal to 'M': we expect TRUE
- waistCircunference equal to 15 and gender equal to 'F': we expect FALSE
- waistCircunference equal to 27 and gender equal to 'F': we expect FALSE
- waistCircunference equal to 79 and gender equal to 'F': we expect FALSE
- waistCircunference equal to 80 and gender equal to 'F': we expect FALSE
- waistCircunference equal to 81 and gender equal to 'F': we expect TRUE
- waistCircunference equal to 90 and gender equal to 'F': we expect TRUE

![Use Cases Diagram](https://github.com/pmgespina/bmicalc/blob/main/doc/P2_new_function.png)

## Use Case Specification

- Name: Calculate the Body Mass Index of a Person
- Primary actor: the user of the calculator
- Scope: the body mass index (BMI) calculator
- Goal: the user wnats to calculate its body mass index
- Level: user objective
- Stakeholders and interests:
    · User: calculate its body mass index
    · Developers of the calculator: to provide a suitable solution for the request of the user
- Precondition: the user has to introduce its mass and heigth
- Minimal guarantee: the calculator returns a value of body mass index
- Success guarantee: the user receives an suitable value of BMI value according to its mass and heigth
- Trigger: the user selects the option "Calculate Body Mass Index" between the different options of the calculator
- Main scenario:
    1. User opens the calculator
    2. User provides its mass and heigth (this point should be underlined because there is an use case that refers to this)
    3. The calculator accepts the values which have been introduced
    4. The calculator obtains the result of body mass index for the user
    5. The calculator shows the result to the user
- Alternative scenario:
    2a. The mass value introduced by the user is invalid
    2b. The heigth value introduced by the user is invalid

## Specification of user stories and scenarios 

· User Storie 1: calculate Body Mass Index
As a user of the Body Mass Index calculator
I want to calculate my Body Mass Index
So that I can realize if I have overweight

- Scenario 1: 
Given the Body Mass Index calculator
When the user with 62 kg and 1,81 m clicks on the "Calculate BMI" button
Then the calculator returns 18.92

- Scenario 2:
Given the Body Mass Index calculator
When the user with -2 kg and 1,31 m clicks on the "Calculate BMI" button
Then the calculator returns an error

- Scenario 3:
Given the Body Mass Index calculator
When the user with 52 kg and -0,61 m clicks on the "Calculate BMI" button
Then the calculator returns an error

- Scenario 4:
Given the Body Mass Index calculator
When the user with -6 kg and -1,1 m clicks on the "Calculate BMI" button
Then the calculator returns an error



· User Storie 2: categorize a person depending on its Body Mass Index
As a user of the Body Mass Index calculator
I want to categorize myself according to my BMI result
So that I know if I have to change to a healthy lifestyle

- Scenario 1: 
Given the Body Mass Index calculator
When the user with BMI equal to 10 wants to categorize himself
Then the calculator returns "UNDERWEIGHT"

- Scenario 2: 
Given the Body Mass Index calculator
When the user with BMI equal to 18.4 wants to categorize himself
Then the calculator returns "UNDERWEIGHT"

- Scenario 3: 
Given the Body Mass Index calculator
When the user with BMI equal to 18.5 wants to categorize himself
Then the calculator returns "NORMAL"

- Scenario 4: 
Given the Body Mass Index calculator
When the user with BMI equal to 21 wants to categorize himself
Then the calculator returns "NORMAL"

- Scenario 5: 
Given the Body Mass Index calculator
When the user with BMI equal to 24.9 wants to categorize himself
Then the calculator returns "NORMAL"

- Scenario 6: 
Given the Body Mass Index calculator
When the user with BMI equal to 25 wants to categorize himself
Then the calculator returns "OVERWEIGHT"

- Scenario 7: 
Given the Body Mass Index calculator
When the user with BMI equal to 29.9 wants to categorize himself
Then the calculator returns "OVERWEIGHT"

- Scenario 8: 
Given the Body Mass Index calculator
When the user with BMI equal to 30 wants to categorize himself
Then the calculator returns "OBESE"

- Scenario 9: 
Given the Body Mass Index calculator
When the user with BMI equal to 32 wants to categorize himself
Then the calculator returns "OBESE"

- Scenario 10: 
Given the Body Mass Index calculator
When the user with BMI equal to -3 wants to categorize himself
Then the calculator returns an error



· User Storie 3:
As a user of the Body Mass Index calculator
I want to determine if I have abdominal obesity
So that I know if I am obese or not

- Scenario 1:
Given the Body Mass Index calculator
When a woman with 67 cm as waist circumference wants to determine if she has abdominal obesity
Then the calculator returns a boolean telling that she does not have abdominal obesity

- Scenario 2: 
Given the Body Mass Index calculator
When a woman with 81 cm as waist circumference wants to determine if she has abdominal obesity
Then the calculator returns a boolean telling that she has abdominal obesity

- Scenario 3: 
Given the Body Mass Index calculator
When a woman with -9 cm as waist circumference wants to determine if she has abdominal obesity
Then the calculator returns an error

- Scenario 4:
Given the Body Mass Index calculator
When a user whose gender character is 'P' and whose waist circumference is 9 wants to determine if he/she has abdominal obesity
Then the calculator returns an error

- Scenario 5: 
Given the Body Mass Index calculator
When a man with -9 cm as waist circumference wants to determine if he has abdominal obesity
Then the calculator returns an error

- Scenario 6: 
Given the Body Mass Index calculator
When a man with 80 cm as waist circumference wants to determine if he has abdominal obesity
Then the calculator returns a boolean telling that he does not have abdominal obesity

- Scenario 7: 
Given the Body Mass Index calculator
When a man with 91 cm as waist circumference wants to determine if he has abdominal obesity
Then the calculator returns a boolean telling that he has abdominal obesity

## GUI

![Mockup of the interface](https://github.com/pmgespina/bmicalc/blob/main/doc/mockup.png)

![Screenshot of the interface](https://github.com/pmgespina/bmicalc/blob/main/doc/screenshot_GUI.png)