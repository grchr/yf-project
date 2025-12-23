package org.opensource.model.response.profile;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultItem{

	@JsonProperty("assetProfile")
	private AssetProfile assetProfile;

	public AssetProfile getAssetProfile(){
		return assetProfile;
	}

	@Override
 	public String toString(){
		return
			"ResultItem{" +
			"assetProfile = '" + assetProfile + '\'' +
			"}";
		}
}