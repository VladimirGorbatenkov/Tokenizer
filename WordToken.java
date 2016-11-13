package tokenizer;

public class WordToken extends Token {
    private boolean isUpperFirst;

    @Override
    public boolean isSuitable(String text) {
        boolean result;
        if (text.length() > 0) {
            result = true;
        }
        else {
            result = false;     //для пустой строки возвращаем false
        }
        for (int i = 0; i < text.length(); i++) {
            if ( ! Character.isLetter(text.charAt(i)) ) {
                result = false;
            }
        }
        return result;
    }

    public WordToken() {
    }

    public WordToken(int begin, int end, String text) {
        super(begin, end, text);
        isUpperFirst = Character.isUpperCase(text.charAt(0));
    }

    public boolean getIsUpperFirst() {
        return isUpperFirst;
    }
}
