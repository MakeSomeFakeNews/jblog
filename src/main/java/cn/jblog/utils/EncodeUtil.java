package cn.jblog.utils;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;

public class EncodeUtil {
	/**
	 * 将字符串转成unicode
	 * 
	 * @param str
	 *            待转字符串
	 * @return base64字符串
	 * @throws UnsupportedEncodingException
	 */
	public static String convert(String str) {
		StringBuffer unicode = new StringBuffer();

		for (int i = 0; i < str.length(); i++) {

			// 取出每一个字符
			char c = str.charAt(i);

			// 转换为unicode
			unicode.append("\\u" + Integer.toHexString(c));
		}

		String base64 = Base64.encodeBase64URLSafeString(unicode.toString().getBytes());

		return base64;

	}

	/**
	 * 将unicode 字符串
	 * 
	 * @param str
	 *            待转字符串
	 * @return 普通字符串
	 */
	public static String revert(String str) {
		byte[] base64 = Base64.decodeBase64(str);
		str = new String(base64);
		StringBuffer string = new StringBuffer();

		String[] hex = str.split("\\\\u");

		for (int i = 1; i < hex.length; i++) {

			// 转换出每一个代码点
			int data = Integer.parseInt(hex[i], 16);

			// 追加成string
			string.append((char) data);
		}
		return string.toString();
	}
}
