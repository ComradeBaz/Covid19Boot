package com.domrade.entity.implementation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
    @NamedQuery(name = "May.findAllEntries", query = "SELECT m FROM May m")
    ,
    @NamedQuery(name = "May.findByCountryRegion", query = "SELECT m FROM May m WHERE m.countryRegion =:countryRegion")})
@Entity
@Table(name = "may")
public class May implements Serializable {

    public May() {
        // TODO Auto-generated constructor stub
    }

    public May(String provenceState, String countryRegion, String latitude, String longitude, int one, int two,
            int three, int four, int five, int six, int seven, int eight, int nine, int ten, int eleven, int twelve,
            int thirteen, int fourteen, int fifteen, int sixteen, int seventeen, int eighteen, int ninteen, int twenty,
            int twentyOne, int twentyTwo, int twentyThree, int twentyFour, int twentyFive, int twentySix,
            int twentySeven, int twentyEight, int twentyNine, int thirty, int thirtyOne) {

        this.provenceState = provenceState;
        this.countryRegion = countryRegion;
        this.latitude = latitude;
        this.longitude = longitude;
        this.one = one;
        this.two = two;
        this.three = three;
        this.four = four;
        this.five = five;
        this.six = six;
        this.seven = seven;
        this.eight = eight;
        this.nine = nine;
        this.ten = ten;
        this.eleven = eleven;
        this.twelve = twelve;
        this.thirteen = thirteen;
        this.fourteen = fourteen;
        this.fifteen = fifteen;
        this.sixteen = sixteen;
        this.seventeen = seventeen;
        this.eighteen = eighteen;
        this.ninteen = ninteen;
        this.twenty = twenty;
        this.twentyOne = twentyOne;
        this.twentyTwo = twentyTwo;
        this.twentyThree = twentyThree;
        this.twentyFour = twentyFour;
        this.twentyFive = twentyFive;
        this.twentySix = twentySix;
        this.twentySeven = twentySeven;
        this.twentyEight = twentyEight;
        this.twentyNine = twentyNine;
        this.thirty = thirty;
        this.thirtyOne = thirtyOne;
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

    @Column(name = "one")
    private int one;

    @Column(name = "two")
    private int two;

    @Column(name = "three")
    private int three;

    @Column(name = "four")
    private int four;

    @Column(name = "five")
    private int five;

    @Column(name = "six")
    private int six;

    @Column(name = "seven")
    private int seven;

    @Column(name = "eight")
    private int eight;

    @Column(name = "nine")
    private int nine;

    @Column(name = "ten")
    private int ten;

    @Column(name = "eleven")
    private int eleven;

    @Column(name = "twelve")
    private int twelve;

    @Column(name = "thirteen")
    private int thirteen;

    @Column(name = "fourteen")
    private int fourteen;

    @Column(name = "fifteen")
    private int fifteen;

    @Column(name = "sixteen")
    private int sixteen;

    @Column(name = "seventeen")
    private int seventeen;

    @Column(name = "eighteen")
    private int eighteen;

    @Column(name = "ninteen")
    private int ninteen;

    @Column(name = "twenty")
    private int twenty;

    @Column(name = "t_one")
    private int twentyOne;

    @Column(name = "t_two")
    private int twentyTwo;

    @Column(name = "t_three")
    private int twentyThree;

    @Column(name = "t_four")
    private int twentyFour;

    @Column(name = "t_five")
    private int twentyFive;

    @Column(name = "t_six")
    private int twentySix;

    @Column(name = "t_seven")
    private int twentySeven;

    @Column(name = "t_eight")
    private int twentyEight;

    @Column(name = "t_nine")
    private int twentyNine;

    @Column(name = "thirty")
    private int thirty;

    @Column(name = "tr_one")
    private int thirtyOne;

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

    public int getOne() {
        return one;
    }

    public void setOne(int one) {
        this.one = one;
    }

    public int getTwo() {
        return two;
    }

    public void setTwo(int two) {
        this.two = two;
    }

    public int getThree() {
        return three;
    }

    public void setThree(int three) {
        this.three = three;
    }

    public int getFour() {
        return four;
    }

    public void setFour(int four) {
        this.four = four;
    }

    public int getFive() {
        return five;
    }

    public void setFive(int five) {
        this.five = five;
    }

    public int getSix() {
        return six;
    }

    public void setSix(int six) {
        this.six = six;
    }

    public int getSeven() {
        return seven;
    }

    public void setSeven(int seven) {
        this.seven = seven;
    }

    public int getEight() {
        return eight;
    }

    public void setEight(int eight) {
        this.eight = eight;
    }

    public int getNine() {
        return nine;
    }

    public void setNine(int nine) {
        this.nine = nine;
    }

    public int getTen() {
        return ten;
    }

    public void setTen(int ten) {
        this.ten = ten;
    }

    public int getEleven() {
        return eleven;
    }

    public void setEleven(int eleven) {
        this.eleven = eleven;
    }

    public int getTwelve() {
        return twelve;
    }

    public void setTwelve(int twelve) {
        this.twelve = twelve;
    }

    public int getThirteen() {
        return thirteen;
    }

    public void setThirteen(int thirteen) {
        this.thirteen = thirteen;
    }

    public int getFourteen() {
        return fourteen;
    }

    public void setFourteen(int fourteen) {
        this.fourteen = fourteen;
    }

    public int getFifteen() {
        return fifteen;
    }

    public void setFifteen(int fifteen) {
        this.fifteen = fifteen;
    }

    public int getSixteen() {
        return sixteen;
    }

    public void setSixteen(int sixteen) {
        this.sixteen = sixteen;
    }

    public int getSeventeen() {
        return seventeen;
    }

    public void setSeventeen(int seventeen) {
        this.seventeen = seventeen;
    }

    public int getEighteen() {
        return eighteen;
    }

    public void setEighteen(int eighteen) {
        this.eighteen = eighteen;
    }

    public int getNinteen() {
        return ninteen;
    }

    public void setNinteen(int ninteen) {
        this.ninteen = ninteen;
    }

    public int getTwenty() {
        return twenty;
    }

    public void setTwenty(int twenty) {
        this.twenty = twenty;
    }

    public int getTwentyOne() {
        return twentyOne;
    }

    public void setTwentyOne(int twentyOne) {
        this.twentyOne = twentyOne;
    }

    public int getTwentyTwo() {
        return twentyTwo;
    }

    public void setTwentyTwo(int twentyTwo) {
        this.twentyTwo = twentyTwo;
    }

    public int getTwentyThree() {
        return twentyThree;
    }

    public void setTwentyThree(int twentyThree) {
        this.twentyThree = twentyThree;
    }

    public int getTwentyFour() {
        return twentyFour;
    }

    public void setTwentyFour(int twentyFour) {
        this.twentyFour = twentyFour;
    }

    public int getTwentyFive() {
        return twentyFive;
    }

    public void setTwentyFive(int twentyFive) {
        this.twentyFive = twentyFive;
    }

    public int getTwentySix() {
        return twentySix;
    }

    public void setTwentySix(int twentySix) {
        this.twentySix = twentySix;
    }

    public int getTwentySeven() {
        return twentySeven;
    }

    public void setTwentySeven(int twentySeven) {
        this.twentySeven = twentySeven;
    }

    public int getTwentyEight() {
        return twentyEight;
    }

    public void setTwentyEight(int twentyEight) {
        this.twentyEight = twentyEight;
    }

    public int getTwentyNine() {
        return twentyNine;
    }

    public void setTwentyNine(int twentyNine) {
        this.twentyNine = twentyNine;
    }

    public int getThirty() {
        return thirty;
    }

    public void setThirty(int thirty) {
        this.thirty = thirty;
    }

    public int getThirtyOne() {
        return thirtyOne;
    }

    public void setThirtyOne(int thirtyOne) {
        this.thirtyOne = thirtyOne;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), provenceState + countryRegion);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final May other = (May) obj;
        return Objects.equals(getId(), other.getId()) && Objects.equals(this.countryRegion, other.countryRegion)
                && Objects.equals(this.provenceState, other.provenceState);
    }

    @Override
    public String toString() {
        return "March{" + "provenceState=" + provenceState + ", countryRegion=" + countryRegion + ", one=" + one + ", two="
                + two + ", three=" + three + ", four=" + four + ", five=" + five + ", six=" + six + ", seven=" + seven
                + ", eight=" + eight + ", nine=" + nine + ", ten=" + ten + ", eleven=" + eleven + ", twelve=" + twelve
                + ", thirteen=" + thirteen + ", fourteen=" + fourteen + ", fifteen=" + fifteen + ", sixteen=" + sixteen
                + ", seventeen=" + seventeen + ", eighteen=" + eighteen + ", ninteen=" + ninteen + ", twenty=" + twenty + ", twentyOne="
                + twentyOne + ", twentyTwo=" + twentyTwo + ", twentyThree=" + twentyThree + ", twentyFour=" + twentyFour + ", twentyFive="
                + twentyFive + ", twentySix=" + twentySix + ", twentySeven=" + twentySeven + ", twentyEight=" + twentyEight + ", twentyNine="
                + twentyNine + ", thirty=" + thirty + ", thirtyOne=" + thirtyOne + '}';
    }

}
