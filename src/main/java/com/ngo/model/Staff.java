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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="STAFF_DETAILS")
public class Staff {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int staffId;
	
	@Column(name="STAFF_NAME")
	private String staffName;
	
	@Column(name="STAFF_CONTACT")
	private Long staffContact;
	
	@Column(name="STAFF_AADHAR")
	private Long staffAadhar;
	
	@Column(name="STAFF_DESIGNATION")
	private String staffDesignation;
	
	@Column(name="STAFF_DEPARTMENT")
	private String staffDepartment;
	
	@Column(name="STAFF_GENDER")
	private String staffGender;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Login login;
	
	@Embedded
	private Address address;
}
