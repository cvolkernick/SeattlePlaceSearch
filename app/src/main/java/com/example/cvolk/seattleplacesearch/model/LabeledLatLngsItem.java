package com.example.cvolk.seattleplacesearch.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class LabeledLatLngsItem implements Parcelable {

	@SerializedName("lng")
	private double lng;

	@SerializedName("label")
	private String label;

	@SerializedName("lat")
	private double lat;

	public void setLng(double lng){
		this.lng = lng;
	}

	public double getLng(){
		return lng;
	}

	public void setLabel(String label){
		this.label = label;
	}

	public String getLabel(){
		return label;
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
			"LabeledLatLngsItem{" + 
			"lng = '" + lng + '\'' + 
			",label = '" + label + '\'' + 
			",lat = '" + lat + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeDouble(this.lng);
		dest.writeString(this.label);
		dest.writeDouble(this.lat);
	}

	public LabeledLatLngsItem() {
	}

	protected LabeledLatLngsItem(Parcel in) {
		this.lng = in.readDouble();
		this.label = in.readString();
		this.lat = in.readDouble();
	}

	public static final Parcelable.Creator<LabeledLatLngsItem> CREATOR = new Parcelable.Creator<LabeledLatLngsItem>() {
		@Override
		public LabeledLatLngsItem createFromParcel(Parcel source) {
			return new LabeledLatLngsItem(source);
		}

		@Override
		public LabeledLatLngsItem[] newArray(int size) {
			return new LabeledLatLngsItem[size];
		}
	};
}