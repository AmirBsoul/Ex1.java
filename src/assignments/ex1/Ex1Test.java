package assignments.ex1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Ex1Test {

    @Test
    public void testNumber2Int() {
        assertEquals(10, Ex1.number2Int("10")); // Decimal
        assertEquals(2, Ex1.number2Int("10b2")); // Binary
        assertEquals(255, Ex1.number2Int("FFbG")); // Hexadecimal
        assertEquals(-1, Ex1.number2Int("123b17")); // Invalid base
        assertEquals(-1, Ex1.number2Int("G1bG")); // Invalid character for base
        assertEquals(-1, Ex1.number2Int(null)); // Null input
        assertEquals(-1, Ex1.number2Int("")); // Empty input
        assertEquals(123, Ex1.number2Int("123")); // Default base 10
    }

    @Test
    public void testIsNumber() {
        assertTrue(Ex1.isNumber("9")); // Valid decimal
        assertTrue(Ex1.isNumber("101b2")); // Valid binary
        assertTrue(Ex1.isNumber("A1bG")); // Valid hexadecimal
        assertFalse(Ex1.isNumber("123bH")); // Invalid base
        assertFalse(Ex1.isNumber("G1bG")); // Invalid character for base
        assertFalse(Ex1.isNumber(null)); // Null input
        assertFalse(Ex1.isNumber("")); // Empty input
        assertTrue(Ex1.isNumber("123")); // Default base 10
    }

    @Test
    public void testInt2Number() {
        assertEquals("10b10", Ex1.int2Number(10, 10)); // Decimal
        assertEquals("101b2", Ex1.int2Number(5, 2)); // Binary
        assertEquals("", Ex1.int2Number(-1, 10)); // Negative number
        assertEquals("", Ex1.int2Number(10, 17)); // Invalid base
        assertEquals("", Ex1.int2Number(10, 1)); // Invalid base
    }

    @Test
    public void testEquals() {
        assertTrue(Ex1.equals("10", "1010b2")); // Decimal equals binary
        assertFalse(Ex1.equals("A1bG", "101b2")); // Hexadecimal not equals binary
        assertTrue(Ex1.equals("FFbG", "255")); // Hexadecimal equals decimal
        assertFalse(Ex1.equals("10", "11")); // Different values
        assertFalse(Ex1.equals("10", null)); // Null comparison
    }

    @Test
    public void testMaxIndex() {
        String[] arr1 = {"10", "101b2", "A1bG"};
        assertEquals(2, Ex1.maxValue(arr1)); // A1b16 (161) is largest

        String[] arr2 = {"5", "4", "3"};
        assertEquals(0, Ex1.maxValue(arr2)); // 5 is largest

        String[] arr3 = {"10"};
        assertEquals(0, Ex1.maxValue(arr3)); // Single element

        String[] arr4 = {};
        assertEquals(0, Ex1.maxValue(arr4)); // Empty array

    }
}