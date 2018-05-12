package com.example.cvolk.seattleplacesearch.model;

import com.google.gson.annotations.SerializedName;

public class VenueChainsItem{

	@SerializedName("id")
	private String id;

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"VenueChainsItem{" + 
			"id = '" + id + '\'' + 
			"}";
		}
}