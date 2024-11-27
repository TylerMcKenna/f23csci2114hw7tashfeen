// 6857
public class McKenna3 {
    public static void main(String[] args) {
        long n = 600851475143L;
        int sqrtN = (int)(Math.sqrt(n) + 1);

        // Sieve of Eratosthenes from data structures homework 1
        // Primes are false, composites are true, i + 2 is the value of the prime
        boolean[] primeNumbers = new boolean[sqrtN - 2];
        for (int i = 0; i < Math.sqrt(sqrtN) - 1; i++) {
            int currentVal = i+2;
            if (!primeNumbers[i]) {
                for (int j = currentVal*currentVal; j < sqrtN; j+=currentVal) {
                    primeNumbers[j-2] = true;
                }
            }
        }

        for (int i = primeNumbers.length - 1; i > 0; i--) {
            if (!primeNumbers[i]) {
                if ((double)n / (i + 2) % 1 == 0) {
                    System.out.print(i + 2);
                    break;
                }
            }
        }
    }
}