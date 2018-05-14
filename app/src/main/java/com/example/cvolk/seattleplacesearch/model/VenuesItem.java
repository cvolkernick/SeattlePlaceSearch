package com.example.cvolk.seattleplacesearch.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class VenuesItem implements Parcelable {

	@SerializedName("hasPerk")
	private boolean hasPerk;

	@SerializedName("specials")
	private Specials specials;

	@SerializedName("referralId")
	private String referralId;

	@SerializedName("venueChains")
	private List<VenueChainsItem> venueChains;

	@SerializedName("verified")
	private boolean verified;

	@SerializedName("storeId")
	private String storeId;

	@SerializedName("url")
	private String url;

	@SerializedName("beenHere")
	private BeenHere beenHere;

	@SerializedName("hereNow")
	private HereNow hereNow;

	@SerializedName("stats")
	private Stats stats;

	@SerializedName("contact")
	private Contact contact;

	@SerializedName("name")
	private String name;

	@SerializedName("location")
	private Location location;

	@SerializedName("id")
	private String id;

	@SerializedName("categories")
	private List<CategoriesItem> categories;

	@SerializedName("allowMenuUrlEdit")
	private boolean allowMenuUrlEdit;

	public void setHasPerk(boolean hasPerk){
		this.hasPerk = hasPerk;
	}

	public boolean isHasPerk(){
		return hasPerk;
	}

	public void setSpecials(Specials specials){
		this.specials = specials;
	}

	public Specials getSpecials(){
		return specials;
	}

	public void setReferralId(String referralId){
		this.referralId = referralId;
	}

	public String getReferralId(){
		return referralId;
	}

	public void setVenueChains(List<VenueChainsItem> venueChains){
		this.venueChains = venueChains;
	}

	public List<VenueChainsItem> getVenueChains(){
		return venueChains;
	}

	public void setVerified(boolean verified){
		this.verified = verified;
	}

	public boolean isVerified(){
		return verified;
	}

	public void setStoreId(String storeId){
		this.storeId = storeId;
	}

	public String getStoreId(){
		return storeId;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setBeenHere(BeenHere beenHere){
		this.beenHere = beenHere;
	}

	public BeenHere getBeenHere(){
		return beenHere;
	}

	public void setHereNow(HereNow hereNow){
		this.hereNow = hereNow;
	}

	public HereNow getHereNow(){
		return hereNow;
	}

	public void setStats(Stats stats){
		this.stats = stats;
	}

	public Stats getStats(){
		return stats;
	}

	public void setContact(Contact contact){
		this.contact = contact;
	}

	public Contact getContact(){
		return contact;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setLocation(Location location){
		this.location = location;
	}

	public Location getLocation(){
		return location;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setCategories(List<CategoriesItem> categories){
		this.categories = categories;
	}

	public List<CategoriesItem> getCategories(){
		return categories;
	}

	public void setAllowMenuUrlEdit(boolean allowMenuUrlEdit){
		this.allowMenuUrlEdit = allowMenuUrlEdit;
	}

	public boolean isAllowMenuUrlEdit(){
		return allowMenuUrlEdit;
	}

	@Override
 	public String toString(){
		return 
			"VenuesItem{" + 
			"hasPerk = '" + hasPerk + '\'' + 
			",specials = '" + specials + '\'' + 
			",referralId = '" + referralId + '\'' + 
			",venueChains = '" + venueChains + '\'' + 
			",verified = '" + verified + '\'' + 
			",storeId = '" + storeId + '\'' + 
			",url = '" + url + '\'' + 
			",beenHere = '" + beenHere + '\'' + 
			",hereNow = '" + hereNow + '\'' + 
			",stats = '" + stats + '\'' + 
			",contact = '" + contact + '\'' + 
			",name = '" + name + '\'' + 
			",location = '" + location + '\'' + 
			",id = '" + id + '\'' + 
			",categories = '" + categories + '\'' + 
			",allowMenuUrlEdit = '" + allowMenuUrlEdit + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeByte(this.hasPerk ? (byte) 1 : (byte) 0);
		dest.writeParcelable(this.specials, flags);
		dest.writeString(this.referralId);
		dest.writeList(this.venueChains);
		dest.writeByte(this.verified ? (byte) 1 : (byte) 0);
		dest.writeString(this.storeId);
		dest.writeString(this.url);
		dest.writeParcelable(this.beenHere, flags);
		dest.writeParcelable(this.hereNow, flags);
		dest.writeParcelable(this.stats, flags);
		dest.writeParcelable(this.contact, flags);
		dest.writeString(this.name);
		dest.writeParcelable(this.location, flags);
		dest.writeString(this.id);
		dest.writeList(this.categories);
		dest.writeByte(this.allowMenuUrlEdit ? (byte) 1 : (byte) 0);
	}

	public VenuesItem() {
	}

	protected VenuesItem(Parcel in) {
		this.hasPerk = in.readByte() != 0;
		this.specials = in.readParcelable(Specials.class.getClassLoader());
		this.referralId = in.readString();
		this.venueChains = new ArrayList<VenueChainsItem>();
		in.readList(this.venueChains, VenueChainsItem.class.getClassLoader());
		this.verified = in.readByte() != 0;
		this.storeId = in.readString();
		this.url = in.readString();
		this.beenHere = in.readParcelable(BeenHere.class.getClassLoader());
		this.hereNow = in.readParcelable(HereNow.class.getClassLoader());
		this.stats = in.readParcelable(Stats.class.getClassLoader());
		this.contact = in.readParcelable(Contact.class.getClassLoader());
		this.name = in.readString();
		this.location = in.readParcelable(Location.class.getClassLoader());
		this.id = in.readString();
		this.categories = new ArrayList<CategoriesItem>();
		in.readList(this.categories, CategoriesItem.class.getClassLoader());
		this.allowMenuUrlEdit = in.readByte() != 0;
	}

	public static final Parcelable.Creator<VenuesItem> CREATOR = new Parcelable.Creator<VenuesItem>() {
		@Override
		public VenuesItem createFromParcel(Parcel source) {
			return new VenuesItem(source);
		}

		@Override
		public VenuesItem[] newArray(int size) {
			return new VenuesItem[size];
		}
	};
}