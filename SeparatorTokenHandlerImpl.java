package tokenizer;

import observer.TokenHandler;

public class SeparatorTokenHandlerImpl implements TokenHandler{
    @Override
    public void handleToken(Token token) {
        if (token.getClass().getName().equals(SeparatorToken.class.getName())) {
            System.out.println("from:  " + this.getClass().getName() + " I`m on separator!  >>" + token + "<<" + "     " + ((SeparatorToken) token).getType());
        }
    }

    @Override
    public String getName() {
        return "SeparatorHandler";
    }
}
