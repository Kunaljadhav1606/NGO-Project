package com.ngo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ngo.dto.Feedbackdto;
import com.ngo.service.FeedbackService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;
	
	@PostMapping("/feedback")
	public ResponseEntity<Feedbackdto> saveFeedback(@Valid @RequestBody Feedbackdto feedbackdto){
		Feedbackdto postFeedback = this.feedbackService.postFeedback(feedbackdto);
		return new ResponseEntity<Feedbackdto>(postFeedback, HttpStatus.CREATED);
		
	}
}
