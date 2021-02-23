package com.leetcode;

/**
 * TODO
 *
 * @date 2020/12/15 10:29
 */
public class D20201215N738MonotoneIncreasingNumber {

    public static int monotoneIncreasingDigits2(int N) {
        while(true) {
            boolean isReturn = false;
            if (N < 10) {
                return N;
            }
            String numberStr = String.valueOf(N);
            char[] numberCharArray = numberStr.toCharArray();
            char numberBeforeChar = numberCharArray[0];
            for (int i = 1;i < numberCharArray.length;i++) {
                char numberCurrentChar = numberCharArray[i];
                int numberBeforeInt = Integer.parseInt(String.valueOf(numberBeforeChar));
                int numberCurrentInt = Integer.parseInt(String.valueOf(numberCurrentChar));
                if (numberBeforeInt > numberCurrentInt) {
                    break;
                }
                numberBeforeChar = numberCurrentChar;
                if (i == numberCharArray.length-1 ) {
                    return N;
                }
            }
            N--;
        }
    }

    public static int monotoneIncreasingDigits(int N) {
        while(true) {
            boolean isReturn = false;
            if (N < 10) {
                return N;
            }
            String numberStr = String.valueOf(N);
            char[] numberCharArray = numberStr.toCharArray();
            char numberBeforeChar = numberCharArray[0];
            for (int i = 1;i < numberCharArray.length;i++) {
                char numberCurrentChar = numberCharArray[i];
                int numberBeforeInt = Integer.parseInt(String.valueOf(numberBeforeChar));
                int numberCurrentInt = Integer.parseInt(String.valueOf(numberCurrentChar));
                if (numberBeforeInt > numberCurrentInt) {
//                    numberCharArray[i-1] = String.valueOf(numberBeforeInt-1).charAt(0);
                    numberCharArray[i-1] = String.valueOf(numberBeforeInt-1).charAt(0);
                    for (int j = i;j<numberCharArray.length;j++) {
                        numberCharArray[j] = '9';
                    }
                    N = Integer.valueOf(String.valueOf(numberCharArray));
                    break;
                }
                numberBeforeChar = numberCurrentChar;
                if (i == numberCharArray.length-1 ) {
                    return N;
                }
            }
        }
    }

    public static void main(String[] args) {
        long invokeStartTime = System.currentTimeMillis();
        System.out.println(monotoneIncreasingDigits(963856657));
        System.out.println("耗时：" + String.valueOf(System.currentTimeMillis() - invokeStartTime));
        invokeStartTime = System.currentTimeMillis();
        System.out.println(monotoneIncreasingDigits2(963856657));
        System.out.println("耗时：" + String.valueOf(System.currentTimeMillis() - invokeStartTime));

    }
}
