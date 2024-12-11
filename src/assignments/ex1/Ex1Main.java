package assignments.ex1;

import java.util.Scanner;

public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2 = "", quit = "quit";
        while (true) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.print("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();
            if (!num1.contains("b"))
                num1 = num1 + "bA";
            if (num1.equals(quit)) break;
            if (!Ex1.isNumber(num1)) {
                System.out.println("ERR: The number you entered is in the wrong format!");
                continue;
            }

            System.out.print("Enter a string as number#2 (or \"quit\" to end the program): ");
            num2 = sc.next();
            if (!num2.contains("b"))
                num2 = num2 + "bA";
            if (num2.equals(quit)) break;

            if (!Ex1.isNumber(num2)) {
                System.out.println("ERR: The number you entered is in the wrong format!");
                continue;
            }

            int value1 = Ex1.number2Int(num1);
            System.out.println("value1 = " + value1);
            int value2 = Ex1.number2Int(num2);
            System.out.println("value2 = " + value2);

            System.out.print("Enter a base for output (a number [2,16]): ");
            int base = sc.nextInt();

            if (base < 2 || base > 16) {
                System.out.println("ERR: Base is not in the valid range [2,16]!");
                continue;
            }

            int sum = value1 + value2;
            int product = value1 * value2;

            String sumStr = Ex1.int2Number(sum, base);
            String productStr = Ex1.int2Number(product, base);
            if (sumStr.contains("b10"))
                sumStr = sumStr.replace("b10","");
            System.out.println(num1 + " + " + num2 + " = " + sumStr);
            if (productStr.contains("b10"))
                productStr = productStr.replace("b10","");
            System.out.println(num1 + " * " + num2 + " = " + productStr);

            String[] results = {num1, num2, sumStr, productStr};
            String maxIdx = results [Ex1.maxValue(results)];
            System.out.println("Max number over [" + String.join(",", results) + "] is " + maxIdx);
        }
        System.out.println("Quitting now...");
        sc.close();
    }
}