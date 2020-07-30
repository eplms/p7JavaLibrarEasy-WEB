package com.emmanuel.plumas.p7JavaLibrarEasyWEB.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.emmanuel.plumas.p7JavaLibrarEasyWEB.model.UserEntity;
import com.emmanuel.plumas.p7JavaLibrarEasyWEB.proxies.UserProxy;

@Service
@Qualifier("UserService")
public class UserService {

	@Autowired
	@Qualifier("UserProxy")
	private UserProxy userProxy;
	
	public UserEntity findByLastName(String userLastName) {
		UserEntity userEntity=userProxy.getUserByLastName(userLastName);
		return userEntity;
	}
	
}
