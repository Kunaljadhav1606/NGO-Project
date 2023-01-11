package com.ngo.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngo.constants.AppConstants;
import com.ngo.dto.LoginDto;
import com.ngo.dto.StaffDto;
import com.ngo.exception.ResourceNotFoundException;
import com.ngo.model.Staff;
import com.ngo.repository.StaffRepository;
import com.ngo.service.StaffService;

@Service
public class StaffServiceImpl implements StaffService{
	
	Logger logger=LoggerFactory.getLogger(StaffServiceImpl.class);
	@Autowired
	private StaffRepository staffRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public StaffDto saveAdmin(StaffDto staffDto) {
		logger.info("Initated Dao Call For Save The Saff Details ");
		Staff staff = this.modelMapper.map(staffDto, Staff.class);
		Staff saveStaff = this.staffRepository.save(staff);
		StaffDto staffdto = this.modelMapper.map(saveStaff, StaffDto.class);
		logger.info("Completed Dao Call For Save The Saff Details ");
		return staffdto;
	}

	@Override
	public StaffDto updateStaff(StaffDto staffDto, Long staffId) {
		logger.info("Initated Dao Call For Updated The staff Details With StaffId :{}" , staffId);
		Staff staff = this.staffRepository.findById(staffId).orElseThrow(() -> new ResourceNotFoundException(AppConstants.NOT_FOUND + staffId));
		staff.setStaffName(staffDto.getStaffName());
		staff.setStaffContact(staffDto.getStaffContact());
		staff.setStaffAadhar(staffDto.getStaffAadhar());
		staff.setStaffDesignation(staffDto.getStaffDesignation());
		staff.setStaffDepartment(staffDto.getStaffDepartment());
		staff.setStaffGender(staffDto.getStaffGender());
		
		Staff updatedStaff = this.staffRepository.save(staff);
		logger.info("Copleted Dao Call For Updated The staff Details With StaffId :{}" , staffId);
		return this.modelMapper.map(updatedStaff, StaffDto.class);
	}

	@Override
	public List<StaffDto> getAllStaff() {
		logger.info("Initated Dao Call For GetAll Staff Details");
		List<Staff> staffList= this.staffRepository.findAll();
		List<StaffDto> ListDtos = staffList.stream().map((staff) -> this.modelMapper.map(staff, StaffDto.class)).collect(Collectors.toList());
		logger.info("Completed Dao Call For GetAll Staff Details");
		
		return ListDtos;
	}

	@Override
	public void deleteStaff(Long staffId) {
		logger.info("Initated Dao Call For Deleted The Staff Deatils With StaffId : {}" , staffId);
		Staff staff = this.staffRepository.findById(staffId).orElseThrow(() -> new ResourceNotFoundException(AppConstants.NOT_FOUND + staffId));
		logger.info("Completed Dao Call For Deleted The Staff Deatils With StaffId : {}" , staffId);
		this.staffRepository.delete(staff);
		
	}

	@Override
	public StaffDto getStaffByLogin(LoginDto loginDto) {
	   Staff staff = this.staffRepository.findByLogin(loginDto);
		return this.modelMapper.map(staff, StaffDto.class);
	}

}
