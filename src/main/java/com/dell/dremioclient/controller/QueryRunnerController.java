package com.dell.dremioclient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dell.dremioclient.model.AssetResponse;
import com.dell.dremioclient.service.QueryRunnerService;

@RestController
public class QueryRunnerController {
	
	@Autowired
	QueryRunnerService service;
	
	@GetMapping("/getCommercialAssets")
	public List<AssetResponse> getCommercialAssets() throws Exception {
		
		return service.getCommercialAssets();
	}
}
