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

        int base = Character.isDigit(baseStr.charAt(0)) ? Integer.parseInt(baseStr) : baseStr.charAt(0) - 'A' + 10;
        int result = 0;

        for (char c : number.toCharArray()) {
            int digitValue = Character.isDigit(c) ? c - '0' : Character.toUpperCase(c) - 'A' + 10;
            result = result * base + digitValue;
        }
        return result;
    }

    // Validates if a string is in a valid number format
    public static boolean isNumber(String a) {
        if (a == null || a.isEmpty()) return false;

        // Handle case where the input is just a number without "b"
        if (!a.contains("b")) {
            return a.matches("\\d+"); // Only digits are allowed for decimal base
        }

        String[] parts = a.split("b");
        if (parts.length != 2) return false;

        String number = parts[0];
        String baseStr = parts[1];

        if (number.isEmpty() || baseStr.isEmpty()) return false;
        if (!baseStr.matches("[2-9A-G]")) return false;

        int base = Character.isDigit(baseStr.charAt(0)) ? Integer.parseInt(baseStr) : baseStr.charAt(0) - 'A' + 10;
        if (base < 2 || base > 16) return false;

        for (char c : number.toCharArray()) {
            int digitValue = Character.isDigit(c) ? c - '0' : Character.toUpperCase(c) - 'A' + 10;
            if (digitValue >= base) return false;
        }
        return true;
    }

    // Converts an integer to its representation in a given base
    public static String int2Number(int num, int base) {
        if (num < 0 || base < 2 || base > 16) return "";
        StringBuilder result = new StringBuilder();
        while (num > 0) {
            int digit = num % base;
            char digitChar = (char) (digit < 10 ? '0' + digit : 'A' + digit - 10);
            result.insert(0, digitChar);
            num /= base;
        }
        return result.length() > 0 ? result + "b" + (base <= 10 ? base : (char) ('A' + base - 10)) : "0b" + base;
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