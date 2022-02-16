package com.dell.dremioclient.service;

import java.util.List;

import com.dell.dremioclient.model.AssetResponse;

public interface QueryRunnerService {

	public List<AssetResponse> getCommercialAssets() throws Exception;
}
