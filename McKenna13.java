import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.math.BigInteger;

// 5537376230
public class McKenna13 {
    public static void main(String[] args) {
        String content = readFile("./13nums.txt");
        String[] lines = content.split("\n");
        BigInteger rollingSum = new BigInteger("1");
        for (String s : lines) {
            rollingSum = rollingSum.add(new BigInteger(s.substring(0, s.length() - 1)));
        }
        System.out.print(rollingSum.toString().substring(0, 10));
    }
    
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
}
