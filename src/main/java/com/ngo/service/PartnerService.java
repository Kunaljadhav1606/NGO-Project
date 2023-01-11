package com.ngo.service;

import java.util.List;

import com.ngo.dto.LoginDto;
import com.ngo.dto.PartnerDto;

public interface PartnerService  {

	PartnerDto savePartner(PartnerDto partnerDto);
	
	PartnerDto updatePartner(PartnerDto partnerDto , Long partnerId);
	
	List<PartnerDto> getAllPartner();
	
	void DeletePartner(Long partnerId);
	
	PartnerDto getPartnerByLogin(LoginDto logindto);
}
