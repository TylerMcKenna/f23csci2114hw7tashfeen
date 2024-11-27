import java.math.BigDecimal;

// 1366
class Sixteen {
    public static void main(String[] args) {
        BigDecimal num = new BigDecimal(2);
        num = num.pow(1000);
        char[] chars  = num.toString().toCharArray();
        int sum = 0;
        for(int i = 0; i < chars.length; i++) 
            sum += Integer.parseInt(String.valueOf(chars[i]));
        System.out.println(sum);
    }
}