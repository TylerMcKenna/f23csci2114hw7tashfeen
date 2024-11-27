import java.util.HashMap;

// 837799
public class McKenna14 {
    public static void main(String args[]) {
        long n = 1_000_000;
        HashMap<Long, Long> solutionSet = new HashMap<>();
        for(long i = 2; i < n; i++) {
            long curr = i;
            long counter = 1;
            while (curr != 1) {
                if (solutionSet.get(curr) != null) {
                    counter += solutionSet.get(curr) - 1;
                    break;
                }
                if (curr % 2 == 0) curr /= 2;
                else curr = 3*(curr) + 1;
                counter++;
            }
            solutionSet.put(i, counter);
        }

        long maxIndex = 2;
        for(long i = 2; i < solutionSet.size(); i++) {
            if(solutionSet.get(i) > solutionSet.get(maxIndex)) maxIndex = i;
        }
        System.out.println(maxIndex);
    }
}
