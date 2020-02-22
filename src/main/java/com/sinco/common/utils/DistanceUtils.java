package com.sinco.common.utils;

public class DistanceUtils {
	private static final double EARTH_RADIUS = 6378137;

	private static double rad(double d) {
		return d * Math.PI / 180.0;
	}

	/** */
	/**
	 * 根据两点间经纬度坐标（double值），计算两点间距离，单位为米
	 * 
	 * @param lng1
	 * @param lat1
	 * @param lng2
	 * @param lat2
	 * @returnDistanceUtils
	 */
	public static double GetDistance(double lng1, double lat1, double lng2, double lat2) {
		double radLat1 = rad(lat1);
		double radLat2 = rad(lat2);
		double a = radLat1 - radLat2;
		double b = rad(lng1) - rad(lng2);
		double s = 2 * Math.asin(Math.sqrt(
				Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
		s = s * EARTH_RADIUS;
		s = Math.round(s * 10000) / 10000;
		return s;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		113.93594821755354 , 22.539102209161772
//		113.93721631431697 , 22.54353370287067
 
		// TODO 自动生成方法存根
		double distance = GetDistance( 113.93958523747061 , 22.54519228366515, 113.949408, 22.557289);
		System.out.println("Distance is:" + distance);
	}
}
