import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите выражение.");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println("Вывод: " + input + " = " + calc(input));
    }
    public static String calc(String input){
        int num1 =0; int num2 = 0;
        int result;
        char operation = 0;
        char[] mass = new char[10];
        for (int i = 0; i < input.length(); i++) {
            mass[i] = input.charAt(i);
            if (mass[i] == '+') {
                operation = '+';
            }
            if (mass[i] == '-') {
                operation = '-';
            }
            if (mass[i] == '*') {
                operation = '*';
            }
            if (mass[i] == '/') {
                operation = '/';
            }
        }
        String[] string = input.split("[+-/*]");
        String str1 = string[0];
        String str2 = string[1];
        String str3 = str2.trim();

        if (NumRoman.romanToNumber(str1) != -1) {
            num1 = NumRoman.romanToNumber(str1);
            num2 = NumRoman.romanToNumber(str3);
            result = calc(num1, num2, operation);
            String resultRoman = NumRoman.convertNumToRoman(result);
            System.out.println(resultRoman);
        } else {
            num1 = Integer.parseInt(str1);
            num2 = Integer.parseInt(str3);
            result = calc(num1, num2, operation);
            System.out.println(result);
        }
        return str1;
    }
    public static int calc(int num1, int num2, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                try {
                    result = num1 / num2;
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                throw new IllegalArgumentException("Не верный знак");
        }
        return result;
    }

}
