package com.example.cvolk.seattleplacesearch.model;

import com.google.gson.annotations.SerializedName;

public class Contact{

	@SerializedName("twitter")
	private String twitter;

	@SerializedName("phone")
	private String phone;

	@SerializedName("formattedPhone")
	private String formattedPhone;

	public void setTwitter(String twitter){
		this.twitter = twitter;
	}

	public String getTwitter(){
		return twitter;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return phone;
	}

	public void setFormattedPhone(String formattedPhone){
		this.formattedPhone = formattedPhone;
	}

	public String getFormattedPhone(){
		return formattedPhone;
	}

	@Override
 	public String toString(){
		return 
			"Contact{" + 
			"twitter = '" + twitter + '\'' + 
			",phone = '" + phone + '\'' + 
			",formattedPhone = '" + formattedPhone + '\'' + 
			"}";
		}
}