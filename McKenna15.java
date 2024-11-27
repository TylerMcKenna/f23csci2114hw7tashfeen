import java.util.HashMap;

// 137846528820
public class McKenna15 {
    public static void main(String args[]) {
        // Gives the amount of edges in a tree of depth loopFrom
        int n = 20;
        int[] test = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        HashMap<Integer, Integer> testMap = generateTreeHash(test, n);

        //System.out.println(testMap.toString());
        int[] array = new int[(int)Math.pow(2, n)];
        int startIndex = 0;
        int endIndex = array.length - 1;
        buildLatticeTree(array, endIndex, startIndex);
        
        long count = 0;
        for (int i : array) {
            count += testMap.get(Math.abs(i));
            if(testMap.get(Math.abs(i)) != Math.abs(testMap.get(Math.abs(i)))) {
                System.out.println("Alert!");
            }
        }
        System.out.println(count);
    }

    // count = n = 4
    // count /= 2
    // count /= 2

    /*
     * [0,*,*,*,*,*,*,*,*,*,*,*]
     * start loop
     * 
     * 
     * 
     * go to n = 0
     * 
     * int[] tree = new int[2^n];
     * tree[0] = 0;
     * int count = n;
     * 
     * for (int i = 1; i < n; i++) {
     *      count /= 2;
     *      for (int j = 0; j < n/count; j++) {
     *          tree[j*count] = 
     *      }
     * }
     * 
     * public void divide()
     * we split array into 2 halves left and right
     * after calling method, it takes (endindex-startindex)/2 and knows
     * that it should take the value at startindex, store it, set it to
     * itself-1 and set (endindex-startindex)/2 and set it to itself+1
     * 
     */

    // n is the size of the grid * 2 e.g. if grid is 20x20 n is 40
    //public int findValidPaths(int n) {
    //
    //}

    // pass it an array with 0 at the first index and of the correct size
    // initially, endIndex = array.length - 1, startIndex = 0
    public static void buildLatticeTree(int[] array , int endIndex, int startIndex) {
        if (startIndex != endIndex) {
            int middleIndex = startIndex + (endIndex - startIndex + 1)/2;
            int temp = array[startIndex];
            array[startIndex] = temp - 1;
            array[middleIndex] = temp + 1;
            buildLatticeTree(array, middleIndex - 1, startIndex);
            buildLatticeTree(array, endIndex, middleIndex);
        }
    }

    // Returns a Hashmap containing amount of zeros resulting from a node value in the tree
    // No real point to computing -10 and 10 just count -10 result as |-10|
    public static HashMap<Integer, Integer> generateTreeHash(int[] numSet, int depth) {
        HashMap<Integer, Integer> valHash = new HashMap<Integer, Integer>();
        for (int i : numSet) {
            int[] array = new int[(int)Math.pow(2, depth)];
            array[0] = i;

            int startIndex = 0;
            int endIndex = array.length - 1;
            buildLatticeTree(array, endIndex, startIndex);
            
            int count = 0;
            for (int j : array) {
                if (j == 0) {
                    count++;
                }
            }
            valHash.put(i, count);
        }
        return valHash;
    }
}
