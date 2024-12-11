package assignments.ex1;

public class Ex1 {
    // Converts a valid string representation of a number to its decimal value
    public static int number2Int(String num) {
        if (!isNumber(num)) return -1;

        // If the number does not contain "b", it is assumed to be in decimal base (base 10)
        if (!num.contains("b")) num = num + "b10";

        String[] parts = num.split("b");
        String number = parts[0];
        String baseStr = parts[1];

        int base;
        if (Character.isDigit(baseStr.charAt(0))) {
            base = Integer.parseInt(baseStr);
        } else {
            base = baseStr.charAt(0) - 'A' + 10; // Map A=10, B=11, ..., G=16
        }
        int result = 0;

        for (char c : number.toCharArray()) {
            int digitValue = Character.isDigit(c) ? c - '0' : Character.toUpperCase(c) - 'A' + 10;
            if (digitValue >= base) {
                throw new IllegalArgumentException("Invalid number: digit exceeds base.");
            }
            result = result * base + digitValue;
        }
        return result;
    }

    // Validates if a string is in a valid number format
    public static boolean isNumber(String a) {
        if (a == null || a.isEmpty()) return false;

        // Handle numbers without "b" (default to base 10)
        if (!a.contains("b")) {
            return a.matches("\\d+"); // Only digits are valid for base 10
        }

        // Split the number into its value and base parts
        String[] parts = a.split("b");
        if (parts.length != 2) return false;

        String number = parts[0];
        String baseStr = parts[1];

        // Validate the base part
        if (baseStr.length() != 1 || (!Character.isDigit(baseStr.charAt(0)) && baseStr.charAt(0) < 'A' || baseStr.charAt(0) > 'G')) {
            return false; // Base must be 2–9 or A–G
        }

        int base = Character.isDigit(baseStr.charAt(0)) ? Integer.parseInt(baseStr) : baseStr.charAt(0) - 'A' + 10;
        if (base < 2 || base > 16) return false;

        // Validate each digit of the number part
        for (char c : number.toCharArray()) {
            int digitValue = Character.isDigit(c) ? c - '0' : Character.toUpperCase(c) - 'A' + 10;
            if (digitValue >= base) return false;
        }
        return true;
    }

    // Converts an integer to its representation in a given base
    public static String int2Number(int num, int base) {
        if (num < 0 || base < 2 || base > 16) return ""; // Handle invalid inputs

        StringBuilder result = new StringBuilder();

        // Convert the number to the target base
        while (num > 0) {
            int digit = num % base; // Extract the digit for the current position
            char digitChar = (char) (digit < 10 ? '0' + digit : 'A' + digit - 10); // Convert to appropriate character
            result.insert(0, digitChar); // Add to the start of the result
            num /= base; // Move to the next digit
        }

        // Handle the base representation correctly
        String baseStr;
        if (base <= 10) {
            baseStr = String.valueOf(base); // Numeric base
        } else {
            baseStr = String.valueOf((char) ('A' + (base - 10))); // Letter base (A=10, B=11, ..., G=16)
        }

        // Return result in the format "<number>b<base>"
        return result.length() > 0 ? result.toString() + "b" + baseStr : "0b" + baseStr;
    }

    // Compares two numbers and checks if they are equivalent
    public static boolean equals(String n1, String n2) {
        return number2Int(n1) == number2Int(n2);
    }

    // Finds the maximum value in a string array of numbers
    public static int maxValue(String[] arr) {
        int j =0;
        int maxValue = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            int value = number2Int(arr[i]);
            if (value > maxValue) {
                maxValue = value;
                j = i;
            }
        }
        return j;
    }
}