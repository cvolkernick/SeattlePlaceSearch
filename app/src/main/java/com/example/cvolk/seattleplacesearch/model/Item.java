package com.example.cvolk.seattleplacesearch.model;

import com.google.gson.annotations.SerializedName;

public class Item{

	@SerializedName("unreadCount")
	private int unreadCount;

	public void setUnreadCount(int unreadCount){
		this.unreadCount = unreadCount;
	}

	public int getUnreadCount(){
		return unreadCount;
	}

	@Override
 	public String toString(){
		return 
			"Item{" + 
			"unreadCount = '" + unreadCount + '\'' + 
			"}";
		}
}