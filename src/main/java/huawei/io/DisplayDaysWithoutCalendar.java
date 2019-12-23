package huawei.io;

import java.util.Scanner;

public class DisplayDaysWithoutCalendar {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DisplayDaysWithoutCalendar operator = new DisplayDaysWithoutCalendar();
        while (input.hasNext()) {
            int year = input.nextInt();
            int month = input.nextInt();
            int day = input.nextInt();

            int additionalDay = (year % 100 == 0)
                    ? (year % 400 == 0) ? 1 : 0
                    : (year % 4 == 0) ? 1 : 0;
            int monthToDay = operator.cumulativeMonthToDay(month);
            System.out.println((additionalDay + monthToDay + day));
        }
    }

    public int cumulativeMonthToDay(int month) {
        if(month <= 0) return 0;
        return convertMonthToday(month - 1) + cumulativeMonthToDay(month - 1);
    }

    public int convertMonthToday(int month) {
        switch (month) {
            case 2:
                return 28;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 0;
        }
    }
}
