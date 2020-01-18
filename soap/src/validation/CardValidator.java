package validation;

import entities.CreditCard;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

import static javax.jws.soap.SOAPBinding.Style.RPC;
import static javax.jws.soap.SOAPBinding.Use.LITERAL;

@WebService(portName = "CreditCardValidator", serviceName = "ValidatorService")
@SOAPBinding(style = RPC, use = LITERAL)
public class CardValidator {

    public CardValidator(){}

    @WebResult(name = "IsValid")
    @WebMethod(operationName = "ValidateCreditCard")
    public boolean validate(CreditCard creditCard){
        Character lastDigit = creditCard.getNumber().charAt(creditCard.getNumber().length()-1);

        if (Integer.parseInt(lastDigit.toString()) % 2 != 0){
            return true;
        }
        return false;
    }

    @WebMethod(exclude = true)
    public void validate(Long creditCardNumber){
        Endpoint.publish("http://8080/cardValidator", new CardValidator());
    }
}
