package huawei.structure;

import java.util.*;

public class SortIntegerAndString {
    //Another Strategy. Keep array(or list) in an order after each insert.
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            Map<Integer, ArrayList<String>> record = new HashMap<>();
            int number = Integer.parseInt(input.nextLine());
            boolean isReverse = Integer.parseInt(input.nextLine()) == 0;
            for (int i = 0; i < number; i++) {
                String[] values = input.nextLine().split(" ");
                String name = values[0];
                Integer score = Integer.parseInt(values[1]);
                ArrayList<String> names = record.containsKey(score)
                                        ? record.get(score)
                                        : new ArrayList<>();
                names.add(name);
                record.put(score, names);
            }

            Integer[] scores = record.keySet().toArray(new Integer[0]);
            if(isReverse) {
                Arrays.sort(scores, (o1, o2) -> Integer.compare(o2, o1));
            } else {
                Arrays.sort(scores);
            }

            for (Integer score : scores) {
                for (String name : record.get(score)) {
                    System.out.println(name + " " + score);
                }
            }
        }
    }
}
