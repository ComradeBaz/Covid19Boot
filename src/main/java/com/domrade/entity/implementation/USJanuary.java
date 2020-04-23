/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.entity.implementation;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author David
 */
@NamedQueries({ @NamedQuery(name = "USJanuary.findAllEntries", query = "SELECT j FROM USJanuary j"),
		@NamedQuery(name = "USJanuary.findAllStates", query = "SELECT DISTINCT j.provenceState FROM USJanuary j"),
		@NamedQuery(name = "USJanuary.findByProvenceState", query = "SELECT j FROM USJanuary j WHERE j.provenceState =:provenceState"),
		@NamedQuery(name = "USJanuary.findByCountryRegionProvinceState", query = "SELECT j FROM USJanuary j WHERE j.countryRegion =:countryRegion AND j.provenceState =:provenceState"),
		@NamedQuery(name = "USJanuary.findByCountryRegion", query = "SELECT j FROM USJanuary j WHERE j.countryRegion =:countryRegion") })
@Entity
@Table(name = "us_january")
public class USJanuary implements Serializable {

	public USJanuary() {
		// TODO Auto-generated constructor stub
	}

	public USJanuary(long id, String provenceState, String countryRegion, String latitude, String longitude,
			String admin2, int _22, int _23, int _24, int _25, int _26, int _27, int _28, int _29, int _30, int _31) {

		this.id = id;
		this.provenceState = provenceState;
		this.countryRegion = countryRegion;
		this.latitude = latitude;
		this.longitude = longitude;
		this.admin2 = admin2;
		this.jan22 = _22;
		this.jan23 = _23;
		this.jan24 = _24;
		this.jan25 = _25;
		this.jan26 = _26;
		this.jan27 = _27;
		this.jan28 = _28;
		this.jan29 = _29;
		this.jan30 = _30;
		this.jan31 = _31;
	}

	@Id
	@Column(name = "id", nullable = false)
	private long id;

	@Column(name = "provence_state")
	private String provenceState;
	@Column(name = "country_region", nullable = false)
	private String countryRegion;

	@Column(name = "lat")
	private String latitude;

	@Column(name = "longitude")
	private String longitude;

	@Column(name = "_22_01")
	private int jan22;

	@Column(name = "_23_01")
	private int jan23;

	@Column(name = "_24_01")
	private int jan24;

	@Column(name = "_25_01")
	private int jan25;

	@Column(name = "_26_01")
	private int jan26;

	@Column(name = "_27_01")
	private int jan27;

	@Column(name = "_28_01")
	private int jan28;

	@Column(name = "_29_01")
	private int jan29;

	@Column(name = "_30_01")
	private int jan30;

	@Column(name = "_31_01")
	private int jan31;

	@Column(name = "admin2")
	private String admin2;

	public String getAdmin2() {
		return admin2;
	}

	public void setAdmin2(String admin2) {
		this.admin2 = admin2;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public String getProvenceState() {
		return provenceState;
	}

	public void setProvenceState(String provenceState) {
		this.provenceState = provenceState;
	}

	public String getCountryRegion() {
		return countryRegion;
	}

	public void setCountryRegion(String countryRegion) {
		this.countryRegion = countryRegion;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public int getJan22() {
		return jan22;
	}

	public void setJan22(int jan22) {
		this.jan22 = jan22;
	}

	public int getJan23() {
		return jan23;
	}

	public void setJan23(int jan23) {
		this.jan23 = jan23;
	}

	public int getJan24() {
		return jan24;
	}

	public void setJan24(int jan24) {
		this.jan24 = jan24;
	}

	public int getJan25() {
		return jan25;
	}

	public void setJan25(int jan25) {
		this.jan25 = jan25;
	}

	public int getJan26() {
		return jan26;
	}

	public void setJan26(int jan26) {
		this.jan26 = jan26;
	}

	public int getJan27() {
		return jan27;
	}

	public void setJan27(int jan27) {
		this.jan27 = jan27;
	}

	public int getJan28() {
		return jan28;
	}

	public void setJan28(int jan28) {
		this.jan28 = jan28;
	}

	public int getJan29() {
		return jan29;
	}

	public void setJan29(int jan29) {
		this.jan29 = jan29;
	}

	public int getJan30() {
		return jan30;
	}

	public void setJan30(int jan30) {
		this.jan30 = jan30;
	}

	public int getJan31() {
		return jan31;
	}

	public void setJan31(int jan31) {
		this.jan31 = jan31;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		final USJanuary other = (USJanuary) obj;
		return Objects.equals(getId(), other.getId()) && Objects.equals(this.countryRegion, other.countryRegion)
				&& Objects.equals(this.provenceState, other.provenceState);
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 37 * hash + Objects.hashCode(this.provenceState);
		hash = 37 * hash + Objects.hashCode(this.countryRegion);
		hash = 37 * hash + Objects.hashCode(this.latitude);
		hash = 37 * hash + Objects.hashCode(this.longitude);
		return hash;
	}

	@Override
	public String toString() {
		return "USJanuary{" + "provenceState=" + provenceState + ", countryRegion=" + countryRegion + ", jan22=" + jan22
				+ ", jan23=" + jan23 + ", jan24=" + jan24 + ", jan25=" + jan25 + ", jan26=" + jan26 + ", jan27=" + jan27
				+ ", jan28=" + jan28 + ", jan29=" + jan29 + '}';
	}

}
