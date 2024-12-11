# README Ex1

## Project Overview
This project provides utilities for working with numbers in various bases (2-16). It includes functionalities such as base conversion, validation, comparison, and finding maximum values. The project contains an interactive console application and a comprehensive set of test cases.

---

## File Descriptions

### `Ex1.java`
- Core utility class with the following functionalities:
  - **Convert Numbers:** Convert numbers between various base formats (e.g., `10b2` to decimal).
  - **Validation:** Check if a string is a valid number in a specified base.
  - **Base Conversion:** Convert integers to their string representation in a specified base.
  - **Comparison:** Compare numbers in different base formats.
  - **Find Maximum:** Identify the largest number in an array of base-formatted strings.

### `Ex1Main.java`
- Interactive console program that:
  - Prompts the user for two numbers and a base.
  - Performs addition and multiplication in the specified base.
  - Displays the largest value among the inputs and results.

### `Ex1Test.java`
- JUnit test suite with tests for all utility methods:
  - Validates `number2Int`, `isNumber`, `int2Number`, and `equals` methods.
  - Ensures robust handling of edge cases and invalid inputs.

---