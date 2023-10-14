import java.io.IOException;
import java.io.InputStream;

public class JsonLexer {
    private InputStream inputStream;
    private int currentChar;

    public JsonLexer(InputStream inputStream, int currentChar) {
        this.inputStream = inputStream;
        this.currentChar = getNextChar();
    }

    private int getNextChar() {
        try {
            return inputStream.read();
        } catch (IOException e) {
            return -1;
        }
    }

    public Token getNextToken() {
        while (Character.isWhitespace(currentChar)) {
            currentChar = getNextChar();
        }

        if (currentChar == '{') {
            currentChar = getNextChar(); // Consume '{'
            return new Token(TokenType.OPEN_BRACE, "{");
        } else if (currentChar == '}') {
            currentChar = getNextChar(); // Consume '}'
            return new Token(TokenType.CLOSE_BRACE, "}");
        } else {
            return new Token(TokenType.INVALID, "Invalid JSON");
        }
    }
}
