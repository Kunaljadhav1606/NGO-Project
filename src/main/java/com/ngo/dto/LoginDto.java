package com.ngo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {

    private Long loginId;
	
	@NotEmpty
	private String loginUsername;
	
	@NotEmpty
	@Pattern(regexp = "regex = “^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\\\S+$).{8, 20}$”")
	private String loginPassword;
	
	@NotEmpty
	private String loginType;
}
