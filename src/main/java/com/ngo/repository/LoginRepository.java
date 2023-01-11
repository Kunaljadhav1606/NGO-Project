package com.ngo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.ngo.model.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {

//	@Query(name ="select new package.Login(a.login_username , a.login_password) form login a")
	Login getByLoginUsernameAndLoginPassword(String loginUsername , String loginPassword);
	
}
