package com.domrade.entity.implementation;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({ @NamedQuery(name = "USJuneDeaths.findAllEntries", query = "SELECT a FROM USJuneDeaths a"),
		@NamedQuery(name = "USJuneDeaths.findByProvenceState", query = "SELECT a FROM USJuneDeaths a WHERE a.provenceState =:provenceState"),
		@NamedQuery(name = "USJuneDeaths.findByCountryRegionProvinceState", query = "SELECT a FROM USJuneDeaths a WHERE a.countryRegion =:countryRegion AND a.provenceState =:provenceState"),
		@NamedQuery(name = "USJuneDeaths.findByCountryRegion", query = "SELECT a FROM USJuneDeaths a WHERE a.countryRegion =:countryRegion") })
@Entity
@Table(name = "us_june_deaths")
public class USJuneDeaths implements Serializable {

	public USJuneDeaths() {
		// TODO Auto-generated constructor stub
	}

	public USJuneDeaths(String provenceState, String countryRegion, String latitude, String longitude, int population,
			String admin2, int _1, int _2, int _3, int _4, int _5, int _6, int _7, int _8, int _9, int _10, int _11,
			int _12, int _13, int _14, int _15, int _16, int _17, int _18, int _19, int _20, int _21, int _22, int _23,
			int _24, int _25, int _26, int _27, int _28, int _29, int _30) {

		this.provenceState = provenceState;
		this.countryRegion = countryRegion;
		this.latitude = latitude;
		this.longitude = longitude;
		this.admin2 = admin2;
		this.population = population;
		this.jun01 = _1;
		this.jun02 = _2;
		this.jun03 = _3;
		this.jun04 = _4;
		this.jun05 = _5;
		this.jun06 = _6;
		this.jun07 = _7;
		this.jun08 = _8;
		this.jun09 = _9;
		this.jun10 = _10;
		this.jun11 = _11;
		this.jun12 = _12;
		this.jun13 = _13;
		this.jun14 = _14;
		this.jun15 = _15;
		this.jun16 = _16;
		this.jun17 = _17;
		this.jun18 = _18;
		this.jun19 = _19;
		this.jun20 = _20;
		this.jun21 = _21;
		this.jun22 = _22;
		this.jun23 = _23;
		this.jun24 = _24;
		this.jun25 = _25;
		this.jun26 = _26;
		this.jun27 = _27;
		this.jun28 = _28;
		this.jun29 = _29;
		this.jun30 = _30;
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

	@Column(name = "_1_06")
	private int jun01;

	@Column(name = "_2_06")
	private int jun02;

	@Column(name = "_3_06")
	private int jun03;

	@Column(name = "_4_06")
	private int jun04;

	@Column(name = "_5_06")
	private int jun05;

	@Column(name = "_6_06")
	private int jun06;

	@Column(name = "_7_06")
	private int jun07;

	@Column(name = "_8_06")
	private int jun08;

	@Column(name = "_9_06")
	private int jun09;

	@Column(name = "_10_06")
	private int jun10;

	@Column(name = "_11_06")
	private int jun11;

	@Column(name = "_12_06")
	private int jun12;

	@Column(name = "_13_06")
	private int jun13;

	@Column(name = "_14_06")
	private int jun14;

	@Column(name = "_15_06")
	private int jun15;

	@Column(name = "_16_06")
	private int jun16;

	@Column(name = "_17_06")
	private int jun17;

	@Column(name = "_18_06")
	private int jun18;

	@Column(name = "_19_06")
	private int jun19;

	@Column(name = "_20_06")
	private int jun20;

	@Column(name = "_21_06")
	private int jun21;

	@Column(name = "_22_06")
	private int jun22;

	@Column(name = "_23_06")
	private int jun23;

	@Column(name = "_24_06")
	private int jun24;

	@Column(name = "_25_06")
	private int jun25;

	@Column(name = "_26_06")
	private int jun26;

	@Column(name = "_27_06")
	private int jun27;

	@Column(name = "_28_06")
	private int jun28;

	@Column(name = "_29_06")
	private int jun29;

	@Column(name = "_30_06")
	private int jun30;

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

	public int getJun01() {
		return jun01;
	}

	public void setJun01(int jun01) {
		this.jun01 = jun01;
	}

	public int getJun02() {
		return jun02;
	}

	public void setJun02(int jun02) {
		this.jun02 = jun02;
	}

	public int getJun03() {
		return jun03;
	}

	public void setJun03(int jun03) {
		this.jun03 = jun03;
	}

	public int getJun04() {
		return jun04;
	}

	public void setJun04(int jun04) {
		this.jun04 = jun04;
	}

	public int getJun05() {
		return jun05;
	}

	public void setJun05(int jun05) {
		this.jun05 = jun05;
	}

	public int getJun06() {
		return jun06;
	}

	public void setJun06(int jun06) {
		this.jun06 = jun06;
	}

	public int getJun07() {
		return jun07;
	}

	public void setJun07(int jun07) {
		this.jun07 = jun07;
	}

	public int getJun08() {
		return jun08;
	}

	public void setJun08(int jun08) {
		this.jun08 = jun08;
	}

	public int getJun09() {
		return jun09;
	}

	public void setJun09(int jun09) {
		this.jun09 = jun09;
	}

	public int getJun10() {
		return jun10;
	}

	public void setJun10(int jun10) {
		this.jun10 = jun10;
	}

	public int getJun11() {
		return jun11;
	}

	public void setJun11(int jun11) {
		this.jun11 = jun11;
	}

	public int getJun12() {
		return jun12;
	}

	public void setJun12(int jun12) {
		this.jun12 = jun12;
	}

	public int getJun13() {
		return jun13;
	}

	public void setJun13(int jun13) {
		this.jun13 = jun13;
	}

	public int getJun14() {
		return jun14;
	}

	public void setJun14(int jun14) {
		this.jun14 = jun14;
	}

	public int getJun15() {
		return jun15;
	}

	public void setJun15(int jun15) {
		this.jun15 = jun15;
	}

	public int getJun16() {
		return jun16;
	}

	public void setJun16(int jun16) {
		this.jun16 = jun16;
	}

	public int getJun17() {
		return jun17;
	}

	public void setJun17(int jun17) {
		this.jun17 = jun17;
	}

	public int getJun18() {
		return jun18;
	}

	public void setJun18(int jun18) {
		this.jun18 = jun18;
	}

	public int getJun19() {
		return jun19;
	}

	public void setJun19(int jun19) {
		this.jun19 = jun19;
	}

	public int getJun20() {
		return jun20;
	}

	public void setJun20(int jun20) {
		this.jun20 = jun20;
	}

	public int getJun21() {
		return jun21;
	}

	public void setJun21(int jun21) {
		this.jun21 = jun21;
	}

	public int getJun22() {
		return jun22;
	}

	public void setJun22(int jun22) {
		this.jun22 = jun22;
	}

	public int getJun23() {
		return jun23;
	}

	public void setJun23(int jun23) {
		this.jun23 = jun23;
	}

	public int getJun24() {
		return jun24;
	}

	public void setJun24(int jun24) {
		this.jun24 = jun24;
	}

	public int getJun25() {
		return jun25;
	}

	public void setJun25(int jun25) {
		this.jun25 = jun25;
	}

	public int getJun26() {
		return jun26;
	}

	public void setJun26(int jun26) {
		this.jun26 = jun26;
	}

	public int getJun27() {
		return jun27;
	}

	public void setJun27(int jun27) {
		this.jun27 = jun27;
	}

	public int getJun28() {
		return jun28;
	}

	public void setJun28(int jun28) {
		this.jun28 = jun28;
	}

	public int getJun29() {
		return jun29;
	}

	public void setJun29(int jun29) {
		this.jun29 = jun29;
	}

	public int getJun30() {
		return jun30;
	}

	public void setJun30(int jun30) {
		this.jun30 = jun30;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		final USJuneDeaths other = (USJuneDeaths) obj;
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
		return "USJuneDeaths{" + "provenceState=" + provenceState + ", countryRegion=" + countryRegion + ", Jun01="
				+ jun01 + ", jun02=" + jun02 + ", jun03=" + jun03 + ", jun04=" + jun04 + ", jun05=" + jun05 + ", jun06="
				+ jun06 + ", jun07=" + jun07 + ", jun08=" + jun08 + ", jun09=" + jun09 + ", jun10=" + jun10 + ", jun11="
				+ jun11 + ", jun12=" + jun12 + ", jun13=" + jun13 + ", jun14=" + jun14 + ", jun15=" + jun15 + ", jun16="
				+ jun16 + ", jun17=" + jun17 + ", jun18=" + jun18 + ", jun19=" + jun19 + ", jun20=" + jun20 + ", jun21="
				+ jun21 + ", jun22=" + jun22 + ", jun23=" + jun23 + ", jun24=" + jun24 + ", jun25=" + jun25 + ", jun26="
				+ jun26 + ", jun27=" + jun27 + ", jun28=" + jun28 + ", jun29=" + jun29 + '}';
	}

}
