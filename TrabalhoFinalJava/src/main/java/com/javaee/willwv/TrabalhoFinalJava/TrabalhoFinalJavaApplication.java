package com.javaee.willwv.TrabalhoFinalJava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javaee.willwv.TrabalhoFinalJava.config.EmailConfig;


@SpringBootApplication
public class TrabalhoFinalJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrabalhoFinalJavaApplication.class, args);
		/*final String fromEmail = "william.walder@gmail.com";
		final String password = "Wt38815152007";
		final String toEmail = "william.walder@gmail.com";
		
		System.out.println("Initializing email send");
		
		EmailConfig config = new EmailConfig();
		
		config.sendEmail(fromEmail, password, toEmail, "Subject", "Email Body");*/
	}

}
