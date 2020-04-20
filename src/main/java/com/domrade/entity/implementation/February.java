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
@NamedQueries({
    @NamedQuery(name = "February.findAllEntries", query = "SELECT f FROM February f")
    ,
    @NamedQuery(name = "February.findAllCountryRegion", query = "SELECT DISTINCT f.countryRegion FROM February f ORDER BY f.countryRegion ASC")
    ,
    @NamedQuery(name = "February.findAllCountryRegionProvinceState", query = "SELECT f.countryRegion, f.provenceState FROM February f ORDER BY f.countryRegion ASC")
    ,
    @NamedQuery(name = "February.findByCountryRegionProvinceState", query = "SELECT f FROM February f WHERE f.countryRegion =:countryRegion AND f.provenceState =:provenceState")
    ,
    @NamedQuery(name = "February.findProvincetateByCountry", query = "SELECT f.provenceState FROM February f WHERE f.countryRegion =:countryRegion ORDER BY f.provenceState ASC")
    ,
    @NamedQuery(name = "February.findByCountryRegion", query = "SELECT f FROM February f WHERE f.countryRegion =:countryRegion")
,
    @NamedQuery(name = "February.findProvinceStateByCountryRegion", query = "SELECT f.provenceState FROM February f WHERE f.countryRegion =:countryRegion")})
@Entity
@Table(name = "february")
public class February implements Serializable {
    
    public February() {
        // TODO Auto-generated constructor stub
    }

    public February(long id, String provenceState, String countryRegion, String latitude, String longitude, int _1, int _2, int _3, int _4, int _5, 
            int _6, int _7, int _8, int _9, int _10, int _11, int _12, int _13, int _14, int _15, int _16, int _17, int _18, int _19, int _20, 
            int _21, int _22, int _23, int _24, int _25, int _26, int _27, int _28, int _29, int _30) {
        
        this.id = id;
        this.provenceState = provenceState;
        this.countryRegion = countryRegion;
        this.latitude = latitude;
        this.longitude = longitude;
        this.feb01 = _1;
        this.feb02 = _2;
        this.feb03 = _3;
        this.feb04 = _4;
        this.feb05 = _5;
        this.feb06 = _6;
        this.feb07 = _7;
        this.feb08 = _8;
        this.feb09 = _9;
        this.feb10 = _10;
        this.feb11 = _11;
        this.feb12 = _12;
        this.feb13 = _13;
        this.feb14 = _14;
        this.feb15 = _15;
        this.feb16 = _16;
        this.feb17 = _17;
        this.feb18 = _18;
        this.feb19 = _19;
        this.feb20 = _20;
        this.feb21 = _21;
        this.feb22 = _22;
        this.feb23 = _23;
        this.feb24 = _24;
        this.feb25 = _25;
        this.feb26 = _26;
        this.feb27 = _27;
        this.feb28 = _28;
        this.feb29 = _29;
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

    @Column(name = "_1_02")
    private int feb01;

    @Column(name = "_2_02")
    private int feb02;

    @Column(name = "_3_02")
    private int feb03;

    @Column(name = "_4_02")
    private int feb04;

    @Column(name = "_5_02")
    private int feb05;

    @Column(name = "_6_02")
    private int feb06;

    @Column(name = "_7_02")
    private int feb07;

    @Column(name = "_8_02")
    private int feb08;

    @Column(name = "_9_02")
    private int feb09;

    @Column(name = "_10_02")
    private int feb10;

    @Column(name = "_11_02")
    private int feb11;

    @Column(name = "_12_02")
    private int feb12;

    @Column(name = "_13_02")
    private int feb13;

    @Column(name = "_14_02")
    private int feb14;

    @Column(name = "_15_02")
    private int feb15;

    @Column(name = "_16_02")
    private int feb16;

    @Column(name = "_17_02")
    private int feb17;

    @Column(name = "_18_02")
    private int feb18;

    @Column(name = "_19_02")
    private int feb19;

    @Column(name = "_20_02")
    private int feb20;

    @Column(name = "_21_02")
    private int feb21;

    @Column(name = "_22_02")
    private int feb22;

    @Column(name = "_23_02")
    private int feb23;

    @Column(name = "_24_02")
    private int feb24;

    @Column(name = "_25_02")
    private int feb25;

    @Column(name = "_26_02")
    private int feb26;

    @Column(name = "_27_02")
    private int feb27;

    @Column(name = "_28_02")
    private int feb28;

    @Column(name = "_29_02")
    private int feb29;

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

    public int getFeb01() {
        return feb01;
    }

    public void setFeb01(int feb01) {
        this.feb01 = feb01;
    }

    public int getFeb02() {
        return feb02;
    }

    public void setFeb02(int feb02) {
        this.feb02 = feb02;
    }

    public int getFeb03() {
        return feb03;
    }

    public void setFeb03(int feb03) {
        this.feb03 = feb03;
    }

    public int getFeb04() {
        return feb04;
    }

    public void setFeb04(int feb04) {
        this.feb04 = feb04;
    }

    public int getFeb05() {
        return feb05;
    }

    public void setFeb05(int feb05) {
        this.feb05 = feb05;
    }

    public int getFeb06() {
        return feb06;
    }

    public void setFeb06(int feb06) {
        this.feb06 = feb06;
    }

    public int getFeb07() {
        return feb07;
    }

    public void setFeb07(int feb07) {
        this.feb07 = feb07;
    }

    public int getFeb08() {
        return feb08;
    }

    public void setFeb08(int feb08) {
        this.feb08 = feb08;
    }

    public int getFeb09() {
        return feb09;
    }

    public void setFeb09(int feb09) {
        this.feb09 = feb09;
    }

    public int getFeb10() {
        return feb10;
    }

    public void setFeb10(int feb10) {
        this.feb10 = feb10;
    }

    public int getFeb11() {
        return feb11;
    }

    public void setFeb11(int feb11) {
        this.feb11 = feb11;
    }

    public int getFeb12() {
        return feb12;
    }

    public void setFeb12(int feb12) {
        this.feb12 = feb12;
    }

    public int getFeb13() {
        return feb13;
    }

    public void setFeb13(int feb13) {
        this.feb13 = feb13;
    }

    public int getFeb14() {
        return feb14;
    }

    public void setFeb14(int feb14) {
        this.feb14 = feb14;
    }

    public int getFeb15() {
        return feb15;
    }

    public void setFeb15(int feb15) {
        this.feb15 = feb15;
    }

    public int getFeb16() {
        return feb16;
    }

    public void setFeb16(int feb16) {
        this.feb16 = feb16;
    }

    public int getFeb17() {
        return feb17;
    }

    public void setFeb17(int feb17) {
        this.feb17 = feb17;
    }

    public int getFeb18() {
        return feb18;
    }

    public void setFeb18(int feb18) {
        this.feb18 = feb18;
    }

    public int getFeb19() {
        return feb19;
    }

    public void setFeb19(int feb19) {
        this.feb19 = feb19;
    }

    public int getFeb20() {
        return feb20;
    }

    public void setFeb20(int feb20) {
        this.feb20 = feb20;
    }

    public int getFeb21() {
        return feb21;
    }

    public void setFeb21(int feb21) {
        this.feb21 = feb21;
    }

    public int getFeb22() {
        return feb22;
    }

    public void setFeb22(int feb22) {
        this.feb22 = feb22;
    }

    public int getFeb23() {
        return feb23;
    }

    public void setFeb23(int feb23) {
        this.feb23 = feb23;
    }

    public int getFeb24() {
        return feb24;
    }

    public void setFeb24(int feb24) {
        this.feb24 = feb24;
    }

    public int getFeb25() {
        return feb25;
    }

    public void setFeb25(int feb25) {
        this.feb25 = feb25;
    }

    public int getFeb26() {
        return feb26;
    }

    public void setFeb26(int feb26) {
        this.feb26 = feb26;
    }

    public int getFeb27() {
        return feb27;
    }

    public void setFeb27(int feb27) {
        this.feb27 = feb27;
    }

    public int getFeb28() {
        return feb28;
    }

    public void setFeb28(int feb28) {
        this.feb28 = feb28;
    }

    public int getFeb29() {
        return feb29;
    }

    public void setFeb29(int feb29) {
        this.feb29 = feb29;
    }

    
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final February other = (February) obj;
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
        return "February{" + "provenceState=" + provenceState + ", countryRegion=" + countryRegion + ", Feb01=" 
                + feb01 + ", feb02=" + feb02 + ", feb03=" + feb03 + ", feb04=" + feb04 + ", feb05=" + feb05 
                + ", feb06=" + feb06 + ", feb07=" + feb07 + ", feb08=" + feb08 + ", feb09=" + feb09 + ", feb10=" 
                + feb10 + ", feb11=" + feb11 + ", feb12=" + feb12 + ", feb13=" + feb13 + ", feb14=" + feb14 + ", feb15=" 
                + feb15 + ", feb16=" + feb16 + ", feb17=" + feb17 + ", feb18=" + feb18 + ", feb19=" + feb19 + ", feb20=" 
                + feb20 + ", feb21=" + feb21 + ", feb22=" + feb22 + ", feb23=" + feb23 + ", feb24=" + feb24 + ", feb25=" 
                + feb25 + ", feb26=" + feb26 + ", feb27=" + feb27 + ", feb28=" + feb28 + ", feb29=" + feb29 + '}';
    }

}
