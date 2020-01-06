package huawei.test;

import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main operator = new Main();
        String output = operator.reduceSpaces("/a/../../b//c/..////././asdas.c");
        String output2 = operator.reduceSpaces("");
        String output3 = operator.reduceSpaces("/..");
        String output4 = operator.reduceSpaces("../");
        System.out.println(operator.printPath(output));
        System.out.println(operator.printPath(output2));
        System.out.println(operator.printPath(output3));
        System.out.println(operator.printPath(output4));

        BigInteger one = new BigInteger("122333");
        BigInteger two = new BigInteger("123123124");
        System.out.println(one.add(two).toString());
    }

    public String reduceSpaces(String value) {
        boolean lastBackSlash = false;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < value.length(); i++) {
            char current = value.charAt(i);
            if ('/' == current && !lastBackSlash) {
                builder.append(current);
                lastBackSlash = true;
            } else if ('/' != current) {
                builder.append(current);
                lastBackSlash = false;
            }
        }
        List<String> asd= new LinkedList<>();
        return builder.toString();
    }

    public String printPath(String path) {
        Stack<String> status = new Stack<>();
        String[] stages = path.split("/");
        for (String stage : stages) {
            switch (stage) {
                case "..":
                    if(!status.isEmpty()) {
                        status.pop();
                    }
                    break;
                case ".":
                    break;
                case "":
                default:
                    status.push(stage);
                    break;
            }
        }
        String displayOutput = "";
        while (!status.isEmpty()) {
            String current = status.pop();
            displayOutput = (status.isEmpty())
                    ? current + displayOutput
                    : "/" + current + displayOutput;
        }
        return (displayOutput.length() == 0)
                ? "/"
                : displayOutput;
    }
}
