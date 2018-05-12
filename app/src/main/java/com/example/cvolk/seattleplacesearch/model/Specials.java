package com.example.cvolk.seattleplacesearch.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Specials{

	@SerializedName("count")
	private int count;

	@SerializedName("items")
	private List<Object> items;

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	public void setItems(List<Object> items){
		this.items = items;
	}

	public List<Object> getItems(){
		return items;
	}

	@Override
 	public String toString(){
		return 
			"Specials{" + 
			"count = '" + count + '\'' + 
			",items = '" + items + '\'' + 
			"}";
		}
}