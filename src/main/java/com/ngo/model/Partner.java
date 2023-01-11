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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PARTNER_DETAILS")
public class Partner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PARTNER_ID")
	private Long partnerId;
	
	@Column(name = "PARTNER_ORGNAISATION")
	private String partnerOrgnaisation;
	
	@Column(name = "PARTNER_CONTACT")
	private Long partnerContact;
	
	@Column(name = "PARTNER_WEBSITE")
	private String partnerWebsite;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Login login;
	
	@Embedded
	private Address address;
}
