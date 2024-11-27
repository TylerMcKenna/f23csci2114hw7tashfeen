// 840
public class McKenna39 {
    public static void main(String[] args) {
        int n = 1000; // Find best number

        // List where we add 1 to an index if we find an integral right triangle with perimiter = index value
        int[] list = new int[n + 1];
        for (int b = 1; b < n; b++) {
            for (int a = 1; a < b; a++) {
                if (Math.sqrt((a*a) + (b*b)) % 1 == 0) {
                    if ((a + b + Math.sqrt((a*a) + (b*b))) <= n) {
                        list[(int)(a + b + Math.sqrt((a*a) + (b*b)))]++;
                    }
                }
            }
        }
        int maxIndex = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] > list[maxIndex]) maxIndex = i;
        }
        System.out.println(maxIndex);
    }
}