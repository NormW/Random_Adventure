package huawei.io;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Addition {

    public static void main(String[] args) {
//        FullCalculation opr = new FullCalculation();
//        String expression1 = "1+2/4*2-1/-1";
//        String expression2 = "-3*{-(1+2)+[2*2]}";
//        String expression3 = "-4/(2-4)";
//        long result = opr.fullCalculation(expression1);
//        long result2 = opr.fullCalculation(expression2);
//        long result3 = opr.fullCalculation(expression3);
//        System.out.println(result);
//        System.out.println(result2);
//        System.out.println(result3);
//
//        String simple = "3--3";
//        String simple2 = "2/4*2";
//        System.out.println(opr.simpleMath(simple));
//        System.out.println(opr.complexMath(simple2));
        Scanner input = new Scanner(System.in);
        Addition op = new Addition();
        while (input.hasNext()) {
            String value = input.nextLine();
            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < value.length(); i++) {
                builder.append(op.replace(value.charAt(i)));
            }
            System.out.println(builder.toString());
        }

        System.out.println(op.replace('B'));
        System.out.println(op.replace('1'));
        System.out.println(op.replace('a'));
        System.out.println(op.replace('X'));
        System.out.println(op.replace('Z'));
    }

    public void simpleAdditionWithNum() {
        Scanner input = new Scanner(System.in);
        int num = Integer.parseInt(input.nextLine());
        int count = 0;
        while(input.hasNext()) {
            if (++count > num) break;
            String line = input.nextLine();
            String[] values = line.split(" ");
            long sum = 0;
            for (String str : values) {
                sum += Long.parseLong(str);
            }
            System.out.println(sum);
        }
    }

    public void simpleAddition() {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String line = input.nextLine();
            String[] values = line.split(" ");
            long sum = 0;
            for (String str : values) {
                sum += Long.parseLong(str);
            }
            System.out.println("Sum: " + sum);
        }
    }

    public void simpleMathCalculation() {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String formula = input.nextLine();
            String[] values = formula.split("|");
            String value = "";
            int lastOpr = 1;
            int result = 0;

            for (String s : values) {
                switch (s) {
                    case "+":
                        int currentSum = value.length() != 0 ? Integer.parseInt(value) : 0;
                        result += (currentSum * lastOpr);
                        lastOpr = 1;
                        value = "";
                        break;
                    case "-":
                        int currentSub = value.length() != 0 ? Integer.parseInt(value) : 0;
                        result += (currentSub * lastOpr);
                        lastOpr = -1;
                        value = "";
                        break;
                    case "=":
                        int currentResult = value.length() != 0 ? Integer.parseInt(value) : 0;
                        result += (currentResult * lastOpr);
                        System.out.println("Ans : " + result);
                        lastOpr = 1;
                        value = "";
                        break;
                    default:
                        value += s;
                }
            }
        }
    }

    public void mathCalculation() {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String evaluation = input.nextLine();
            String tracker = "";
            String addOrMinus = "";
            String multiplyOrDivide = "";
            long lastAmValue = 0;
            long currentValue = 0;

            for(int i = 0; i < evaluation.length(); i++) {
                char value = evaluation.charAt(i);
                switch (value) {
                    case '+':
                    case '-':
                        if ("*".equals(multiplyOrDivide)) {
                            currentValue = currentValue * Integer.parseInt(tracker);
                            multiplyOrDivide = "*";
                            tracker = "";
                        } else if("/".equals(multiplyOrDivide)) {
                            currentValue = currentValue / Integer.parseInt(tracker);
                            multiplyOrDivide = "/";
                            tracker = "";
                        } else if ("+".equals(addOrMinus)) {
                            currentValue = currentValue + Integer.parseInt(tracker);
                            addOrMinus = "+";
                            tracker = "";
                        } else if ("-".equals(addOrMinus)) {
                            currentValue = currentValue - Integer.parseInt(tracker);
                            addOrMinus = "-";
                            tracker = "";
                        } else {
                            addOrMinus = String.valueOf(value);
                        }
                    break;
                    case '*':
                    case '/':
                        if ("*".equals(multiplyOrDivide)) {
                            currentValue = currentValue * Integer.parseInt(tracker);
                            multiplyOrDivide = "*";
                            tracker = "";
                        } else if("/".equals(multiplyOrDivide)) {
                            currentValue = currentValue / Integer.parseInt(tracker);
                            multiplyOrDivide = "/";
                            tracker = "";
                        } else {
                            multiplyOrDivide = String.valueOf(value);
                            lastAmValue = currentValue;
                            currentValue = Integer.parseInt(tracker);
                            tracker = "";
                        }
                        break;
                    default:
                        tracker += String.valueOf(value);
                }
            }

            if ("*".equals(multiplyOrDivide)) {
                currentValue = currentValue * Integer.parseInt(tracker);
            } else if("/".equals(multiplyOrDivide)) {
                currentValue = currentValue / Integer.parseInt(tracker);
            }

            if ("+".equals(addOrMinus)) {
                currentValue = currentValue + lastAmValue;
            } else if ("-".equals(addOrMinus)) {
                currentValue = lastAmValue - currentValue;
            }

            System.out.println(currentValue);
        }
    }

    public void sortArrayofString() {
        Scanner input = new Scanner(System.in);
        int num = Integer.parseInt(input.nextLine());
        String checkStrings = input.nextLine();
        List<String> stringList = Arrays.asList(checkStrings.split(" "));
        Collections.sort(stringList);
        String result = "";
        for (String value : stringList) {
            result += value + " ";
        }
        System.out.print(result.trim());
    }

    public void sortArrayOfStringNoLimit() {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            String checkStrings = input.nextLine();
            List<String> stringList = Arrays.asList(checkStrings.split(" "));
            Collections.sort(stringList);
            String result = "";
            for (String value : stringList) {
                result += value + " ";
            }
            System.out.println(result.trim());
        }
    }

    public void sortArrayOfStringComma() {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            String checkStrings = input.nextLine();
            List<String> stringList = Arrays.asList(checkStrings.split(","));
            Collections.sort(stringList);
            int size = stringList.size();
            String result = size > 0 ? stringList.get(0) : "";
            for (int i = 1; i < size; i++) {
                result += "," + stringList.get(i);
            }
            System.out.println(result);
        }
    }

    public void findLastLength() {
        Scanner input = new Scanner(System.in);
        String rawValue = input.nextLine();
        String[] stringValues = rawValue.split(" ");
        System.out.println(stringValues[stringValues.length - 1].length());
    }

    public void checkUppercase() {
        Scanner input = new Scanner(System.in);
        String checkString = input.nextLine();
        char[] chars = checkString.toCharArray();
        int count = 0;
        for (char value : chars) {
            if (Character.isUpperCase(value)) {
                count += 1;
            }
        }
        System.out.println(count);
    }

    public void countOnes() {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()) {
            int number = input.nextInt();
            int count = 0;
            while (number != 0) {
                int shiftLeft = number >> 1;
                if (number != shiftLeft * 2) {
                    count += 1;
                }
                number = shiftLeft;
            }
            System.out.println(count);
        }
    }

    public void checkMaximum() {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int count = Integer.parseInt(input.nextLine());
            if (count == 0) break;

            int number = 0;
            while (count >= 3) {
                int remaining = count % 3;
                int divider = count / 3;
                number += divider;
                count = divider + remaining;
             }
            if (count == 2) number++;
            System.out.println(number);
        }
    }

    public void checkValidPW() {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()) {
            String password = input.nextLine();
            boolean isValid = password.length() > 8;
            String countNumber = password.replaceAll("[^0-9]", "");
            String countLowerCase = password.replaceAll("[^a-z]", "");
            String countUpperCase = password.replaceAll("[^A-Z]", "");
            String countSymbol = password.replaceAll("[a-zA-Z0-9]", "");

            if(isValid && countNumber.length() == 0) {
                isValid = (countLowerCase.length() > 0) && (countUpperCase.length() > 0) && (countSymbol.length() > 0);
            } else if (isValid && countLowerCase.length() == 0) {
                isValid = (countUpperCase.length() > 0) && (countSymbol.length() > 0);
            } else if (isValid && countUpperCase.length() == 0) {
                isValid = (countSymbol.length() > 0);
            }

            if (isValid) {
                for (int i = 0; i < password.length() - 3; i++) {
                    String sub = password.substring(i, i + 3);
                    String remaining = password.substring(i+3);
                    if (remaining.contains(sub)) {
                        isValid = false;
                        break;
                    }
                }
            }
            System.out.println((isValid)?"OK":"NG");
        }
    }

    public String replace(char in) {
        String strValue = String.valueOf(in);

        if ("abc".contains(strValue)) {
            return "2";
        } else if ("def".contains(strValue)) {
            return "3";
        } else if ("ghi".contains(strValue)) {
            return "4";
        } else if ("jkl".contains(strValue)) {
            return "5";
        } else if ("mno".contains(strValue)) {
            return "6";
        } else if ("pqrs".contains(strValue)) {
            return "7";
        } else if ("tuv".contains(strValue)) {
            return "8";
        } else if ("wxyz".contains(strValue)) {
            return "9";
        }

        if ('Z' == in) return "a";
        if ((int) in >= (int) 'A' && (int) in < (int) 'Z') {
            int nextValue = (int) in + 1;
            return String.valueOf((char) nextValue).toLowerCase();
        }
        return strValue;
    }

    static class FullCalculation {

        public int simpleMath(String expression) {
            String value = "";
            int lastOpr = 1;
            int result = 0;

            for (int i = 0; i < expression.length(); i++) {
                char val = expression.charAt(i);
                switch (val) {
                    case '+':
                        result += value.isEmpty() ? 0 : (Integer.parseInt(value) * lastOpr);
                        lastOpr = 1;
                        value = "";
                        break;
                    case '-':
                        char previous = (i != 0) ? expression.charAt(i-1) : ' ';
                        if (previous == '-' || previous == '+' || previous == ' ') {
                            value += String.valueOf(val);
                        } else {
                            result += value.isEmpty() ? 0 : (Integer.parseInt(value) * lastOpr);
                            lastOpr = -1;
                            value = "";
                        }
                        break;
                    default:
                        value += String.valueOf(val);
                }
            }

            result += (Integer.parseInt(value) * lastOpr);
            return result;
        }

        public int complexMath(String expression) {
            String value = "";
            boolean isMultiple = true;
            int result = 1;

            for (int i = 0; i < expression.length(); i++) {
                char val = expression.charAt(i);
                switch (val) {
                    case '*':
                        if (isMultiple) {
                            result = result * (Integer.parseInt(value));
                        } else {
                            result = result / (Integer.parseInt(value));
                        }
                        value = "";
                        isMultiple = true;
                        break;
                    case '/':
                        if (isMultiple) {
                            result = result * (Integer.parseInt(value));
                        } else {
                            result = result / (Integer.parseInt(value));
                        }
                        value = "";
                        isMultiple = false;
                        break;
                    default:
                        value += String.valueOf(val);
                }
            }
            return isMultiple
                    ? result * (Integer.parseInt(value))
                    : result / (Integer.parseInt(value));
        }

        public List<String> findComplexExpression(String expression) {
            ArrayList<String> complexExpressions = new ArrayList<>();
            int begin = 0;
            for (int i = 0; i < expression.length(); i++) {
                char val = expression.charAt(i);
                switch (val) {
                    case '+':
                        String current = expression.substring(begin, i);
                        if (current.contains("*") || current.contains(("/"))) {
                            complexExpressions.add(current);
                        }
                        begin = i + 1;
                        break;
                    case '-':
                        String minusCurrent = expression.substring(begin, i);
                        char previous = (i != 0) ? expression.charAt(i-1) : ' ';
                        if(previous == '*' || previous == '/' || previous == ' ') {
                            break;
                        }

                        if (minusCurrent.contains("*") || minusCurrent.contains("/")) {
                            complexExpressions.add(minusCurrent);
                        }
                        begin = i + 1;
                        break;
                    case '*':
                    case '/':
                    default:
                }
                if (i == expression.length() - 1) {
                    String current = expression.substring(begin);
                    if (current.contains("*") || current.contains("/")) {
                        complexExpressions.add(current);
                    }
                }
            }
            return complexExpressions;
        }

        public int calculation(String expression) {
            List<String> complexExpressions = findComplexExpression(expression);
            for (String complex : complexExpressions) {
                int complexValue = complexMath(complex);
                expression = expression.replace(complex, String.valueOf(complexValue));
            }

            return simpleMath(expression);
        }

        public int fullCalculation(String expression) {
            Matcher smallBrackets = Pattern.compile("\\(([^)]+)\\)").matcher(expression);
            while (smallBrackets.find()) {
                String findExpression = smallBrackets.group(1);
                String bracketExpression = "(" + findExpression + ")";
                expression = expression.replace(bracketExpression, String.valueOf(calculation(findExpression)));
            }

            Matcher medianBrackets = Pattern.compile("\\[([^]]+)\\]").matcher(expression);
            while (medianBrackets.find()) {
                String findExpression = medianBrackets.group(1);
                String bracketExpression = "[" + findExpression + "]";
                expression = expression.replace(bracketExpression, String.valueOf(calculation(findExpression)));
            }

            Matcher largeBrackets = Pattern.compile("\\{([^}]+)\\}").matcher(expression);
            while (largeBrackets.find()) {
                String findExpression = largeBrackets.group(1);
                String bracketExpression = "{" + findExpression + "}";
                expression = expression.replace(bracketExpression, String.valueOf(calculation(findExpression)));
            }

            return calculation(expression);
        }
    }

    static class MathOperation {

        public long findSmallest(long number) {
            long half = number / 2;
            for (int i = 2; i < half; i ++) {
                if (number % i == 0) {
                    return i;
                }
            }
            return number;
        }

        public void findAll(long number) {
            while(number > 1) {
                long small = findSmallest(number);
                number = number / small;
                System.out.print(small + " ");
            }
        }
    }
}
