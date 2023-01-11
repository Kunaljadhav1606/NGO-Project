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
import com.ngo.dto.StaffDto;
import com.ngo.payloads.ApiResponse;
import com.ngo.service.StaffService;

@RestController
@RequestMapping("/api")
public class StaffController {

	Logger logger= LoggerFactory.getLogger(StaffController.class);
	
	@Autowired
	private StaffService staffService;
	
	
	/**
	   *@author kunal
	   *@param staffDto
	   *@apiNote This Api Is To save Staffr Data
	   * 
	   */
	@PostMapping("/staff")
	public ResponseEntity<StaffDto> saveStaff(@RequestBody StaffDto staffDto){
		logger.info("Initated Request For Save The Saff Details ");
		StaffDto saveStaff= staffService.saveAdmin(staffDto);
		logger.info("Completed Request For Save The Saff Details ");
		return new ResponseEntity<StaffDto>(saveStaff,HttpStatus.CREATED);
		
	}
	
	/**
	 * @apiNote This Api is For  The Update The Staff Details
	 * @param staffDto
	 * @param staffId
	 * @return staffId
	 */
	
	@PutMapping("/staff/{staffId}")
	public ResponseEntity<StaffDto> updateStaff(@RequestBody StaffDto staffDto , @PathVariable Long staffId){
		logger.info("Initated Request For Updated The staff Details With StaffId :{}" , staffId);
		StaffDto updateStaff = staffService.updateStaff(staffDto, staffId);
		logger.info("Completed Request For Updated The staff Details With StaffId :{}" , staffId);
		return new ResponseEntity<StaffDto>(updateStaff , HttpStatus.CREATED);
		
	}
	
	/**
	   *@apiNote This Api Is For Get Staff Details
	   * @return
	   */
	@GetMapping("/staffs")
	public ResponseEntity<List<StaffDto>> getAllStaff(){
		logger.info("Initated Request For GetAll Staff Details");
		List<StaffDto> allStaff = staffService.getAllStaff();
		logger.info("Completed Request For GetAll Staff Details");
		return new ResponseEntity<List<StaffDto>>(allStaff , HttpStatus.OK);
		
	}
	
	/**
	 * @apiNote This Api is For  The Delete The Staff Details
	 * @param staffId
	 * @return 
	 */
	@DeleteMapping("/staff/{staffId}")
	public ResponseEntity<ApiResponse> deleteStaff(@PathVariable Long staffId){
		logger.info("Initated Request For Deleted The Staff Deatils With StaffId : {}" , staffId);
		staffService.deleteStaff(staffId);
		logger.info("Completed Request For Deleted The Staff Deatils With StaffId : {}" , staffId);
		return new ResponseEntity<ApiResponse>(new ApiResponse(AppConstants.STAFF_DELTE, true) , HttpStatus.OK);
		
	}
}
