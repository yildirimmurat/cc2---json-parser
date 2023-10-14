public class JsonParser {
    private JsonLexer lexer;
    public JsonParser(JsonLexer lexer) {
        this.lexer = lexer;
    }

    public boolean parse() {
        Token token = lexer.getNextToken();
        if (token.getType() != TokenType.OPEN_BRACE) {
            return false;
        }

        token = lexer.getNextToken();
        if (token.getType() != TokenType.CLOSE_BRACE) {
            return false;
        }

        return true;
    }
}