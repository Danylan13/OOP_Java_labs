package calculator;

import java.util.Scanner;
import java.util.regex.Pattern;

public class StringCalculator {
    public static int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        else if(numbers.length() > 1) {
            String[] symbols = change(numbers);
            int sum = 0;
            for (String sym : symbols) {
                if (sym.isEmpty())
                    throw new RuntimeException("The input data is incorrect");
                int x = Integer.parseInt(sym);
                if (x < 0)
                    throw new RuntimeException("Negatives numbers not allowed: " + negative(symbols));
                if (x <= 1000)
                    sum += x;
            }
            return sum;
        }
        else {
            return Integer.parseInt(numbers);
        }
    }

    private static String[] change(String numbers) {
        StringBuilder del = new StringBuilder("\\\\n|,");
        if (numbers.startsWith("//")) {
            //if () {}
            String str = numbers.substring(numbers.indexOf("\\n") + 2);
            del.append("|").append(numbers.charAt(2));
            Pattern pattern = Pattern.compile(del.toString());
            return pattern.split(str);
        }
        Pattern pattern = Pattern.compile(del.toString());
        return pattern.split(numbers);
    }

    private static String negative(String[] symbols) {
        StringBuilder str = new StringBuilder();
        for (String sym : symbols) {
            int x = Integer.parseInt(sym);
            if (x < 0) {
                str.append(x);
                str.append(", ");
            }
        }
        return str.substring(0, str.lastIndexOf(","));
    }
}

