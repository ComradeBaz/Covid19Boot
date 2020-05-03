package com.domrade.entity.implementation;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({ @NamedQuery(name = "MayDeaths.findAllEntries", query = "SELECT m FROM MayDeaths m"),
		@NamedQuery(name = "MayDeaths.findByCountryRegion", query = "SELECT m FROM MayDeaths m WHERE m.countryRegion =:countryRegion") })
@Entity
@Table(name = "may_deaths")
public class MayDeaths implements Serializable {

	public MayDeaths() {
		// TODO Auto-generated constructor stub
	}

	public MayDeaths(long id, String provenceState, String countryRegion, String latitude, String longitude, int _1,
			int _2, int _3, int _4, int _5, int _6, int _7, int _8, int _9, int _10, int _11, int _12, int _13, int _14,
			int _15, int _16, int _17, int _18, int _19, int _20, int _21, int _22, int _23, int _24, int _25, int _26,
			int _27, int _28, int _29, int _30, int _31) {

		this.id = id;
		this.provenceState = provenceState;
		this.countryRegion = countryRegion;
		this.latitude = latitude;
		this.longitude = longitude;
		this.may01 = _1;
		this.may02 = _2;
		this.may03 = _3;
		this.may04 = _4;
		this.may05 = _5;
		this.may06 = _6;
		this.may07 = _7;
		this.may08 = _8;
		this.may09 = _9;
		this.may10 = _10;
		this.may11 = _11;
		this.may12 = _12;
		this.may13 = _13;
		this.may14 = _14;
		this.may15 = _15;
		this.may16 = _16;
		this.may17 = _17;
		this.may18 = _18;
		this.may19 = _19;
		this.may20 = _20;
		this.may21 = _21;
		this.may22 = _22;
		this.may23 = _23;
		this.may24 = _24;
		this.may25 = _25;
		this.may26 = _26;
		this.may27 = _27;
		this.may28 = _28;
		this.may29 = _29;
		this.may30 = _30;
		this.may31 = _31;
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

	@Column(name = "_1_05")
	private int may01;

	@Column(name = "_2_05")
	private int may02;

	@Column(name = "_3_05")
	private int may03;

	@Column(name = "_4_05")
	private int may04;

	@Column(name = "_5_05")
	private int may05;

	@Column(name = "_6_05")
	private int may06;

	@Column(name = "_7_05")
	private int may07;

	@Column(name = "_8_05")
	private int may08;

	@Column(name = "_9_05")
	private int may09;

	@Column(name = "_10_05")
	private int may10;

	@Column(name = "_11_05")
	private int may11;

	@Column(name = "_12_05")
	private int may12;

	@Column(name = "_13_05")
	private int may13;

	@Column(name = "_14_05")
	private int may14;

	@Column(name = "_15_05")
	private int may15;

	@Column(name = "_16_05")
	private int may16;

	@Column(name = "_17_05")
	private int may17;

	@Column(name = "_18_05")
	private int may18;

	@Column(name = "_19_05")
	private int may19;

	@Column(name = "_20_05")
	private int may20;

	@Column(name = "_21_05")
	private int may21;

	@Column(name = "_22_05")
	private int may22;

	@Column(name = "_23_05")
	private int may23;

	@Column(name = "_24_05")
	private int may24;

	@Column(name = "_25_05")
	private int may25;

	@Column(name = "_26_05")
	private int may26;

	@Column(name = "_27_05")
	private int may27;

	@Column(name = "_28_05")
	private int may28;

	@Column(name = "_29_05")
	private int may29;

	@Column(name = "_30_05")
	private int may30;

	@Column(name = "_31_05")
	private int may31;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public int getMay01() {
		return may01;
	}

	public void setMay01(int may01) {
		this.may01 = may01;
	}

	public int getMay02() {
		return may02;
	}

	public void setMay02(int may02) {
		this.may02 = may02;
	}

	public int getMay03() {
		return may03;
	}

	public void setMay03(int may03) {
		this.may03 = may03;
	}

	public int getMay04() {
		return may04;
	}

	public void setMay04(int may04) {
		this.may04 = may04;
	}

	public int getMay05() {
		return may05;
	}

	public void setMay05(int may05) {
		this.may05 = may05;
	}

	public int getMay06() {
		return may06;
	}

	public void setMay06(int may06) {
		this.may06 = may06;
	}

	public int getMay07() {
		return may07;
	}

	public void setMay07(int may07) {
		this.may07 = may07;
	}

	public int getMay08() {
		return may08;
	}

	public void setMay08(int may08) {
		this.may08 = may08;
	}

	public int getMay09() {
		return may09;
	}

	public void setMay09(int may09) {
		this.may09 = may09;
	}

	public int getMay10() {
		return may10;
	}

	public void setMay10(int may10) {
		this.may10 = may10;
	}

	public int getMay11() {
		return may11;
	}

	public void setMay11(int may11) {
		this.may11 = may11;
	}

	public int getMay12() {
		return may12;
	}

	public void setMay12(int may12) {
		this.may12 = may12;
	}

	public int getMay13() {
		return may13;
	}

	public void setMay13(int may13) {
		this.may13 = may13;
	}

	public int getMay14() {
		return may14;
	}

	public void setMay14(int may14) {
		this.may14 = may14;
	}

	public int getMay15() {
		return may15;
	}

	public void setMay15(int may15) {
		this.may15 = may15;
	}

	public int getMay16() {
		return may16;
	}

	public void setMay16(int may16) {
		this.may16 = may16;
	}

	public int getMay17() {
		return may17;
	}

	public void setMay17(int may17) {
		this.may17 = may17;
	}

	public int getMay18() {
		return may18;
	}

	public void setMay18(int may18) {
		this.may18 = may18;
	}

	public int getMay19() {
		return may19;
	}

	public void setMay19(int may19) {
		this.may19 = may19;
	}

	public int getMay20() {
		return may20;
	}

	public void setMay20(int may20) {
		this.may20 = may20;
	}

	public int getMay21() {
		return may21;
	}

	public void setMay21(int may21) {
		this.may21 = may21;
	}

	public int getMay22() {
		return may22;
	}

	public void setMay22(int may22) {
		this.may22 = may22;
	}

	public int getMay23() {
		return may23;
	}

	public void setMay23(int may23) {
		this.may23 = may23;
	}

	public int getMay24() {
		return may24;
	}

	public void setMay24(int may24) {
		this.may24 = may24;
	}

	public int getMay25() {
		return may25;
	}

	public void setMay25(int may25) {
		this.may25 = may25;
	}

	public int getMay26() {
		return may26;
	}

	public void setMay26(int may26) {
		this.may26 = may26;
	}

	public int getMay27() {
		return may27;
	}

	public void setMay27(int may27) {
		this.may27 = may27;
	}

	public int getMay28() {
		return may28;
	}

	public void setMay28(int may28) {
		this.may28 = may28;
	}

	public int getMay29() {
		return may29;
	}

	public void setMay29(int may29) {
		this.may29 = may29;
	}

	public int getMay30() {
		return may30;
	}

	public void setMay30(int may30) {
		this.may30 = may30;
	}

	public int getMay31() {
		return may31;
	}

	public void setMay31(int may31) {
		this.may31 = may31;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		final MayDeaths other = (MayDeaths) obj;
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
		return "May{" + "provenceState=" + provenceState + ", countryRegion=" + countryRegion + ", may01=" + may01
				+ ", may02=" + may02 + ", may03=" + may03 + ", may04=" + may04 + ", may05=" + may05 + ", may06=" + may06
				+ ", may07=" + may07 + ", may08=" + may08 + ", may09=" + may09 + ", may10=" + may10 + ", may11=" + may11
				+ ", may12=" + may12 + ", may13=" + may13 + ", may14=" + may14 + ", may15=" + may15 + ", may16=" + may16
				+ ", may17=" + may17 + ", may18=" + may18 + ", may19=" + may19 + ", may20=" + may20 + ", may21=" + may21
				+ ", may22=" + may22 + ", may23=" + may23 + ", may24=" + may24 + ", may25=" + may25 + ", may26=" + may26
				+ ", may27=" + may27 + ", may28=" + may28 + ", may29=" + may29 + '}';
	}

}
