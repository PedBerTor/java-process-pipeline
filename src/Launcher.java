import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Launcher.
 *
 * <p>The {@code Launcher} class serves as an orchestrator for the execution of the
 * {@link  Generator} and {@link  Analyzer} classes. It enables users to generate random
 * text strings and analyze them for specific vowel counts in a streamlined manner.
 *
 * <p>This class prompts the user for the number of text strings to generate, starts
 * a new {@code Generator} process and pipes its output directly to an {@code Analyzer}
 * process.
 *
 * <p>The following example shows how to use {@code Launcher} to generate and analyze 2
 * text strings:
 * <pre>
 * java-process-pipeline> javac src/Launcher.java
 * java-process-pipeline> java -cp src Launcher
 *
 * Number of text strings to generate:
 * 3
 *
 * TuzVszmByv > 0 0 0
 * Aqswuvkggd > 1 0 0
 * TvWsrfpTyw > 0 0 0
 * </pre>
 *
 * <p>Note: Ensure that the {@link Generator} and {@link Analyzer} classes are compiled
 * and available in the specified directory before running this class.
 *
 * @author Pedro Bernaldez
 */
public class Launcher {

    private static final String JAVA_DIR =
            System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";

    public static void main(String[] args) throws IOException {
        List<String> missingCompiledClasses = Stream.of("Analyzer.class", "Generator.class")
                .filter((clazz) -> Files.notExists(Path.of("src", clazz)))
                .collect(Collectors.toList());
        if (!missingCompiledClasses.isEmpty()) {
            throw new RuntimeException("Compiled classes are missing: " + String.join(", ", missingCompiledClasses));
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Number of text strings to generate:");
        String nTextStrings = scanner.next();

        ProcessBuilder generatorProcessBuilder = new ProcessBuilder()
                .command(JAVA_DIR, "-cp", "src", "Generator", nTextStrings)
                .redirectInput(ProcessBuilder.Redirect.INHERIT)
                .redirectOutput(ProcessBuilder.Redirect.PIPE);
        ProcessBuilder analyzerProcessBuilder = new ProcessBuilder()
                .command(JAVA_DIR, "-cp", "src", "Analyzer")
                .redirectInput(ProcessBuilder.Redirect.PIPE)
                .redirectOutput(ProcessBuilder.Redirect.INHERIT);

        ProcessBuilder.startPipeline(
                List.of(
                        generatorProcessBuilder,
                        analyzerProcessBuilder
                )
        );
    }
}
