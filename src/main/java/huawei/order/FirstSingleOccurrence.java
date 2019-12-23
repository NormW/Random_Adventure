package huawei.order;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstSingleOccurrence {

    public String findFirst(String nonNullValue) {
        Map<Character, Integer> linkedMap = new LinkedHashMap<>();
        for (int i = 0; i < nonNullValue.length(); i++) {
            Character current = Character.valueOf(nonNullValue.charAt(i));
            int occurrence = linkedMap.containsKey(current)
                    ? linkedMap.get(current) + 1
                    : 1;
            linkedMap.put(current, occurrence);
        }

        Character[] keys = new Character[linkedMap.size()];
        linkedMap.keySet().toArray(keys);
        String first = "-1";
        for (Character key : keys) {
            if (linkedMap.get(key) == 1) {
                first = String.valueOf(key);
                break;
            }
        }
        return first;
    }
}
