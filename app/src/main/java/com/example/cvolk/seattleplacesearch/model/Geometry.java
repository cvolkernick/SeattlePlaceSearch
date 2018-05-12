package com.example.cvolk.seattleplacesearch.model;

import com.google.gson.annotations.SerializedName;

public class Geometry{

	@SerializedName("center")
	private Center center;

	@SerializedName("bounds")
	private Bounds bounds;

	public void setCenter(Center center){
		this.center = center;
	}

	public Center getCenter(){
		return center;
	}

	public void setBounds(Bounds bounds){
		this.bounds = bounds;
	}

	public Bounds getBounds(){
		return bounds;
	}

	@Override
 	public String toString(){
		return 
			"Geometry{" + 
			"center = '" + center + '\'' + 
			",bounds = '" + bounds + '\'' + 
			"}";
		}
}