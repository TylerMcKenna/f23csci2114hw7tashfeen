// 171
public class McKenna19 {
    public static void main(String[] args) {
        //                           Jan Feb Mar Apr May Jun Jul Aug Sep Oct Nov Dec  
        int[] normalMonthSequence = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // Febuary has 29 instead of 28
        int[] leapMonthSequence = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int year = 1901;
        // 1 Monday, 2 Tuesday, 3 Wednesday, 4 Thursday
        // 5 Friday, 6 Saturday, 7/0 Sunday, 8/1 Monday
        // Monday is 1, Sunday is 0, mod 7 to get current day
        int currDay = 1;
        int firstSundayCount = 0;

        int[] currMonthSequence;
        // 1901 - 2, 1902 - 2, 1903 - 1, 1904 - 2, 1905 - 1, 1906 - 2, 1907 - 2, 1908 - 1, 1909 - 2
        while(year <= 2010) {
            currMonthSequence = ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
                ? leapMonthSequence
                : normalMonthSequence;
            for (int i = 0; i < 12; i++) {
                currDay %= 7;
                if (currDay == 0) firstSundayCount++;
                currDay += currMonthSequence[i];
            }
            year++;
        }
        System.out.println(firstSundayCount - 1);
    }
}