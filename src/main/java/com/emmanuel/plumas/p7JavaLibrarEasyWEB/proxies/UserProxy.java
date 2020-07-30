package com.emmanuel.plumas.p7JavaLibrarEasyWEB.proxies;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.emmanuel.plumas.p7JavaLibrarEasyWEB.model.UserEntity;


@FeignClient(name="p7JavaLibrarEasy-API",url="localhost:9001")
@Qualifier("UserProxy")
public interface UserProxy {
	
	@GetMapping(value="libraryUser/{userLastName}")
	UserEntity getUserByLastName (@PathVariable String userLastName);
}
