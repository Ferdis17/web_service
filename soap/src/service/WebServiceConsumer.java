package service;

import entities.CreditCard;
import service.CardValidatorService;
import validation.CardValidator;

import javax.xml.ws.WebServiceRef;

public class WebServiceConsumer {

    @WebServiceRef
    private static CardValidatorService cardValidatorService;

    public static void main(String args[]){
        CreditCard creditCard = new CreditCard();

        creditCard.setNumber("12341234");
        creditCard.setExpiryDate("10/22");
        creditCard.setType("VISA");
        creditCard.setControlNumber(1234);

       CardValidator cardValidator = new CardValidator(); //new CardValidatorService().getCardValidatorPort();
        cardValidator.validate(creditCard);

    }

}
