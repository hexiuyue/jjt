package com.guoshi.baselib.utils;

import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;

//import java.util.HashMap;


/**
 * 签名的的规则
 * 
 */

public class SignUtil {
	/**
	 * 生成sign
	 * 
	 * @param map
	 * @param key
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String getSign(Map<String, Object> map, String key) {
		String returnValue = "";
		String[] nameArr = map.keySet().toArray(new String[] {});
		Arrays.sort(nameArr);//按照参数名升序排序
		StringBuilder builder = new StringBuilder();
		for (String name : nameArr) {
//			if ("sign".equals(name))//后台需要
//				continue;
			if (map.get(name) == null||"".equals(map.get(name)))//参数为空或""不参与
				continue;
			builder.append(name + "=" + map.get(name) + "&");
		}
		builder.append("key=" + key);//最后加上公司KEY
		String s=builder.toString();
		String sa=s.replaceAll(" ","");//去除空格
		Log.e("mainPage/search",sa);
		try {
			returnValue = Md5(sa,"UTF-8");//最后一起使用AES加密
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnValue;
	}
	

	/**
	 * md5加密
	 * 
	 * @param plainText
	 * @param charset
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	private static String Md5(String plainText, String charset)
			throws UnsupportedEncodingException {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes(charset));
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			return buf.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "null";
	}
}
