package com.example.cvolk.seattleplacesearch.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class FourSquareResponse{

	@SerializedName("meta")
	private Meta meta;

	@SerializedName("response")
	private Response response;

	@SerializedName("notifications")
	private List<NotificationsItem> notifications;

	public void setMeta(Meta meta){
		this.meta = meta;
	}

	public Meta getMeta(){
		return meta;
	}

	public void setResponse(Response response){
		this.response = response;
	}

	public Response getResponse(){
		return response;
	}

	public void setNotifications(List<NotificationsItem> notifications){
		this.notifications = notifications;
	}

	public List<NotificationsItem> getNotifications(){
		return notifications;
	}

	@Override
 	public String toString(){
		return 
			"FourSquareResponse{" + 
			"meta = '" + meta + '\'' + 
			",response = '" + response + '\'' + 
			",notifications = '" + notifications + '\'' + 
			"}";
		}
}