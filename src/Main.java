import java.io.*;
import java.nio.file.Files;

public class Main {
    public static void main(String[] args) {
        if (isPipedInput()) {
            processPipedInput();
        } else {
            processInteractiveInput(args);
        }
    }

    private static boolean isPipedInput() {
        try {
            if (System.console() != null) {
                // There is a console, so it's not piped input
                return false;
            }

            // Check if System.in is connected to a terminal or a pipe
            // If available() returns 0 or less, it's likely piped input
            return System.in.available() <= 0;

            // If available() returns a positive value, it's likely terminal input
        } catch (IOException e) {
            return false;
        }
    }

    private static void processPipedInput() {
        processCommand(System.in, null);
    }

    private static void processInteractiveInput(String[] args) {
        if (args.length > 1) {
            System.err.println("Usage: json-parser [filename]");
            return;
        }

        String fileName = args[0];
        InputStream inputStream;

        File file = new File(fileName);

        if (!file.exists() || !file.isFile()) {
            System.err.println("File not found: " + fileName);
            return;
        }

        try {
            inputStream = Files.newInputStream(file.toPath());
        } catch (IOException e) {
            System.err.println("Error opening file: " + fileName);
            return;
        }

        processCommand(inputStream, fileName);
    }

    private static void processCommand(InputStream inputStream, String fileName) {
        boolean isValid = getResult(inputStream);

        if (isValid) {
            System.out.println("valid");
        } else {
            System.err.println("invalid");
        }
    }

    private static boolean getResult(InputStream inputStream) {
        JsonLexer lexer = new JsonLexer(inputStream, -1);
        JsonParser parser = new JsonParser(lexer);

        return parser.parse();
    }
}
