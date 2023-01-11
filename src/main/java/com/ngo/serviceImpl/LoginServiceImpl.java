package com.ngo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngo.dto.LoginDto;
import com.ngo.repository.LoginRepository;
import com.ngo.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository loginRepository;
	
	@Override
	public LoginDto getLogin(String loginUsername, String loginPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
