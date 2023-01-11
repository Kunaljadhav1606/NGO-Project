package com.ngo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ngo.constants.AppConstants;
import com.ngo.dto.AdminDto;
import com.ngo.payloads.ApiResponse;
import com.ngo.service.AdminService;

@RestController
@RequestMapping("/api")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	Logger logger= LoggerFactory.getLogger(AdminController.class);
	
	/**
	   *@author kunal
	   *@param AdminDto
	   *@apiNote This Api Is To save Admin Data
	   * 
	   */
   
	
	@PostMapping("/admin")
	public ResponseEntity<AdminDto> saveAdmin(@RequestBody AdminDto adminDto){
		logger.info("Initiated request for save the admin details");
		AdminDto saveAdmin = this.adminService.saveAdmin(adminDto);
		logger.info("Compeleted request for save the admin details");
		return new ResponseEntity<AdminDto>(saveAdmin ,HttpStatus.CREATED);
	}
	
	
	/**
	   *@apiNote This Api Is For Get Alladmin Details
	   * @return 
	   */
	
	@GetMapping("/admins")	
    public ResponseEntity<List<AdminDto>> getAllAdmin(){
		logger.info("Initiated request for getAll the admin details");
    	List<AdminDto> allAdmin = this.adminService.getAllAdmin();
    	logger.info("Complelted request for getAll the admin details");
    	return new ResponseEntity<List<AdminDto>>(allAdmin , HttpStatus.OK);	
	}
	
	
	/**
	 * @apiNote This Api is For  The Update The Admin Details
	 * @param AdminDto
	 * @param adminId
	 * @return adminId
	 */
	
	@PutMapping("/admin/{adminId}")
	public ResponseEntity<AdminDto> updateAdmin( @RequestBody AdminDto adminDto , @PathVariable Long adminId){
		logger.info("Initiated request for update the admin details with adminId :{} " , adminId);
		AdminDto updateAdmin = this.adminService.updateAdmin(adminDto, adminId);
		logger.info("Completed request for update the admin details with adminId :{} " , adminId);
		return new ResponseEntity<AdminDto>(updateAdmin, HttpStatus.CREATED);		
	}
	
	/**
	 * @apiNote This Api is For  The Delete The Admin Details
	 * @param adminId
	 * @return 
	 */
	
	
	@DeleteMapping("/admin/{adminId}")
	public ResponseEntity<ApiResponse> deleteAdmin(@PathVariable Long adminId){
		logger.info("Initiated request for delete the admin details with adminId :{} " , adminId);
		this.adminService.deleteAdmin(adminId);
		logger.info("Completed request for delete the admin details with adminId :{} " , adminId);
		return new ResponseEntity<ApiResponse>(new ApiResponse(AppConstants.ADMIN_DELETE, true),HttpStatus.OK);
		
	}
}
