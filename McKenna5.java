// 232792560
public class McKenna5 {
    public static void main(String[] args) {
        boolean numFound = false;
        double i = 20;
        while (numFound == false) {
            for (int j = 1; j <= 20; j++) {
                if (i/j % 1 != 0)
                    break;
                if (j == 20)
                    numFound = true;
            }
            i++;
        }
        System.out.println(i-1);
    }
}
