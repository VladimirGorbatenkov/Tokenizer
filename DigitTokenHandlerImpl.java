package tokenizer;

import observer.TokenHandler;

public class DigitTokenHandlerImpl implements TokenHandler {
    @Override
    public void handleToken(Token token) {
        if (token.getClass().getName().equals(DigitToken.class.getName())) {
            System.out.println("from:  " + this.getClass().getName() + " I`m on digit!  >>" + token + "<<" + "     " + ((DigitToken) token).getValue());
        }
    }

    @Override
    public String getName() {
        return "DigitHandler";
    }
}
