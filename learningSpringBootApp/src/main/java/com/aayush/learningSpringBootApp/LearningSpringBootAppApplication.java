package com.aayush.learningSpringBootApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearningSpringBootAppApplication implements CommandLineRunner
{

//	private RazorPayPaymentService paymentService = new RazorPayPaymentService();

	//make the dependency
	private RazorPayPaymentService paymentService;
	public LearningSpringBootAppApplication(RazorPayPaymentService paymentService){
		this.paymentService = paymentService;
	}



	@Override
	public void run(String ... args) throws Exception{

		String payment = paymentService.pay();
		System.out.println("Payment Done "+payment);

	}
	public static void main(String[] args) {

		SpringApplication.run(LearningSpringBootAppApplication.class, args);



	}

}
