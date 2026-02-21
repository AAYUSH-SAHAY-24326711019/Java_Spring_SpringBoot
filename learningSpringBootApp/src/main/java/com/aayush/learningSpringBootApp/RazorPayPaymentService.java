package com.aayush.learningSpringBootApp;


import org.springframework.stereotype.Component;

@Component
public class RazorPayPaymentService {
    public String pay(){
        String payment = "Razor pay payment";
        System.out.println("Payment from"+payment);
        return payment;

    }
}
