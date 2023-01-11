package com.ngo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Feedbackdto {
   
	
	private Long feedbackId;
	
	@NotEmpty
	@Size(min=3 , message = " Name Must Be Atleat 3 Character !!")
	private String feedbackName;

	@NotEmpty
	@Email(message = "Email not valid ")
	private String feedbackEmail;
	
	@NotEmpty
	@Size(min = 2 , message = " Feedback must be Atleat 2 Character")
	private String feedbackSuggestion;
}
