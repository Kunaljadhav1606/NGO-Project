package com.ngo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ngo.dto.AdminDto;
import com.ngo.dto.DonorDto;
import com.ngo.dto.LoginDto;
import com.ngo.dto.PartnerDto;
import com.ngo.dto.StaffDto;
import com.ngo.model.Admin;
import com.ngo.service.AdminService;
import com.ngo.service.PartnerService;
import com.ngo.service.StaffService;
import com.ngo.serviceImpl.DonorServiceImpl;
import com.ngo.serviceImpl.LoginServiceImpl;

@RestController
@RequestMapping("/login")
public class LoginContoller {

	@Autowired
	private LoginServiceImpl loginServiceImpl;
	
	@Autowired
	private StaffService staffService;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private PartnerService partnerService;
	
	@Autowired
	private DonorServiceImpl donorServiceImpl;
	
	
	@GetMapping("/get/{loginUsername}/{loginPassword}")
	public Object getLogin(@PathVariable String loginUsername , @PathVariable String loginPassword) {
		LoginDto login = this.loginServiceImpl.getLogin(loginUsername, loginPassword);
	
		if(login.getLoginType().equalsIgnoreCase("staff")) {
			StaffDto staffDto = this.staffService.getStaffByLogin(login);
			return staffDto;
		
		}else if(login.getLoginType().equalsIgnoreCase("admin")) {
			AdminDto adminDto = this.adminService.getAdminByLogin(login);
			return adminDto;
		}else if(login.getLoginType().equalsIgnoreCase("partner")) {
			PartnerDto partnerDto = this.partnerService.getPartnerByLogin(login);
			return partnerDto;
		}else if(login.getLoginType().equalsIgnoreCase("donor")) {
			DonorDto donorDto = this.donorServiceImpl.getDonorByLogin(login);
			return donorDto;
		}
		return login;
		
	}
}
