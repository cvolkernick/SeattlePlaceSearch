package com.example.cvolk.seattleplacesearch.model;

import com.google.gson.annotations.SerializedName;

public class BeenHere{

	@SerializedName("lastCheckinExpiredAt")
	private int lastCheckinExpiredAt;

	public void setLastCheckinExpiredAt(int lastCheckinExpiredAt){
		this.lastCheckinExpiredAt = lastCheckinExpiredAt;
	}

	public int getLastCheckinExpiredAt(){
		return lastCheckinExpiredAt;
	}

	@Override
 	public String toString(){
		return 
			"BeenHere{" + 
			"lastCheckinExpiredAt = '" + lastCheckinExpiredAt + '\'' + 
			"}";
		}
}