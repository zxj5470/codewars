package com.github.zxj5470.k6;

/**
 * Created by Administrator on 2017/8/24 0024.
 */
public class K6 {
    public static String Tickets(int[] peopleInLine) {
        int _25 = 0;
        int _50 = 0;
        boolean ret = true;
        for (int i : peopleInLine) {
            if (i == 25) _25++;
            if (i == 50) {
                if (_25 < 1) {
                    ret = false;
                    break;
                } else {
                    _50++;
                    _25--;
                }
            }
            if (i == 100) {
                boolean flag = true;

                if (_50 > 0) {
                    if (_25 > 0) {
                        _25--;
                        _50--;
                    } else flag = false;
                } else if (_25 > 2) {
                    _25 -= 3;
                } else {
                    flag = false;
                }
                if (!flag) {
                    ret = false;
                    break;
                }
            }
        }
        return ret ? "YES" : "NO";
    }

    public static void main(String[] args) {
        System.out.println(Tickets(new int[]{25, 100}));
    }
}
