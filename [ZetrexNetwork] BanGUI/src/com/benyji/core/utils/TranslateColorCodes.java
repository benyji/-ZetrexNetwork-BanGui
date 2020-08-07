package com.benyji.core.utils;

import org.bukkit.ChatColor;

public class TranslateColorCodes {

	public String translate(String m) {
		String s = ChatColor.translateAlternateColorCodes('&', m);
		 String working = s;
		    int index;
		    index = working.indexOf("\\u");
		    while(index > -1)
		    {
		        int length = working.length();
		        if(index > (length-6))break;
		        int numStart = index + 2;
		        int numFinish = numStart + 4;
		        String substring = working.substring(numStart, numFinish);
		        int number = Integer.parseInt(substring,16);
		        String stringStart = working.substring(0, index);
		        String stringEnd   = working.substring(numFinish);
		        working = stringStart + ((char)number) + stringEnd;
		        index = working.indexOf("\\u");
		    }
		    return working;
		
	}
	
	

}
