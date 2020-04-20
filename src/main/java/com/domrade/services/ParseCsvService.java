package com.domrade.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domrade.interfaces.local.CachedDataLocal;
import com.domrade.interfaces.local.ParseCsvServiceLocal;

@Service
public class ParseCsvService implements ParseCsvServiceLocal {

	@Autowired
	private CachedDataLocal cachedData;

	public ParseCsvService() {
		// no arg constructor
	}

	@Override
	public void readFile(String fileToParse) {
		StringBuilder sb = new StringBuilder();
		String strLine = "";
		String strData = "";
		String provinceState = "Province/State";
		String countryRegion = "Country/Region";
		String lat = "Lat";
		String longitude = "Long";
		String startOfJan = "1/22/20";
		String endOfJan = "1/31/20";
		boolean endOfJanSet = false;
		String[] janData;
		String startOfFeb = "2/1/20";
		String endOfFeb = "2/29/20";
		boolean endOfFebSet = false;
		String[] febData;
		String startOfMarch = "3/1/20";
		String endOfMarch = "3/31/20";
		boolean endOfMarchSet = false;
		String[] marchData;
		String startOfApril = "4/1/20";
		String endOfApril = "4/30/20";
		boolean endOfAprilSet = false;
		String[] aprilData;
		String startOfMay = "5/1/20";
		String endOfMay = "5/31/20";
		boolean endOfMaySet = false;
		String[] mayData;
		int indexOfProvinceState = -1;
		int indexOfCountryRegion = -1;
		int indexOfLat = -1;
		int indexOfLongitude = -1;
		int indexStartOfJan = -1;
		int indexEndOfJan = -1;
		int noDaysJan;
		int indexStartOfFeb = -1;
		int indexEndOfFeb = -1;
		int noDaysFeb; // = indexEndOfFeb - indexStartOfFeb
		int indexStartOfMarch = -1;
		int indexEndOfMarch = -1;
		int noDaysMarch; // = indexEndOfMarch - indexStartOfMarch
		int indexStartOfApril = -1;
		int indexEndOfApril = -1;
		int noDaysApril; // = indexEndOfApril - indexStartOfApril
		int indexStartOfMay = -1;
		int indexEndOfMay = -1;
		int noDaysMay; // = indexEndOfMay - indexStartOfMay
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileToParse));
			int arrayLength = 0;
			boolean endOfArray = false;
			// Read the first line to get the indexes of location and dates
			strLine = br.readLine();
			if (strLine != null) {
				String[] elements = strLine.split(",");
				arrayLength = elements.length;
				int index;
				for (index = 0; index < elements.length; index++) {
					// check if end of array has been reached before the end of the current month
					// checkPositionInArray returns true if the index is at the last position in the
					// array
					// If that is true the index is at the last day of the month available in the
					// array
					// Set this to the final day of the month and break

					if (elements[index].equalsIgnoreCase(provinceState)) {
						System.out.println(elements[index] + " " + index);
						indexOfProvinceState = index;
					}
					if (elements[index].equalsIgnoreCase(countryRegion)) {
						System.out.println(elements[index] + " " + index);
						indexOfCountryRegion = index;
					}
					if (elements[index].equalsIgnoreCase(lat)) {
						System.out.println(elements[index] + " " + index);
						indexOfLat = index;
					}
					if (elements[index].equalsIgnoreCase(longitude)) {
						System.out.println(elements[index] + " " + index);
						indexOfLongitude = index;
					}
					if (elements[index].equalsIgnoreCase(startOfJan)) {
						System.out.println(elements[index] + " " + index);
						indexStartOfJan = index;
					}
					if (elements[index].equalsIgnoreCase(endOfJan)) {
						System.out.println(elements[index] + " " + index);
						indexEndOfJan = index;
						endOfJanSet = true;
					}
					if (elements[index].equalsIgnoreCase(startOfFeb)) {
						System.out.println(elements[index] + " " + index);
						indexStartOfFeb = index;
					}
					if (elements[index].equalsIgnoreCase(endOfFeb)) {
						System.out.println(elements[index] + " " + index);
						indexEndOfFeb = index;
						endOfFebSet = true;
					}
					if (elements[index].equalsIgnoreCase(startOfMarch)) {
						System.out.println(elements[index] + " " + index);
						indexStartOfMarch = index;
					}
					if (elements[index].equalsIgnoreCase(endOfMarch)) {
						System.out.println(elements[index] + " " + index);
						indexEndOfMarch = index;
						endOfMarchSet = true;
					}
					if (elements[index].equalsIgnoreCase(startOfApril)) {
						System.out.println(elements[index] + " " + index);
						indexStartOfApril = index;
					}
					if (elements[index].equalsIgnoreCase(endOfApril)) {
						System.out.println(elements[index] + " " + index);
						indexEndOfApril = index;
						endOfAprilSet = true;
					}
					if (elements[index].equalsIgnoreCase(startOfMay)) {
						System.out.println(elements[index] + " " + index);
						indexStartOfMay = index;
					}
					if (elements[index].equalsIgnoreCase(endOfMay)) {
						System.out.println(elements[index] + " " + index);
						indexEndOfMay = index;
						endOfMaySet = true;
					}
					if (!endOfArray) {
						if (checkPositionInArray(index, arrayLength)) {
							if (!endOfJanSet) {
								indexEndOfJan = index;
								endOfJanSet = true;
								endOfArray = true;
								System.out.println("indexEndOfJan: " + indexEndOfJan);
								break;
							}
							if (!endOfFebSet) {
								indexEndOfFeb = index;
								endOfFebSet = true;
								endOfArray = true;
								System.out.println("indexEndOfFeb: " + indexEndOfFeb);
								break;
							}
							if (!endOfMarchSet) {
								indexEndOfMarch = index;
								endOfMarchSet = true;
								endOfArray = true;
								System.out.println("indexEndOfMarch: " + indexEndOfMarch);
								break;
							}
							if (!endOfAprilSet) {
								indexEndOfApril = index;
								endOfAprilSet = true;
								endOfArray = true;
								System.out.println("indexEndOfApril: " + indexEndOfApril);
								break;
							}
							if (!endOfMaySet) {
								indexEndOfMay = index;
								endOfMaySet = true;
								endOfArray = true;
								System.out.println("indexEndOfMay: " + indexEndOfMay);
								break;
							}
						}
					}
				}
			}
			List<String> janDataList = new ArrayList<>();
			List<String> febDataList = new ArrayList<>();
			List<String> marchDataList = new ArrayList<>();
			List<String> aprilDataList = new ArrayList<>();
			List<String> mayDataList = new ArrayList<>();
			while (strLine != null) {
				strLine = br.readLine();
				if (strLine != null) {
					if (indexStartOfJan > 0) {
						String janList = getDataByMonth(strLine, indexOfProvinceState, indexOfCountryRegion, indexOfLat,
								indexOfLongitude, indexStartOfJan, indexEndOfJan);
						janDataList.add(janList);
					}
					if (indexStartOfFeb > 0) {
						String febList = getDataByMonth(strLine, indexOfProvinceState, indexOfCountryRegion, indexOfLat,
								indexOfLongitude, indexStartOfFeb, indexEndOfFeb);
						febDataList.add(febList);
					}
					if (indexStartOfMarch > 0) {
						String marchList = getDataByMonth(strLine, indexOfProvinceState, indexOfCountryRegion,
								indexOfLat, indexOfLongitude, indexStartOfMarch, indexEndOfMarch);
						marchDataList.add(marchList);
					}
					if (indexStartOfApril > 0) {
						indexEndOfApril = indexStartOfApril + 29;
						String aprilList = getDataByMonth(strLine, indexOfProvinceState, indexOfCountryRegion,
								indexOfLat, indexOfLongitude, indexStartOfApril, indexEndOfApril);
						aprilDataList.add(aprilList);
					}
					if (indexStartOfMay > 0) {
						String mayList = getDataByMonth(strLine, indexOfProvinceState, indexOfCountryRegion, indexOfLat,
								indexOfLongitude, indexStartOfMay, indexEndOfMay);
						mayDataList.add(mayList);
					}
				}
			}
			cachedData.setJanuary(janDataList);
			cachedData.setFebruary(febDataList);
			cachedData.setMarch(marchDataList);
			cachedData.setApril(aprilDataList);
			cachedData.setMay(mayDataList);

			System.out.println("array.length: " + arrayLength);

		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe.getMessage());
		} catch (IOException io) {
			System.out.println(io.getMessage());
		}
	}

	// If there is not data for the entire month, find the last date for which there
	// is data
	@Override
	public boolean checkPositionInArray(int index, int arrayLength) {
		boolean lastPositionInArray = false;
		if (index == arrayLength - 1) {
			lastPositionInArray = true;
		}

		return lastPositionInArray;
	}

	@Override
	public String getDataByMonth(String lineOfData, int indexProvinceState, int indexCountryRegion, int indexLat,
			int indexLong, int indexFirstDayOfMonth, int indexEndOfMonth) {
		char split = ',';
		String[] elements = lineOfData.split(",");
		List<String> returnList = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		// 5 because there are 4 locations data positions and I'm adding a primaryKey
		// column
		String[] monthlyData = new String[5 + 1 + (indexEndOfMonth - indexFirstDayOfMonth)];
		String[] monthlyDataWithTwoPartProvinceState = new String[monthlyData.length + 1];
		String[] monthlyDataWithTwoPartCountryRegion = new String[monthlyData.length + 1];
		String[] monthlyDataWithTwoPartProvinceStateCountryRegion = new String[monthlyData.length + 2];
		int monthlyDataIndex = 0;
		int index = 0;

		// Generate Primary Key
		String provinceState = elements[indexProvinceState];
		String countryRegion = elements[indexCountryRegion];
		long primaryKey = (provinceState + countryRegion).hashCode();
		sb.append(primaryKey);
		sb.append(split);

		int result;
		char compareTo = '\"';
		boolean isProvinceStateTwoParts = false;
		boolean isCountryRegionTwoParts = false;
		// Province/State
		if (!provinceState.equalsIgnoreCase("")) {
			char provinceStateFirstChar = provinceState.charAt(0);
			result = Character.compare(provinceStateFirstChar, compareTo);
			if (result == 0) {
				// The Province/State is comprised of two Strings separated by a comma eg "Polk
				// County, GA",
				monthlyData[monthlyDataIndex] = elements[indexProvinceState];
				sb.append(monthlyData[monthlyDataIndex]);
				sb.append(split);
				monthlyDataIndex++;
				monthlyData[monthlyDataIndex] = elements[indexProvinceState + 1];
				sb.append(monthlyData[monthlyDataIndex]);
				sb.append(split);
				monthlyDataIndex++;
				isProvinceStateTwoParts = true;
				// If provinceState is two parts the array must be length + 1
				System.arraycopy(monthlyData, 0, monthlyDataWithTwoPartProvinceState, 0, monthlyDataIndex);
			} else {
				monthlyData[monthlyDataIndex] = elements[indexProvinceState];
				sb.append(monthlyData[monthlyDataIndex]);
				sb.append(split);
				monthlyDataIndex++;
			}
		} else {
			monthlyData[monthlyDataIndex] = elements[indexProvinceState];
			sb.append(monthlyData[monthlyDataIndex]);
			sb.append(split);
			monthlyDataIndex++;
		}

		// Country/Region
		if (isProvinceStateTwoParts) {
			// Shift the index forward 1 position to account for 2 part provinceState
			indexCountryRegion++;
			// Get the countryRegion
			countryRegion = elements[indexCountryRegion];
			// Assign array with extra position to monthlyData
			monthlyData = monthlyDataWithTwoPartProvinceState;
			// Shift indexes 1 position
			indexFirstDayOfMonth++;
			indexEndOfMonth++;
			indexLat++;
			indexLong++;
		}
		char countryRegionFirstChar = countryRegion.charAt(0);
		result = Character.compare(countryRegionFirstChar, compareTo);
		if (result == 0) {
			// The Country/Region is comprised of two Strings separated by a comma eg
			// ,"Korea, South",
			monthlyData[monthlyDataIndex] = elements[indexCountryRegion];
			sb.append(monthlyData[monthlyDataIndex]);
			sb.append(split);
			monthlyDataIndex++;
			monthlyData[monthlyDataIndex] = elements[indexCountryRegion + 1];
			sb.append(monthlyData[monthlyDataIndex]);
			sb.append(split);
			monthlyDataIndex++;
			isCountryRegionTwoParts = true;
			if (!isProvinceStateTwoParts) {
				// If countryRegion is two parts the array must be length + 1
				System.arraycopy(monthlyData, 0, monthlyDataWithTwoPartCountryRegion, 0, monthlyDataIndex);
				// Shift indexes 1 position
				indexFirstDayOfMonth++;
				indexEndOfMonth++;
				indexLat++;
				indexLong++;
			} else {
				// If provinceState and countryRegion is two parts the array must be length + 2
				System.arraycopy(monthlyData, 0, monthlyDataWithTwoPartProvinceStateCountryRegion, 0, monthlyDataIndex);
				// Shift indexes 1 position
				indexFirstDayOfMonth++;
				indexEndOfMonth++;
				indexLat++;
				indexLong++;
			}
		} else {
			monthlyData[monthlyDataIndex] = elements[indexCountryRegion];
			sb.append(monthlyData[monthlyDataIndex]);
			sb.append(split);
			monthlyDataIndex++;
		}

		// Latitude
		monthlyData[monthlyDataIndex] = elements[indexLat];
		sb.append(monthlyData[monthlyDataIndex]);
		sb.append(split);
		monthlyDataIndex++;

		// Longitude
		monthlyData[monthlyDataIndex] = elements[indexLong];
		sb.append(monthlyData[monthlyDataIndex]);
		sb.append(split);
		monthlyDataIndex++;

		try {
			for (index = indexFirstDayOfMonth; index <= indexEndOfMonth; index++) {
				monthlyData[monthlyDataIndex] = elements[index];
				sb.append(monthlyData[monthlyDataIndex]);
				if (index != indexEndOfMonth) {
					sb.append(split);
				}
				monthlyDataIndex++;
			}
			sb.append("\n");
			returnList = Arrays.asList(monthlyData);
			return sb.toString();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("End of data");
			// Add a , for dates not included in the original file so it can be imported to
			// database
			for (int i = index; i <= indexEndOfMonth; i++) {
				sb.append(-1);
				if (i != indexEndOfMonth) {
					sb.append(split);
				}
			}
			sb.append("\n");
			return sb.toString();
		}
	}
}
