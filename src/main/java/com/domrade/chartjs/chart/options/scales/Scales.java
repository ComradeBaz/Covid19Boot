/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.chartjs.chart.options.scales;

import java.util.ArrayList;

/**
 *
 * @author David
 */
public class Scales {
    
    private ArrayList<YAxes> yAxes;
    private ArrayList<XAxes> xAxes;

    public Scales(ArrayList<YAxes> yAxes, ArrayList<XAxes> xAxes) {
        this.yAxes = yAxes;
        this.xAxes = xAxes;
    }

    public ArrayList<YAxes> getyAxes() {
        return yAxes;
    }

    public void setyAxes(ArrayList<YAxes> yAxes) {
        this.yAxes = yAxes;
    }

    public ArrayList<XAxes> getxAxes() {
        return xAxes;
    }

    public void setxAxes(ArrayList<XAxes> xAxes) {
        this.xAxes = xAxes;
    }

}
