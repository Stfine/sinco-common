package com.sinco.common.utils;

import com.sinco.common.Hashids;

/**
 * hashid 工具类
 * @author james
 *
 */
public class HashidUtils {
	
	/**
	 * 默认密钥的对象
	 */
	private final static Hashids defaultHashids = new Hashids("shiro default salt,by james,123ewqasd654");

	/**
	 * 加密
	 * @param val
	 * @return
	 */
	public static String encode(Long val){
		return defaultHashids.encode(val);
	}
	
	/**
	 * 加密
	 * @param val
	 * @param salt 密钥
	 * @param length 结果长度
	 * @return
	 */
	public static  String encode(Long val,String salt,int length){
		Hashids hashids = new Hashids(salt,length);
		return hashids.encode(val);
	}
	
	/**
	 * 加密
	 * @param val
	 * @param salt 密钥
	 * @return
	 */
	public static String encode(Long val,String salt){
		Hashids hashids = new Hashids(salt);
		return hashids.encode(val);
	}
	
	/**
	 * 解密
	 * @param val
	 * @return
	 */
	public static Long decode(String val){
		long [] result=defaultHashids.decode(val);
		return result.length > 0 ? result[0]:null;
	}
	/**
	 * 解密
	 * @param val
	 * @return
	 */
	public static Long decode(String val,String salt,int length){
		Hashids hashids = new Hashids(salt,length);
		long [] result=hashids.decode(val);
		return result.length > 0 ? result[0]:null;
	}
	/**
	 * 解密
	 * @param val
	 * @return
	 */
	public static Long decode(String val,String salt){
		return decode(val, salt);
	}
	
	public static void main(String[] args) {
		String encode=HashidUtils.encode(23223232323L);
		System.out.println(encode);
		Long decode=HashidUtils.decode(encode);
		System.err.println(decode);
	}
}
