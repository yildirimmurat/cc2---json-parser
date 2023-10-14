enum TokenType {
    STRING,
    NUMBER,
    TRUE,
    FALSE,
    NULL,
    OPEN_BRACE,
    CLOSE_BRACE,
    INVALID,
};
public class Token {
    private TokenType type;
    private String value;

    public Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }

    public TokenType getType()
    {
        return type;
    }
}
