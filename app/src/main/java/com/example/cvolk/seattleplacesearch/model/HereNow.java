package com.example.cvolk.seattleplacesearch.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class HereNow implements Parcelable {

	@SerializedName("summary")
	private String summary;

	@SerializedName("count")
	private int count;

	@SerializedName("groups")
	private List<GroupsItem> groups;

	public void setSummary(String summary){
		this.summary = summary;
	}

	public String getSummary(){
		return summary;
	}

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	public void setGroups(List<GroupsItem> groups){
		this.groups = groups;
	}

	public List<GroupsItem> getGroups(){
		return groups;
	}

	@Override
 	public String toString(){
		return 
			"HereNow{" + 
			"summary = '" + summary + '\'' + 
			",count = '" + count + '\'' + 
			",groups = '" + groups + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.summary);
		dest.writeInt(this.count);
		dest.writeList(this.groups);
	}

	public HereNow() {
	}

	protected HereNow(Parcel in) {
		this.summary = in.readString();
		this.count = in.readInt();
		this.groups = new ArrayList<GroupsItem>();
		in.readList(this.groups, GroupsItem.class.getClassLoader());
	}

	public static final Parcelable.Creator<HereNow> CREATOR = new Parcelable.Creator<HereNow>() {
		@Override
		public HereNow createFromParcel(Parcel source) {
			return new HereNow(source);
		}

		@Override
		public HereNow[] newArray(int size) {
			return new HereNow[size];
		}
	};
}