package com.github.zxj5470.k5;

import static com.github.zxj5470.k5.K5.generate_bc;

/**
 * Created by Administrator on 2017/8/24 0024.
 */

public class K5_2_Test {
    public static void examplesTests() {
        String[] urls = new String[] {"mysite.com/pictures/holidays.html",
                "www.codewars.com/users/GiacomoSorbi?ref=CodeWars",
                "www.microsoft.com/docs/index.htm#top",
                "mysite.com/very-long-url-to-make-a-silly-yet-meaningful-example/example.asp",
                "agcpartners.co.uk/in-immunity-of-from-in-of-uber-research/test.asp#bottom?rank=recent_first&hide=sold"};

        String[] seps = new String[] {" : ", " / ", " * ", " > ", " - "};

        String[] anss = new String[] {
                "<a href=\"/\">HOME</a> : <a href=\"/pictures/\">PICTURES</a> : <span class=\"active\">HOLIDAYS</span>",
                "<a href=\"/\">HOME</a> / <a href=\"/users/\">USERS</a> / <span class=\"active\">GIACOMOSORBI</span>",
                "<a href=\"/\">HOME</a> * <span class=\"active\">DOCS</span>",
                "<a href=\"/\">HOME</a> > <a href=\"/very-long-url-to-make-a-silly-yet-meaningful-example/\">VLUMSYME</a> > <span class=\"active\">EXAMPLE</span>",
                "<a href=\"/\">HOME</a> - <a href=\"/in-immunity-of-from-in-of-uber-research/\">IUR</a> - <span class=\"active\">TEST</span>"};

        for (int i = 0 ; i<5 ; i++) {
//            System.out.println(" \nTest with : " + urls[i]);
            String actual = generate_bc(urls[i], seps[i]);
            System.out.println(anss[i].equals(actual));
            System.out.println(anss[i]);
            if (!actual.equals(anss[i])) {
//                System.out.println(String.format("Expected : %s", reformat(anss[i])));
//                System.out.println(String.format("Actual :   %s", reformat(actual)));
            }
        }
    }
    static String reformat(String s) { return s.replace("<","<"); }

    public static void main(String[] args) {
        examplesTests();
    }
}


