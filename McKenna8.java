import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

// 23514624000
public class McKenna8 {
    public static void main(String[] args) {
        // Setting the length we want to check for greatest product
        int productLength = 13;

        // Pulling in the data and converting it to an Integer ArrayList
        ArrayList<Character> content = toCharacterArrayList(readFile("./8nums.txt").toCharArray());
        ArrayList<Integer> numsList = toIntegerArrayList(content);

        // Placeholder values for our max and the index of that max
        long max = Integer.MIN_VALUE;
        //int indexOfMax = -1;

        long currentProduct = 1;
        // From index 0 to index productLength we multiply the values to get our initial max
        for (int i = 0; i < productLength; i++) {
            currentProduct *= numsList.get(i);
        }
        max = currentProduct;

        // Now we iterate from productLength to numsList.size() - 1 to find our real max
        for (int i = productLength; i < numsList.size(); i++) {
            // This is a 0 check since the way I'm calculating the current product causes me to divide by 0
            // I am just iterating recursively to get the last 4 value's product
            if (numsList.get(i - productLength) == 0) {
                currentProduct = 1;
                for (int j = i; j > i - productLength; j--) {
                    currentProduct *= numsList.get(j);
                }
            } 
            // Normal way of getting product is just "removing" i - productLength from the product and multiplying it by i
            else { 
            currentProduct /= numsList.get(i - productLength);
            currentProduct *= numsList.get(i);
            }

            // Updates max
            if (currentProduct > max) {
                max = currentProduct;
                //indexOfMax = i - productLength;
            }
        }

        System.out.print(max);
    }

    // Utility functions
    private static String readFile(String path) {
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(path));
            return new String(bytes, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
            return null;
        }
    }

    private static ArrayList<Integer> toIntegerArrayList(ArrayList<Character> chars) {
        ArrayList<Integer> numsList = new ArrayList<>();
        for (int i = 0; i < chars.size(); i++) {
            int charVal = Character.getNumericValue(chars.get(i));
            if (charVal >= 0 ) 
                numsList.add(charVal);
        }
        return numsList;
    }

    private static ArrayList<Character> toCharacterArrayList(char[] chars) {
        ArrayList<Character> charList = new ArrayList<>();
        for (char c : chars) {
            charList.add(c);
        }
        return charList;
    }
}
