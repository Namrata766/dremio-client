package com.dell.dremioclient.repository;

import java.util.List;

import com.dell.dremioclient.model.AssetResponse;

public interface QueryRunnerRepository {

	public static final String SELECT_ASSET_TAG = "SELECT * FROM sahub.\"asset_master_table\" fetch first 10 rows only";
	
	public static final String FETCH_COMMERCIAL_ASSETS = "SELECT * FROM sahub.poc.\"assets\" fetch first 10 rows only";
	
	List<AssetResponse> runQuery(String query) throws Exception;
}
