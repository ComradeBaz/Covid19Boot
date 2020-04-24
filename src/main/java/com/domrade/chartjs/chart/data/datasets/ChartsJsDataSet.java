/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.chartjs.chart.data.datasets;

import java.util.List;

/**
 *
 * @author David
 */
public class ChartsJsDataSet extends AbstractChartsJsDataSet {

	private List<Integer> data;
	private String label;

	// Common defaults
	// private boolean fill;
	// line width
	// private int borderWidth;
	// private int pointRadius;
	// private int pointBorderWidth;

	public ChartsJsDataSet() {
		super();
	}

	public ChartsJsDataSet(List<Integer> data, String label) {
		this.data = data;
		this.label = label;

		// Common defaults
		// this.fill = false;
		// this.borderWidth = 2;
		// this.pointRadius = 2;
		// this.pointBorderWidth = 0;
	}

	public List<Integer> getData() {
		return data;
	}

	public void setData(List<Integer> data) {
		this.data = data;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	/*
	 * public boolean isFill() { return fill; }
	 * 
	 * public void setFill(boolean fill) { this.fill = fill; }
	 * 
	 * public int getBorderWidth() { return borderWidth; }
	 * 
	 * public void setBorderWidth(int borderWidth) { this.borderWidth = borderWidth;
	 * }
	 * 
	 * public int getPointRadius() { return pointRadius; }
	 * 
	 * public void setPointRadius(int pointRadius) { this.pointRadius = pointRadius;
	 * }
	 * 
	 * public int getPointBorderWidth() { return pointBorderWidth; }
	 * 
	 * public void setPointBorderWidth(int pointBorderWidth) { this.pointBorderWidth
	 * = pointBorderWidth; }
	 */
}
