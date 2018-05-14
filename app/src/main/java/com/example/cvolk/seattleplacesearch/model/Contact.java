package com.example.cvolk.seattleplacesearch.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Contact implements Parcelable {

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

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.twitter);
		dest.writeString(this.phone);
		dest.writeString(this.formattedPhone);
	}

	public Contact() {
	}

	protected Contact(Parcel in) {
		this.twitter = in.readString();
		this.phone = in.readString();
		this.formattedPhone = in.readString();
	}

	public static final Parcelable.Creator<Contact> CREATOR = new Parcelable.Creator<Contact>() {
		@Override
		public Contact createFromParcel(Parcel source) {
			return new Contact(source);
		}

		@Override
		public Contact[] newArray(int size) {
			return new Contact[size];
		}
	};
}