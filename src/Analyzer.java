import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Analyzer.
 *
 * <p>The {@code Analyzer} class provides a utility for analyzing text input. It reads lines of text
 * from standard input and counts the occurrences of specific vowels: 'a', 'e', and 'o'. For each
 * line, it outputs the line of text along with the counts of these vowels in a formatted manner.
 *
 * <p>The following example shows the use of {@code Analyzer} for analyzing the input lines "Hello
 * World" and "Credo quia absurdum":
 * <pre>
 * java-process-pipeline> javac src/Analyzer.java
 * java-process-pipeline> java -cp src Analyzer
 *
 * Hello World
 * Hello World > 0 1 2
 *
 * Credo quia absurdum
 * Credo quia absurdum > 2 1 1
 * </pre>
 *
 * @author Pedro Bernaldez
 */
public class Analyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String textString = scanner.nextLine();
            Map<Character, Long> count = textString.toLowerCase().chars()
                    .mapToObj((i) -> (char) i)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            System.out.printf("%s > %d %d %d%n",
                    textString,
                    count.getOrDefault('a', 0L),
                    count.getOrDefault('e', 0L),
                    count.getOrDefault('o', 0L));
        }
        scanner.close();
    }
}
