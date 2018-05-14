package com.example.cvolk.seattleplacesearch.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Specials implements Parcelable {

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

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(this.count);
		dest.writeList(this.items);
	}

	public Specials() {
	}

	protected Specials(Parcel in) {
		this.count = in.readInt();
		this.items = new ArrayList<Object>();
		in.readList(this.items, Object.class.getClassLoader());
	}

	public static final Parcelable.Creator<Specials> CREATOR = new Parcelable.Creator<Specials>() {
		@Override
		public Specials createFromParcel(Parcel source) {
			return new Specials(source);
		}

		@Override
		public Specials[] newArray(int size) {
			return new Specials[size];
		}
	};
}