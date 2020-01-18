package validation;

import entities.CreditCard;

import javax.jws.WebService;

@WebService
public class CardValidator {

    public boolean validate(CreditCard creditCard){
        Character lastDigit = creditCard.getNumber().charAt(creditCard.getNumber().length()-1);

        if (Integer.parseInt(lastDigit.toString()) %2 != 0){
            return true;
        }
        return false;
    }
}
