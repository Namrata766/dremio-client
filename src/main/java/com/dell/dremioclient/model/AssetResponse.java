package com.dell.dremioclient.model;

import java.io.Serializable;

public class AssetResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4808691613139671396L;
	
	private String assetId;
	private String accntId;
	private String siteId;
	private String groupId;
	private String modelName;
	private String sacVersion;
	public String getAssetId() {
		return assetId;
	}
	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}
	public String getAccntId() {
		return accntId;
	}
	public void setAccntId(String accntId) {
		this.accntId = accntId;
	}
	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getSacVersion() {
		return sacVersion;
	}
	public void setSacVersion(String sacVersion) {
		this.sacVersion = sacVersion;
	}
}
