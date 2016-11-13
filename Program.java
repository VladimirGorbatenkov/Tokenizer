package tokenizer;

public class Program {
    public static void main(String[] args) {
        Tokenizer T = new Tokenizer();
        T.addTokenHandler(new WordTokenHandlerImpl());
        T.addTokenHandler(new DigitTokenHandlerImpl());
        T.addTokenHandler(new SeparatorTokenHandlerImpl());
        T.tokenize("dfsd Dggsd1212;gsg.124124");
    }
}
