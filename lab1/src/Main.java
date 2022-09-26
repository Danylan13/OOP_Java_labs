import calculator.StringCalculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = s.nextLine();
        System.out.println(StringCalculator.add(str));
    }
}
