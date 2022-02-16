package com.dell.dremioclient.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dell.dremioclient.model.AssetResponse;
import com.dell.dremioclient.repository.QueryRunnerRepository;
import com.dell.dremioclient.service.QueryRunnerService;

@Service
public class QueryRunnerServiceImpl implements QueryRunnerService{

	@Autowired
	QueryRunnerRepository repo;
	
	@Override
	public List<AssetResponse> getCommercialAssets() throws Exception {
		
		return repo.runQuery(QueryRunnerRepository.FETCH_COMMERCIAL_ASSETS);
	}
}
