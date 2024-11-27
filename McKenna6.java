// 25164150
public class McKenna6 {
    public static void main(String[] args) {
        int n = 100;
        long sumOfSquares = 0;  
        long squareOfSums = 0;
        for(int i = 1; i <= n; i++) {
            sumOfSquares += i*i;
            squareOfSums += i;
        }
        squareOfSums *= squareOfSums;

        System.out.println(squareOfSums - sumOfSquares);
    }
}
