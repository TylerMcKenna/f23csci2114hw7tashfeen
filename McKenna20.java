import java.math.BigInteger;

// 648
public class McKenna20 {
    public static void main(String[] args) {
        char[] result = factorial(new BigInteger("100")).toString().toCharArray();
        int sum = 0;
        // Sums digits
        for (char c : result) {
            sum += Integer.parseInt(Character.toString(c));
        }
        System.out.println(sum);
    }


    // Factorial utility function
    private static BigInteger factorial(BigInteger num) {
        BigInteger factorialNum = num;
        for (int i = Integer.parseInt(num.toString()) - 1; i > 0; i--) {
            factorialNum = factorialNum.multiply(new BigInteger(String.valueOf(i)));
        }
        return factorialNum;
    }
}
