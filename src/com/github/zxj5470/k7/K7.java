package com.github.zxj5470.k7;

/**
 * Created by Administrator on 2017/8/24 0024.
 */
public class K7 {
    //01
    public static String printerError(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) > 'm') {
                count++;
            }
        }
        return count + "/" + s.length();
    }

    //02
    public static String longest(String s1, String s2) {
        char[] table = new char[26];
        for (int i = 0; i < s1.length(); i++) {
            table[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            table[s2.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < table.length; i++) {
            if(table[i]!=0)
            sb.append((char)(i+'a'));
        }
        return sb.toString();
    }

}
