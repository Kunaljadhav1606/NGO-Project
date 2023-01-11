package com.ngo.service;

import java.util.List;

import com.ngo.dto.LoginDto;
import com.ngo.dto.StaffDto;


public interface StaffService {

	StaffDto saveAdmin(StaffDto staffDto);
	
	StaffDto updateStaff(StaffDto staffDto , Long staffId);
	
	List<StaffDto> getAllStaff();
	
	void deleteStaff(Long staffId);
	
	StaffDto getStaffByLogin(LoginDto loginDto);
}
