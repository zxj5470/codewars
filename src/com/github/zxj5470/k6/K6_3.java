package com.github.zxj5470.k6;

import java.util.LinkedList;

/**
 * Created by Administrator on 2017/8/24 0024.
 */
public class K6_3 {
    public static int max(int[] s) {
        int max = s[0];
        for (int i : s) {
            if (max < i) max = i;
        }
        return max;
    }

    public static int min(int[] s) {
        int min = s[0];
        for (int i : s) {
            if (min > i && i != 0) min = i;
        }
        return min;
    }

    public static int sum(int[] s) {
        int S = 0;
        for (int i : s) S += i;
        return S;
    }

    static void pr(int []s){
        for(int i:s){
            System.out.print(i);
        }
        System.out.println();
    }

    public static int solveSuperMarketQueue(int[] customers, int n) {
        int size = customers.length;
        if (size == 0) return 0;
        if (n > size) return max(customers);
        if (n == 1) return sum(customers);

        int[] q = new int[n];
        for (int i = 0,is=q.length; i < is; i++) q[i] = customers[i];

        int l=q.length;
        int time = 0;
        boolean ret=true;
        while (ret) {
            int min = min(q);
            time += min;
            int count=0;
            for (int j = 0,jsize=q.length; j < jsize; j++) {
                if(q[j]!=0){
                    q[j] -= min;
                    ret=true;
                }else{
                    if (l<customers.length){
                        q[j]=customers[l];
                        l++;
                    }
                    if(q[j]==0)count++;
                }
            }
            if(count==q.length)break;
        }
        return time;
    }
    public static String expandedForm(int num)
    {
        String a=num+"";
        StringBuilder sb=new StringBuilder();
        LinkedList<String> strings=new LinkedList<>();
        char[] ca=a.toCharArray();
        for(int i=0;i<ca.length;i++){
            if(ca[i]!='0'){
                sb.append(ca[i]);
                for(int j=i+1;j<ca.length;j++){
                    sb.append('0');
                }
                strings.add(sb.toString());
                sb.delete(0,sb.length());
            }
        }
        return String.join(" + ",strings);
    }

    public static void main(String[] args) {
//        int a = solveSuperMarketQueue(new int[]{2,2,3,3,4,4}, 2);
//        System.out.println(a);
        String s=expandedForm(70304);
        System.out.println(s);
    }
}
