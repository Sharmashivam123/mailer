package com.shivam.mailer.emailservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.shivam.mailer.model.User;

@Service
@Aspect
public class UserEmailServiceImpl implements UserEmailService{

	@Value("${spring.mail.username}")
	private String fromAddress;
	
	@Autowired
	private JavaMailSender mailSender;
	
	private ExecutorService executor = Executors.newSingleThreadExecutor();
	
	@AfterReturning("execution(* com.shivam.mailer.services.UserServiceImpl.saveUser(..)) && args(user)")
	private void saveUser(JoinPoint jointPoint, User user) {
		executor.submit(()-> sendEmail(user.getEmailId()));
	}
	
	
	public void sendEmail(String emailId) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(emailId);
		message.setFrom(fromAddress);
		message.setText("You are successfully registered. This mail contains no data.");
		mailSender.send(message);
	}

	
	
}
