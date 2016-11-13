package tokenizer;

public abstract class Token {
    protected static final String DEFAULT_TEXT = "";
    protected static final int DEFAULT_BEGIN = 0;
    protected static final int DEFAULT_END = 0;
    protected int begin;
    protected int end;
    protected String text;
    protected abstract boolean isSuitable (String text);

    public Token() {
        this(DEFAULT_BEGIN, DEFAULT_END, DEFAULT_TEXT);
    }

    public Token(int begin, int end, String text) {
        this.begin = begin;
        this.end = end;
        if (isSuitable(text)) {
            this.text = text;
        }
        else {
            this.text = DEFAULT_TEXT;
        }
    }

    public int getBegin() {
        return begin;
    }

    public int getEnd() {
        return end;
    }

    public String getText() {
        return text;
    }

    public String toString() {
        return this.text;
    }
}
