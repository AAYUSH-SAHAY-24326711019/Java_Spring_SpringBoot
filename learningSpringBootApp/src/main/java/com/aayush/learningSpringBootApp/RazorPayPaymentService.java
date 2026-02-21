package com.aayush.learningSpringBootApp;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

//@Component
@Component
@ConditionalOnProperty(name="payment.provider",havingValue="razorpay")
//adding the above to notify : When to use the below bean
public class RazorPayPaymentService implements PaymentService {

    @Override
    public String pay(){
        String payment = "Razor pay payment";
        System.out.println("Payment from"+payment);
        return payment;

    }
}
