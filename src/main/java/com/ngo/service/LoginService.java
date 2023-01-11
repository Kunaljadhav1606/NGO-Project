package com.ngo.service;

import com.ngo.dto.LoginDto;

public interface LoginService {

	LoginDto getLogin(String loginUsername , String loginPassword);
}
