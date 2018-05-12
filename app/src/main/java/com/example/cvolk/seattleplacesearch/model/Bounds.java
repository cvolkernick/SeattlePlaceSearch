package com.example.cvolk.seattleplacesearch.model;

import com.google.gson.annotations.SerializedName;

public class Bounds{

	@SerializedName("sw")
	private Sw sw;

	@SerializedName("ne")
	private Ne ne;

	public void setSw(Sw sw){
		this.sw = sw;
	}

	public Sw getSw(){
		return sw;
	}

	public void setNe(Ne ne){
		this.ne = ne;
	}

	public Ne getNe(){
		return ne;
	}

	@Override
 	public String toString(){
		return 
			"Bounds{" + 
			"sw = '" + sw + '\'' + 
			",ne = '" + ne + '\'' + 
			"}";
		}
}