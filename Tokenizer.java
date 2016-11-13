package tokenizer;

import observer.TokenHandler;
import observer.TokenizerObservable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Tokenizer implements TokenizerObservable {
    private Map<String, TokenHandler> handlers;
    private ArrayList<Token> tokens = new ArrayList<>();


    public Tokenizer() {
        this.handlers = new HashMap<String, TokenHandler>();
    }

    @Override
    public void addTokenHandler(TokenHandler handler) {
        handlers.put(handler.getName(), handler);
    }

    @Override
    public void removeTokenHandler(String handlerName) {
        handlers.remove(handlerName);
    }

    @Override
    public void notifyHandlers(Token token) {
        Set<Map.Entry<String, TokenHandler>> entries = handlers.entrySet();
        for (Map.Entry<String, TokenHandler> entity : entries) {
            TokenHandler currentHandler = entity.getValue();
            currentHandler.handleToken(token);
        }
    }

    @Override
    public void tokenize(String text) {
        WordToken wt = new WordToken(0, 0, text.substring(0, 1));
        DigitToken dt = new DigitToken(0, 0, text.substring(0, 1), 1);
        SeparatorToken st = new SeparatorToken(0, 0, text.substring(0, 1));
        int beg = 0;
        String tokenType = "";
        String prevTokenType = "";

        for (int i = 0; i < text.length(); i++) {
            if (wt.isSuitable(String.valueOf(text.charAt(i)))) {
                tokenType = "word";
            }
            else {
                if (dt.isSuitable(String.valueOf(text.charAt(i)))) {
                    tokenType = "digit";
                }
                else {
                    if (st.isSuitable(String.valueOf(text.charAt(i)))) {
                        tokenType = "separator";
                    }
                    else {
                        tokenType = "unknown";
                    }
                }
            }
            if (( tokenType != prevTokenType && prevTokenType != "") || prevTokenType == "separator" ) {  //тип токена сменился и это не первый символ или это сепаратор
                switch (prevTokenType) {
                    case "word" :
                        WordToken wt1 = new WordToken(beg, i-1, text.substring(beg, i));
                        handleToken(wt1);
                        notifyHandlers(wt1);
                        break;
                    case "digit" :
                        DigitToken dt1 = new DigitToken(beg, i-1, text.substring(beg, i), Integer.parseInt(text.substring(beg, i)));
                        handleToken(dt1);
                        notifyHandlers(dt1);
                        break;
                    case "separator" :
                        SeparatorToken st1 = new SeparatorToken(beg, i-1, text.substring(beg, i));
                        handleToken(st1);
                        notifyHandlers(st1);
                        break;
                    default:
                        break;
                }
                prevTokenType = tokenType;
                beg = i;
            }
            if (prevTokenType == "") {
                prevTokenType = tokenType;
                beg = 0;
            }

        }
        if (tokenType != "") {     //добавляем последний токен, если есть
            switch (prevTokenType) {
                case "word" :
                    WordToken wt1 = new WordToken(beg, text.length()-1, text.substring(beg, text.length()));
                    handleToken(wt1);
                    notifyHandlers(wt1);
                    break;
                case "digit" :
                    DigitToken dt1 = new DigitToken(beg, text.length()-1, text.substring(beg, text.length()), Integer.parseInt(text.substring(beg, text.length())));
                    handleToken(dt1);
                    notifyHandlers(dt1);
                    break;
                case "separator" :
                    SeparatorToken st1 = new SeparatorToken(beg, text.length()-1, text.substring(beg, text.length()));
                    handleToken(st1);
                    notifyHandlers(st1);
                    break;
                default:
                    break;
            }

        }
    }

    private void handleToken(Token token) {
        this.tokens.add(token);
    }

    public Token[] getTokens() {

        return tokens.toArray(new Token[tokens.size()]);
    }
}
