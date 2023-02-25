/**
 * @author GoKEY
 */

import java.util.Scanner;


import static java.lang.String.valueOf;

public class Main {


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите выражение: ");
        String expression = sc.nextLine();
        System.out.println(calc(expression));
    }

    public static String calc(String input) throws Exception {
        String result;
        String[] ex = input.split("[+\\-*/]");
        if (ex.length != 2) {
            if (ex.length < 2) {
                throw new Exception("строка не является математической операцией");
            }
            throw new Exception("формат математической операции не удовлетворяет заданию");
        } else {
            String num1 = ex[0];
            String num2 = ex[1];
            String action = identificationAction(input);
            boolean isArabic = false;
            boolean isArabic1 = false;
            boolean isArabic2 = false;
            boolean isRoman = false;
            boolean isRoman1 = false;
            boolean isRoman2 = false;
            boolean isExpression = false;

            if ((num1.contains("0") || num1.contains("1") || num1.contains("2")
                    || num1.contains("3") || num1.contains("4") || num1.contains("5")
                    || num1.contains("6") || num1.contains("7") || num1.contains("8")
                    || num1.contains("9"))) {
                isArabic1 = true;
            }
            if (num2.contains("0") || num2.contains("1") || num2.contains("2")
                    || num2.contains("3") || num2.contains("4") || num2.contains("5")
                    || num2.contains("6") || num2.contains("7") || num2.contains("8")
                    || num2.contains("9")) {
                isArabic2 = true;
            }
            if (isArabic1 && isArabic2) {
                isArabic = true;
            }
            if ((num1.contains("I") || num1.contains("II") || num1.contains("III")
                    || num1.contains("IV") || num1.contains("V") || num1.contains("VI")
                    || num1.contains("VII") || num1.contains("VIII") || num1.contains("IX")
                    || num1.contains("X"))) {
                isRoman1 = true;
            }
            if (num2.contains("I") || num2.contains("II") || num2.contains("III")
                    || num2.contains("IV") || num2.contains("V") || num2.contains("VI")
                    || num2.contains("VII") || num2.contains("VIII") || num2.contains("IX")
                    || num2.contains("X")) {
                isRoman2 = true;
            }
            if (isRoman1 && isRoman2) {
                isRoman = true;
            }
            if (isArabic || isRoman) {
                isExpression = true;
            } else {
                throw new Exception("используются одновременно разные системы счисления");
            }

            if (isArabic) {
                int int1 = Integer.parseInt(num1);
                int int2 = Integer.parseInt(num2);
                if (int1 > 10 || int2 > 10) {
                    throw new Exception("Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более.");
                }
                if (action.equals("/") && int2 == 0) {
                    throw new Exception("на ноль делить нельзя");
                }
                result = valueOf(calculate(int1, int2, action));

            } else {
                Converter converter = new Converter();
                boolean chek1 = converter.checkMap(num1);
                boolean chek2 = converter.checkMap(num2);
                if (!chek1 && !chek2) {
                    throw new Exception("Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более.");
                }
                int num1Int = converter.getIntFromStringRomanArabic(num1);
                int num2Int = converter.getIntFromStringRomanArabic(num2);
                if (num2Int > num1Int) {
                    throw new Exception("в римской системе нет отрицательных чисел");
                }
                int resNum = calculate(num1Int, num2Int, action);
                result = converter.getRomanFromArabic(resNum);
            }
            return result;
        }
    }

    static String identificationAction(String str) {
        String action = null;
        if (str.contains("+")) {
            action = "+";
        } else if (str.contains("-")) {
            action = "-";
        } else if (str.contains("*")) {
            action = "*";
        } else if (str.contains("/")) {
            action = "/";
        }
        return action;
    }

    public static int calculate(int a, int b, String action) {
        return switch (action) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            default -> a / b;
        };
    }
}