package com.ngo.service;

import java.util.List;

import com.ngo.dto.AdminDto;
import com.ngo.dto.LoginDto;
import com.ngo.model.Admin;

public interface AdminService {

	AdminDto saveAdmin(AdminDto adminDto);
	
	AdminDto updateAdmin(AdminDto adminDto , Long adminId);
	
	List<AdminDto> getAllAdmin();
	
	void deleteAdmin(Long adminId);
	
	AdminDto getAdminByLogin(LoginDto loginDto);
}
