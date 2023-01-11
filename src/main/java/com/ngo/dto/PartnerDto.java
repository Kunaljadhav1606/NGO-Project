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
public class PartnerDto {

    private Long partnerId;
	
    @NotEmpty
    @Size(min = 3 , message = " Name Must Be Atleat 3 Character !!")
	private String partnerOrgnaisation;
	
    @NotEmpty
	@Size(min = 10 , max = 10 , message = " Not Valid ADMIN_CONTACT !!")
	private Long partnerContact;
	
	@NotEmpty
	private String partnerWebsite;
}
