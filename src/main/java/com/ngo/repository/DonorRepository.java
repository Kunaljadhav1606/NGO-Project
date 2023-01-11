package com.ngo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngo.dto.DonorDto;
import com.ngo.dto.LoginDto;
import com.ngo.model.Donor;

@Repository
public interface DonorRepository extends JpaRepository<Donor, Long>{

	Donor findByLogin(LoginDto loginDto);
}
