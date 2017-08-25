package com.github.zxj5470.k6;

import java.util.*;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2017/8/23 0023.
 */
public class K6_2 {
    public static Map<String, Long> getAverageGradeByDepartment(Stream<Student> students) {
        /*
        Map<String, Double> map = new HashMap<String, Double>();
        Map<String, Integer> countMap = new HashMap<String, Integer>();
        students.forEach(it -> {
            if (map.get(it.getDepartment()) == null) {
                countMap.put(it.getDepartment(), 1);
                map.put(it.getDepartment(), it.getGrade());
            } else {
                countMap.put(it.getDepartment(), countMap.get(it.getDepartment()) + 1);
                map.put(it.getDepartment(), it.getGrade() + map.get(it.getDepartment()));
            }
        });
            map.put(k,  (v / (double)countMap.get(k)));
        });
        return map;
        */
        Map<String, Long> countMap = new HashMap<String, Long>();
        students.forEach(it -> {
            if (countMap.get(it.getDepartment()) == null) {
                countMap.put(it.getDepartment(), 1L);
            } else {
                countMap.put(it.getDepartment(), countMap.get(it.getDepartment()) + 1);
            }
        });
        return countMap;
    }

    public static void main(String[] args) {
        Student galina = new Student("Galina", 95, "Philology", Student.Gender.FEMALE);
        Student anton = new Student("Anton", 90, "CS", Student.Gender.MALE);
        Student jack = new Student("Jack", 82, "Philology", Student.Gender.MALE);
        Student mike = new Student("Mike", 60, "Philology", Student.Gender.MALE);
        Student jane = new Student("Jane", 65, "CS", Student.Gender.FEMALE);
        Student[] students = new Student[]{galina, anton, jack, mike, jane};

//        Map<String, Double> actual = getAverageGradeByDepartment(Arrays.stream(students));
        Map<String, Double> expected = new HashMap<>();
        expected.put("CS", 77.5);
        expected.put("Philology", 79.0);
//        System.out.println(expected == actual);
//        actual.forEach((k,v)-> System.out.println(k+","+v));
        System.out.println(longestConsec(new String[]{"zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"}, 2));
    }
    public static String longestConsec(String[] strarr, int k) {
        if (strarr.length == 0|| k > strarr.length || k <= 0) return "";
        List<String> strs= Arrays.asList(strarr);
        strs.sort((o1, o2) -> o1.length()>o2.length()?-1:1);
        strs=strs.subList(0,k);
        StringBuilder sb=new StringBuilder();
        strs.forEach(sb::append);
        return sb.toString();
    }
}
