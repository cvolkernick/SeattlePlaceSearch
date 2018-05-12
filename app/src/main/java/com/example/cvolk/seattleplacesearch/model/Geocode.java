package com.example.cvolk.seattleplacesearch.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Geocode{

	@SerializedName("what")
	private String what;

	@SerializedName("feature")
	private Feature feature;

	@SerializedName("where")
	private String where;

	@SerializedName("parents")
	private List<Object> parents;

	public void setWhat(String what){
		this.what = what;
	}

	public String getWhat(){
		return what;
	}

	public void setFeature(Feature feature){
		this.feature = feature;
	}

	public Feature getFeature(){
		return feature;
	}

	public void setWhere(String where){
		this.where = where;
	}

	public String getWhere(){
		return where;
	}

	public void setParents(List<Object> parents){
		this.parents = parents;
	}

	public List<Object> getParents(){
		return parents;
	}

	@Override
 	public String toString(){
		return 
			"Geocode{" + 
			"what = '" + what + '\'' + 
			",feature = '" + feature + '\'' + 
			",where = '" + where + '\'' + 
			",parents = '" + parents + '\'' + 
			"}";
		}
}