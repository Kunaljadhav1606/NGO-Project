package com.ngo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngo.dto.LoginDto;
import com.ngo.model.Partner;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long>{

	Partner findByLogin(LoginDto loginDto);
}
