package com.ngo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "login_details")
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long loginId;
	
	@Column(name = "login_Username")
	private String loginUsername;
	
	@Column(name = "login_Password")
	private String loginPassword;
	
	@Column(name = "login_Type")
	private String loginType;
}
