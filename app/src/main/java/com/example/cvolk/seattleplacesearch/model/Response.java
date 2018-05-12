package com.example.cvolk.seattleplacesearch.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Response{

	@SerializedName("geocode")
	private Geocode geocode;

	@SerializedName("venues")
	private List<VenuesItem> venues;

	public void setGeocode(Geocode geocode){
		this.geocode = geocode;
	}

	public Geocode getGeocode(){
		return geocode;
	}

	public void setVenues(List<VenuesItem> venues){
		this.venues = venues;
	}

	public List<VenuesItem> getVenues(){
		return venues;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"geocode = '" + geocode + '\'' + 
			",venues = '" + venues + '\'' + 
			"}";
		}
}