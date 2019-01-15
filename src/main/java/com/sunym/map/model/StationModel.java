package com.sunym.map.model;

import java.math.BigDecimal;

public class StationModel {

	private String routeCode;

	private Integer stationNo;

	private String stationName;

	private BigDecimal lat;

	private BigDecimal lng;

	private BigDecimal lat1;

	private BigDecimal lng1;

	private BigDecimal lat2;

	private BigDecimal lng2;

	public String getRouteCode() {
		return routeCode;
	}

	public void setRouteCode(String routeCode) {
		this.routeCode = routeCode;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public Integer getStationNo() {
		return stationNo;
	}

	public void setStationNo(Integer stationNo) {
		this.stationNo = stationNo;
	}

	public BigDecimal getLat() {
		return lat;
	}

	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}

	public BigDecimal getLng() {
		return lng;
	}

	public void setLng(BigDecimal lng) {
		this.lng = lng;
	}

	public BigDecimal getLat1() {
		return lat1;
	}

	public void setLat1(BigDecimal lat1) {
		this.lat1 = lat1;
	}

	public BigDecimal getLng1() {
		return lng1;
	}

	public void setLng1(BigDecimal lng1) {
		this.lng1 = lng1;
	}

	public BigDecimal getLat2() {
		return lat2;
	}

	public void setLat2(BigDecimal lat2) {
		this.lat2 = lat2;
	}

	public BigDecimal getLng2() {
		return lng2;
	}

	public void setLng2(BigDecimal lng2) {
		this.lng2 = lng2;
	}
}
