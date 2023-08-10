package com.niuke.huawei;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * TODO
 *
 * @author wei.he
 * @date 2022/6/17 11:05
 */
public class hj1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = 0;
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String item = in.next();
            length = item.length();
        }
        System.out.println(length);

        Queue<Integer> queue = new LinkedList<>();
    }
}
