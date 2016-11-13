package tokenizer;

import observer.TokenHandler;

public class WordTokenHandlerImpl implements TokenHandler{
    @Override
    public void handleToken(Token token) {
        if (token.getClass().getName().equals(WordToken.class.getName())) {
            System.out.println("from:  " + this.getClass().getName() + " I`m on word!  >>" + token + "<<" + "     " + ((WordToken) token).getIsUpperFirst());
        }
    }

    @Override
    public String getName() {
        return "WordHandler";
    }
}
