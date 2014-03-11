package com.gabrielbellon.model;

public class Portal {
	private int id;
	private String name;
	private double lat;
	private double lon;
	private int latE6;
	private int lonE6;
	private String address;

	public Portal() {}

	public Portal(int id, String name, double lat, double lon, String address) {
		this.id = id;
		this.name = name;
		this.lat = lat;
		this.lon = lon;
		this.address = address;
		this.latE6 = (int) (lat * 1e6);
		this.lonE6 = (int) (lon * 1e6);
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getLat() {
		return lat;
	}

	public double getLon() {
		return lon;
	}

	public String getAddress() {
		return address;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLat(double lat) {
		this.lat = lat;
		this.latE6 = (int) (lat * 1e6);
	}

	public void setLon(double lon) {
		this.lon = lon;
		this.lonE6 = (int) (lon * 1e6);
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getLatE6() {
		return latE6;
	}

	public int getLonE6() {
		return lonE6;
	}

	public void setLatE6(int latE6) {
		this.latE6 = latE6;
	}

	public void setLonE6(int lonE6) {
		this.lonE6 = lonE6;
	}

}
