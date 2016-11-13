package tokenizer;

public class DigitToken extends Token {
    private int value;
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
            if ( ! Character.isDigit(text.charAt(i)) ) {
                result = false;
            }
        }
        return result;
    }

    public DigitToken() {
    }

    public DigitToken(int begin, int end, String text, int value) {
        super(begin, end, text);
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
