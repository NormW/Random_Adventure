package huawei.io;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Main operator = new Main();
        Map<String, Integer> map = new LinkedHashMap<>();
        int numebr = 0;
        while (input.hasNext() && numebr < 20) {
            String rawValue = input.nextLine();
            String[] values = rawValue.split(" ");
            String fileRecord = operator.getFilename(values[0]) + " " + values[1];
            int count = map.get(fileRecord) == null
                    ? 0
                    : map.get(fileRecord);
            map.put(fileRecord, ++count);
            numebr ++;
        }
        String[] keys = map.keySet().toArray(new String[0]);
        StringBuilder builder = new StringBuilder();
        for (int i = Math.max(0, keys.length - 8); i < keys.length; i++) {
            builder.append(keys[i] + " " + map.get(keys[i]) + " ");
        }
        System.out.println(builder.toString());
    }

    public String getFilename(String file) {
        int index = file.lastIndexOf("\\");
        String fileName = file.substring(index+1);
        return (fileName.length() <= 16)
                ? fileName
                : fileName.substring(fileName.length() - 16);
    }
}