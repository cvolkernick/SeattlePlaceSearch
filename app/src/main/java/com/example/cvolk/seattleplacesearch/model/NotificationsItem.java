package com.example.cvolk.seattleplacesearch.model;

import com.google.gson.annotations.SerializedName;

public class NotificationsItem{

	@SerializedName("item")
	private Item item;

	@SerializedName("type")
	private String type;

	public void setItem(Item item){
		this.item = item;
	}

	public Item getItem(){
		return item;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	@Override
 	public String toString(){
		return 
			"NotificationsItem{" + 
			"item = '" + item + '\'' + 
			",type = '" + type + '\'' + 
			"}";
		}
}