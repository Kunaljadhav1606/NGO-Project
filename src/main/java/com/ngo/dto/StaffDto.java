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
public class StaffDto {

	private int staffId;
	
	@NotEmpty
	@Size(min = 3 , max = 20 , message = " Name Must Be Atleat 3 Character !!")
	private String staffName;
	
	@NotEmpty
	@Size(min = 10 , max = 10 , message = " Not Valid ADMIN_CONTACT !!")
	private Long staffContact;
	
	@NotEmpty
	@Size(min = 12 , max = 12 ,message = "Aadhar-card Must Be 12 Digits...!!")
	private Long staffAadhar;
	
	@NotEmpty
	private String staffDesignation;
	
	@NotEmpty
	private String staffDepartment;
	
	@NotEmpty
	private String staffGender;
}
