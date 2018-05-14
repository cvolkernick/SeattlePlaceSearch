package com.example.cvolk.seattleplacesearch.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Location implements Parcelable {

	@SerializedName("cc")
	private String cc;

	@SerializedName("country")
	private String country;

	@SerializedName("address")
	private String address;

	@SerializedName("labeledLatLngs")
	private List<LabeledLatLngsItem> labeledLatLngs;

	@SerializedName("lng")
	private double lng;

	@SerializedName("formattedAddress")
	private List<String> formattedAddress;

	@SerializedName("city")
	private String city;

	@SerializedName("postalCode")
	private String postalCode;

	@SerializedName("state")
	private String state;

	@SerializedName("crossStreet")
	private String crossStreet;

	@SerializedName("lat")
	private double lat;

	public void setCc(String cc){
		this.cc = cc;
	}

	public String getCc(){
		return cc;
	}

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return address;
	}

	public void setLabeledLatLngs(List<LabeledLatLngsItem> labeledLatLngs){
		this.labeledLatLngs = labeledLatLngs;
	}

	public List<LabeledLatLngsItem> getLabeledLatLngs(){
		return labeledLatLngs;
	}

	public void setLng(double lng){
		this.lng = lng;
	}

	public double getLng(){
		return lng;
	}

	public void setFormattedAddress(List<String> formattedAddress){
		this.formattedAddress = formattedAddress;
	}

	public List<String> getFormattedAddress(){
		return formattedAddress;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setPostalCode(String postalCode){
		this.postalCode = postalCode;
	}

	public String getPostalCode(){
		return postalCode;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}

	public void setCrossStreet(String crossStreet){
		this.crossStreet = crossStreet;
	}

	public String getCrossStreet(){
		return crossStreet;
	}

	public void setLat(double lat){
		this.lat = lat;
	}

	public double getLat(){
		return lat;
	}

	@Override
 	public String toString(){
		return 
			"Location{" + 
			"cc = '" + cc + '\'' + 
			",country = '" + country + '\'' + 
			",address = '" + address + '\'' + 
			",labeledLatLngs = '" + labeledLatLngs + '\'' + 
			",lng = '" + lng + '\'' + 
			",formattedAddress = '" + formattedAddress + '\'' + 
			",city = '" + city + '\'' + 
			",postalCode = '" + postalCode + '\'' + 
			",state = '" + state + '\'' + 
			",crossStreet = '" + crossStreet + '\'' + 
			",lat = '" + lat + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.cc);
		dest.writeString(this.country);
		dest.writeString(this.address);
		dest.writeList(this.labeledLatLngs);
		dest.writeDouble(this.lng);
		dest.writeStringList(this.formattedAddress);
		dest.writeString(this.city);
		dest.writeString(this.postalCode);
		dest.writeString(this.state);
		dest.writeString(this.crossStreet);
		dest.writeDouble(this.lat);
	}

	public Location() {
	}

	protected Location(Parcel in) {
		this.cc = in.readString();
		this.country = in.readString();
		this.address = in.readString();
		this.labeledLatLngs = new ArrayList<LabeledLatLngsItem>();
		in.readList(this.labeledLatLngs, LabeledLatLngsItem.class.getClassLoader());
		this.lng = in.readDouble();
		this.formattedAddress = in.createStringArrayList();
		this.city = in.readString();
		this.postalCode = in.readString();
		this.state = in.readString();
		this.crossStreet = in.readString();
		this.lat = in.readDouble();
	}

	public static final Parcelable.Creator<Location> CREATOR = new Parcelable.Creator<Location>() {
		@Override
		public Location createFromParcel(Parcel source) {
			return new Location(source);
		}

		@Override
		public Location[] newArray(int size) {
			return new Location[size];
		}
	};
}