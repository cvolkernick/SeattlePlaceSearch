package com.example.cvolk.seattleplacesearch.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Icon implements Parcelable {

	@SerializedName("prefix")
	private String prefix;

	@SerializedName("suffix")
	private String suffix;

	public void setPrefix(String prefix){
		this.prefix = prefix;
	}

	public String getPrefix(){
		return prefix;
	}

	public void setSuffix(String suffix){
		this.suffix = suffix;
	}

	public String getSuffix(){
		return suffix;
	}

	@Override
 	public String toString(){
		return 
			"Icon{" + 
			"prefix = '" + prefix + '\'' + 
			",suffix = '" + suffix + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.prefix);
		dest.writeString(this.suffix);
	}

	public Icon() {
	}

	protected Icon(Parcel in) {
		this.prefix = in.readString();
		this.suffix = in.readString();
	}

	public static final Parcelable.Creator<Icon> CREATOR = new Parcelable.Creator<Icon>() {
		@Override
		public Icon createFromParcel(Parcel source) {
			return new Icon(source);
		}

		@Override
		public Icon[] newArray(int size) {
			return new Icon[size];
		}
	};
}