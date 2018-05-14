package com.example.cvolk.seattleplacesearch.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Stats implements Parcelable {

	@SerializedName("checkinsCount")
	private int checkinsCount;

	@SerializedName("usersCount")
	private int usersCount;

	@SerializedName("tipCount")
	private int tipCount;

	public void setCheckinsCount(int checkinsCount){
		this.checkinsCount = checkinsCount;
	}

	public int getCheckinsCount(){
		return checkinsCount;
	}

	public void setUsersCount(int usersCount){
		this.usersCount = usersCount;
	}

	public int getUsersCount(){
		return usersCount;
	}

	public void setTipCount(int tipCount){
		this.tipCount = tipCount;
	}

	public int getTipCount(){
		return tipCount;
	}

	@Override
 	public String toString(){
		return 
			"Stats{" + 
			"checkinsCount = '" + checkinsCount + '\'' + 
			",usersCount = '" + usersCount + '\'' + 
			",tipCount = '" + tipCount + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(this.checkinsCount);
		dest.writeInt(this.usersCount);
		dest.writeInt(this.tipCount);
	}

	public Stats() {
	}

	protected Stats(Parcel in) {
		this.checkinsCount = in.readInt();
		this.usersCount = in.readInt();
		this.tipCount = in.readInt();
	}

	public static final Parcelable.Creator<Stats> CREATOR = new Parcelable.Creator<Stats>() {
		@Override
		public Stats createFromParcel(Parcel source) {
			return new Stats(source);
		}

		@Override
		public Stats[] newArray(int size) {
			return new Stats[size];
		}
	};
}