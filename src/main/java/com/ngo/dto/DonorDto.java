package com.ngo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DonorDto {



    private Long donorId;
	
    @NotEmpty
    @Size(min = 3 , max = 15 , message = " Name Must Be Atleat 3 Character !!")
	private String donorName;
	
    @NotEmpty
	@Size(min = 10 , max = 10 , message = " Not Valid ADMIN_CONTACT !!")
	private Long donorContact;
	
    @NotEmpty
	@Size(min = 10 , max = 10 , message = " Not Valid ADMIN_PAN !!")
    @Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}")
	private String donorPAN;
	
	@NotEmpty
	private String donorGender;
	
	@NotEmpty
	private String donorDOB;
	
	@NotEmpty
	private Long donorAmount;
}
