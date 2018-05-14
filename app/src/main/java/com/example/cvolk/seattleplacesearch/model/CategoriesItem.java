package com.example.cvolk.seattleplacesearch.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class CategoriesItem implements Parcelable {

	@SerializedName("pluralName")
	private String pluralName;

	@SerializedName("name")
	private String name;

	@SerializedName("icon")
	private Icon icon;

	@SerializedName("id")
	private String id;

	@SerializedName("shortName")
	private String shortName;

	@SerializedName("primary")
	private boolean primary;

	public void setPluralName(String pluralName){
		this.pluralName = pluralName;
	}

	public String getPluralName(){
		return pluralName;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setIcon(Icon icon){
		this.icon = icon;
	}

	public Icon getIcon(){
		return icon;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setShortName(String shortName){
		this.shortName = shortName;
	}

	public String getShortName(){
		return shortName;
	}

	public void setPrimary(boolean primary){
		this.primary = primary;
	}

	public boolean isPrimary(){
		return primary;
	}

	@Override
 	public String toString(){
		return 
			"CategoriesItem{" + 
			"pluralName = '" + pluralName + '\'' + 
			",name = '" + name + '\'' + 
			",icon = '" + icon + '\'' + 
			",id = '" + id + '\'' + 
			",shortName = '" + shortName + '\'' + 
			",primary = '" + primary + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.pluralName);
		dest.writeString(this.name);
		dest.writeParcelable(this.icon, flags);
		dest.writeString(this.id);
		dest.writeString(this.shortName);
		dest.writeByte(this.primary ? (byte) 1 : (byte) 0);
	}

	public CategoriesItem() {
	}

	protected CategoriesItem(Parcel in) {
		this.pluralName = in.readString();
		this.name = in.readString();
		this.icon = in.readParcelable(Icon.class.getClassLoader());
		this.id = in.readString();
		this.shortName = in.readString();
		this.primary = in.readByte() != 0;
	}

	public static final Parcelable.Creator<CategoriesItem> CREATOR = new Parcelable.Creator<CategoriesItem>() {
		@Override
		public CategoriesItem createFromParcel(Parcel source) {
			return new CategoriesItem(source);
		}

		@Override
		public CategoriesItem[] newArray(int size) {
			return new CategoriesItem[size];
		}
	};
}