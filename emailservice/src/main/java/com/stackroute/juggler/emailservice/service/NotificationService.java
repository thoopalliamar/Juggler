package com.stackroute.juggler.emailservice.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.stackroute.juggler.emailservice.domain.EmailDetails;
import com.stackroute.juggler.rsvp.domain.EventDetails;

@Service
public class NotificationService {
	private JavaMailSender javaMailSender;
	private SpringTemplateEngine templateEngine;

	@Autowired
	public NotificationService(JavaMailSender javaMailSender, SpringTemplateEngine templateEngine) {
		super();
		this.javaMailSender = javaMailSender;
		this.templateEngine = templateEngine;
	}

	EmailDetails emailDetails = new EmailDetails();
	String emailBody;
	String eventName;
	String eventDate;
	String url = "www.google.co.in";

	// public void getEventDetails(EventDetails event) {
	// System.out.println("geteventdetails");
	// emailDetails.setToEmailId(event.getInvitiesMail());
	// emailDetails.setBody(event.getEventSynopsis());
	// emailDetails.setEventName(event.getEventName());
	// emailDetails.setEventDate(event.getEventDate());
	//
	// //emailDetails.setEventLocation(event.getEventLocation());
	// System.out.println(emailDetails.toString());
	//
	// }

	@KafkaListener(topics = "eventdetails1", groupId = "event")
	public void sendNotification(EventDetails event) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setTo(event.getInvitiesMail());
		helper.setSubject("Event Invitation");
		this.emailBody = event.getEventSynopsis();
		this.eventName = event.getEventName();
		this.eventDate = event.getEventDate();

		helper.setText("<html>" + "<head>" + "<body> " + "<h3>Hey,</h3><br>" + "<p>You are invited to attend an Event "
				+ eventName + " where in " + emailBody + " held on " + eventDate + "</p><br>"
				+ "        </body></head></html>", true);
		System.out.println(message.toString());
		javaMailSender.send(message);
	}

}
