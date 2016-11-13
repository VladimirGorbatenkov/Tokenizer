package tokenizer;

public class SeparatorToken extends Token {
    private static final String SEPARATORS = "., :;";
    private String type;
    @Override
    public boolean isSuitable(String text) {
        boolean result;
        type = text.substring(0,1);
        if (text.length() > 0) {    //первичная инициализация
            result = true;
        }
        else {
            result = false;     //для пустой строки возвращаем false
            type ="";
        }
        if (text.length() != 1 || ! (SEPARATORS.contains(text.substring(0,1)) ) ) {
            result = false;
            type ="";
        }
        return result;
    }

    public SeparatorToken() {
    }

    public SeparatorToken(int begin, int end, String text) {
        super(begin, end, text);
    }

    public String getType() {
        return type;
    }
}
