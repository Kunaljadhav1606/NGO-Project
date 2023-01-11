package com.ngo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "DONOR_DETAILS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Donor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Donor_ID")
	private Long donorId;
	
	@Column(name = "Donor_NAME")
	private String donorName;
	
	@Column(name = "Donor_CONTACT")
	private Long donorContact;
	
	@Column(name = "Donor_PAN")
	private String donorPAN;
	
	@Column(name = "Donor_GENDER")
	private String donorGender;
	
	@Column(name = "Donor_DOB")
	private String donorDOB;
	
	@Column(name = "Donor_AMOUNT")
	private Long donorAmount;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Login login;
	
	@Embedded
	private Address address;
}
