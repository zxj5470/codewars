package com.github.zxj5470.K4;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/24 0024.
 */
public class K4 {
    //01
    static class A<Integer> extends ArrayList<Integer> {
        @Override
        public boolean add(Integer integer) {
            return !this.contains(integer) && super.add(integer);
        }
    }

    public static int dblLinear(int n) {
        ArrayList<Integer> ll = new A<>();
        ll.add(1);
        int size = 1;
        int i = 1;
        int e = 1;
        while (size <= n*2) {
            if (ll.add(2 * e + 1)) size++;
            if (ll.add(3 * e + 1)) size++;
            e = ll.get(i++);
        }
        ll.sort((o1, o2) -> o1 > o2 ? 1 : -1);
        ll.forEach(System.out::print);
        System.out.println();
        return ll.get(n);
    }

    public static void main(String[] args) {
        System.out.println(dblLinear(30));
    }
}
