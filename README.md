# Medi Score Calculation

## Overview

This project contains my solution to the Aire Logic Medi Score Calculation technical test.

The aim of the task is to calculate a patient's Medi score from a set of physiological observations. The score is based on:

- air or oxygen
- consciousness
- respiration rate
- oxygen saturation (SpO2)
- temperature

The calculator returns the final Medi score as an integer.

## Project Structure

- `MediScoreCalculator` contains the main scoring logic and input validation
- `MediScoreCalculatorTest` contains JUnit 5 tests for the example patients, boundaries, rounding, and invalid inputs

## Task Summary

The Medi score is calculated by assigning a score to each observation based on the inclusive ranges in the specification and then adding those values together.

My implementation follows the rules from the brief, including the important SpO2 rule where values above 92 are scored differently depending on whether the patient is breathing air or receiving supplemental oxygen.

## My Approach

I implemented the core scoring logic in a `MediScoreCalculator` class and verified it with a `MediScoreCalculatorTest` JUnit test suite covering both expected behaviour from the specification and edge cases.

The main public method is `calculateScore(...)`. It:

- validates input values
- rounds temperature to one decimal place
- calculates the score for each observation category
- returns the total Medi score

To keep the code readable and easier to maintain, I split the logic into smaller private helper methods for each observation category, such as `scoreRespiration(...)`, `scoreOxygenSaturation(...)`, and `scoreTemperature(...)`.

I also separated input validation and temperature rounding into their own methods so that the main `calculateScore(...)` method stays simple and easy to follow.

## Design Decisions

### Separate helper methods
I divided each observation category into its own method so that the scoring rules are easier to read, check, and maintain.

### Constants for key values
I used constants for:
- `AIR = 0`
- `OXYGEN = 2`
- `ALERT = 0`

This makes the code more readable by avoiding repeated raw values throughout the `MediScoreCalculator` class.

### Temperature rounding
The specification states that temperature should be rounded to one decimal place before scoring, so I handled this in a dedicated helper method.

### Validation
I added validation for:
- invalid air/oxygen values
- negative respiration rate
- oxygen saturation values outside the range `0` to `100`
- invalid temperature values such as `NaN`, positive infinity, and negative infinity

### Why I added validation
Although the brief mainly focuses on the scoring rules, I added input validation to make the implementation more robust. In a real system, invalid physiological data should be detected explicitly rather than silently producing a misleading score.

## Assumptions

My current implementation assumes that:

- consciousness is interpreted as `0` for alert and any non-zero value as CVPU / confused / unconscious, in line with the brief
- temperature is rounded to one decimal place before scoring
- clearly invalid numeric input is rejected with an `IllegalArgumentException`

## Testing

I created a JUnit 5 test suite to verify the implementation.

The test suite covers:
- the 3 example patients from the brief
- invalid air/oxygen input
- invalid respiration input
- invalid oxygen saturation input
- invalid temperature input
- respiration boundary values
- oxygen saturation boundary values
- the air vs oxygen SpO2 rule
- temperature boundary values
- temperature rounding behaviour
- alert and non-zero consciousness values
- the additional oxygen score even when SpO2 is in the normal band
- minimum and maximum overall score examples

My focus was to make sure the solution was correct across both normal cases and edge cases.

## Final Notes

My focus for this solution was correctness, readability, and strong boundary-value testing. I aimed to keep the implementation simple while still treating it like a small production-style piece of code.

To do that, I kept the solution focused on the required scoring function rather than adding unnecessary abstractions, while still maintaining clear structure, input validation, and good test coverage.
