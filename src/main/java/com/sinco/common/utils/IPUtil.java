package com.sinco.common.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

public class IPUtil {
	
	public static String getIpAddr(ServletRequest request) {
		HttpServletRequest localRequest=(HttpServletRequest) request;
		String ip = localRequest.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = localRequest.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = localRequest.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
	public static String [] getDomainIP(String domain) throws UnknownHostException {
		InetAddress [] array= InetAddress.getAllByName(domain);
		String ips []=new String[array.length];
		for (int i = 0; i < array.length; i++) {
			ips[i]=array[i].getHostAddress();
		}
		return ips;
	}
	
	/**
	 * 得到本机ip
	 * @return
	 * @throws UnknownHostException
	 */
	public static String getLocalIP() throws UnknownHostException{
		InetAddress addr = InetAddress.getLocalHost();
		return addr.getHostAddress().toString();//获得本机IP
	}

}
