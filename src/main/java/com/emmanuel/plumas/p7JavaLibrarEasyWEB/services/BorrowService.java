package com.emmanuel.plumas.p7JavaLibrarEasyWEB.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.emmanuel.plumas.p7JavaLibrarEasyWEB.model.BorrowEntity;
import com.emmanuel.plumas.p7JavaLibrarEasyWEB.proxies.ApiProxy;

@Service
@Qualifier("BorrowService")
public class BorrowService {
	
	@Autowired
	@Qualifier("ApiProxy")
	private ApiProxy apiProxy;
	
	
	public List<BorrowEntity> getBorrowByUserLastName(String userLastName){
		return apiProxy.getBorrowByUserName(userLastName);
	}
}
