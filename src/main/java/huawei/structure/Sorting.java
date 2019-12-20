package huawei.structure;

import java.math.BigInteger;
import java.util.*;

public class Sorting {

    public static void main(String[] args) {
        //Method for Biggest Number Range.
        new BigInteger("abc",16);
        String test = "#$Y^!#Pf&~#FUyTtAfZhCs&Dly%M@(muOI@Le^mydvc((w$x-cP&t-f$R%CCp)bCck@P-ag";
        LetterSort opr = new LetterSort();
        opr.sortLetters(test);

        String test2 = "  asd ".replaceAll("[^ ]", "");
        System.out.println(test2.length()+"");

        int[] test1 = new int[]{1,2,4};
        int[] test3 = test1;

        test3[0] = 5;
        System.out.println(test1[0]+"");
        System.out.println(Integer.toBinaryString(10));

        int i = 1_000_000_000;
        int j = 2_000_000_000;
        System.out.println("Sum " + ((long) i+j));
    }

    static class RelativeSorting {

        public void relativeChecking() {
            Scanner input = new Scanner(System.in);
            while (input.hasNext()) {
                String rawData = input.nextLine();
                String[] values = rawData.split(" ");
                int number = Integer.parseInt(values[0]);
                String[] dicts = (number > 0) ? Arrays.copyOfRange(values, 1, number + 1) : new String[]{};
                String target = (number > 0) ? values[number + 1] : "";
                int order = (number > 0) ? Integer.parseInt(values[number + 2]) : 0;

                String result = (number > 0) ? getTargetValue(dicts, target, order) : "";
                if (number > 0 && !result.isEmpty()) System.out.println(result);
            }
        }

        private String getTargetValue(String[] values, String target, int order) {
            ArrayList<String> relatives = new ArrayList<>();
            for (String value : values) {
                if (isRelative(target, value)) {
                    relatives.add(value);
                }
            }
            Collections.sort(relatives);
            System.out.println(relatives.size());
            return (relatives.size() >= order) ? relatives.get(order - 1) : "";
        }

        private boolean isRelative(String one, String two) {
            if (one.equals(two) || one.length() != two.length()) {
                return false;
            }

            char[] charOne = one.toCharArray();
            char[] charTwo = two.toCharArray();
            Arrays.sort(charOne);
            Arrays.sort(charTwo);

            return new String(charOne).equals(new String(charTwo));
        }
    }

    static class LongestCommonString {

        public static String getLongestCommon(String one, String two) {
            String des = one.length() > two.length() ? one : two;
            String source = one.equals(des) ? two : one;

            int longestLength = 0;
            String longest = "";
            for (int i = 0; i < source.length(); i ++) {
                for (int j = Math.max(1 , longestLength) + i; j < source.length(); j ++) {
                    if (des.contains(source.substring(i, j + 1)) && (longestLength < (j-i))) {
                        longestLength = j - i;
                        longest = source.substring(i, j + 1);
                    }
                }
            }
            return longest;
        }

        public String findLongestCommon(String one, String two) {
            String des = one.length() > two.length() ? one : two;
            String source = one.equals(des) ? two : one;
            int longestLength = 0;
            String longest = "";
            while(source.length() > longestLength) {
                longest = findLongest(des, source, longest);
                source = source.substring(1);
            }

            return longest;
        }

        public String findLongest(String des, String source, String currentLongest) {
            int longestLength = currentLongest.length();
            String longest = currentLongest;

            for(int i = 0; (i < des.length()) && (longestLength < (des.length()- i -1)); i ++) {
                int count = 0;
                for (int j = 0; j < source.length() && (i + j < des.length()); j ++) {
                    if (des.charAt(i + j) == source.charAt(j)) {
                        count++;
                    } else {
                        break;
                    }
                }
                if (count > longestLength) {
                    longest = source.substring(0, count);
                    longestLength = count;
                }
            }
            return  longest;
        }
    }

    public void reverseString() {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()) {
            String rawValue = input.nextLine();
            String cleanValue = rawValue.replaceAll("[^a-zA-Z]", " ");
            String[] values = cleanValue.trim().replaceAll("(\\s)+", " ").split(" ");
            StringBuilder builder = new StringBuilder();

            for (int i = values.length - 1; i >= 0; i--) {
                builder.append(values[i]).append(" ");
            }
            System.out.println(builder.toString().trim());
        }
    }

    public void sortRandom() {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int count = Integer.parseInt(input.nextLine());
            ArrayList<Integer> values = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                Integer check = Integer.parseInt(input.nextLine());
                if (!values.contains(check)) {
                    values.add(check);
                }
            }
            Collections.sort(values);
            for (int value : values) {
                System.out.println(value);
            }
        }
    }

    public void sortPair() {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()) {
            int number = Integer.parseInt(input.nextLine());
            Map<Integer, Long> paris = new HashMap<>();
            for (int i = 0; i < number; i ++) {
                String rawValue = input.nextLine();
                String[] values = rawValue.split(" ");
                Integer key = Integer.parseInt(values[0]);
                Long value = Long.parseLong(values[1]);
                if (paris.containsKey(key)) {
                    long previous = paris.get(key);
                    paris.put(key, value + previous);
                } else {
                    paris.put(key, value);
                }
            }

            List<Integer> keys = new ArrayList<>(paris.keySet());
            Collections.sort(keys);
            for (Integer key : keys) {
                System.out.println(key + " " + paris.get(key));
            }
        }
    }

    public String getFilename(String file) {
        int index = file.lastIndexOf("\\");
        return file.substring(index + 1);
    }

    static class CheckIp {

        public String convertToNumber(String ip) {
            String[] values = ip.split("\\.");
            long result = 0;
            for (String value : values) {
                int intValue = Integer.parseInt(value);
                result = (result << 8) + intValue;
            }
            return String.valueOf(result);
        }

        public String convertToId(String number) {
            long longValue = Long.parseLong(number);
            long first = ((longValue & ((long)255 << 24)) >> 24);
            long second = ((longValue & ((long)255 << 16)) >> 16);
            long third = ((longValue & ((long)255 << 8)) >> 8);
            long forth = (longValue & (255));

            return first + "." + second + "." + third + "." + forth;
        }
    }

    static class SimpleSort {
        public void reverseNumber(String number) {
            Set<Character> numberSet = new HashSet<>();
            for (int i = number.length() - 1; i >= 0; i--) {
                if (!numberSet.contains(number.charAt(i))) {
                    System.out.print(number.charAt(i));
                    numberSet.add(number.charAt(i));
                }
            }
            System.out.println("");
        }

        public void sortStrings() {
            Scanner input = new Scanner(System.in);
            while(input.hasNext()) {
                int number = Integer.parseInt(input.nextLine());
                String[] values = new String[number];
                for (int i = 0; i < number; i++) {
                    values[i] = input.nextLine();
                }
                Arrays.sort(values);
                for (String value : values) {
                    System.out.println(value);
                }
            }
        }

        public void removeRedundant() {
            Scanner input = new Scanner(System.in);
            while (input.hasNext()) {
                String value = input.nextLine();
                int[] container = new int[26];
                Arrays.fill(container, Integer.MAX_VALUE);
                for (int i = 0; i < value.length(); i++) {
                    int index = value.charAt(i) - 'a';
                    container[index] = (container[index] == Integer.MAX_VALUE)
                            ? 1
                            : container[index] + 1;
                }
                int min = Integer.MAX_VALUE;
                for (int count : container) {
                    min = Math.min(count, min);
                }
                String output = "";
                for (int i = 0; i < value.length(); i++) {
                    int index = value.charAt(i) - 'a';
                    if (container[index] != min && container[index] != Integer.MAX_VALUE) {
                        output += value.charAt(i);
                    }
                }
                System.out.println(output);
            }
        }
    }

    static class MatrixMove {

        public void checkMove () {
            int[] matrix = new int[]{0, 0};
            Scanner input = new Scanner(System.in);
            while (input.hasNext()) {
                String[] operations = input.nextLine().split(";");
                for (String operation : operations) {
                    if(isValid(operation)) {
                        String direction = operation.substring(0, 1);
                        int moves = Integer.parseInt(operation.substring(1));
                        switch (direction) {
                            case "A":
                                System.out.println(matrix[0] + "-" + moves + "to" + (matrix[0] - moves));
                                matrix[0] = matrix[0] - moves;
                                break;
                            case "W":
                                matrix[1] = matrix[1] + moves;
                                break;
                            case "S":
                                matrix[1] = matrix[1] - moves;
                                break;
                            case "D":
                                System.out.println(matrix[0] + "+" + moves + "to" + (matrix[0] + moves));
                                matrix[0] = matrix[0] + moves;
                                break;
                        }
                    }
                }
                System.out.println(matrix[0] + "," + matrix[1]);
            }
        }

        public boolean isValid(String operation) {
            if(operation.length() > 3 || operation.length() < 2) return false;
            String direction = operation.substring(0, 1);
            String moves = operation.substring(1);

            boolean isValid = false;
            if ("A".equalsIgnoreCase(direction)
                    || "S".equalsIgnoreCase(direction)
                    || "W".equalsIgnoreCase(direction)
                    || "D".equalsIgnoreCase(direction)) {
                try {
                    int validMove = Integer.parseInt(moves);
                    isValid = true;
                } catch(NumberFormatException e) {
                    isValid = false;
                }
            }
            return isValid;
        }
    }

    static class LetterSort {

        public String sortLetters(String value) {
            String allLetters = value.replaceAll("[^a-zA-Z]", "");
            List<Character> charsList = new ArrayList<>();
            for (int i = 0; i < allLetters.length(); i++) {
                charsList.add(allLetters.charAt(i));
            }
            sortChars(charsList);
            for (int i = 0; i < value.length(); i++) {
                if (!Character.isLetter(value.charAt(i))) {
                    charsList.add(i, value.charAt(i));
                }
            }
            StringBuilder builder = new StringBuilder();
            for (Character character : charsList) {
                builder.append(character);
            }
            return builder.toString();
        }

        public void sortChars(List<Character> charsArray) {
            Collections.sort(charsArray, new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {
                    return Character.compare(Character.toLowerCase(o1),
                            Character.toLowerCase(o2));
                }
            });
        }

        static class CharWithIndex implements Comparable<CharWithIndex> {
            int index;
            char charValue;

            public CharWithIndex(char charValue, int index) {
                this.index = index;
                this.charValue = charValue;
            }

            @Override
            public int compareTo(CharWithIndex o) {
                char lowerCaseSelf = Character.toLowerCase(charValue);
                char lowerCaseOther = Character.toLowerCase(o.charValue);

                return (lowerCaseSelf == lowerCaseOther)
                        ? Integer.compare(index, o.index)
                        : Character.compare(lowerCaseSelf, lowerCaseOther);
            }
        }

        public void sortCharts(char[] charsArray, int begin, int end) {
            if (end <= begin) return;

            for (int i = begin + 1; i < end; i++) {
                char min = charsArray[begin];
                char current = charsArray[i];

                if (Character.toLowerCase(min) > Character.toLowerCase(current)) {
                    charsArray[begin] = current;
                    charsArray[i] = min;
                }
            }
            sortCharts(charsArray, begin + 1, end);
        }
    }
}
