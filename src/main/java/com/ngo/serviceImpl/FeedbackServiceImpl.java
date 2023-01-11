package com.ngo.serviceImpl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngo.dto.Feedbackdto;
import com.ngo.model.Feedback;
import com.ngo.repository.FeedbackRepository;
import com.ngo.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService {
	
	Logger logger=LoggerFactory.getLogger(FeedbackServiceImpl.class);

	@Autowired
	private FeedbackRepository feedbackRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public Feedbackdto postFeedback(Feedbackdto feedbackdto) {
		Feedback feedback = this.modelMapper.map(feedbackdto, Feedback.class);
		Feedback saveFeedback = this.feedbackRepository.save(feedback);
		return this.modelMapper.map(saveFeedback, Feedbackdto.class);
	}
}
