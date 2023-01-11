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
import com.ngo.dto.DonorDto;
import com.ngo.payloads.ApiResponse;
import com.ngo.serviceImpl.DonorServiceImpl;

@RestController
@RequestMapping("/api")
public class DonorController {

	Logger logger= LoggerFactory.getLogger(DonorController.class);
	@Autowired
	private DonorServiceImpl donorServiceImpl;
	
	
	/**
	   *@author kunal
	   *@param DonorDto
	   *@apiNote This Api Is To save Donor Data
	   * 
	   */
	@PostMapping("/donor")
	public ResponseEntity<DonorDto> saveDonor( @RequestBody DonorDto donorDto){
		logger.info("Initiated Request For Save The Donor Details");
		DonorDto saveDonor = this.donorServiceImpl.saveDonor(donorDto);
		logger.info("Completed Request For Save The Donor Details");
		return new ResponseEntity<DonorDto>(saveDonor , HttpStatus.CREATED);
		
	}
	
	
	/**
	 * @apiNote This Api is For  The Update The Donor Details
	 * @param DonorDto
	 * @param donorId
	 * @return donorId
	 */
	
	@PutMapping("/donor/{donorId}")
	public ResponseEntity<DonorDto> updateDonor(@RequestBody DonorDto donorDto , @PathVariable Long donorId){
		logger.info("Initiated Request For Update The Donor Details With DonorId :{}" , donorId);
		DonorDto updateDonor = this.donorServiceImpl.updateDonor(donorDto, donorId);
		logger.info("Completed Request For Update The Donor Details With DonorId :{}" , donorId);
		return new ResponseEntity<DonorDto>(updateDonor , HttpStatus.CREATED);
		
	}
	
	
	/**
	   *@apiNote This Api Is For Get Donor Details
	   * @return
	   */
	
	@GetMapping("/donors")
	public ResponseEntity<List<DonorDto>> getAllDonor(){
		logger.info("Initiated Request For Get All Donors Details ");
		List<DonorDto> getAllDonors = this.donorServiceImpl.GetAllDonors();
		logger.info("Completed Request For Get All Donors Details ");
		return new ResponseEntity<List<DonorDto>>(getAllDonors ,HttpStatus.OK);
		
	}
	
	
	/**
	 * @apiNote This Api is For  The Delete The Donor Details
	 * @param donorId
	 * @return 
	 */
	
	@DeleteMapping("/donor/{donorId}")
	public ResponseEntity<ApiResponse> deleteDonor(@PathVariable Long donorId){
		logger.info("Initiated Request For Delete The Donor Details Wiht DonorId :{}" ,donorId);
		this.donorServiceImpl.deltedDonor(donorId);
		logger.info("Completed Request For Delete The Donor Details Wiht DonorId :{}" ,donorId);
		return new ResponseEntity<ApiResponse>(new ApiResponse(AppConstants.DONOR_DELETE, true),HttpStatus.OK);
		
	}
	
}
