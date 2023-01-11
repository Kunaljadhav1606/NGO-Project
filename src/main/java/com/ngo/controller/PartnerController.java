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
import com.ngo.dto.PartnerDto;
import com.ngo.payloads.ApiResponse;
import com.ngo.service.PartnerService;

@RestController
@RequestMapping("/api")
public class PartnerController {

	Logger logger= LoggerFactory.getLogger(PartnerController.class);
	
	@Autowired
	private PartnerService partnerService;
	
	
	/**
	   *@author kunal
	   *@param PartnerDto
	   *@apiNote This Api Is To save Partner Data
	   * 
	   */
	@PostMapping("/partner")
	public ResponseEntity<PartnerDto> savePartner( @RequestBody PartnerDto partnerDto){
		logger.info("Initiated  Request For The Save Partner Details ");
		PartnerDto savePartner = this.partnerService.savePartner(partnerDto);
		logger.info("Completed  Request For The Save Partner Details ");
		return new ResponseEntity<PartnerDto>(savePartner, HttpStatus.CREATED);
		
	}
	
	/**
	 * @apiNote This Api is For  The Update The Partner Details
	 * @param PartnerDto
	 * @param partnerId
	 * @return partnerDto
	 */
	
	@PutMapping("/partner/{partnerId}")
    public ResponseEntity<PartnerDto> updatePartner( @RequestBody PartnerDto   partnerDto, @PathVariable Long partnerId){
		logger.info(" Initiated Request For The Update Partner Details With Id :{}",partnerId);
		PartnerDto updatePartner = this.partnerService.updatePartner(partnerDto, partnerId);
		logger.info(" Completed Request For The Update Partner Details With Id :{}",partnerId);
    	return new ResponseEntity<PartnerDto>(updatePartner,HttpStatus.CREATED);
    	
    }
	
	
	/**
	   *@apiNote This Api Is For Get Partner Details
	   * @return
	   */
	@GetMapping("/partners")
	public ResponseEntity<List<PartnerDto>> getAllPatner(){
	    logger.info("Initiated Request For Get All Partner Details ");
		List<PartnerDto> listPartner = this.partnerService.getAllPartner();
		logger.info("Completed Request For Get All Partner Details ");
		return new ResponseEntity<List<PartnerDto>>(listPartner, HttpStatus.OK);
		
	}
	
	/**
	 * @apiNote This Api is For  The Delete The Partner Details
	 * @param partnerId
	 * @return 
	 */
	@DeleteMapping("/partner/{partnerId}")
	public ResponseEntity<ApiResponse> deletePartner(@PathVariable Long partnerId){
		logger.info("Initiated Request For Deleted Partner Details with Id :{}",partnerId);
		this.partnerService.DeletePartner(partnerId);
		logger.info("Completed Request For Deleted Partner Details with Id :{}",partnerId);
		return new ResponseEntity<ApiResponse>(new ApiResponse(AppConstants.PARTNER_DELETE,true),HttpStatus.OK);
		
	}
	
}
