package observer;

import tokenizer.Token;

public interface TokenizerObservable {
    void addTokenHandler (TokenHandler handler);
    void removeTokenHandler(String handlerName);
    void notifyHandlers(Token token);
    void tokenize(String text);

}
