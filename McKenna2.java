import java.util.ArrayList;

// 4613732
public class McKenna2 {
    public static void main(String[] args) {
        // Generate fibonacci
        ArrayList<Integer> fibonacci = new ArrayList<Integer>();
        fibonacci.add(0);
        fibonacci.add(1);
        while (fibonacci.get(fibonacci.size() - 1) < 4_000_000)
            fibonacci.add(fibonacci.get(fibonacci.size() - 1) + fibonacci.get(fibonacci.size() - 2));

        // Sum evens
        int sum = 0;
        for (Integer i : fibonacci)
            if (i % 2 == 0)
                sum += i;

        System.out.print(sum);
    }   
}
