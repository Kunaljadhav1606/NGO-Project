package com.ngo.service;

import java.util.List;

import com.ngo.dto.DonorDto;
import com.ngo.dto.LoginDto;

public interface DonarService {

	DonorDto saveDonor(DonorDto donorDto);
	
	DonorDto updateDonor(DonorDto donorDto , Long donorId);
	
	List<DonorDto>  GetAllDonors();
	
	void deltedDonor(Long donorId);
	
	DonorDto getDonorByLogin(LoginDto loginDto);
}
