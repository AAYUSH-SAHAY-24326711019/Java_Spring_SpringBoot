package com.aayush.learningSpringBootApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearningSpringBootAppApplication implements CommandLineRunner
{

//	private RazorPayPaymentService paymentService = new RazorPayPaymentService();
//lesson 1 : Constructor dependency injection
	//make the dependency [this is the best one] explicit (can make public and final)
	private final PaymentService paymentService;
	public LearningSpringBootAppApplication(PaymentService paymentService){
		this.paymentService = paymentService;
	}
	//now there are two implemented Razorpay and Stripe. [Ambiguity]
	// solution make someone primary , so removing the component
	//	annotation from the RazorPay
	//Notes :dependency injection will create the object.

	//lesson 2 is use of the Autowired annotation
	//this is a field injection.
//	@Autowired
//	private RazorPayPaymentService paymentService;
//	//beans allow to add the loose coupling
	//cannot set this as the private final


//lesson 3 : There is always need to recompile the code. [needs to be prevented]
//	Now we have implemented loose coupling , you can use any payment system
	//required at any time.

	//Time to make a configuration file that would decide.
	//what bean to be used.
	/*
	* Step 1 goto resources/application.properties.
	* add this line : payment.provider=stripe
	*
	* Now above needs to be notified, see the RazorPay file
	* */

	/* lesson 4:
	in the properties file add debug = true
	 to know what beans are made is then after shown in the logs
	 */

	@Override
	public void run(String ... args) throws Exception{

		String payment = paymentService.pay();
		System.out.println("Payment Done "+payment);

	}
	public static void main(String[] args) {

		SpringApplication.run(LearningSpringBootAppApplication.class, args);



	}

}
