package com.ngo.serviceImpl;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngo.constants.AppConstants;
import com.ngo.dto.DonorDto;
import com.ngo.dto.LoginDto;
import com.ngo.model.Donor;
import com.ngo.repository.DonorRepository;
import com.ngo.service.DonarService;

@Service
public class DonorServiceImpl implements DonarService {

	Logger logger= LoggerFactory.getLogger(DonorServiceImpl.class);
	@Autowired
	private DonorRepository donorRepository;
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public DonorDto saveDonor(DonorDto donorDto) {
		logger.info("Initiated Dao Call For Save The Donor Details");
		Donor donor = this.modelMapper.map(donorDto, Donor.class);
		Donor saveDonor = this.donorRepository.save(donor);
		DonorDto DonorDto = this.modelMapper.map(saveDonor, DonorDto.class);
		logger.info("Completed Dao Call For Save The Donor Details");
		return DonorDto;
	}

	@Override
	public DonorDto updateDonor(DonorDto donorDto, Long donorId) {
		logger.info("Initiated Dao call For Update The Donor Details With DonorId :{}" , donorId);
		Donor donor = this.donorRepository.findById(donorId).orElseThrow(() -> new ResolutionException(AppConstants.NOT_FOUND + donorId));
		donor.setDonorName(donorDto.getDonorName());
		donor.setDonorContact(donorDto.getDonorContact());
		donor.setDonorPAN(donorDto.getDonorPAN());
		donor.setDonorGender(donorDto.getDonorDOB());
		donor.setDonorDOB(donorDto.getDonorDOB());
		donor.setDonorAmount(donorDto.getDonorAmount());
		Donor saveDonor = this.donorRepository.save(donor);
		logger.info("Completed Dao Call For Update The Donor Details With DonorId :{}" , donorId);
		
		return this.modelMapper.map(saveDonor, DonorDto.class);
	}

	@Override
	public List<DonorDto> GetAllDonors() {
		logger.info("Initiated Dao Call For Get All Donors Details ");
		List<Donor> DonorList= this.donorRepository.findAll();
		  List<DonorDto> Dtolist = DonorList.stream().map((admin) -> this.modelMapper.map(admin, DonorDto.class)).collect(Collectors.toList());
		  logger.info("Completed Dao Call For Get All Donors Details ");
		return Dtolist ;
	}

	@Override
	public void deltedDonor(Long donorId) {
		logger.info("Initiated Dao Call For Delete The Donor Details Wiht DonorId :{}" ,donorId);
		Donor donor = this.donorRepository.findById(donorId).orElseThrow(() -> new ResolutionException(AppConstants.NOT_FOUND + donorId));
		logger.info("Completed Dao Call For Delete The Donor Details Wiht DonorId :{}" ,donorId);
		this.donorRepository.delete(donor);
		
	}

	@Override
	public DonorDto getDonorByLogin(LoginDto loginDto) {
		Donor donor = this.donorRepository.findByLogin(loginDto);
		return this.modelMapper.map(donor, DonorDto.class);
	}

}
