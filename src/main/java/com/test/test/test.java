package com.test.test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class test {

    @Test
    public void testFinal() {
        final List<String> strList = new ArrayList<>();
        strList.add("Hello");
        strList.add("world");
        List<String> unmodifiableStrList = List.of("hello", "world");
        unmodifiableStrList.add("again");
    }

    @Test
    public void testFinalize() {

        Object counter = new Object();
        ReferenceQueue refQueue = new ReferenceQueue<>();
        PhantomReference<Object> p = new PhantomReference<>(counter, refQueue);
        counter = null;
        System.gc();
        try {
            // Remove是一个阻塞方法，可以指定timeout，或者选择一直阻塞
            Reference<Object> ref = refQueue.remove(1000L);
            if (ref != null) {
                // do something
            }
        } catch (InterruptedException e) {
            // Handle it
        }
    }


    @Test
    public void testFinal3() {
        String s = "test";
        s = s+ "test";
        System.out.println(s);
    }

    @Test
    public void testContin() {
        List<Integer> number = new LinkedList<>();
        number.add(new Integer(1));
        System.out.println(number.contains(new Integer(1)));
    }

    @Test
    public void testLocalTime() {
        String str = "2021-08-14T21:11:22";
        LocalDateTime localDateTime= LocalDateTime.parse(str,DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
        System.out.println(localDateTime);

        LocalDateTime dt = LocalDateTime.parse("2015-10-23T03:34:40");
        System.out.println(dt);

    }

    @Test
    public void testInteger() {
        int integer1= 11;
        Integer integer2= new Integer(11);
        System.out.println(integer1 == integer2);
    }

    @Test
    public void testArray() {
        int[] array = null;
        System.out.println(array);
        int[] array2 = {1,2,3};
        System.out.println(array2);
    }

    @Test
    public void testFor() {
        for (int i = 1;i<1;i++) {
            System.out.println(i);
        }
        int[] digits = new int[10];
        System.out.println(Arrays.toString(digits));
    }




}
