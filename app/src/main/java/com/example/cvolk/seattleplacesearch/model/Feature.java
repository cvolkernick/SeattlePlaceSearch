package com.example.cvolk.seattleplacesearch.model;

import com.google.gson.annotations.SerializedName;

public class Feature{

	@SerializedName("cc")
	private String cc;

	@SerializedName("woeType")
	private int woeType;

	@SerializedName("highlightedName")
	private String highlightedName;

	@SerializedName("displayName")
	private String displayName;

	@SerializedName("name")
	private String name;

	@SerializedName("geometry")
	private Geometry geometry;

	@SerializedName("id")
	private String id;

	@SerializedName("longId")
	private String longId;

	@SerializedName("matchedName")
	private String matchedName;

	@SerializedName("slug")
	private String slug;

	public void setCc(String cc){
		this.cc = cc;
	}

	public String getCc(){
		return cc;
	}

	public void setWoeType(int woeType){
		this.woeType = woeType;
	}

	public int getWoeType(){
		return woeType;
	}

	public void setHighlightedName(String highlightedName){
		this.highlightedName = highlightedName;
	}

	public String getHighlightedName(){
		return highlightedName;
	}

	public void setDisplayName(String displayName){
		this.displayName = displayName;
	}

	public String getDisplayName(){
		return displayName;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setGeometry(Geometry geometry){
		this.geometry = geometry;
	}

	public Geometry getGeometry(){
		return geometry;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setLongId(String longId){
		this.longId = longId;
	}

	public String getLongId(){
		return longId;
	}

	public void setMatchedName(String matchedName){
		this.matchedName = matchedName;
	}

	public String getMatchedName(){
		return matchedName;
	}

	public void setSlug(String slug){
		this.slug = slug;
	}

	public String getSlug(){
		return slug;
	}

	@Override
 	public String toString(){
		return 
			"Feature{" + 
			"cc = '" + cc + '\'' + 
			",woeType = '" + woeType + '\'' + 
			",highlightedName = '" + highlightedName + '\'' + 
			",displayName = '" + displayName + '\'' + 
			",name = '" + name + '\'' + 
			",geometry = '" + geometry + '\'' + 
			",id = '" + id + '\'' + 
			",longId = '" + longId + '\'' + 
			",matchedName = '" + matchedName + '\'' + 
			",slug = '" + slug + '\'' + 
			"}";
		}
}