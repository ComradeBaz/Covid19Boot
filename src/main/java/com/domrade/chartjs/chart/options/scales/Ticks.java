/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.chartjs.chart.options.scales;

/**
 *
 * @author David
 */
public class Ticks {
    private boolean autoSkip;
    private int maxTicksLimit;
    /*private int min;
    private int max;
    private int sampleSize;
    private int autoSkipPadding;
    private int labelOffset;
    private int maxRotation;
    private int minRotation;
    private boolean mirror;
    private int padding;
    */

    public Ticks(boolean autoSkip, int maxTicksLimit) {
        this.autoSkip = autoSkip;
        this.maxTicksLimit = maxTicksLimit;
    }

    public boolean isAutoSkip() {
        return autoSkip;
    }

    public void setAutoSkip(boolean autoSkip) {
        this.autoSkip = autoSkip;
    }

    public int getMaxTicksLimit() {
        return maxTicksLimit;
    }

    public void setMaxTicksLimit(int maxTicksLimit) {
        this.maxTicksLimit = maxTicksLimit;
    }

    /*    public int getMin() {
    return min;
    }
    
    public void setMin(int min) {
    this.min = min;
    }
    
    public int getMax() {
    return max;
    }
    
    public void setMax(int max) {
    this.max = max;
    }
    
    public int getSampleSize() {
    return sampleSize;
    }
    
    public void setSampleSize(int sampleSize) {
    this.sampleSize = sampleSize;
    }
    
    public int getAutoSkipPadding() {
    return autoSkipPadding;
    }
    
    public void setAutoSkipPadding(int autoSkipPadding) {
    this.autoSkipPadding = autoSkipPadding;
    }
    
    public int getLabelOffset() {
    return labelOffset;
    }
    
    public void setLabelOffset(int labelOffset) {
    this.labelOffset = labelOffset;
    }
    
    public int getMaxRotation() {
    return maxRotation;
    }
    
    public void setMaxRotation(int maxRotation) {
    this.maxRotation = maxRotation;
    }
    
    public int getMinRotation() {
    return minRotation;
    }
    
    public void setMinRotation(int minRotation) {
    this.minRotation = minRotation;
    }
    
    public boolean isMirror() {
    return mirror;
    }
    
    public void setMirror(boolean mirror) {
    this.mirror = mirror;
    }
    
    public int getPadding() {
    return padding;
    }
    
    public void setPadding(int padding) {
    this.padding = padding;
    }*/    
}
