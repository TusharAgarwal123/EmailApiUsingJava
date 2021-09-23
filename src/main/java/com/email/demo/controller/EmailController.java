package com.email.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.email.demo.model.EmailRequest;
import com.email.demo.service.EmailService;

@RestController
public class EmailController {

	@Autowired
	private EmailService es;

	@GetMapping("/welcome")
	public String welcome() {
		return "hello this is my email api";
	}

	// api to send email

	@PostMapping("/sendEmail")
	public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request) {

		boolean rs = this.es.sendEmail(request.getMessage(), request.getSubject(), request.getTo());

		if (rs) {
			return ResponseEntity.ok("Email is send Successfully");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("email not send");
		}

	}

}
