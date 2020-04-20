package com.domrade.entity.implementation;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
    @NamedQuery(name = "March.findAllEntries", query = "SELECT m FROM March m")
    ,
    @NamedQuery(name = "March.findByCountryRegionProvinceState", query = "SELECT m FROM March m WHERE m.countryRegion =:countryRegion AND m.provenceState =:provenceState")
    ,
    @NamedQuery(name = "March.findByCountryRegion", query = "SELECT m FROM March m WHERE m.countryRegion =:countryRegion")})
@Entity
@Table(name = "march")
public class March implements Serializable {

    public March() {
        // TODO Auto-generated constructor stub
    }

    public March(long id, String provenceState, String countryRegion, String latitude, String longitude, int _1, int _2, int _3, int _4, int _5, 
            int _6, int _7, int _8, int _9, int _10, int _11, int _12, int _13, int _14, int _15, int _16, int _17, int _18, int _19, int _20, 
            int _21, int _22, int _23, int _24, int _25, int _26, int _27, int _28, int _29, int _30, int _31) {
        
        this.id = id;
        this.provenceState = provenceState;
        this.countryRegion = countryRegion;
        this.latitude = latitude;
        this.longitude = longitude;
        this.mar01 = _1;
        this.mar02 = _2;
        this.mar03 = _3;
        this.mar04 = _4;
        this.mar05 = _5;
        this.mar06 = _6;
        this.mar07 = _7;
        this.mar08 = _8;
        this.mar09 = _9;
        this.mar10 = _10;
        this.mar11 = _11;
        this.mar12 = _12;
        this.mar13 = _13;
        this.mar14 = _14;
        this.mar15 = _15;
        this.mar16 = _16;
        this.mar17 = _17;
        this.mar18 = _18;
        this.mar19 = _19;
        this.mar20 = _20;
        this.mar21 = _21;
        this.mar22 = _22;
        this.mar23 = _23;
        this.mar24 = _24;
        this.mar25 = _25;
        this.mar26 = _26;
        this.mar27 = _27;
        this.mar28 = _28;
        this.mar29 = _29;
        this.mar30 = _30;
        this.mar31 = _31;
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

    @Column(name = "_1_03")
    private int mar01;

    @Column(name = "_2_03")
    private int mar02;

    @Column(name = "_3_03")
    private int mar03;

    @Column(name = "_4_03")
    private int mar04;

    @Column(name = "_5_03")
    private int mar05;

    @Column(name = "_6_03")
    private int mar06;

    @Column(name = "_7_03")
    private int mar07;

    @Column(name = "_8_03")
    private int mar08;

    @Column(name = "_9_03")
    private int mar09;

    @Column(name = "_10_03")
    private int mar10;

    @Column(name = "_11_03")
    private int mar11;

    @Column(name = "_12_03")
    private int mar12;

    @Column(name = "_13_03")
    private int mar13;

    @Column(name = "_14_03")
    private int mar14;

    @Column(name = "_15_03")
    private int mar15;

    @Column(name = "_16_03")
    private int mar16;

    @Column(name = "_17_03")
    private int mar17;

    @Column(name = "_18_03")
    private int mar18;

    @Column(name = "_19_03")
    private int mar19;

    @Column(name = "_20_03")
    private int mar20;

    @Column(name = "_21_03")
    private int mar21;

    @Column(name = "_22_03")
    private int mar22;

    @Column(name = "_23_03")
    private int mar23;

    @Column(name = "_24_03")
    private int mar24;

    @Column(name = "_25_03")
    private int mar25;

    @Column(name = "_26_03")
    private int mar26;

    @Column(name = "_27_03")
    private int mar27;

    @Column(name = "_28_03")
    private int mar28;

    @Column(name = "_29_03")
    private int mar29;
    
    @Column(name = "_30_03")
    private int mar30;
    
    @Column(name = "_31_03")
    private int mar31;

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

    public int getMar01() {
        return mar01;
    }

    public void setMar01(int mar01) {
        this.mar01 = mar01;
    }

    public int getMar02() {
        return mar02;
    }

    public void setMar02(int mar02) {
        this.mar02 = mar02;
    }

    public int getMar03() {
        return mar03;
    }

    public void setMar03(int mar03) {
        this.mar03 = mar03;
    }

    public int getMar04() {
        return mar04;
    }

    public void setMar04(int mar04) {
        this.mar04 = mar04;
    }

    public int getMar05() {
        return mar05;
    }

    public void setMar05(int mar05) {
        this.mar05 = mar05;
    }

    public int getMar06() {
        return mar06;
    }

    public void setMar06(int mar06) {
        this.mar06 = mar06;
    }

    public int getMar07() {
        return mar07;
    }

    public void setMar07(int mar07) {
        this.mar07 = mar07;
    }

    public int getMar08() {
        return mar08;
    }

    public void setMar08(int mar08) {
        this.mar08 = mar08;
    }

    public int getMar09() {
        return mar09;
    }

    public void setMar09(int mar09) {
        this.mar09 = mar09;
    }

    public int getMar10() {
        return mar10;
    }

    public void setMar10(int mar10) {
        this.mar10 = mar10;
    }

    public int getMar11() {
        return mar11;
    }

    public void setMar11(int mar11) {
        this.mar11 = mar11;
    }

    public int getMar12() {
        return mar12;
    }

    public void setMar12(int mar12) {
        this.mar12 = mar12;
    }

    public int getMar13() {
        return mar13;
    }

    public void setMar13(int mar13) {
        this.mar13 = mar13;
    }

    public int getMar14() {
        return mar14;
    }

    public void setMar14(int mar14) {
        this.mar14 = mar14;
    }

    public int getMar15() {
        return mar15;
    }

    public void setMar15(int mar15) {
        this.mar15 = mar15;
    }

    public int getMar16() {
        return mar16;
    }

    public void setMar16(int mar16) {
        this.mar16 = mar16;
    }

    public int getMar17() {
        return mar17;
    }

    public void setMar17(int mar17) {
        this.mar17 = mar17;
    }

    public int getMar18() {
        return mar18;
    }

    public void setMar18(int mar18) {
        this.mar18 = mar18;
    }

    public int getMar19() {
        return mar19;
    }

    public void setMar19(int mar19) {
        this.mar19 = mar19;
    }

    public int getMar20() {
        return mar20;
    }

    public void setMar20(int mar20) {
        this.mar20 = mar20;
    }

    public int getMar21() {
        return mar21;
    }

    public void setMar21(int mar21) {
        this.mar21 = mar21;
    }

    public int getMar22() {
        return mar22;
    }

    public void setMar22(int mar22) {
        this.mar22 = mar22;
    }

    public int getMar23() {
        return mar23;
    }

    public void setMar23(int mar23) {
        this.mar23 = mar23;
    }

    public int getMar24() {
        return mar24;
    }

    public void setMar24(int mar24) {
        this.mar24 = mar24;
    }

    public int getMar25() {
        return mar25;
    }

    public void setMar25(int mar25) {
        this.mar25 = mar25;
    }

    public int getMar26() {
        return mar26;
    }

    public void setMar26(int mar26) {
        this.mar26 = mar26;
    }

    public int getMar27() {
        return mar27;
    }

    public void setMar27(int mar27) {
        this.mar27 = mar27;
    }

    public int getMar28() {
        return mar28;
    }

    public void setMar28(int mar28) {
        this.mar28 = mar28;
    }

    public int getMar29() {
        return mar29;
    }

    public void setMar29(int mar29) {
        this.mar29 = mar29;
    }

    public int getMar30() {
        return mar30;
    }

    public void setMar30(int mar30) {
        this.mar30 = mar30;
    }

    public int getMar31() {
        return mar31;
    }

    public void setMar31(int mar31) {
        this.mar31 = mar31;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final March other = (March) obj;
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
        return "March{" + "provenceState=" + provenceState + ", countryRegion=" + countryRegion + ", mar01=" 
                + mar01 + ", mar02=" + mar02 + ", mar03=" + mar03 + ", mar04=" + mar04 + ", mar05=" + mar05 
                + ", mar06=" + mar06 + ", mar07=" + mar07 + ", mar08=" + mar08 + ", mar09=" + mar09 + ", mar10=" 
                + mar10 + ", mar11=" + mar11 + ", mar12=" + mar12 + ", mar13=" + mar13 + ", mar14=" + mar14 + ", mar15=" 
                + mar15 + ", mar16=" + mar16 + ", mar17=" + mar17 + ", mar18=" + mar18 + ", mar19=" + mar19 + ", mar20=" 
                + mar20 + ", mar21=" + mar21 + ", mar22=" + mar22 + ", mar23=" + mar23 + ", mar24=" + mar24 + ", mar25=" 
                + mar25 + ", mar26=" + mar26 + ", mar27=" + mar27 + ", mar28=" + mar28 + ", mar29=" + mar29 + '}';
    }

}
