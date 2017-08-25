package com.github.zxj5470.k5;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Stream;

public class K5 {
    //01
    public static int sequence(int[] arr) {
        if (arr.length == 0) return 0;
        //find first +
        int sum, max, M = -1000000;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                sum = arr[i];
                for (int j = i + 1; j < arr.length; j++) {
                    max = sum;
                    sum += arr[j];
                    if (max < sum) max = sum;
                    M = Math.max(max, M);
                }
            }
        }
        return M;
    }

    //02
    static String toCamelCase(String s) {
        String[] ss = s.split("-|_");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ss.length; i++) {
            if (i > 0) {
                char[] ca = ss[i].toCharArray();
                if (ca[0] >= 'a' || ca[0] < 'z') ca[0] -= 32;
                sb.append(ca);
            } else {
                sb.append(ss[i]);
            }
        }
        return sb.toString();
    }

    //03
    static int comp(String a, String b) {
        int m = Math.min(a.length(), b.length());
        for (int i = 0; i < m; i++) {
            if (a.charAt(i) == b.charAt(i)) {
                continue;
            }
            if (a.charAt(i) > b.charAt(i)) {
                return 1;
            } else {
                return -1;
            }
        }
        return -1;
    }

    public static String orderWeight(String strng) {
        System.out.println(strng);
        String[] ss = strng.split(" ");
        for (int i = 0; i < ss.length; i++) {

        }
        Arrays.sort(ss, (o1, o2) -> {
            int s1 = 0, s2 = 0;
            for (int i = 0; i < o1.length(); i++) {
                s1 += o1.charAt(i) - '0';
            }
            for (int i = 0; i < o2.length(); i++) {
                s2 += o2.charAt(i) - '0';
            }
            if (s1 == s2) {
                return comp(o1, o2);
            }
            return s1 > s2 ? 1 : -1;
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ss.length; i++) {
            if (i == 0) sb.append(ss[i]);
            else {
                sb.append(" ");
                sb.append(ss[i]);
            }
        }
        return sb.toString();
    }

    //04
    static boolean find(String single, String[] str) {
        for (String e : str) {
            if (single.equals(e)) return true;
        }
        return false;
    }

    public static String generate_bc(String url, String separator) {
        url = url.replace("https://", "").replace("http://", "");
        if (url.contains("#")) {
            url = url.substring(0, url.indexOf("#"));
        }
        if (url.contains("?")) {
            url = url.substring(0, url.indexOf("?"));
        }
        String keywords[] = {"the", "of", "in", "from", "by", "with", "and", "or", "for", "to", "at", "a"};
        String head = "<a href=\"/\">HOME</a>";
        String[] ss = url.split("/");
        String inner = "";
        String[] splt1 = ss[ss.length - 2].split("-");
        String ender = ss[ss.length - 1].split("[.?#]")[0];
        String[] splt2 = ender.split("-");
        String cap = "", cap2 = "";
        final int[] s = {0, 1};
        Stream.of(splt1).forEach(it -> {
            s[0] += it.length();
        });
        Stream.of(splt2).forEach(it -> {
            s[1] += it.length();
        });
        if (s[0] > 30) {
            StringBuilder sb = new StringBuilder();
            Stream.of(splt1).forEach(it -> {
                if (!find(it, keywords))
                    sb.append(it.charAt(0));
            });
            cap = sb.toString().toUpperCase();
        } else {
            cap = ss[ss.length - 2].toUpperCase();
        }
        if (s[1] > 30) {
            StringBuilder sb = new StringBuilder();
            Stream.of(splt2).forEach(it -> {
                if (!find(it, keywords))
                    sb.append(it.charAt(0));
            });
            cap2 = sb.toString().toUpperCase();
        } else {
            cap2 = ender.toUpperCase().replaceAll("-", " ");
        }

        if (!ender.contains("index")) {
            inner = separator + "<a href=\"/" + ss[1] + "/\">" + cap + "</a>";
        } else {
            cap2 = "DOCS";
        }
        String end = separator + "<span class=\"active\">" + cap2 + "</span>";
        String ret = head + inner + end;
        System.out.println(ret);
        return ret;
    }


    //05
    public static int minIndex(char[] s) {
        int min = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[min] >= s[i]) min = i;
        }
        return min;
    }

    public static long[] smallest(long n) {
        char[] a = (n + "").toCharArray();
        int last = minIndex(a);
        for (int i = 0; i < a.length; i++) {
        }
        return new long[]{};
    }

    //06
    static long gcd(long a, long b) {
        long c;
        while (b != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }

    static long gbs(long a, long b) {
        return a / gcd(a, b) * b;
    }

    public static String convertFrac(long[][] lst) {
        StringBuilder sb=new StringBuilder();
        HashSet<Long> hashSet = new HashSet<>();
        for (long[] aLst : lst) {
            hashSet.add(aLst[1]);
        }
        final long[] t = {1};
        hashSet.forEach(it -> t[0] = gbs(t[0], it));
        for (long[] aLst : lst) {
            long temp = t[0] / aLst[1];
            aLst[0] *= temp;
            aLst[1] = t[0];
            sb.append("(").append(aLst[0]).append(",").append(aLst[1]).append(")");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        int ret=sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
//        System.out.println(ret);
//        toCamelCase("the-stealth-warrior");
//        String ret=orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123");
//        System.out.println(ret);
//        K5_2_Test.main(null);
//        long[][] lst;
//        lst = new long[][]{{1, 2}, {1, 3}, {1, 4}};
//        System.out.println(convertFrac(lst));

//        String u = "I should have known that you would have a perfect answer for me!!!";
//        List<String> v = Arrays.asList("J vltasl rlhr ", "zdfog odxr ypw", " atasl rlhr p ", "gwkzzyq zntyhv", " lvz wp!!!");

    }
}
