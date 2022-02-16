package com.dell.dremioclient.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.arrow.flight.FlightStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dell.dremioclient.model.AssetResponse;
import com.dell.dremioclient.repository.QueryRunnerRepository;
import com.dell.dremioclient.utils.AdhocFlightClient;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class QueryRunnerRepositoryImpl implements QueryRunnerRepository {

	@Autowired
	AdhocFlightClient adhocflightClient;

	/**
	 * This methods takes o(n^2) to map response to output model. This needs to be improved.
	 */
	@Override
	public List<AssetResponse> runQuery(final String query) throws Exception {

		List<AssetResponse> assets = new ArrayList<>();
		
		
		FlightStream fs = adhocflightClient.runQuery(query, null, null, true);
		
		while (fs.next()) {
			if (!fs.hasRoot()) {
				break;
			}

			int count = fs.getRoot().getRowCount();
			
			for(int i = 0; i < count; i++) {
				
				AssetResponse response = new AssetResponse();
				
				for(int j = 0; j < count; j++) {
					
					log.info("Looping for column : {}", fs.getRoot().getVector(j).getField().getName());
					
					if("ASSET_ID".equals(fs.getRoot().getVector(j).getField().getName())) {
						response.setAssetId(fs.getRoot().getVector(j).getObject(j) != null ? fs.getRoot().getVector(j).getObject(j).toString() : null);
					} else if("ACCNT_ID".equals(fs.getRoot().getVector(j).getField().getName())) {
						response.setAccntId(fs.getRoot().getVector(j).getObject(j) != null ? fs.getRoot().getVector(j).getObject(j).toString() : null);
					} else if("SITE_ID".equals(fs.getRoot().getVector(j).getField().getName())) {
						response.setSiteId(fs.getRoot().getVector(j).getObject(j) != null ? fs.getRoot().getVector(j).getObject(j).toString() : null);
					} else if("GROUP_ID".equals(fs.getRoot().getVector(i).getField().getName())) {
						response.setGroupId(fs.getRoot().getVector(j).getObject(j) != null ? fs.getRoot().getVector(j).getObject(j).toString() : null);
					} else if("MODEL_NAME".equals(fs.getRoot().getVector(j).getField().getName())) {
						response.setModelName(fs.getRoot().getVector(j).getObject(j) != null ? fs.getRoot().getVector(j).getObject(j).toString() : null);
					} else if("SAC_VERSION".equals(fs.getRoot().getVector(j).getField().getName())) {
						response.setSacVersion(fs.getRoot().getVector(j).getObject(j) != null ? fs.getRoot().getVector(j).getObject(j).toString() : null);
					}
				}
				
				assets.add(response);
			}
		}
		return assets;
	}
}
