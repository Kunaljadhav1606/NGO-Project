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
@Table(name = "admin_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_id")
	private Long adminId;
	
	@Column(name = "admin_name")
	private String adminName;
	
	@Column(name = "admin_contact")
	private Long adminContact;
	
	@Column(name = "admin_aadhar")
	private Long adminAadhar;
	
	@Column(name = "admin_gender")
	private String adminGender;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Login login;
	
	@Embedded
	private Address address;
}
