package com.aayush.learningSpringBootApp;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

//@Component This works the same as below:
//@Service  This works the same as below
//@RestController This works the same as below
//@Repository This also works the same as below
//@Controller  //all are the stereotype annotations are type of components

//main thing , the bean / object is handled by the Spring framework
// and the user will not handle the object.

@Component
@ConditionalOnProperty(name="payment.provider",havingValue="stripe")
public class StripePaymentService implements PaymentService{
    @Override
    public String pay() {
        return "Stripe payment System";
    }
}
