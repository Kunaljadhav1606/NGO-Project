package com.ngo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngo.dto.AdminDto;
import com.ngo.dto.LoginDto;
import com.ngo.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

	
	Admin findByLogin(LoginDto login);
}
