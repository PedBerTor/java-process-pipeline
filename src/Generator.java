import java.util.Random;

/**
 * Generator.
 *
 * <p>The {@code Generator} class provides a utility for generating random text strings. Each
 * string consists of a fixed length of characters randomly selected from a predefined set of
 * alphabetic characters, including both uppercase and lowercase letters.
 *
 * <p>This class is designed to be executed from the command line. The main method accepts a
 * single argument that specifies the number of text strings to generate. If no argument is
 * provided, a {@code RuntimeException} is thrown, indicating that the number of strings is
 * required.
 *
 * <p>The following example shows how to use {@code Generator} to produce 5 random text strings:
 * <pre>
 * java-process-pipeline> javac src/Generator.java
 * java-process-pipeline> java -cp src Generator 5
 *
 * aOydSlALlB
 * capuxsVkzp
 * jkeLdoTfGj
 * iiIWpmbmZh
 * TtsdMgJVjJ
 * </pre>
 *
 * @author Pedro Bernaldez
 */
public class Generator {

    private static final int TEXT_STRING_LENGTH = 10;
    private static final char[] ALPHABET_CHARS = new char[]{
            'A', 'a', 'B', 'b', 'C', 'c', 'D', 'd', 'E', 'e', 'F', 'f', 'G',
            'g', 'H', 'h', 'I', 'i', 'J', 'j', 'K', 'k', 'L', 'l', 'M', 'm',
            'N', 'n', 'O', 'o', 'P', 'p', 'Q', 'q', 'R', 'r', 'S', 's', 'T',
            't', 'U', 'u', 'V', 'v', 'W', 'w', 'X', 'x', 'Y', 'y', 'Z', 'z'
    };

    public static void main(String[] args) {
        if (args.length == 0) {
            throw new RuntimeException("The number of text strings to generate must be passed as an argument.");
        }
        int nTextStrings = Integer.parseInt(args[0]);
        Random random = new Random();
        for (int i = 0; i < nTextStrings; i++) {
            StringBuilder stringBuilder = new StringBuilder(TEXT_STRING_LENGTH);
            for (int j = 0; j < TEXT_STRING_LENGTH; j++) {
                int charPos = random.nextInt(ALPHABET_CHARS.length);
                stringBuilder.append(ALPHABET_CHARS[charPos]);
            }
            System.out.println(stringBuilder);
        }
    }
}
