package com.example.cvolk.seattleplacesearch.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class VenuesItem{

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
}