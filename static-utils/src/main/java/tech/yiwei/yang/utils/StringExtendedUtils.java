package tech.yiwei.yang.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

public class StringExtendedUtils {

	public static String getUuid(){
		return UUID.randomUUID().toString().toLowerCase().replace("-","");
	}

	private static final char UNDERLINE='_';
	public static String camelToUnderline(String param){
		if(StringUtils.isBlank(param))
			return param;
		int len=param.length();
		StringBuilder sb=new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			char c=param.charAt(i);
			if (Character.isUpperCase(c)){
				sb.append(UNDERLINE);
				sb.append(Character.toLowerCase(c));
			}else{
				sb.append(c);
			}
		}
		return sb.toString();
	}
	public static String underlineToCamel(String param){
        if(StringUtils.isBlank(param))
            return param;
		int len=param.length();
		StringBuilder sb=new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			char c=param.charAt(i);
			if (c==UNDERLINE){
				if (++i<len){
					sb.append(Character.toUpperCase(param.charAt(i)));
				}
			}else{
				sb.append(c);
			}
		}
		return sb.toString();
	}

	public static String upperFirstLetter(String param){
	    String firstLetter = param.substring(0, 1).toUpperCase();
	    return firstLetter + param.substring(1);
    }

	public static String lowerFirstLetter(String param){
		String firstLetter = param.substring(0, 1).toLowerCase();
		return firstLetter + param.substring(1);
	}
}
