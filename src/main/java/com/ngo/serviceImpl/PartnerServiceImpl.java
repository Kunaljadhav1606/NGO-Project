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
import com.ngo.dto.LoginDto;
import com.ngo.dto.PartnerDto;
import com.ngo.model.Partner;
import com.ngo.repository.PartnerRepository;
import com.ngo.service.PartnerService;

@Service
public class PartnerServiceImpl implements PartnerService {

	Logger logger= LoggerFactory.getLogger(PartnerServiceImpl.class);
	@Autowired
	private PartnerRepository partnerRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public PartnerDto savePartner(PartnerDto partnerDto) {
		logger.info("Initiated Dao Call  For The Save Partner Details ");
		Partner partner = this.modelMapper.map(partnerDto, Partner.class);
		Partner savePartner = this.partnerRepository.save(partner);
		logger.info("Completed Dao Call  For The Save Partner Details ");
		return this.modelMapper.map(savePartner, PartnerDto.class);
	}

	@Override
	public PartnerDto updatePartner(PartnerDto partnerDto, Long partnerId) {
		logger.info(" Initiated Dao Call For The Update Partner Details With Id :{}",partnerId);
		Partner partner = this.partnerRepository.findById(partnerId).orElseThrow(() -> new ResolutionException(AppConstants.NOT_FOUND + partnerId));
		partner.setPartnerOrgnaisation(partnerDto.getPartnerOrgnaisation());
		partner.setPartnerContact(partnerDto.getPartnerContact());
		partner.setPartnerWebsite(partnerDto.getPartnerWebsite());
		Partner savePartner= this.partnerRepository.save(partner);
		logger.info(" Completed Dao Call For The Update Partner Details With Id :{}",partnerId);
		return this.modelMapper.map(savePartner, PartnerDto.class);
	}

	@Override
	public List<PartnerDto> getAllPartner() {
		logger.info("Initiated Dao Call For Get All Partner Details ");
		List<Partner> listPartner = this.partnerRepository.findAll();
		List<PartnerDto> collect = listPartner.stream().map((partner) -> this.modelMapper.map(partner, PartnerDto.class)).collect(Collectors.toList());
		logger.info("Initiated Dao Call For Get All Patner Details ");
		return collect;
	}

	@Override
	public void DeletePartner(Long partnerId) {
		logger.info("Initiated Dao Call For Delete Partner Details With Id :{}" ,partnerId);
		Partner partner = this.partnerRepository.findById(partnerId).orElseThrow(() -> new ResolutionException(AppConstants.NOT_FOUND + partnerId));
		logger.info("Completed Dao Call For Delete Partner Details With Id :{}" ,partnerId);
		this.partnerRepository.delete(partner);
		
	}

	@Override
	public PartnerDto getPartnerByLogin(LoginDto logindto) {
		Partner partner = this.partnerRepository.findByLogin(logindto);
		return this.modelMapper.map(partner, PartnerDto.class);
	}

}
