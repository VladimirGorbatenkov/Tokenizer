package observer;

import tokenizer.Token;

public interface TokenHandler {
    void handleToken(Token token);
    String getName();
}
