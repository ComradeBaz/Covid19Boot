/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.entity.implementation;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 *
 * @author David
 */
public class June {
    
    public June() {
        // TODO Auto-generated constructor stub
    }

    public June(long id, String provenceState, String countryRegion, String latitude, String longitude, int _1, int _2, int _3, int _4, int _5, 
            int _6, int _7, int _8, int _9, int _10, int _11, int _12, int _13, int _14, int _15, int _16, int _17, int _18, int _19, int _20, 
            int _21, int _22, int _23, int _24, int _25, int _26, int _27, int _28, int _29, int _30) {
        
        this.id = id;
        this.provenceState = provenceState;
        this.countryRegion = countryRegion;
        this.latitude = latitude;
        this.longitude = longitude;
        this._1 = _1;
        this._2 = _2;
        this._3 = _3;
        this._4 = _4;
        this._5 = _5;
        this._6 = _6;
        this._7 = _7;
        this._8 = _8;
        this._9 = _9;
        this._10 = _10;
        this._11 = _11;
        this._12 = _12;
        this._13 = _13;
        this._14 = _14;
        this._15 = _15;
        this._16 = _16;
        this._17 = _17;
        this._18 = _18;
        this._19 = _19;
        this._20 = _20;
        this._21 = _21;
        this._22 = _22;
        this._23 = _23;
        this._24 = _24;
        this._25 = _25;
        this._26 = _26;
        this._27 = _27;
        this._28 = _28;
        this._29 = _29;
        this._30 = _30;
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

    @Column(name = "_1")
    private int _1;

    @Column(name = "_2")
    private int _2;

    @Column(name = "_3")
    private int _3;

    @Column(name = "_4")
    private int _4;

    @Column(name = "_5")
    private int _5;

    @Column(name = "_6")
    private int _6;

    @Column(name = "_7")
    private int _7;

    @Column(name = "_8")
    private int _8;

    @Column(name = "_9")
    private int _9;

    @Column(name = "_10")
    private int _10;

    @Column(name = "_11")
    private int _11;

    @Column(name = "_12")
    private int _12;

    @Column(name = "_13")
    private int _13;

    @Column(name = "_14")
    private int _14;

    @Column(name = "_15")
    private int _15;

    @Column(name = "_16")
    private int _16;

    @Column(name = "_17")
    private int _17;

    @Column(name = "_18")
    private int _18;

    @Column(name = "_19")
    private int _19;

    @Column(name = "_20")
    private int _20;

    @Column(name = "_21")
    private int _21;

    @Column(name = "_22")
    private int _22;

    @Column(name = "_23")
    private int _23;

    @Column(name = "_24")
    private int _24;

    @Column(name = "_25")
    private int _25;

    @Column(name = "_26")
    private int _26;

    @Column(name = "_27")
    private int _27;

    @Column(name = "_28")
    private int _28;

    @Column(name = "_29")
    private int _29;

    @Column(name = "_30")
    private int _30;

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

    public int get1() {
        return _1;
    }

    public void set1(int _1) {
        this._1 = _1;
    }

    public int get2() {
        return _2;
    }

    public void set2(int _2) {
        this._2 = _2;
    }

    public int get3() {
        return _3;
    }

    public void set3(int _3) {
        this._3 = _3;
    }

    public int get4() {
        return _4;
    }

    public void set4(int _4) {
        this._4 = _4;
    }

    public int get5() {
        return _5;
    }

    public void set5(int _5) {
        this._5 = _5;
    }

    public int get6() {
        return _6;
    }

    public void set6(int _6) {
        this._6 = _6;
    }

    public int get7() {
        return _7;
    }

    public void set7(int _7) {
        this._7 = _7;
    }

    public int get8() {
        return _8;
    }

    public void set8(int _8) {
        this._8 = _8;
    }

    public int get9() {
        return _9;
    }

    public void set9(int _9) {
        this._9 = _9;
    }

    public int get10() {
        return _10;
    }

    public void set10(int _10) {
        this._10 = _10;
    }

    public int get11() {
        return _11;
    }

    public void set11(int _11) {
        this._11 = _11;
    }

    public int get12() {
        return _12;
    }

    public void set12(int _12) {
        this._12 = _12;
    }

    public int get13() {
        return _13;
    }

    public void set13(int _13) {
        this._13 = _13;
    }

    public int get14() {
        return _14;
    }

    public void set14(int _14) {
        this._14 = _14;
    }

    public int get15() {
        return _15;
    }

    public void set15(int _15) {
        this._15 = _15;
    }

    public int get16() {
        return _16;
    }

    public void set16(int _16) {
        this._16 = _16;
    }

    public int get17() {
        return _17;
    }

    public void set17(int _17) {
        this._17 = _17;
    }

    public int get18() {
        return _18;
    }

    public void set18(int _18) {
        this._18 = _18;
    }

    public int get19() {
        return _19;
    }

    public void set19(int _19) {
        this._19 = _19;
    }

    public int get20() {
        return _20;
    }

    public void set20(int _20) {
        this._20 = _20;
    }

    public int get21() {
        return _21;
    }

    public void set21(int _21) {
        this._21 = _21;
    }

    public int get22() {
        return _22;
    }

    public void set22(int _22) {
        this._22 = _22;
    }

    public int get23() {
        return _23;
    }

    public void set23(int _23) {
        this._23 = _23;
    }

    public int get24() {
        return _24;
    }

    public void set24(int _24) {
        this._24 = _24;
    }

    public int get25() {
        return _25;
    }

    public void set25(int _25) {
        this._25 = _25;
    }

    public int get26() {
        return _26;
    }

    public void set26(int _26) {
        this._26 = _26;
    }

    public int get27() {
        return _27;
    }

    public void set27(int _27) {
        this._27 = _27;
    }

    public int get28() {
        return _28;
    }

    public void set28(int _28) {
        this._28 = _28;
    }

    public int get29() {
        return _29;
    }

    public void set29(int _29) {
        this._29 = _29;
    }

    public int get30() {
        return _30;
    }

    public void set30(int _30) {
        this._30 = _30;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final June other = (June) obj;
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
        return "June{" + "provenceState=" + provenceState + ", countryRegion=" + countryRegion + ", _1=" + _1 + ", _2=" + _2 
                + ", _3=" + _3 + ", _4=" + _4 + ", _5=" + _5 + ", _6=" + _6 + ", _7=" + _7 + ", _8=" + _8 + ", _9=" + _9 + ", _10=" 
                + _10 + ", _11=" + _11 + ", _12=" + _12 + ", _13=" + _13 + ", _14=" + _14 + ", _15=" + _15 + ", _16=" + _16 + ", _17=" 
                + _17 + ", _18=" + _18 + ", _19=" + _19 + ", _20=" + _20 + ", _21=" + _21 + ", _22=" + _22 + ", _23=" + _23 + ", _24=" 
                + _24 + ", _25=" + _25 + ", _26=" + _26 + ", _27=" + _27 + ", _28=" + _28 + ", _29=" + _29 + ", _30=" + _30 + '}';
    }
    
}
