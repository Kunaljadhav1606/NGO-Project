package com.ngo.dto;



import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminDto {

	
	private Long adminId;
	
	@NotEmpty
	@Size(min = 3 , max = 15 , message = " Name Must Be Atleat 3 Character !!")
	private String adminName;
	
	@NotEmpty
	@Size(min = 10 , max = 10 , message = " Not Valid ADMIN_CONTACT !!")
	private Long adminContact;
	
	@NotEmpty
	@Size(min = 12 , max = 12 ,message = "Aadhar-card Must Be 12 Digits...!!")
	private Long adminAadhar;
	
	@NotEmpty
	private String adminGender;
}
