package com.example.cvolk.seattleplacesearch.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class BeenHere implements Parcelable {

	@SerializedName("lastCheckinExpiredAt")
	private int lastCheckinExpiredAt;

	public void setLastCheckinExpiredAt(int lastCheckinExpiredAt){
		this.lastCheckinExpiredAt = lastCheckinExpiredAt;
	}

	public int getLastCheckinExpiredAt(){
		return lastCheckinExpiredAt;
	}

	@Override
 	public String toString(){
		return 
			"BeenHere{" + 
			"lastCheckinExpiredAt = '" + lastCheckinExpiredAt + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(this.lastCheckinExpiredAt);
	}

	public BeenHere() {
	}

	protected BeenHere(Parcel in) {
		this.lastCheckinExpiredAt = in.readInt();
	}

	public static final Parcelable.Creator<BeenHere> CREATOR = new Parcelable.Creator<BeenHere>() {
		@Override
		public BeenHere createFromParcel(Parcel source) {
			return new BeenHere(source);
		}

		@Override
		public BeenHere[] newArray(int size) {
			return new BeenHere[size];
		}
	};
}