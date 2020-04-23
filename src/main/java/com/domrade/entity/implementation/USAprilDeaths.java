package com.domrade.entity.implementation;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({ @NamedQuery(name = "USAprilDeaths.findAllEntries", query = "SELECT a FROM USAprilDeaths a"),
		@NamedQuery(name = "USAprilDeaths.findByProvenceState", query = "SELECT a FROM USAprilDeaths a WHERE a.provenceState =:provenceState"),
		@NamedQuery(name = "USAprilDeaths.findByCountryRegionProvinceState", query = "SELECT a FROM USAprilDeaths a WHERE a.countryRegion =:countryRegion AND a.provenceState =:provenceState"),
		@NamedQuery(name = "USAprilDeaths.findByCountryRegion", query = "SELECT a FROM USAprilDeaths a WHERE a.countryRegion =:countryRegion") })
@Entity
@Table(name = "us_april_deaths")
public class USAprilDeaths implements Serializable {

	public USAprilDeaths() {
		// TODO Auto-generated constructor stub
	}

	public USAprilDeaths(String provenceState, String countryRegion, String latitude, String longitude, int population,
			String admin2, int _1, int _2, int _3, int _4, int _5, int _6, int _7, int _8, int _9, int _10, int _11,
			int _12, int _13, int _14, int _15, int _16, int _17, int _18, int _19, int _20, int _21, int _22, int _23,
			int _24, int _25, int _26, int _27, int _28, int _29, int _30) {

		this.provenceState = provenceState;
		this.countryRegion = countryRegion;
		this.latitude = latitude;
		this.longitude = longitude;
		this.admin2 = admin2;
		this.population = population;
		this.apr01 = _1;
		this.apr02 = _2;
		this.apr03 = _3;
		this.apr04 = _4;
		this.apr05 = _5;
		this.apr06 = _6;
		this.apr07 = _7;
		this.apr08 = _8;
		this.apr09 = _9;
		this.apr10 = _10;
		this.apr11 = _11;
		this.apr12 = _12;
		this.apr13 = _13;
		this.apr14 = _14;
		this.apr15 = _15;
		this.apr16 = _16;
		this.apr17 = _17;
		this.apr18 = _18;
		this.apr19 = _19;
		this.apr20 = _20;
		this.apr21 = _21;
		this.apr22 = _22;
		this.apr23 = _23;
		this.apr24 = _24;
		this.apr25 = _25;
		this.apr26 = _26;
		this.apr27 = _27;
		this.apr28 = _28;
		this.apr29 = _29;
		this.apr30 = _30;
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

	@Column(name = "_1_04")
	private int apr01;

	@Column(name = "_2_04")
	private int apr02;

	@Column(name = "_3_04")
	private int apr03;

	@Column(name = "_4_04")
	private int apr04;

	@Column(name = "_5_04")
	private int apr05;

	@Column(name = "_6_04")
	private int apr06;

	@Column(name = "_7_04")
	private int apr07;

	@Column(name = "_8_04")
	private int apr08;

	@Column(name = "_9_04")
	private int apr09;

	@Column(name = "_10_04")
	private int apr10;

	@Column(name = "_11_04")
	private int apr11;

	@Column(name = "_12_04")
	private int apr12;

	@Column(name = "_13_04")
	private int apr13;

	@Column(name = "_14_04")
	private int apr14;

	@Column(name = "_15_04")
	private int apr15;

	@Column(name = "_16_04")
	private int apr16;

	@Column(name = "_17_04")
	private int apr17;

	@Column(name = "_18_04")
	private int apr18;

	@Column(name = "_19_04")
	private int apr19;

	@Column(name = "_20_04")
	private int apr20;

	@Column(name = "_21_04")
	private int apr21;

	@Column(name = "_22_04")
	private int apr22;

	@Column(name = "_23_04")
	private int apr23;

	@Column(name = "_24_04")
	private int apr24;

	@Column(name = "_25_04")
	private int apr25;

	@Column(name = "_26_04")
	private int apr26;

	@Column(name = "_27_04")
	private int apr27;

	@Column(name = "_28_04")
	private int apr28;

	@Column(name = "_29_04")
	private int apr29;

	@Column(name = "_30_04")
	private int apr30;

	@Column(name = "admin2")
	private String admin2;

	@Column(name = "population")
	private int population;

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public String getAdmin2() {
		return admin2;
	}

	public void setAdmin2(String admin2) {
		this.admin2 = admin2;
	}

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

	public int getApr01() {
		return apr01;
	}

	public void setApr01(int apr01) {
		this.apr01 = apr01;
	}

	public int getApr02() {
		return apr02;
	}

	public void setApr02(int apr02) {
		this.apr02 = apr02;
	}

	public int getApr03() {
		return apr03;
	}

	public void setApr03(int apr03) {
		this.apr03 = apr03;
	}

	public int getApr04() {
		return apr04;
	}

	public void setApr04(int apr04) {
		this.apr04 = apr04;
	}

	public int getApr05() {
		return apr05;
	}

	public void setApr05(int apr05) {
		this.apr05 = apr05;
	}

	public int getApr06() {
		return apr06;
	}

	public void setApr06(int apr06) {
		this.apr06 = apr06;
	}

	public int getApr07() {
		return apr07;
	}

	public void setApr07(int apr07) {
		this.apr07 = apr07;
	}

	public int getApr08() {
		return apr08;
	}

	public void setApr08(int apr08) {
		this.apr08 = apr08;
	}

	public int getApr09() {
		return apr09;
	}

	public void setApr09(int apr09) {
		this.apr09 = apr09;
	}

	public int getApr10() {
		return apr10;
	}

	public void setApr10(int apr10) {
		this.apr10 = apr10;
	}

	public int getApr11() {
		return apr11;
	}

	public void setApr11(int apr11) {
		this.apr11 = apr11;
	}

	public int getApr12() {
		return apr12;
	}

	public void setApr12(int apr12) {
		this.apr12 = apr12;
	}

	public int getApr13() {
		return apr13;
	}

	public void setApr13(int apr13) {
		this.apr13 = apr13;
	}

	public int getApr14() {
		return apr14;
	}

	public void setApr14(int apr14) {
		this.apr14 = apr14;
	}

	public int getApr15() {
		return apr15;
	}

	public void setApr15(int apr15) {
		this.apr15 = apr15;
	}

	public int getApr16() {
		return apr16;
	}

	public void setApr16(int apr16) {
		this.apr16 = apr16;
	}

	public int getApr17() {
		return apr17;
	}

	public void setApr17(int apr17) {
		this.apr17 = apr17;
	}

	public int getApr18() {
		return apr18;
	}

	public void setApr18(int apr18) {
		this.apr18 = apr18;
	}

	public int getApr19() {
		return apr19;
	}

	public void setApr19(int apr19) {
		this.apr19 = apr19;
	}

	public int getApr20() {
		return apr20;
	}

	public void setApr20(int apr20) {
		this.apr20 = apr20;
	}

	public int getApr21() {
		return apr21;
	}

	public void setApr21(int apr21) {
		this.apr21 = apr21;
	}

	public int getApr22() {
		return apr22;
	}

	public void setApr22(int apr22) {
		this.apr22 = apr22;
	}

	public int getApr23() {
		return apr23;
	}

	public void setApr23(int apr23) {
		this.apr23 = apr23;
	}

	public int getApr24() {
		return apr24;
	}

	public void setApr24(int apr24) {
		this.apr24 = apr24;
	}

	public int getApr25() {
		return apr25;
	}

	public void setApr25(int apr25) {
		this.apr25 = apr25;
	}

	public int getApr26() {
		return apr26;
	}

	public void setApr26(int apr26) {
		this.apr26 = apr26;
	}

	public int getApr27() {
		return apr27;
	}

	public void setApr27(int apr27) {
		this.apr27 = apr27;
	}

	public int getApr28() {
		return apr28;
	}

	public void setApr28(int apr28) {
		this.apr28 = apr28;
	}

	public int getApr29() {
		return apr29;
	}

	public void setApr29(int apr29) {
		this.apr29 = apr29;
	}

	public int getApr30() {
		return apr30;
	}

	public void setApr30(int apr30) {
		this.apr30 = apr30;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		final USAprilDeaths other = (USAprilDeaths) obj;
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
		return "USAprilDeaths{" + "provenceState=" + provenceState + ", countryRegion=" + countryRegion + ", Apr01="
				+ apr01 + ", apr02=" + apr02 + ", apr03=" + apr03 + ", apr04=" + apr04 + ", apr05=" + apr05 + ", apr06="
				+ apr06 + ", apr07=" + apr07 + ", apr08=" + apr08 + ", apr09=" + apr09 + ", apr10=" + apr10 + ", apr11="
				+ apr11 + ", apr12=" + apr12 + ", apr13=" + apr13 + ", apr14=" + apr14 + ", apr15=" + apr15 + ", apr16="
				+ apr16 + ", apr17=" + apr17 + ", apr18=" + apr18 + ", apr19=" + apr19 + ", apr20=" + apr20 + ", apr21="
				+ apr21 + ", apr22=" + apr22 + ", apr23=" + apr23 + ", apr24=" + apr24 + ", apr25=" + apr25 + ", apr26="
				+ apr26 + ", apr27=" + apr27 + ", apr28=" + apr28 + ", apr29=" + apr29 + '}';
	}

}
